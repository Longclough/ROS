#define routescalculationextensionros_extension_serviceimplementations_CalculationExtensionServiceProvider_BODY

#include "CalculationExtensionServiceProvider.h"

#include "costmap_2d.h"
#include "cost_values.h"
#include "navfn_planner.h"

#include <iostream>

// End of Include declaration (body)

namespace routescalculationextensionros
{
    std::vector<const GEOSGeometry *> CalculationExtensionServiceProvider::triangulate(const GEOSGeometry *polygon) const
    {
        std::vector<const GEOSGeometry *> result;
        const GEOSCoordSequence *coords = GEOSGeom_getCoordSeq(GEOSGetExteriorRing(polygon));
        unsigned int size = 0;
        GEOSCoordSeq_getSize(coords, &size);
        //route point simplification
        if (size < 5)
        {
            result.push_back(polygon);
        }
        else
        {
            //Tolerance is in degrees relative to the earths surface where 3 decimal places converts to 1 meter (0.001 = 1 meter)
            const GEOSGeometry *simplePolygon = GEOSSimplify(polygon, 0.000001);

            const GEOSGeometry *exteriorRing = GEOSGetExteriorRing(simplePolygon);
            const GEOSGeometry *exteriorPolygon = GEOSGeom_createPolygon(const_cast<GEOSGeometry *>(exteriorRing), nullptr, 0);
            
            const GEOSCoordSequence *coords = GEOSGeom_getCoordSeq(GEOSGetExteriorRing(exteriorPolygon));
            unsigned int Newsize = 0;
            GEOSCoordSeq_getSize(coords, &Newsize);
            std::cout << "Original points " << std::to_string(size) << " points, simplified to " << std::to_string(Newsize) << std::endl << std::endl;

            const GEOSGeometry *triangles = GEOSConstrainedDelaunayTriangulation(exteriorPolygon);
            int numberOfTriangles = GEOSGetNumGeometries(triangles);
            for (int i = 0; i < numberOfTriangles; i++)
            {
                const GEOSGeometry *triangle = GEOSGetGeometryN(triangles, i);
                result.push_back(triangle);
            }
        }
        return result;
    }

    void CalculationExtensionServiceProvider::processConstraints(const std::string& constraints, const std::vector<GEOSGeometry *> &keepIns, std::vector<GEOSGeometry *> &keepOuts) const
    {
        const auto rawJsonLength = static_cast<int>(constraints.length());
        JSONCPP_STRING err;
        Json::Value root;
        if (!reader->parse(constraints.c_str(), constraints.c_str() + rawJsonLength, &root,
                           &err))
        {
            //std::cout << "Error reading constraints json: " << err << std::endl;
        }

        Json::Value jsonFeatures = root["features"];

        for (Json::Value jsonFeature : jsonFeatures)
        {
            Json::Value jsonGeometry = jsonFeature["geometry"];
            Json::Value jsonCoordinates = jsonGeometry["coordinates"];

            GEOSGeometry *shell = nullptr;
            int numHoles = jsonCoordinates.size() - 1;
            auto holes = (GEOSGeometry **)malloc(sizeof(GEOSGeometry *) * numHoles);
            for (int j = 0; j < jsonCoordinates.size(); j++)
            {
                Json::Value jsonRing = jsonCoordinates[j];
                GEOSCoordSequence *coordinates = GEOSCoordSeq_create(jsonRing.size(), 3);
                for (int k = 0; k < jsonRing.size(); k++)
                {
                    Json::Value jsonCoordinate = jsonRing[k];
                    GEOSCoordSeq_setXYZ(coordinates, k, jsonCoordinate[0].asDouble(), jsonCoordinate[1].asDouble(), 0);
                }
                //LinearRing is the GeosGeom version of points (a linear ring is an array of points)
                GEOSGeometry *lr = GEOSGeom_createLinearRing(coordinates);
                //Shell is the container the costmap sits in
                if (shell == nullptr)
                {
                    shell = lr;
                }
                else
                {
                    //Holes are empty areas within the shell
                    holes[j - 1] = lr;
                }
            }

            //buffer_width is the expansion of the polygons
            const double buffer_width = 0.00001;
            //buffer_quadseg are the amount of segments relative to the number of right angles in the circle (No. of right angles * buffer_quadsegs)
            const int buffer_quadsegs = 3;

            const GEOSGeometry *geosPolygon = GEOSGeom_createPolygon(shell, holes, numHoles);
            GEOSGeometry *bufferedPolygon = GEOSBuffer(geosPolygon, buffer_width, buffer_quadsegs);
            //Ignores the buffer on the polygon
            //keepOuts.push_back(const_cast<GEOSGeometry *>(geosPolygon));
            keepOuts.push_back(bufferedPolygon);

            //const GEOSCoordSequence *coords = GEOSGeom_getCoordSeq(GEOSGetExteriorRing(exteriorPolygon));
            //unsigned int Newsize = 0;
            //GEOSCoordSeq_getSize(coords, &Newsize);
            //std::cout << std::to_string(size) << " points, simplified to " << std::to_string(Newsize) << std::endl;
        }
        //std::cout << "Processed constraints" << std::endl;
    }

    std::vector<geometry::Cartesian> CalculationExtensionServiceProvider::getCartesianExteriorCoords(const GEOSGeometry *polygon, const geometry::Point &origin) const
    {
        std::vector<geometry::Cartesian> coords;
        const GEOSGeometry *linearRing = GEOSGetExteriorRing(polygon);
        unsigned int numPoints;
        numPoints = GEOSGeomGetNumPoints(linearRing);
        for (unsigned int p = 0; p < numPoints; p++)
        {
            double xCoord;
            double yCoord;
            const GEOSCoordSequence *coordSeq = GEOSGeom_getCoordSeq(linearRing);
            GEOSCoordSeq_getX(coordSeq, p, &xCoord);
            GEOSCoordSeq_getY(coordSeq, p, &yCoord);
            geometry::Point point = {xCoord, yCoord, 0};
            coords.push_back(geometry::Coordinates::geodeticToCartesian(geometry::Ellipsoid::WGS84, point, origin));
        }
        return coords;
    }

    std::vector<Point> CalculationExtensionServiceProvider::calculateLeg(const Point &from, const Point &to, const std::function<std::string(std::string, double)> &constraintsCallback)
    {
        geometry::Point legStartLocation = {from.lon, from.lat, from.alt};
        geometry::Point legEndLocation = {to.lon, to.lat, to.alt};
        //std::cout << "Route has " << legStartLocation << " many start points" << std::endl;

        //Amount the costmap is increased relative to the planned route
        const double margin = 100; // metres

        double minX = std::min(legEndLocation.x, legStartLocation.x);
        double maxX = std::max(legEndLocation.x, legStartLocation.x);
        double minY = std::min(legEndLocation.y, legStartLocation.y);
        double maxY = std::max(legEndLocation.y, legStartLocation.y);

        //Angles where the costmap is increased by the margin
        geometry::Point bl = geometry::Coordinates::positionAtRangeBearingWGS84Msl({minX, minY, 0}, margin, 5 * M_PI / 4);
        geometry::Point tl = geometry::Coordinates::positionAtRangeBearingWGS84Msl({minX, maxY, 0}, margin, 7 * M_PI / 4);
        geometry::Point tr = geometry::Coordinates::positionAtRangeBearingWGS84Msl({maxX, maxY, 0}, margin, 1 * M_PI / 4);
        geometry::Point br = geometry::Coordinates::positionAtRangeBearingWGS84Msl({maxX, minY, 0}, margin, 3 * M_PI / 4);

        GEOSCoordSequence *coordinates = GEOSCoordSeq_create(5, 3);
        GEOSCoordSeq_setXYZ(coordinates, 0, bl.x, bl.y, 0);
        GEOSCoordSeq_setXYZ(coordinates, 1, tl.x, tl.y, 0);
        GEOSCoordSeq_setXYZ(coordinates, 2, tr.x, tr.y, 0);
        GEOSCoordSeq_setXYZ(coordinates, 3, br.x, br.y, 0);
        GEOSCoordSeq_setXYZ(coordinates, 4, bl.x, bl.y, 0);
        GEOSGeometry *shell = GEOSGeom_createLinearRing(coordinates);
        const GEOSGeometry *bounds = GEOSGeom_createPolygon(shell, nullptr, 0);

        geometry::Point origin = bl;
        geometry::Point extent = tr;

        geometry::Cartesian legStartCart = geometry::Coordinates::geodeticToCartesian(geometry::Ellipsoid::WGS84, legStartLocation, origin);
        geometry::Cartesian legEndCart = geometry::Coordinates::geodeticToCartesian(geometry::Ellipsoid::WGS84, legEndLocation, origin);
        geometry::Cartesian extentCart = geometry::Coordinates::geodeticToCartesian(geometry::Ellipsoid::WGS84, extent, origin);

        const int maxCells = 2000;

        double resolution = 0;

        int xCells;
        int yCells;

        do
        {
            resolution = resolution + 0.01;
            //resolution = resolution + 0.000001;
            //resolution = resolution + 1;
            xCells = int(std::ceil(extentCart.e / resolution));
            yCells = int(std::ceil(extentCart.n / resolution));
        } while (xCells > maxCells || yCells > maxCells);

        //std::cout << "costmap has resolution " << std::to_string(resolution) << " xCells= " << std::to_string(xCells) << " yCells= " << std::to_string(yCells) << " extentCart.e= " << std::to_string(extentCart.e) << " extentCart.n= " << std::to_string(extentCart.n) << std::endl;
        std::vector<GEOSGeometry *> keepIns;
        std::vector<GEOSGeometry *> keepOuts;

        const char *wkt = GEOSWKTWriter_write(wktWriter, bounds);
        double minAltitude = std::min(legStartLocation.z, legEndLocation.z);
        std::string constraints = constraintsCallback(std::string(wkt), minAltitude);
        processConstraints(constraints, keepIns, keepOuts);

        //creates the costmap
        auto costMap = std::make_shared<nav2_costmap_2d::Costmap2D>(xCells, yCells, resolution,
                                                                    0, 0, keepIns.empty() ? 0 : nav2_costmap_2d::LETHAL_OBSTACLE);

        for (auto keepIn : keepIns)
        {
            costMap->setConvexPolygonCost(getCartesianExteriorCoords(keepIn, origin), 0);
        }

        for (auto keepOut : keepOuts)
        {
            for (auto simple : triangulate(keepOut))
            {
                costMap->setConvexPolygonCost(getCartesianExteriorCoords(simple, origin), nav2_costmap_2d::LETHAL_OBSTACLE);
            }
        }

        //std::cout << "Filled cost map" << std::endl;
        
        //if(debug) 
        costMap->saveMap("/tmp/test.pgm");

        geometry_msgs::msg::PoseStamped start;
        start.pose.position = {legStartCart.e, legStartCart.n, legStartCart.d};
        geometry_msgs::msg::PoseStamped goal;
        goal.pose.position = {legEndCart.e, legEndCart.n, legEndCart.d};

        nav2_navfn_planner::NavfnPlanner planner;
        planner.activate();
        planner.configure(costMap);
        nav_msgs::msg::Path path = planner.createPlan(start, goal);

        std::vector<geometry::Cartesian> planPoints;

        for (geometry_msgs::msg::PoseStamped pose : path.poses)
        {
            planPoints.emplace_back(pose.pose.position.y, pose.pose.position.x, pose.pose.position.z);
        }

        if (path.poses.empty())
        {
            std::vector<Point> empty;
            return empty;
        }

        std::vector<geometry::Cartesian> simplePlanPoints;
        //Simplification of route points where epsilon is relative to the magnitude of the resolution
        geometry::Coordinates::ramerDouglasPeucker(planPoints, 0.02, simplePlanPoints);

        std::cout << "Leg has " << std::to_string(planPoints.size()) << " points, simplified to " << std::to_string(simplePlanPoints.size()) << std::endl;

        std::vector<Point> result;
        for (const geometry::Cartesian& planPoint : planPoints)
        {
            geometry::Point point = geometry::Coordinates::cartesianToGeodetic(geometry::Ellipsoid::WGS84, planPoint, origin);
            result.emplace_back(point.y, point.x, to.alt);
            
        }
        //if (!result.empty())
        //{
        //    result.emplace_back(to.lat, to.lon, to.alt);
        //   // std::cout << "value 2";
        //}
        std::cout << "Leg has " << std::to_string(result.size()) << std::endl;

        std::vector<geometry::Cartesian> translatedPoints;
        //translatedPoints.push_back(geometry::Cartesian(start.pose.position.x, start.pose.position.y, start.pose.position.z));
        translatedPoints.push_back(geometry::Cartesian(goal.pose.position.x, goal.pose.position.y, goal.pose.position.z));

        geometry::Point ConvertedPoint = geometry::Coordinates::cartesianToGeodetic(geometry::Ellipsoid::WGS84, translatedPoints[0], origin);

        //Staring Coordinates
        //std::cout << "Starting Coordinates (lon/lat) " << "lattitude: " << from.lat << " longitude: " << from.lon << std::endl;
        //std::cout << "Starting Coordinates (cart) " << "y: " << start.pose.position.y << " x: " << start.pose.position.x << std::endl;
        //std::cout << "Coordinates translated from cart to lonlat " << "lattitude: " << ConvertedPoint.y << " longitude: " << ConvertedPoint.x << std::endl;

        //Goal Coordinates
        std::cout << "Goal Coordinates (lon/lat) " << "lattitude: " << to.lat << " longitude: " << to.lon << std::endl;
        std::cout << "Goal Coordinates (cart) " << "y: " << goal.pose.position.y << " x: " << goal.pose.position.x << std::endl;
        std::cout << "Coordinates translated from cart to lonlat " << "lattitude: " << ConvertedPoint.y << " longitude: " << ConvertedPoint.x << std::endl;

        return result;
    }

    

    void notice(const char *fmt, ...) { printf("%s", fmt); };
    void error(const char *fmt, ...) { printf("%s", fmt); };

    /**
     *
     */
    CalculationExtensionServiceProvider::CalculationExtensionServiceProvider()
    {
        initGEOS(notice, error);
        wktWriter = GEOSWKTWriter_create();
    }

} // of namespace routescalculationextensionros


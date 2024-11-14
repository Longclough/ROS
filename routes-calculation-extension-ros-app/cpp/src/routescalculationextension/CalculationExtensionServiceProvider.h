#ifndef ROUTESCALCULATIONEXTENSIONROS_CALCULATIONEXTENSIONSERVICEPROVIDER_H
#define ROUTESCALCULATIONEXTENSIONROS_CALCULATIONEXTENSIONSERVICEPROVIDER_H

#include <vector>
#include <string>
#include <functional>

#include <geos_c.h>

#include <geometry/Coordinates.h>

#include <jsoncpp/json/json.h>

namespace routescalculationextensionros
{
    struct Point
    {
    public:
        double lat;
        double lon;
        double alt;

        Point(double lat, double lon, double alt) : lat(lat), lon(lon), alt(alt)
        {
        }
    };

    class CalculationExtensionServiceProvider
    {
    public:
        /**
         *
         * @param start
         * @param end
         * @param constraintsCallback
         */
        std::vector<Point> calculateLeg(const Point &from, const Point &to, const std::function<std::string(std::string, double)> &constraintsCallback);

        /**
         *
         */
        CalculationExtensionServiceProvider();

        /**
         *
         */
        virtual ~CalculationExtensionServiceProvider() = default;

    private:

        GEOSWKTWriter* wktWriter;

        std::vector<const GEOSGeometry *> triangulate(const GEOSGeometry *polygon) const;

        std::vector<geometry::Cartesian> getCartesianExteriorCoords(const GEOSGeometry *polygon, const geometry::Point &origin) const;

        void processConstraints(const std::string& constraints, const std::vector<GEOSGeometry *> &keepIns, std::vector<GEOSGeometry *> &keepOuts) const;

        Json::CharReaderBuilder readerBuilder;
        Json::CharReader* reader = readerBuilder.newCharReader();

        bool debug = false;
    };

}

#endif

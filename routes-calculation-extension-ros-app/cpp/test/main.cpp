#include <routescalculationextension/CalculationExtensionServiceProvider.h>
#include <iostream>
#include <sstream>
#include <fstream>

std::string constraintsCallback(std::string wkt, double height) {
    std::ifstream t("constraints.json");
    std::stringstream buffer;
    buffer << t.rdbuf();
    return buffer.str();
}

int main()
{
    routescalculationextensionros::CalculationExtensionServiceProvider sp;
    routescalculationextensionros::Point start{53.903189, -2.770097, 1};
    routescalculationextensionros::Point end{53.6475, -3.005278, 2};

    std::vector<routescalculationextensionros::Point> points = sp.calculateLeg(start, end, &constraintsCallback);
    if (points.empty())
    {
        std::cout << "no points" << std::endl;
    }
    else
    {
        bool doneOne = false;
        for (routescalculationextensionros::Point point : points)
        {
            if (doneOne)
            {
                std::cout << "," << std::endl;
            }
            std::cout << "[" + std::to_string(point.lon) + "," + std::to_string(point.lat) + "]";
            doneOne = true;
        }
        std::cout << std::endl;
    }
    return 0;
}
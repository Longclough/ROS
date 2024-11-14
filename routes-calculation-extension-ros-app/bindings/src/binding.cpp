#include <pybind11/pybind11.h>
#include <pybind11/stl.h>
#include <pybind11/functional.h>
#include <routescalculationextension/CalculationExtensionServiceProvider.h>

#define STRINGIFY(x) #x
#define MACRO_STRINGIFY(x) STRINGIFY(x)

routescalculationextensionros::CalculationExtensionServiceProvider calculationExtensionServiceProvider;

std::vector<routescalculationextensionros::Point> calculateLeg(const routescalculationextensionros::Point &start, const routescalculationextensionros::Point &end, const std::function<std::string(std::string, double)> &constraintsCallback)
{
    return calculationExtensionServiceProvider.calculateLeg(start, end, constraintsCallback);
}

namespace py = pybind11;

PYBIND11_MODULE(routescalculationextensionros, m)
{
    m.doc() = "pybind11 example plugin"; // optional module docstring

    m.def("calculateLeg", &calculateLeg, "A function that calculates a leg");

    py::class_<routescalculationextensionros::Point>(m, "Point")
        .def(py::init<double, double, double>())
        .def_readwrite("lat", &routescalculationextensionros::Point::lat)
        .def_readwrite("lon", &routescalculationextensionros::Point::lon)
        .def_readwrite("alt", &routescalculationextensionros::Point::alt);

#ifdef VERSION_INFO
    m.attr("__version__") = MACRO_STRINGIFY(VERSION_INFO);
#else
    m.attr("__version__") = "dev";
#endif
}
cmake_minimum_required(VERSION 3.4...3.18)
project(routescalculationextensionros)

add_subdirectory(pybind11)
pybind11_add_module(routescalculationextensionros src/binding.cpp)

include_directories(../cpp/src)

target_link_libraries(routescalculationextensionros PRIVATE ${CPP_LIBRARY_NAME} jsoncpp geos_c)

# EXAMPLE_VERSION_INFO is defined by setup.py and passed into the C++ code as a
# define (VERSION_INFO) here.
target_compile_definitions(routescalculationextensionros
                           PRIVATE VERSION_INFO=${EXAMPLE_VERSION_INFO})

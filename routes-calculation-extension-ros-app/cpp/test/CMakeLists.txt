#define a variable to store the name of the binary we want to create, with the naming convention <project name>
set(BINARY testall)

#this includes all files in the folder which have the defined extensions
file(GLOB_RECURSE SOURCES LIST_DIRECTORIES true *.hpp *.cpp)
set(SOURCES ${SOURCES})

#include_directories("${CMAKE_SOURCE_DIR}/lib/gtest/include")

#allows the tests to find the header files of the source directory
include_directories(test)

#define an executable which is used to run the source code - currently commented out as it is only applicable for projects with a "main" in the source (e.g. builds)
    add_executable(${BINARY} ${SOURCES})

    target_link_libraries(${BINARY} PUBLIC ${CPP_LIBRARY_NAME} jsoncpp geos_c)
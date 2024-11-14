cmake_minimum_required(VERSION 3.22.1)

project(routes-calculation-extension-ros)

#set the output paths for different targets
set(CMAKE_ARCHIVE_OUTPUT_DIRECTORY ${CMAKE_BINARY_DIR}/../lib)
set(CMAKE_LIBRARY_OUTPUT_DIRECTORY ${CMAKE_BINARY_DIR}/../lib)
set(CMAKE_RUNTIME_OUTPUT_DIRECTORY ${CMAKE_BINARY_DIR}/../bin)
set(CPP_LIBRARY_NAME routes-calculation-extension-ros-cpp)

#adds the following folders to the project
add_subdirectory(cpp)
add_subdirectory(bindings)

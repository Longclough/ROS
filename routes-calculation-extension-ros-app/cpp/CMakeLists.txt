#this defines the standard of C++ to use, using 11 as this is defined in the draft coding standard...
set(CMAKE_CXX_STANDARD 11)

include_directories(src)
include_directories(test)

add_subdirectory(src)
add_subdirectory(test)
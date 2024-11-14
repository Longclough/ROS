#this includes all files in the folder which have the defined extensions
file(GLOB_RECURSE SOURCES LIST_DIRECTORIES true *.hpp *.h *.cpp)
set(SOURCES ${SOURCES})

#define the source files to be built as a library
add_library(${CPP_LIBRARY_NAME} SHARED ${SOURCES})

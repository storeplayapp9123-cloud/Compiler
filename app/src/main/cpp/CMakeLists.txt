
cmake_minimum_required(VERSION 3.22.1)

project(aalam_core LANGUAGES CXX)

add_library(
    aalam_core
    SHARED
    native-lib.cpp
)

target_compile_features(aalam_core PRIVATE cxx_std_20)

find_library(android_log log)

target_link_libraries(
    aalam_core
    ${android_log}
)

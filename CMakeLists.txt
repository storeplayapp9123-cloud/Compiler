
cmake_minimum_required(VERSION 3.22.1)

project(AalamCompiler LANGUAGES C CXX)

set(CMAKE_C_STANDARD 11)
set(CMAKE_CXX_STANDARD 20)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

set(CMAKE_CXX_EXTENSIONS OFF)

add_library(
    aalam_core
    SHARED
    src/main/cpp/native-lib.cpp
    src/main/cpp/compiler/CompilerCore.cpp
)

target_include_directories(
    aalam_core
    PRIVATE
    src/main/cpp
)

target_compile_options(
    aalam_core
    PRIVATE
    -Wall
    -Wextra
    -Wpedantic
)

find_library(
    android_log
    log
)

target_link_libraries(
    aalam_core
    ${android_log}
)

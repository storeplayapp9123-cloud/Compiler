
plugins {
    id("com.android.application")
}

android {
    namespace = "com.aalam.compiler"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.aalam.compiler"
        minSdk = 23
        targetSdk = 28
        versionCode = 1
        versionName = "0.1.0"

        externalNativeBuild {
            cmake {
                cppFlags += "-std=c++20"
            }
        }
    }

    externalNativeBuild {
        cmake {
            path = file("src/main/cpp/CMakeLists.txt")
            version = "3.22.1"
        }
    }

    buildTypes {
        debug {
            isMinifyEnabled = false
        }

        release {
            isMinifyEnabled = false
        }
    }
}

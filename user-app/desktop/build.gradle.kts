plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose.multiplatform)
}

layout.buildDirectory.set(file("$rootDir/.build/user-app/desktop"))
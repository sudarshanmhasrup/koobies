plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.compose.compiler)
}

layout.buildDirectory.set(file("$rootDir/.build/user-app/desktop"))
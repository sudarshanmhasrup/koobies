plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose.multiplatform)
}

group = libs.versions.userApp.desktop.group.get()
version = libs.versions.userApp.desktop.version.get()

kotlin {
    jvm()
}

// Custom build directory
layout.buildDirectory.set(file("$rootDir/.build/user-app/Desktop"))
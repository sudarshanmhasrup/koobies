plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.compose.compiler)
}

group = libs.versions.userApp.desktop.group.get()
version = libs.versions.userApp.desktop.version.get()

kotlin {
    jvm()
}

compose.desktop {
    application {
        mainClass = libs.versions.userApp.desktop.mainClass.get()
    }
}

// Custom build directory
layout.buildDirectory.set(file("$rootDir/.build/user-app/Desktop"))
plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.kotlin.multiplatform.library)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.compose.compiler)
}

group = libs.versions.designSystem.compose.group.get()
version = libs.versions.designSystem.compose.version.get()

kotlin {
    jvm()
}

// Custom build directory
layout.buildDirectory.set(file("$rootDir/.build/design-system/Compose"))
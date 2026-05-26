plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.compose.compiler) apply false
}

layout.buildDirectory.set(file("$rootDir/.build/project"))
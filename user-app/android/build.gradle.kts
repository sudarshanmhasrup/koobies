plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.compose.compiler)
}

layout.buildDirectory.set(file("$rootDir/.build/user-app/android"))
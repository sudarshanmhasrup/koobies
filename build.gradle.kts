plugins {
    alias(libs.plugins.android.application) apply false
}

layout.buildDirectory.set(file("$rootDir/.build/project"))
rootProject.name = "Koobies"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

@Suppress("UnstableApiUsage")
pluginManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
    }
}

// Entry point modules for the User App (Android and Desktop)
setOf(
    "android",
    "desktop",
    "compose" // Umbrella module
).forEach { userAppModule ->
    include(":user-app:$userAppModule")
}

// Shared modules used across all client platforms
include(":shared")
include(":design-system:compose")

// Feature-specific modules
setOf(
    "user-onboarding"
).forEach { module ->
    include(":features:$module")
}
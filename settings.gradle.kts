pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)
    repositories {
        google()
        mavenCentral()
        maven {
            credentials(PasswordCredentials::class)
            name = "EigerRepository"
            url = uri("https://maven.pkg.github.com/eigerco/uniffi-android-pkg")
        }
    }
}

rootProject.name = "ZcashDemoApp"
include(":app", ":lightwallet-client-lib")
 
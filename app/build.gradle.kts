plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.google.ksp)
}

android {
    namespace = "z.cash.demoapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "z.cash.demoapp"
        minSdk = 27
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    sourceSets {
        getByName("main") {
            jniLibs.srcDir("src/main/jniLibs")
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
        viewBinding = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}


dependencies {

    implementation(libs.bundles.std.with.coroutines)

    // SQLite Support libraries
    implementation(libs.sqlite.ktx)
    implementation(libs.sqlite.framework)

    implementation(libs.appcompat.core)
    implementation(libs.activity.core)
    implementation(libs.activity.compose)
    implementation(libs.coord.layout)

    // Dependencies for working with Architecture components
    implementation(libs.androidx.material3)
    implementation(libs.navigation.fragment.ktx)
    implementation(libs.navigation.ui.ktx)

    ksp(libs.dagger.dagger.compiler)
    ksp(libs.dagger.hilt.compiler)

    // Lifecycle components
    implementation(libs.lifecycle.viewmodel)
    implementation(libs.lifecycle.livedata)
    implementation(libs.lifecycle.common)

    // UI
    implementation(libs.android.constraint.layout)
    implementation(libs.android.material)

    // Native java lib needed for jniLibs built by UniFFI
    implementation(libs.jna) {
        artifact {
            type = "aar"
        }
    }

    runtimeOnly(libs.grpc.okhttp)

    implementation(libs.okhttp)
    implementation(libs.kotlin.bip39)

    // UniFFI library compiled for Android
    implementation(libs.zcash)

    // lightwallet structures
    implementation(project(":lightwallet-client-lib"))

    // Testing
    testImplementation(libs.junit.core)

    androidTestImplementation(libs.androidx.testing)
    androidTestImplementation(libs.espresso.core) {
        exclude(group = "com.android.support", module = "support-annotations")
    }
    androidTestImplementation(libs.androidx.junit)

    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.graphics)
    debugImplementation(libs.androidx.compose.ui.test)
}
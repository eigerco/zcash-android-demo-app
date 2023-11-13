import com.google.protobuf.gradle.id
import com.google.protobuf.gradle.proto

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.google.protobuf)
}

android {
    namespace = "cash.z.wallet.sdk.rpc"
    compileSdk = 34

    defaultConfig {
        consumerProguardFiles("proguard-consumer.txt")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        buildConfig = true
    }

    buildTypes {
        getByName("debug").apply {
            isMinifyEnabled = false
        }
        getByName("release").apply {
            isMinifyEnabled = false
            proguardFiles.addAll(
                listOf(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    File("proguard-project.txt")
                )
            )
        }
    }

    sourceSets.getByName("main") {
        proto { srcDir("src/main/proto") }
    }

    lint {
        baseline = File("lint-baseline.xml")
    }
}

protobuf {
    protoc {
        artifact = libs.protobuf.protoc.get().asCoordinateString()
    }
    plugins {
        create("java") {
            artifact = libs.grpc.gen.java.get().asCoordinateString()
        }
        create("grpc") {
            artifact = libs.grpc.gen.java.get().asCoordinateString()
        }
        create("grpckt") {
            artifact = libs.grpc.gen.kotlin.get().asCoordinateString() + ":jdk8@jar"
        }
    }

    generateProtoTasks {
        all().forEach {
            it.plugins {
                id("java") {
                    option("lite")
                }
                id("grpc") {
                    option("lite")
                }
                id("grpckt") {
                    option("lite")
                }
            }
            it.builtins {
                id("kotlin") {
                    option("lite")
                }
            }
        }
    }
}

dependencies {
    implementation(libs.androidx.annotation)
    implementation(libs.bundles.std.with.coroutines)
    api(libs.bundles.grpc)
}

tasks {
    getByName("preBuild").dependsOn(create("bugfixTask") {
        doFirst {
            mkdir("build/extracted-include-protos/main")
        }
    })
}

fun MinimalExternalModuleDependency.asCoordinateString() =
    "${module.group}:${module.name}:${versionConstraint.displayName}"

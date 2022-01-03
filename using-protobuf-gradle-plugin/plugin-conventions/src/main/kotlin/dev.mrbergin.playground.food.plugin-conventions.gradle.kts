import com.google.protobuf.gradle.*

plugins {
    kotlin("jvm")
    id("com.google.protobuf")
    idea
}

repositories {
    mavenCentral()
}

val protocVersion = "3.19.1"
val kotlinGrpcVersion = "1.2.0"
val grpcVersion = "1.43.1"

dependencies {
    implementation("com.google.protobuf:protobuf-kotlin:$protocVersion")
    implementation("io.grpc:grpc-kotlin-stub:$kotlinGrpcVersion")
    implementation("io.grpc:grpc-protobuf:$grpcVersion")
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:$protocVersion"
    }
    plugins {
        id("grpc") {
            artifact = "io.grpc:protoc-gen-grpc-java:$grpcVersion"
        }
        id("grpckt") {
            artifact = "io.grpc:protoc-gen-grpc-kotlin:$kotlinGrpcVersion:jdk7@jar"
        }
    }
    generateProtoTasks {
        all().forEach {
            it.plugins {
                id("grpc")
                id("grpckt")
            }
            it.builtins {
                id("kotlin")
            }
        }
    }
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(11))
    }
}

kotlin {
    jvmToolchain {
        (this as JavaToolchainSpec).languageVersion.set(JavaLanguageVersion.of(11))
    }
}

tasks.withType<JavaCompile> {
    options.release.set(8)
}

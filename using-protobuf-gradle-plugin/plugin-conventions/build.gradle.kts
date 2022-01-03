plugins {
    `kotlin-dsl`
}

group = "dev.mrbergin.playground.food"
version = "1.0"

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
    implementation("com.google.protobuf:protobuf-gradle-plugin:0.8.18")
}

repositories {
    mavenCentral()
    gradlePluginPortal()
}

kotlin {
    jvmToolchain {
        (this as JavaToolchainSpec).languageVersion.set(JavaLanguageVersion.of(11))
    }
}

tasks.withType<JavaCompile> {
    options.release.set(8)
}

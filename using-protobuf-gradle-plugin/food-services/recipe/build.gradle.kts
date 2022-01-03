plugins {
    id("dev.mrbergin.playground.food.plugin-conventions")
}

group = "dev.mrbergin.playground.food"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("dev.mrbergin.playground.food:common:1.0")
}

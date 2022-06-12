import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.10"

    id("io.gitlab.arturbosch.detekt").version("1.19.0")
}

group = "me.bakchulhyong"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()

    maven("https://maven.pkg.jetbrains.space/public/p/kotlinx-html/maven")
}

dependencies {
    testImplementation(kotlin("test"))
}

detekt {
    allRules = false // activate all available (even unstable) rules.
    config = files("$rootDir/detekt.yml") // point to your custom config defining rules to run, overwriting default behavior
    buildUponDefaultConfig = true // preconfigure defaults
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}

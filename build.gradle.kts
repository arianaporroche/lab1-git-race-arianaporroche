import org.springframework.boot.gradle.tasks.run.BootRun

plugins {
    alias(libs.plugins.kotlin)
    alias(libs.plugins.kotlin.spring)
    alias(libs.plugins.spring.boot)
}

group = "es.unizar.webeng"
version = "2025-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    jvmToolchain(21)
}

dependencies {
    implementation(platform(libs.spring.boot.bom))
    implementation(libs.spring.boot.starter.web)
    implementation(libs.spring.boot.starter.thymeleaf)
    implementation(libs.spring.boot.starter.actuator)
    implementation(libs.spring.boot.starter.validation)
    developmentOnly(libs.spring.boot.devtools)
    implementation(libs.bootstrap)
    implementation(libs.jackson.module.kotlin)
    testImplementation(libs.spring.boot.starter.test)
    testImplementation("org.seleniumhq.selenium:selenium-java:4.17.0")
    testImplementation("io.github.bonigarcia:webdrivermanager:5.5.3")
    // NEW DEPENDENCIES FOR testcontainers
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.testcontainers:testcontainers:1.20.3")
    testImplementation("org.testcontainers:selenium:1.20.3")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<BootRun> {
	sourceResources(sourceSets["main"])
}
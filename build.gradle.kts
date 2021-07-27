import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.3.7.RELEASE"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    id("application")
    kotlin("jvm") version "1.5.20"
    kotlin("plugin.spring") version "1.5.20"
    kotlin("plugin.jpa") version "1.5.20"
}

group = "com.potato"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

repositories {
    mavenCentral()
}

application {
    mainClass.set("com.potato.velog.PotatoVelogApplicationKt")
}

subprojects {
    repositories {
        mavenCentral()
    }

    apply {
        plugin("idea")
        plugin("java-library")
        plugin("kotlin")
        plugin("kotlin-jpa")
        plugin("org.springframework.boot")
        plugin("io.spring.dependency-management")
        plugin("org.jetbrains.kotlin.plugin.spring")
        plugin("org.jetbrains.kotlin.jvm")
        plugin("org.jetbrains.kotlin.kapt")
    }

    dependencies {
        // kotlin
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

        // spring validation
        implementation("org.springframework.boot:spring-boot-starter-validation")

        // test
        testImplementation("org.springframework.boot:spring-boot-starter-test")

        // security
        implementation("org.springframework.boot:spring-boot-starter-security")
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "11"
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}

noArg {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.MappedSuperclass")
    annotation("javax.persistence.Embeddable")
}
allOpen {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.MappedSuperclass")
    annotation("javax.persistence.Embeddable")
}

dependencies {
    // spring data jpa
    api("org.springframework.boot:spring-boot-starter-data-jpa")

    // h2
    implementation("com.h2database:h2")

    // querydsl
    api("com.querydsl:querydsl-jpa")
    kapt("com.querydsl:querydsl-apt::jpa")
}

tasks.jar { enabled = true }
tasks.bootJar { enabled = false }
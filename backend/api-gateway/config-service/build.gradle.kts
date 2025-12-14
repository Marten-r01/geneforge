plugins {
    id("org.springframework.boot")
    id("org.jetbrains.kotlin.plugin.spring")
}

dependencies {
    implementation(libs.spring.boot.starter.web)
    implementation("org.springframework.cloud:spring-cloud-config-server:4.1.0")
    implementation(libs.spring.cloud.starter.bus.amqp)
}

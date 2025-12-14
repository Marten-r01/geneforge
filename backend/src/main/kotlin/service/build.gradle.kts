plugins {
    id("org.springframework.boot")
    id("org.jetbrains.kotlin.plugin.spring")
}

dependencies {
    implementation(platform(org.springframework.boot.gradle.plugin.SpringBootPlatformPlugin.BOM_COORDINATES))
    implementation(platform("org.springframework.cloud:spring-cloud-dependencies:2023.0.0"))
    
    implementation("org.springframework.cloud:spring-cloud-starter-gateway:4.1.0")
    implementation(libs.spring.boot.starter.data.redis.reactive)
    implementation(libs.spring.cloud.starter.netflix.eureka.client)
    implementation("org.springframework.cloud:spring-cloud-starter-circuitbreaker-reactor-resilience4j:3.0.3")
    implementation(libs.jjwt.api)
    implementation(libs.jjwt.impl)
    implementation(libs.jjwt.jackson)
    
    // Rate limiting
    implementation("com.github.vladimir-bukhtoyarov:bucket4j-core:7.6.0")
    
    // Monitoring
    implementation(libs.spring.boot.starter.actuator)
    implementation("io.micrometer:micrometer-registry-prometheus:1.12.2")
}

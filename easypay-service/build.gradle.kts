plugins {
	java
	id("org.springframework.boot") version "3.3.1"
	id("io.spring.dependency-management") version "1.1.5"
}

group = "com.worldline.easypay"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_21
}

repositories {
	mavenCentral()
}

extra["springCloudVersion"] = "2023.0.2"
extra["springDocVersion"] = "2.5.0"

dependencies {
	// Spring Boot Web
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-validation")

	// ORM for database access: JPA & Postgres
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	runtimeOnly("org.postgresql:postgresql")

	// Spring Cloud Config client
	implementation("org.springframework.cloud:spring-cloud-starter-config")

	// Spring Cloud service discovery client
	implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client")

	// Spring Cloud REST Client
	implementation("org.springframework.cloud:spring-cloud-starter-openfeign")

	// Spring Cloud Resilience
	implementation("org.springframework.cloud:spring-cloud-starter-loadbalancer")
	implementation("org.springframework.cloud:spring-cloud-starter-circuitbreaker-resilience4j")
	
	// Spring Cloud Stream (Kafka)
	implementation("org.springframework.cloud:spring-cloud-stream")
	implementation("org.springframework.cloud:spring-cloud-stream-binder-kafka")
	implementation("org.springframework.kafka:spring-kafka")

	// OpenAPI
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:${property("springDocVersion")}")

	// Expose metrics with Micrometer using a Prometheus registry
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("io.micrometer:micrometer-registry-prometheus")

	// Logging JSON support
	implementation("ch.qos.logback.contrib:logback-json-classic:0.1.5")
	implementation("ch.qos.logback.contrib:logback-jackson:0.1.5")

	// Add opentelemetry support
	implementation(platform("io.opentelemetry:opentelemetry-bom:1.38.0"))
	implementation("io.opentelemetry:opentelemetry-api")
	implementation("io.opentelemetry.instrumentation:opentelemetry-instrumentation-annotations:2.5.0")
	implementation("io.prometheus:prometheus-metrics-tracer-otel-agent:1.3.1")

	developmentOnly("org.springframework.boot:spring-boot-devtools")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.testcontainers:postgresql")
}

dependencyManagement {
	imports {
		mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

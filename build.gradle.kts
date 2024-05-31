plugins {
	java
	id("org.springframework.boot") version "3.3.0"
	id("io.spring.dependency-management") version "1.1.5"
	`maven-publish`
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

publishing{
	publications{
		create<MavenPublication>("mavenJava"){
			from(components["java"])
			versionMapping {
				usage("java-api"){
					fromResolutionOf("runtimeClasspath")
				}
				usage("java-runtime"){
					fromResolutionResult()
				}
			}
		}
	}
	repositories{
		mavenLocal()
	}
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
	implementation("org.springframework.boot:spring-boot-starter-aop:3.3.0")
	implementation("org.springframework.boot:spring-boot-configuration-processor:3.3.0")
	compileOnly("jakarta.servlet:jakarta.servlet-api:6.0.0")
	implementation("org.springframework:spring-web:6.1.8")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

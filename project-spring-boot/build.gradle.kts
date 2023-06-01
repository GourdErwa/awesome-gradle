apply(plugin = "org.springframework.boot")

dependencies {
    implementation(project(":project-common"))
    implementation("com.github.xiaoymin:knife4j-openapi3-spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")
    //developmentOnly("org.springframework.boot:spring-boot-devtools")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

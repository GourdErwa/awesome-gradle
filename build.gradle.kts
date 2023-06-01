plugins {
    java
    // spring-boot 启动类型应用按需引入，默认不应用
    alias(libs.plugins.spring.boot) apply false
    //alias(libs.plugins.io.freefair.lombok)
}
allprojects {
    repositories {
        mavenCentral()
        maven { url = uri("https://maven.aliyun.com/repository/public") }
        maven { url = uri("https://maven.aliyun.com/repository/jcenter") }
        maven { url = uri("https://maven.aliyun.com/repository/google") }
        maven { url = uri("https://maven.aliyun.com/repository/central") }
        maven { url = uri("https://maven.aliyun.com/repository/gradle-plugin") }
        mavenLocal()
        gradlePluginPortal()
    }
}
group = "io.groud"
version = "0.0.1-SNAPSHOT"

val bomProjects = setOf(
    project(":project-dependencies")
)
val libraryProjects = subprojects - bomProjects

configure(bomProjects) {
    apply(plugin = "java-platform")
    configure<JavaPlatformExtension> {
        allowDependencies()
    }
}

configure(libraryProjects) {
    apply(plugin = "java-library-conventions")
    dependencies {
        annotationProcessor(platform(project(":project-dependencies")))
        implementation(platform(project(":project-dependencies")))
        testAnnotationProcessor(platform(project(":project-dependencies")))

        compileOnly("org.projectlombok:lombok:1.18.28")
        annotationProcessor("org.projectlombok:lombok:1.18.28")
        implementation("org.slf4j:slf4j-api:2.0.7")
        testCompileOnly("org.projectlombok:lombok:1.18.28")
        testAnnotationProcessor("org.projectlombok:lombok:1.18.28")

        testImplementation("org.junit.jupiter:junit-jupiter-api")
        testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    }
}



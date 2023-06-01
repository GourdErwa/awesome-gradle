plugins {
    `kotlin-dsl`
}

repositories {
    maven { url = uri("https://maven.aliyun.com/repository/public") }
    maven { url = uri("https://maven.aliyun.com/repository/jcenter") }
    maven { url = uri("https://maven.aliyun.com/repository/google") }
    maven { url = uri("https://maven.aliyun.com/repository/central") }
    maven { url = uri("https://maven.aliyun.com/repository/gradle-plugin") }
    mavenCentral()
    mavenLocal()
    gradlePluginPortal()
}

dependencies {
    // https://plugins.gradle.org/plugin/com.github.spotbugs
    //implementation(libs.gradle.spotbugs)
    implementation("com.github.spotbugs.snom:spotbugs-gradle-plugin:5.0.14")

    // https://github.com/diffplug/spotless/tree/main/plugin-gradle#requirements
    // 如果您坚持使用 JRE 8，请使用 id 'com.diffplug.spotless' 版本 '6.13.0' 或更早版本。
    //implementation(libs.gradle.spotless)
    implementation("com.diffplug.spotless:spotless-plugin-gradle:6.19.0")
    implementation("org.jetbrains.dokka:dokka-gradle-plugin:1.8.10")
}

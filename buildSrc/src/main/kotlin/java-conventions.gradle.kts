plugins {
    idea
    java
    id("spotless-conventions")
    id("checkstyle-conventions")
    id("spotbugs-conventions")
    id("jacoco-conventions")
    // id("dokka-conventions")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
    withSourcesJar()
}

tasks.compileJava {
    options.encoding = "UTF-8"
    options.isIncremental = true
    options.isFork = true
    options.isFailOnError = false
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}

rootProject.name = "awesome-gradle"

dependencyResolutionManagement {
    versionCatalogs.create("libs") {
        from(files("libs.versions.toml"))
    }
}

include(
    ":project-dependencies",
    ":project-common",
    ":project-spring-boot"
)

dependencies {
    api(platform(libs.spring.boot.bom))
    api(platform(libs.junit.bom))
    // https://doc.xiaominfo.com/
    api(platform(libs.knife4j.bom))

    constraints {

        //(rootProject.ext.get("mavenDependenciesProjects") as Iterable<Project>).forEach { api(project(it.path)) }

        api(libs.jsr305)
        api(libs.calcite.core)
        api(libs.lombok)
    }
}

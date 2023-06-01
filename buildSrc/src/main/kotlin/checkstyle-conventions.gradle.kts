plugins {
    // https://checkstyle.org/
    // https://docs.gradle.org/current/userguide/checkstyle_plugin.html
    checkstyle
}
// TODO libs 无法直接访问
//val libs = extensions.getByType(org.gradle.accessors.dm.LibrariesForLibs::class)
//val libs = the<LibrariesForLibs>()
checkstyle {
    toolVersion = "10.12.0"
    //val versionCatalog = extensions.getByType<VersionCatalogsExtension>().named("versions")
    //println(versionCatalog)
    // toolVersion = libs.versions.checkstyle.get()
//    libs.versions.checkstyle.get()
//        .takeIf { it.isPresent }
//        ?.let { toolVersion = it.get() }
    // maxWarnings = 200
}

val checkstyleTasks = tasks.withType<Checkstyle>()
checkstyleTasks.configureEach {
    //classpath = files()
    configFile = file("${rootDir}/config/checkstyle/checkstyle.xml")
    minHeapSize.set("200m")
    maxHeapSize.set("1g")
    reports {
        xml.required.set(false)
        html.required.set(true)
        html.outputLocation.set(file("${rootProject.buildDir}/reports/checkstyle/${project.name}.checkstyle.html"))
        //html.stylesheet = resources.text.fromFile("${rootDir}/config/checkstyle/xsl/checkstyle-csv.xsl")
    }
    ignoreFailures = true
    isShowViolations = true
}

tasks.named<Checkstyle>("checkstyleMain") {
    // exclude("**/guava/**")
}
tasks.named<Checkstyle>("checkstyleTest") {
    // exclude("**/jdbc/shared/**")
}

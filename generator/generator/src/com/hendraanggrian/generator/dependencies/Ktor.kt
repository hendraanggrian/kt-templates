package com.hendraanggrian.generator.dependencies

import com.hendraanggrian.kotlinpoet.FileSpecBuilder

object Ktor : Dependency("ktor") {

    override fun FileSpecBuilder.initialize() {
        properties {
            mavenCentralVal("VERSION_KTOR", "io.ktor", "ktor")
        }
        functions {
            dependencyFun("ktor", "module" to false) {
                append("return %S", "io.ktor:ktor-\$module:\$VERSION_KTOR")
            }
        }
    }
}
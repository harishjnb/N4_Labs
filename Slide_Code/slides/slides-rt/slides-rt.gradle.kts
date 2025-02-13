/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

import com.tridium.gradle.plugins.bajadoc.task.Bajadoc
import com.tridium.gradle.plugins.module.util.ModulePart.RuntimeProfile.*

plugins {
  // The Niagara Module plugin configures the "moduleManifest" extension and the
  // "jar" and "moduleTestJar" tasks.
  id("com.tridium.niagara-module")

  // The signing plugin configures the correct signing of modules. It requires
  // that the plugin also be applied to the root project.
  id("com.tridium.niagara-signing")

  // The bajadoc plugin configures the generation of Bajadoc for a module.
  id("com.tridium.bajadoc")

  // Configures JaCoCo for the "niagaraTest" task of this module.
  id("com.tridium.niagara-jacoco")

  // The Annotation processors plugin adds default dependencies on ":nre"
  // for the "annotationProcessor" and "moduleTestAnnotationProcessor"
  // configurations by creating a single "niagaraAnnotationProcessor"
  // configuration they extend from. This value can be overridden by explicitly
  // declaring a dependency for the "niagaraAnnotationProcessor" configuration.
  id("com.tridium.niagara-annotation-processors")

  // The niagara_home repositories convention plugin configures !bin/ext and
  // !modules as flat-file Maven repositories so that projects in this build can
  // depend on already-installed Niagara modules.
  id("com.tridium.convention.niagara-home-repositories")
}

description = "The code examples used in the N4 Developer Training slides"

moduleManifest {
  moduleName.set("slides")
  runtimeProfile.set(rt)
}

// See documentation at module://docDeveloper/doc/build.html#dependencies for the supported
// dependency types
dependencies {
  // NRE dependencies
  nre(":nre")

  // Niagara module dependencies
  api(":alarm-rt")
  api(":baja")
  api(":control-rt")
  api(":driver-rt")
  api(":history-rt")
  api(":nDriver-rt")

  // Test Niagara module dependencies
  moduleTestImplementation(":bql-rt")
  moduleTestImplementation(":tagDictionary-rt")
  moduleTestImplementation(":test-wb")
}

tasks.named<Bajadoc>("bajadoc") {
  // This is necessary if any files use characters not in Gradle's default encoding
  options.encoding="utf-8"

  // Each of the packages you wish to include in your module's API documentation must be
  // enumerated below
  includePackage("com.tridiumuniversity.slides.drivers")
  includePackage("com.tridiumuniversity.slides.moduleDevelopment")
  includePackage("com.tridiumuniversity.slides.niagaraFundamentals")
  includePackage("com.tridiumuniversity.slides.ordQueries")
  includePackage("com.tridiumuniversity.slides.servicesAndMultithreaded")
  includePackage("com.tridiumuniversity.slides.webDevelopment")
  includePackage("com.tridiumuniversity.slides.workbenchDevelopment")
}

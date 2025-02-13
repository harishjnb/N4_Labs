/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

/* See deployingHelp documentation at module://docDeveloper/doc/deployingHelp.html for details
   about the format for this file
 */

import com.tridium.gradle.plugins.module.util.ModulePart.RuntimeProfile.*

plugins {
  // The Niagara Module plugin configures the "moduleManifest" extension and the
  // "jar" and "moduleTestJar" tasks.
  id("com.tridium.niagara-module")

  // The signing plugin configures the correct signing of modules. It requires
  // that the plugin also be applied to the root project.
  id("com.tridium.niagara-signing")

  // The niagara_home repositories convention plugin configures !bin/ext and
  // !modules as flat-file Maven repositories so that projects in this build can
  // depend on already-installed Niagara modules.
  id("com.tridium.convention.niagara-home-repositories")

  id("com.tridium.niagara-doc")
  id("com.tridium.bajadoc-module")
}

description = "The code examples used in the N4 Developer Training slides"

moduleManifest {
  moduleName.set("slides")
  runtimeProfile.set(doc)
}

dependencies {
  indexJars(":nre")
  indexJars(":baja")
  indexJars(":html-wb")
  indexJars(":help-wb")

  bajadocs(project(":slides-rt"))
  bajadocs(project(":slides-wb"))
}

tasks.named<Copy>("docCopy") {
  from("src") {
    include("doc/**/*.*")
  }
}

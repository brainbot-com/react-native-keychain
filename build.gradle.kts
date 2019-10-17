// Copyright (c) Facebook, Inc. and its affiliates.

// This source code is licensed under the MIT license found in the
// LICENSE file in the root directory of this source tree.

buildscript {
  repositories {
    mavenLocal()
    google()
    jcenter()
  }
  dependencies {
    classpath("com.android.tools.build:gradle:3.5.1")
  }
}

allprojects {
  repositories {
    mavenLocal()
    google()
    jcenter()
    // All of React Native (JS, Obj-C sources, Android binaries) is installed from npm
    maven {
      url = uri("$rootDir/KeychainExample/node_modules/react-native/android")
    }
  }
}

allprojects {
  configurations.all {
    resolutionStrategy.eachDependency {
      when (requested.group) {
        "com.android.support" -> useVersion("28.0.0")
        "android.arch.lifecycle" -> useVersion("1.1.1")
        "android.arch.core" -> useVersion("1.1.1")
        "com.facebook.fresco" -> useVersion("1.13.+")
      }

      when ("${requested.group}:${requested.name}") {
        "com.facebook.react:react-native" -> useVersion("0.57.1")
        "com.facebook.soloader:soloader" -> useVersion("0.6.+")
      }
    }
  }
}

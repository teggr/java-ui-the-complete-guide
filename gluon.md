---
name: Gluon
status: Production-ready, Commercial & Open Source
javaVersion: 17+ (21+ recommended)
learningCurve: Moderate
lastRelease: Scene Builder 25.0.0 (September 2025)
learnMoreText: Gluon Official Website
learnMoreHref: https://gluonhq.com/
image: images/ui-gluonhq.png
tags:
    - Desktop UI
    - Mobile
    - Build Tools
dateAdded: 2026-02-25
---

Gluon is a Java-focused company and platform that co-leads the OpenJFX project and provides a suite of commercial and open-source tools for building cross-platform JavaFX applications. Their flagship open-source product, Scene Builder, is a drag-and-drop visual designer for FXML-based JavaFX UIs, enabling rapid interface design with clear separation between design and application logic. GluonFX extends JavaFX with additional components including a Rich Text Area, interactive Maps, and Emoji support. For mobile development, Gluon Mobile leverages GraalVM native image to compile JavaFX apps for iOS and Android from a single codebase. Gluon also provides JavaFX Long Term Support (LTS) contracts, commercial support for enterprises running JavaFX 11+, IDE plugins for IntelliJ IDEA, Eclipse, and NetBeans, and the GluonFX Maven/Gradle plugins that streamline the build and deployment pipeline. Gluon's deep involvement in the JavaFX ecosystem—from tooling to core contributions—makes it the go-to commercial partner for JavaFX-based enterprise, desktop, and mobile development.

## Code Example

```xml
<!-- pom.xml – GluonFX Maven plugin for cross-platform JavaFX deployment -->
<plugin>
    <groupId>com.gluonhq</groupId>
    <artifactId>gluonfx-maven-plugin</artifactId>
    <version>1.0.28</version>
    <configuration>
        <!-- 'host' builds for the current OS; use 'ios' or 'android' for mobile -->
        <mainClass>com.example.HelloGluon</mainClass>
        <target>host</target>
    </configuration>
</plugin>

<!--
    Run on desktop:   mvn gluonfx:run
    Compile native:   mvn gluonfx:build
    Package:          mvn gluonfx:package
    Run on device:    mvn gluonfx:run -Dtarget=android
-->
```

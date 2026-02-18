---
name: jpackage
status: Production-ready, Stable
javaVersion: 14+ (16+ recommended)
learningCurve: Moderate
lastRelease: Part of JDK (Updated with each release)
learnMoreText: JEP 343 - jpackage
learnMoreHref: https://openjdk.java.net/jeps/343
image: images/ui-jpackage.png
tags:
    - Build Tools
    - Desktop UI
dateAdded: 2026-02-18
---

The jpackage tool is a standard JDK utility (since JDK 14) for packaging self-contained Java applications into platform-specific native installers. It creates packages that end users can install in a familiar, platform-native way—MSI and EXE on Windows, PKG and DMG on macOS, and DEB and RPM on Linux. Unlike its predecessor javapackager (removed from JDK 11), jpackage focuses solely on packaging without JavaFX dependencies or Java Web Start support. The tool bundles your application with a custom JDK runtime image (created with jlink), allowing distribution of applications that run independently without requiring users to install Java separately. You can specify launch-time parameters, file associations, application metadata (version, vendor, copyright), and multiple launchers at packaging time. The tool works with both modular and non-modular applications, automatically determining required modules for non-modular apps or using dependency analysis for modular ones. For commercial-grade deployments requiring auto-update functionality or simplified multi-platform builds, consider complementary tools like Conveyor, but jpackage provides the free, built-in foundation for creating professional native installers directly from the JDK.

## Code Example

```bash
# Non-modular application (JAR files in lib directory)
jpackage --name myapp \
  --input lib \
  --main-jar main.jar \
  --main-class com.example.Main \
  --type dmg \
  --app-version 1.0 \
  --vendor "My Company" \
  --copyright "Copyright 2026"

# Modular application
jpackage --name myapp \
  --module-path lib \
  --module myapp/com.example.Main \
  --type msi

# Create custom runtime image first, then package
jlink --add-modules java.base,java.sql \
  --output customjre
jpackage --name myapp \
  --input lib \
  --main-jar main.jar \
  --runtime-image customjre

# Two-step process: create app-image, customize, then package
jpackage --name myapp \
  --module-path lib \
  --module myapp \
  --type app-image
# ... customize myapp/ directory ...
jpackage --name myapp \
  --app-image myapp \
  --type dmg
```

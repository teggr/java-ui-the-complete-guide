---
name: jpackage
status: Production-ready, Part of JDK
javaVersion: 14+ (improved in 16+)
learningCurve: Moderate
lastRelease: Bundled with JDK
learnMoreText: jpackage JEP 343
learnMoreHref: https://openjdk.java.net/jeps/343
image: https://robintegg.com/images/ui-jpackage.png
tags:
    - Build Tools
    - Desktop UI
---

jpackage is a packaging tool included in the JDK since Java 14 that creates native installers for Java applications, eliminating the need for users to have Java pre-installed. It generates platform-specific packages: exe/msi for Windows, dmg/pkg for macOS, and deb/rpm for Linux. jpackage can bundle a Java runtime (via jlink) to create self-contained applications, include custom splash screens and icons, and set application metadata like version numbers and descriptions. The tool integrates with platform conventions—Windows installers can include shortcuts and file associations, macOS apps bundle into proper .app structures with Info.plist, and Linux packages follow distribution guidelines. While jpackage handles the basics well, it doesn't provide auto-update mechanisms, code signing automation, or cross-platform builds from a single host (you need Windows to build Windows installers, macOS for DMGs). It's the free, built-in option for Java desktop distribution and works well for internal applications or cases where you manage updates manually. For more complex scenarios, tools like Conveyor or Install4j provide additional features.

## Code Example

```bash
# Build a self-contained JavaFX application installer

# Step 1: Create a custom Java runtime with only needed modules
jlink \
  --module-path $JAVA_HOME/jmods \
  --add-modules java.base,javafx.controls,javafx.fxml \
  --output custom-jre

# Step 2: Package application with custom runtime
jpackage \
  --input target/libs \
  --main-jar myapp.jar \
  --main-class com.example.Main \
  --runtime-image custom-jre \
  --name "My JavaFX App" \
  --app-version 1.0 \
  --icon myapp.png \
  --type dmg

# Output: My JavaFX App-1.0.dmg (on macOS)
# Windows: --type msi or --type exe
# Linux: --type deb or --type rpm

# Users double-click installer, no Java required!
```

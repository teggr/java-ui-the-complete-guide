---
name: Conveyor
status: Production-ready, Commercial
javaVersion: 11+
learningCurve: Easy-Moderate
lastRelease: v14.3 (2026)
learnMoreText: Conveyor Official Website
learnMoreHref: https://conveyor.hydraulic.dev/
image: images/ui-conveyor.png
tags:
    - Build Tools
    - Desktop UI
dateAdded: 2026-02-13
---

Conveyor is a commercial tool (with free tier) from Hydraulic Software that revolutionizes Java desktop application distribution by creating native installers and self-updating packages for Windows, macOS, and Linux from a single configuration file. Unlike traditional tools like jpackage or Install4j, Conveyor handles code signing, notarization (macOS), Windows Store submission, Linux repository management, and automatic updates out of the box. It supports Electron, JVM apps (JavaFX, Swing), and native applications, with deep integration for Kotlin/JVM projects. Conveyor's standout feature is its update mechanism—applications can update themselves in the background without interrupting users, similar to Chrome's update system. The tool handles platform-specific concerns like DMG creation for macOS, MSI/EXE for Windows, and DEB/RPM for Linux, plus generates download pages with platform detection. For commercial JavaFX or Swing applications requiring professional deployment and updates, Conveyor significantly reduces DevOps complexity compared to rolling your own solution with jpackage and other tools.

## Code Example

```hocon
// conveyor.conf - Single config for all platforms
app {
  display-name = "My JavaFX App"
  fsname = "my-javafx-app"
  version = 1.0.0
  
  machines = [windows.amd64, mac.amd64, mac.aarch64, linux.amd64]
  
  jvm {
    modules = [javafx.controls, javafx.fxml]
    gui = com.example.Main
  }
  
  updates = aggressive
  
  // Conveyor handles:
  // - Code signing (Windows, macOS)
  // - Notarization (macOS)
  // - Native installers (MSI, DMG, DEB, RPM)
  // - Auto-updates
  // - Download pages
}

// Build all platforms: conveyor make site
```

---
name: FXGL
status: Production-ready, Active
javaVersion: 8-25
learningCurve: Easy
lastRelease: v25 (2025)
learnMoreText: FXGL Official Website
learnMoreHref: https://almasb.github.io/FXGL/
image: images/ui-fxgl.png
tags:
    - Game Development
    - Desktop UI
    - Mobile
    - Web UI
---

FXGL is a JavaFX Game Development Framework that provides a simple and clean API for building 2D games (and experimental 3D) with no installation or setup required. As a superset of JavaFX, developers can leverage familiar UI APIs while accessing real-world game development techniques including Entity-Component systems, interpolated animations, particles, and physics. FXGL works seamlessly across Java 8-25 and supports Windows, Mac, Linux, Android 8+, iOS 11.0+, and Web platforms. The framework is particularly well-suited for side-scrollers, platformers, arcade games, and RPGs, offering "out of the box" functionality that allows developers to focus on game logic rather than engine internals. Games package easily into single executable .jar files or native images, and the framework is backed by comprehensive documentation including a published book, video tutorials, and extensive sample code. Used by universities worldwide for teaching game development, FXGL combines the power of professional game engines with the accessibility of JavaFX, making it ideal for hobby projects, academic work, commercial games, and rapid prototyping.

## Code Example

```java
import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;

public class BasicGameApp extends GameApplication {

    @Override
    protected void initSettings(GameSettings settings) {
        settings.setWidth(800);
        settings.setHeight(600);
        settings.setTitle("Basic Game App");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
```

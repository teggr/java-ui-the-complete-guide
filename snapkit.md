---
name: SnapKit
status: Production-ready
javaVersion: 8+
learningCurve: Easy-Moderate
lastRelease: v2025.12 (Dec 2025)
learnMoreText: SnapKit GitHub
learnMoreHref: https://github.com/reportmill/SnapKit
image: images/ui-snapkit.png
tags:
    - Desktop UI
dateAdded: 2026-02-09
---

SnapKit is "Swing 2.0"—a UI toolkit developed by ReportMill that aims to run on both desktop and in the browser. Used to power SnapCode (a Java IDE that runs in a browser), SnapKit can deploy to desktop via Swing or JavaFX, and to browsers via CheerpJ JVM. The framework features XML-based UI files with a visual GUI builder (SnapBuilder), a ViewOwner controller pattern, and support for geometric primitives, effects, and even 3D via WebGL/JOGL. While SnapKit presents an interesting approach for dual-platform development, it remains a niche framework with limited adoption compared to mainstream Java UI toolkits.

## Code Example

```java
import snap.view.*;
import snap.viewx.WebPage;
import snap.gfx.Font;

public class HelloSnapKit extends WebPage {
    protected View createUI() {
        Label label = new Label("Hello, SnapKit!");
        label.setFont(Font.Arial14.deriveFont(24));
        
        RowView row = new RowView();
        row.setPadding(50, 50, 50, 50);
        row.addChild(label);
        return row;
    }
    
    public static void main(String[] args) {
        new HelloSnapKit().run(args);
    }
}
```

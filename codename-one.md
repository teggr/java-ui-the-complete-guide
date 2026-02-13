---
name: Codename One
status: Production-ready, Mature (since 2012)
javaVersion: 8+ (also supports Kotlin)
learningCurve: Easy
lastRelease: Active (Feb 2026)
learnMoreText: Codename One Official Website
learnMoreHref: https://www.codenameone.com/
image: images/ui-codename-one.png
tags:
    - Mobile UI
---

Codename One offers true write-once-run-anywhere capabilities for mobile, desktop, and web from a single Java or Kotlin codebase. What makes it unique is the cloud-based build service that eliminates the need for Mac hardware when building iOS applications—it handles Xcode compilation in the cloud. The framework produces truly native apps (not hybrid WebView apps) by statically compiling bytecode to native code: ParparVM for iOS translates bytecode to C, while TeaVM handles web/PWA targets. With 100% code reuse across platforms, drag-and-drop GUI builder, and fast simulator with hot reload, Codename One has powered applications at banks, governments, and telecom companies including BeRider (Prague scooters), HBZ Mobile (banking), and yHomework (1M+ installs). Founded by ex-Sun Microsystems developers from the LWUIT project, it combines open-source core with commercial build services under GPL + Commercial Exception licensing (free for commercial use).

## Code Example

```java
import com.codename1.ui.*;
import com.codename1.ui.layouts.BoxLayout;

public class HelloCodenameOne {
    public void start() {
        Form form = new Form("Codename One", BoxLayout.y());
        form.add(new Label("Hello, Codename One!"));
        form.add(new Button("Click Me", e -> 
            Dialog.show("Info", "Button clicked!", "OK", null)
        ));
        form.show();
    }
}
```

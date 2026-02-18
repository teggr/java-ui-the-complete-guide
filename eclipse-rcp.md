---
name: Eclipse RCP
status: Production-ready, Mature
javaVersion: 8+
learningCurve: Steep
lastRelease: Active
learnMoreText: Eclipse RCP GitHub
learnMoreHref: https://github.com/eclipse-platform/eclipse.platform.ui/blob/master/docs/Rich_Client_Platform.md
image: images/ui-eclipse-rcp.png
tags:
    - Desktop UI
dateAdded: 2026-02-18
---

Eclipse RCP is an OSGi-based Rich Client Platform that powers the Eclipse IDE and countless enterprise applications from companies like IBM and SAP. It uses SWT for native widget rendering, giving applications a true native look and feel on each platform. The platform provides complete application infrastructure including window management, perspectives, views, plugin architectures, and update mechanisms. Eclipse RCP applications can support multiple versions of the same library simultaneously thanks to OSGi's sophisticated class loading. While the learning curve is steep due to OSGi and SWT concepts, the result is highly modular, enterprise-grade desktop applications with massive ecosystem support.

## Code Example

```java
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.*;

public class HelloEclipseRCP {
    public static void main(String[] args) {
        Display display = new Display();
        Shell shell = new Shell(display);
        shell.setText("Eclipse RCP Example");
        shell.setSize(300, 200);
        
        Label label = new Label(shell, SWT.CENTER);
        label.setText("Hello, Eclipse RCP!");
        label.setBounds(50, 80, 200, 30);
        
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
        display.dispose();
    }
}
```

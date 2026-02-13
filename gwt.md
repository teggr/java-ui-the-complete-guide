---
name: GWT
status: Production-ready, Active
javaVersion: 8+ (11+ supported)
learningCurve: Steep
lastRelease: v2.12.1 (2025)
learnMoreText: GWT Project Website
learnMoreHref: http://www.gwtproject.org/
image: images/ui-gwt.png
tags:
    - Web UI
    - Compiler/Transpiler
---

GWT (Google Web Toolkit) is a development toolkit for building high-performance web applications in Java that compiles to optimized JavaScript. Originally developed by Google and now maintained as an open source project, GWT allows developers to write complex browser-based applications using the Java language and tools, then deploy as pure JavaScript that runs in any modern browser. The GWT compiler performs aggressive code splitting, dead code elimination, and optimization to produce small, fast JavaScript bundles. GWT provides a rich set of UI widgets, RPC mechanisms for client-server communication, internationalization support, and the ability to use Java's type system and IDE features (refactoring, debugging, etc.) for web development. Despite being considered "legacy" by some, GWT remains actively maintained and used in production by thousands of applications worldwide, particularly in enterprise settings where Java expertise is abundant. It's ideal for complex, data-intensive web applications where Java developers want to leverage their existing skills without learning JavaScript frameworks.

## Code Example

```java
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;

public class HelloGWT implements EntryPoint {
    
    public void onModuleLoad() {
        // Create widgets
        Label label = new Label("Hello, GWT!");
        Button button = new Button("Click me");
        
        // Add click handler
        button.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                label.setText("Button clicked!");
            }
        });
        
        // Create panel and add widgets
        VerticalPanel panel = new VerticalPanel();
        panel.setSpacing(10);
        panel.add(label);
        panel.add(button);
        
        // Add panel to page
        RootPanel.get().add(panel);
    }
}

// Compiled to optimized JavaScript for deployment
```

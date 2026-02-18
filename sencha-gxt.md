---
name: Sencha GXT
status: Production-ready, Commercial
javaVersion: 8+ (11+ recommended)
learningCurve: Steep
lastRelease: GXT 10.1 (2023)
learnMoreText: Sencha GXT Website
learnMoreHref: https://www.sencha.com/products/gxt/
image: images/ui-sencha-gxt.png
tags:
    - Web UI
    - Web Framework
dateAdded: 2026-02-13
---

Sencha GXT (formerly Ext GWT) is a commercial, enterprise-grade widget library for GWT that provides over 100 professionally designed UI components based on Sencha's Ext JS framework. GXT offers sophisticated components like advanced grids with live updates, pivot grids, tree grids, rich text editors, charting (via Sencha Charts integration), complex forms with validation, and desktop-like layouts with docking, resizing, and drag-and-drop. The framework includes a comprehensive theming system with multiple built-in themes (Neptune, Triton, Material) and tools for creating custom themes. GXT emphasizes enterprise requirements: accessibility (ARIA support), high-performance data handling, extensive keyboard navigation, and production-ready components that handle edge cases. It's a commercial product requiring licensing, with support tiers available. GXT competes with frameworks like SmartGWT and Vaadin but stays closer to traditional GWT patterns. It's ideal for large enterprises building complex, data-intensive web applications in Java where the licensing cost is justified by developer productivity and the mature, battle-tested component library.

## Code Example

```java
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.TextField;

public class HelloGXT implements EntryPoint {
    public void onModuleLoad() {
        ContentPanel panel = new ContentPanel();
        panel.setHeading("GXT Example");
        panel.setWidth(400);
        
        VerticalLayoutContainer layout = 
            new VerticalLayoutContainer();
        
        TextField nameField = new TextField();
        nameField.setEmptyText("Enter your name");
        
        TextButton button = new TextButton("Submit");
        button.addSelectHandler(event -> {
            Info.display("Hello", 
                "Hello, " + nameField.getValue() + "!");
        });
        
        layout.add(nameField);
        layout.add(button);
        
        panel.add(layout);
        RootPanel.get().add(panel);
    }
}
```

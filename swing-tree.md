---
name: Swing-Tree
status: Production-ready
javaVersion: 8+
learningCurve: Easy
lastRelease: v0.13.0
learnMoreText: Swing-Tree GitHub
learnMoreHref: https://github.com/globaltcad/swing-tree
image: /images/ui-swing-tree.png
tags:
    - Desktop UI
---

Swing-Tree brings declarative, fluent APIs to Swing development—think Jetpack Compose or SwiftUI, but for Swing. Developed by Global TCAD Solutions for their own desktop applications, it eliminates Swing's verbose boilerplate with a clean, lambda-friendly API. The entire framework centers around a single `UI` class that can be statically imported, making Swing development feel modern and expressive. It integrates seamlessly with existing Swing components and works beautifully alongside FlatLaf for modern aesthetics. This is a community-driven library that's well-suited for developers seeking a more contemporary Swing development experience.

## Code Example

```java
import static swingtree.UI.*;

public class HelloSwingTree {
    public static void main(String[] args) {
        of(new JFrame("Swing-Tree Example"))
            .withDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
            .withSize(300, 200)
            .withLayout("fill, insets 20")
            .add("grow",
                panel("fill, wrap 1")
                .add("grow", label("Hello, Swing-Tree!"))
                .add("grow", button("Click Me")
                    .onClick(it -> System.out.println("Clicked!"))
                )
            )
            .show();
    }
}
```

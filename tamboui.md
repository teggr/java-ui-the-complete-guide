---
name: TamboUI
status: Experimental, Active Development
javaVersion: 8+ (17+ recommended)
learningCurve: Moderate
lastRelease: v0.1.0-SNAPSHOT (2026)
learnMoreText: TamboUI Official Documentation
learnMoreHref: https://tamboui.dev/docs/main/
image: images/ui-tamboui.png
tags:
    - Terminal UI
---

TamboUI is a Java library for building modern terminal user interfaces, bringing TUI paradigms from Rust's ratatui and Go's bubbletea to the Java ecosystem. It features immediate-mode rendering with an intermediate buffer system for efficient diff-based terminal updates, a flexible constraint-based layout system, and multiple backends including JLine 3, Panama (FFM), and Aesh for cross-platform support. The library includes a high-level TUI framework called TuiRunner that eliminates boilerplate with built-in event handling, and a declarative Toolkit DSL with fluent APIs for building components with focus management. TamboUI supports mouse capture, 60fps animations, CSS-based styling (TCSS), PicoCLI integration, and GraalVM native image compilation for instant startup. With comprehensive widget implementations including blocks, paragraphs, lists, tables, charts, canvas drawing, and text inputs, TamboUI provides everything needed for rich terminal applications while maintaining Java 8+ compatibility.

## Code Example

```java
import static dev.tamboui.toolkit.Toolkit.*;
import dev.tamboui.toolkit.app.ToolkitApp;
import dev.tamboui.toolkit.element.Element;

public class HelloTamboUI extends ToolkitApp {

    @Override
    protected Element render() {
        return panel("Hello",
            text("Welcome to TamboUI!").bold().cyan(),
            spacer(),
            text("Press 'q' to quit").dim()
        ).rounded();
    }

    public static void main(String[] args) throws Exception {
        new HelloTamboUI().run();
    }
}
```

---
name: WebFX
status: Active
javaVersion: 11+
learningCurve: Moderate
lastRelease: Active development (February 2026)
learnMoreText: WebFX Documentation
learnMoreHref: https://docs.webfx.dev/
image: images/ui-webfx.png
tags:
    - Compiler/Transpiler
    - Web UI
    - Desktop UI
    - Mobile
---

WebFX is a JavaFX application transpiler powered by GWT or TeaVM that converts JavaFX applications into standalone, self-contained JavaScript or WebAssembly web apps requiring no plugins or server execution in the browser. The WebFX kit is a modified version of OpenJFX with a patched higher layer made compatible with GWT and TeaVM, and a replaced lower layer that maps the scene graph directly to the DOM for browser rendering. Beyond web deployment, WebFX applications can also run on desktop (with embedded JRE) and mobile platforms (via Gluon), enabling true cross-platform development from a single JavaFX codebase. This approach offers a Java full-stack solution where developers can share code between frontend and backend using the Java module system, avoiding the complexity of JavaScript/TypeScript ecosystems. WebFX produces surprisingly lightweight web applications despite OpenJFX's size, with demos ranging from 97-176 kB, and benefits from the simplicity of self-contained web packaging versus server-based approaches.

## Code Example

```java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class WebFXHelloWorld extends Application {

    @Override
    public void start(Stage primaryStage) {
        Label label = new Label("Welcome to WebFX!");
        Button button = new Button("Click me");
        
        button.setOnAction(e -> 
            label.setText("Hello from WebFX in the browser!")
        );
        
        VBox root = new VBox(10, label, button);
        root.setStyle("-fx-padding: 20; -fx-alignment: center;");
        
        Scene scene = new Scene(root, 400, 300);
        primaryStage.setTitle("WebFX Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
```

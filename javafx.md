---
name: JavaFX
status: Production-ready
javaVersion: 11+ (17+ recommended)
learningCurve: Moderate
lastRelease: Ongoing (OpenJFX)
learnMoreText: OpenJFX Official Website
learnMoreHref: https://openjfx.io/
image: images/ui-javafx.png
tags:
    - Desktop UI
---

JavaFX is the modern standard for Java desktop applications. It provides a rich set of UI controls including tables, trees, charts, media players, and even 3D graphics with hardware-accelerated rendering. The framework supports CSS styling for theming, FXML for separating UI markup from logic, and includes Scene Builder for visual UI design. JavaFX's WebView component (WebKit-based) enables hybrid desktop apps that combine native controls with web content. It's cross-platform by default and has been the go-to choice for enterprise desktop applications requiring modern, professional interfaces. Note that JavaFX is maintained separately under the OpenJFX project and is no longer part of the standard JDK distribution.

## Code Example

```java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloJavaFX extends Application {
    @Override
    public void start(Stage stage) {
        Label label = new Label("Hello, JavaFX!");
        StackPane root = new StackPane(label);
        Scene scene = new Scene(root, 300, 200);
        stage.setTitle("JavaFX Example");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
```

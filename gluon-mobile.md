---
name: Gluon Mobile
status: Production-ready, Actively Maintained
javaVersion: 17+
learningCurve: Moderate
lastRelease: JavaFX 25.0.2 (Jan 2026)
learnMoreText: Gluon Mobile Official Website
learnMoreHref: https://gluonhq.com/products/mobile/
image: images/ui-gluon.png
tags:
    - Mobile UI
---

Gluon Mobile brings JavaFX to iOS and Android platforms, enabling developers to write desktop and mobile applications from a single codebase. Developed by Gluon HQ, who co-lead the OpenJFX project itself, the framework provides commercial JavaFX ports with native integrations for mobile platforms. Gluon provides Scene Builder for drag-and-drop UI design, GluonFX Maven and Gradle plugins for building, and optional cloud build services. The framework supports GraalVM native image compilation for mobile deployment (as iOS has historically required ahead-of-time compilation rather than standard JVM execution) and includes commercial long-term support options. For teams already invested in JavaFX for desktop who want to extend to mobile, Gluon Mobile provides a natural migration path.

## Code Example

```java
import com.gluonhq.charm.glisten.application.AppManager;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class HelloGluon extends Application {
    @Override
    public void start(Stage stage) {
        View view = new View("Hello") {
            {
                setCenter(new Label("Hello, Gluon Mobile!"));
            }
            
            @Override
            protected void updateAppBar(AppBar appBar) {
                appBar.setTitleText("Gluon Example");
            }
        };
        
        AppManager.initialize();
        AppManager.getInstance().addViewFactory("hello", () -> view);
        AppManager.getInstance().start(stage);
    }
}
```

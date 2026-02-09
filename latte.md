---
name: Latte
status: Active Development
javaVersion: 8+
learningCurve: Easy-Moderate
lastRelease: v0.1.1
learnMoreText: Latte GitHub
learnMoreHref: https://github.com/flatscrew/latte
image: https://robintegg.com/images/ui-latte.png
tags:
    - Terminal UI
---

Latte is a Java port of Golang's Bubble Tea framework, bringing The Elm Architecture's clean separation of concerns to terminal UI development in Java. The framework follows a simple pattern: you define a Model (your application state), implement an `init()` method for initialization, an `update()` method for handling events and state changes, and a `view()` method for rendering the UI. This architecture makes terminal applications predictable, testable, and easy to reason about. Latte handles all the complexity of terminal I/O, event handling, and rendering, letting you focus on your application logic.

The framework excels at building interactive command-line tools like coffee ordering systems, Conway's Game of Life visualizations, and other event-driven terminal applications. With support for keyboard input, commands for I/O operations, and a clean message-passing system, Latte brings modern reactive programming patterns to the terminal. The library includes numerous ported examples from the Bubble Tea ecosystem, making it easy to learn by example and adapt proven patterns to your Java applications.

## Code Example

```java
import org.flatscrew.latte.*;

public class HelloLatte implements Model {
    private int counter = 0;
    
    @Override
    public Command init() {
        return null;
    }
    
    @Override
    public UpdateResult<? extends Model> update(Message msg) {
        if (msg instanceof KeyPressMessage key) {
            if (key.key() == 'q') {
                return new UpdateResult<>(this, QuitMessage::new);
            } else if (key.key() == ' ') {
                counter++;
            }
        }
        return new UpdateResult<>(this, null);
    }
    
    @Override
    public String view() {
        return String.format("Counter: %d\n\nPress space to increment, q to quit", counter);
    }
    
    public static void main(String[] args) {
        new Program(new HelloLatte()).run();
    }
}
```

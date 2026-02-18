---
name: JStachio
status: Production-ready, Active
javaVersion: 11+
learningCurve: Easy-Moderate
lastRelease: v1.3.7 (2025)
learnMoreText: JStachio GitHub
learnMoreHref: https://github.com/jstachio/jstachio
image: images/ui-jstachio.png
tags:
    - Template Engine
    - Web UI
dateAdded: 2026-02-13
---

JStachio is a compile-time, type-safe template engine for Java that leverages annotation processing to generate template code at compile time rather than runtime. Inspired by Mustache, JStachio templates are logic-less and emphasize separation of concerns. Unlike reflection-based template engines, JStachio generates plain Java code during compilation, resulting in zero runtime overhead, no reflection, and full type safety with compile-time errors for missing or mistyped variables. The engine has first-class support for Java records, making it ideal for modern Java applications. JStachio templates are simple and readable, with no complex expression language to learn. The framework integrates well with Spring Boot, Quarkus, and other Java web frameworks, providing excellent performance characteristics for server-side rendering. It's perfect for teams that value type safety, want fast template rendering without reflection overhead, and appreciate catching template errors at compile time rather than in production.

## Code Example

```java
import io.jstach.jstachio.JStachio;

// Define a model using a record
@JStache(path = "hello.mustache")
public record HelloModel(String name, String message) {}

// Template file: hello.mustache
// <h1>Hello, {{name}}!</h1>
// <p>{{message}}</p>

public class HelloJStachio {
    public static void main(String[] args) {
        // JStachio generates the renderer at compile time
        HelloModel model = new HelloModel(
            "JStachio", 
            "Type-safe templates at compile time!"
        );
        
        String html = JStachio.render(model);
        System.out.println(html);
        
        // Output:
        // <h1>Hello, JStachio!</h1>
        // <p>Type-safe templates at compile time!</p>
    }
}
```

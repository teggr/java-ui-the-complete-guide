---
name: Javalin
status: Production-ready, Active
javaVersion: 8+ (11+ recommended)
learningCurve: Easy
lastRelease: v6.4.0 (2026)
learnMoreText: Javalin Official Website
learnMoreHref: https://javalin.io/
image: images/ui-javalin-screenshot.png
tags:
    - Web Framework
    - Microservices
---

Javalin is a simple, lightweight web framework for Java and Kotlin built on top of Jetty. Unlike other frameworks, Javalin has very few concepts to learn—you never extend classes and rarely implement interfaces, making it one of the easiest Java web frameworks to pick up. With just a few thousand lines of code, Javalin's performance is equivalent to raw Jetty while being far more developer-friendly. It's designed with inter-operability in mind, so applications are built identically in both Java and Kotlin. Javalin embraces a simple, blocking programming model that's easy to reason about, but automatically switches to asynchronous mode when you set a Future as result. It includes built-in OpenAPI support with Swagger UI and ReDoc, comprehensive WebSocket support, and access to all of Jetty's configuration options including SSL and HTTP3. Perfect for microservices, REST APIs, and lightweight web applications where you want minimal ceremony and maximum clarity.

## Code Example

```java
import io.javalin.Javalin;
import io.javalin.http.Context;

public class HelloJavalin {
    public static void main(String[] args) {
        Javalin app = Javalin.create(config -> {
            config.staticFiles.enableWebjars();
        }).start(7070);

        app.get("/", ctx -> ctx.result("Hello, Javalin!"));
        
        app.get("/hello/{name}", ctx -> {
            String name = ctx.pathParam("name");
            ctx.json(Map.of("message", "Hello, " + name + "!"));
        });
        
        app.post("/echo", ctx -> {
            String body = ctx.body();
            ctx.result("You said: " + body);
        });
    }
}
```

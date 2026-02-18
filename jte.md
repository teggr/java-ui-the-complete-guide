---
name: JTE
status: Production-ready, Active
javaVersion: 8+ (11+ recommended)
learningCurve: Easy
lastRelease: v3.2.3 (2026)
learnMoreText: JTE Official Website
learnMoreHref: https://jte.gg/
image: images/ui-jte.png
tags:
    - Template Engine
    - Web UI
dateAdded: 2026-02-18
---

JTE (Java Template Engine) is a secure, lightweight, and blazingly fast template engine for Java and Kotlin. What sets JTE apart is its intuitive syntax that builds upon existing Java/Kotlin language features—you write plain Java or Kotlin code for expressions without learning a new expression language. JTE performs context-sensitive HTML escaping at compile time to prevent XSS attacks, making security a default rather than an afterthought. The framework offers hot reloading during development for instant feedback and includes a full-featured IntelliJ plugin with code completion, refactoring support, and syntax highlighting. JTE compiles templates to Java classes, resulting in exceptional performance (benchmarks show it's one of the fastest template engines available). It's particularly popular in the Kotlin community and integrates seamlessly with Spring Boot, Javalin, Ktor, and other frameworks. With minimal dependencies and straightforward syntax, JTE is ideal for teams building modern web applications who want type safety, security, and performance without complexity.

## Code Example

```java
import gg.jte.TemplateEngine;
import gg.jte.CodeResolver;
import gg.jte.ContentType;
import gg.jte.output.StringOutput;
import gg.jte.resolve.DirectoryCodeResolver;
import java.nio.file.Path;

public class HelloJTE {
    public static void main(String[] args) {
        CodeResolver resolver = new DirectoryCodeResolver(Path.of("jte"));
        TemplateEngine engine = TemplateEngine.create(
            resolver, 
            ContentType.Html
        );
        
        StringOutput output = new StringOutput();
        engine.render("hello.jte", "JTE User", output);
        System.out.println(output.toString());
    }
}

// Template file: hello.jte
// @param String name
// <h1>Hello, ${name}!</h1>
// <p>Type-safe templates with plain Java!</p>
```

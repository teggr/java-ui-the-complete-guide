---
name: j2html
status: Production-ready
javaVersion: 8+
learningCurve: Easy
lastRelease: v1.6.0 (June 2022, current stable)
learnMoreText: j2html Official Website
learnMoreHref: https://j2html.com/
image: images/ui-j2html.png
tags:
    - Web UI
---

j2html is not a template engine—it's a type-safe HTML builder for pure Java code. Using a fluent API, you construct HTML with compile-time safety, eliminating risks of unclosed tags, mistyped attributes, or XSS vulnerabilities through automatic escaping. It's extremely fast (100k renders in under 1 second, roughly 1000x faster than Velocity) and enables dynamic reuse of view code that's difficult with templates. j2html works particularly well with lightweight frameworks like Javalin for building APIs that return HTML fragments or generating dynamic emails and forms. While not suitable for traditional websites with large amounts of static HTML or heavy copy-pasted CSS framework markup, it excels when type safety and Java-centric development are priorities.

## Code Example

```java
import static j2html.TagCreator.*;

public class HelloJ2Html {
    public static void main(String[] args) {
        String html = html(
            head(
                title("j2html Example")
            ),
            body(
                h1("Hello, j2html!"),
                p("Type-safe HTML in Java"),
                button("Click me").withClass("btn")
            )
        ).render();
        
        System.out.println(html);
    }
}
```

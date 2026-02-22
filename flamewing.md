---
name: Flamewing
status: Experimental
javaVersion: 17+
learningCurve: Easy
lastRelease: Active (February 2026)
learnMoreText: Flamewing Website
learnMoreHref: https://pazvanti.github.io/Flamewing/index.html
image: images/ui-flamewing.png
tags:
    - Web UI
    - Template Engine
dateAdded: 2026-02-22
---

Flamewing is a modern, high-performance server-side template engine designed specifically for Spring and Spring Boot applications. Using a minimal, Java-centric syntax built around a single special character (`@`), Flamewing lets developers embed Java directly in HTML templates without learning a new language or DSL. Templates are compiled into Java classes at build time rather than interpreted at runtime, which makes Flamewing significantly faster than interpreted engines — benchmark results show it renders pages over 30× faster than Thymeleaf and slightly faster than Rocker.

Key features include component-based development with reusable fragments, reverse routing (Flamewing resolves controller URLs at runtime so template links stay valid even when endpoint paths change), null-safety operators, `@with` scoped variable blocks, content blocks, CSRF helpers for Spring Security integration, and full support for standard Java `for`/`if`/`else` syntax. Flamewing is fully open source (free for commercial use) and currently in early but active development. It is an ideal choice for Spring Boot teams that want the safety and speed of server-side rendering with minimal new syntax to learn.

## Code Example

```java
// ProductController.java
@Controller
public class ProductController {

    @GetMapping("/products")
    public View products(Model model) {
        List<String> items = List.of("Widget", "Gadget", "Doohickey");
        return View.of("products", model.addAttribute("items", items));
    }
}
```

```html
<!-- products.flamewing -->
@import java.util.List;

@args(List<String> items)
<html>
<body>
    <h1>Product List</h1>
    @if (items.isEmpty()) {
        <p>No products found.</p>
    } else {
        <ul>
        @for (String item : items) {
            <li>@item</li>
        }
        </ul>
    }
    <a href="@routes.ProductController.products()">Refresh</a>
</body>
</html>
```

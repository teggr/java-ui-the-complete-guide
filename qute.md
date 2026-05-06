---
name: Qute
status: Production-ready, Active
javaVersion: 11+ (17+ recommended)
learningCurve: Moderate
lastRelease: v3.21.4 (2026)
learnMoreText: Qute Quarkus Guide
learnMoreHref: https://quarkus.io/guides/qute
image: images/ui-qute.png
tags:
    - Template Engine
    - Web UI
    - Web Framework
dateAdded: 2026-05-06
---

Qute is a type-safe, reactive templating engine designed specifically for Quarkus, built to meet the demands of modern cloud-native Java applications. Its core design minimizes the use of reflection, making it an excellent fit for GraalVM native image compilation and achieving low memory footprints. Qute templates are automatically discovered from the `src/main/resources/templates` folder and support hot reloading in Quarkus dev mode for near-instant feedback during development.

What sets Qute apart is its build-time type checking: the engine validates template expressions at compile time, catching most problems before deployment and failing fast rather than at runtime. CDI beans can be injected directly into templates, and template extension methods allow you to add custom functionality to existing types without modifying them. Qute supports reactive and imperative rendering and provides built-in HTML escaping to prevent XSS vulnerabilities.

Beyond the Quarkus integration, Qute can also be used as a standalone library, although some Quarkus-specific features like CDI injection, type-safe message bundles, and build-time validation are unavailable in that mode. Qute is the recommended template engine for Quarkus-based REST APIs, server-side rendered web applications, and email templating.

## Code Example

```java
import io.quarkus.qute.Template;
import io.quarkus.qute.Location;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class HelloResource {

    // Quarkus auto-discovers templates/hello.html
    @Inject
    Template hello;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String get(@QueryParam("name") String name) {
        return hello.data("name", name != null ? name : "World")
                    .render();
    }
}

// Template file: src/main/resources/templates/hello.html
// <!DOCTYPE html>
// <html>
// <body>
//   <h1>Hello, {name}!</h1>
//   {#if name}
//     <p>Welcome back, {name}.</p>
//   {#else}
//     <p>Please provide your name.</p>
//   {/if}
// </body>
// </html>
```

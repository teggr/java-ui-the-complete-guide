---
name: Apache Wicket
status: Production-ready, Mature (since 2004)
javaVersion: 17+ (Wicket 10)
learningCurve: Moderate
lastRelease: Wicket 10.7.0 (Sep 2025)
learnMoreText: Apache Wicket Official Website
learnMoreHref: https://wicket.apache.org/
image: images/ui-wicket.png
tags:
    - Web UI
---

Apache Wicket is a component-oriented web framework that brings Swing-like development to the web. It uses pure Java and HTML markup (no XML), with clean separation between markup and logic. Wicket manages stateful web applications automatically, treating models as opaque POJOs that are serialized between requests. The framework's component hierarchy—Pages, Components, Models—feels familiar to desktop developers and enables significant code reuse through Panels. Wicket 10, built on Java 17, includes Ajax support without writing JavaScript, WebSocket integration, and compatibility with Spring, CDI, and Guice. Widely adopted in enterprise environments, Wicket powers thousands of applications deployed worldwide at governments, banks, and universities, having proven its staying power since surviving the mid-2000s Java web framework wars.

## Code Example

```java
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

public class HelloWicket extends WebPage {
    public HelloWicket() {
        add(new Label("message", "Hello, Wicket!"));
    }
}

// Corresponding HTML (HelloWicket.html):
// <html>
//   <body>
//     <span wicket:id="message"></span>
//   </body>
// </html>
```

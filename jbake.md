---
name: JBake
status: Production-ready
javaVersion: 11+
learningCurve: Easy-Moderate
lastRelease: v2.7.0 (December 2025)
learnMoreText: JBake Website
learnMoreHref: https://jbake.org/
image: images/ui-jbake.png
tags:
    - Build Tools
    - Template Engine
dateAdded: 2026-03-04
---

JBake is an open-source, Java-based static site generator inspired by tools like Jekyll and Awestruct. It processes content written in AsciiDoc, Markdown, or plain HTML and applies templates to produce a complete static website. JBake supports multiple template engines—Freemarker, Groovy Markup, Groovy Templates, Thymeleaf, Jade, and Pebble—giving developers maximum flexibility in choosing a familiar syntax for layouts and partials. The tool is blog-aware, supporting RSS/Atom feeds, tag pages, archive pages, and draft content previews out of the box.

Build tool integration is a first-class feature: official plugins exist for Gradle, Maven, mill, and sbt, making JBake easy to incorporate into existing Java project workflows. Content is stored as plain files, compatible with any version control system. The binary distribution is self-contained, requiring only a JRE. JBake is ideal for developers, technical writers, and open-source projects that want a Java-native static site pipeline with strong template customization, without adopting Node.js-based tooling.

## Code Example

```java
// Using the JBake API to bake a site programmatically
import org.jbake.app.Oven;
import org.jbake.app.configuration.ConfigUtil;
import org.jbake.app.configuration.JBakeConfiguration;

import java.io.File;

public class BakeSite {
    public static void main(String[] args) throws Exception {
        File sourceDir = new File("src/site");
        File outputDir = new File("build/site");

        JBakeConfiguration config = ConfigUtil.load(sourceDir);
        Oven oven = new Oven(config);

        // Bake the site: process content and apply templates
        oven.bake();

        System.out.println("Site generated in: " + outputDir.getAbsolutePath());
    }
}
```

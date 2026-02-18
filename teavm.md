---
name: TeaVM
status: Production-ready
javaVersion: Any (bytecode-based)
learningCurve: Easy
lastRelease: Active (2025-2026)
learnMoreText: TeaVM Official Website
learnMoreHref: https://teavm.org/
image: images/ui-teavm.png
tags:
    - Web UI
dateAdded: 2026-02-18
---

TeaVM is an ahead-of-time compiler that transpiles Java bytecode to JavaScript or WebAssembly, making it work with any JVM language—Java, Kotlin, Scala, or others. Unlike GWT which works on source code, TeaVM operates on bytecode, giving it broader language support. The framework supports the new WebAssembly GC standard for garbage-collected languages and produces readable, optimized JavaScript without requiring npm, Webpack, or other frontend build tools. TeaVM includes JSO (JavaScript Objects) API for JS interop, DOM module for browser APIs, and sophisticated optimizations like dead code elimination. It's used by WebFX (JavaFX apps in browsers) and various projects where backend Java developers want to target the web without learning the JavaScript ecosystem.

## Code Example

```java
import org.teavm.jso.dom.html.HTMLDocument;
import org.teavm.jso.dom.html.HTMLElement;

public class HelloTeaVM {
    public static void main(String[] args) {
        HTMLDocument document = HTMLDocument.current();
        HTMLElement body = document.getBody();
        HTMLElement div = document.createElement("div");
        div.setInnerHTML("Hello, TeaVM!");
        body.appendChild(div);
    }
}
```

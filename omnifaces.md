---
name: OmniFaces
status: Production-ready
javaVersion: 17+
learningCurve: Easy
lastRelease: Active
learnMoreText: OmniFaces Official Website
learnMoreHref: https://omnifaces.org
image: images/ui-omnifaces.png
tags:
    - Web UI
---

OmniFaces is a utility library for Jakarta Faces that focuses on utilities that ease everyday tasks with the standard Faces API. Unlike component libraries like PrimeFaces or BootsFaces, OmniFaces doesn't provide visual components but rather solves everyday practical problems and workarounds for shortcomings in the Faces API. It provides utility classes like Faces and Messages for working with the Faces API from Java code, enhanced components such as `<o:highlight>` and `<o:viewParam>`, converters, validators, and Facelets tag handlers. OmniFaces includes specialized handlers like a full ajax exception handler and a combined resource handler, plus CDI-specific features including transparent support for injection in @FacesConverter and @FacesValidator, an improved @ViewScoped, and web socket based push via `<o:socket>`.

## Code Example

```java
// Backing bean with OmniFaces utilities
@Named
@ViewScoped
public class HelloBean implements Serializable {
    private String message = "Hello, OmniFaces!";
    
    public void init() {
        // Using OmniFaces Faces utility
        Faces.addGlobalInfo("Welcome to OmniFaces!");
    }
    
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}

// XHTML view with OmniFaces components:
// <o:viewParam name="id" value="#{helloBean.id}" />
// <o:socket channel="push" onmessage="handleMessage" />
```

---
name: Jakarta Faces
status: Production-ready, Enterprise standard
javaVersion: 8+
learningCurve: Moderate
lastRelease: Active
learnMoreText: Jakarta Faces Official Website
learnMoreHref: https://jakarta.ee/specifications/faces/
image: https://robintegg.com/images/ui-jsf.png
tags:
    - Web UI
---

Jakarta Faces (the evolution of JavaServer Faces under the Jakarta EE umbrella) is a component-focused web framework deeply integrated with enterprise Java. As part of the Jakarta EE specification, it provides standardized UI component development with server-side state management, event handling, and validation. The framework includes drag-and-drop features in supporting IDEs and works seamlessly with other Jakarta EE technologies like CDI, JPA, and Bean Validation. For teams already invested in the Jakarta EE ecosystem, Faces provides a stable, standardized approach to web UI development with broad vendor support and extensive enterprise tooling.

## Code Example

```java
// Backing bean
@Named
@RequestScoped
public class HelloFaces {
    private String message = "Hello, Jakarta Faces!";
    
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}

// XHTML view:
// <h:outputText value="#{helloFaces.message}" />
```

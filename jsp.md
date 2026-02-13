---
name: JSP (Jakarta Server Pages)
status: Legacy, Stable
javaVersion: 8+
learningCurve: Easy-Moderate
lastRelease: Jakarta Pages 4.0 (2024)
learnMoreText: Jakarta EE Pages Specification
learnMoreHref: https://jakarta.ee/specifications/pages/
image: /images/ui-jsp.png
tags:
    - Web UI
    - Template Engine
    - Legacy
---

JSP (JavaServer Pages), now part of Jakarta EE as Jakarta Pages, is a server-side template technology that embeds Java code in HTML pages using special tags. Once the standard for Java web development alongside Servlets, JSP allows mixing presentation (HTML) with logic (Java scriptlets, expressions, and tag libraries like JSTL). While JSP revolutionized Java web development in the early 2000s and remains embedded in countless enterprise applications, it's now considered legacy technology. Modern alternatives like Thymeleaf, JTE, and server-side frameworks (Vaadin, Spring Boot with REST) have largely replaced JSP in new development due to better separation of concerns, improved testability, and more maintainable codebases. However, JSP's simplicity and ubiquity mean it's still widely used in maintenance scenarios and some enterprise environments. The Jakarta EE specification continues to maintain JSP (as Jakarta Pages), ensuring compatibility and security updates, but the focus has shifted to more modern template engines and architectural patterns. Learning JSP remains relevant primarily for maintaining existing applications.

## Code Example

```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP Example</title>
</head>
<body>
    <h1>Hello, JSP!</h1>
    
    <%-- Scriptlet (avoid in modern JSP) --%>
    <% String name = request.getParameter("name"); %>
    
    <%-- Expression --%>
    <p>Welcome, <%= name != null ? name : "Guest" %></p>
    
    <%-- JSTL (preferred modern approach) --%>
    <c:if test="${not empty sessionScope.user}">
        <p>Logged in as: ${sessionScope.user.name}</p>
    </c:if>
    
    <%-- Iteration example --%>
    <ul>
    <c:forEach items="${items}" var="item">
        <li>${item}</li>
    </c:forEach>
    </ul>
</body>
</html>
```

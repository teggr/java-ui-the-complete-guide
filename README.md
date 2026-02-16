# Awesome Java UI

Guide to the Java UI landscape: desktop, web, terminal and mobile

## Quick Start

**Prerequisites:**
- Java 25+
- JBang

**Build and serve the site:**

```bash
# Build the site (generates HTML in _site/ directory)
jbang run build.java

# Serve locally (open http://localhost:8000)
cd _site
"%JAVA_HOME%\bin\jwebserver"
```

The site will be available at `http://localhost:8000`

## Contributing

We welcome contributions! There are several ways you can help:

### Option 1: Submit a Pull Request
If you're comfortable with Git and markdown:
1. Fork this repository
2. Create a new `.md` file for the Java UI library (e.g., `my-framework.md`)
3. Follow the markdown template structure (see existing files like `htmx.md`)
4. Submit a pull request

### Option 2: Create a GitHub Issue
If you'd like to suggest a library but don't have time for a full PR:
1. [Create a new issue](https://github.com/YOUR_USERNAME/java-ui-the-complete-guide/issues/new)
2. Provide at minimum:
   - **Project name**
   - **Project URL**

### Option 3: Create a Detailed Issue
If you really want to help, provide the full markdown content in the issue using this template:

```markdown
---
name: Framework Name
status: Production-ready / Active / Archived / Beta
javaVersion: Java 17+
learningCurve: Easy / Moderate / Steep
lastRelease: vX.X.X (YYYY)
learnMoreText: Official Website
learnMoreHref: https://example.com
image: images/ui-framework-name.png
tags:
    - Desktop UI / Web UI / Terminal UI / Mobile UI
    - Web Framework / UI Components / etc.
---

Brief description of the framework (2-3 paragraphs explaining what it is, 
its key features, and why it's relevant to Java developers).

## Code Example

\```java
// Minimal working example demonstrating the framework
public class Example {
    public static void main(String[] args) {
        // Your example code here
    }
}
\```
```

**Required metadata fields:**
- `name`: Display name
- `status`: Current project status
- `javaVersion`: Supported Java versions
- `learningCurve`: Difficulty level
- `lastRelease`: Latest version and year
- `learnMoreText` / `learnMoreHref`: Link to documentation
- `image`: Screenshot/logo filename
- `tags`: Categories (Desktop UI, Web Framework, Terminal UI, etc.)

All contributions are appreciated! 🎉


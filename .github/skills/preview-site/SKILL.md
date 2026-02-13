---
description: Start a local web server to preview the generated static site. Use this when asked to preview the site, start a preview server, or view the site locally.
---

# Preview Site

To preview the generated static site locally:

1. Check if `_site/` directory exists and contains `index.html`. If not, run `jbang run build.java` first to build the site.

2. Open the browser to `http://localhost:8000`:
   - Windows: `Start-Process "http://localhost:8000"`
   - macOS: `open http://localhost:8000`
   - Linux: `xdg-open http://localhost:8000`

3. Start jwebserver in the foreground from the `_site` directory:
   - Windows: `Set-Location _site; & "$env:JAVA_HOME\bin\jwebserver.exe"`
   - Unix/Mac: `cd _site && $JAVA_HOME/bin/jwebserver`

4. Use `mode="async"` without detach so the server runs in the foreground and can be stopped with Ctrl+C.

5. Inform the user the preview server is running on http://localhost:8000 and can be stopped with Ctrl+C or the stop button.

## Requirements

- Java 18+ (jwebserver was introduced in Java 18)
- JAVA_HOME environment variable must be set

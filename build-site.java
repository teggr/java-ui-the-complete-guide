///usr/bin/env jbang "$0" "$@" ; exit $?

//JAVA 17+

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * JBang script to build the static site for java-ui-the-complete-guide
 * This script generates HTML pages in the docs directory for GitHub Pages
 */
public class build_site {
    
    public static void main(String... args) throws IOException {
        System.out.println("Building java-ui-the-complete-guide static site...");
        
        // Create docs directory if it doesn't exist
        Path docsDir = Paths.get("docs");
        if (!Files.exists(docsDir)) {
            Files.createDirectory(docsDir);
            System.out.println("Created docs directory");
        }
        
        // Read README.md
        Path readmePath = Paths.get("README.md");
        String readmeContent = Files.exists(readmePath) 
            ? Files.readString(readmePath) 
            : "Welcome to Java UI - The Complete Guide";
        System.out.println("Read README.md");
        
        // Generate index.html
        String html = generateIndexHtml(readmeContent);
        Path indexPath = docsDir.resolve("index.html");
        Files.writeString(indexPath, html);
        System.out.println("Generated index.html");
        
        System.out.println("Site build completed successfully!");
    }
    
    private static String generateIndexHtml(String readmeContent) {
        // Convert markdown to basic HTML
        String bodyContent = convertMarkdownToHtml(readmeContent);
        
        return """
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Java UI - The Complete Guide</title>
    <style>
        body {
            font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, 'Helvetica Neue', Arial, sans-serif;
            line-height: 1.6;
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
            color: #333;
        }
        h1 {
            color: #2c3e50;
            border-bottom: 2px solid #3498db;
            padding-bottom: 10px;
        }
        h2 {
            color: #34495e;
            margin-top: 30px;
        }
        a {
            color: #3498db;
            text-decoration: none;
        }
        a:hover {
            text-decoration: underline;
        }
        .header {
            text-align: center;
            margin-bottom: 40px;
        }
        .footer {
            margin-top: 50px;
            padding-top: 20px;
            border-top: 1px solid #ddd;
            text-align: center;
            color: #7f8c8d;
            font-size: 0.9em;
        }
    </style>
</head>
<body>
    <div class="header">
        <h1>☕ Java UI - The Complete Guide</h1>
        <p><em>A community-driven repository of up-to-date Java UI projects</em></p>
    </div>
    
    <div class="content">
""" + bodyContent + """
    </div>
    
    <div class="footer">
        <p>Generated with ❤️ by JBang | <a href="https://github.com/teggr/java-ui-the-complete-guide">View on GitHub</a></p>
    </div>
</body>
</html>
""";
    }
    
    private static String convertMarkdownToHtml(String markdown) {
        // Basic markdown to HTML conversion
        String html = markdown;
        
        // Convert headers
        html = html.replaceAll("(?m)^# (.+)$", "<h1>$1</h1>");
        html = html.replaceAll("(?m)^## (.+)$", "<h2>$1</h2>");
        html = html.replaceAll("(?m)^### (.+)$", "<h3>$1</h3>");
        
        // Convert bold
        html = html.replaceAll("\\*\\*(.+?)\\*\\*", "<strong>$1</strong>");
        
        // Convert italic
        html = html.replaceAll("\\*(.+?)\\*", "<em>$1</em>");
        
        // Convert links
        html = html.replaceAll("\\[(.+?)\\]\\((.+?)\\)", "<a href=\"$2\">$1</a>");
        
        // Convert paragraphs - only wrap lines that aren't already HTML tags
        html = html.replaceAll("(?m)^(?!<[hH][1-6]>)(.+?)(?!</[hH][1-6]>)$", "<p>$1</p>");
        
        // Remove empty paragraphs
        html = html.replaceAll("<p>\\s*</p>", "");
        
        return html;
    }
}

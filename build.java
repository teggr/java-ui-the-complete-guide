///usr/bin/env jbang "$0" "$@" ; exit $?
//JAVA 25+
//DEPS com.j2html:j2html:1.6.0
//DEPS org.commonmark:commonmark:0.21.0
//DEPS org.commonmark:commonmark-ext-yaml-front-matter:0.21.0
//DEPS org.commonmark:commonmark-ext-heading-anchor:0.21.0

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static j2html.TagCreator.*;

import j2html.TagCreator;
import j2html.rendering.IndentedHtml;
import j2html.tags.DomContent;
import j2html.tags.specialized.HtmlTag;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.commonmark.ext.front.matter.YamlFrontMatterExtension;
import org.commonmark.ext.heading.anchor.HeadingAnchorExtension;

void main(String... args) throws IOException {

    System.out.println("Building java-ui-the-complete-guide static site...");

    // Create docs directory if it doesn't exist
    Path docsDir = Paths.get("docs");
    if (!Files.exists(docsDir)) {
        Files.createDirectory(docsDir);
        System.out.println("Created docs directory");
    }

    // start iterating over the markdown files in the root folder, excluding README.md
    Files.list(Paths.get("."))
        .filter(path -> path.toString().endsWith(".md") && !path.getFileName().toString().equals("README.md"))
        .forEach(path -> {
            try {
                System.out.println("Processing " + path);
                String markdown = Files.readString(path);

                // Parse markdown with CommonMark
                Parser parser = Parser.builder()
                    .extensions(List.of(YamlFrontMatterExtension.create(), HeadingAnchorExtension.create()))
                    .build();
                HtmlRenderer renderer = HtmlRenderer.builder()
                    .extensions(List.of(YamlFrontMatterExtension.create(), HeadingAnchorExtension.create()))
                    .build();
                String html = renderer.render(parser.parse(markdown));

                // Write HTML to docs directory
                HtmlTag htmlTag = output( TagCreator.rawHtml(html) );

               StringWriter writer = new StringWriter();
               writer.append( htmlTag.render(IndentedHtml.inMemory()) );

               String finalHtml = writer.toString();

                String htmlFileName = path.getFileName().toString().replace(".md", ".html");
                Path htmlPath = docsDir.resolve(htmlFileName);
                Files.writeString(htmlPath, finalHtml);
                System.out.println("Generated " + htmlFileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });


    // Generate index.html
    String html = "";
    Path indexPath = docsDir.resolve("index.html");
    Files.writeString(indexPath, html);
    System.out.println("Generated index.html");

    System.out.println("Site build completed successfully!");

}

static HtmlTag output(DomContent content) {
    return html(
        head(
            title("Java UI - The Complete Guide")
        ),
        body(
            h1("Java UI - The Complete Guide"),
            content
        )
    );
}
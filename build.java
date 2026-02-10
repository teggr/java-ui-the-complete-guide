/// usr/bin/env jbang "$0" "$@" ; exit $?
//JAVA 25+
//DEPS com.j2html:j2html:1.6.0
//DEPS org.commonmark:commonmark:0.21.0
//DEPS org.commonmark:commonmark-ext-yaml-front-matter:0.21.0
//DEPS org.commonmark:commonmark-ext-heading-anchor:0.21.0

import j2html.rendering.IndentedHtml;
import j2html.tags.DomContent;
import j2html.tags.specialized.HtmlTag;
import org.commonmark.ext.front.matter.YamlFrontMatterExtension;
import org.commonmark.ext.front.matter.YamlFrontMatterVisitor;
import org.commonmark.ext.heading.anchor.HeadingAnchorExtension;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

import static j2html.TagCreator.*;

void main(String... args) throws IOException {

  System.out.println("Building java-ui-the-complete-guide static site...");

  // Create docs directory if it doesn't exist
  Path outputDirectory = Paths.get("_site");
  if (!Files.exists(outputDirectory)) {
    Files.createDirectory(outputDirectory);
    System.out.println("Created output directory");
  }

  // collect all markdown data in a map, key is html file name, value is the data from the markdown file
  Map<String, Map<String, List<String>>> markdownData = new HashMap<>();

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
        org.commonmark.node.Node document = parser.parse(markdown);
        // Extract YAML front matter
        YamlFrontMatterVisitor frontMatterVisitor = new YamlFrontMatterVisitor();
        document.accept(frontMatterVisitor);

        String html = renderer.render(document);

        // Write HTML to docs directory
        HtmlTag htmlTag = output(project(frontMatterVisitor.getData(), rawHtml(html)));

        StringWriter writer = new StringWriter();
        writer.append(htmlTag.render(IndentedHtml.inMemory()));

        String finalHtml = writer.toString();

        String htmlFileName = path.getFileName().toString().replace(".md", ".html");

        markdownData.put( htmlFileName, frontMatterVisitor.getData() );

        Path htmlPath = outputDirectory.resolve(htmlFileName);
        Files.writeString(htmlPath, finalHtml);
        System.out.println("Generated " + htmlFileName);
      } catch (IOException e) {
        e.printStackTrace();
      }
    });

  // Generate index.html
  StringWriter writer = new StringWriter();
  writer.append(output(indexPage(markdownData)).render(IndentedHtml.inMemory()));
  String html = writer.toString();
  Path indexPath = outputDirectory.resolve("index.html");
  Files.writeString(indexPath, html);
  System.out.println("Generated index.html");

  // copy the css directory and all the files inside to the output directory
  Path cssSource = Paths.get("css");
  Path cssTarget = outputDirectory.resolve("css");
  if (Files.exists(cssSource) && Files.isDirectory(cssSource)) {
    Files.walk(cssSource).forEach(source -> {
      try {
        Path target = cssTarget.resolve(cssSource.relativize(source));
        if (Files.isDirectory(source)) {
          if (!Files.exists(target)) {
            Files.createDirectory(target);
          }
        } else {
          Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    });
    System.out.println("Copied css directory");
  } else {
    System.out.println("No css directory found, skipping copy");
  }

  System.out.println("Site build completed successfully!");

}

private DomContent project(Map<String, List<String>> data, DomContent content) {

  String name = data.getOrDefault("name", List.of("Unknown Project")).get(0);
  String status = data.getOrDefault("status", List.of("Unknown Status")).get(0);
  String javaVersion = data.getOrDefault("javaVersion", List.of("Unknown Java Version")).get(0);
  String learningCurve = data.getOrDefault("learningCurve", List.of("Unknown Learning Curve")).get(0);
  String lastRelease = data.getOrDefault("lastRelease", List.of("Unknown Last Release")).get(0);
  String learnMoreText = data.getOrDefault("learnMoreText", List.of("Learn More")).get(0);
  String learnMoreHref = data.getOrDefault("learnMoreHref", List.of("#")).get(0);
  String image = data.getOrDefault("image", List.of("https://via.placeholder.com/150")).get(0);
  List<String> tags = data.getOrDefault("tags", List.of());

  return div(
    div(
      a("← Back to Home")
        .withHref("index.html")
        .attr("hx-get", "index.html")
        .attr("hx-target", "body")
        .attr("hx-swap", "innerHTML transition:true")
        .attr("hx-push-url", "true")
        .withClass("back-link")
    ),
    each(
      h1(name),
      img().withSrc(image).withAlt(name),
      p("Status: " + status),
      p("Java Version: " + javaVersion),
      p("Learning Curve: " + learningCurve),
      p("Last Release: " + lastRelease),
      a(learnMoreText).withHref(learnMoreHref).withTarget("_blank"),
      div(
        each(tags, tag -> span(tag).withClass("tag"))
      ).withClass("tags"),
      content
    )
  ).withId("main-content");

}

static DomContent indexPage(Map<String, Map<String, List<String>>> markdownData) {
  return div(
    h1("Java UI - The Complete Guide"),
    p("Welcome to the Java UI - The Complete Guide! This site provides an overview of various Java UI frameworks and libraries, along with their status, Java version compatibility, learning curve, last release date, and more. Explore the projects below to find the right Java UI solution for your needs."),
    div(
      a("🚀 Contribute on GitHub")
        .withHref("https://github.com/teggr/java-ui-the-complete-guide")
        .withTarget("_blank")
        .withRel("noopener noreferrer")
        .withClass("github-cta")
    ).withClass("github-cta-container"),
    div(
      each( markdownData.entrySet(), entry -> {
        String htmlFileName = entry.getKey();
        String projectName = entry.getValue().getOrDefault("name", List.of("ProjectX")).get(0);
        String imageUrl = entry.getValue().getOrDefault("image", List.of("https://via.placeholder.com/150")).get(0);
        return a(
          div(
            img().withSrc(imageUrl).withAlt(projectName).withClass("project-thumbnail"),
            div(projectName).withClass("project-name")
          ).withClass("project-card-content")
        )
          .withHref(htmlFileName)
          .attr("hx-get", htmlFileName)
          .attr("hx-target", "body")
          .attr("hx-swap", "innerHTML transition:true")
          .attr("hx-push-url", "true")
          .withClass("project-card");
      })
    ).withClass("project-list")
  ).withId("main-content");
}

static HtmlTag output(DomContent content) {
  return html(
    head(
      title("Java UI - The Complete Guide"),
      link().withRel("stylesheet").withHref("css/styles.css"),
      script().withSrc("https://unpkg.com/htmx.org@2.0.4")
    ),
    body(
      content
    )
  );
}
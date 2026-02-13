---
name: Helidon
status: Production-ready, Active
javaVersion: 21+
learningCurve: Moderate
lastRelease: v4.1.6 (2026)
learnMoreText: Helidon Official Website
learnMoreHref: https://helidon.io/
image: images/ui-helidon-screenshot.png
tags:
    - Web Framework
    - Cloud-Native
    - Microservices
---

Helidon is Oracle's collection of lightweight Java libraries for building cloud-native microservices, designed around Java virtual threads (Project Loom). It's the world's first web server written entirely on virtual threads, providing exceptional throughput and scalability. Helidon offers two programming models: Helidon MP (MicroProfile) with familiar JAX-RS, CDI, and JSON-P/B APIs, and Helidon SE with a modern functional/reactive approach. The framework includes comprehensive observability with health checks, metrics, telemetry (OpenTelemetry), and fault tolerance integrations with Prometheus, Jaeger, and Zipkin. GraalVM Native Image support allows compilation to small-footprint native executables, while persistence support covers JDBC drivers and both relational and non-relational databases. Helidon is ideal for enterprise teams building cloud-ready microservices that need MicroProfile compatibility combined with cutting-edge virtual thread performance.

## Code Example

```java
import io.helidon.webserver.WebServer;
import io.helidon.webserver.http.HttpRouting;

public class HelloHelidon {
    public static void main(String[] args) {
        HttpRouting routing = HttpRouting.builder()
            .get("/hello", (req, res) -> {
                res.send("Hello, Helidon!");
            })
            .get("/greet/{name}", (req, res) -> {
                String name = req.path().pathParameters().get("name");
                res.send("Hello, " + name + "!");
            })
            .build();

        WebServer server = WebServer.builder()
            .routing(routing)
            .port(8080)
            .build()
            .start();
        
        System.out.println("Server started at: http://localhost:8080");
    }
}
```

---
name: Æsh
status: Production-ready, Active
javaVersion: 8+
learningCurve: Easy-Moderate
lastRelease: v1.7 (aesh), v2.6 (readline)
learnMoreText: Æsh Documentation
learnMoreHref: https://aeshell.github.io/
image: images/ui-aesh.png
tags:
    - Terminal UI
dateAdded: 2026-02-19
---

Æsh (Another Extendable SHell) is a comprehensive Java library for building command-line interfaces, interactive shells, and terminal applications. The project consists of two complementary libraries: the high-level Æsh command framework with annotation-based command definitions, and the low-level Æsh Readline library for terminal input/output and line editing. Æsh provides automatic parsing, validation, type conversion, and help generation with support for command groups, subcommands, and unlimited nesting depth. The library offers GNU Readline compatibility with line editing in Emacs and Vi modes, persistent command history with search, customizable tab completion, syntax highlighting, and password masking. Cross-platform support includes POSIX systems and Windows, with additional remote connectivity via SSH, Telnet, and WebSocket servers. Used in production by WildFly application server CLI and JBoss Tools, Æsh is the standard choice for building sophisticated CLI tools, interactive shells, REPLs, build systems, deployment tools, and system administration utilities in Java.

## Code Example

```java
import org.aesh.command.*;
import org.aesh.command.impl.registry.AeshCommandRegistryBuilder;
import org.aesh.command.invocation.CommandInvocation;
import org.aesh.command.registry.CommandRegistry;
import org.aesh.readline.ReadlineConsole;
import org.aesh.readline.terminal.formatting.TerminalString;

@CommandDefinition(name = "greet", description = "Greet a user")
public class GreetCommand implements Command {
    
    @Option(shortName = 'n', description = "Name to greet")
    private String name;
    
    @Option(shortName = 'e', hasValue = false, 
            description = "Use enthusiastic greeting")
    private boolean enthusiastic;
    
    @Override
    public CommandResult execute(CommandInvocation invocation) {
        String greeting = enthusiastic ? 
            "Hello, " + (name != null ? name : "World") + "!!!" :
            "Hello, " + (name != null ? name : "World");
        invocation.println(greeting);
        return CommandResult.SUCCESS;
    }
    
    public static void main(String[] args) throws Exception {
        CommandRegistry registry = new AeshCommandRegistryBuilder()
            .command(GreetCommand.class)
            .create();
        ReadlineConsole console = new ReadlineConsole(registry);
        console.setPrompt("[aesh]$ ");
        console.start();
    }
}
```

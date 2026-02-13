---
name: JGoodies
status: Mature, Maintenance Mode
javaVersion: 6+ (8+ recommended)
learningCurve: Easy-Moderate
lastRelease: v1.9.0 (2016)
learnMoreText: JGoodies Website
learnMoreHref: https://www.jgoodies.com/
image: /images/ui-jgoodies.png
tags:
    - Desktop UI
    - UI Components
---

JGoodies is a collection of libraries that enhance Java Swing with better layouts, look-and-feels, data binding, and validation. The JGoodies Looks library provides professional-looking, platform-native-inspired themes that make Swing applications look significantly better than the default Metal theme. JGoodies Forms offers a powerful layout manager based on a grid system with support for growing/non-growing components, gaps, and separators—making complex forms much easier to create than with GridBagLayout. JGoodies Binding provides presentation model support with buffering, validation, and data synchronization between domain models and UI components. JGoodies Validation offers a consistent validation framework with visual feedback. While development has slowed (last major release in 2016), the libraries remain popular in enterprise Swing applications because they solve real pain points with minimal complexity. JGoodies is particularly valued for making Swing forms that look professional and are maintainable, addressing the historical criticism that Swing applications look dated or are hard to lay out properly.

## Code Example

```java
import com.jgoodies.forms.layout.*;
import com.jgoodies.forms.builder.FormBuilder;
import javax.swing.*;

public class HelloJGoodies {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JGoodies Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // JGoodies Forms - easy, powerful layout
        JPanel panel = FormBuilder.create()
            .columns("right:pref, 3dlu, pref:grow")
            .rows("p, 3dlu, p, 9dlu, p")
            .addLabel("Name:").xy(1, 1)
            .add(new JTextField()).xy(3, 1)
            .addLabel("Email:").xy(1, 3)
            .add(new JTextField()).xy(3, 3)
            .add(new JButton("Submit")).xy(3, 5)
            .build();
        
        frame.setContentPane(panel);
        frame.setSize(400, 200);
        frame.setVisible(true);
    }
}
```

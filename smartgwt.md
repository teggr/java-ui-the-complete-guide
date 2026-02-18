---
name: SmartGWT
status: Production-ready, Commercial & Open Source
javaVersion: 8+
learningCurve: Steep
lastRelease: v13.1 (2024)
learnMoreText: SmartGWT Website
learnMoreHref: https://www.smartclient.com/product/smartgwt.jsp
image: images/ui-smartgwt.png
tags:
    - Web UI
    - Web Framework
dateAdded: 2026-02-13
---

SmartGWT is a comprehensive GWT-based framework for building enterprise web applications with rich, desktop-like interfaces. It wraps the SmartClient JavaScript library, providing Java APIs for an extensive widget set including advanced data grids with inline editing, filtering, and grouping; tree grids; calendars; sophisticated form controls; and charting components. SmartGWT emphasizes data-driven applications with built-in support for RESTful services, SQL DataSources, and automatic data binding. The framework includes a visual design tool (Visual Builder), extensive documentation, and targets enterprise scenarios requiring complex data manipulation, batch editing, and rich client capabilities. Available in both open-source (LGPL) and commercial editions, SmartGWT is particularly popular in financial services, healthcare, and other enterprise domains where web applications need to match desktop application sophistication. The learning curve is steep due to the framework's comprehensive nature, but it provides capabilities difficult to achieve with lighter-weight frameworks, especially for data-intensive applications requiring advanced grid features.

## Code Example

```java
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.ListGridField;
import com.smartgwt.client.data.DataSource;

public class HelloSmartGWT implements EntryPoint {
    public void onModuleLoad() {
        // Advanced data grid with minimal code
        ListGrid grid = new ListGrid();
        grid.setWidth(600);
        grid.setHeight(400);
        grid.setShowFilterEditor(true);
        grid.setCanEdit(true);
        
        ListGridField nameField = new ListGridField("name", "Name");
        ListGridField emailField = new ListGridField("email", "Email");
        ListGridField roleField = new ListGridField("role", "Role");
        
        grid.setFields(nameField, emailField, roleField);
        grid.setDataSource(UserDataSource.getInstance());
        grid.setAutoFetchData(true);
        
        grid.draw();
    }
}

// Built-in: sorting, filtering, inline editing, 
// grouping, export, and more
```

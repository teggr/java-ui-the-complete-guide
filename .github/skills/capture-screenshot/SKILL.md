---
description: Capture a screenshot of a project's website and save it as a PNG image in the images folder. This skill navigates to the project's main page using web tools and captures a laptop-sized screenshot for use in the project documentation.
---

# Capture Screenshot Skill

This document describes the workflow for capturing screenshots of Java UI library project websites to use as visual documentation.

## Overview

When documenting a Java UI library, a screenshot of the project's main page provides visual context and helps users quickly understand what the library offers. This skill automates the process of navigating to a project website and capturing a properly-sized screenshot.

## Screenshot Requirements

### Image Specifications

- **Format**: PNG (for lossless quality and transparency support)
- **Aspect Ratio**: 16:10 or 16:9 (typical laptop display ratios)
- **Recommended Dimensions**: 1280x800px or 1920x1080px
- **File Naming**: `ui-{project-name}.png` where project-name is in kebab-case
- **Location**: `/images/` folder at project root

### What to Capture

Priority order for screenshot content:

1. **Hero Section** - Main landing page with logo, tagline, and key visuals
2. **Live Demo** - If the project has an interactive demo or example
3. **Feature Showcase** - Section highlighting main features with visuals
4. **Documentation Home** - If other options aren't visually appealing

**Capture Guidelines:**
- Focus on the most visually representative section
- Avoid excessive whitespace or empty areas
- Include recognizable branding (logo, name)
- Ensure text is readable at the captured size
- Capture in light mode unless dark mode is the primary theme

## Workflow Steps

### 1. Identify the Project and URL

First, determine:
- **Project name** (in kebab-case format for filename)
- **Website URL** (from the markdown file's `learnMoreHref` field or user input)
- **Target filename**: `ui-{project-name}.png`

```bash
# Example
Project: JavaFX
URL: https://openjfx.io
Filename: ui-javafx.png
```

### 2. Check for Existing Image

Before capturing, check if the image already exists:

```bash
# Check if file exists in images directory
if (Test-Path "images/ui-{project-name}.png") {
    Write-Host "Image already exists: images/ui-{project-name}.png"
    # Ask user for confirmation to overwrite
}
```

**Important**: If the image exists, ask the user for confirmation to overwrite before proceeding.

### 3. Navigate to Website Using Web Tools

Use available web browsing or screenshot capture tools to navigate to the project's URL:

**Recommended Tools:**
- Browser automation libraries (Playwright, Selenium, Puppeteer)
- Screenshot APIs (headless browsers, screenshot services)
- Command-line tools (wkhtmltoimage, shot-scraper, pageres-cli)

**Example using Playwright (Node.js)**:
```javascript
const { chromium } = require('playwright');

(async () => {
  const browser = await chromium.launch();
  const page = await browser.newPage();
  await page.setViewportSize({ width: 1280, height: 800 });
  await page.goto('https://example.com');
  await page.screenshot({ 
    path: 'images/ui-project.png',
    fullPage: false // Capture viewport only, not full page
  });
  await browser.close();
})();
```

**Example using shot-scraper (Python CLI)**:
```bash
shot-scraper "https://example.com" \
  --output "images/ui-project.png" \
  --width 1280 \
  --height 800 \
  --wait 2000
```

**Example using pageres-cli (Node.js CLI)**:
```bash
pageres "https://example.com" 1280x800 \
  --filename="ui-project" \
  --dest="images" \
  --format=png \
  --delay=2
```

### 4. Capture Strategy

When navigating to the website:

1. **Set Viewport Size**: 1280x800px or 1920x1080px
2. **Wait for Page Load**: Allow 2-3 seconds for JavaScript and images to load
3. **Scroll Position**: Capture the top of the page (hero section)
4. **Handle Modals**: Dismiss any cookie banners or modal popups if possible
5. **Capture**: Take screenshot of the viewport (not full page scroll)

### 5. Save the Screenshot

Save the captured screenshot to the correct location:

```bash
# Target path structure
C:\Users\robin\IdeaProjects\java-ui-the-complete-guide\images\ui-{project-name}.png
```

**Validation Steps:**
- Verify file was created successfully
- Check file size (should be > 50KB for reasonable quality)
- Optionally verify PNG format validity

### 6. Confirm Success

After capturing, inform the user:
```
✓ Screenshot captured successfully
  - URL: https://example.com
  - Saved to: images/ui-project.png
  - Size: 1280x800px
  - Format: PNG
```

## Tool Selection Guide

Choose the appropriate tool based on availability:

### Option 1: Playwright (Recommended)
**Pros**: Full browser automation, handles JavaScript, reliable
**Cons**: Requires Node.js and installation
```bash
npm install -D playwright
npx playwright install chromium
```

### Option 2: shot-scraper
**Pros**: Simple CLI, Python-based, good for quick captures
**Cons**: Requires Python and installation
```bash
pip install shot-scraper
shot-scraper install
```

### Option 3: pageres-cli
**Pros**: Simple CLI, flexible sizing options
**Cons**: Requires Node.js and installation
```bash
npm install -g pageres-cli
```

### Option 4: Screenshot API Services
**Pros**: No local installation, simple HTTP requests
**Cons**: Requires API key, network dependency, rate limits

Examples:
- screenshotapi.net
- apiflash.com
- screenshotmachine.com

```bash
# Example API call
curl "https://api.screenshotapi.net/screenshot?token=YOUR_TOKEN&url=https://example.com&output=image&file_type=png&wait_for_event=load" \
  -o images/ui-project.png
```

## Error Handling

### Common Issues and Solutions

**1. Website is unreachable or returns 404**
- Verify the URL is correct
- Check if the website is temporarily down
- Try an archived version from web.archive.org
- Inform user that screenshot capture failed

**2. Website requires JavaScript or has delayed loading**
- Increase wait time (--wait or --delay parameter)
- Use tools that support JavaScript (Playwright, not simple curl)

**3. Website blocks automated tools (bot detection)**
- Set user agent to a real browser
- Add random delays to appear more human
- Consider manual screenshot as fallback

**4. Image file is too large (>2MB)**
- Consider using JPG for photos/complex images
- Optimize PNG with tools like pngquant or optipng
- Reduce viewport size slightly

**5. Screenshot is blank or shows error page**
- Check if URL needs www prefix or protocol change (http vs https)
- Verify SSL certificates aren't blocking access
- Test URL manually in browser first

## Example: Complete Workflow

```bash
# Step 1: Check existing image
if exist "images\ui-javafx.png" (
    echo Image exists. Overwrite? [Y/N]
    # Wait for user confirmation
)

# Step 2: Install tool if needed (one-time)
npm install -g pageres-cli

# Step 3: Capture screenshot
pageres "https://openjfx.io" 1280x800 ^
  --filename="ui-javafx" ^
  --dest="images" ^
  --format=png ^
  --delay=2

# Step 4: Verify
if exist "images\ui-javafx.png" (
    echo ✓ Screenshot captured: images/ui-javafx.png
) else (
    echo ✗ Screenshot capture failed
)
```

## Integration with Project Workflow

This skill integrates with the add-project skill:

1. When creating a new project documentation file
2. After determining the project's URL (learnMoreHref field)
3. Use this skill to automatically capture the screenshot
4. Reference the image in the markdown front matter: `image: images/ui-{project}.png`

**Manual Fallback**: If automated screenshot capture fails:
1. Manually open the URL in a browser
2. Resize window to approximately 1280x800px
3. Use browser's built-in screenshot tool or OS screenshot tool
4. Save as PNG with correct naming in images folder

## Best Practices

1. **Consistent Sizing**: Always use same viewport dimensions (1280x800px recommended)
2. **Wait for Load**: Allow sufficient time for page to fully render
3. **Check Quality**: Verify screenshot is clear and representative
4. **Optimize Files**: Keep PNG files under 500KB when possible
5. **Update Regularly**: Re-capture screenshots when projects rebrand or update their websites
6. **Backup URLs**: Keep note of the URL and date captured for reference

## Requirements

**Tool Requirements** (choose one):
- Node.js 16+ (for Playwright or pageres-cli)
- Python 3.8+ (for shot-scraper)
- Internet connection for accessing websites

**Project Requirements**:
- Valid project URL
- Write access to `/images/` folder
- Confirmation from user if overwriting existing image


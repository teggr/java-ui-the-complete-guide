import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DownloadImages {
    public static void main(String[] args) throws IOException, InterruptedException {
    System.out.println("Downloading images from robintegg.com...");
    
    // Create images directory if it doesn't exist
    Path imagesDir = Paths.get("images");
    if (!Files.exists(imagesDir)) {
        Files.createDirectory(imagesDir);
        System.out.println("Created images directory");
    }
    
    // Pattern to find robintegg.com image URLs in markdown files
    Pattern imagePattern = Pattern.compile("image:\\s*https://robintegg\\.com/images/([^\\s\"]+)");
    
    // Set to store unique image filenames
    Set<String> imageFiles = new HashSet<>();
    
    // Find all markdown files and extract image URLs
    Files.list(Paths.get("."))
        .filter(path -> path.toString().endsWith(".md") && !path.getFileName().toString().equals("README.md"))
        .forEach(path -> {
            try {
                String content = Files.readString(path);
                Matcher matcher = imagePattern.matcher(content);
                while (matcher.find()) {
                    String imageFile = matcher.group(1);
                    imageFiles.add(imageFile);
                }
            } catch (IOException e) {
                System.err.println("Error reading file " + path + ": " + e.getMessage());
            }
        });
    
    System.out.println("Found " + imageFiles.size() + " unique images to download");
    
    // Download each image
    HttpClient client = HttpClient.newBuilder()
        .followRedirects(HttpClient.Redirect.NORMAL)
        .build();
    
    int downloaded = 0;
    int skipped = 0;
    
    for (String imageFile : imageFiles) {
        Path localPath = imagesDir.resolve(imageFile);
        
        // Skip if file already exists
        if (Files.exists(localPath)) {
            System.out.println("Skipping " + imageFile + " (already exists)");
            skipped++;
            continue;
        }
        
        String imageUrl = "https://robintegg.com/images/" + imageFile;
        System.out.println("Downloading " + imageUrl + " to " + localPath);
        
        try {
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(imageUrl))
                .GET()
                .build();
            
            HttpResponse<InputStream> response = client.send(request, HttpResponse.BodyHandlers.ofInputStream());
            
            if (response.statusCode() == 200) {
                Files.copy(response.body(), localPath, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Downloaded " + imageFile);
                downloaded++;
            } else {
                System.err.println("Failed to download " + imageFile + " (HTTP " + response.statusCode() + ")");
            }
        } catch (Exception e) {
            System.err.println("Error downloading " + imageFile + ": " + e.getMessage());
        }
    }
    
    System.out.println("\nDownload summary:");
    System.out.println("  Downloaded: " + downloaded);
    System.out.println("  Skipped: " + skipped);
    System.out.println("  Total: " + imageFiles.size());
    
    // Now update all markdown files to use local image paths
    System.out.println("\nUpdating markdown files to use local image paths...");
    
    Files.list(Paths.get("."))
        .filter(path -> path.toString().endsWith(".md") && !path.getFileName().toString().equals("README.md"))
        .forEach(path -> {
            try {
                String content = Files.readString(path);
                String originalContent = content;
                
                // Replace robintegg.com URLs with local paths
                content = content.replaceAll(
                    "image:\\s*https://robintegg\\.com/images/",
                    "image: /images/"
                );
                
                if (!content.equals(originalContent)) {
                    Files.writeString(path, content);
                    System.out.println("Updated " + path.getFileName());
                }
            } catch (IOException e) {
                System.err.println("Error updating file " + path + ": " + e.getMessage());
            }
        });
    
    System.out.println("\nImage download and markdown update completed!");
    }
}

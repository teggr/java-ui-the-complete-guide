/// usr/bin/env jbang "$0" "$@" ; exit $?
//JAVA 25+

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

void main(String... args) throws IOException, NoSuchAlgorithmException {
    
    System.out.println("Starting thumbnail generation...");
    
    Path imagesDir = Paths.get("images");
    Path hashFile = imagesDir.resolve(".thumbnail-hashes");
    
    if (!Files.exists(imagesDir)) {
        System.out.println("Images directory not found!");
        return;
    }
    
    // Load existing hashes
    Map<String, String> existingHashes = loadHashes(hashFile);
    Map<String, String> currentHashes = new HashMap<>();
    
    int generated = 0;
    int skipped = 0;
    
    // Process all PNG files in the images directory
    Files.list(imagesDir)
        .filter(path -> path.toString().toLowerCase().endsWith(".png"))
        .filter(path -> !path.getFileName().toString().startsWith("thumbnail-"))
        .filter(path -> !path.getFileName().toString().equals(".thumbnail-hashes"))
        .forEach(imagePath -> {
            try {
                String fileName = imagePath.getFileName().toString();
                System.out.println("Processing: " + fileName);
                
                // Calculate hash of the original image
                String imageHash = calculateHash(imagePath);
                currentHashes.put(fileName, imageHash);
                
                // Determine thumbnail filename
                String thumbnailBaseName = fileName.startsWith("ui-")
                    ? fileName.substring("ui-".length())
                    : fileName.substring(fileName.lastIndexOf('-') + 1);
                String thumbnailName = "thumbnail-" + thumbnailBaseName;
                Path thumbnailPath = imagesDir.resolve(thumbnailName);
                
                // Check if thumbnail needs to be generated
                String existingHash = existingHashes.get(fileName);
                if (existingHash != null && existingHash.equals(imageHash) && Files.exists(thumbnailPath)) {
                    System.out.println("  Skipped (unchanged): " + thumbnailName);
                    return;
                }
                
                // Generate thumbnail
                generateThumbnail(imagePath, thumbnailPath, 540);
                System.out.println("  Generated: " + thumbnailName);
                
            } catch (Exception e) {
                System.err.println("Error processing " + imagePath + ": " + e.getMessage());
                e.printStackTrace();
            }
        });
    
    // Save updated hashes
    saveHashes(hashFile, currentHashes);
    
    System.out.println("\nThumbnail generation completed!");
    System.out.println("Check the images directory for generated thumbnails.");
}

/**
 * Generate a thumbnail with a maximum height while maintaining aspect ratio
 */
private static void generateThumbnail(Path sourcePath, Path targetPath, int maxHeight) throws IOException {
    BufferedImage originalImage = ImageIO.read(sourcePath.toFile());
    
    if (originalImage == null) {
        throw new IOException("Unable to read image: " + sourcePath);
    }
    
    int originalWidth = originalImage.getWidth();
    int originalHeight = originalImage.getHeight();
    
    // Calculate new dimensions maintaining aspect ratio
    int newHeight = maxHeight;
    int newWidth = (int) ((double) originalWidth / originalHeight * maxHeight);
    
    // If the image is already smaller than maxHeight, use original dimensions
    if (originalHeight <= maxHeight) {
        newHeight = originalHeight;
        newWidth = originalWidth;
    }
    
    // Create thumbnail with high-quality scaling
    BufferedImage thumbnail = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
    Graphics2D g2d = thumbnail.createGraphics();
    
    // Enable high-quality rendering
    g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
    g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    
    g2d.drawImage(originalImage, 0, 0, newWidth, newHeight, null);
    g2d.dispose();
    
    // Write thumbnail to file
    ImageIO.write(thumbnail, "PNG", targetPath.toFile());
}

/**
 * Calculate SHA-256 hash of a file
 */
private static String calculateHash(Path filePath) throws IOException, NoSuchAlgorithmException {
    MessageDigest digest = MessageDigest.getInstance("SHA-256");
    byte[] fileBytes = Files.readAllBytes(filePath);
    byte[] hashBytes = digest.digest(fileBytes);
    
    // Convert to hex string
    StringBuilder hexString = new StringBuilder();
    for (byte b : hashBytes) {
        String hex = Integer.toHexString(0xff & b);
        if (hex.length() == 1) hexString.append('0');
        hexString.append(hex);
    }
    return hexString.toString();
}

/**
 * Load existing hashes from file
 */
private static Map<String, String> loadHashes(Path hashFile) throws IOException {
    Map<String, String> hashes = new HashMap<>();
    
    if (Files.exists(hashFile)) {
        Files.readAllLines(hashFile).forEach(line -> {
            String[] parts = line.split("=", 2);
            if (parts.length == 2) {
                hashes.put(parts[0], parts[1]);
            }
        });
    }
    
    return hashes;
}

/**
 * Save hashes to file
 */
private static void saveHashes(Path hashFile, Map<String, String> hashes) throws IOException {
    StringBuilder content = new StringBuilder();
    hashes.forEach((fileName, hash) -> {
        content.append(fileName).append("=").append(hash).append("\n");
    });
    Files.writeString(hashFile, content.toString());
}

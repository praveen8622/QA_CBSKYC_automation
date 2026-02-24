package utilities;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtil {

    private static final String BASE_RESOURCE_PATH = Paths.get(System.getProperty("user.dir"),
            "src", "test", "resources").toString();

    // Get file from src/test/resources
    public static String getFileFromResources(String relativePath) {

        Path fullPath = Paths.get(BASE_RESOURCE_PATH, relativePath);

        if (!Files.exists(fullPath)) {
            throw new RuntimeException("File not found: " + fullPath);
        }

        return fullPath.toAbsolutePath().toString();
    }

    // Validate file exists
    public static void validateFileExists(String filePath) {

        File file = new File(filePath);

        if (!file.exists() || !file.isFile()) {
            throw new RuntimeException("Upload failed. File invalid: " + filePath);
        }
    }
}
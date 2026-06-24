package utilities;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtil {

    public static String getFileFromResources(String relativePath) {
        // 1) Try classpath resolution (works in most environments)
        ClassLoader classLoader = FileUtil.class.getClassLoader();
        URL resourceUrl = classLoader.getResource(relativePath);

        if (resourceUrl != null) {
            try {
                String path = new File(resourceUrl.toURI()).getAbsolutePath();
                if (new File(path).exists()) {
                    return path;
                }
            } catch (URISyntaxException ignored) {
            }
        }

        // 2) Fallback: resolve from project-root/src/test/resources
        String base = Paths.get(System.getProperty("user.dir"), "src", "test", "resources").toString();
        Path fullPath = Paths.get(base, relativePath);
        if (Files.exists(fullPath)) {
            return fullPath.toAbsolutePath().toString();
        }

        throw new RuntimeException("File not found: " + relativePath +
                " (tried classpath and " + base + ")");
    }

    public static void validateFileExists(String filePath) {
        File file = new File(filePath);
        if (!file.exists() || !file.isFile()) {
            throw new RuntimeException("Upload failed. File invalid: " + filePath);
        }
    }
}
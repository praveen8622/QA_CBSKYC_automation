package utilities;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

public class FileUtil {

    // Get file from classpath (src/test/resources is on the classpath)
    public static String getFileFromResources(String relativePath) {
        ClassLoader classLoader = FileUtil.class.getClassLoader();
        URL resourceUrl = classLoader.getResource(relativePath);

        if (resourceUrl == null) {
            throw new RuntimeException("File not found in classpath: " + relativePath);
        }

        try {
            return new File(resourceUrl.toURI()).getAbsolutePath();
        } catch (URISyntaxException e) {
            throw new RuntimeException("Failed to decode resource URL: " + resourceUrl, e);
        }
    }

    // Validate file exists
    public static void validateFileExists(String filePath) {

        File file = new File(filePath);

        if (!file.exists() || !file.isFile()) {
            throw new RuntimeException("Upload failed. File invalid: " + filePath);
        }
    }
}
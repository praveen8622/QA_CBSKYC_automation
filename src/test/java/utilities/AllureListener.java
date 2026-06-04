package utilities;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import base.BaseTestSequential;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class AllureListener implements ITestListener {

    @Override
    public void onTestSuccess(ITestResult result) {
        // Attach video for passed tests
        attachVideoRecording(result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Object testClass = result.getInstance();
        WebDriver driver = ((BaseTestSequential) testClass).getDriver();

        // 1. Capture Screenshot only on failure
        if (driver != null) {
            saveScreenshotPNG(driver);
        }

        // 2. Attach video for failed tests
        attachVideoRecording(result.getMethod().getMethodName());
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Execution Video - {testName}", type = "video/avi")
    public byte[] attachVideo(byte[] videoBytes, String testName) {
        return videoBytes;
    }

    private void attachVideoRecording(String testName) {
        try {
            File recordingFolder = new File("./target/recordings/");
            File[] files = recordingFolder.listFiles((dir, name) -> name.toLowerCase().endsWith(".avi"));

            if (files != null && files.length > 0) {
                File targetVideo = null;

                // Match the recording with the active test method name
                for (File file : files) {
                    if (file.getName().contains(testName)) {
                        targetVideo = file;
                        break;
                    }
                }

                // Fallback: Grab the most recent file if naming mismatch occurs
                if (targetVideo == null) {
                    targetVideo = files[0];
                    for (File file : files) {
                        if (file.lastModified() > targetVideo.lastModified()) {
                            targetVideo = file;
                        }
                    }
                }

                // Stream the video bytes straight to Allure
                attachVideo(Files.readAllBytes(targetVideo.toPath()), testName);

                // Delete the local file so your framework directory doesn't bloat
                targetVideo.delete();
            }
        } catch (IOException e) {
            System.err.println("Failed to attach video to Allure: " + e.getMessage());
        }
    }
}
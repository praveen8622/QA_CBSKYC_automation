package base;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import helper.LoginHelper;
import utilities.ConfigReader;
import utilities.ScreenRecorderUtil;

public class BaseTestSequential {
    protected WebDriver driver;
    protected Properties prop;
    protected SoftAssert softAssert;

    @BeforeClass
    public void setUp() {
        prop = ConfigReader.getProperties();

        // Override with system properties if provided via -D flags
        String executionMode = System.getProperty("execution.mode",
                prop.getProperty("execution.mode", "LOCAL"));
        String remoteUrl = System.getProperty("selenium.remote.url",
                prop.getProperty("selenium.remote.url", ""));
        String browser = System.getProperty("browser",
                prop.getProperty("browser", "chrome"));
        String baseUrl = System.getProperty("baseUrl",
                prop.getProperty("baseUrl"));
        boolean headless = Boolean.parseBoolean(System.getProperty("headless",
                prop.getProperty("headless", "false")));

        if ("REMOTE".equalsIgnoreCase(executionMode)) {
            if (browser.equalsIgnoreCase("chrome")) {
                ChromeOptions options = new ChromeOptions();
                options.setExperimentalOption(
                        "excludeSwitches",
                        new String[]{"enable-automation"});
                options.setExperimentalOption(
                        "useAutomationExtension",
                        false);
                if (headless) {
                    options.addArguments("--headless=new", "--disable-gpu",
                            "--window-size=1920,1080", "--no-sandbox",
                            "--disable-dev-shm-usage");
                }
                try {
                    driver = new RemoteWebDriver(new URL(remoteUrl), options);
                    ((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
                } catch (MalformedURLException e) {
                    throw new RuntimeException("Invalid remote URL: " + remoteUrl, e);
                }
            } else if (browser.equalsIgnoreCase("firefox")) {
                FirefoxOptions options = new FirefoxOptions();
//                options.addPreference("security.enterprise_roots.enabled", true);
                if (headless) {
                    options.addArguments("-headless");
                }
                try {
                    driver = new RemoteWebDriver(new URL(remoteUrl), options);
                    ((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
                } catch (MalformedURLException e) {
                    throw new RuntimeException("Invalid remote URL: " + remoteUrl, e);
                }
            } else {
                throw new IllegalArgumentException("Invalid browser name: " + browser);
            }
        } else {
            if (browser.equalsIgnoreCase("chrome")) {
                ChromeOptions options = new ChromeOptions();
                options.setExperimentalOption(
                        "excludeSwitches",
                        new String[]{"enable-automation"});
                options.setExperimentalOption(
                        "useAutomationExtension",
                        false);
                if (headless) {
                    options.addArguments("--headless=new", "--disable-gpu",
                            "--window-size=1920,1080", "--no-sandbox",
                            "--disable-dev-shm-usage");
                }
                driver = new ChromeDriver(options);
            } else if (browser.equalsIgnoreCase("firefox")) {
                FirefoxOptions options = new FirefoxOptions();
//                options.addPreference("security.enterprise_roots.enabled", true);
                if (headless) {
                    options.addArguments("-headless");
                }
                driver = new FirefoxDriver(options);
            } else {
                throw new IllegalArgumentException("Invalid browser name: " + browser);
            }
        }

        driver.manage().window().maximize();
        driver.get(baseUrl);
        LoginHelper.login(driver);
    }

    @BeforeMethod
    public void startVideoRecord(Method method) {
        softAssert = new SoftAssert();
        // Starts recording automatically before every test execution
        // ScreenRecorderUtil.startRecording(method.getName());
    }

    @AfterMethod
    public void stopVideoRecord() {
        // Stops recording automatically after every test execution
        // ScreenRecorderUtil.stopRecording();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}
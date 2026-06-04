package base;

import java.lang.reflect.Method;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
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
        String browser = prop.getProperty("browser");
        String baseUrl = prop.getProperty("baseUrl");
        boolean headless = Boolean.parseBoolean(prop.getProperty("headless", "false"));

        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();

            // Remove the automation infobar
            options.setExperimentalOption(
                    "excludeSwitches",
                    new String[]{"enable-automation"});

            // Disable automation extension
            options.setExperimentalOption(
                    "useAutomationExtension",
                    false);

            if (headless) {
                options.addArguments("--headless=new", "--disable-gpu", "--window-size=1920,1080", "--no-sandbox", "--disable-dev-shm-usage");
            }
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            if (headless) {
                options.addArguments("-headless");
            }
            driver = new FirefoxDriver(options);
        } else {
            throw new IllegalArgumentException("Invalid browser name: " + browser);
        }

        driver.manage().window().maximize();
        driver.get(baseUrl);
        LoginHelper.login(driver);
    }

    @BeforeMethod
    public void startVideoRecord(Method method) {
        softAssert = new SoftAssert();
        // Starts recording automatically before every test execution
        ScreenRecorderUtil.startRecording(method.getName());
    }

    @AfterMethod
    public void stopVideoRecord() {
        // Stops recording automatically after every test execution
        ScreenRecorderUtil.stopRecording();
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
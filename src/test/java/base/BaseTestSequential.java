package base;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import helper.LoginHelper;
import utilities.ConfigReader;

public class BaseTestSequential {
    protected WebDriver driver;
    protected Properties prop;
    protected SoftAssert softAssert;

    @BeforeClass
    public void setUp() {
        prop = ConfigReader.getProperties();

        String browser = prop.getProperty("browser");
        String baseUrl = prop.getProperty("baseUrl");

        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else {
            throw new IllegalArgumentException("Invalid browser name: " + browser);
        }

        driver.manage().window().maximize();
        driver.get(baseUrl);
        LoginHelper.login(driver);
    }

    @BeforeMethod

    public void initSoftAssert() {
        softAssert = new SoftAssert();
    }

    @AfterMethod
    public void tearDownSoftAssert() {
        if (softAssert != null) {
            softAssert.assertAll();
        }
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

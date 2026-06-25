package helper;

import org.openqa.selenium.WebDriver;
import utilities.LoggerUtil;
import pages.LoginPage;
import utilities.ConfigReader;

public class LoginHelper {

    public static void login(WebDriver driver) {

        String username = ConfigReader.getProperty("username");
        String password = ConfigReader.getProperty("password");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);
        // loginPage.handlePasswordChangePopupIfPresent();

        if (loginPage.waitForLoginSuccess()) {
            LoggerUtil.info("Login successful");
        } else {
            LoggerUtil.info("Login failed: Dashboard not displayed");
        }
    }
}
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.WaitUtils;

public class LoginPage {
    private WaitUtils wait;

    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.xpath("//button [@type='submit']");
    private By signInButton = By.xpath("//button[contains(text(),'Sign In')]");
    private By dashboardHeader = By.xpath("//*[@id=\"root\"]/div/div[1]/img");

    // Password change popup
    private By passwordPopup = By.xpath("//h2[contains(text(),'Change your password')]");
    private By popupOkButton = By.xpath("//button[text()='OK']");

    public LoginPage(WebDriver driver) {

        this.wait = new WaitUtils(driver);
    }

    public void enterUsername(String username) {

        wait.waitForElementToBeClickable(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {

        wait.waitForElementToBeClickable(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        wait.waitForElementToBeClickable(loginButton).click();

    }

    public void clickSignInButton() {
        wait.waitForElementToBeClickable(signInButton).click();
    }

    public boolean waitForLoginSuccess() {
        return wait.waitForElementToBeVisible(dashboardHeader).isDisplayed();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
        clickSignInButton();

    }

    public void handlePasswordChangePopupIfPresent() {
        try {
            if (wait.waitForElementToBeVisible(passwordPopup).isDisplayed()) {
                wait.waitForElementToBeClickable(popupOkButton).click();
            }
        } catch (Exception e) {
            // Popup not present – safe to ignore
        }
    }

}

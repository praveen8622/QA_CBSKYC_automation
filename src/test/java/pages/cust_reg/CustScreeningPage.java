package pages.cust_reg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.BasePage;
import utilities.LoggerUtil;

public class CustScreeningPage extends BasePage {

    private By nameInputLocator = By.name("name");
    private By searchBtnLocator = By.xpath("//button[@title='Search']");
    private By screeningIdLocator = By.xpath("//p[normalize-space()='Master Screening ID']/following::p[1]");

    public CustScreeningPage(WebDriver driver) {
        super(driver);
    }

    public void enterFullName(String name) {
        LoggerUtil.info("Entering Full Name for screening: " + name);
        typeText(nameInputLocator, name);
    }

    public void clickSearch() {
        LoggerUtil.info("Clicking Search button in Screening page");
        click(searchBtnLocator);
    }

    public String getScreeningId() {
        wait.waitForElementToBeVisible(screeningIdLocator);
        String id = driver.findElement(screeningIdLocator).getText().trim();
        LoggerUtil.info("Captured Screening ID: " + id);
        return id;
    }
}

package pages.cust_reg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.BasePage;
import utilities.LoggerUtil;

public class CustCashFlowPage extends BasePage {

    // =================================================
    // Locators
    // =================================================
    private By addBtnLocator = By.xpath("//button[@title='Add']");

    private By headingNameContainerLocator = By
            .xpath("//input[@aria-label='Heading Name']/ancestor::div[contains(@class, 'container')]");
    private By headingNameInputLocator = By.xpath("//input[@aria-label='Heading Name']");

    private By frequencyContainerLocator = By
            .xpath("//input[@aria-label='Frequency']/ancestor::div[contains(@class, 'container')]");
    private By frequencyInputLocator = By.xpath("//input[@aria-label='Frequency']");

    private By amountInputLocator = By.xpath("//input[@aria-label='Amount']");

    private By saveBtnLocator = By.xpath("//button[normalize-space()='Save']");
    private By exitBtnLocator = By.xpath("//button[@title='Exit']");

    public CustCashFlowPage(WebDriver driver) {
        super(driver);
    }

    // =================================================
    // Actions
    // =================================================

    public void clickAdd() {
        LoggerUtil.info("Clicking 'Add' button for Cash Flow");
        click(addBtnLocator);
    }

    public void enterCashFlowDetails(String heading, String frequency, String amount) {
        LoggerUtil.info(
                "Entering Cash Flow Details: Heading=" + heading + ", Frequency=" + frequency + ", Amount=" + amount);

        selectFromReactSelect(headingNameContainerLocator, headingNameInputLocator, heading);
        selectFromReactSelect(frequencyContainerLocator, frequencyInputLocator, frequency);
        typeText(amountInputLocator, amount);
        assertValueEquals(amountInputLocator, amount, "Amount mismatch in Cash Flow");
    }

    public void clickSave() {
        LoggerUtil.info("Clicking 'Save' button in Cash Flow dialog");
        click(saveBtnLocator);
    }

    public void clickExit() {
        LoggerUtil.info("Clicking 'Exit' button in Cash Flow dialog");
        click(exitBtnLocator);
    }
}

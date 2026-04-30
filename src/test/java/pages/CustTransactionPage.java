package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.BasePage;
import utilities.LoggerUtil;

public class CustTransactionPage extends BasePage {

    // =================================================
    // Locators
    // =================================================
    private By transactionTabLocator = By.xpath("//p[contains(text(), 'Estimated Transaction')]");
    private By saveBtnLocator = By.xpath("//button[normalize-space()='Save']");

    public CustTransactionPage(WebDriver driver) {
        super(driver);
    }

    // =================================================
    // Actions
    // =================================================

    public void openTransactionFormPage() {
        LoggerUtil.info("Clicking 'Estimated Transaction' step");
        click(transactionTabLocator);
    }

    /**
     * Enters transaction details for a specific frequency row.
     * 
     * @param frequency The frequency label (e.g., "Daily", "Weekly", "Monthly")
     * @param isApplied Whether to check the "Is Applied?" checkbox
     * @param amount    The Max Tran Amount
     * @param count     The Max Tran Count
     */
    public void enterTransactionDetails(String frequency, boolean isApplied, String amount, String count) {
        LoggerUtil.info("Entering Transaction Details for Frequency: " + frequency);

        // Robust row locator using contains to handle subtle spacing or wraps
        // We wait for the specific row to be visible first
        String rowXpath = "//div[contains(@class,'grid')][.//span[contains(text(), '" + frequency + "')]]";
        By rowLocator = By.xpath(rowXpath);

        wait.waitForElementToBeVisible(rowLocator);

        By checkboxLocator = By.xpath(rowXpath + "//input[@type='checkbox']");
        By amountLocator = By.xpath(rowXpath + "//input[contains(@name, 'maxTranAmount')]");
        By countLocator = By.xpath(rowXpath + "//input[contains(@name, 'maxTranCount')]");

        // Use BasePage helper to handle checkbox
        LoggerUtil.info("Setting 'Is Applied?' to " + isApplied);
        setCheckbox(checkboxLocator, isApplied);

        if (isApplied) {
            // Enter Amount
            LoggerUtil.info("Entering Amount: " + amount);
            typeText(amountLocator, amount);
            assertValueEquals(amountLocator, amount, "Transaction Amount mismatch");
            // Enter Count
            LoggerUtil.info("Entering Count: " + count);
            typeText(countLocator, count);
            assertValueEquals(countLocator, count, "Transaction Count mismatch");
        }
    }

    public void clickSave() {
        LoggerUtil.info("Clicking 'Save' button on Transaction page");
        click(saveBtnLocator);
    }

}

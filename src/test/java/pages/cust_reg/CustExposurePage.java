package pages.cust_reg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.BasePage;
import utilities.LoggerUtil;

public class CustExposurePage extends BasePage {

    // =================================================
    // Locators
    // =================================================

    private By addBtnLocator = By.xpath("//button[@title='Add']");

    private By instTypeContainerBy = By
            .xpath("//input[@aria-label='Institution Type']/ancestor::div[contains(@class, 'container')]");
    private By instTypeInputBy = By.xpath("//input[@aria-label='Institution Type']");

    private By instNameInputBy = By.xpath("//input[@aria-label='Institution Name']");

    private By productTypeContainerBy = By
            .xpath("//input[@aria-label='Product Type Name']/ancestor::div[contains(@class, 'container')]");
    private By productTypeInputBy = By.xpath("//input[@aria-label='Product Type Name']");

    private By portfolioAmountInputBy = By.xpath("//input[@aria-label='Portfolio Amount']");
    private By averageIntRateInputBy = By.xpath("//input[@aria-label='Average Interest Rate']");
    private By servicePeriodInputBy = By.xpath("//input[@aria-label='Service Period Month']");

    private By saveBtnBy = By.xpath("//button[normalize-space()='Save']");

    public CustExposurePage(WebDriver driver) {
        super(driver);
    }

    // =================================================
    // Actions
    // =================================================

    public void clickAdd() {
        LoggerUtil.info("Clicking 'Add' button for Exposure details");
        click(addBtnLocator);
    }

    public void enterExposureDetails(String instType, String instName, String prodType, String portfolio, String rate,
            String period) {
        LoggerUtil.info("Entering Exposure Details: Institution=" + instName + ", Product=" + prodType);

        selectFromReactSelect(instTypeContainerBy, instTypeInputBy, instType);
        typeText(instNameInputBy, instName);
        assertValueEquals(instNameInputBy, instName, "Institution Name mismatch");
        selectFromReactSelect(productTypeContainerBy, productTypeInputBy, prodType);
        typeText(portfolioAmountInputBy, portfolio);
        assertValueEquals(portfolioAmountInputBy, portfolio, "Portfolio Amount mismatch");
        typeText(averageIntRateInputBy, rate);
        assertValueEquals(averageIntRateInputBy, rate, "Average Interest Rate mismatch");
        typeText(servicePeriodInputBy, period);
        assertValueEquals(servicePeriodInputBy, period, "Service Period mismatch");
    }

    public void clickSave() {
        LoggerUtil.info("Clicking 'Save' button in Exposure dialog");
        click(saveBtnBy);
    }
}

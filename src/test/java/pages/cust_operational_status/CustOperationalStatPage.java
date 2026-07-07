package pages.cust_operational_status;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;
import utilities.LoggerUtil;

public class CustOperationalStatPage extends BasePage {

    public CustOperationalStatPage(WebDriver driver) {
        super(driver);
    }

    // Locators for the CustOperationalStatPage
    By custCodeLocator = By.xpath("(//input[@role='combobox'])[1]");
    By custNameLocator = By.xpath("(//input[@role='combobox'])[2]");

    By statusCodeLocator = By.xpath("(//input[@role='combobox'])[3]");
    By statusNameLocator = By.xpath("(//input[@role='combobox'])[4]");
    By updateClauseLocator = By.name("remarks");
    By resetButtonLocator = By.xpath("//button[@title='Reset']");
    By saveButtonLocator = By.xpath("//button[@title='Save']");

    public void enterCustomerName(String customerName) {
        LoggerUtil.info("Entering Customer Name: " + customerName);
        selectFromDropdown(custNameLocator, customerName);
        assertValueEquals(custNameLocator, customerName, "Customer Name input value mismatch");
    }

    public void enterCustomerCode(String customerCode) {
        LoggerUtil.info("Entering Customer Code: " + customerCode);
        selectFromDropdown(custCodeLocator, customerCode);

        assertValueEquals(custCodeLocator, customerCode, "Customer Code input value mismatch");
    }

    public void enterStatusCode(String statusCode) {
        LoggerUtil.info("Entering Status Code: " + statusCode);
        selectFromDropdown(statusCodeLocator, statusCode);
        assertValueEquals(statusCodeLocator, statusCode, "Status Code input value mismatch");
    }

    public void enterStatusName(String statusName) {
        LoggerUtil.info("Entering Status Name: " + statusName);
        selectFromDropdown(statusNameLocator, statusName);
        assertValueEquals(statusNameLocator, statusName, "Status Name input value mismatch");
    }

    public void enterUpdateClause(String updateClause) {
        LoggerUtil.info("Entering Update Clause: " + updateClause);
        typeText(updateClauseLocator, updateClause);
        assertValueEquals(updateClauseLocator, updateClause, "Update Clause input value mismatch");
    }

    public void clickResetButton() {
        LoggerUtil.info("Clicking Reset Button");
        click(resetButtonLocator);
    }

    public void clickSaveButton() {
        LoggerUtil.info("Clicking Save Button");
        click(saveButtonLocator);
    }

}

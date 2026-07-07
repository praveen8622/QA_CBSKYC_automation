package pages.cust_reg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.BasePage;
import utilities.LoggerUtil;

public class CustRelationshipCommunication extends BasePage {

    // =================================================
    // Locators
    // =================================================
    private By communicationTabLocator = By.xpath("//button[normalize-space()='Communication']");

    private By addCommunicationBtnLocator = By.xpath(
            "//h4[normalize-space()='Relationship Communications']/ancestor::div[contains(@class,'flex')]//button[@title='Add']");

    private By communicationTypeInputLocator = By.xpath("//input[@aria-label='Device Type']");

    private By deviceNumberInputLocator = By.name("deviceNo");

    private By saveCommunicationBtnLocator = By.xpath("//button[normalize-space()='Save']");
    private By nextBtnLocator = By.xpath("//button[@title='Next']");

    public CustRelationshipCommunication(WebDriver driver) {
        super(driver);
    }

    // =================================================
    // Actions
    // =================================================

    public void clickCommunicationTab() {
        LoggerUtil.info("Clicking Communication tab");
        click(communicationTabLocator);
    }

    public void clickAddCommunication() {
        LoggerUtil.info("Clicking Add Communication button");
        click(addCommunicationBtnLocator);
    }

    public void selectCommunicationType(String type) {
        LoggerUtil.info("Selecting Communication Type: " + type);
        selectFromDropdown(communicationTypeInputLocator, type);
    }

    public void enterCommunicationNumber(String number) {
        LoggerUtil.info("Entering Communication Number: " + number);
        typeText(deviceNumberInputLocator, number);
        assertValueEquals(deviceNumberInputLocator, number, "Relationship Communication Number mismatch");
    }

    public void clickSaveCommunication() {
        LoggerUtil.info("Clicking Save button in Communication form");
        click(saveCommunicationBtnLocator);
    }

    public void clickNext() {
        LoggerUtil.info("Clicking Next button in Communication form");
        click(nextBtnLocator);
    }
}

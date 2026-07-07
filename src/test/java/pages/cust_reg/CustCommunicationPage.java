package pages.cust_reg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.BasePage;
import utilities.LoggerUtil;

public class CustCommunicationPage extends BasePage {

    public CustCommunicationPage(WebDriver driver) {
        super(driver);
    }

    // ======================================
    // Locators
    // ======================================
    private By addCommunicationLocator = By.xpath("//button[@title='Add']");

    private By deviceTypeLocator = By.xpath("//input[@aria-label='Device Type']");

    private By isPersonalDeviceContainerLocator = By
            .xpath("//input[@aria-label='Is Device Personal']/ancestor::div[contains(@class,'control')]");
    private By isPersonalDeviceLocator = By.xpath("//input[@aria-label='Is Device Personal']");

    private By priorityOrderLocator = By.xpath("//input[@name='priority']");

    private By deviceNumLocator = By.xpath("//input[@name='deviceNo']");

    private By isAlertTypeCheckboxLocator = By.xpath("//input[@name='isAlertTypeDevice' and @type='checkbox']");

    private By exitButtonLocator = By.xpath("//button[.//text()[normalize-space()='Exit']]");

    private By resetButtonLocator = By.xpath("//button[.//text()[normalize-space()='Reset']]");

    private By saveButtonLocator = By.xpath("//button[@type='submit' and .//text()[normalize-space()='Save']]");

    private By nextButtonLocator = By.xpath("//button[@title='Next Step']");

    // ===============================
    // Actions
    // ===============================
    public void openAddCommunicationForm() {
        LoggerUtil.info("Clicking 'Add' button to open Communication Form");
        click(addCommunicationLocator);
    }

    public void selectIsPersonalDevice(String value) {
        LoggerUtil.info("Selecting '" + value + "' from 'Is Personal Device' dropdown");
        selectFromReactSelect(
                isPersonalDeviceContainerLocator,
                isPersonalDeviceLocator,
                value);

    }

    public void selectDevice(String deviceTypeValue) {
        LoggerUtil.info("Selecting '" + deviceTypeValue + "' from Device Type dropdown");
        selectFromDropdown(deviceTypeLocator, deviceTypeValue);
    }

    public void enterPriorityOrder(String priority) {
        LoggerUtil.info("Typing '" + priority + "' into Priority Order field");
        typeText(priorityOrderLocator, priority);
        assertValueEquals(priorityOrderLocator, priority,
                "Priority Order value mismatch");
    }

    public void enterDeviceNumber(String deviceNumber) {
        LoggerUtil.info("Typing '" + deviceNumber + "' into Device Number field");
        typeText(deviceNumLocator, deviceNumber);
        assertValueEquals(deviceNumLocator, deviceNumber,
                "Device Number value mismatch");
    }

    public void setAlertTypeDevice(boolean shouldBeChecked) {
        LoggerUtil.info((shouldBeChecked ? "Checking" : "Unchecking") + " 'Alert Type Device' checkbox");
        setCheckbox(isAlertTypeCheckboxLocator, shouldBeChecked);
    }

    public void clickExitButton() {
        LoggerUtil.info("Clicking 'Exit' button");
        click(exitButtonLocator);
    }

    public void clickResetButton() {
        LoggerUtil.info("Clicking 'Reset' button");
        click(resetButtonLocator);
    }

    public void clickSaveButton() {
        LoggerUtil.info("Clicking 'Save' button");
        click(saveButtonLocator);
    }

    public void clickNextbutton() {
        LoggerUtil.info("Clicking 'Next' button");
        click(nextButtonLocator);
    }

    // ===============================
    // Composite Method
    // ===============================
    public void fillCommunicationDetails(
            String deviceType,
            String isPersonal,
            String priority,
            String deviceNumber,
            boolean isAlertType) throws InterruptedException {

        // selectDeviceType(deviceType);
        // Thread.sleep(3000);
        // selectIsPersonalDevice(isPersonal);

        enterPriorityOrder(priority);

        enterDeviceNumber(deviceNumber);
        setAlertTypeDevice(isAlertType);

    }
}

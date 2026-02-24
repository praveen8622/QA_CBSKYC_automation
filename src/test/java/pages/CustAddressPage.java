package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.BasePage;
import utilities.LoggerUtil;

public class CustAddressPage extends BasePage {

    // ================================
    // Locators
    // ================================
    private By addAddressLocator = By.xpath("//button[@title='Add']");

    private By addressTypeContainerLocator = By
            .xpath("//input[@name='addressTypeId']/ancestor::div[contains(@class, 'container')]");
    private By addressTypeInputLocator = By.xpath(
            "//input[@name='addressTypeId']/ancestor::div[contains(@class, 'container')]//input[not(@type='hidden')]");

    private By stateContainerLocator = By
            .xpath("//input[@name='stateId']/ancestor::div[contains(@class, 'container')]");
    private By stateInputLocator = By
            .xpath("//input[@name='stateId']/ancestor::div[contains(@class, 'container')]//input[not(@type='hidden')]");

    private By districtContainerLocator = By
            .xpath("//input[@name='districtId']/ancestor::div[contains(@class, 'container')]");
    private By districtInputLocator = By.xpath(
            "//input[@name='districtId']/ancestor::div[contains(@class, 'container')]//input[not(@type='hidden')]");

    private By localBodyContainerLocator = By
            .xpath("//input[@name='townshipId']/ancestor::div[contains(@class, 'container')]");
    private By localBodyInputLocator = By.xpath(
            "//input[@name='townshipId']/ancestor::div[contains(@class, 'container')]//input[not(@type='hidden')]");

    private By postalCodeInputLocator = By.name("postalCode");
    private By streetInputLocator = By.name("street");
    private By wardNoInputLocator = By.name("wardNo");
    private By houseNoInputLocator = By.name("houseNo");
    private By latitudeInputLocator = By.name("latitude");
    private By longitudeInputLocator = By.name("longitude");

    private By openMapButtonLocator = By.xpath("//button[@title='Open Map']");
    private By imageUploadInputLocator = By.cssSelector("input[type='file']");

    private By exitButtonLocator = By.xpath("//button[@title='Exit']");
    private By resetButtonLocator = By.xpath("//button[.//div[text()='Reset']]");
    private By saveButtonLocator = By.xpath("//button[.//div[text()='Save']]");
    private By nextButtonLocator = By.xpath("//button[@title='Next Step']");

    // ================================
    // Constructor
    // ================================
    public CustAddressPage(WebDriver driver) {
        super(driver);
    }

    // ================================
    // Actions
    // ================================
    public void openAddAddressForm() {
        LoggerUtil.info("Clicking 'Add' button to open Address Form");
        click(addAddressLocator);
    }

    public void selectAddressType(String value) {
        LoggerUtil.info("Selecting '" + value + "' from Address Type dropdown");
        selectFromReactSelect(addressTypeContainerLocator, addressTypeInputLocator, value);
    }

    public void selectState(String value) {
        LoggerUtil.info("Selecting '" + value + "' from State dropdown");
        selectFromReactSelect(stateContainerLocator, stateInputLocator, value);
    }

    public void selectDistrict(String value) {
        LoggerUtil.info("Selecting '" + value + "' from District dropdown");
        selectFromReactSelect(districtContainerLocator, districtInputLocator, value);
    }

    public void selectLocalBody(String value) {
        LoggerUtil.info("Selecting '" + value + "' from Local Body dropdown");
        selectFromReactSelect(localBodyContainerLocator, localBodyInputLocator, value);
    }

    public void enterPostalCode(String postalCode) {
        LoggerUtil.info("Typing '" + postalCode + "' into Postal Code field");
        typeText(postalCodeInputLocator, postalCode);
        assertValueEquals(postalCodeInputLocator, postalCode, "Postal Code mismatch");
    }

    public void enterStreet(String street) {
        LoggerUtil.info("Typing '" + street + "' into Street field");
        typeText(streetInputLocator, street);
        assertValueEquals(streetInputLocator, street, "Street mismatch");
    }

    public void enterWardNo(String wardNo) {
        LoggerUtil.info("Typing '" + wardNo + "' into Ward No field");
        typeText(wardNoInputLocator, wardNo);
        assertValueEquals(wardNoInputLocator, wardNo, "Ward No mismatch");
    }

    public void enterHouseNo(String houseNo) {
        LoggerUtil.info("Typing '" + houseNo + "' into House No field");
        typeText(houseNoInputLocator, houseNo);
        assertValueEquals(houseNoInputLocator, houseNo, "House No mismatch");
    }

    public void clickOpenMap() {
        LoggerUtil.info("Clicking 'Open Map' button");
        click(openMapButtonLocator);
    }

    public void enterLatitude(String latitude) {
        LoggerUtil.info("Typing '" + latitude + "' into Latitude field");
        typeText(latitudeInputLocator, latitude);
        assertValueEquals(latitudeInputLocator, latitude, "Latitude mismatch");
    }

    public void enterLongitude(String longitude) {
        LoggerUtil.info("Typing '" + longitude + "' into Longitude field");
        typeText(longitudeInputLocator, longitude);
        assertValueEquals(longitudeInputLocator, longitude, "Longitude mismatch");
    }

    public void uploadAddressDocument(String filePath) {
        LoggerUtil.info("Uploading Address Document from path: " + filePath);
        uploadFile(imageUploadInputLocator, filePath);
    }

    public void clickSave() {
        LoggerUtil.info("Clicking 'Save' button on Address page");
        click(saveButtonLocator);
    }

    public void clickReset() {
        LoggerUtil.info("Clicking 'Reset' button on Address page");
        click(resetButtonLocator);
    }

    public void clickExit() {
        LoggerUtil.info("Clicking 'Exit' button on Address page");
        click(exitButtonLocator);
    }

    public void clickNext() {
        LoggerUtil.info("Clicking 'Next' button on Address page");
        click(nextButtonLocator);
    }

}

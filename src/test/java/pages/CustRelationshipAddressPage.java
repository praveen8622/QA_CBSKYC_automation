package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.BasePage;
import utilities.LoggerUtil;

public class CustRelationshipAddressPage extends BasePage {

    // =================================================
    // Locators
    // =================================================
    private By addressTabLocator = By.xpath("//button[normalize-space()='Address']");

    private By addAddressBtnLocator = By.xpath(
            "//h4[normalize-space()='Relationship Address']/ancestor::div[contains(@class,'flex')]//button[@title='Add']");

    private By addressTypeContainerLocator = By
            .xpath("//input[@aria-label='Address Type']/ancestor::div[contains(@class, 'container')]");
    private By addressTypeInputLocator = By.xpath("//input[@aria-label='Address Type']");

    private By stateContainerLocator = By
            .xpath("//input[@aria-label='State']/ancestor::div[contains(@class, 'container')]");
    private By stateInputLocator = By.xpath("//input[@aria-label='State']");

    private By districtContainerLocator = By
            .xpath("//input[@aria-label='District']/ancestor::div[contains(@class, 'container')]");
    private By districtInputLocator = By.xpath("//input[@aria-label='District']");

    private By townshipContainerLocator = By
            .xpath("//input[@aria-label='Local Body']/ancestor::div[contains(@class, 'container')]");
    private By townshipInputLocator = By.xpath("//input[@aria-label='Local Body']");

    private By quarterContainerLocator = By
            .xpath("//input[@aria-label='Quarter']/ancestor::div[contains(@class, 'container')]");
    private By quarterInputLocator = By.xpath("//input[@aria-label='Quarter']");

    private By postalCodeInputLocator = By.name("postalCode");
    private By streetInputLocator = By.name("street");
    private By wardNoInputLocator = By.name("wardNo");
    private By houseNoInputLocator = By.name("houseNo");
    private By latitudeInputLocator = By.name("latitude");
    private By longitudeInputLocator = By.name("longitude");

    private By fileUploadInputLocator = By.xpath("//input[@type='file']");
    private By saveBtnLocator = By.xpath("//button[normalize-space()='Save']");
    private By nextBtnLocator = By.xpath("//button[@title='Next']");

    public CustRelationshipAddressPage(WebDriver driver) {
        super(driver);
    }

    // =================================================
    // Actions
    // =================================================

    public void clickAddressTab() {
        LoggerUtil.info("Clicking Address tab");
        click(addressTabLocator);
    }

    public void clickAddAddress() {
        LoggerUtil.info("Clicking Add Address button");
        click(addAddressBtnLocator);
    }

    public void selectAddressType(String type) {
        LoggerUtil.info("Selecting Address Type: " + type);
        selectFromReactSelect(addressTypeContainerLocator, addressTypeInputLocator, type);
    }

    public void selectState(String state) {
        LoggerUtil.info("Selecting State: " + state);
        selectFromReactSelect(stateContainerLocator, stateInputLocator, state);
    }

    public void selectDistrict(String district) {
        LoggerUtil.info("Selecting District: " + district);
        selectFromReactSelect(districtContainerLocator, districtInputLocator, district);
    }

    public void selectTownship(String township) {
        LoggerUtil.info("Selecting Township: " + township);
        selectFromReactSelect(townshipContainerLocator, townshipInputLocator, township);
    }

    public void selectQuarter(String quarter) {
        LoggerUtil.info("Selecting Quarter: " + quarter);
        selectFromReactSelect(quarterContainerLocator, quarterInputLocator, quarter);
    }

    public void enterPostalCode(String code) {
        LoggerUtil.info("Entering Postal Code: " + code);
        typeText(postalCodeInputLocator, code);
        assertValueEquals(postalCodeInputLocator, code, "Relationship Postal Code mismatch");
    }

    public void enterStreet(String street) {
        LoggerUtil.info("Entering Street: " + street);
        typeText(streetInputLocator, street);
        assertValueEquals(streetInputLocator, street, "Relationship Street mismatch");
    }

    public void enterWardNo(String ward) {
        LoggerUtil.info("Entering Ward No: " + ward);
        typeText(wardNoInputLocator, ward);
        assertValueEquals(wardNoInputLocator, ward, "Relationship Ward No mismatch");
    }

    public void enterHouseNo(String house) {
        LoggerUtil.info("Entering House No: " + house);
        typeText(houseNoInputLocator, house);
        assertValueEquals(houseNoInputLocator, house, "Relationship House No mismatch");
    }

    public void enterLatitude(String lat) {
        LoggerUtil.info("Entering Latitude: " + lat);
        typeText(latitudeInputLocator, lat);
    }

    public void enterLongitude(String lon) {
        LoggerUtil.info("Entering Longitude: " + lon);
        typeText(longitudeInputLocator, lon);
    }

    public void uploadDocument(String filePath) {
        LoggerUtil.info("Uploading document: " + filePath);
        uploadFile(fileUploadInputLocator, filePath);
    }

    public void clickSave() {
        LoggerUtil.info("Clicking Save button in Relationship Address form");
        click(saveBtnLocator);
    }

    public void clickNext() {
        LoggerUtil.info("Clicking Next button in Relationship Address form");
        click(nextBtnLocator);
    }
}

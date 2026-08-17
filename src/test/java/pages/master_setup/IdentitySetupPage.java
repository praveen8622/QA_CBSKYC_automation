package pages.master_setup;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import base.BasePage;
import utilities.LoggerUtil;

public class IdentitySetupPage extends BasePage {

    public IdentitySetupPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    private By addBtnLocator = By.xpath("(//button[@type='submit'])[2]");
    private By identityTypeNameInputLocator = By.name("identityTypeName");
    private By identityNameAliasInputLocator = By.name("identityTypeAlias");
    private By parentIdentityNameComboboxLocator = By.xpath("//input[@aria-label='Parent Identity Name']");
    private By identityTypeOptionComboboxLocator = By.xpath("//input[@aria-label='issueOfficeOptionScope']");
    private By identityTypeIssueLocator = By.xpath("//input[@aria-label='officeTypeCode']");
    private By isExpiryCheckboxLocator = By.xpath("//input[@aria-label='isIdentityTypeExpiryDateBased']");
    private By identityLifeInputLocator = By.name("identityTypeLifeDays");
    private By identityTypeDocTypeComboboxLocator = By.xpath("//input[@aria-label='identityTypeDocTypeId']");
    private By saveBtnLocator = By.xpath("(//button[@type='submit'])[2]");
    private By searchInputLocator = By.xpath("//input[@placeholder='Search here']");
    private By loadDataBtnLocator = By.xpath("//div[text()='Load Data']");
    private By exitBtnLocator = By.xpath("(//button[@data-hot-keys='EXIT'])[2]");

    // Interaction Methods
    public void clickAdd() {
        click(addBtnLocator);
    }

    public void enterIdentityTypeName(String name) {
        typeText(identityTypeNameInputLocator, name);
    }

    public void enterIdentityNameAlias(String alias) {
        typeText(identityNameAliasInputLocator, alias);
    }

    public void selectParentIdentityName(String name) {
        selectFromDropdown(parentIdentityNameComboboxLocator, name);
    }

    public void selectIdentityTypeOption(String option) {
        selectFromDropdown(identityTypeOptionComboboxLocator, option);

    }

    public void selectIdentityTypeIssue(String issue) {
        String currentValue = driver.findElement(identityTypeOptionComboboxLocator).getText();
        if (!currentValue.equals("Open Office")) {
            selectFromDropdown(identityTypeIssueLocator, issue);

        } else {
            LoggerUtil.info("Identity Type Option is 'Open Office', skipping selection of Identity Type Issue.");
        }

    }

    public void clickIsExpiry(String isExpiry) {
        selectFromDropdown(isExpiryCheckboxLocator, isExpiry);
    }

    public void enterIdentityLife(String days) {
        typeText(identityLifeInputLocator, days);
    }

    public void selectIdentityTypeDocType(String docType) {
        selectFromDropdown(identityTypeDocTypeComboboxLocator, docType);

    }

    public void clickSave() {
        click(saveBtnLocator);
    }

    public void searchIdentity(String searchText) {
        typeText(searchInputLocator, searchText);
    }

    public void clickLoadData() {
        click(loadDataBtnLocator);
    }

    public void clickExit() {
        click(exitBtnLocator);
    }

    // ================================
    // Table Actions
    // ================================

    public void clickEditIdentity(String identityName) {
        By editBtnLocator = By.xpath("(//td[text()='" + identityName + "']/following-sibling::td//button)[1]");
        click(editBtnLocator);
    }

    public void clickViewIdentity(String identityName) {
        By viewBtnLocator = By.xpath("(//td[text()='" + identityName + "']/following-sibling::td//button)[2]");
        click(viewBtnLocator);
    }

    public void clickDeleteIdentity(String identityName) {
        By deleteBtnLocator = By.xpath("(//td[text()='" + identityName + "']/following-sibling::td//button)[3]");
        click(deleteBtnLocator);
    }
}

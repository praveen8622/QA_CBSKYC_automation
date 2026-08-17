package pages.master_setup;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import base.BasePage;

public class CountrySetupPage extends BasePage {

    public CountrySetupPage(WebDriver driver) {
        super(driver);
    }

    // ================================
    // Locators
    // ================================
    private By addBtnLocator = By.xpath("(//button[@type='submit'])[2]");
    private By saveBtnLocator = By.xpath("//div[text()='Save']");
    private By updateBtnLocator = By.xpath("//div[text()='Update']");

    private By countryCodeInputLocator = By.name("countryCode");
    private By countryNameInputLocator = By.name("countryName");
    private By aliasInputLocator = By.name("countryAlias");
    private By isoCodeInputLocator = By.name("isoCode");
    private By nationalityInputLocator = By.name("nationalityName");
    private By permanentResidentNameInputLocator = By.name("permanentResidentName");
    private By officialLanguageComboboxLocator = By.xpath("(//input[@role='combobox'])");

    private By searchInputLocator = By.xpath("//input[@placeholder='Search here']");
    private By loadDataBtnLocator = By.xpath("//div[text()='Load Data']");
    private By exitBtnLocator = By.xpath("//button[@data-hot-keys='EXIT']");
    private By confirmDeleteBtnLocator = By.xpath("//button[@data-hot-keys='DELETE']");

    // ================================
    // Page Interaction Methods
    // ===============================

    public void clickAdd() {
        click(addBtnLocator);
    }

    public void enterCountryCode(String countryCode) {
        typeText(countryCodeInputLocator, countryCode);
    }

    public void enterCountryName(String countryName) {
        typeText(countryNameInputLocator, countryName);
    }

    public void enterAlias(String alias) {
        typeText(aliasInputLocator, alias);
    }

    public void enterIsoCode(String isoCode) {
        typeText(isoCodeInputLocator, isoCode);
    }

    public void enterNationality(String nationality) {
        typeText(nationalityInputLocator, nationality);
    }

    public void enterPermanentResidentName(String name) {
        typeText(permanentResidentNameInputLocator, name);
    }

    public void selectOfficialLanguage(String language) {
        selectFromDropdown(officialLanguageComboboxLocator, language);
    }

    public void clickSave() {
        click(saveBtnLocator);
    }

    public void clickUpdate() {
        click(updateBtnLocator);
    }

    public void searchCountry(String searchText) {
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

    public void clickEditCountry(String countryName) {
        By editBtnLocator = By.xpath("(//td[text()='" + countryName + "']/following-sibling::td//button)[1]");
        click(editBtnLocator);
    }

    public void clickViewCountry(String countryName) {
        By viewBtnLocator = By.xpath("(//td[text()='" + countryName + "']/following-sibling::td//button)[2]");
        click(viewBtnLocator);
    }

    public void clickDeleteCountry(String countryName) {
        By deleteBtnLocator = By.xpath("(//td[text()='" + countryName + "']/following-sibling::td//button)[3]");
        click(deleteBtnLocator);
    }

    public void clickConfirmDelete() {
        click(confirmDeleteBtnLocator);
    }
}

package pages.cust_reg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.BasePage;
import utilities.LoggerUtil;

public class CustHighProfilePage extends BasePage {

    // ================================
    // Locators
    // ================================

    // Checkbox
    private By isHighProfileCheckboxLocator = By.name("isHighProfilePersonCustomer");
    private By addHighProfileFormLocator = By.xpath("//button[@title='Add']");
    // Text Inputs
    private By fullNameInputLocator = By.name("fullName");
    private By fullNameLocalInputLocator = By.name("fullNameLocal");
    private By positionInputLocator = By.name("position");

    // React Select Containers & Inputs
    private By genderContainerLocator = By
            .xpath("//input[@name='genderId']/ancestor::div[contains(@class, 'container')]");
    private By genderInputLocator = By.xpath(
            "//input[@name='genderId']/ancestor::div[contains(@class, 'container')]//input[not(@type='hidden')]");

    private By relationContainerLocator = By
            .xpath("//input[@name='relationId']/ancestor::div[contains(@class, 'container')]");
    private By relationInputLocator = By.xpath(
            "//input[@name='relationId']/ancestor::div[contains(@class, 'container')]//input[not(@type='hidden')]");

    private By occupationContainerLocator = By
            .xpath("//input[@name='occupationId']/ancestor::div[contains(@class, 'container')]");
    private By occupationInputLocator = By.xpath(
            "//input[@name='occupationId']/ancestor::div[contains(@class, 'container')]//input[not(@type='hidden')]");

    private By citizenshipCategoryContainerLocator = By
            .xpath("//input[@name='citizenshipCategoryCode']/ancestor::div[contains(@class, 'container')]");
    private By citizenshipCategoryInputLocator = By.xpath(
            "//input[@name='citizenshipCategoryCode']/ancestor::div[contains(@class, 'container')]//input[not(@type='hidden')]");

    private By primaryCitizenCountryContainerLocator = By
            .xpath("//input[@name='primaryCitizenCountryId']/ancestor::div[contains(@class, 'container')]");
    private By primaryCitizenCountryInputLocator = By.xpath(
            "//input[@name='primaryCitizenCountryId']/ancestor::div[contains(@class, 'container')]//input[not(@type='hidden')]");

    private By secondaryCitizenCountryContainerLocator = By
            .xpath("//input[@name='secondaryCitizenCountryId']/ancestor::div[contains(@class, 'container')]");
    private By secondaryCitizenCountryInputLocator = By.xpath(
            "//input[@name='secondaryCitizenCountryId']/ancestor::div[contains(@class, 'container')]//input[not(@type='hidden')]");

    private By residentCountryContainerLocator = By
            .xpath("//input[@name='residentCountryId']/ancestor::div[contains(@class, 'container')]");
    private By residentCountryInputLocator = By.xpath(
            "//input[@name='residentCountryId']/ancestor::div[contains(@class, 'container')]//input[not(@type='hidden')]");

    private By prCountryContainerLocator = By
            .xpath("//input[@name='prCountryId']/ancestor::div[contains(@class, 'container')]");
    private By prCountryInputLocator = By.xpath(
            "//input[@name='prCountryId']/ancestor::div[contains(@class, 'container')]//input[not(@type='hidden')]");

    private By educationContainerLocator = By
            .xpath("//input[@name='educationId']/ancestor::div[contains(@class, 'container')]");
    private By educationInputLocator = By.xpath(
            "//input[@name='educationId']/ancestor::div[contains(@class, 'container')]//input[not(@type='hidden')]");

    // Buttons
    private By exitButtonLocator = By.xpath("//button[@title='Exit']");
    private By resetButtonLocator = By.xpath("//button[.//div[text()='Reset']]");
    private By saveButtonLocator = By.xpath("//button[.//div[text()='Save']]");
    private By nextButtonLocator = By.xpath("//button[@title='Next Step']");

    // ================================
    // Constructor
    // ================================
    public CustHighProfilePage(WebDriver driver) {
        super(driver);
    }

    // ================================
    // Actions
    // ================================\
    public void openAddHighProfileForm() {
        LoggerUtil.info("Clicking 'Add' button to open High Profile Form");
        click(addHighProfileFormLocator);
    }

    public void checkIsHighProfile(boolean shouldCheck) {
        LoggerUtil.info((shouldCheck ? "Checking" : "Unchecking") + " 'Is High Profile' checkbox");
        setCheckbox(isHighProfileCheckboxLocator, shouldCheck);
    }

    public void enterFullName(String fullName) {
        LoggerUtil.info("Typing '" + fullName + "' into Full Name field");
        typeText(fullNameInputLocator, fullName);
        assertValueEquals(fullNameInputLocator, fullName, "Full Name mismatch");
    }

    public void enterFullNameLocal(String fullNameLocal) {
        LoggerUtil.info("Typing '" + fullNameLocal + "' into Full Name (Local) field");
        typeText(fullNameLocalInputLocator, fullNameLocal);
        assertValueEquals(fullNameLocalInputLocator, fullNameLocal, "Full Name (Local) mismatch");
    }

    public void selectGender(String gender) {
        LoggerUtil.info("Selecting '" + gender + "' from Gender dropdown");
        selectFromReactSelect(genderContainerLocator, genderInputLocator, gender);
    }

    public void selectRelation(String relation) {
        LoggerUtil.info("Selecting '" + relation + "' from Relation dropdown");
        selectFromReactSelect(relationContainerLocator, relationInputLocator, relation);
    }

    public void selectOccupation(String occupation) {
        LoggerUtil.info("Selecting '" + occupation + "' from Occupation dropdown");
        selectFromReactSelect(occupationContainerLocator, occupationInputLocator, occupation);
    }

    public void selectCitizenshipCategory(String category) {
        LoggerUtil.info("Selecting '" + category + "' from Citizenship Category dropdown");
        selectFromReactSelect(citizenshipCategoryContainerLocator, citizenshipCategoryInputLocator, category);
    }

    public void selectPrimaryCitizenCountry(String country) {
        LoggerUtil.info("Selecting '" + country + "' from Primary Citizen Country dropdown");
        selectFromReactSelect(primaryCitizenCountryContainerLocator, primaryCitizenCountryInputLocator, country);
    }

    public void selectSecondaryCitizenCountry(String country) {
        LoggerUtil.info("Selecting '" + country + "' from Secondary Citizen Country dropdown");
        selectFromReactSelect(secondaryCitizenCountryContainerLocator, secondaryCitizenCountryInputLocator, country);
    }

    public void selectResidentCountry(String country) {
        LoggerUtil.info("Selecting '" + country + "' from Resident Country dropdown");
        selectFromReactSelect(residentCountryContainerLocator, residentCountryInputLocator, country);
    }

    public void selectPrCountry(String country) {
        LoggerUtil.info("Selecting '" + country + "' from PR Country dropdown");
        selectFromReactSelect(prCountryContainerLocator, prCountryInputLocator, country);
    }

    public void selectEducation(String education) {
        LoggerUtil.info("Selecting '" + education + "' from Education dropdown");
        selectFromReactSelect(educationContainerLocator, educationInputLocator, education);
    }

    public void enterPosition(String position) {
        LoggerUtil.info("Typing '" + position + "' into Position field");
        typeText(positionInputLocator, position);
        assertValueEquals(positionInputLocator, position, "Position mismatch");
    }

    public void clickSave() {
        LoggerUtil.info("Clicking 'Save' button on High Profile page");
        click(saveButtonLocator);
    }

    public void clickReset() {
        LoggerUtil.info("Clicking 'Reset' button on High Profile page");
        click(resetButtonLocator);
    }

    public void clickExit() {
        LoggerUtil.info("Clicking 'Exit' button on High Profile page");
        click(exitButtonLocator);
    }

    public void clickNext() {
        LoggerUtil.info("Clicking 'Next' button on High Profile page");
        click(nextButtonLocator);
    }
}

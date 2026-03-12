package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.BasePage;
import utilities.LoggerUtil;

public class CorporateCustRegPage extends BasePage {

    // =================================================
    // Form Visible Locators
    // =================================================
    private By formVisibleLocator = By.xpath("//label[@class='text-sm mb-1 block text-gray-600']");
    private By corporateCustomerHeaderLocator = By.xpath("//h4[normalize-space()='Corporate Customer']");

    // =================================================
    // Corporate Details Locators
    // =================================================
    private By legalStatusLocator = By.cssSelector("input[role='combobox']");
    private By companyNameLocator = By.cssSelector("input[aria-label='Company Name']");
    private By issuedAuthorityLocator = By
            .cssSelector("input[aria-label='Company Registered Number Issued Authority']");
    private By authorityRemarksLocator = By.cssSelector("textarea[aria-label='Company Registered Authority Remarks']");
    private By registeredNumberLocator = By.cssSelector("input[aria-label='Company Registered Number']");

    // Date Locators
    private By registeredDateInputLocator = By.cssSelector("input[data-testid='eng-date-picker']");
    private By monthDropdownLocator = By.xpath("//select[@name='months']");
    private By yearDropdownLocator = By.xpath("//select[@name='years']");

    private By onboardingChannelLocator = By.cssSelector("input[aria-label='Onboarding Channel']");
    private By obligorLocator = By.cssSelector("input[aria-label='Obligor']");
    private By countryLocator = By.cssSelector("input[aria-label='Country']");
    private By foreignCheckboxLocator = By.xpath("//input[@name='isForeign']");

    // Actions Locators
    private By nextBtnLocator = By.xpath("//button[.//div[normalize-space()='Proceed']]");
    private By resetBtnLocator = By.xpath("//button[.//div[normalize-space()='Reset']]");

    // =================================================
    // Constructor
    // =================================================
    public CorporateCustRegPage(WebDriver driver) {
        super(driver);
    }

    // =================================================
    // Corporate Details Methods
    // =================================================
    public void chooseLegalStatus(String legalStatusValue) {
        LoggerUtil.info("Selecting '" + legalStatusValue + "' from Legal Status dropdown");
        selectFromDropdown(legalStatusLocator, legalStatusValue);

        if (legalStatusValue.equalsIgnoreCase("Legal Entities")) {
            assertTextEquals(corporateCustomerHeaderLocator, "Corporate Customer",
                    "Corporate Customer form not opened.");
        }
    }

    public void enterCompanyName(String name) {
        LoggerUtil.info("Entering Company Name: " + name);
        typeText(companyNameLocator, name);
        assertValueEquals(companyNameLocator, name, "Company name not entered correctly");
    }

    public void selectIssuedAuthority(String authorityValue) {
        LoggerUtil.info("Selecting '" + authorityValue + "' from Issued Authority dropdown");
        selectFromDropdown(issuedAuthorityLocator, authorityValue);
    }

    public void enterAuthorityRemarks(String remarks) {
        LoggerUtil.info("Entering Authority Remarks: " + remarks);
        typeText(authorityRemarksLocator, remarks);
    }

    public void enterRegisteredNumber(String number) {
        LoggerUtil.info("Entering Registered Number: " + number);
        typeText(registeredNumberLocator, number);
        assertValueEquals(registeredNumberLocator, number, "Registered Number not entered correctly");
    }

    public void selectRegisteredDate(String yearValue, String monthValue, String dayValue) {
        LoggerUtil.info("Selecting Registered Date AD - Year: " + yearValue +
                ", Month: " + monthValue + ", Day: " + dayValue);

        By dayLocator = By.xpath("//button[@name='day' and normalize-space()='" + dayValue + "' and not(@disabled)]");
        selectDate(registeredDateInputLocator, yearDropdownLocator, yearValue,
                monthDropdownLocator, monthValue, dayLocator);

        assertFalseCondition(getAttributeValue(registeredDateInputLocator, "value").isEmpty(),
                "Registered date was not selected");
    }

    public void selectOnboardingChannel(String onboardingChannelValue) {
        LoggerUtil.info("Selecting '" + onboardingChannelValue + "' from Onboarding Channel dropdown");
        selectFromDropdown(onboardingChannelLocator, onboardingChannelValue);
    }

    public void selectObligor(String obligorValue) {
        LoggerUtil.info("Selecting '" + obligorValue + "' from Obligor dropdown");
        selectFromDropdown(obligorLocator, obligorValue);
    }

    public void selectCountry(String countryValue) {
        LoggerUtil.info("Selecting '" + countryValue + "' from Country dropdown");
        selectFromDropdown(countryLocator, countryValue);
    }

    public void selectIsForeignResident(boolean isForeignValue) {
        LoggerUtil.info((isForeignValue ? "Checking" : "Unchecking") + " 'Is Foreign Resident' checkbox");
        if (isForeignValue != isSelected(foreignCheckboxLocator)) {
            click(foreignCheckboxLocator);
        }
    }

    public void clickProceedButton() {
        LoggerUtil.info("Clicking 'Proceed' button");
        click(nextBtnLocator);
    }

    public void clickResetButton() {
        LoggerUtil.info("Clicking 'Reset' button");
        click(resetBtnLocator);
    }

    // =================================================
    // Form Validation
    // =================================================
    public boolean isFormVisible() {
        LoggerUtil.info("Checking if Corporate Customer Registration form is visible");
        return wait.waitForElementToBeVisible(formVisibleLocator).isDisplayed();
    }
}

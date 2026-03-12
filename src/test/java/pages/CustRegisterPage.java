package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.BasePage;
import utilities.LoggerUtil;

public class CustRegisterPage extends BasePage {

	// =================================================
	// Check form visible or not Locators
	// =================================================

	private By formVisibleLocator = By.xpath("//label[@class='text-sm mb-1 block text-gray-600']");
	private By individualCustomerHeaderLocator = By.xpath("//h4[normalize-space()='Individual Customer']");

	// =================================================
	// Personal Details Locators
	// =================================================
	private By legalStatusLocator = By.cssSelector("input[role='combobox']");
	private By ScreeningIdLocator = By.xpath("//input[@name='screeningId']");
	private By fNameLocator = By.cssSelector("input[aria-label='First Name']");
	private By mNameLocator = By.cssSelector("input[aria-label='Middle Name']");
	private By lNameLocator = By.cssSelector("input[aria-label='Last Name']");
	private By fNameLocalLocator = By.xpath("//input[@name='firstNameLocal']");
	private By mNameLocalLocator = By.xpath("//input[@name='middleNameLocal']");
	private By lNameLocalLocator = By.xpath("//input[@name='lastNameLocal']");
	private By maidenNameLocator = By.cssSelector("input[aria-label='Maiden Name']");
	private By foreignCheckboxLocator = By.xpath("//input[@name='isForeign']");
	private By isPEPCheckboxLocator = By.xpath("//input[@name='isPep']");
	private By foreignResidentLocator = By.xpath("//input[@aria-label='Foreign Residential Country']");
	private By pepLocator = By.xpath("//input[@aria-label='PEP Category']");
	private By genderLocator = By.xpath("//input[@aria-label='Gender']");
	private By onboardingChannelLocator = By.xpath("//input[@aria-label='Onboarding Channel']");
	private By maritalStatusLocator = By.xpath("//input[@aria-label='Marital Status']");
	private By religionLocator = By.xpath("//input[@aria-label='Religion']");
	private By educationLocator = By.xpath("//input[@aria-label='Education']");
	private By motherlanguageLocator = By.xpath("//input[@aria-label='Mother Language']");
	private By prreferredCommunicationLocator = By.xpath("//input[@aria-label='Preferred Communication Language']");

	// =================================================
	// Birth Details Locators
	// =================================================
	private By birthCountryLocator = By.xpath("//input[@aria-label='Birth Country']");
	private By birthAddressNoneLocalCustomerLocator = By.name("birthAddressForNoneLocalCustomer");
	private By birthDateInputLocator = By.cssSelector("input[data-testid='eng-date-picker']");
	private By monthDropdownLocator = By.xpath("//select[@name='months']");
	private By yearDropdownLocator = By.xpath("//select[@name='years']");

	// =================================================
	// Employment Locators
	// =================================================
	private By isEmployeeYesLocator = By.xpath("//input[@name='isHomeEmployee' and @value='true']");
	private By isEmployeeNoLocator = By.xpath("//input[@name='isHomeEmployee' and @value='false']");
	private By nextBtnLocator = By.xpath("//div[normalize-space()='Proceed']");

	// =================================================
	// Constructor
	// =================================================
	public CustRegisterPage(WebDriver driver) {
		super(driver);
	}

	// =================================================
	// Employment Methods
	// =================================================
	public void isEmployee(String optionValue) {
		LoggerUtil.info("Selecting Is Employee option: " + optionValue);

		if (optionValue.equalsIgnoreCase("yes")) {
			LoggerUtil.info("Clicking 'Yes' for Is Employee");
			click(isEmployeeYesLocator);
			assertTrueCondition(isSelected(isEmployeeYesLocator), "'Yes' Employee option not selected");
		} else if (optionValue.equalsIgnoreCase("no")) {
			LoggerUtil.info("Clicking 'No' for Is Employee");
			click(isEmployeeNoLocator);
			assertTrueCondition(isSelected(isEmployeeNoLocator), "'No' Employee option not selected");
		} else {
			throw new IllegalArgumentException("Invalid value for Is Employee. Use 'Yes' or 'No'");
		}
	}

	public void enterScreeningId(String screeningIdValue) {
		LoggerUtil.info("Entering Screening ID: " + screeningIdValue);
		typeText(ScreeningIdLocator, screeningIdValue);
		assertValueEquals(ScreeningIdLocator, screeningIdValue, "Screening ID not entered correctly");
	}

	// =================================================
	// Personal Details Methods
	// =================================================
	public void chooseLegalStatus(String legalStatusValue) {
		LoggerUtil.info("Selecting '" + legalStatusValue + "' from Legal Status dropdown");
		selectFromDropdown(legalStatusLocator, legalStatusValue);

		if (legalStatusValue.equalsIgnoreCase("Individual")) {
			assertTextEquals(individualCustomerHeaderLocator, "Individual Customer",
					"Individual Customer form not opened.");
		}
	}

	public void enterCustomerName(String firstNameValue, String middleNameValue, String lastNameValue) {
		LoggerUtil.info("Entering Customer Name - First: " + firstNameValue +
				", Middle: " + middleNameValue + ", Last: " + lastNameValue);

		typeText(fNameLocator, firstNameValue);
		typeText(mNameLocator, middleNameValue);
		typeText(lNameLocator, lastNameValue);

		assertValueEquals(fNameLocator, firstNameValue, "First name not entered correctly");
		assertValueEquals(mNameLocator, middleNameValue, "Middle name not entered correctly");
		assertValueEquals(lNameLocator, lastNameValue, "Last name not entered correctly");
	}

	public void enterCustomerNameLocal(String firstNameLocalValue, String middleNameLocalValue,
			String lastNameLocalValue) {

		LoggerUtil.info("Entering Customer Local Name - First: " + firstNameLocalValue +
				", Middle: " + middleNameLocalValue + ", Last: " + lastNameLocalValue);

		typeText(fNameLocalLocator, firstNameLocalValue);
		typeText(mNameLocalLocator, middleNameLocalValue);
		typeText(lNameLocalLocator, lastNameLocalValue);

		assertValueEquals(fNameLocalLocator, firstNameLocalValue, "Local First name not entered correctly");
		assertValueEquals(mNameLocalLocator, middleNameLocalValue, "Local Middle name not entered correctly");
		assertValueEquals(lNameLocalLocator, lastNameLocalValue, "Local Last name not entered correctly");
	}

	public void enterMaidenName(String maidenNameValue) {
		LoggerUtil.info("Typing '" + maidenNameValue + "' into Maiden Name field");
		typeText(maidenNameLocator, maidenNameValue);
		assertValueEquals(maidenNameLocator, maidenNameValue, "Maiden name not entered correctly");
	}

	public void selectIsForeign(boolean isForeignValue, String foreignResidentCountryValue) {
		LoggerUtil.info((isForeignValue ? "Checking" : "Unchecking") + " 'Is Foreign Resident' checkbox");
		if (isForeignValue != isSelected(foreignCheckboxLocator)) {
			click(foreignCheckboxLocator);
		}

		if (isForeignValue) {
			LoggerUtil.info("Selecting '" + foreignResidentCountryValue + "' from Foreign Resident Country dropdown");
			selectFromDropdown(foreignResidentLocator, foreignResidentCountryValue);
		}
	}

	public void selectIsPEP(boolean isPEPValue, String pepCategoryValue) {
		LoggerUtil.info((isPEPValue ? "Checking" : "Unchecking") + " 'Is PEP' checkbox");
		if (isPEPValue != isSelected(isPEPCheckboxLocator)) {
			click(isPEPCheckboxLocator);
		}

		if (isPEPValue) {
			LoggerUtil.info("Selecting '" + pepCategoryValue + "' from PEP Category dropdown");
			selectFromDropdown(pepLocator, pepCategoryValue);
		}
	}

	public void selectGender(String genderValue) {
		LoggerUtil.info("Selecting '" + genderValue + "' from Gender dropdown");
		selectFromGenderDropdown(genderLocator, genderValue);

	}

	public void selectOnboardingChannel(String onboardingChannelValue) {
		LoggerUtil.info("Selecting '" + onboardingChannelValue + "' from Onboarding Channel dropdown");
		selectFromDropdown(onboardingChannelLocator, onboardingChannelValue);
	}

	public void selectMaritalStatus(String maritalStatusValue) {
		LoggerUtil.info("Selecting '" + maritalStatusValue + "' from Marital Status dropdown");
		selectFromDropdown(maritalStatusLocator, maritalStatusValue);
	}

	public void selectReligion(String religionValue) {
		LoggerUtil.info("Selecting '" + religionValue + "' from Religion dropdown");
		selectFromDropdown(religionLocator, religionValue);
	}

	public void selectEducation(String educationValue) {
		LoggerUtil.info("Selecting '" + educationValue + "' from Education Level dropdown");
		selectFromGenderDropdown(educationLocator, educationValue);
	}

	public void selectMotherLanguage(String MotherLanguageValue) {
		LoggerUtil.info("Selecting '" + MotherLanguageValue + "' from Mother Language dropdown");
		selectFromDropdown(motherlanguageLocator, MotherLanguageValue);
	}

	public void selectPreferredCommunicationLanguage(String preferredLanguageValue) {
		LoggerUtil.info("Selecting '" + preferredLanguageValue + "' from Preferred Communication Language dropdown");
		selectFromDropdown(prreferredCommunicationLocator, preferredLanguageValue);
	}

	// =================================================
	// Birth Details Methods
	// =================================================
	public void selectBirthDate(String yearValue, String monthValue, String dayValue) {
		LoggerUtil.info("Selecting Date of Birth - Year: " + yearValue +
				", Month: " + monthValue + ", Day: " + dayValue);

		By dayLocator = By.xpath("//button[@name='day' and normalize-space()='" + dayValue + "' and not(@disabled)]");
		selectDate(birthDateInputLocator, yearDropdownLocator, yearValue,
				monthDropdownLocator, monthValue, dayLocator);

		assertFalseCondition(getAttributeValue(birthDateInputLocator, "value").isEmpty(),
				"Birth date was not selected");
	}

	public void enterBirthCountry(String birthCountryValue) {
		LoggerUtil.info("Selecting '" + birthCountryValue + "' from Birth Country dropdown");
		selectFromDropdown(birthCountryLocator, birthCountryValue);
	}

	public void enterBirthAddressIfApplicable(String addressValue) {
		if (addressValue != null && !addressValue.trim().isEmpty()) {
			LoggerUtil.info("Typing '" + addressValue + "' into Birth Address for Non-local Customer field");
			typeText(birthAddressNoneLocalCustomerLocator, addressValue);
			assertValueEquals(birthAddressNoneLocalCustomerLocator, addressValue,
					"Birth address not entered correctly");
		} else {
			LoggerUtil.info("No Birth Address provided for Non-local Customer");
		}
	}

	public void clickNextButton() {
		LoggerUtil.info("Clicking 'Next' button");
		click(nextBtnLocator);

	}

	// =================================================
	// Form Validation
	// =================================================
	public boolean isFormVisible() {
		LoggerUtil.info("Checking if Customer Registration form is visible");
		return wait.waitForElementToBeVisible(formVisibleLocator).isDisplayed();
	}
}

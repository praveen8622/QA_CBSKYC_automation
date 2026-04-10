package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;
import utilities.LoggerUtil;

public class CustIdentityPage extends BasePage {

	public CustIdentityPage(WebDriver driver) {
		super(driver);

	}

	private By addIdentityLocator = By.xpath("//button[@title='Add']");

	private By identityTypeDropdownLocator = By.xpath("//input[@aria-label='Identity Type']");
	private By identityNumberInputLocator = By.xpath("//input[@name='identityNo']");

	private By openIssueOfficeNameInputLocator = By.xpath("//input[@name='openIssueOfficeName']");
	private By localBodyInputLocator = By.xpath("//input[@aria-label='local Body']");
	private By stateInputLocator = By.xpath("//input[@aria-label='State']");
	private By districtInputLocator = By.xpath("//input[@aria-label='District']");

	private By issueDateButtonLocator = By.name("issueDate");
	private By issueDateLocalInputLocator = By.xpath("//input[@name='issueDateLocal']");

	private By isExpiryBasedInputLocator = By.xpath("//input[@name='isExpiryBased']");

	private By identityLifeDaysInputLocator = By.xpath("//input[@name='identityTypeLifeDays']");

	private By expiryDateInputLocator = By.name("expiryDate");

	private By documentUploadInputLocator = By.xpath("//div[contains(@class,'dropzone')]//input[@type='file']");

	private By exitButtonLocator = By.xpath("//button[.//text()[normalize-space()='Exit']]");

	private By resetButtonLocator = By.xpath("//button[.//text()[normalize-space()='Reset']]");

	private By saveButtonLocator = By.xpath("//button[@type='submit' and .//text()[normalize-space()='Save']]");

	private By nextButtonLocator = By.xpath("//button[@title='Next Step']");

	// Date picker common locators (assumed existing in your framework)
	private By yearDropdownLocator = By.xpath("//select[@name='years']");
	private By monthDropdownLocator = By.xpath("//select[@name='months']");

	public void openAddIdentityForm() {
		LoggerUtil.info("Clicking 'Add' button to open Identity Form");
		click(addIdentityLocator);

		LoggerUtil.info("Verifying if Add Identity form is visible");
		assertTrueCondition(isIdentityFormVisible(), "Add Identity form is not visible");
	}

	// =================================================
	// Identity Details
	// =================================================

	public void selectIdentityType(String identityTypeValue) {
		LoggerUtil.info("Selecting '" + identityTypeValue + "' from Identity Type dropdown");
		selectFromDropdown(identityTypeDropdownLocator, identityTypeValue);
	}

	public void selectLocalBody(String localBody) {
		LoggerUtil.info("Selecting Local Body: " + localBody);
		selectFromDropdown(localBodyInputLocator, localBody);
	}

	public void selectState(String state) {
		LoggerUtil.info("Selecting State: " + state);
		selectFromDropdown(stateInputLocator, state);
	}

	public void selectIdentityTypeAndFillConditionalField(String type, String fieldValue) {
		selectIdentityType(type);
		fillConditionalIdentityField(type, fieldValue,
				openIssueOfficeNameInputLocator,
				localBodyInputLocator,
				stateInputLocator,
				districtInputLocator);
	}

	public void enterIdentityNumber(String identityNumberValue) {
		LoggerUtil.info("Typing '" + identityNumberValue + "' into Identity Number field");
		typeText(identityNumberInputLocator, identityNumberValue);

		assertValueEquals(identityNumberInputLocator, identityNumberValue,
				"Identity Number not entered correctly");
	}

	public void enterOpenIssueOfficeName(String officeNameValue) {
		LoggerUtil.info("Typing '" + officeNameValue + "' into Open Issue Office Name field");
		typeText(openIssueOfficeNameInputLocator, officeNameValue);

		assertValueEquals(openIssueOfficeNameInputLocator, officeNameValue,
				"Open Issue Office Name not entered correctly");
	}

	public void selectIssueDate(String yearValue, String monthValue, String dayValue) {
		LoggerUtil.info("Selecting Issue Date - Year: " + yearValue +
				", Month: " + monthValue + ", Day: " + dayValue);

		By dayLocator = By.xpath("//button[@name='day' and normalize-space()='"
				+ dayValue + "' and not(@disabled)]");

		selectDate(issueDateButtonLocator, yearDropdownLocator, yearValue,
				monthDropdownLocator, monthValue, dayLocator);

		assertFalseCondition(getAttributeValue(issueDateButtonLocator, "value").isEmpty(),
				"Issue Date was not selected");
	}

	public void verifyIssueDateLocalIsAutoPopulated() {
		LoggerUtil.info("Verifying 'Issue Date (Local)' field is auto-populated");

		assertFalseCondition(getAttributeValue(issueDateLocalInputLocator, "value").isEmpty(),
				"Issue Date (Local) is not auto populated");
	}

	public boolean isIdentityExpiryBased() {
		LoggerUtil.info("Checking 'Is Expiry Based' field value");
		String value = getAttributeValue(isExpiryBasedInputLocator, "value");
		System.out.println(value);
		return value != null && value.equalsIgnoreCase("Yes");

	}

	public boolean isExpiryDateDisabled() {
		return getAttributeValue(expiryDateInputLocator, "disabled") != null;
	}

	public boolean isExpiryDateEnabled() {
		return getAttributeValue(expiryDateInputLocator, "disabled") == null;
	}

	public void verifyIdentityLifeDays(String expectedLifeDays) {
		LoggerUtil.info("Verifying 'Identity Life Days' field contains: " + expectedLifeDays);

		String actualValue = getAttributeValue(identityLifeDaysInputLocator, "value");
		assertTrueCondition(actualValue.equals(expectedLifeDays),
				"Identity Life Days mismatch. Expected: " + expectedLifeDays +
						", Actual: " + actualValue);
	}

	public void handleExpiryDateIfApplicable(
			String year, String month, String day) {

		LoggerUtil.info("Handling Expiry Date selection if applicable");

		if (isIdentityExpiryBased()) {
			LoggerUtil.info("Identity is expiry-based. Selecting Expiry Date: Year " + year + ", Month " + month
					+ ", Day " + day);

			// ===== Expiry-based identity =====
			assertTrueCondition(isExpiryDateEnabled(),
					"Expiry Date is disabled for expiry-based identity");

			By dayLocator = By.xpath(
					"//button[@name='day' and normalize-space()='"
							+ day + "' and not(@disabled)]");

			selectDate(
					expiryDateInputLocator,
					yearDropdownLocator, year,
					monthDropdownLocator, month,
					dayLocator);

			assertFalseCondition(
					getAttributeValue(expiryDateInputLocator, "value").isEmpty(),
					"Expiry Date was not populated");
		} else {
			LoggerUtil.info("Identity is NOT expiry-based. Skipping Expiry Date selection.");

			// ===== Non-expiry identity =====
			assertTrueCondition(isExpiryDateDisabled(),
					"Expiry Date is enabled for non-expiry identity");
		}
	}

	// =================================================
	// Document Upload
	// =================================================

	public void uploadIdentityDocument(String relativePath) {
		LoggerUtil.info("Uploading Identity Document from path: " + relativePath);
		uploadFile(documentUploadInputLocator, relativePath);
	}

	// =================================================
	// Actions
	// =================================================

	public void clickExitButton() {
		LoggerUtil.info("Clicking 'Exit' button");
		click(exitButtonLocator);
	}

	public void clickResetButton() {
		LoggerUtil.info("Clicking 'Reset' button");
		click(resetButtonLocator);
	}

	public void clickSaveIdentity() {
		LoggerUtil.info("Clicking 'Save' button");
		click(saveButtonLocator);
	}

	public void clickNextbutton() {
		LoggerUtil.info("Clicking 'Next' button");
		click(nextButtonLocator);
	}

	// =================================================
	// Validation
	// =================================================

	public boolean isIdentityFormVisible() {
		LoggerUtil.info("Checking if Add Identity form is visible");
		return isElementVisible(identityTypeDropdownLocator);
	}
}

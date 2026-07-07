package pages.cust_reg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;
import utilities.LoggerUtil;

public class CustDocument extends BasePage {

	public CustDocument(WebDriver driver) {
		super(driver);

	}

	private By addDocumentBtnLocator = By.xpath("//button[@title='Add']");
	private By documentTypeInputLocator = By.xpath("//input[@aria-label='Document Type']");
	private By documentTitleInputLocator = By.name("documentTitle");
	private By documentNoInputLocator = By.name("documentNo");
	private By fileUploadInputLocator = By.xpath("//input[@type='file']");
	private By saveButtonLocator = By.xpath("//button[normalize-space()='Save']");

	public void clickAddDocument() {
		LoggerUtil.info("Clicking Add Document button");
		click(addDocumentBtnLocator);
	}

	public void selectDocumentType(String type) {
		LoggerUtil.info("Selecting Document Type: " + type);
		selectFromDropdown(documentTypeInputLocator, type);
	}

	public void enterDocumentTitle(String title) {
		LoggerUtil.info("Entering Document Title: " + title);
		typeText(documentTitleInputLocator, title);
		assertValueEquals(documentTitleInputLocator, title, "Document Title mismatch");
	}

	public void enterDocumentNumber(String number) {
		LoggerUtil.info("Entering Document Number: " + number);
		typeText(documentNoInputLocator, number);
		assertValueEquals(documentNoInputLocator, number, "Document Number mismatch");
	}

	public void uploadDocument(String filePath) {
		LoggerUtil.info("Uploading document: " + filePath);
		uploadFile(fileUploadInputLocator, filePath);
	}

	public void clickSave() {
		LoggerUtil.info("Clicking 'Next' button on Document page");
		click(saveButtonLocator);
	}

}

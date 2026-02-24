package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.BasePage;
import utilities.LoggerUtil;

public class CustRelationshipDocumentPage extends BasePage {

    // =================================================
    // Locators
    // =================================================
    private By documentTabLocator = By.xpath("//button[normalize-space()='Document']");

    private By addDocumentBtnLocator = By.xpath(
            "//h4[normalize-space()='Relationship Document']/ancestor::div[contains(@class,'flex')]//button[@title='Add']");

    private By documentTypeContainerLocator = By
            .xpath("//input[@aria-label='Document Type']/ancestor::div[contains(@class, 'container')]");
    private By documentTypeInputLocator = By.xpath("//input[@aria-label='Document Type']");

    private By documentTitleInputLocator = By.name("documentTitle");
    private By documentNoInputLocator = By.name("documentNo");

    private By mimeTypeContainerLocator = By
            .xpath("//input[@aria-label='MIME Type']/ancestor::div[contains(@class, 'container')]");
    private By mimeTypeInputLocator = By.xpath("//input[@aria-label='MIME Type']");

    private By fileUploadInputLocator = By.xpath("//input[@type='file']");
    private By saveBtnLocator = By.xpath("//button[normalize-space()='Save']");
    private By nextBtnLocator = By.xpath("//button[@title='Next']");

    public CustRelationshipDocumentPage(WebDriver driver) {
        super(driver);
    }

    // =================================================
    // Actions
    // =================================================

    public void clickDocumentTab() {
        LoggerUtil.info("Clicking Document tab");
        click(documentTabLocator);
    }

    public void clickAddDocument() {
        LoggerUtil.info("Clicking Add Document button");
        click(addDocumentBtnLocator);
    }

    public void selectDocumentType(String type) {
        LoggerUtil.info("Selecting Document Type: " + type);
        selectFromReactSelect(documentTypeContainerLocator, documentTypeInputLocator, type);
    }

    public void enterDocumentTitle(String title) {
        LoggerUtil.info("Entering Document Title: " + title);
        typeText(documentTitleInputLocator, title);
        assertValueEquals(documentTitleInputLocator, title, "Relationship Document Title mismatch");
    }

    public void enterDocumentNumber(String number) {
        LoggerUtil.info("Entering Document Number: " + number);
        typeText(documentNoInputLocator, number);
        assertValueEquals(documentNoInputLocator, number, "Relationship Document Number mismatch");
    }

    public void selectMimeType(String mime) {
        LoggerUtil.info("Selecting MIME Type: " + mime);
        selectFromReactSelect(mimeTypeContainerLocator, mimeTypeInputLocator, mime);
    }

    public void uploadDocument(String filePath) {
        LoggerUtil.info("Uploading document from path: " + filePath);
        uploadFile(fileUploadInputLocator, filePath);
    }

    public void clickSave() {
        LoggerUtil.info("Clicking Save button in Relationship Document form");
        click(saveBtnLocator);
    }

    public void clickNext() {
        LoggerUtil.info("Clicking Next button in Relationship Document form");
        click(nextBtnLocator);
    }
}

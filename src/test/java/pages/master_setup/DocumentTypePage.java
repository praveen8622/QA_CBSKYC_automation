package pages.master_setup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.BasePage;

public class DocumentTypePage extends BasePage {

    public DocumentTypePage(WebDriver driver) {
        super(driver);
    }

    // Locators
    private By addBtnLocator = By.xpath("//div[text()='Add Document Type']");
    private By documentTypeInputLocator = By.xpath("//input[@aria-label='documentType']");
    private By documentTypeLocalInputLocator = By.xpath("//input[@aria-label='documentTypeLocal']");
    private By maxSizeInputLocator = By.xpath("//input[@aria-label='maxFileSize']");
    private By saveBtnLocator = By.xpath("//div[text()='Save']");
    private By searchInputLocator = By.xpath("//input[@placeholder='Search here']");
    private By loadDataBtnLocator = By.xpath("//div[text()='Load Data']");
    private By exitBtnLocator = By.xpath("//button[@data-hot-keys='CLOSE_MODAL']");

    // Interaction Methods
    public void clickAdd() {
        click(addBtnLocator);
    }

    public void enterDocumentType(String documentType) {
        typeText(documentTypeInputLocator, documentType);
    }

    public void enterDocumentTypeLocal(String documentTypeLocal) {
        typeText(documentTypeLocalInputLocator, documentTypeLocal);
    }

    public void enterMaxSize(String size) {
        typeText(maxSizeInputLocator, size);
    }

    public void clickSave() {
        click(saveBtnLocator);
    }

    public void searchDocumentType(String searchText) {
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

    public void clickEditDocumentType(String docType) {
        By editBtnLocator = By.xpath("(//td[text()='" + docType + "']/following-sibling::td//button)[1]");
        click(editBtnLocator);
    }

    public void clickViewDocumentType(String docType) {
        By viewBtnLocator = By.xpath("(//td[text()='" + docType + "']/following-sibling::td//button)[2]");
        click(viewBtnLocator);
    }

    public void clickDeleteDocumentType(String docType) {
        By deleteBtnLocator = By.xpath("(//td[text()='" + docType + "']/following-sibling::td//button)[3]");
        click(deleteBtnLocator);
    }
}

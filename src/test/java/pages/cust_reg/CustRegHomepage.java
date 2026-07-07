package pages.cust_reg;
import pages.HomePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.BasePage;
import utilities.LoggerUtil;

public class CustRegHomepage extends BasePage {

    // =================================================
    // Navigation Locators
    // =================================================
    private By addCustregBtnLocator = By.xpath("//div[contains(text(),'Add Customer Registration')]");
    private By loadBtnLocator = By.xpath("//button[@title='Load Data']");
    private By nextBtnLocator = By.xpath("//form//button[@type='submit' and .//div[normalize-space()='Next Step']]");
    private By titleTextLocator = By.xpath("//p[normalize-space()='Customer Registration Master']");
    // =================================================
    // Locators of menues
    // =================================================

    private By identityTabLocator = By.xpath("//p[normalize-space()='Customer Identity']");
    private By communicationTabLocator = By.xpath("//p[normalize-space()='Customer Communication']");
    private By documentTabLocator = By.xpath("//button[normalize-space()='Customer Document']");
    private By addressTabLocator = By.xpath("//p[normalize-space()='Customer Address']");
    private By photoTabLocator = By.xpath("//p[normalize-space()='Customer Photo']");
    private By highProfileTabConnLocator = By.xpath("//p[normalize-space()='High Profile Connections']");
    private By transactionVolumeTabLocator = By.xpath("//p[normalize-space()='Transaction Volume']");
    private By cashFlowTabLocator = By.xpath("//p[normalize-space()='Cash Flow']");
    private By exposureTabLocator = By.xpath("//p[normalize-space()='Exposure to Other Financial Institutions']");
    private By employmentTabLocator = By.xpath("//p[normalize-space()='Employment Details']");
    private By relationshipTabLocator = By.xpath("//div[normalize-space()='Relationships']");
    private By addRelationshipBtn = By.xpath("//button[@title='Add']");

    // =================================================
    // FORM HEADERS LOCATOR
    // =================================================
    private By custIdentityHeaderLocator = By.xpath("//h4[normalize-space()='Customer Identity']");
    private By custCommunicationHeaderLocator = By.xpath("//h4[normalize-space()='Customer Communication']");
    private By custDocumentHeaderLocator = By.xpath("//h4[normalize-space()='Customer Document']");
    private By custAddressHeaderLocator = By.xpath("//h4[normalize-space()='Customer Address']");
    private By custPhotoHeaderLocator = By.xpath("//h4[normalize-space()='Customer Photo']");
    private By custHighProfileHeaderLocator = By.xpath("//h4[normalize-space()='High Profile Connections']");
    private By custTransactionHeaderLocator = By.xpath("//h4[normalize-space()='Transaction Volume']");
    private By custCashFlowHeaderLocator = By.xpath("//h4[normalize-space()='Cash Flow']");
    private By custExposureHeaderLocator = By
            .xpath("//h4[normalize-space()='Exposure to Other Financial Institutions']");
    private By custEmploymentHeaderLocator = By.xpath("//h4[normalize-space()='Employment Details']");
    private By custRelationshipHeaderLocator = By.xpath("//h4[normalize-space()='Relationships']");

    public CustRegHomepage(WebDriver driver) {
        super(driver);
    }

    HomePage homePage = new HomePage(driver);

    public void clickAddCustomerRegistration() {
        LoggerUtil.info("Clicking 'Add Customer Registration' button");
        click(addCustregBtnLocator);
        assertTextEquals(titleTextLocator, "Customer Registration Master",
                "Customer Registration master page not loaded.");
    }

    // =================================================
    // Table Action Methods
    // =================================================
    public void selectStatus(String status) {
        LoggerUtil.info("Selecting status: " + status);
        // Locate the dropdown that contains a "singleValue" (currently selected option)
        By statusDropdownLocator = By
                .xpath("//div[contains(@class, '-control')][.//div[contains(@class, 'singleValue')]]");
        click(statusDropdownLocator);

        // Select the option from the dropdown menu
        By statusOptionLocator = By.xpath("//div[contains(text(), '" + status + "')]");
        click(statusOptionLocator);
    }

    public void clickEditAction(String customerName) {
        LoggerUtil.info("Clicking 'Edit' button for customer: " + customerName);
        By editBtnLocator = By.xpath("//tr[td[normalize-space()='" + customerName + "']]//button[@title='Edit']");
        click(editBtnLocator);
    }

    public void searchAndEditDraftCustomer(String customerName) {
        LoggerUtil.info("Searching and editing customer (Draft): " + customerName);

        homePage.navigateToCustomerRegistration();
        selectStatus("Draft");
        click(loadBtnLocator);
        clickEditAction(customerName);
        click(nextBtnLocator);
    }

    public void clickViewAction(String customerName) {
        LoggerUtil.info("Clicking 'View' button for customer: " + customerName);
        By viewBtnLocator = By.xpath("//tr[td[normalize-space()='" + customerName + "']]//button[@title='View']");
        click(viewBtnLocator);
    }

    public void clickDeleteAction(String customerName) {
        LoggerUtil.info("Clicking 'Delete' button for customer: " + customerName);
        By deleteBtnLocator = By.xpath("//tr[td[normalize-space()='" + customerName + "']]//button[@title='Delete']");
        click(deleteBtnLocator);
    }

    // =================================================
    // NAVIGATION TO MENU
    // =================================================
    public void navigateToIdentityTab() {
        LoggerUtil.info("Clicking 'Customer Identity' tab");
        click(identityTabLocator);
        assertElementVisible(custIdentityHeaderLocator, "Customer Identity form not opened");
    }

    public void navigateToCommunicationTab() {
        LoggerUtil.info("Clicking 'Communication' tab");
        click(communicationTabLocator);
        assertElementVisible(custCommunicationHeaderLocator, "Customer Communication form not opened");
    }

    public void navigateToDocumentTab() {
        LoggerUtil.info("Clicking Document tab");
        click(documentTabLocator);
        assertElementVisible(custDocumentHeaderLocator, "Customer Document form not opened");
    }

    public void navigateToAddressTab() {
        LoggerUtil.info("Clicking Address tab");
        click(addressTabLocator);
        assertElementVisible(custAddressHeaderLocator, "Customer Address form not opened");
    }

    public void navigateToPhotoTab() {
        LoggerUtil.info("Clicking Photo tab");
        click(photoTabLocator);
        assertElementVisible(custPhotoHeaderLocator, "Customer Photo form not opened");
    }

    public void navigateToHighProfileTab() {
        LoggerUtil.info("Clicking 'High Profilev Conn' step");
        click(highProfileTabConnLocator);
        assertElementVisible(custHighProfileHeaderLocator, "High Profile Connections form not opened");
    }

    public void navigateToTransactionVolumeTab() {
        LoggerUtil.info("Clicking 'Transaction Volume' step");
        click(transactionVolumeTabLocator);
        assertElementVisible(custTransactionHeaderLocator, "Transaction Volume form not opened");
    }

    public void navigateToCashFlowTab() {
        LoggerUtil.info("Navigating to Cash Flow tab");
        click(cashFlowTabLocator);
        assertElementVisible(custCashFlowHeaderLocator, "Cash Flow form not opened");
    }

    public void navigateToExposureTab() {
        LoggerUtil.info("Navigating to Exposure tab");
        click(exposureTabLocator);
        assertElementVisible(custExposureHeaderLocator, "Exposure form not opened");
    }

    public void navigateToEmploymentTab() {
        LoggerUtil.info("Navigating to Employment Details tab");
        click(employmentTabLocator);
        assertElementVisible(custEmploymentHeaderLocator, "Employment Details form not opened");
    }

    public void navigateToRelationshipMasterTab() {
        LoggerUtil.info("Clicking Relationship tab");
        click(relationshipTabLocator);
        assertElementVisible(custRelationshipHeaderLocator, "Relationships form not opened");
    }

    public void clickAddRelationshipBtn() {
        LoggerUtil.info("Clicking 'Add Relationship' button");
        click(addRelationshipBtn);
        assertElementVisible(custRelationshipHeaderLocator, "Relationships form not opened");
    }
}

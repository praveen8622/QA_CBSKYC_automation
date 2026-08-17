package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.BasePage;
import utilities.LoggerUtil;

public class HomePage extends BasePage {

    // =================================================
    // Menus Navigation Locators
    // =================================================
    private By custManagementLocator = By.xpath("//p[normalize-space()='Customer Management']");
    private By screeningMenuLocator = By.xpath("//p[normalize-space()='Screening & Monitoring']");
    private By masterSetupLocator = By.xpath("//p[normalize-space()='Master Setup']");

    // =================================================
    // Subenus Navigation Locators
    // =================================================
    private By custRegLocator = By.xpath("//p[normalize-space()='Customer Registration']");
    private By buttonLocator = By.xpath("//button[@title='Add Customer Registration']");
    private By custScreeningLocator = By.xpath("//p[normalize-space()='Customer Screening']");

    // locators for assertion of page title
    private By titleScreeningPageSearchLocator = By.xpath("//label[normalize-space()='Search By:']");

    // locators for Customer Operational Status
    private By custOperationalStatusLocator = By
            .xpath("//p[normalize-space()='Customer Operational Status Manual Update']");
    private By operationalStatusFormLocator = By.xpath("//p[text()='Entry']");

    // locators for Master Setup
    private By countrySetupLocator = By.xpath("//a[@data-tooltip-content='Country Setup']");
    private By identityTypeSetupLocator = By.xpath("//a[@data-tooltip-content='Identity Setup']");
    private By documentTypeSetupLocator = By.xpath("//a[@data-tooltip-content='Document Type']");

    // Locators for Approval Dashboard
    private By approvalManagementLocator = By.xpath("//p[normalize-space()='Approval Management']");
    private By approvalDashboardLocator = By.xpath("//p[normalize-space()='Approval Dashboard']");

    // =================================================
    // Constructor
    public HomePage(WebDriver driver) {
        super(driver);
    }

    // =================================================
    // Navigation Methods
    // =================================================

    public void navigateToCustomerManagement() {
        LoggerUtil.info("Clicking 'Customer Management' menu");
        click(custManagementLocator);
    }

    public void navigateToScreeningMonitoring() {
        LoggerUtil.info("Clicking 'Screening & Monitoring' menu");
        click(screeningMenuLocator);
    }

    public void navigateToCustomerRegistration() {
        navigateToCustomerManagement();
        LoggerUtil.info("Clicking 'Customer Registration' submenu");
        click(custRegLocator);
        assertElementVisible(buttonLocator, "Customer Registration page not loaded successfully");

    }

    public void navigateToCustomerScreening() {
        navigateToScreeningMonitoring();
        LoggerUtil.info("Clicking 'Customer Screening' submenu");
        click(custScreeningLocator);
        assertElementVisible(titleScreeningPageSearchLocator, "Customer Screening page not loaded successfully");
    }

    public void navigateToCustomerOperationalStatus() {
        navigateToCustomerManagement();
        LoggerUtil.info("Clicking 'Customer Operational Status' submenu");
        click(custOperationalStatusLocator);
        assertElementVisible(operationalStatusFormLocator,
                "Customer Operational Status page not loaded successfully");
    }

    public void navigateToMasterSetup() {
        LoggerUtil.info("Clicking 'Master Setup' menu");
        click(masterSetupLocator);
    }

    public void navigateToCountrySetup() {
        navigateToMasterSetup();
        LoggerUtil.info("Clicking 'Country Setup' submenu");
        click(countrySetupLocator);
    }

    public void navigateToIdentityTypeSetup() {
        navigateToMasterSetup();
        LoggerUtil.info("Clicking 'Identity Type Setup' submenu");
        click(identityTypeSetupLocator);
    }

    public void navigateToDocumentTypeSetup() {
        navigateToMasterSetup();
        LoggerUtil.info("Clicking 'Document Type Setup' submenu");
        click(documentTypeSetupLocator);
    }

    public void navigateToApprovalDashboard() {
        click(approvalManagementLocator);
        LoggerUtil.info("Clicking 'Approval Dashboard' submenu");
        click(approvalDashboardLocator);
    }

}

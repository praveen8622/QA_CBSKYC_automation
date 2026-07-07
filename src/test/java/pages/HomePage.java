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

    // =================================================
    // Subenus Navigation Locators
    // =================================================
    private By custRegLocator = By.xpath("//p[normalize-space()='Customer Registration']");
    private By buttonLocator = By.xpath("//button[@title='Add Customer Registration']");
    private By custScreeningLocator = By.xpath("//p[normalize-space()='Customer Screening']");
    private By custOperationalStatusLocator = By
            .xpath("//p[normalize-space()='Customer Operational Status Manual Update']");

    // locators for assertion of page title
    private By titleScreeningPageSearchLocator = By.xpath("//label[normalize-space()='Search By:']");
    private By operationalStatusFormLocator = By.xpath("//p[text()='Entry']");

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

}

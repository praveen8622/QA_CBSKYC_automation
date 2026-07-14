package tests.cust_operational_status;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTestSequential;
import pages.HomePage;
import pages.cust_operational_status.CustOperationalStatPage;

public class CustOperationalStatTest extends BaseTestSequential {
    private CustOperationalStatPage custoperational;
    private HomePage homePage;

    @BeforeClass
    public void pageSetup() {
        custoperational = new CustOperationalStatPage(driver);
        homePage = new HomePage(driver);
    }

    @BeforeMethod
    public void setupSoftAssert() {
        custoperational.setSoftAssert(softAssert);
    }

    @Test(priority = 1, description = "Verify Customer Operational Status")
    public void verifyCustomerOperationalStatus() {
        homePage.navigateToCustomerOperationalStatus();
        custoperational.enterCustomerName("Santosh Subedi");
        custoperational.enterStatusName("Black listed");
        custoperational.enterUpdateClause("testing case for customer operational status ");
        custoperational.clickSaveButton();
        softAssert.assertAll();

    }

    @Test(priority = 2, description = "Verify Customer Operational Status")
    public void verifyCustomerOperationalStatus_usingCode() {
        homePage.navigateToCustomerOperationalStatus();
        custoperational.enterCustomerCode("01397370");
        custoperational.enterStatusName("Z");
        custoperational.enterUpdateClause("testing case for customer operational status ");
        custoperational.clickSaveButton();
        softAssert.assertAll();

    }

}

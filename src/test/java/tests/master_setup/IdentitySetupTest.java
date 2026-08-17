package tests.master_setup;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTestSequential;
import pages.HomePage;
import pages.master_setup.IdentitySetupPage;
import utilities.DataGenerator;
import utilities.LoggerUtil;

public class IdentitySetupTest extends BaseTestSequential {

    private HomePage homePage;
    private IdentitySetupPage identitySetupPage;

    @BeforeClass
    public void pageSetup() {
        homePage = new HomePage(driver);
        identitySetupPage = new IdentitySetupPage(driver);
    }

    @BeforeMethod
    public void setupSoftAssert() {
        homePage.setSoftAssert(softAssert);
        identitySetupPage.setSoftAssert(softAssert);
    }

    @Test(priority = 1, description = "Verify adding a new Identity Setup")
    public void verifyAddIdentity() {
        LoggerUtil.info("Identity Setup - Add test started");

        homePage.navigateToIdentityTypeSetup();
        identitySetupPage.clickAdd();

        String randomIdentity = "Identity " + DataGenerator.generateRandomfirstName();

        identitySetupPage.enterIdentityTypeName(randomIdentity);
        identitySetupPage.enterIdentityNameAlias("TestAlias");

        // Example inputs for comboboxes - these might need adjustment based on valid
        // system values
        identitySetupPage.selectIdentityTypeOption("Specific Office");
        identitySetupPage.selectIdentityTypeIssue("District Office");

        identitySetupPage.clickIsExpiry("Yes");
        identitySetupPage.enterIdentityLife("3650");

        identitySetupPage.clickSave();

        LoggerUtil.info("Identity Setup - Add test completed");
    }
}

package tests.master_setup;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTestSequential;
import pages.HomePage;
import pages.master_setup.CountrySetupPage;
import utilities.DataGenerator;
import utilities.LoggerUtil;

public class CountrySetupTest extends BaseTestSequential {

    private HomePage homePage;
    private CountrySetupPage countrySetupPage;
    String randomCountry = "TestCountry " + DataGenerator.generateRandomfirstName();
    String randomCountryCode = DataGenerator.generateRandomNumber(3);

    @BeforeClass
    public void pageSetup() {
        homePage = new HomePage(driver);
        countrySetupPage = new CountrySetupPage(driver);
    }

    @BeforeMethod
    public void setupSoftAssert() {
        homePage.setSoftAssert(softAssert);
        countrySetupPage.setSoftAssert(softAssert);
    }

    @Test(priority = 1, description = "Verify adding a new country in Country Setup")
    public void verifyAddCountry() {
        LoggerUtil.info("Country Setup - Add Country test started");
        homePage.navigateToCountrySetup();
        countrySetupPage.clickAdd();
        countrySetupPage.enterCountryCode(randomCountryCode);
        countrySetupPage.enterCountryName(randomCountry);
        countrySetupPage.enterAlias("TCS");
        countrySetupPage.enterIsoCode("ISO123");
        countrySetupPage.enterNationality("TestNational");
        countrySetupPage.enterPermanentResidentName("TestResident");
        countrySetupPage.selectOfficialLanguage("English");
        countrySetupPage.clickSave();

        LoggerUtil.info("Country Setup - Add Country test completed");
        softAssert.assertAll();
    }

    @Test(priority = 2, description = "Verify country search and view functionality in Country Setup")
    public void verifySearchAndViewCountry() {
        LoggerUtil.info("Country Setup - View Country test started");
        countrySetupPage.clickLoadData();
        countrySetupPage.searchCountry(randomCountry);
        countrySetupPage.clickViewCountry(randomCountry);
        countrySetupPage.clickExit();
        LoggerUtil.info("Country Setup - View Country test completed");
        softAssert.assertAll();
    }

    @Test(priority = 3, description = "Verify editing a country in Country Setup")
    public void verifyEditCountry() {
        LoggerUtil.info("Country Setup - Edit Country test started");
        // countrySetupPage.clickLoadData();
        countrySetupPage.searchCountry(randomCountry);
        countrySetupPage.clickEditCountry(randomCountry);
        countrySetupPage.clickExit();
        LoggerUtil.info("Country Setup - Edit Country test completed");
        softAssert.assertAll();
    }

    @Test(priority = 4, description = "Verify deleting a country in Country Setup")
    public void verifyDeleteCountry() {
        LoggerUtil.info("Country Setup - Delete Country test started");
        countrySetupPage.clickLoadData();
        countrySetupPage.searchCountry(randomCountry);
        countrySetupPage.clickDeleteCountry(randomCountry);
        countrySetupPage.clickConfirmDelete();
        LoggerUtil.info("Country Setup - Delete Country test completed");
        softAssert.assertAll();
    }

}

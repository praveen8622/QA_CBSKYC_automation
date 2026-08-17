package tests.master_setup;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTestSequential;
import pages.HomePage;
import pages.master_setup.DocumentTypePage;
import utilities.DataGenerator;
import utilities.LoggerUtil;

public class DocumentTypeSetupTest extends BaseTestSequential {

    private HomePage homePage;
    private DocumentTypePage documentTypePage;

    @BeforeClass
    public void pageSetup() {
        homePage = new HomePage(driver);
        documentTypePage = new DocumentTypePage(driver);
    }

    @BeforeMethod
    public void setupSoftAssert() {
        homePage.setSoftAssert(softAssert);
        documentTypePage.setSoftAssert(softAssert);
    }

    @Test(priority = 1, description = "Verify adding a new Document Type")
    public void verifyAddDocumentType() {
        LoggerUtil.info("Document Type Setup - Add test started");

        homePage.navigateToDocumentTypeSetup();
        documentTypePage.clickAdd();
        
        String randomDocType = "DocType " + DataGenerator.generateRandomfirstName();
        
        documentTypePage.enterDocumentType(randomDocType);
        documentTypePage.enterDocumentTypeLocal(randomDocType + " Local");
        documentTypePage.enterMaxSize("5000"); // 5MB
        
        documentTypePage.clickSave();
        
        LoggerUtil.info("Document Type Setup - Add test completed");
    }
}

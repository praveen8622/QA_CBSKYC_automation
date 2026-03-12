package workflows;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import pages.*;

public class CorporateCustRegWorkflow extends BaseCustRegWorkflow {

    // Unique Pages for Corporate Registration
    private CorporateCustRegPage corpRegPage;
    private HomePage homePage;

    public CorporateCustRegWorkflow(WebDriver driver, SoftAssert softAssert) {
        super(driver, softAssert);
        initializePages();
    }

    private void initializePages() {
        corpRegPage = new CorporateCustRegPage(driver);
        homePage = new HomePage(driver);
        syncSoftAssert();
    }

    private void syncSoftAssert() {
        corpRegPage.setSoftAssert(softAssert);
        homePage.setSoftAssert(softAssert);
    }

    @Override
    public void updateSoftAssert(SoftAssert newSoftAssert) {
        super.updateSoftAssert(newSoftAssert);
        syncSoftAssert();
    }

    // ================================
    // Unique Business Flows
    // ================================

    public void fillPrimaryRegistration(String companyName, String authority, String registeredNumber, String obligor)
            throws InterruptedException {
        // Navigate to Customer Registration and open the form
        homePage.navigateToCustomerManagement();
        homePage.navigateToCustomerRegistration();
        custRegHomePage.clickAddCustomerRegistration();

        // Select Legal Entities (This will show the Corporate Customer form)
        corpRegPage.chooseLegalStatus("Legal Entities");
        Thread.sleep(1000);

        // Fill Corporate Customer Details
        corpRegPage.enterCompanyName(companyName);
        corpRegPage.selectIssuedAuthority(authority);
        corpRegPage.enterRegisteredNumber(registeredNumber);

        // Let's ensure Authority Remarks are tested, even if empty or simple text
        corpRegPage.enterAuthorityRemarks("Registered accurately");

        Thread.sleep(1000);
        corpRegPage.selectRegisteredDate("2020", "March", "15");

        Thread.sleep(1000);
        corpRegPage.selectOnboardingChannel("Physical");
        corpRegPage.selectObligor(obligor);
        Thread.sleep(2000);
        corpRegPage.selectCountry("Nepal");
        Thread.sleep(2000);
        corpRegPage.selectIsForeignResident(false);

        Thread.sleep(2000);
        corpRegPage.clickProceedButton();
        Thread.sleep(2000);
    }
}

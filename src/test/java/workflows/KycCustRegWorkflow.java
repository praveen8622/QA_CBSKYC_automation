package workflows;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import pages.*;

public class KycCustRegWorkflow extends BaseCustRegWorkflow {
    // Unique Pages for Individual Registration
    private CustRegisterPage reg;
    private HomePage homePage;
    private CustScreeningPage custScreeningPage;

    public KycCustRegWorkflow(WebDriver driver, SoftAssert softAssert) {
        super(driver, softAssert);
        initializePages();
    }

    private void initializePages() {
        reg = new CustRegisterPage(driver);
        homePage = new HomePage(driver);
        custScreeningPage = new CustScreeningPage(driver);
        syncSoftAssert();
    }

    private void syncSoftAssert() {
        reg.setSoftAssert(softAssert);
        homePage.setSoftAssert(softAssert);
        custScreeningPage.setSoftAssert(softAssert);
    }

    @Override
    public void updateSoftAssert(SoftAssert newSoftAssert) {
        super.updateSoftAssert(newSoftAssert); // updates base pages
        syncSoftAssert(); // updates specific pages
    }

    // ================================
    // Unique Business Flows
    // ================================

    public String getScreeningId(String fullName) throws InterruptedException {
        homePage.navigateToCustomerScreening();
        custScreeningPage.enterFullName(fullName);
        custScreeningPage.clickSearch();
        return custScreeningPage.getScreeningId();
    }

    public void fillPrimaryRegistration(String screeningId, String lastName) throws InterruptedException {
        homePage.navigateToCustomerRegistration();
        custRegHomePage.clickAddCustomerRegistration();

        reg.chooseLegalStatus("Individual");
        reg.enterScreeningId(screeningId);
        reg.isEmployee("No");
        reg.enterMaidenName(lastName);
        Thread.sleep(2000);
        reg.selectBirthDate("1995", "March", "29");
        reg.enterBirthCountry("Nepal");
        reg.enterBirthAddressIfApplicable("Nepal");
        reg.selectIsForeign(false, "India");
        reg.selectIsPEP(false, "Domestic pep");
        reg.selectGender("male");
        reg.selectOnboardingChannel("Physical");

        reg.selectMaritalStatus("Single");
        reg.selectReligion("Hindu");
        reg.selectEducation("Master’s Degree");
        reg.selectMotherLanguage("Nepali");
        reg.selectPreferredCommunicationLanguage("Nepali");
        reg.selectTaxCategory("Natural Person");
        reg.clickNextButton();
    }

    public void resumeDraft(String fullName) {
        custRegHomePage.searchAndEditDraftCustomer(fullName);
    }
}

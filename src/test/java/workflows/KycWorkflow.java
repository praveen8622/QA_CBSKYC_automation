package workflows;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import pages.*;

public class KycWorkflow {
    private WebDriver driver;
    private SoftAssert softAssert;

    // Pages
    private CustRegisterPage reg;
    private CustIdentityPage identityPage;
    private CustCommunicationPage communicationPage;
    private CustDocument documentPage;
    private CustAddressPage addressPage;
    private CustHighProfilePage highProfilePage;
    private CustTransactionPage transactionPage;
    private CustCashFlowPage cashFlowPage;
    private CustExposurePage exposurePage;
    private CustEmploymentPage employmentPage;
    private CustRelationshipPage relationshipPage;
    private CustRelationshipIdentityPage relationshipIdentityPage;
    private CustRelationshipCommunication relationshipCommunicationPage;
    private CustRelationshipDocumentPage relationshipDocumentPage;
    private CustRelationshipAddressPage relationshipAddressPage;
    private CustRegHomepage custRegHomePage;
    private HomePage homePage;
    private CustScreeningPage custScreeningPage;
    private CustRelationshipPhoto relationshipPhotoPage;

    public KycWorkflow(WebDriver driver, SoftAssert softAssert) {
        this.driver = driver;
        this.softAssert = softAssert;
        initializePages();
    }

    private void initializePages() {
        reg = new CustRegisterPage(driver);
        homePage = new HomePage(driver);
        identityPage = new CustIdentityPage(driver);
        communicationPage = new CustCommunicationPage(driver);
        documentPage = new CustDocument(driver);
        addressPage = new CustAddressPage(driver);
        highProfilePage = new CustHighProfilePage(driver);
        transactionPage = new CustTransactionPage(driver);
        cashFlowPage = new CustCashFlowPage(driver);
        exposurePage = new CustExposurePage(driver);
        employmentPage = new CustEmploymentPage(driver);
        relationshipPage = new CustRelationshipPage(driver);
        relationshipIdentityPage = new CustRelationshipIdentityPage(driver);
        relationshipCommunicationPage = new CustRelationshipCommunication(driver);
        relationshipDocumentPage = new CustRelationshipDocumentPage(driver);
        relationshipAddressPage = new CustRelationshipAddressPage(driver);
        custRegHomePage = new CustRegHomepage(driver);
        custScreeningPage = new CustScreeningPage(driver);
        relationshipPhotoPage = new CustRelationshipPhoto(driver);

        syncSoftAssert();
    }

    private void syncSoftAssert() {
        reg.setSoftAssert(softAssert);
        homePage.setSoftAssert(softAssert);
        identityPage.setSoftAssert(softAssert);
        communicationPage.setSoftAssert(softAssert);
        documentPage.setSoftAssert(softAssert);
        addressPage.setSoftAssert(softAssert);
        highProfilePage.setSoftAssert(softAssert);
        transactionPage.setSoftAssert(softAssert);
        cashFlowPage.setSoftAssert(softAssert);
        exposurePage.setSoftAssert(softAssert);
        employmentPage.setSoftAssert(softAssert);
        relationshipPage.setSoftAssert(softAssert);
        relationshipIdentityPage.setSoftAssert(softAssert);
        relationshipCommunicationPage.setSoftAssert(softAssert);
        relationshipDocumentPage.setSoftAssert(softAssert);
        relationshipAddressPage.setSoftAssert(softAssert);
        custRegHomePage.setSoftAssert(softAssert);
        custScreeningPage.setSoftAssert(softAssert);
        relationshipPhotoPage.setSoftAssert(softAssert);
    }

    public void updateSoftAssert(SoftAssert newSoftAssert) {
        this.softAssert = newSoftAssert;
        syncSoftAssert();
    }

    // ================================
    // Business Flows
    // ================================

    public String getScreeningId(String fullName) throws InterruptedException {
        homePage.navigateToCustomerScreening();
        custScreeningPage.enterFullName(fullName);
        custScreeningPage.clickSearch();
        Thread.sleep(2000);
        return custScreeningPage.getScreeningId();
    }

    public void fillPrimaryRegistration(String screeningId, String lastName) throws InterruptedException {
        homePage.navigateToCustomerRegistration();
        custRegHomePage.clickAddCustomerRegistration();

        reg.chooseLegalStatus("Individual");
        reg.enterScreeningId(screeningId);
        Thread.sleep(1000);
        reg.isEmployee("No");
        Thread.sleep(1000);
        reg.enterMaidenName(lastName);
        Thread.sleep(1000);
        reg.selectBirthDate("1995", "March", "29");
        Thread.sleep(1000);
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
        Thread.sleep(1000);
        reg.clickNextButton();
        Thread.sleep(1000);
    }

    public void resumeDraft(String fullName) {
        custRegHomePage.searchAndEditDraftCustomer(fullName);
    }

    public void fillIdentityDetails(String licenseNumber, String relativePath) throws InterruptedException {
        custRegHomePage.navigateToIdentityTab();
        identityPage.openAddIdentityForm();
        Thread.sleep(1000);
        identityPage.selectIdentityTypeAndFillConditionalField("Citizenship", "Kathmandu");
        identityPage.enterIdentityNumber(licenseNumber);
        Thread.sleep(1000);
        identityPage.selectIssueDate("2020", "March", "29");
        Thread.sleep(1000);
        identityPage.handleExpiryDateIfApplicable("2030", "March", "30");
        Thread.sleep(1000);
        identityPage.uploadIdentityDocument(relativePath);
        Thread.sleep(1000);
        identityPage.clickSaveIdentity();
        Thread.sleep(1000);
        identityPage.clickNextbutton();
        Thread.sleep(1000);
    }

    public void fillCommunicationDetails(String mobileNumber) throws InterruptedException {
        custRegHomePage.navigateToCommunicationTab();
        communicationPage.openAddCommunicationForm();
        Thread.sleep(1000);
        communicationPage.selectDevice("Mobile");
        Thread.sleep(1000);
        communicationPage.selectIsPersonalDevice("Yes");
        Thread.sleep(1000);
        communicationPage.enterPriorityOrder("1");
        Thread.sleep(1000);
        communicationPage.enterDeviceNumber(mobileNumber);
        Thread.sleep(1000);
        communicationPage.clickSaveButton();
        Thread.sleep(1000);
        communicationPage.clickNextbutton();
        Thread.sleep(1000);
    }

    public void fillDocumentDetails(String passportNumber, String relativePath) throws InterruptedException {
        custRegHomePage.navigateToDocumentTab();
        documentPage.clickAddDocument();
        documentPage.selectDocumentType("Passport");
        documentPage.enterDocumentTitle("Passport");
        documentPage.enterDocumentNumber(passportNumber);
        Thread.sleep(1000);
        documentPage.uploadDocument(relativePath);
        documentPage.clickSave();
        Thread.sleep(1000);
    }

    public void fillAddressDetails(String relativePath) throws InterruptedException {
        custRegHomePage.navigateToAddressTab();
        addressPage.openAddAddressForm();
        Thread.sleep(1000);
        addressPage.selectAddressType("Permanent");
        Thread.sleep(1000);
        addressPage.selectState("Bagmati");
        Thread.sleep(1000);
        addressPage.selectDistrict("Kathmandu");
        Thread.sleep(1000);
        addressPage.selectLocalBody("Kathmandu");
        Thread.sleep(1000);
        addressPage.enterPostalCode("12345");
        Thread.sleep(1000);
        addressPage.enterStreet("Kathmandu");
        Thread.sleep(1000);
        addressPage.enterWardNo("123");
        Thread.sleep(1000);
        addressPage.enterHouseNo("123");
        Thread.sleep(1000);
        addressPage.enterLatitude("123");
        Thread.sleep(1000);
        addressPage.enterLongitude("123");
        Thread.sleep(1000);
        addressPage.uploadAddressDocument(relativePath);
        Thread.sleep(1000);
        addressPage.clickSave();
        Thread.sleep(1000);
        addressPage.clickNext();
        Thread.sleep(1000);
    }

    public void fillHighProfileDetails(String fullName) throws InterruptedException {
        custRegHomePage.navigateToHighProfileTab();
        Thread.sleep(1000);
        highProfilePage.openAddHighProfileForm();
        Thread.sleep(1000);
        highProfilePage.enterFullName(fullName);
        Thread.sleep(1000);
        highProfilePage.selectGender("male");
        Thread.sleep(1000);
        highProfilePage.selectRelation("father");
        Thread.sleep(1000);
        highProfilePage.selectOccupation("engineer");
        Thread.sleep(1000);
        highProfilePage.selectCitizenshipCategory("Pure Domestic Citizen");
        Thread.sleep(1000);
        highProfilePage.selectPrimaryCitizenCountry("Nepal");
        Thread.sleep(1000);
        highProfilePage.selectSecondaryCitizenCountry("Nepal");
        Thread.sleep(1000);
        highProfilePage.selectResidentCountry("Nepal");
        Thread.sleep(1000);
        highProfilePage.selectPrCountry("Nepal");
        Thread.sleep(1000);
        highProfilePage.selectEducation("master");
        Thread.sleep(1000);
        highProfilePage.enterPosition("Manager");
        Thread.sleep(1000);
        highProfilePage.clickSave();
        Thread.sleep(1000);
        highProfilePage.clickNext();
        Thread.sleep(1000);
    }

    public void fillTransactionDetails() throws InterruptedException {
        custRegHomePage.navigateToTransactionVolumeTab();
        transactionPage.enterTransactionDetails("Daily", true, "10000", "5");
        transactionPage.enterTransactionDetails("Weekly", true, "50000", "10");
        Thread.sleep(1000);
        transactionPage.clickSave();
        Thread.sleep(1000);
    }

    public void fillCashFlowDetails() throws InterruptedException {
        custRegHomePage.navigateToCashFlowTab();
        Thread.sleep(1000);
        cashFlowPage.clickAdd();
        Thread.sleep(1000);
        cashFlowPage.enterCashFlowDetails("Income", "Monthly", "10000");
        Thread.sleep(1000);
        cashFlowPage.clickSave();
        Thread.sleep(1000);
    }

    public void fillExposureDetails() throws InterruptedException {
        custRegHomePage.navigateToExposureTab();
        Thread.sleep(1000);
        exposurePage.clickAdd();
        Thread.sleep(1000);
        exposurePage.enterExposureDetails("Banking", "Global IME Bank", "Loans", "500000", "12", "60");
        Thread.sleep(1000);
        exposurePage.clickSave();
        Thread.sleep(1000);
    }

    public void fillEmploymentDetails() throws InterruptedException {
        custRegHomePage.navigateToEmploymentTab();
        Thread.sleep(1000);
        employmentPage.clickAdd();
        Thread.sleep(1000);
        employmentPage.enterEmploymentDetails("Salaried", "Engineer", "Manager", "Tech Corp", "Kathmandu", "1200000");
        Thread.sleep(1000);
        employmentPage.clickSave();
        Thread.sleep(1000);
    }

    public void fillRelationshipMasterDetails() throws InterruptedException {
        custRegHomePage.navigateToRelationshipMasterTab();
        Thread.sleep(1000);
        custRegHomePage.clickAddRelationshipBtn();
        Thread.sleep(1000);
        relationshipPage.setKycCategory("Family");
        Thread.sleep(1000);
        relationshipPage.selectRelation("Father");
        Thread.sleep(1000);
        relationshipPage.enterFirstName("Hari", "हरि");
        Thread.sleep(1000);
        relationshipPage.enterLastName("Karki", "कारकि");
        Thread.sleep(1000);
        relationshipPage.selectBirthDate("2000", "January", "1");
        Thread.sleep(1000);
        relationshipPage.selectBirthCountry("Nepal");
        Thread.sleep(1000);
        relationshipPage.selectGender("Male");
        Thread.sleep(1000);
        relationshipPage.selectMaritalStatus("Single");
        Thread.sleep(1000);
        relationshipPage.selectOccupation("Engineer");
        Thread.sleep(1000);
        relationshipPage.selectEducation("Master’s Degree'");
        Thread.sleep(2000);
        relationshipPage.clickNext();
        Thread.sleep(2000);
    }

    public void fillRelationshipIdentityDetails(String licenseNumber, String relativePath) throws InterruptedException {
        relationshipIdentityPage.clickIdentityTab();
        Thread.sleep(1000);
        relationshipIdentityPage.clickAddIdentity();
        Thread.sleep(1000);
        relationshipIdentityPage.selectIdentityTypeAndFillConditionalField("Driver’s License", "Bagmati Province");
        Thread.sleep(1000);
        relationshipIdentityPage.enterIdentityNumber(licenseNumber);
        Thread.sleep(1000);
        relationshipIdentityPage.selectIssueDate("2021", "January", "1");
        Thread.sleep(1000);
        relationshipIdentityPage.handleExpiryDateIfApplicable("2031", "January", "1");
        Thread.sleep(1000);
        relationshipIdentityPage.uploadDocument(relativePath);
        Thread.sleep(1000);
        relationshipIdentityPage.clickSave();
        Thread.sleep(2000);
        relationshipIdentityPage.clickNext();
        Thread.sleep(2000);
    }

    public void fillRelationshipCommunicationDetails(String mobileNumber) throws InterruptedException {
        relationshipCommunicationPage.clickCommunicationTab();
        Thread.sleep(1000);
        relationshipCommunicationPage.clickAddCommunication();
        Thread.sleep(1000);
        relationshipCommunicationPage.selectCommunicationType("Mobile");
        Thread.sleep(1000);
        relationshipCommunicationPage.enterCommunicationNumber(mobileNumber);
        Thread.sleep(1000);
        relationshipCommunicationPage.clickSaveCommunication();
        Thread.sleep(2000);
        relationshipCommunicationPage.clickNext();
        Thread.sleep(2000);
    }

    public void fillRelationshipDocumentDetails(String docNumber, String relativePath) throws InterruptedException {
        relationshipDocumentPage.clickDocumentTab();
        Thread.sleep(1000);
        relationshipDocumentPage.clickAddDocument();
        Thread.sleep(1000);
        relationshipDocumentPage.selectDocumentType("Citizenship");
        Thread.sleep(1000);
        relationshipDocumentPage.enterDocumentTitle("Citizenship Front");
        Thread.sleep(1000);
        relationshipDocumentPage.enterDocumentNumber(docNumber);
        Thread.sleep(1000);
        relationshipDocumentPage.selectMimeType("image/png");
        Thread.sleep(1000);
        relationshipDocumentPage.uploadDocument(relativePath);
        Thread.sleep(1000);
        relationshipDocumentPage.clickSave();
        Thread.sleep(2000);
        relationshipDocumentPage.clickNext();
        Thread.sleep(2000);
    }

    public void fillRelationshipAddressDetails() throws InterruptedException {
        relationshipAddressPage.clickAddressTab();
        Thread.sleep(1000);
        relationshipAddressPage.clickAddAddress();
        Thread.sleep(1000);
        relationshipAddressPage.selectAddressType("Permanent");
        Thread.sleep(1000);
        relationshipAddressPage.selectState("Bagmati");
        Thread.sleep(1000);
        relationshipAddressPage.selectDistrict("Kathmandu");
        Thread.sleep(1000);
        relationshipAddressPage.selectTownship("Kathmandu Metropolitan City");
        Thread.sleep(1000);
        relationshipAddressPage.enterPostalCode("44600");
        Thread.sleep(1000);
        relationshipAddressPage.enterStreet("Main Street");
        Thread.sleep(1000);
        relationshipAddressPage.enterWardNo("4");
        Thread.sleep(1000);
        relationshipAddressPage.enterHouseNo("123");
        Thread.sleep(1000);
        relationshipAddressPage.enterLatitude("27.7172");
        Thread.sleep(1000);
        relationshipAddressPage.enterLongitude("85.3240");
        Thread.sleep(1000);
        relationshipAddressPage.clickSave();
        Thread.sleep(2000);
        relationshipAddressPage.clickNext();
        Thread.sleep(2000);
    }

    public void fillRelationshipPhoto(String relativePath) throws InterruptedException {
        relationshipPhotoPage.clickPhotoTab();
        Thread.sleep(1000);
        relationshipPhotoPage.uploadPhoto(relativePath);
        Thread.sleep(1000);
        relationshipPhotoPage.clickSaveButton();
        Thread.sleep(2000);
        // relationshipPhotoPage.clickCloseButton();
        // Thread.sleep(2000);
        relationshipPhotoPage.clickNextButton();
        Thread.sleep(2000);
    }
}

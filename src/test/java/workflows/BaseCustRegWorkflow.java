package workflows;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import pages.*;

public class BaseCustRegWorkflow {
    protected WebDriver driver;
    protected SoftAssert softAssert;

    // Common Pages
    protected CustRegHomepage custRegHomePage;
    protected CustIdentityPage identityPage;
    protected CustCommunicationPage communicationPage;
    protected CustDocument documentPage;
    protected CustAddressPage addressPage;
    protected CustHighProfilePage highProfilePage;
    protected CustTransactionPage transactionPage;
    protected CustCashFlowPage cashFlowPage;
    protected CustExposurePage exposurePage;
    protected CustEmploymentPage employmentPage;
    protected CustRelationshipPage relationshipPage;
    protected CustRelationshipIdentityPage relationshipIdentityPage;
    protected CustRelationshipCommunication relationshipCommunicationPage;
    protected CustRelationshipDocumentPage relationshipDocumentPage;
    protected CustRelationshipAddressPage relationshipAddressPage;
    protected CustRelationshipPhoto relationshipPhotoPage;

    public BaseCustRegWorkflow(WebDriver driver, SoftAssert softAssert) {
        this.driver = driver;
        this.softAssert = softAssert;
        initializeBasePages();
    }

    private void initializeBasePages() {
        custRegHomePage = new CustRegHomepage(driver);
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
        relationshipPhotoPage = new CustRelationshipPhoto(driver);
        syncBaseSoftAssert();
    }

    private void syncBaseSoftAssert() {
        custRegHomePage.setSoftAssert(softAssert);
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
        relationshipPhotoPage.setSoftAssert(softAssert);
    }

    public void updateSoftAssert(SoftAssert newSoftAssert) {
        this.softAssert = newSoftAssert;
        syncBaseSoftAssert();
    }

    // ================================
    // Shared Business Flows
    // ================================

    public void fillIdentityDetails(String licenseNumber, String relativePath) throws InterruptedException {
        custRegHomePage.navigateToIdentityTab();
        identityPage.openAddIdentityForm();
        Thread.sleep(1000);
        identityPage.selectIdentityTypeAndFillConditionalField("Citizenship", "Kathmandu");
        identityPage.enterIdentityNumber(licenseNumber);
        Thread.sleep(1000);
        identityPage.selectIssueDate("2020", "March", "29");
        Thread.sleep(1000);
        // identityPage.handleExpiryDateIfApplicable("2030", "March", "30");
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
        addressPage.enterHouseNo("342");
        Thread.sleep(1000);
        addressPage.enterLatitude("27.7172");
        Thread.sleep(1000);
        addressPage.enterLongitude("85.3240");
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

    public void fillIndividualRelationshipMaster(boolean isMember, String customerCode, String firstName,
            String lastName) throws InterruptedException {
        custRegHomePage.navigateToRelationshipMasterTab();
        Thread.sleep(1000);
        custRegHomePage.clickAddRelationshipBtn();
        Thread.sleep(1000);

        relationshipPage.setMemberCustomer(isMember, customerCode);
        Thread.sleep(1000);

        relationshipPage.setKycCategory("Family");
        Thread.sleep(1000);

        relationshipPage.selectRelation("Father");
        Thread.sleep(1000);

        if (!isMember) {
            relationshipPage.enterFirstName(firstName, "");
            Thread.sleep(1000);
            relationshipPage.enterLastName(lastName, "");
            Thread.sleep(1000);
            relationshipPage.selectBirthDate("1985", "May", "15");
            Thread.sleep(1000);
            relationshipPage.selectBirthCountry("Nepal");
            Thread.sleep(1000);
            relationshipPage.selectMaritalStatus("Married");
            Thread.sleep(1000);
            relationshipPage.selectOccupation("Education");
            Thread.sleep(1000);
            relationshipPage.selectEducation("Master’s Degree");
            Thread.sleep(2000);
        }

        relationshipPage.clickNext();
        Thread.sleep(2000);
    }

    public void fillCorporateRelationshipMaster(boolean isMemberCustomer, String customerCode, String kycCategory,
            String firstName,
            String lastName)
            throws InterruptedException {
        custRegHomePage.navigateToRelationshipMasterTab();
        Thread.sleep(1000);
        custRegHomePage.clickAddRelationshipBtn();
        Thread.sleep(1000);

        relationshipPage.setMemberCustomer(isMemberCustomer, customerCode);
        Thread.sleep(1000);

        relationshipPage.setKycCategory(kycCategory);
        Thread.sleep(1000);

        if (kycCategory.equalsIgnoreCase("Shareholder")) {
            relationshipPage.selectShareHolderScope("Individual");
            Thread.sleep(1000);

            relationshipPage.setIsShareHolderSelfBeneficiaryOwner(true, "10");
            Thread.sleep(1000);
        }
        if (!isMemberCustomer) {
            relationshipPage.enterFirstName(firstName, "");
            Thread.sleep(1000);
            relationshipPage.enterLastName(lastName, "");
            Thread.sleep(1000);
            relationshipPage.selectBirthDate("1985", "May", "15");
            Thread.sleep(1000);
            relationshipPage.selectBirthCountry("Nepal");
            Thread.sleep(1000);
            relationshipPage.selectGender("Male");
            Thread.sleep(1000);
            relationshipPage.selectMaritalStatus("Married");
            Thread.sleep(1000);
            relationshipPage.selectOccupation("Service");
            Thread.sleep(1000);
            relationshipPage.selectEducation("Master’s Degree");
            Thread.sleep(2000);
        }

        relationshipPage.clickNext();
        Thread.sleep(2000);
    }

    public void fillRelationshipIdentityDetails(String licenseNumber, String relativePath) throws InterruptedException {
        relationshipIdentityPage.clickIdentityTab();
        Thread.sleep(2000);
        relationshipIdentityPage.clickAddIdentity();
        Thread.sleep(2000);
        relationshipIdentityPage.selectIdentityTypeAndFillConditionalField("Driver’s License", "Bagmati Province");
        Thread.sleep(2000);
        relationshipIdentityPage.enterIdentityNumber(licenseNumber);
        Thread.sleep(1000);
        relationshipIdentityPage.selectIssueDate("2021", "January", "1");
        Thread.sleep(1000);
        // relationshipIdentityPage.handleExpiryDateIfApplicable("2031", "January",
        // "1");
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

    public void skipRelationshipIdentityDetails() throws InterruptedException {
        relationshipIdentityPage.clickNext();
        Thread.sleep(2000);
    }

    public void skipRelationshipCommunicationDetails() throws InterruptedException {
        relationshipCommunicationPage.clickNext();
        Thread.sleep(2000);
    }

    public void skipRelationshipDocumentDetails() throws InterruptedException {
        relationshipDocumentPage.clickNext();
        Thread.sleep(2000);
    }

    public void skipRelationshipAddressDetails() throws InterruptedException {
        relationshipAddressPage.clickNext();
        Thread.sleep(2000);
    }

    public void skipRelationshipPhoto() throws InterruptedException {
        relationshipPhotoPage.clickSaveButton();
        Thread.sleep(2000);
    }
}

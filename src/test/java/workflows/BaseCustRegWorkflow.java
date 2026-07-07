package workflows;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import pages.*;
import pages.cust_reg.*;

public class BaseCustRegWorkflow {
    protected WebDriver driver;
    protected SoftAssert softAssert;

    // Common Pages
    protected CustRegHomepage custRegHomePage;
    protected CustIdentityPage identityPage;
    protected CustCommunicationPage communicationPage;
    protected CustDocument documentPage;
    protected CustAddressPage addressPage;
    protected CustPhotoPage photoPage;
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
    protected CustApprovalPage approvalPage;

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
        photoPage = new CustPhotoPage(driver);
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
        approvalPage = new CustApprovalPage(driver);
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
        approvalPage.setSoftAssert(softAssert);
    }

    public void updateSoftAssert(SoftAssert newSoftAssert) {
        this.softAssert = newSoftAssert;
        syncBaseSoftAssert();
    }

    // ================================
    // Shared Business Flows
    // ================================

    public void fillIdentityDetails(String documentNum, String relativePath) throws InterruptedException {
        custRegHomePage.navigateToIdentityTab();
        identityPage.openAddIdentityForm();
        identityPage.selectIdentityTypeAndFillConditionalField("Citizenship", "Kathmandu");
        identityPage.enterIdentityNumber(documentNum);
        identityPage.selectIssueDate("2020", "March", "29");
        identityPage.uploadIdentityDocument(relativePath);
        identityPage.clickSaveIdentity();
        Thread.sleep(2000);
        identityPage.clickNextbutton();
    }

    public void fillIdentityDetailsCorporate(String documentNum, String relativePath) throws InterruptedException {
        custRegHomePage.navigateToIdentityTab();
        identityPage.openAddIdentityForm();
        identityPage.selectIdentityTypeAndFillConditionalField("Company Registration Certificate", "DAO");
        identityPage.enterIdentityNumber(documentNum);
        identityPage.selectIssueDate("2020", "March", "29");
        // identityPage.handleExpiryDateIfApplicable("2030", "March", "30");
        identityPage.uploadIdentityDocument(relativePath);
        identityPage.clickSaveIdentity();
        identityPage.clickNextbutton();
    }

    public void fillCommunicationDetails(String mobileNumber) throws InterruptedException {
        custRegHomePage.navigateToCommunicationTab();
        communicationPage.openAddCommunicationForm();
        communicationPage.selectDevice("Mobile");
        communicationPage.selectIsPersonalDevice("Yes");
        communicationPage.enterPriorityOrder("1");
        communicationPage.enterDeviceNumber(mobileNumber);
        communicationPage.clickSaveButton();
        communicationPage.clickNextbutton();
    }

    public void fillDocumentDetails(String passportNumber, String relativePath) throws InterruptedException {
        custRegHomePage.navigateToDocumentTab();
        documentPage.clickAddDocument();
        documentPage.selectDocumentType("National Identity");
        documentPage.enterDocumentTitle("NID");
        documentPage.enterDocumentNumber(passportNumber);
        documentPage.uploadDocument(relativePath);
        documentPage.clickSave();
    }

    public void fillAddressDetails(String relativePath) throws InterruptedException {
        custRegHomePage.navigateToAddressTab();
        addressPage.openAddAddressForm();
        addressPage.selectAddressType("Permanent");
        addressPage.selectState("Bagmati");
        addressPage.selectDistrict("Kathmandu");
        addressPage.selectLocalBody("Kathmandu");
        addressPage.enterPostalCode("12345");
        addressPage.enterStreet("Kathmandu");
        addressPage.enterWardNo("123");
        // addressPage.enterHouseNo("342");
        // Thread.sleep(1000);
        // addressPage.enterLatitude("27.7172");
        // Thread.sleep(1000);
        // addressPage.enterLongitude("85.3240");
        addressPage.uploadAddressDocument(relativePath);
        addressPage.clickSave();
        addressPage.clickNext();
    }

    public void fillCustomerPhoto(String relativePath) throws InterruptedException {
        custRegHomePage.navigateToPhotoTab();
        photoPage.uploadPhoto(relativePath);
        photoPage.clickSaveButton();
    }

    public void fillHighProfileDetails(String fullName) throws InterruptedException {
        custRegHomePage.navigateToHighProfileTab();
        highProfilePage.openAddHighProfileForm();
        highProfilePage.enterFullName(fullName);
        highProfilePage.selectGender("male");
        highProfilePage.selectRelation("father");
        highProfilePage.selectOccupation("engineer");
        highProfilePage.selectCitizenshipCategory("Pure Domestic Citizen");
        highProfilePage.selectPrimaryCitizenCountry("Nepal");
        highProfilePage.selectSecondaryCitizenCountry("Nepal");
        highProfilePage.selectResidentCountry("Nepal");
        highProfilePage.selectPrCountry("Nepal");
        highProfilePage.selectEducation("master");
        highProfilePage.enterPosition("Manager");
        highProfilePage.clickSave();
        highProfilePage.clickNext();
    }

    public void fillTransactionDetails() throws InterruptedException {
        custRegHomePage.navigateToTransactionVolumeTab();
        transactionPage.enterTransactionDetails("Daily", true, "10000", "5");
        transactionPage.enterTransactionDetails("Weekly", true, "50000", "10");
        transactionPage.clickSave();
    }

    public void fillCashFlowDetails() throws InterruptedException {
        custRegHomePage.navigateToCashFlowTab();
        cashFlowPage.clickAdd();
        cashFlowPage.enterCashFlowDetails("Income", "Monthly", "10000");
        cashFlowPage.clickSave();
    }

    public void fillExposureDetails() throws InterruptedException {
        custRegHomePage.navigateToExposureTab();
        exposurePage.clickAdd();
        exposurePage.enterExposureDetails("Banking", "Global IME Bank", "Loans", "500000", "12", "60");
        exposurePage.clickSave();
    }

    public void fillEmploymentDetails() throws InterruptedException {
        custRegHomePage.navigateToEmploymentTab();
        employmentPage.clickAdd();
        employmentPage.enterEmploymentDetails("Salaried", "Engineer", "Manager", "Tech Corp", "Kathmandu", "1200000");
        employmentPage.clickSave();
    }

    public void fillIndividualRelationshipMaster(boolean isMember, String customerCode, String firstName,
            String lastName) throws InterruptedException {
        custRegHomePage.navigateToRelationshipMasterTab();
        custRegHomePage.clickAddRelationshipBtn();

        relationshipPage.setMemberCustomer(isMember, customerCode);

        relationshipPage.setKycCategory("Family");

        relationshipPage.selectRelation("Father");

        if (!isMember) {
            relationshipPage.enterFirstName(firstName, "");
            relationshipPage.enterLastName(lastName, "");
            relationshipPage.selectBirthDate("1985", "May", "15");
            relationshipPage.selectBirthCountry("Nepal");
            relationshipPage.selectMaritalStatus("Married");
            // Thread.sleep(1000);
            // relationshipPage.selectOccupation("Education");
            // Thread.sleep(1000);
            // relationshipPage.selectEducation("Master’s Degree");
            // Thread.sleep(2000);
        }

        relationshipPage.clickNext();
    }

    public void fillCorporateRelationshipMaster(boolean isMemberCustomer, String customerCode, String kycCategory,
            String firstName,
            String lastName)
            throws InterruptedException {
        custRegHomePage.navigateToRelationshipMasterTab();
        custRegHomePage.clickAddRelationshipBtn();

        relationshipPage.setMemberCustomer(isMemberCustomer, customerCode);

        relationshipPage.setKycCategory(kycCategory);

        if (kycCategory.equalsIgnoreCase("Shareholder")) {
            relationshipPage.selectShareHolderScope("Individual");

            relationshipPage.setIsShareHolderSelfBeneficiaryOwner(true, "10");
        }
        if (!isMemberCustomer) {
            relationshipPage.enterFirstName(firstName, "");
            relationshipPage.enterLastName(lastName, "");
            relationshipPage.selectBirthDate("1985", "May", "15");
            relationshipPage.selectBirthCountry("Nepal");
            relationshipPage.selectGender("Male");
            relationshipPage.selectMaritalStatus("Married");
            relationshipPage.selectOccupation("Service");
            // relationshipPage.selectEducation("Master’s Degree");
            // Thread.sleep(2000);
        }

        relationshipPage.clickNext();
    }

    public void fillRelationshipIdentityDetails(String licenseNumber, String relativePath) throws InterruptedException {
        Thread.sleep(2000);
        relationshipIdentityPage.clickIdentityTab();
        relationshipIdentityPage.clickAddIdentity();
        relationshipIdentityPage.selectIdentityTypeAndFillConditionalField("Citizenship", "Kathmandu");
        relationshipIdentityPage.enterIdentityNumber(licenseNumber);
        relationshipIdentityPage.selectIssueDate("2021", "January", "10");
        relationshipIdentityPage.uploadDocument(relativePath);
        relationshipIdentityPage.clickSave();
        relationshipIdentityPage.clickNext();
    }

    public void fillRelationshipCommunicationDetails(String mobileNumber) throws InterruptedException {
        Thread.sleep(2000);

        relationshipCommunicationPage.clickCommunicationTab();
        relationshipCommunicationPage.clickAddCommunication();
        relationshipCommunicationPage.selectCommunicationType("Mobile");
        relationshipCommunicationPage.enterCommunicationNumber(mobileNumber);
        relationshipCommunicationPage.clickSaveCommunication();
        relationshipCommunicationPage.clickNext();
    }

    public void fillRelationshipDocumentDetails(String docNumber, String relativePath) throws InterruptedException {
        Thread.sleep(2000);
        relationshipDocumentPage.clickDocumentTab();
        relationshipDocumentPage.clickAddDocument();
        relationshipDocumentPage.selectDocumentType("National ID");
        relationshipDocumentPage.enterDocumentTitle("NID");
        relationshipDocumentPage.enterDocumentNumber(docNumber);
        relationshipDocumentPage.uploadDocument(relativePath);
        relationshipDocumentPage.clickSave();
        relationshipDocumentPage.clickNext();
    }

    public void fillRelationshipAddressDetails() throws InterruptedException {
        Thread.sleep(2000);
        relationshipAddressPage.clickAddressTab();
        relationshipAddressPage.clickAddAddress();
        relationshipAddressPage.selectAddressType("Permanent");
        relationshipAddressPage.selectState("Bagmati");
        relationshipAddressPage.selectDistrict("Kathmandu");
        relationshipAddressPage.selectTownship("Kathmandu Metropolitian City");
        relationshipAddressPage.enterPostalCode("44600");
        // relationshipAddressPage.enterStreet("Main Street");
        relationshipAddressPage.enterWardNo("4");
        // relationshipAddressPage.enterHouseNo("123");
        // relationshipAddressPage.enterLatitude("27.7172");
        // relationshipAddressPage.enterLongitude("85.3240");
        relationshipAddressPage.clickSave();
        relationshipAddressPage.clickNext();
    }

    public void fillRelationshipPhoto(String relativePath) throws InterruptedException {
        Thread.sleep(2000);

        relationshipPhotoPage.clickPhotoTab();
        relationshipPhotoPage.uploadPhoto(relativePath);
        relationshipPhotoPage.clickSaveButton();
        // relationshipPhotoPage.clickCloseButton();
        relationshipPhotoPage.clickNextButton();
    }

    public void sendApproval() throws InterruptedException {
        approvalPage.clickAdditionalFormTab();
        approvalPage.clickSendForApprovalButton();
    }

    public void skipRelationshipIdentityDetails() throws InterruptedException {
        relationshipIdentityPage.clickNext();
    }

    public void skipRelationshipCommunicationDetails() throws InterruptedException {
        relationshipCommunicationPage.clickNext();
    }

    public void skipRelationshipDocumentDetails() throws InterruptedException {
        relationshipDocumentPage.clickNext();
    }

    public void skipRelationshipAddressDetails() throws InterruptedException {
        relationshipAddressPage.clickNext();
    }

    public void skipRelationshipPhoto() throws InterruptedException {
        relationshipPhotoPage.clickSaveButton();
    }

}

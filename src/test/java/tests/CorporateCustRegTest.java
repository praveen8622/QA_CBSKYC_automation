package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTestSequential;
import utilities.DataGenerator;
import utilities.LoggerUtil;
import workflows.CorporateCustRegWorkflow;

public class CorporateCustRegTest extends BaseTestSequential {

    private CorporateCustRegWorkflow corpKyc;
    private String testImagePath = "testimages/testdoc.jpg";
    private String profileImagePath = "testimages/profile.jpg";
    private boolean isMemberCustomer = false;

    @BeforeClass
    public void pageSetup() {
        corpKyc = new CorporateCustRegWorkflow(driver, softAssert);
    }

    @BeforeMethod
    public void setupSoftAssert() {
        corpKyc.updateSoftAssert(softAssert);
    }

    @Test(priority = 1, description = "Verify Corporate Customer Registration")
    public void verifyCorporateCustomerRegistration() throws InterruptedException {
        LoggerUtil.info("Corporate Registration test started");

        String companyName = DataGenerator.generateRandomCompanyName();
        String registeredNumber = DataGenerator.generateRandomNumber(6);

        // Assuming common dropdown values are available in the mock/actual data:
        // Adjust "Company Registrar" and "Main Entity" based on actual dropdown list if
        // needed.
        corpKyc.fillPrimaryRegistration(companyName, "Company", registeredNumber, "Nepal Electricity");

        softAssert.assertAll();
    }

    @Test(priority = 2, description = "Verify Identity Details")
    public void verifyIdentityDetails() throws InterruptedException {
        LoggerUtil.title("Identity Details test started");
        corpKyc.fillIdentityDetails(DataGenerator.generateRandomLicense(),
                testImagePath);
        softAssert.assertAll();
    }

    @Test(priority = 3, description = "Verify Communication Details")
    public void verifyCommunicationDetails() throws InterruptedException {
        LoggerUtil.title("Communication Details test started");
        corpKyc.fillCommunicationDetails(DataGenerator.generateRandomPhoneNumber());
        softAssert.assertAll();
    }

    @Test(priority = 4, description = "Verify Document Details")
    public void verifyDocumentDetails() throws InterruptedException {
        LoggerUtil.title("Document Details test started");
        corpKyc.fillDocumentDetails(DataGenerator.generateRandomPassport(),
                testImagePath);
        softAssert.assertAll();
    }

    @Test(priority = 5, description = "Verify Address Details")
    public void verifyAddressDetails() throws InterruptedException {
        LoggerUtil.title("Address Details test started");
        corpKyc.fillAddressDetails(testImagePath);
        softAssert.assertAll();
    }

    @Test(priority = 6, description = "Verify High Profile Details")
    public void verifyHighProfileDetails() throws InterruptedException {
        LoggerUtil.title("High Profile Details test started");
        String fullName = DataGenerator.generateRandomfirstName() + " " +
                DataGenerator.generateRandomlastName();
        corpKyc.fillHighProfileDetails(fullName);
        softAssert.assertAll();
    }

    @Test(priority = 7, description = "Verify Transaction Details")
    public void verifyTransactionDetails() throws InterruptedException {
        LoggerUtil.title("Transaction Details test started");
        corpKyc.fillTransactionDetails();
        softAssert.assertAll();
    }

    @Test(priority = 8, description = "Verify Cash Flow Details")
    public void verifyCashFlowDetails() throws InterruptedException {
        LoggerUtil.title("Cash Flow Details test started");
        corpKyc.fillCashFlowDetails();
        softAssert.assertAll();
    }

    @Test(priority = 9, description = "Verify Exposure Details")
    public void verifyExposureDetails() throws InterruptedException {
        LoggerUtil.title("Exposure Details test started");
        corpKyc.fillExposureDetails();
        softAssert.assertAll();
    }

    @Test(priority = 10, description = "Verify Relationship Master")
    public void verifyRelationshipDetails() throws InterruptedException {
        LoggerUtil.title("Relationship Details test started");

        String firstName = DataGenerator.generateRandomfirstName();
        String lastName = DataGenerator.generateRandomlastName();
        // Since it's corporate, let's test a Shareholder scenario
        corpKyc.fillCorporateRelationshipMaster(isMemberCustomer, "", "Board of Directors", firstName, lastName);
        softAssert.assertAll();
    }

    @Test(priority = 11, description = "Verify Relationship Identity")
    public void verifyRelationshipIdentity() throws InterruptedException {
        LoggerUtil.title("Relationship Identity Details test started");
        if (isMemberCustomer) {
            LoggerUtil.info("Skipping Identity details, clicking Next");
            corpKyc.skipRelationshipIdentityDetails();
            return;
        }

        corpKyc.fillRelationshipIdentityDetails(DataGenerator.generateRandomLicense(), testImagePath);
        softAssert.assertAll();
    }

    @Test(priority = 12, description = "Verify Relationship Communication")
    public void verifyRelationshipCommunication() throws InterruptedException {
        LoggerUtil.title("Relationship Communication Details test started");
        if (isMemberCustomer) {
            LoggerUtil.info("Skipping Communication details, clicking Next");
            corpKyc.skipRelationshipCommunicationDetails();
            return;
        }
        corpKyc.fillRelationshipCommunicationDetails(DataGenerator.generateRandomPhoneNumber());
        softAssert.assertAll();
    }

    @Test(priority = 13, description = "Verify Relationship Document")
    public void verifyRelationshipDocument() throws InterruptedException {
        LoggerUtil.title("Relationship Document Details test started");

        if (isMemberCustomer) {
            LoggerUtil.info("Skipping Document details, clicking Next");
            corpKyc.skipRelationshipDocumentDetails();
            return;
        }
        corpKyc.fillRelationshipDocumentDetails(DataGenerator.generateRandomNumber(10), testImagePath);
        softAssert.assertAll();
    }

    @Test(priority = 14, description = "Verify Relationship Address")
    public void verifyRelationshipAddress() throws InterruptedException {
        LoggerUtil.title("Relationship Address Details test started");
        if (isMemberCustomer) {
            LoggerUtil.info("Skipping Address details, clicking Next");
            corpKyc.skipRelationshipAddressDetails();
            return;
        }
        corpKyc.fillRelationshipAddressDetails();
        softAssert.assertAll();
    }

    @Test(priority = 15, description = "Verify Relationship Photo")
    public void verifyRelationshipPhoto() throws InterruptedException {
        LoggerUtil.title("Relationship Photo test started");

        if (isMemberCustomer) {
            LoggerUtil.info("Skipping Photo details, clicking Next");
            corpKyc.skipRelationshipPhoto();
            return;
        }
        corpKyc.fillRelationshipPhoto(profileImagePath);
        softAssert.assertAll();
    }

}

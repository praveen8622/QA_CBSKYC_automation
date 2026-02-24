package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTestSequential;
import utilities.DataGenerator;
import utilities.LoggerUtil;
import workflows.KycWorkflow;

public class CusRegTest extends BaseTestSequential {

	private KycWorkflow kyc;
	private String testImagePath = "testimages/testdoc.jpg";
	private String profileImagePath = "testimages/profile.jpg";

	// private String editCustomerName = "PRAKASH BAHADUR KARKI";
	@BeforeClass
	public void pageSetup() {
		kyc = new KycWorkflow(driver, softAssert);
	}

	@BeforeMethod
	public void setupSoftAssert() {
		kyc.updateSoftAssert(softAssert);
	}

	@Test(priority = 1, description = "Verify Customer Registration")
	public void verifyCustomerRegistration() throws InterruptedException {
		LoggerUtil.info("Registration test started");

		String firstName = DataGenerator.generateRandomfirstName();
		String lastName = DataGenerator.generateRandomlastName();
		String fullName = firstName + " " + lastName;

		String screeningId = kyc.getScreeningId(fullName);
		kyc.fillPrimaryRegistration(screeningId, lastName);
	}

	@Test(priority = 2, description = "Verify Identity Details")
	public void verifyIdentityDetails() throws InterruptedException {
		LoggerUtil.info("Identity Details test started");
		kyc.fillIdentityDetails(DataGenerator.generateRandomLicense(), testImagePath);
	}

	@Test(priority = 3, description = "Verify Communication Details")
	public void verifyCommunicationDetails() throws InterruptedException {
		LoggerUtil.info("Communication Details test started");
		kyc.fillCommunicationDetails("9841234567");
	}

	@Test(priority = 4, description = "Verify Document Details")
	public void verifyDocumentDetails() throws InterruptedException {
		LoggerUtil.info("Document Details test started");
		kyc.fillDocumentDetails(DataGenerator.generateRandomPassport(), testImagePath);
	}

	@Test(priority = 5, description = "Verify Address Details")
	public void verifyAddressDetails() throws InterruptedException {
		LoggerUtil.info("Address Details test started");
		kyc.fillAddressDetails(testImagePath);
	}

	@Test(priority = 6, description = "Verify High Profile Details")
	public void verifyHighProfileDetails() throws InterruptedException {
		LoggerUtil.info("High Profile Details test started");
		String fullName = DataGenerator.generateRandomfirstName() + " " + DataGenerator.generateRandomlastName();
		kyc.fillHighProfileDetails(fullName);
	}

	@Test(priority = 7, description = "Verify Transaction Details")
	public void verifyTransactionDetails() throws InterruptedException {
		LoggerUtil.info("Transaction Details test started");
		kyc.fillTransactionDetails();
	}

	@Test(priority = 8, description = "Verify Cash Flow Details")
	public void verifyCashFlowDetails() throws InterruptedException {
		LoggerUtil.info("Cash Flow Details test started");
		kyc.fillCashFlowDetails();
	}

	@Test(priority = 9, description = "Verify Exposure Details")
	public void verifyExposureDetails() throws InterruptedException {
		LoggerUtil.info("Exposure Details test started");
		kyc.fillExposureDetails();
	}

	@Test(priority = 10, description = "Verify Employment Details")
	public void verifyEmploymentDetails() throws InterruptedException {
		LoggerUtil.info("Employment Details test started");
		kyc.fillEmploymentDetails();
	}

	@Test(priority = 11, description = "Verify Relationship Master")
	public void verifyRelationshipDetails() throws InterruptedException {
		LoggerUtil.info("Relationship Details test started");
		kyc.fillRelationshipMasterDetails();
	}

	@Test(priority = 12, description = "Verify Relationship Identity")
	public void verifyRelationshipIdentity() throws InterruptedException {
		LoggerUtil.info("Relationship Identity Details test started");
		// kyc.resumeDraft(editCustomerName);
		kyc.fillRelationshipIdentityDetails(DataGenerator.generateRandomLicense(), testImagePath);
	}

	@Test(priority = 13, description = "Verify Relationship Communication")
	public void verifyRelationshipCommunication() throws InterruptedException {
		LoggerUtil.info("Relationship Communication Details test started");
		// kyc.resumeDraft(editCustomerName);
		kyc.fillRelationshipCommunicationDetails("9876543221");
	}

	@Test(priority = 14, description = "Verify Relationship Document")
	public void verifyRelationshipDocument() throws InterruptedException {
		LoggerUtil.info("Relationship Document Details test started");
		// kyc.resumeDraft(editCustomerName);
		kyc.fillRelationshipDocumentDetails(DataGenerator.generateRandomNumber(10), testImagePath);
	}

	@Test(priority = 15, description = "Verify Relationship Address")
	public void verifyRelationshipAddress() throws InterruptedException {
		LoggerUtil.info("Relationship Address Details test started");
		// kyc.resumeDraft(editCustomerName);
		kyc.fillRelationshipAddressDetails();
	}

	@Test(priority = 16, description = "Verify Relationship Photo")
	public void verifyRelationshipPhoto() throws InterruptedException {
		LoggerUtil.info("Relationship Photo test started");
		// kyc.resumeDraft(editCustomerName);
		kyc.fillRelationshipPhoto(profileImagePath);
	}
}

package pages.cust_reg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.BasePage;
import utilities.LoggerUtil;

public class CustEmploymentPage extends BasePage {

    // =================================================
    // Locators
    // =================================================
    private By addBtnLocator = By.xpath("//button[@title='Add']");

    private By employmentTypeContainerBy = By
            .xpath("//input[@aria-label='employmentTypeCode']/ancestor::div[contains(@class, 'container')]");
    private By employmentTypeInputBy = By.xpath("//input[@aria-label='employmentTypeCode']");

    private By primaryOccupationContainerBy = By
            .xpath("//input[@aria-label='primaryOccupationId']/ancestor::div[contains(@class, 'container')]");
    private By primaryOccupationInputBy = By.xpath("//input[@aria-label='primaryOccupationId']");

    private By designationContainerBy = By.xpath(
            "//input[@aria-label='primaryOccupationDesignationId']/ancestor::div[contains(@class, 'container')]");
    private By designationInputBy = By.xpath("//input[@aria-label='primaryOccupationDesignationId']");

    private By organizationInputBy = By.xpath("//input[@name='organizationName']");
    private By addressInputBy = By.xpath("//input[@name='address']");
    private By incomeInputBy = By.xpath("//input[@name='expectedAnnualIncome']");

    private By saveBtnBy = By.xpath("//button[normalize-space()='Save']");

    public CustEmploymentPage(WebDriver driver) {
        super(driver);
    }

    // =================================================
    // Actions
    // =================================================

    public void clickAdd() {
        LoggerUtil.info("Clicking 'Add' button for Employment details");
        click(addBtnLocator);
    }

    public void enterEmploymentDetails(String type, String occupation, String designation, String org, String addr,
            String income) {
        LoggerUtil.info("Entering Employment Details: Type=" + type + ", Occupation=" + occupation);

        selectFromReactSelect(employmentTypeContainerBy, employmentTypeInputBy, type);
        selectFromReactSelect(primaryOccupationContainerBy, primaryOccupationInputBy, occupation);
        selectFromReactSelect(designationContainerBy, designationInputBy, designation);
        typeText(organizationInputBy, org);
        assertValueEquals(organizationInputBy, org, "Organization Name mismatch");
        typeText(addressInputBy, addr);
        assertValueEquals(addressInputBy, addr, "Employment Address mismatch");
        typeText(incomeInputBy, income);
        assertValueEquals(incomeInputBy, income, "Annual Income mismatch");
    }

    public void clickSave() {
        LoggerUtil.info("Clicking 'Save' button in Employment details dialog");
        click(saveBtnBy);
    }
}

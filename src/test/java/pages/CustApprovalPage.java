package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.BasePage;
import utilities.LoggerUtil;

public class CustApprovalPage extends BasePage {
    public CustApprovalPage(WebDriver driver) {
        super(driver);
    }

    // Approval Tab
    private By additionalFormTab = By.xpath("//p[normalize-space()='Additional Form']");

    // Customer Approval Section
    private By sendForApprovalBtnLocator = By.xpath("//button[@title='Send for Approval']");

    public void clickAdditionalFormTab() {
        LoggerUtil.info("Clicking Additional Form tab");
        click(additionalFormTab);
    }

    public void clickSendForApprovalButton() {
        LoggerUtil.info("Clicking Send For Approval button");
        click(sendForApprovalBtnLocator);
    }
}

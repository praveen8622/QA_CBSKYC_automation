package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.BasePage;
import utilities.LoggerUtil;

public class CustRelationshipPhoto extends BasePage {
    public CustRelationshipPhoto(WebDriver driver) {
        super(driver);
    }

    private By photoTabLocator = By.xpath("//button[normalize-space()='Photo'] ");
    private By uploadPhoto = By.xpath("//input[@type='file']");
    private By saveButton = By.xpath("//button[normalize-space()='Save']");
    private By closeBtnLocator = By.name("Close Alert");
    private By nextButton = By.xpath("//button[@title='Next Step']");

    public void clickPhotoTab() {
        LoggerUtil.info("Clicking Photo tab");
        click(photoTabLocator);
    }

    public void uploadPhoto(String filePath) {
        LoggerUtil.info("Uploading Photo: " + filePath);
        uploadFile(uploadPhoto, filePath);
    }

    public void clickSaveButton() {
        LoggerUtil.info("Clicking Save button");
        click(saveButton);
    }

    public void clickCloseButton() {
        LoggerUtil.info("Clicking Close button");
        click(closeBtnLocator);
    }

    public void clickNextButton() {
        LoggerUtil.info("Clicking Next button");
        click(nextButton);
    }
}

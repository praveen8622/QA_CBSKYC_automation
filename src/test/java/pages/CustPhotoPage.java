package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.BasePage;
import utilities.LoggerUtil;

public class CustPhotoPage extends BasePage {
    public CustPhotoPage(WebDriver driver) {
        super(driver);
    }

    private By photoTabLocator = By.xpath("//button[normalize-space()='Photo'] ");
    private By uploadPhoto = By.xpath("//input[@type='file']");
    private By saveButton = By.xpath("//button[normalize-space()='Save']");

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
}

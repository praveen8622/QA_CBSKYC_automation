package utilities;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
	private WebDriverWait wait;

	public WaitUtils(WebDriver driver) {
		Properties prop = ConfigReader.getProperties();
		int timeout = Integer.parseInt(System.getProperty("timeout",
				prop.getProperty("timeout", "30")));
		this.wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(timeout));
	}

	public WebElement waitForElementToBeClickable(By locator) {
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public WebElement waitForElementToBeVisible(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void waitForAlert() {
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public WebElement waitForElementToBePresent(By locator) {
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
}

package bg.pragmatic.examtests.backend;

import bg.pragmatic.examtests.browser.Browser;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class AdminLogin {

	public static void goTo() {
		Browser.driver.get("http://shop.pragmatic.bg/admin");
	}

	public static void login(String username, String password) {
		WebElement usernameField = Browser.driver.findElement(By.name("username"));
		WebElement passwordField = Browser.driver.findElement(By.name("password"));
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		
		WebElement loginButton = Browser.driver.findElement(By.linkText("Login"));
		loginButton.click();
	}

	public static void verifyValidationMessage(String messageOnFailure, String expectedValidationMessage) {
		String actualValidationMessage = null;
		try {
			WebElement validationMessage = Browser.driver.findElement(By.className("warning"));
			actualValidationMessage = validationMessage.getText();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			Assert.fail("There was a missing web element on the page");
		}
		
		Assert.assertEquals(messageOnFailure, expectedValidationMessage, actualValidationMessage);
	}

}

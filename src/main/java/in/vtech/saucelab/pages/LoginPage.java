package in.vtech.saucelab.pages;

import org.openqa.selenium.By;

import in.vtech.saucelab.base.Base;

public class LoginPage extends Base {

	// login form fields
	private By usernameField = By.id("user-name");
	private By passwordField = By.id("password");
	private By submitButton = By.id("login-button");

	private void enterUsername(String text) {
		driver.findElement(usernameField).sendKeys(text);
	}

	private void enterPassword(String text) {
		driver.findElement(passwordField).sendKeys(text);
	}

	private void clickSubmit() {
		driver.findElement(submitButton).click();
	}

	public void login(String username, String password) {
		enterUsername(username);
		enterPassword(password);
		clickSubmit();
	}

	public String getLoginPageTitle() {
		return driver.getTitle();
	}
}

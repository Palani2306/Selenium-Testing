package in.vtech.saucelab.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import in.vtech.saucelab.base.Base;
import in.vtech.saucelab.pages.LoginPage;

public class UserLoginTest extends Base {

	private LoginPage loginPage;

	@BeforeTest
	public void setup() {
		initialization();
		loginPage = new LoginPage();
	}

	@Test
	public void validateUserLogin() {
		loginPage.login("standard_user", "secret_sauce");
		Assert.assertEquals("A", "B");
	}

	@AfterTest
	public void quit() {
		tearDown();
	}
}

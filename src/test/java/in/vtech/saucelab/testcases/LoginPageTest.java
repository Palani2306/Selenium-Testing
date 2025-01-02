package in.vtech.saucelab.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import in.vtech.saucelab.base.Base;
import in.vtech.saucelab.pages.LoginPage;

public class LoginPageTest extends Base {

	private LoginPage loginPage;

	@BeforeTest
	public void setup() {
		initialization();
		loginPage = new LoginPage();
	}

	@Test
	public void validateLoginPageTitle() {
		String expectedTitle = "Swag Labs";
		String actualTitle = loginPage.getLoginPageTitle();
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, expectedTitle, "HOME_PAGE_TITLE_NOT_MATCHED");
	}

	@AfterTest
	public void quit() {
		tearDown();
	}
}

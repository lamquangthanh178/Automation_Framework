package TestCase;

import lib.driver.DriverManager;

import org.testng.annotations.Test;

import page.common.*;
import utilities.data.InjectData;
import utilities.parse.ReadWriteJson;

public class Test01 extends DriverManager {

	@InjectData(json = "/data/authentication/login.json")
	@Test(description = "Test Log in")
	public void test_Login() throws Exception {
		HomePage homePage = new HomePage(getWebDriver());
		homePage.openHomePage().goToSignInPage();
		Authentication loginPage = new Authentication(getWebDriver());
		loginPage.inputEmail(ReadWriteJson.getValueFromDataFile("email"))
				.inputPassword(ReadWriteJson.getValueFromDataFile("passwd")).clickButtonSignIn();
		MyAccount myAccountPage = new MyAccount(getWebDriver());
		myAccountPage.verifyLabelAccountName();
	}
}

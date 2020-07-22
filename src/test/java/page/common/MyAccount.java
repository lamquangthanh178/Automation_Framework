package page.common;

import lib.action.Action;
import lib.services.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utilities.parse.ReadWriteJson;

public class MyAccount extends Action {

	@FindBy(how = How.XPATH, using = "//a[@class='account']/span")
	public WebElement lb_accountName;

	public MyAccount(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public MyAccount verifyLabelAccountName() {
		String accountName = ReadWriteJson.getValueFromDataFile("account");
		verifyElementIsContainsText(lb_accountName, accountName);
		Logger.log(this.getClass().getName(), "Verify label account name", Logger.LogLevel.INFO);
		return this;
	}

}

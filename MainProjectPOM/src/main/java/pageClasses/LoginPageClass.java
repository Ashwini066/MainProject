package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExplicitWaitClass;
import utilities.GeneralUtilities;

public class LoginPageClass {

	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	ExplicitWaitClass ewait = new ExplicitWaitClass();

	@FindBy(name = "LoginForm[username]")
	WebElement username;
	@FindBy(name = "LoginForm[password]")
	WebElement password;
	@FindBy(name = "login-button")
	WebElement LoginBtn;

	@FindBy(xpath = "//input[@name='LoginForm[password]']//following::p[1]")
	WebElement ErrorMessage;

	public LoginPageClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String checkURL(WebDriver driver) {
		return driver.getTitle();
	}

	public void successfulLogin(String name, String pwd) {
		gu.typeOnElement(username, name);
		gu.typeOnElement(password, pwd);
		ewait.visibitlityOfElementWait(driver, LoginBtn);
		gu.clickAnElementUsingSendKeys(driver, LoginBtn);

	}

	public String getTextofElement()

	{
		ewait.visibitlityOfElementWait(driver, ErrorMessage);
		return gu.getTextOfElement(ErrorMessage);
	}

}

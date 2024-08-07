package testClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageClasses.HomePageClass;
import pageClasses.LoginPageClass;
import retryAnalyzer.RetryAnalyzer;
import utilities.ExcelReadClass;

public class HomePageTestClass extends BaseClass {

	LoginPageClass lpc;
	HomePageClass hpc;

	@Test(priority = 2)
	public void verifyLogoIsDisplayed() throws IOException {
		lpc = new LoginPageClass(driver);
		hpc = lpc.enterUsername(ExcelReadClass.readStringData(1, 1)).enterPassword(ExcelReadClass.readStringData(2, 1))
				.clickLoginButton();
		hpc.checkLogo();
		Assert.assertTrue(hpc.checkLogo(), "Logo is not Displayed");

	}

	@Test(priority = 0, retryAnalyzer = RetryAnalyzer.class)
	public void verifyUserNameIsDisplayed() throws IOException {
		lpc = new LoginPageClass(driver);
		hpc = lpc.enterUsername(ExcelReadClass.readStringData(1, 1)).enterPassword(ExcelReadClass.readStringData(2, 1))
				.clickLoginButton();
		Assert.assertTrue(hpc.checkUserName(), "User Name is displayed");
		String actual_profileName = hpc.getProfileName();
		Assert.assertEquals(actual_profileName, ExcelReadClass.readStringData(8, 1), "Profile name Mismatch");

	}

	@Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
	public void verifyAllTilesInHomePageIsDisplayed() throws IOException {
		lpc = new LoginPageClass(driver);
		hpc = lpc.enterUsername(ExcelReadClass.readStringData(1, 1)).enterPassword(ExcelReadClass.readStringData(2, 1))
				.clickLoginButton();
		lpc.successfulLogin(ExcelReadClass.readStringData(1, 1), ExcelReadClass.readStringData(2, 1));
		Assert.assertTrue(hpc.checkAllTilesIsDisplayed());
	}

}

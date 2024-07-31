package testClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageClasses.LoginPageClass;
import utilities.ExcelReadClass;



public class LoginPageTestClass extends BaseClass {

	LoginPageClass lpc;

	@Test
	public void verifyCorrectURLIsHit() throws IOException {
		lpc = new LoginPageClass(driver);
		String actual_URL = lpc.checkURL(driver);
		//System.out.println(actual_URL);
		Assert.assertEquals(actual_URL, ExcelReadClass.readStringData(0, 1));//0,1
	}

	@Test
	public void verifySucessfulLogin() throws IOException {
		lpc = new LoginPageClass(driver);
		lpc.successfulLogin(ExcelReadClass.readStringData(1, 1), ExcelReadClass.readStringData(2, 1));
		String actual_Title = lpc.checkURL(driver);
		//System.out.println(actual_Title);
		String expected_Title = ExcelReadClass.readStringData(3, 1);
		Assert.assertEquals(actual_Title, expected_Title);
	}

	@Test(dataProviderClass = DataProviderClass.class, dataProvider = "UnsuccessfulLogin")
	public void verifyUnsucessfulLogin(String uname, String pwd) throws IOException {
		lpc = new LoginPageClass(driver);
		lpc.successfulLogin(uname, pwd);
		String actual_Message = lpc.getTextofElement();
		String expected_Message = ExcelReadClass.readStringData(7, 1);
		Assert.assertEquals(actual_Message, expected_Message, "Incorrect Message Received");

	}

}

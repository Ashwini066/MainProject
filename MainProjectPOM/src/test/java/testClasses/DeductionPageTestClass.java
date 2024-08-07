package testClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageClasses.DeductionPageClass;
import pageClasses.HomePageClass;
import pageClasses.LoginPageClass;
import retryAnalyzer.RetryAnalyzer;
import utilities.ExcelReadClass;

public class DeductionPageTestClass extends BaseClass {

	LoginPageClass lpc;
	HomePageClass hpc;
	DeductionPageClass dpc;

	@Test(groups = { "AddGroup" }, retryAnalyzer = RetryAnalyzer.class)
	public void verifyNewDeductionIsAdded() throws IOException {
		lpc = new LoginPageClass(driver);
		hpc = new HomePageClass(driver);
		dpc = new DeductionPageClass(driver);
		lpc.successfulLogin(ExcelReadClass.readStringData(1, 1), ExcelReadClass.readStringData(2, 1));
		hpc.clickonDeductionTile();
		dpc.addNewDeduction(ExcelReadClass.readStringData(69, 1), ExcelReadClass.readStringData(70, 1));
	}

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void verifyExistingDeductionIsUpdated() throws IOException, InterruptedException {
		lpc = new LoginPageClass(driver);
		hpc = new HomePageClass(driver);
		dpc = new DeductionPageClass(driver);
		lpc.successfulLogin(ExcelReadClass.readStringData(1, 1), ExcelReadClass.readStringData(2, 1));
		hpc.clickonDeductionTile();
		dpc.updateExistingDeduction(ExcelReadClass.readStringData(74, 1), ExcelReadClass.readStringData(75, 1));
		String expected_amt = ExcelReadClass.readStringData(75, 1);
		// System.out.println("Â£" + String.format("%,.2f",
		// Double.parseDouble(expected_amt)));
		Assert.assertEquals(dpc.getDeductionType(), ExcelReadClass.readStringData(74, 1));
		Assert.assertEquals(dpc.getDeductionAmt(), ("£" + String.format("%,.2f", Double.parseDouble(expected_amt))));
	}

}

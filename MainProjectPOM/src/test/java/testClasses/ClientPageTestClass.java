package testClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageClasses.ClientPageClass;
import pageClasses.HomePageClass;
import pageClasses.LoginPageClass;
import utilities.ExcelReadClass;

public class ClientPageTestClass extends BaseClass {
	LoginPageClass lpc;
	HomePageClass hpc;
	ClientPageClass cpc;

	@Test (groups = {"AddGroup"})
	public void verifyANewClientisCreated() throws IOException {
		lpc = new LoginPageClass(driver);
		hpc = new HomePageClass(driver);
		cpc = new ClientPageClass(driver);
		lpc.successfulLogin(ExcelReadClass.readStringData(1, 1), ExcelReadClass.readStringData(2, 1));
		hpc.clickonClientTile();
		cpc.clickonCreateClient();

		String actual_heading = cpc.createNewClient(ExcelReadClass.readStringData(13, 1),
				ExcelReadClass.readStringData(14, 1), ExcelReadClass.readStringData(15, 1),
				ExcelReadClass.readStringData(16, 1), ExcelReadClass.readStringData(17, 1),
				ExcelReadClass.readStringData(18, 1), ExcelReadClass.readStringData(19, 1),
				ExcelReadClass.readStringData(20, 1), ExcelReadClass.readStringData(21, 1),
				ExcelReadClass.readIntegerData(22, 1), ExcelReadClass.readStringData(23, 1),
				ExcelReadClass.readStringData(24, 1), ExcelReadClass.readStringData(25, 1),
				ExcelReadClass.readStringData(26, 1));
		// String actual_heading=cpc.getAddedClientName();
		//System.out.println(actual_heading);
		Assert.assertEquals(actual_heading, ExcelReadClass.readStringData(28, 1));

	}

	@Test (groups = {"ViewGroup"})
	public void verifySearchingAnExistingClient() throws IOException, InterruptedException {

		lpc = new LoginPageClass(driver);
		cpc = new ClientPageClass(driver);
		hpc = new HomePageClass(driver);
		lpc.successfulLogin(ExcelReadClass.readStringData(1, 1), ExcelReadClass.readStringData(2, 1));
		hpc.clickonClientTile();

		String actual_ClientName = cpc.searchExistingClient(ExcelReadClass.readStringData(32, 1));
		//System.out.println(actual_ClientName);
		Assert.assertEquals(actual_ClientName, ExcelReadClass.readStringData(32, 1));

	}

}

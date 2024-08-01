package testClasses;

import utilities.ExcelReadClass;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

	@DataProvider(name = "UnsuccessfulLogin")
	public Object[][] dp() throws IOException {
		return new Object[][] {
				new Object[] { ExcelReadClass.readStringData(4, 1), ExcelReadClass.readStringData(4, 2) },
				new Object[] { ExcelReadClass.readStringData(5, 1), ExcelReadClass.readStringData(5, 2) },
				new Object[] { ExcelReadClass.readStringData(6, 1), ExcelReadClass.readStringData(6, 2) }, };
	}
}

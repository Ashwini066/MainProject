package testClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageClasses.HomePageClass;
import pageClasses.LoginPageClass;
import pageClasses.WorkerPageClass;
import utilities.ExcelReadClass;



public class WorkerPageTestClass extends BaseClass {

	LoginPageClass lpc;
	HomePageClass hpc;
	WorkerPageClass wpc;

	
	
	@Test (groups = {"AddGroup"})
	public void verifyANewWorkerisCreated() throws IOException {
		lpc = new LoginPageClass(driver);
		hpc = new HomePageClass(driver);
		wpc = new WorkerPageClass(driver);
		lpc.successfulLogin(ExcelReadClass.readStringData(1, 1), ExcelReadClass.readStringData(2, 1));
		hpc.clickonWorkerTile();
		String actual_workerName = wpc.createNewWorker(ExcelReadClass.readStringData(37, 1),
				ExcelReadClass.readStringData(38, 1), ExcelReadClass.readStringData(39, 1),
				ExcelReadClass.readStringData(40, 1), ExcelReadClass.readStringData(41, 1),
				ExcelReadClass.readStringData(42, 1), ExcelReadClass.readStringData(43, 1),
				ExcelReadClass.readStringData(44, 1), ExcelReadClass.readStringData(45, 1),
				ExcelReadClass.readStringData(46, 1), ExcelReadClass.readStringData(47, 1),
				ExcelReadClass.readStringData(48, 1), ExcelReadClass.readStringData(49, 1),
				ExcelReadClass.readStringData(50, 1), ExcelReadClass.readStringData(51, 1),
				ExcelReadClass.readStringData(52, 1));
		// System.out.println(actual_workerName);
		// System.out.println(ExcelReadClass.readStringData(40, 1));
		Assert.assertTrue(actual_workerName.equalsIgnoreCase(ExcelReadClass.readStringData(40, 1)));

	}

	@Test (groups = {"ViewGroup"})

	public void verifyExistingWorkerIsViewed() throws IOException, InterruptedException {
		lpc = new LoginPageClass(driver);
		hpc = new HomePageClass(driver);
		wpc = new WorkerPageClass(driver);
		lpc.successfulLogin(ExcelReadClass.readStringData(1, 1), ExcelReadClass.readStringData(2, 1));
		hpc.clickonWorkerTile();
		wpc.viewExistingWorker(ExcelReadClass.readStringData(40, 1), ExcelReadClass.readStringData(41, 1));

	}

	@Test

	public void verifyExistingWorkerIsDeleted() throws IOException, InterruptedException {
		lpc = new LoginPageClass(driver);
		hpc = new HomePageClass(driver);
		wpc = new WorkerPageClass(driver);
		lpc.successfulLogin(ExcelReadClass.readStringData(1, 1), ExcelReadClass.readStringData(2, 1));
		hpc.clickonWorkerTile();
		String actual_error_message = wpc.deleteExistingWorker(ExcelReadClass.readStringData(63, 1),
				ExcelReadClass.readStringData(64, 1));
		Assert.assertEquals(actual_error_message, ExcelReadClass.readStringData(65, 1));
	}
}

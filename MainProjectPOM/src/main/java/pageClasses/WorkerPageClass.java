package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExplicitWaitClass;
import utilities.GeneralUtilities;

public class WorkerPageClass {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	ExplicitWaitClass ewait = new ExplicitWaitClass();

	@FindBy(xpath = "//a[@href='/payrollapp/worker/index']")
	WebElement workerTile;
	@FindBy(xpath = "//a[@href='/payrollapp/worker/create']")
	WebElement createWorkerBtn;
	@FindBy(id = "worker-gender")
	WebElement workerGender;
	@FindBy(id = "worker-branch_id")
	WebElement workerBranch;
	@FindBy(id = "worker-division_id")
	WebElement workerdivision;
	@FindBy(id = "worker-first_name")
	WebElement Workerfirstname;
	@FindBy(id = "worker-last_name")
	WebElement Workerlastname;
	@FindBy(id = "worker-dob")
	WebElement workerDob;
	@FindBy(id = "worker-employment_type")
	WebElement workerEmpType;
	@FindBy(id = "worker-address1")
	WebElement workerAddr1;
	@FindBy(id = "worker-payslip_method")
	WebElement workerPaySlipMethod;
	@FindBy(id = "worker-phone")
	WebElement workerPhone;
	@FindBy(id = "worker-ni_number")
	WebElement workerNiNumber;
	@FindBy(id = "worker-email")
	WebElement workerEmail;
	@FindBy(id = "worker-postcode")
	WebElement workerPostalCode;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement nextBtn;
	@FindBy(id = "worker-ac_name")
	WebElement workerAcctName;
	@FindBy(id = "worker-ac_no")
	WebElement workerAcctNumber;
	@FindBy(id = "worker-sort_code")
	WebElement workerSortCode;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement saveButton;
	@FindBy(xpath = "//table[@id='w0']//tbody//tr[6]//td")
	WebElement addedWorker;

	@FindBy(xpath = "//a[@href='/payrollapp/worker']")
	WebElement workersBtn;
	@FindBy(id = "workersearch-first_name")
	WebElement searchWorkerFName;
	@FindBy(id = "workersearch-last_name")
	WebElement searchWorkerLName;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement searchBtn;
	@FindBy(xpath = "//table[@id='w0']//tbody//tr[6]//td")
	WebElement viewElement;
	@FindBy(xpath = "//div[@class='summary']//following::table//tbody//tr[1]//td[8]//a[@title='View']")
	WebElement viewIcon;

	@FindBy(xpath = "//div[@id='w1']//child::div//following::table//tbody/tr[1]//a[@title='Delete']")
	WebElement deleteIcon;
	@FindBy(xpath = "//div[@id='w1']//following::table//tr//td//div")
	WebElement deletedText;

	public WorkerPageClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String createNewWorker(String gend, String branch, String division, String fname, String lname, String dob,
			String empType, String Addr1, String pSMethod, String phone, String niNumb, String email, String postcode,
			String actname, String acctnum, String sortcode) {
		gu.clickOnElement(workerTile);
		ewait.visibitlityOfElementWait(driver, createWorkerBtn);
		gu.clickOnElement(createWorkerBtn);
		ewait.visibitlityOfElementWait(driver, workerGender);
		gu.selectFromDropDownByVisibleText(workerGender, gend);
		gu.selectFromDropDownByVisibleText(workerBranch, branch);
		gu.selectFromDropDownByVisibleText(workerdivision, division);
		gu.typeOnElement(Workerfirstname, fname);
		gu.typeOnElement(Workerlastname, lname);
		gu.typeOnElement(workerDob, dob);
		gu.scrollToAnElement(driver, workerPostalCode);
		gu.selectFromDropDownByVisibleText(workerEmpType, empType);
		gu.typeOnElement(workerAddr1, Addr1);
		gu.selectFromDropDownByVisibleText(workerPaySlipMethod, pSMethod);
		gu.typeOnElement(workerPhone, phone);
		gu.typeOnElement(workerNiNumber, niNumb);
		gu.typeOnElement(workerEmail, email);
		gu.typeOnElement(workerPostalCode, postcode);
		ewait.visibitlityOfElementWait(driver, nextBtn);
		gu.clickOnElement(nextBtn);
		ewait.visibitlityOfElementWait(driver, workerAcctName);
		gu.typeOnElement(workerAcctName, actname);
		gu.typeOnElement(workerAcctNumber, acctnum);
		gu.typeOnElement(workerSortCode, sortcode);
		ewait.visibitlityOfElementWait(driver, saveButton);
		gu.clickUsingJavaScriptExecutor(driver, saveButton);
		ewait.visibitlityOfElementWait(driver, addedWorker);
		return gu.getTextOfElement(addedWorker);

	}

	public String viewExistingWorker(String fname, String lname) throws InterruptedException

	{
		gu.clickOnElement(workerTile);
		ewait.visibitlityOfElementWait(driver, workersBtn);
		gu.clickOnElement(workersBtn);
		ewait.visibitlityOfElementWait(driver, searchWorkerFName);
		gu.typeOnElement(searchWorkerFName, fname);
		gu.typeOnElement(searchWorkerLName, lname);
		ewait.visibitlityOfElementWait(driver, searchBtn);
		gu.clickOnElement(searchBtn);
		Thread.sleep(1000);
		ewait.visibitlityOfElementWait(driver, viewIcon);
		gu.clickUsingJavaScriptExecutor(driver, viewIcon);
		ewait.visibitlityOfElementWait(driver, viewElement);
		return gu.getTextOfElement(viewElement);

	}

	public String deleteExistingWorker(String fname, String lname) throws InterruptedException {
		gu.clickOnElement(workerTile);
		ewait.visibitlityOfElementWait(driver, workersBtn);
		gu.clickOnElement(workersBtn);
		ewait.visibitlityOfElementWait(driver, searchWorkerFName);
		gu.typeOnElement(searchWorkerFName, fname);
		gu.typeOnElement(searchWorkerLName, lname);
		ewait.visibitlityOfElementWait(driver, searchBtn);
		gu.clickOnElement(searchBtn);
		Thread.sleep(1000);
		ewait.visibitlityOfElementWait(driver, deleteIcon);
		gu.clickUsingJavaScriptExecutor(driver, deleteIcon);
		// gu.pressEnterKeyUsingKeyboard(driver);
		// ewait.alertPresentWait(driver);
		gu.alertAccept(driver);
		ewait.visibitlityOfElementWait(driver, searchWorkerFName);
		ewait.visibitlityOfElementWait(driver, searchWorkerFName);
		gu.clearElement(searchWorkerFName);
		gu.clearElement(searchWorkerLName);
		gu.typeOnElement(searchWorkerFName, fname);
		gu.typeOnElement(searchWorkerLName, lname);
		ewait.visibitlityOfElementWait(driver, searchBtn);
		gu.clickOnElement(searchBtn);
		ewait.visibitlityOfElementWait(driver, deletedText);
		return gu.getTextOfElement(deletedText);

	}

}

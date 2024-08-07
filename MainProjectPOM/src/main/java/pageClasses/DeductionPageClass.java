package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExplicitWaitClass;
import utilities.GeneralUtilities;
import utilities.RandomDataGenerationClass;

public class DeductionPageClass {

	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	ExplicitWaitClass ewait = new ExplicitWaitClass();

	@FindBy(xpath = "//a[@href='/payrollapp/deduction/create']")
	WebElement AddDeductionBtn;
	@FindBy(xpath = "//span[@role='presentation']")
	WebElement workerNameDropDown;
	@FindBy(xpath = "//input[@type='search']")
	WebElement workerNameSearchTextBx;
	@FindBy(id = "deduction-type")
	WebElement deductionType;
	@FindBy(id = "deduction-amount")
	WebElement DeductionAmount;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement saveBtn;
	@FindBy(xpath = "//table[@id=\"w0\"]//tbody//tr[1]//td")
	WebElement verifyWorkerName;
	@FindBy(xpath = "//table[@id=\"w0\"]//tbody//tr[3]//td")
	WebElement verifyDeductionAmt;
	@FindBy(xpath = "//table[@id=\"w0\"]//tbody//tr[2]//td")
	WebElement verifyDeductionType;
	@FindBy(xpath = "//a[@href='/payrollapp/deduction']")
	WebElement deductionsBtn;
	@FindBy(xpath = "//div[@class='summary']//following::table/tbody//tr[1]//td[7]//a[2]")
	WebElement updateIcon;

	public DeductionPageClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void addNewDeduction(String wName, String type) {
		String Amount = RandomDataGenerationClass.getDeductionAmt();
		ewait.visibitlityOfElementWait(driver, AddDeductionBtn);
		gu.clickOnElement(AddDeductionBtn);
		ewait.visibitlityOfElementWait(driver, workerNameDropDown);
		gu.clickOnElement(workerNameDropDown);
		ewait.visibitlityOfElementWait(driver, workerNameSearchTextBx);
		gu.typeOnElement(workerNameSearchTextBx, wName);
		gu.pressEnterKeyUsingKeyboard(driver);
		ewait.visibitlityOfElementWait(driver, deductionType);
		gu.selectFromDropDownByVisibleText(deductionType, type);
		gu.typeOnElement(DeductionAmount, Amount);
		ewait.visibitlityOfElementWait(driver, saveBtn);
		gu.clickOnElement(saveBtn);
		ewait.visibitlityOfElementWait(driver, verifyWorkerName);

	}

	public String getWorkerName() {
		return gu.getTextOfElement(verifyWorkerName);

	}

	public String getDeductionAmt() {
		return gu.getTextOfElement(verifyDeductionAmt);
	}

	public String getDeductionType() {
		return gu.getTextOfElement(verifyDeductionType);
	}

	public void updateExistingDeduction(String type, String amount) throws InterruptedException {
		ewait.visibitlityOfElementWait(driver, deductionsBtn);
		gu.clickOnElement(deductionsBtn);
		ewait.visibitlityOfElementWait(driver, updateIcon);
		gu.clickUsingJavaScriptExecutor(driver, updateIcon);
		ewait.visibitlityOfElementWait(driver, deductionType);
		gu.selectFromDropDownByVisibleText(deductionType, type);
		gu.clearElement(DeductionAmount);
		gu.typeOnElement(DeductionAmount, amount);
		ewait.visibitlityOfElementWait(driver, saveBtn);
		gu.clickOnElement(saveBtn);

	}

}

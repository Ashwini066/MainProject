package pageClasses;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExplicitWaitClass;
import utilities.GeneralUtilities;

public class HomePageClass {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	ExplicitWaitClass ewait = new ExplicitWaitClass();

	@FindBy(xpath = "//ul[@class='list-inline']//preceding::img")
	WebElement logo;
	@FindBy(className = "dropdown-toggle")
	WebElement profileName;
	@FindBy(xpath = "//div[@id='w0-collapse']//following::a")
	List<WebElement> allTiles;

	@FindBy(xpath = "//a[@href='/payrollapp/client/index']")
	WebElement clientTile;
	@FindBy(xpath = "//a[@href='/payrollapp/worker/index']")
	WebElement workerTile;
	@FindBy(xpath = "//a[@href='/payrollapp/deduction/index']")
	WebElement deductionTile;
	@FindBy(xpath = "//a[@href='/payrollapp/timesheet/index']")
	WebElement timesheetTile;

	public HomePageClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean checkLogo() {
		ewait.visibitlityOfElementWait(driver, logo);
		return gu.isElementDisplayed(logo);

	}

	public boolean checkUserName() {

		ewait.visibitlityOfElementWait(driver, profileName);
		return gu.isElementDisplayed(profileName);
	}

	public String getProfileName() {
		return gu.getTextOfElement(profileName);
	}

	public boolean checkAllTilesIsDisplayed() {

		for (WebElement element : allTiles) {
			ewait.visibitlityOfElementWait(driver, element);
			if (!gu.isElementDisplayed(element))

				return false;
		}

		return true;

	}

	public void clickonClientTile() {
		ewait.visibitlityOfElementWait(driver, clientTile);
		gu.clickOnElement(clientTile);
	}

	public void clickonWorkerTile() {
		ewait.visibitlityOfElementWait(driver, workerTile);
		gu.clickOnElement(workerTile);
	}

	public void clickonDeductionTile() {
		ewait.visibitlityOfElementWait(driver, deductionTile);
		gu.clickOnElement(deductionTile);
	}

	public void clickonTimesheetTile() {
		ewait.visibitlityOfElementWait(driver, timesheetTile);
		gu.clickOnElement(timesheetTile);
	}

}

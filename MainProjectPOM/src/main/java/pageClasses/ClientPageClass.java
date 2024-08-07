package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExplicitWaitClass;
import utilities.GeneralUtilities;

public class ClientPageClass {

	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	ExplicitWaitClass ewait = new ExplicitWaitClass();

	@FindBy(xpath = "//a[@href='/payrollapp/client/create']")
	WebElement createClientBtn;
	@FindBy(id = "client-branch_id")
	WebElement clientBranchId;
	@FindBy(id = "client-invoice_order")
	WebElement clientInvoiceOrder;
	@FindBy(id = "client-division_id")
	WebElement clientDivisionId;
	@FindBy(id = "client-invoice_contact")
	WebElement clientInvoiceContact;
	@FindBy(id = "client-invoice_delivery_method")
	WebElement clientInvoiceDeliveryMethod;
	@FindBy(id = "client-client_name")
	WebElement client_Name;
	@FindBy(id = "client-phone")
	WebElement clientPhone;
	@FindBy(id = "client-master_document")
	WebElement clientMasterDocument;
	@FindBy(id = "client-settilement_days")
	WebElement clientSettlementDays;
	@FindBy(id = "client-client_address")
	WebElement clientAddress;
	@FindBy(id = "client-email")
	WebElement clientEmail;
	@FindBy(id = "client-vat_rate")
	WebElement client_VatRate;
	@FindBy(id = "client-postcode")
	WebElement clientPostCode;
	@FindBy(id = "client-company_reg")
	WebElement clientComapnyReisteration;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement saveButton;
	@FindBy(xpath = "//table[@id='w0']//tbody//tr[3]//td")
	WebElement addedClientName;
	@FindBy(xpath = "//a[@href='/payrollapp/client']")
	WebElement clientBtn;
	@FindBy(id = "clientsearch-client_name")
	WebElement clientNameSearch;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement searchClientBtn;
	@FindBy(xpath = "//div[@class='summary']//following::table//tbody//tr[1]//td[6]//a[1]")
	WebElement viewSearchElement;
	@FindBy(xpath = "//table[@id='w0']//tbody//tr[3]//td")
	WebElement searchElementFound;

	public ClientPageClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickonCreateClient() {
		ewait.visibitlityOfElementWait(driver, createClientBtn);
		gu.clickUsingJavaScriptExecutor(driver, createClientBtn);
	}

	public String createNewClient(String bid, String invoiceOrder, String division, String invCnct, String invDelMeth,
			String cName, String phone, String MasDoc, String caddr, String setlDays, String email, String postcode,
			String comReg, String vatRat) {

		ewait.visibitlityOfElementWait(driver, clientBranchId);
		gu.selectFromDropDownByVisibleText(clientBranchId, bid);
		gu.selectFromDropDownByVisibleText(clientInvoiceOrder, invoiceOrder);
		gu.selectFromDropDownByVisibleText(clientDivisionId, division);
		gu.typeOnElement(clientInvoiceContact, invCnct);
		gu.selectFromDropDownByVisibleText(clientInvoiceDeliveryMethod, invDelMeth);
		gu.typeOnElement(client_Name, cName);
		gu.typeOnElement(clientPhone, phone);
		gu.scrollToAnElement(driver, client_VatRate);
		gu.selectFromDropDownByVisibleText(clientMasterDocument, MasDoc);
		gu.typeOnElement(clientAddress, caddr);
		gu.typeOnElement(clientSettlementDays, setlDays);
		gu.typeOnElement(clientEmail, email);
		gu.typeOnElement(clientPostCode, postcode);
		gu.typeOnElement(clientComapnyReisteration, comReg);
		gu.selectFromDropDownByVisibleText(client_VatRate, vatRat);
		ewait.visibitlityOfElementWait(driver, saveButton);
		gu.clickOnElement(saveButton);
		ewait.visibitlityOfElementWait(driver, addedClientName);
		return gu.getTextOfElement(addedClientName);
	}

	public String searchExistingClient(String clientName) throws InterruptedException {
		ewait.visibitlityOfElementWait(driver, clientBtn);
		gu.clickOnElement(clientBtn);
		ewait.visibitlityOfElementWait(driver, clientNameSearch);
		gu.typeOnElement(clientNameSearch, clientName.toUpperCase());
		ewait.visibitlityOfElementWait(driver, searchClientBtn);
		gu.clickOnElement(searchClientBtn);
		Thread.sleep(1000);
		ewait.visibitlityOfElementWait(driver, viewSearchElement);
		gu.clickUsingJavaScriptExecutor(driver, viewSearchElement);
		Thread.sleep(1000);
		ewait.visibitlityOfElementWait(driver, searchElementFound);
		return gu.getTextOfElement(searchElementFound);
	}

}

package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtilities {

	public void typeOnElement(WebElement element, String text) {
		element.sendKeys(text);
	}
	
	public void clearElement(WebElement element)
	{
		element.clear();
	}
	public void refreshPage(WebDriver driver)
	{
		driver.navigate().refresh();
	}
	public void clickOnElement(WebElement element) {
		element.click();
	}

	public String getTextOfElement(WebElement element) {
		return element.getText();
	}

	public boolean isElementDisplayed(WebElement element) {
		return element.isDisplayed();
	}

	public boolean isElementSelected(WebElement element) {
		return element.isSelected();
	}
	
	public String getCurrentURLOfPage(WebDriver driver)
	{
		return driver.getCurrentUrl();
	}
	
	public String getTitleOfPage(WebDriver driver)
	{
		return driver.getTitle();
	}
	
	public String getAttributeofElement(WebElement element, String attribute)
	{
		return element.getAttribute(attribute);
	}
	
	public void selectFromDropDownByIndex(WebElement element, int index)
	{
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	public void selectFromDropDownByVisibleText(WebElement element, String text)
	{
		Select select=new Select(element);
		select.selectByVisibleText(text);
	}
	
	
	public void alertAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	public void alertDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	public void scrollToAnElement(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}
	public void clickUsingJavaScriptExecutor(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		js.executeScript("arguments[0].click()", element);
	}
	
	
	
	public void clickAnElementUsingSendKeys(WebDriver driver, WebElement element)
	{
		Actions actions=new Actions(driver);
		actions.sendKeys(element,Keys.ENTER).build().perform();
	}
	
	public void pressEnterKeyUsingKeyboard(WebDriver driver)
	{
		Actions actions=new Actions(driver);
		actions.sendKeys(Keys.ENTER).build().perform();
	}
	
	public void dragAndDrop(WebElement element1, WebElement element2, WebDriver driver) 
	{
		Actions actions=new Actions(driver);
		actions.dragAndDrop(element1, element2).build().perform();
	}
public void doubleClick(WebElement element, WebDriver driver) {
		Actions actions=new Actions(driver);
		actions.doubleClick(element).build().perform();
		
	}
public void movetoElement(WebElement element,WebDriver driver) {
	Actions actions=new Actions(driver);
	actions.moveToElement(element).build().perform();
}
	
	
	public void addSleep() throws InterruptedException {
		Thread.sleep(3000);
	}
	
 public void fileUploadUsingRobotClass(String path) throws AWTException, InterruptedException
 {
	 Robot r=new Robot();
	  StringSelection filepath=new  StringSelection(path);	  
	  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
	  
	  r.keyPress(KeyEvent.VK_CONTROL);
	  Thread.sleep(10);
	  r.keyPress(KeyEvent.VK_V);
	  
	  
	  r.keyRelease(KeyEvent.VK_CONTROL);
	  Thread.sleep(10);
	  r.keyRelease(KeyEvent.VK_V);
	  
	  r.keyPress(KeyEvent.VK_ENTER);
	  Thread.sleep(10);
	  r.keyRelease(KeyEvent.VK_ENTER);
 }
 {
	 
 }
}

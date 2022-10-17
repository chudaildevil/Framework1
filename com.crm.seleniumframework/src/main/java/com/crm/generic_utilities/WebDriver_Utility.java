package com.crm.generic_utilities;

import java.awt.Desktop.Action;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.text.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.asm.MemberSubstitution.TypePoolResolver.OfImplicitPool;

public class WebDriver_Utility {
	
	/**
	 * wait for page to load before identifying any synchronized in DOM
	 * @author divya
	 * 
	 */
	public void waitForPageToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	/**
	 * wait for the page to load 
	 * @param driver
	 * @param element
	 * @author divya
	 */
	public void waitForElementPresent(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * 
	 * used to wait for element to be clickable in GUI and check for specific element for every 500 milliseconds
	 * @author divya
	 */
	public void waitForElementWithCustomTimeOut(WebDriver driver,WebElement element,int pollingTime)
	{
		FluentWait wait= new FluentWait(driver);
		wait.pollingEvery(Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * used to switch to any window based on window title
	 * @param driver
	 * @param ParticularWindowTitle
	 * @author divya
	 */
	public void switchToWindow(WebDriver driver,String ParticularWindowTitle)
	{
		Set<String> allId = driver.getWindowHandles();
		Iterator<String> it = allId.iterator();
		while(it.hasNext())
		{
			String wid = it.next();
			driver.switchTo().window(wid);
			if(driver.getTitle().contains(ParticularWindowTitle))
			{
				break;
			}
		}
	}
	/**
	 * used to switch to AlertWindow and accept(click on ok button)
	 * @param driver
	 * @author divya
	 */
	public void switchToAlertAndAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	/**
	 * used to switch to AlertWindow and dismiss(click on cancel button)
	 * @param driver
	 * @author divya
	 */
	public void switchToAlertAndDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	/**
	 * used to switch to frame window based on Index
	 * @param driver
	 * @param index
	 * @author divya
	 */
	public void switchToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * used to switch to frame window based on id or name attribute
	 * @param driver
	 * @param id_name_attribute
	 * @author divya
	 */
	public void switchToFrame(WebDriver driver,String id_name_attribute)
	{
		driver.switchTo().frame(id_name_attribute);
	}
	/**
	 
	 * select by visible text
	 * @param element
	 * @param text
	 * @author divya
	 */
	public void selectOption(WebElement element,String text)
	{
		Select s=new Select(element);
		s.selectByVisibleText(text);
		
	}
	/**
	 * select by Value
	 * @param element
	 * @param value
	 * @author divya
	 */
	public void selectOptionbyValue(WebElement element, String value)
	{
		Select s1=new Select(element);
		s1.selectByValue(value);
	}
	/**
	 * select by index
	 * @param element
	 * @param index
	 * @author divya
	 */
	public void selectOptionbyIndex(WebElement element, int index)
	{
		Select s2=new Select(element);
		s2.selectByIndex(index);
	}
	/**
	 * used to place mouse cursor on specified element
	 * @param driver
	 * @param element
	 * @author divya
	 */
	public void mouseOverOnElement(WebDriver driver, WebElement element)
	{
		Actions ac1=new Actions(driver);
		ac1.moveToElement(element).perform();
	}
	/**
	 * method to right click
	 * @param driver
	 * @return element
	 * @author divya
	 */
	public void actionMethodToRightClick(WebDriver driver, WebElement element) {
		
		Actions act=new Actions(driver);
        act.contextClick(element).perform();		
	}
	/**
	 * method to double click
	 * @param driver
	 * @return element
	 * @author divya	 
	 */
	public void doubleClick(WebDriver driver, WebElement element)
	{
	    Actions ac=new Actions(driver);
	    ac.doubleClick(element).perform();
	}
	/**
	 * method to drag and drop
	 * @param driver
	 * @return src
	 * @return targt
	 * @author divya
	 */
	public void dragAndDrop(WebDriver driver, WebElement src, WebElement targt)
	{
		Actions acc=new Actions(driver);
		acc.dragAndDrop(src, targt);
	}
	/**
	 * method to move the element
	 * @param driver
	 * @return
	 * 
	 */
	public void moveToElement(WebDriver driver, WebElement element) {
		Actions acn=new Actions(driver);
		acn.moveToElement(element).perform();
	}
	public void moveByOffest(WebDriver driver,int x, int y)
	{
		Actions acn=new Actions(driver);
		acn.moveByOffset(x, y).click().perform();
	}
	public String takeScreenshot( WebDriver sDriver, String methodName)
	{
		return null;
	}

	public void maximizeTheWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

		
	
	 
}

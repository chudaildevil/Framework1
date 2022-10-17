package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
		
	public OrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//declaration
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement createOrgImg;
	
	@FindBy(name = "accountname")
	private WebElement accountNameTextField;
	
	@FindBy(name = "button")
	private WebElement saveButton;
	
	//@FindBy(xpath = "//span[@class='dvHeaderText']")
	//private WebElement actualText;

	
	//Getter methods
	public WebElement getCreateOrgImg() 
	{
		return createOrgImg;
	}

	public WebElement getAccountNameTextField()
	{
		return accountNameTextField;
	}

	public WebElement getSaveButton() 
	{
		return saveButton;
	}

	/*public WebElement getActualText()
	{
		return actualText;
	}*/
	
	
	/**
	 * Business logic
	 * @author Divya
	 */
	public void clickOnCreateOrganizion()
	{
		createOrgImg.click();
	}
	
	public void setAccountName(String Oname)
	{
		accountNameTextField.sendKeys(Oname);
	}
	
	public void clickOnSaveButton()
	{
		saveButton.click();
	}
	
	/*public String getActualResult()
	{
		return actualText.getText();
	}*/

}





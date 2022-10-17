package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	
		
	//initialization
		public ProductPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		//declaration
		
		@FindBy(xpath = "//img[@alt='Create Product...']")
		private WebElement createProductImg;
		
		@FindBy(name = "productname")
		private WebElement productNameTextField;
		
		@FindBy(name = "button")
		private WebElement saveButton;
		
		//@FindBy(xpath = "//span[@class='lvtHeaderText']")
		//private WebElement actualText;
		
		@FindBy(name = "Delete")
		private WebElement deleteButton;

		
		//Getter methods
		public WebElement getCreateProductImg() 
		{
			return createProductImg;
		}

		public WebElement getProductNameTextField()
		{
			return productNameTextField;
		}

		public WebElement getSaveButton() 
		{
			return saveButton;
		}

		/*public WebElement getActualText()
		{
			return actualText;
		}*/

		public WebElement getDeleteButton() 
		{
			return deleteButton;
		}
		
		 
		/**
		 * Business logic
		 * @author Divya
		 */
		public void clickOnCreateProductIcon()
		{
			createProductImg.click();
		}
		
		public void setproductName(String Pname)
		{
			productNameTextField.sendKeys(Pname);
		}

		public void clickOnSaveButton1()
		{
			saveButton.click();
		}
		
		/*public String getActualResult()
		{
			return actualText.getText();
		}*/
		
		public void clickOnDeleteButton()
		{
			deleteButton.click();
		}
		
		
	}




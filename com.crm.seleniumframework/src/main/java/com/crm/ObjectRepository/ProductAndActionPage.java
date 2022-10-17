package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductAndActionPage {
	
	//initialization
		public ProductAndActionPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		
		//declaration
		@FindBy(id = "search_txt")
		private WebElement productNameTextField;
		
		@FindBy(name = "search")
		private WebElement searchButton;
		
		@FindBy(xpath = "//a[@href='javascript:window.close();']")
		private WebElement textLink;
		

		//getter methods
		public WebElement getProductNameTextField() {
			return productNameTextField;
		}

		public WebElement getSearchButton() {
			return searchButton;
		}

		public WebElement getTextLink() {
			return textLink;
		}
		
		
		/**
		 * Business logic
		 * @author Divya
		 */
		
		public void setProductName(String Pname)
		{
			productNameTextField.sendKeys(Pname);
		}
		
		public void clickOnSearchButton()
		{
			searchButton.click();
		}
		
		public void clickProductNametextLink()
		{
			textLink.click();
		}
}

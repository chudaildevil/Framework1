package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampignPage {
	
	//initialization
	//initialization
		public CampignPage(WebDriver driver) 
		{
			PageFactory.initElements(driver, this);
		}
		
		
		//declaration
		@FindBy(xpath = "//img[@alt='Create Campaign...']")
		private WebElement createCampaignPage;
		
		@FindBy(name = "campaignname")
		private WebElement campaignNameTextField;
		
		@FindBy(name = "button")
		private WebElement saveButton;
		
		@FindBy(xpath = "//span[@class='dvHeaderText']")
		private WebElement actualText;
		
		@FindBy(xpath = "//img[@alt='Select']")
		private WebElement addProductImg;

		
		//getter methods
		public WebElement getCreateCampaignPage()
		{
			return createCampaignPage;
		}

		public WebElement getCampaignNameTextField() 
		{
			return campaignNameTextField;
		}

		public WebElement getSaveButton()
		{
			return saveButton;
		}

		public WebElement getActualText() 
		{
			return actualText;
		}
		
		public WebElement getAddProductImg()
		{
			return addProductImg;
		}

		
		/**
		 * business logic
		 * @author Divya
		 */
		
		public void clickOnCreateCampaignImg()
		{
			createCampaignPage.click();
		}
		
		public void setCampaignName(String Cname)
		{
			campaignNameTextField.sendKeys(Cname);
		}
		
		public void clickOnSaveButton()
		{
			saveButton.click();
		}
		
		public String getActualResult()
		{
			return actualText.getText();
		}
		
		public void clickOnAddProductImg()
		{
			addProductImg.click();
		}


	}

		
		



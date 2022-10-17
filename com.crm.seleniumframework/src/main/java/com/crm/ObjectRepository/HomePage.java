package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.generic_utilities.WebDriver_Utility;

public class HomePage {
	
		
		//initialization
		public HomePage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		
		//Deceleration
		@FindBy(linkText = "Organizations") 
		private WebElement organizationLinktext;
		
		@FindBy(linkText = "Products" )
		private WebElement productLinktext;
		
		@FindBy(linkText = "Campaigns")
		private WebElement CampaignLinktext;
		
		@FindBy(linkText = "More")
		private WebElement moreLinktext;
		
		@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
		private WebElement signOutImg;
		
		@FindBy(linkText = "Sign Out")
		private WebElement signoutLinktext;

		public WebElement getOrganizationLinktext() 
		{
			return organizationLinktext;
		}

		public WebElement getProductLinktext()
		{
			return productLinktext;
		}

		public WebElement getCampaignLinktext()
		{
			return CampaignLinktext;
		}

		public WebElement getMoreLinktext()
		{
			return moreLinktext;
		}

		public WebElement getSignOutImg()
		{
			return signOutImg;
		}

		public WebElement getSignoutLinktext()
		{
			return signoutLinktext;
		}
		
		/**
		 * Business logic
		 * @author Divya
		 */

	    public void clickOrganizationLink()
	    {
	    	organizationLinktext.click();
	    }
	    
	    public void clickProductionLink()
	    {
	    	productLinktext.click();
	    }
	    
	    public void moveToMoreLink(WebDriver driver)
	    {
	    	WebDriver_Utility wb=new WebDriver_Utility();
	    	wb.moveToElement(driver, moreLinktext);
	    }
	    
	    public void clickCampaignLink()
	    {
	    	CampaignLinktext.click();
	    }
	    
	     public void moveTosignoutImg(WebDriver driver)
	     {
	    	 WebDriver_Utility wb=new WebDriver_Utility();
	    	 wb.moveToElement(driver, signOutImg);
	     }
	    
	    public void clickSignoutLink()
	    {
	    	signoutLinktext.click();
	    }

}

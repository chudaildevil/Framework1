package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ValidationAndVerificationPage {
	
	public ValidationAndVerificationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement actualOrganizationData;
	
	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement actualProductData;
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement actualCampaignData;
	
	

	public WebElement getActualOrganizationData() {
		return actualOrganizationData;
	}

	public WebElement getActualProductData() {
		return actualProductData;
	}

	public WebElement getActualCampaignData() {
		return actualCampaignData;
	}
	
	public void organizationValidation(WebDriver driver,String data)
	{
		String actData = actualOrganizationData.getText();
		if(actData.contains(data))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
	}
	
	public void productValidation(WebDriver driver,String excel)
	{
		String actmsg = actualProductData.getText();
		if(actmsg.contains(excel))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
	}
	public void campaignValidation(WebDriver driver,String excel)
	{
		String actmsg = actualCampaignData.getText();
		if(actmsg.contains(excel))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
	}

	
}

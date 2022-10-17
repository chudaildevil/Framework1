package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//Initialization
	public  LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//Declaration
	@FindBy(name="user_name")
	private WebElement UNTextField;
	
	@FindBy(name="user_password")
	private WebElement PDTextField;
	
	@FindBy(id="submitButton")
	private WebElement LGbtn;

	public WebElement getUNTextField() {
		return UNTextField;
	}

	public WebElement getPDTextField() {
		return PDTextField;
	}

	public WebElement getLGbtn() {
		return LGbtn;
	}

	/** business logic
	 * 
	 * this method is used to login the application
	 * @author divya	
	 * @return 
	 */
	public void Login(String UN,String PD)
	{
		UNTextField.sendKeys(UN);
		PDTextField.sendKeys(PD);
		LGbtn.click();
	}
	

}

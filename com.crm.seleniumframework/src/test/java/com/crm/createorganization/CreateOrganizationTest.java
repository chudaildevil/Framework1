package com.crm.createorganization;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganizationPage;
import com.crm.ObjectRepository.ValidationAndVerificationPage;
import com.crm.generic_utilities.BaseClass;
import com.crm.generic_utilities.Excel_Utility;
import com.crm.generic_utilities.File_Utility;
import com.crm.generic_utilities.Java_Utility;
import com.crm.generic_utilities.WebDriver_Utility;


public class CreateOrganizationTest extends BaseClass {
	
	@Test
	public  void createOrganizationTest() throws Throwable {
		
		File_Utility f1=new File_Utility();
		WebDriver_Utility wb=new WebDriver_Utility();
		Excel_Utility ex=new Excel_Utility();
		Java_Utility ja=new Java_Utility();
		
		//using File_utility generic class
		//Read common data from property file
		 
		 String UN = f1.getPropertyKeyValue("Username");
		 String PD = f1.getPropertyKeyValue("Password");


	  
		//LoginPage POM class object
		LoginPage l=new LoginPage(driver);
		l.Login(UN,PD);
		
		//Homepage POM class Object
		HomePage h=new HomePage(driver);
		wb.waitForPageToLoad(driver);
		h.clickOrganizationLink();
		Thread.sleep(3000);
		
		//get randomNum from java_utility class
		int randomNum = ja.getRandomNum();
				
		//organization POM class object
		OrganizationPage org=new OrganizationPage(driver);
		org.clickOnCreateOrganizion();
		
		String excel = ex.getDataFromExcel("sheet1",0,0)+randomNum;
		org.setAccountName(excel);
		org.clickOnSaveButton();
		
		//Validationpage POM 
	    ValidationAndVerificationPage validate=new ValidationAndVerificationPage(driver);
	    validate.organizationValidation(driver, excel);
	//	WebElement actmsg = val.getActualOrganizationData();
			
	//	System.out.println(excel);
		/*if(actmsg.contains(excel)) 
		{
			System.out.println("Organization created successfully and pass");
		}
		else
		{	
			System.out.println("org not created and fail");
		}*/
		
		//SoftAssert soft=new SoftAssert();
		//soft.assertEquals(excel, actmsg);
		h.moveTosignoutImg(driver);
		h.clickSignoutLink();

		driver.close();	
		//soft.assertAll();
	}
	public void modifyOrg()
	{
		System.out.println("modified organization");
	}
}
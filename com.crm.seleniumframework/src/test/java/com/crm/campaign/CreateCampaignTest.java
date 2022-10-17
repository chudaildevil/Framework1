package com.crm.campaign;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.crm.ObjectRepository.CampignPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.ValidationAndVerificationPage;
import com.crm.generic_utilities.BaseClass;
import com.crm.generic_utilities.Excel_Utility;
import com.crm.generic_utilities.File_Utility;
import com.crm.generic_utilities.Java_Utility;
import com.crm.generic_utilities.WebDriver_Utility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaignTest extends BaseClass{
	
	@Test
	public void CreateCampaignTest() throws Throwable {

		//object creation of all the generic utility classes
				//File_Utility f1=new File_Utility();
				WebDriver_Utility wb=new WebDriver_Utility();
				Excel_Utility ex=new Excel_Utility();
				Java_Utility ja=new Java_Utility();
				
		
				//using File_utility generic class
				//Read common data from property file
				File_Utility f1= new File_Utility();
				 String url = f1.getPropertyKeyValue("URL");
				 String UN = f1.getPropertyKeyValue("Username");
				 String PD = f1.getPropertyKeyValue("Password");
				
				//String BROWSER=f1.getPropertyKeyValue("browser");
				//WebDriver driver;
				
				
				
				//LoginPage POM class object
				LoginPage l=new LoginPage(driver);
				l.Login(UN,PD);
				
				//Homepage POM class Object
				HomePage h=new HomePage(driver);
				h.moveToMoreLink(driver);
				h.clickCampaignLink();
				Thread.sleep(3000);
				//campaignpage
				CampignPage camp=new CampignPage(driver);
				camp.clickOnCreateCampaignImg();
				
				int randomNum = ja.getRandomNum();
				
				String excel = ex.getDataFromExcel("sheet1",0,0)+randomNum;
				camp.setCampaignName(excel);
				camp.clickOnSaveButton();
				
				ValidationAndVerificationPage val=new ValidationAndVerificationPage(driver);
				val.campaignValidation(driver, excel);

				/*String actdata = camp.getActualResult();
				 if(actdata.contains(excel))
					{
						System.out.println("Compaign created and pass");
					}
					else 
					{
						System.out.println("Compaign not created and fail");
					}*/
				 	wb.waitForPageToLoad(driver);
					h.moveTosignoutImg(driver);
					h.clickSignoutLink();

					driver.close();

	}

}

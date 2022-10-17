package com.crm.campaign;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
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
import org.testng.annotations.Test;

import com.crm.ObjectRepository.CampignPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.ProductAndActionPage;
import com.crm.ObjectRepository.ProductPage;
import com.crm.ObjectRepository.ValidationAndVerificationPage;
import com.crm.generic_utilities.BaseClass;
import com.crm.generic_utilities.Excel_Utility;
import com.crm.generic_utilities.File_Utility;
import com.crm.generic_utilities.Java_Utility;
import com.crm.generic_utilities.WebDriver_Utility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CampAndProductUsingInteratorTest extends BaseClass {
	
	
		@Test
		public void campAndProductUsingInteratorTest() throws Throwable {
		
			//object creation of all the generic utility classes
			File_Utility f1=new File_Utility();
			WebDriver_Utility wb=new WebDriver_Utility();
			Excel_Utility ex=new Excel_Utility();
			Java_Utility ja=new Java_Utility();
			
			
			//using File_utility generic class
			//Read common data from property file
			 String url = f1.getPropertyKeyValue("URL");
			 String UN = f1.getPropertyKeyValue("Username");
			 String PD = f1.getPropertyKeyValue("Password");
			 f1.getPropertyKeyValue("browser");
			
			String productdata = ex.getDataFromExcel("sheet1", 0, 0)+ja.getRandomNum();
			String data = ex.getDataFromExcel("sheet1", 0, 0)+ja.getRandomNum();

			//String BROWSER=f1.getPropertyKeyValue("browser");
			//WebDriver driver;

			
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			//LoginPage POM class object
			LoginPage l=new LoginPage(driver);
			l.Login(UN,PD);
			
			//Homepage POM class Object
			HomePage h=new HomePage(driver);
			h.clickProductionLink();
			
			
			ProductPage prod=new ProductPage(driver);
			prod.clickOnCreateProductIcon();
			
			int randomNum = ja.getRandomNum();
			
			String excel = ex.getDataFromExcel("sheet1",0,0)+randomNum;
			prod.setproductName(excel);
			prod.clickOnSaveButton1();
			
			h.moveToMoreLink(driver);
		
			h.clickCampaignLink();
			
			
			CampignPage camp=new CampignPage(driver);
			camp.clickOnCreateCampaignImg();
			camp.setCampaignName(excel);
			camp.clickOnAddProductImg();
			
			//switch to Products&action window and add the product name
			ProductAndActionPage prodactn=new ProductAndActionPage(driver);
			wb.switchToWindow(driver,"Products&action");
			prodactn.setProductName(data);
			prodactn.clickOnSearchButton();
			prodactn.clickProductNametextLink();
			
			//Switch to Campaigns&action window and save it
			wb.switchToWindow(driver, "Campaigns&action");
			camp.clickOnSaveButton();
			
			//step 10: Verify
			
			ValidationAndVerificationPage val=new ValidationAndVerificationPage(driver);
			val.campaignValidation(driver, excel);
			
	/*		String actData2=camp.getActualResult();
			if(actData2.contains(excel))
			{
				System.out.println("Test case Pass");
			}
			else
			{
				System.out.println("Fail");
			}
			*/

			//step 11: Signout
			h.moveTosignoutImg(driver);
			h.clickSignoutLink();

			//step 12: close all the browsers
			driver.quit();
}
}

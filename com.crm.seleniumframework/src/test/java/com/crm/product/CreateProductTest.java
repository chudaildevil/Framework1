package com.crm.product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.ProductPage;
import com.crm.ObjectRepository.ValidationAndVerificationPage;
import com.crm.generic_utilities.BaseClass;
import com.crm.generic_utilities.Excel_Utility;
import com.crm.generic_utilities.File_Utility;
import com.crm.generic_utilities.Java_Utility;
import com.crm.generic_utilities.WebDriver_Utility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProductTest extends BaseClass{

	@Test
	public void CreateProductTest() throws Throwable {

				//object creation of all the generic utility classes
				File_Utility f1=new File_Utility();
				WebDriver_Utility wb=new WebDriver_Utility();
				Excel_Utility ex=new Excel_Utility();
				Java_Utility ja=new Java_Utility();
				
				//using File_utility generic class
				//Read common data from property file
				String UN = f1.getPropertyKeyValue("Username");
				String PD = f1.getPropertyKeyValue("Password");
				f1.getPropertyKeyValue("browser");
							
				
				//String BROWSER=f1.getPropertyKeyValue("browser");
				//WebDriver driver;
				
				
			  
				//LoginPage POM class object
				LoginPage l=new LoginPage(driver);
				l.Login(UN,PD);
				Thread.sleep(3000);
				
				//Homepage POM class Object
				HomePage h=new HomePage(driver);
				h.clickProductionLink();
				
				//get randomNum from java_utility class
				int randomNum = ja.getRandomNum();
				
				ProductPage prod=new ProductPage(driver);
				prod.clickOnCreateProductIcon();
				
				String excel = ex.getDataFromExcel("sheet1",0,0)+randomNum;
				prod.setproductName(excel);
				prod.clickOnSaveButton1();
				
				ValidationAndVerificationPage val=new ValidationAndVerificationPage(driver);
				val.productValidation(driver, excel);
				
				/*String actData = prod.getActualResult();
				if(actData.contains(excel))
				{
					System.out.println("Product created and Pass");
				}
				else
				{
					System.out.println("Product not created and Fail");
				}*/
				
			//	Thread.sleep(2000);
				h.moveTosignoutImg(driver);
				h.clickSignoutLink();

				driver.close();			
	}
}

package com.crm.generic_utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static  WebDriver driver;
	public static WebDriver sDriver;
	WebDriver_Utility wb=new WebDriver_Utility();
	
	@BeforeSuite(groups= {"smokeTest","regressionTest"})
	public void BS()
	{
		System.out.println("Database connection");	
	}

	@BeforeTest(groups= {"smokeTest","regressionTest"})
	public void BT()
	{
		System.out.println("execute in parallel mode");
	}
	//@Parameters("BROWSER")
	@BeforeClass(groups= {"smokeTest","regressionTest"})
    //public void BC(String BROWSER) throws Throwable
	public void BC() throws Throwable
	{
		//object creation of all the generic utility classes
		File_Utility f1=new File_Utility();		

				String BROWSER=f1.getPropertyKeyValue("browser");
				String url = f1.getPropertyKeyValue("URL");
				if(BROWSER.equalsIgnoreCase("chrome"))
				{
					WebDriverManager.chromedriver().setup();
					driver= new ChromeDriver();
				}
				else if(BROWSER.equalsIgnoreCase("firefox"))
				{
					WebDriverManager.firefoxdriver().setup();
					driver=new FirefoxDriver();
				}
				else if(BROWSER.equalsIgnoreCase("edge"))
				{
					WebDriverManager.edgedriver().setup();
					driver=new EdgeDriver();
				}
				else
		        {
					driver=new ChromeDriver();
		        }
				sDriver=driver;
				
				driver.get(url);
				wb.maximizeTheWindow(driver);
				
				wb.waitForPageToLoad(driver);

		System.out.println("launching the browser");
	}

	@BeforeMethod(groups= {"smokeTest","regressionTest"})
	public void BM()
	{
				
		System.out.println("Login to application");
	}

	@AfterMethod(groups= {"smokeTest","regressionTest"})
	public void AM()
	{
		System.out.println("Logout the Application");
	}
	@AfterClass(groups= {"smokeTest","regressionTest"})
	public void AC()
	{
		System.out.println("close the browser");
	}
	@AfterTest(groups= {"smokeTest","regressionTest"})
	public void AT()
	{
		System.out.println("executed successfully");
	}
	@AfterSuite(groups= {"smokeTest","regressionTest"})
	public void AS()
	{
		System.out.println("Database closed");
	}

}


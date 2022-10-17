package com.crm.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.generic_utilities.File_Utility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateParameterTest {
	
	public static  WebDriver driver;
	@Test
    public void methodOpeningBrowser() throws Throwable
    {

   		String BROWSER=System.getProperty("browser");
   		//String url = f1.getPropertyKeyValue("URL");
   		
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
   		String url=System.getProperty("URL");
   		driver.get(url);
   		
   		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
   		String UN = System.getProperty("Username");
   		
   		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
   		String PD = System.getProperty("Password");
   		
    }

	
	
}

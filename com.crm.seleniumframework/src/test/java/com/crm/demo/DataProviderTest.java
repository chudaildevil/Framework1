package com.crm.demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DataProviderTest {
	
	@Test(dataProvider="dataProvider_test")
	public void salesOrder()
	{
		String key = "webdriver.chrome.driver";
		String value = "./chromedriver.exe";
		System.setProperty(key, value);
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("More")).click();
		driver.findElement(By.name("Sales Order")).click();
		driver.findElement(By.xpath("//img[@alt='Create Sales Order...']")).click();
		System.out.println("github pulled succefully");
		
		
		
		
	}

}

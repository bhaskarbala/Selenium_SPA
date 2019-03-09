package com.acttime.generic.lib;

import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

/* In BaseClass we should be execute before the @Test Annotations 
 * which content Connected to Data base,LunchToBrowser,LoginMethod,LogoutMethod,closeToBrowser and DisconnectedToDataBase
 * like @BeforeSuite @BeforeClass @BeforeMethod @AfterMethod @AfterClass @AfterSuite
 * 
 */
public class BaseClass {
	
	public static WebDriver driver;
	public static readDataExternalFile read=new readDataExternalFile();
	
	@BeforeSuite
	public void configBS() {
		System.out.println("connected to DataBAse");
		
	}
	
	
	
	@org.testng.annotations.BeforeClass
	public void LunchBrowser() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+""
				+ "./Resours/chromedriver.exe"); 
		driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	
	}
	
	
	
	
		@BeforeMethod
	public void preCondition() {
		
		try {
			driver.get(read.getPropertyKeyValue("Url"));
			driver.findElement(By.name("ctl00$ContentPlaceHolder2$txtUserName")).sendKeys(read.getPropertyKeyValue("Username"));
			driver.findElement(By.name("ctl00$ContentPlaceHolder2$txtPassword")).sendKeys(read.getPropertyKeyValue("Password"));
			driver.findElement(By.xpath("//input[@value='Login']")).click();
			Thread.sleep(3000);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		
	}
		@AfterMethod
		public void postCondition() {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
			System.out.println(e.getMessage());
				e.printStackTrace();
			}
			driver.findElement(By.linkText("Logout")).click();
		}
		@AfterClass
		public void closeToBrowser()
		{
			driver.close();
		}

		@AfterSuite
		public void configAS() {
			System.out.println("Disconnected to Data Base");
		
		}

	

}

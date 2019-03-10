package com.acttime.generic.lib;

import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
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
		Reporter.log("To Connected to DataBase");
		
	}
	
	
	
	@org.testng.annotations.BeforeClass
	public void LunchBrowser() throws Throwable {
		Reporter.log("Set To Property in WebDriver");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+""
				+ "./Resours/chromedriver.exe"); 
		driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	
			driver.get(read.getPropertyKeyValue("Url"));
			Reporter.log("Get a Url");
	
	
	}
	
	
	
	
		@BeforeMethod
	public void preCondition() {
		
		try {
			Reporter.log("Create WebDriverWiat it will wait for Visiable of Element");
			WebDriverWait wait=new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='login']"))));
			Reporter.log("get the Username From properties file");
			driver.findElement(By.name("ctl00$ContentPlaceHolder2$txtUserName")).sendKeys(read.getPropertyKeyValue("Username"));
			Reporter.log("get the password from properties file and pass GUI");
			driver.findElement(By.name("ctl00$ContentPlaceHolder2$txtPassword")).sendKeys(read.getPropertyKeyValue("Password"));
			Reporter.log("Click on login button");
			driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		} catch (Throwable e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		
	}
		@AfterMethod
		public void postCondition() {
		
				Reporter.log("click on the logout button");
				driver.findElement(By.linkText("Logout")).click();
		
		
		}
		@AfterClass
		public void closeToBrowser()
		{
			Reporter.log("Close the browser");
			driver.close();
		}

		@AfterSuite
		public void configAS() {
		Reporter.log("Disconnected to Data Base");
		
		}

	

}

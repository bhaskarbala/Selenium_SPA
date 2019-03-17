package com.SpaSelenium.generic.lib;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.Spa.objectrepository.HomePageRepo;
import com.Spa.objectrepository.LoginPage;

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
		String browserLunch=read.getPropertyKeyValue("Browser");
		if(browserLunch.equals("chrome")) {
			Reporter.log("Set To Property in WebDriver");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+""
					+ "./Resours/chromedriver.exe"); 
			driver=new ChromeDriver();
		}
		else if(browserLunch.equals("fireFox"))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+""
					+ "./Resours/geckodriver.exe"); 
			driver=new FirefoxDriver();
			
		}
		else if(browserLunch.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver","./Resours/IEDriverServer.exe"); 
			driver=new InternetExplorerDriver();
		
		
			
		}

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

				driver.get(read.getPropertyKeyValue("Url"));
			Reporter.log("Get a Url");
	
	
	}
	
	
	
	
		@BeforeMethod
	public void preCondition() throws Throwable {
		
	
			Reporter.log("Create WebDriverWiat it will wait for Visiable of Element");
			WebDriverWait wait=new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("horizontalTab"))));
			LoginPage lp=PageFactory.initElements(driver, LoginPage.class);
			String UserName=read.getPropertyKeyValue("Username");
			String Password=read.getPropertyKeyValue("Password");
			lp.loginToApp(UserName,Password);
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
			driver.quit();
		}

		@AfterSuite
		public void configAS() {
		Reporter.log("Disconnected to Data Base");
		
		}
		public static void getScreenShot() throws Throwable {
			EventFiringWebDriver efd=new EventFiringWebDriver(driver);
			File src=efd.getScreenshotAs(OutputType.FILE);
			File dsrc=new File("./ScreenShot/test.png");
			FileUtils.copyFile(src, dsrc);
		}

	

}

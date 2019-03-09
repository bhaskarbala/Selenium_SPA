package com.acttime.generic.lib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCaseP {
	 public static WebDriver driver; 
	 readDataExternalFile read=new readDataExternalFile();
	@BeforeMethod
	public void preCondition() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+""
				+ "./Resours/chromedriver.exe"); 
		driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		try {
			driver.get(read.getPropertyKeyValue("Url"));
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	@Test
	public void Runthe(){
		System.out.println("Ram");
		
	}
	
	@AfterMethod
	public void postCondition() {
		driver.close();
	}


}

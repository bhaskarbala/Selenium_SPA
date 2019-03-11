package com.SpaSelenium.testScript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.SpaSelenium.generic.lib.BaseClass;
@Listeners(com.SpaSelenium.generic.lib.ListenerImple.class)
public class LoginPageTest extends BaseClass{
	
	@Test
	public void VerifyPageHomePageTitle() throws Throwable
	{
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//form[@name='aspnetFo']"))));
		Reporter.log("Get the Title frome HomePage ");
	String Actualresult=driver.getTitle();
	
	String expectedresult="SPA";
	Reporter.log("To compare to ActualResult and ExpectedResult in Homepaga");
	
	Assert.assertEquals(Actualresult, expectedresult);
	}

	
	

}

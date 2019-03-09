package com.actitime.testScript;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.acttime.generic.lib.BaseClass;

public class LoginPage extends BaseClass{
	@Test
	public void VerifyPageHomePageTitle() throws Throwable
	{
		Thread.sleep(3000);
	String Actualresult=driver.getTitle();
	String expectedresult="SPA";
	Assert.assertEquals(Actualresult, expectedresult);
	}

	
	

}

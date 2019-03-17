package com.SpaSelenium.testScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Spa.objectrepository.HomePageRepo;
import com.Spa.objectrepository.OrganizationPage;
import com.SpaSelenium.generic.lib.BaseClass;
@Listeners(com.SpaSelenium.generic.lib.ListenerImple.class)
public class organizationPage extends BaseClass{
	@Test
	public void organizationPageShouldDisplyed()
	{
		HomePageRepo hp=PageFactory.initElements(driver, HomePageRepo.class);
	
	Actions act=new Actions(driver);
	act.moveToElement(driver.findElement(By.linkText("Configurations"))).build().perform();
	driver.findElement(By.linkText("Organization")).click();
	
	}

}

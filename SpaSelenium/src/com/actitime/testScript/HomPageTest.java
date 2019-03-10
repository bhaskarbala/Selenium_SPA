package com.actitime.testScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.acttime.generic.lib.BaseClass;

public class HomPageTest extends BaseClass{
	@Test
	public void corporateNameEditDropDown() {
		WebDriverWait wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//form[@name='aspnetForm']"))));
		Reporter.log("Identify the Element in GUI and Stored WebElment ");
		WebElement wb=driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlGroupName"));
		Reporter.log("Create Selecte Class and pass the WebElemnt reffence");
		Select sct=new Select(wb);
		Reporter.log("Take Help of Select class reffence by using selectByIndex");
		sct.selectByIndex(2);
	}


}

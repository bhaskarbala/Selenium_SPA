package com.SpaSelenium.generic.lib;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;

import org.testng.ITestResult;

public class ListenerImple implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {
		
	String failureTestName=result.getMethod().getMethodName();
	EventFiringWebDriver edriver=new EventFiringWebDriver(BaseClass.driver);
	File srcImg=edriver.getScreenshotAs(OutputType.FILE);
	File dstImg=new File("./ScreenShot/"+failureTestName+".png");
	try {
		FileUtils.copyFile(srcImg, dstImg);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
		}



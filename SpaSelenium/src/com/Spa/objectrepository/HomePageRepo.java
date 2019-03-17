package com.Spa.objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageRepo {
	
	@FindBy(linkText="Logout")
	private WebElement logoutLinkText;
	@FindBy (linkText="Masters")
	private WebElement mastersLinkText;
	@FindBy(linkText="Configarations")
	private WebElement configarationsLinkText;
	@FindBy(linkText="New Business")
	private WebElement newbusinessLinkText;
	@FindBy (linkText="Endorsement")
	private WebElement endorsementLinkText;
	@FindBy (linkText="Claims")
	private WebElement claimsLinkText;
	@FindBy (linkText="My Account")
	private WebElement myAccountLinkText;
	public WebElement getLogoutLinkText() {
		return logoutLinkText;
	}
	public WebElement getMastersLinkText() {
		return mastersLinkText;
	}
	public WebElement getConfigarationsLinkText() {
		return configarationsLinkText;
	}
	public WebElement getNewbusinessLinkText() {
		return newbusinessLinkText;
	}
	public WebElement getEndorsementLinkText() {
		return endorsementLinkText;
	}
	public WebElement getClaimsLinkText() {
		return claimsLinkText;
	}
	public WebElement getMyAccountLinkText() {
		return myAccountLinkText;
	}
	public void getlogoutToApp()
	{
		logoutLinkText.click();
	}



}

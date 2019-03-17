package com.Spa.objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	
	@FindBy(name="ctl00$ContentPlaceHolder2$txtUserName")
	private WebElement userNameEditBox;
	@FindBy(name="ctl00$ContentPlaceHolder2$txtPassword")
	private WebElement passwordEditBox;
	@FindBy(id="ctl00_ContentPlaceHolder2_btnSubmit")
	private WebElement loginButton;
	@FindBy(linkText=" Forgot password?")
	private WebElement forgotLink;
	public WebElement getUserNameEditBox() {
		return userNameEditBox;
	}
	public WebElement getUasswordEditbox() {
		return passwordEditBox;
	}
	public WebElement getLoginButton() {
		return loginButton;
	}
	public WebElement getForgotLink() {
		return forgotLink;
	}
	public void loginToApp(String username,String password) {
		userNameEditBox.sendKeys(username);

		passwordEditBox.sendKeys(password);
		loginButton.click();
	}
}

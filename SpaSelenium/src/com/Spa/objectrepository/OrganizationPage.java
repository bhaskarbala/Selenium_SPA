package com.Spa.objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrganizationPage {
	@FindBy(linkText="Organization")
	private WebElement organizationLinktext;

	public WebElement getOrganizationLinktext() {
		return organizationLinktext;
	}
	

}

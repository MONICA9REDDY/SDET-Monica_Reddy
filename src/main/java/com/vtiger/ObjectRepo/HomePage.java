package com.vtiger.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.com.generics.WebDriverUtility;

public class HomePage 
{
	WebDriver driver;
	public 	WebDriverUtility wdu = new WebDriverUtility();
	
	@FindBy(xpath ="img[@src='themes/softed/images/menuDnArrow.gif']")
	private WebElement MoreDropDown;
	
	public WebElement getMoreDropDown() {
		return MoreDropDown;
}
	@FindBy(xpath="//a[@href='index.php?module=Campaigns&action=index']")
	private WebElement Campaigns;
	
	public WebElement Campaigns() {
		return Campaigns;
		}
	@FindBy(xpath="//input[@id='122']")
	private WebElement Checkbox;
	
	public WebElement Checkbox() {
		return Checkbox;
		}
	
	@FindBy(xpath="input[@value='Mass Edit']")
	private WebElement MassEditbtn;
	
	public WebElement MassEditbtn() {
		return MassEditbtn;
		}
	@FindBy(xpath="input[@name='campaignname']")
	private WebElement campaignnametbx;
	
	public WebElement campaignnametbx() {
		return campaignnametbx;
		}
	
	@FindBy(xpath="//a[text()='Organizations']")
	private WebElement orglink;

	@FindBy(xpath="//a[text()='Contacts']")
	private WebElement contactlnk;

	public WebElement getOrglink() {
		return orglink;
	}

	public WebElement getContactlnk() {
		return contactlnk;
		
	}
	@FindBy(xpath="//img[@src='themes/softed/images/Home.PNG']")
	private WebElement homepagelnk;

	public WebElement getHomepagelnk() {
		return homepagelnk;
	}
	@FindBy(xpath = "//img[contains(@src,'user.PNG')]")
	private WebElement adminstrationImg;

	@FindBy(linkText = "Sign Out")
	private WebElement signOutLnk;

	public HomePage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	public void logout() {
		wdu.movetoelement(driver, adminstrationImg);
		signOutLnk.click();
	}
	
}




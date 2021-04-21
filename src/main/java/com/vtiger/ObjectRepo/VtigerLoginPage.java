package com.vtiger.ObjectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.PageFactory;

	public class VtigerLoginPage {


		public VtigerLoginPage(WebDriver driver) {             //Rule -4
			PageFactory.initElements(driver, this);
		}
		
		@FindBy (xpath = "//input[@name='user_name']")
		WebElement usernameEdt1;
		
	    @FindBy(name="user_name")                   //Rule -2 
	    private WebElement usernameEdt;
	    
	    @FindBy(name="user_password")
	    private WebElement passwordEdt;
	    
	    @FindBy(id="submitButton")
	    private WebElement loginButon;
	   
		public WebElement getUsernameEdt() {        //rule-3
			return usernameEdt1;
		}

		public WebElement getPasswordEdt() {
			return passwordEdt;
		}

		public WebElement getLoginButon() {
			return loginButon;
		}
	    
		public void loginToApp(String username , String password) {             //Rule -5
			usernameEdt1.sendKeys(username);
			passwordEdt.sendKeys(password);
			loginButon.click();
		}
		public void loginToApp() {             //Rule -5
			usernameEdt1.sendKeys("admin");
			passwordEdt.sendKeys("admin");
			loginButon.click();
		}
	   
	}


	
//	@FindBy(xpath="//input[@name='user_password']")
//	public WebElement passwordtxtfld;
//	
//	/**
//	 * We can use for list of WebElement;
//	 * 
//	 * 
//	 */
//	@FindBy(id="submitButton")
//	public WebElement loginbtn;
//	
//	/**
//	 * 
//	 * 
//	 */
	
	
	//@FindAll(={@FindBy(xpath="//input[@name='user']"),@FindBy(id="//input[@type='text']")})
	//public WebElement usernametxtfld;
	
	
	//@FindAll(value= {@FindBy(id="submitButton")})
	//public WebElement loginbtn;
	



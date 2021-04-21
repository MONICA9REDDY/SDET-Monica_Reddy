package com.vtiger.testcases;


	 
	import java.io.IOException;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.SendKeysAction;
	import org.openqa.selenium.support.ui.Select;
	import org.testng.annotations.Test;

	import com.vtiger.com.generics.BaseClass;
	import com.vtiger.ObjectRepo.ContactPage;
	import com.vtiger.ObjectRepo.CreateContactPage;
	 
	import com.vtiger.ObjectRepo.HomePage;
	import com.vtiger.ObjectRepo.VtigerLoginPage;
	@Test
	public class LatestOneCreateContact extends BaseClass {

		public void createcontact() {

			HomePage hp = new HomePage(driver);
			hp.getContactlnk().click();

			ContactPage cp = new ContactPage(driver);
			cp.getCreatecontactbtn().click();

			CreateContactPage ccp = new CreateContactPage(driver);
			wdu.selectdropdown(ccp.getSelectinitial(), "Mrs.");
			
			ccp.getfirstnametxtfld().sendKeys("XYZ");
			ccp.getLastnametxtfld().sendKeys("ABC");
			ccp.getsavebtn().click();

		}
	}




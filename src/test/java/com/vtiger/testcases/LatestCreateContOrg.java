package com.vtiger.testcases;

	import java.io.IOException;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.FindAll;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.FindBys;
	import org.openqa.selenium.support.PageFactory;
	import org.testng.annotations.Test;

	import com.vtiger.com.generics.ExcelUtility;
	import com.vtiger.com.generics.FileUtility;
	import com.vtiger.com.generics.IConstants;
	import com.vtiger.com.generics.JavaUtility;
	import com.vtiger.com.generics.WebDriverUtility;
	import com.vtiger.ObjectRepo.ContactPage;
	import com.vtiger.ObjectRepo.CreateContactPage;
	import com.vtiger.ObjectRepo.HomePage;
	import com.vtiger.ObjectRepo.VtigerLoginPage;
	
	public class LatestCreateContOrg {
		//WebDriver driver ;
		JavaUtility jv = new JavaUtility();
		FileUtility fu=  new FileUtility();
		ExcelUtility eu= new ExcelUtility();
		WebDriverUtility wdu= new WebDriverUtility();
		@Test
		public void createcontact() throws IOException, InterruptedException 
		{
			
			WebDriver	driver= new ChromeDriver();
			wdu.maximizewindow(driver);
			driver.get(fu.readDatafrompropfile(IConstants.propfilepath, "url"));
			wdu.implicitwait(driver);

			//Login to App
			VtigerLoginPage lp = new VtigerLoginPage(driver);
			lp.loginToApp(fu.readDatafrompropfile(IConstants.propfilepath, "username"), fu.readDatafrompropfile(IConstants.propfilepath, "password"));

			//Click on contact
			HomePage hp = new HomePage(driver);
			hp.getContactlnk().click();
			
			//click on create contact
			ContactPage cp = new ContactPage(driver);
			cp.getCreatecontactbtn().click();
			
			//Conatct Name
			CreateContactPage ccp=new CreateContactPage(driver);
			ccp.getLastnametxtfld().sendKeys("Reddy");

			//Click on plus btn so that new window should open
			wdu.waitandclick(driver, "//input[@name='account_name']//following-sibling::img");
			
			//switch to window
			wdu.switchtochildwindow(driver, "childwindtit");

			//select orgname
			ccp.selectorg("TCS");
			wdu.waitandclick(driver, "//a[@id='1']");
		
			//switch back to Contacts window
			wdu.switchtochildwindow(driver, "Contacts");
			
			//Click on save btn
			ccp.getsavebtn().click();
		}
		
	}


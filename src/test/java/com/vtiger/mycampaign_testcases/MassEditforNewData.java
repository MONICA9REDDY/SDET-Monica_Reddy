package com.vtiger.mycampaign_testcases;

	import java.io.IOException;
	import org.apache.poi.EncryptedDocumentException;
	import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.testng.Assert;
	import org.testng.Reporter;
	import org.testng.annotations.Listeners;
	import org.testng.annotations.Test;

import com.vtiger.ObjectRepo.HomePage;
import com.vtiger.com.generics.BaseClass;
	import com.vtiger.com.generics.ExcelUtility;
	import com.vtiger.com.generics.FileUtility;
	import com.vtiger.com.generics.JavaUtility;
	import com.vtiger.com.generics.WebDriverUtility;
 
	 
	//@Listeners(com.OrangeHRM.generic.ListenerImplements.class)
	public class MassEditforNewData extends BaseClass {
			static {
				System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
			}
			
			WebDriver driver ;
			JavaUtility jv = new JavaUtility();
			FileUtility fu=  new FileUtility();
			ExcelUtility eu= new ExcelUtility();
			WebDriverUtility wdu= new WebDriverUtility();
			@Test
			public void Mass_Edit_CampaignTC() throws Exception {
			//Reporter.log("login",true);
			Reporter.log("MassEditCampaigns",true);
			 
			String CampaignName =eu.readDatafromExcel("Sheet2",1,0);
			//String CampaignNo =eu.readDatafromExcel(" Sheet2",1,1);
			HomePage hp=new HomePage(driver);
			 
			 
			 
			//a[text()="Aristotal"]
			//a[text()="Manthas"]
			 
			 
			 
			//mouse hover to More dropdown
			wdu.mouseHover(driver,hp.getMoreDropDown()); 
			wdu.elementisclickable(driver,hp.Campaigns());
		 
			 
			//click on edit button
			hp.Checkbox().click();
			Thread.sleep(2000);
			hp.MassEditbtn().click();
			Thread.sleep(2000);
			// //input[@name="campaignname"]
			//ap.getOrganizationNametbx().sendKeys(OrganizationName);
			hp.campaignnametbx().sendKeys(CampaignName);
			
			Thread.sleep(2000);
			String ActualCampaigns = hp.campaignnametbx().getAttribute("value");
			Assert.assertEquals(ActualCampaigns, CampaignName);
		}
				
		}





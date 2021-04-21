package com.vtiger.testcases;


	 

	import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.Assert;
	import org.testng.annotations.Test;

	import com.vtiger.com.generics.BaseClass;
	import com.vtiger.com.generics.ExcelUtility; 
	import  com.vtiger.com.generics.FileUtility; 
	import  com.vtiger.com.generics.IConstants; 
	import  com.vtiger.com.generics.JavaUtility;
	import  com.vtiger.com.generics.WebDriverUtility;
	import com.vtiger.ObjectRepo.LatestCreateOrgPage;
	import com.vtiger.ObjectRepo.CreateOrgPage;
	import com.vtiger.ObjectRepo.HomePage;
	import com.vtiger.ObjectRepo.VtigerLoginPage;
	import com.vtiger.ObjectRepo.OrgPage;
	 

	 @Test 
	public class LatestOneCreateOrg extends BaseClass
	{
		public void createOrg() throws EncryptedDocumentException, Exception 
		{

			int randomnumber=jv.createRandomNumber();
			
			//Read Test Script Data from Excel
			String name=eu.readDatafromExcel("Sheet1", 0, 0);
			String orgname=name+randomnumber;
			String phonenumber=eu.readDatafromExcel("Sheet1", 1, 0);
			String indDD=eu.readDatafromExcel("Sheet1", 2, 0);
			String ratingDD=eu.readDatafromExcel("Sheet1", 3, 0);
			String typeDD=eu.readDatafromExcel("Sheet1", 4, 0);

			//Name of org
			System.out.println(name+" "+orgname+" "+phonenumber+" "+indDD+" "+ratingDD+" "+typeDD);

			HomePage hp = new HomePage(driver);
			hp.getOrglink().click();

			OrgPage op= new OrgPage(driver);
			op.getCreateorgbtn().click();

			CreateOrgPage cop = new CreateOrgPage(driver);
			cop.getOrgnametxtfld().sendKeys(orgname);
			cop.getphonenotxtfld().sendKeys(phonenumber);


			wdu.selectdropdown(cop.getIndustrydd(), indDD);
			wdu.selectdropdown(cop.getAcctypedd(), typeDD);
			wdu.selectdropdown(cop.getRatingdd(), ratingDD);

			cop.getSavebtn().click();
			wdu.refresh(driver);

			hp.getHomepagelnk().click();
			hp.getOrglink().click();

			op.getSearchbox().sendKeys(orgname);
			wdu.selectdropdown(op.getSelectorgtypedd(),"Organization Name" );
			op.getSubmitbtn().click();

			WebElement actualorgname=driver.findElement(By.xpath("//a[text()='"+orgname+"']/ancestor::table[@class='lvt small']"));

			wdu.waitforElement(actualorgname);

			System.out.println(actualorgname.getText());

			boolean result=actualorgname.getText().contains(orgname);

			Assert.assertEquals(true, result);

		}

	}



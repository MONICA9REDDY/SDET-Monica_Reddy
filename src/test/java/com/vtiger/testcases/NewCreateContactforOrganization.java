package com.vtiger.testcases;


	 
	import java.io.IOException;
	import java.util.Iterator;
	import java.util.Set;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.Select;
	import org.testng.annotations.Test;

	import com.vtiger.com.generics.ExcelUtility;
	import com.vtiger.com.generics.FileUtility;
	import com.vtiger.com.generics.IConstants;
	import com.vtiger.com.generics.JavaUtility;
	import com.vtiger.com.generics.WebDriverUtility;
	 
	public class NewCreateContactforOrganization {
		static {
			System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		}
		JavaUtility jv = new JavaUtility();
		FileUtility fu=  new FileUtility();
		ExcelUtility eu= new ExcelUtility();
		WebDriverUtility wdu= new WebDriverUtility();
		
		@Test(groups= {"SMOKE-TEST","REGRESSION-TEST"})
		
		public void createcontact() throws IOException, InterruptedException {

			String UN=fu.readDatafrompropfile(IConstants.propfilepath, "username");
			String PWD=fu.readDatafrompropfile(IConstants.propfilepath, "password");
			String URL=fu.readDatafrompropfile(IConstants.propfilepath, "url");

			WebDriver driver = new ChromeDriver();
			wdu.maximizewindow(driver);
			driver.get(URL);
			wdu.implicitwait(driver);
			
			//LoginPage lp= PageFactory.initElements(driver,LoginPage class);
			//lp.usernametxtfld.sendskeys("admin");
			//driver.navigate().refresh();
			//lp.usernametxtfld.sendkeys("admin");
			//lp.passwordtxtfld.sendkeys("admin");
			//lp.loginbtn.click();

			driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(UN);
			driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PWD);
			driver.findElement(By.id("submitButton")).click();
			driver.findElement(By.xpath("//a[text()='Contacts']")).click();

			driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

			driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Reddy");

			driver.findElement(By.xpath("//input[@name='account_name']//following-sibling::img")).click();

			String parent = driver.getWindowHandle();
			Set<String> child = driver.getWindowHandles();
			Iterator<String> childWin = child.iterator();

			while(childWin.hasNext())
			{
				String childWindow = childWin.next();
				if(!parent.equalsIgnoreCase(childWindow))
				{
					driver.switchTo().window(childWindow);
					driver.findElement(By.id("search_txt")).sendKeys("TCS");
					driver.findElement(By.xpath("//input[@name='search']")).click();
					Thread.sleep(3000);
					driver.findElement(By.xpath("//a[@id='1']")).click();
				}
			}
			driver.switchTo().window(parent) ;
			driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
		}

	}





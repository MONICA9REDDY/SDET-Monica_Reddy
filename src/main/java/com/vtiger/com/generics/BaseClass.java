package com.vtiger.com.generics;

	import java.io.IOException;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.ie.InternetExplorerDriver;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.AfterSuite;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.vtiger.ObjectRepo.HomePage;
	import com.vtiger.ObjectRepo.VtigerLoginPage;

	public class BaseClass 
	{
		public WebDriver	driver;
		public	JavaUtility jv = new JavaUtility();
		public FileUtility fu=  new FileUtility();
		public ExcelUtility eu= new ExcelUtility();
		public WebDriverUtility wdu= new WebDriverUtility();


	/**
	 * Create DB Connection
	 * And  Extent Report
	 */
		@BeforeSuite(groups= {"SMOKE-TEST","REGRESSION-TEST"})
		public void beforesuite() 
		{
			System.out.println("==DB connection==");
			System.out.println("==Extent report==");
		}

		@AfterSuite(groups="SMOKE-TEST")
		public void afterSuite() 
		{
			System.out.println("==Close DB connection==");
			System.out.println("== Close Extent report==");
		}

		/**
		 * Launch Browser and get the URL
		 * @throws IOException
		 */
		@BeforeClass(groups= {"SMOKE-TEST","REGRESSION-TEST"})
		public void launchBrowser() throws IOException {

			String BROWSER=fu.readDatafrompropfile(IConstants.propfilepath, "browser");

			if(BROWSER.equalsIgnoreCase("chrome")) {
				driver= new ChromeDriver();
			}
			else if(BROWSER.equalsIgnoreCase("firefox")) {
				driver= new FirefoxDriver();
			}
			else if(BROWSER.equalsIgnoreCase("ie")) {
				driver= new InternetExplorerDriver();
			}
			wdu.maximizewindow(driver);
			wdu.implicitwait(driver);
			driver.get(fu.readDatafrompropfile(IConstants.propfilepath, "url"));
		}
//		@Parameters("BROWSER")
//		@BeforeClass(groups="SMOKE-TEST")
//		public void configBeforeClassCompatability(String browser) throws IOException {
//			System.out.println("=====Launch Browser=====");
//			/*
//			 * launch browser from the parameters
//			 */
//			String url=fu.readDatafrompropfile(IConstants.propfilepath, "url");
//			if(browser.equals("chrome"))
//			{
//				driver=new ChromeDriver();//if parameter has chrome than launch chrome browser
//			}
//			else if(browser.equals("firefox"))
//			{
//				driver=new FirefoxDriver();//if parameter has firefox than launch firefox browser
//			}
//			else
//				driver= new InternetExplorerDriver();
//				wdu.implicitwait(driver);
//				driver.get(url);
//		}
//		
		@AfterClass(groups= {"SMOKE-TEST","REGRESSION-TEST"})
		public void closeBrowser() {
			driver.quit();
		}
		
		@BeforeMethod(groups= {"SMOKE-TEST","REGRESSION-TEST"})
		public void logintoapp() throws IOException {
			VtigerLoginPage lp = new VtigerLoginPage(driver);
			lp.loginToApp(fu.readDatafrompropfile(IConstants.propfilepath, "username"), fu.readDatafrompropfile(IConstants.propfilepath, "password"));

		}
		
		@AfterMethod(groups= {"SMOKE-TEST","REGRESSION-TEST"})
		public void logoutfromApp() {
			HomePage hp = new HomePage(driver);
			hp.logout();
		}

	}



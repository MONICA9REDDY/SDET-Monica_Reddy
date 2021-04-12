package com.Assignment;

import java.util.concurrent.TimeUnit; 
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalandarCurrentDate
  {
	static {
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");

	}
	public static void main(String[] args) throws InterruptedException {

//		Date dateobj= new  Date();
//		String currentSysDate=dateobj.toString();
//		System.out.println(currentSysDate);
//
//		String arr[]=currentSysDate.split(" ");
//		String var=arr[0];
//		String date= arr[2];
//		String month= arr[1];
//		String year = arr[5];
//
//		System.out.println(var+" "+date+" "+month+" "+year);


		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");

		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 20);

		Actions act = new Actions(driver);
		act.moveByOffset(10, 10).click().perform();

		driver.findElement(By.xpath("//input[@id='fromCity']")).sendKeys("BOM");
		driver.findElement(By.xpath("//div[contains(text(),'BOM')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='toCity']")).sendKeys("PNQ");
		driver.findElement(By.xpath("//div[contains(text(),'PNQ')]")).click();

		WebElement departure=driver.findElement(By.xpath("//span[text()='DEPARTURE']"));
		wait.until(ExpectedConditions.elementToBeClickable(departure)).click();

		//String currdate=var+" "+month+" "+date+" "+year;

		//driver.findElement(By.xpath("//div[@aria-label='Wed Apr 07 2021']")).click();
		//driver.findElement(By.xpath("//div[@aria-label='"+currdate+"']")).click();
		//div[@aria-label='Mon Sep 06 2021']

		int count =0;
		
		while(count<11) 
		{
			try
			{
				driver.findElement(By.xpath("//div[@aria-label='Mon Sep 06 2021']")).click();
			break;
			}
			catch(Exception e)
			{
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
				count++;
			}
		}
		System.out.println(count);
	
	driver.close();
	
	}}
	

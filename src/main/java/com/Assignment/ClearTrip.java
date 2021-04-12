/**
 * 
 */
package com.Assignment;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author LENOVO
 *
 */
public class ClearTrip {
	
	/**
	 * @param args
	 */
	 
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		Date dateobj= new  Date();
		String currentSysDate=dateobj.toString();
		System.out.println(currentSysDate);

		String arr[]=currentSysDate.split(" ");
		//String date=arr[2];
		int date=dateobj.getDate();
		int month=dateobj.getMonth();
		String year = arr[5];

		System.out.println(date+" "+month+" "+year);

		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.cleartrip.com/");
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("FromTag")).sendKeys("BLR"); driver.findElement(By.
				xpath("//a[contains(text(),'Bangalore, IN - Kempegowda International Airport (BLR)')]")).click(); 
		//a[contains(text(),'"+srcLocation+"')]")
		driver.findElement(By.id("ToTag")).sendKeys("BOM"); driver.findElement(By.
				xpath("//a[text()='Mumbai, IN - Chatrapati Shivaji Airport (BOM)']")).click();
		driver.findElement(By. xpath("//td[@data-month='"+month+"' and @data-year='"+year+"']/a[text()='"+date+"']")).click();
	}
}

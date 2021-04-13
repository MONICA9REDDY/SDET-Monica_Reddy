package com.Assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AmazonBookPrintPrice {

	static {
	System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait( 10,TimeUnit.SECONDS);
		driver.get("https://www.amazon.com/" );
		WebElement listbox = driver.findElement(By.id( "searchDropdownBox"));
		Select s = new Select(listbox);
		s.selectByVisibleText("Books");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("one arranged murder by chetan bhagat");
		driver.findElement(By.id("nav-search-submit-button")).click();
		WebElement text=driver.findElement(By.xpath("//a[contains(@href,'One-Arranged-Murder-Chetan-Bhagat-ebook/dp/B084Q7FLZB/ref=sr_1_1?dchild=1&keywords=one+arranged+murder+by+chetan+bhagat&qid=1618319399&s=books&sr=1-1')]"));
				//a[@class='a-link-normal a-text-normal']"));
				//a[contains(@href,'One-Arranged-Murder-Chetan-Bhagat-ebook/dp/B084Q7FLZB/ref=sr_1_fkmr0_1?crid=16J1W8EMTPDEW&dchild=1&keywords=one+arranged+murder+by+chetan+bhagat&qid=1618318104&s=books&sprefix=one+murder+%2Caps%2C429&sr=1-1-fkmr0')]"));
		System.out.println(text);
		driver.close();	
	}
	
}
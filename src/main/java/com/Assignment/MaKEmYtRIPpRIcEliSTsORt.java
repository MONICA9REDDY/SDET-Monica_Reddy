package com.Assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MaKEmYtRIPpRIcEliSTsORt {
static {
	System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}
public static void main(String[] args, List<WebElement> al)  throws InterruptedException
{
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	driver.get("https://www.makemytrip.com/");
	Actions a= new Actions(driver);
	WebElement ele =driver.findElement(By.xpath("//body[@class='desktop in']"));
	driver.findElement(By.xpath("//label[@for='fromCity']")).click();
	driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("PNQ");
	driver.findElement(By.xpath("//div[.='PNQ']")).click();
	Thread.sleep(2000);
	driver.findElement( By.xpath("//p[@data-cy='departureDate']")).click();
	driver.findElement(By.xpath("//div[@class='DayPicker-Day DayPicker-Day--selected']")).click();
	driver.findElement(By.xpath("//a[.='search']")).click();
	Thread.sleep(2000);
	List<WebElement> priceList = driver.findElements(By.xpath("//p[@class='blackText fontSize18 blackFont']"));
	ArrayList<String>al1 = new ArrayList<String>();
	for(WebElement price:priceList) {
		String pricetxt = price.getText();
		al1.add(pricetxt);
	}
	Collections.sort(al1);
	for(String elements:al1) {
		System.out.println(elements);
	}
}
			
}



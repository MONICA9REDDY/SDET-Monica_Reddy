package com.Assignment;

//import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WikiiICCIndiaPonts {
	
	static {
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//driver.get("https://www.wikipedia.org/");
		driver.get("https://en.wikipedia.org/wiki/ICC_Test_Championship");
		Thread.sleep(2000);
		 String points=driver.findElement(By.xpath("//a[@title=\"India national cricket team\"]/ancestor::table[@class=\"wikitable\"]//a[.=\"ICC Test Championship\"]"
				+ "/parent::caption/following-sibling::tbody//tr[2]/td[3]")).getText();
		 System.out.println("ICC Test Championship Points: "+points);
		driver.close();
		}
	} 	


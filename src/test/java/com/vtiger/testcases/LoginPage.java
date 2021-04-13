package com.vtiger.testcases;

	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;

	public class LoginPage {

		public static void main(String[] args) {

			WebDriver driver = new FirefoxDriver();

			driver.get("https://localhost:8888.com/");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
			driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
			driver.findElement(By.id("submitButton")).click();
		}

	}


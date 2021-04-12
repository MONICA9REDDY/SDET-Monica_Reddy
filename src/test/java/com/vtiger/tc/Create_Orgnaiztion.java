package com.vtiger.tc;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
 
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Create_Orgnaiztion {
	static {
		System.setProperty("webdriver.chrome.driver","./driver/ChromeDriver.exe");
		}
	public static void main(String[] args) throws Exception {
		Random r=new Random();
		int num = r.nextInt();
		String orgname="Tesla"+num;
		WebDriver dr=new ChromeDriver();
		dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		dr.manage().window().maximize();
		dr.get("http://localhost:8888/");
		dr.findElement(By.name("user_name")).sendKeys("admin");
		dr.findElement(By.name("user_password")).sendKeys("admin");
		dr.findElement(By.id("submitButton")).click();
		dr.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		dr.findElement(By.xpath("//a/img[contains(@title,'Create Organization')]")).click();
		dr.findElement(By.name("accountname")).sendKeys(orgname);
		WebElement industrynames = dr.findElement(By.name("industry"));
		selectItemFromList(industrynames, "Biotechnology");
		WebElement typename = dr.findElement(By.name("accounttype"));
		selectItemFromList(typename, "Analyst");
		dr.findElement(By.id("phone")).sendKeys("99963646526745");
		dr.findElement(By.xpath("//input[contains(@value,'Save')]")).click();
		Thread.sleep(1000);
		WebElement organclk = dr.findElement(By.xpath("(//a[text()='Organizations'])[1]"));
		WebDriverWait wait=new WebDriverWait(dr,20);
		wait.until(ExpectedConditions.elementToBeClickable(organclk)).click();

		ArrayList<String> al1=new ArrayList<String>();
		List<WebElement> orgnames = dr.findElements(By.xpath("//table[@class='lvt small']/tbody/tr/td[3]/a"));
		for(int i=0;i<orgnames.size();i++)
		{
		al1.add(orgnames.get(i).getText());
		}
		for(String al:al1)
		{
		if(al.equals(orgname))
		{
		System.out.println("test script is pass");
		}

		}
		dr.close();
		}
		public static void selectItemFromList(WebElement list,String item)
		{
		Select s=new Select(list);
		s.selectByValue(item);

		}
}

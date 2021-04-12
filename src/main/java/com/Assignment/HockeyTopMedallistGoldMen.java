package com.Assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HockeyTopMedallistGoldMen {
	static {
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.olympic.org/hockey/12-team-tournament-men");
		List<WebElement> li = driver.findElements(By.xpath("//section[@class='related-athletes alt first']/ul/li/div/a/strong[@class='name']"));
		ArrayList<String> al=new ArrayList<String>();
		int count=li.size();
		for(WebElement medals:li)
	  {
			al.add(medals.getText());
	  }
		/*for(String name:al)
		{System.out.println(name);}*/
	List<WebElement> gli = driver.findElements(By.xpath(" //section[@class='related-athletes alt first'] /ul/li/div/a/strong[@class='name']/ancestor::div[@class='holder'] //ul[@class='medal-box']/li[1]"));
	ArrayList<String> lli=new ArrayList<String>();
	for(WebElement medals:gli)
  {
		lli.add(medals.getText());
  }
	for(int i=0;i<al.size();i++)
	{
		System.out.println(al.get(i)+"----"+lli.get(i));
}
}
}




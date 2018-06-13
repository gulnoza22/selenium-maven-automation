package com.dice;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DiceJobSearch {
	
	public static void main(String[] args) {
		  // chrome driver path
		WebDriverManager.chromedriver().setup();
		  //invoke selenium webdriver
		WebDriver driver=new ChromeDriver();
		  //to make fullscreen
		driver.manage().window().maximize();
		  //set universal wait time in case web page is slow
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  // goint to website by assigning to String
		String url="https://dice.com";
		driver.get(url);
		
		String actualTitle=driver.getTitle();
		String expectedTitle="Job Search for Technology Professionals | Dice.com";
		if(actualTitle.equals(expectedTitle)) {
			System.out.println("Step pass");
		}else {
			System.out.println("Step Fail");
		}
		String keyword="java developer";
		driver.findElement(By.id("search-field-keyword")).clear();
		driver.findElement(By.id("search-field-keyword")).sendKeys(keyword);
		
		String location="78728";
		driver.findElement(By.id("search-field-location")).clear();
		driver.findElement(By.id("search-field-location")).sendKeys(location);
		
		driver.findElement(By.id("findTechJobs")).click();
		
		String count= driver.findElement(By.id("posiCountId")).getText();
		System.out.println(count);
		
		//ensure count is more than 0
		int countResult =Integer.parseInt(count.replace(",", ""));
		if(countResult>0) {
			System.out.println(" Step Pass keyword: " +keyword+ " search returned " + countResult + " results in " +location);
		}else {
			System.out.println(" Step Fail keyword: " +keyword+ " search returned " + countResult + " results in " +location);
		}
		
		driver.close();
	System.out.println("Test completed " + LocalDateTime.now());
		
		
		
		
		
		
		
		
		
		
	}

}

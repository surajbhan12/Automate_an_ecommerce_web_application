package com.example;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class NewTest {
	WebDriver wd;
	
	 @BeforeTest
	  public void beforeTest() {
		  WebDriverManager.chromedriver().setup();
			wd=new ChromeDriver();
			wd.manage().window().maximize();
	 }
	 @AfterTest
	  public void afterTest() throws InterruptedException {
		 Thread.sleep(5000);
		  wd.quit();
	  }
	
	@Test
	public void flipcartPageTest() throws MalformedURLException {
		
		long start =System.currentTimeMillis();
		wd.get("https://www.flipkart.com/");
		long finish=System.currentTimeMillis();
		long Total_Time=(finish-start)/1000;
		System.out.println("Total page load time : "+Total_Time+"seconds");
		
		if(Total_Time>50) {
			System.out.println("Page load time is more than expected");
		}
		else {
			System.out.println("Hurray its loading quickly ");
		}
		
		
	  WebElement textFieldRef = wd.findElement(By.name("q"));
	  textFieldRef.sendKeys("iPhone 13");
		WebElement buttonRef = wd.findElement(By.className("L0Z3Pu"));
		buttonRef.click();	 
	  	buttonRef.sendKeys(Keys.ENTER);
	  	try {
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	  	String execScript="return document.documentElement.scrollHeight>document.documentElement.clientHeight;";
		JavascriptExecutor js= (JavascriptExecutor) wd;
		Boolean test=(Boolean) js.executeScript(execScript);
		if(test==true) {
			System.out.println("Scroll Bar is Present !");
		}
		else {
			System.out.println("Scroll Bar is not Present !");
		}
	  	wd.navigate().back();
	  	
		
	//	*[@id="__LOADABLE_REQUIRED_CHUNKS__"]
		
		WebElement ExplorePlus= wd.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[1]/div/a[2]"));
		if(ExplorePlus.isEnabled()) {
			System.out.println("ExplorePlus in image is enabled ");
		}
		else {
			System.out.println("ExplorePlus in image is not enabled ");
			}
   
	
	    Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	    System.out.println("height "+screensize.getHeight());
	    System.out.println("width "+screensize.getWidth());
	    int screenresolution= Toolkit.getDefaultToolkit().getScreenResolution();
	    System.out.println("resoltion "+ screenresolution);
	    
}
}

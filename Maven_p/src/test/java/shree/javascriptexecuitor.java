package shree;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class javascriptexecuitor {
		
			WebDriver driver;
			String url1 ="https://www.rahulshettyacademy.com/practice-project";

		@BeforeTest //launching and getting website
		public  void tc1() throws InterruptedException {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();//launching the browser
			driver.get(url1);//initiating a url
			driver.manage().window().maximize();//used to maximize the web. 
			Thread.sleep(5000);
		}

		@Test(enabled= true)
		public void tc() throws InterruptedException, AWTException {
			JavascriptExecutor jes=((JavascriptExecutor)driver);
			jes.executeScript("document.getElementById('name').value='Kavyashree'");
			jes.executeScript("document.getElementById('email').value='kavyashree.hp@moolya.com'");
			jes.executeScript("document.getElementById('agreeTerms').click()");
			jes.executeScript("document.getElementById('form-submit').click()");
			}

		
		}


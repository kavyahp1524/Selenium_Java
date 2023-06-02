package shree;

import java.awt.AWTException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class aleart {
	public class search {
		WebDriver driver;
		String url1="https://www.amazon.in";
		String url2 ="https://demoqa.com/alerts";
		String url3="https://mail.google.com";
		@BeforeTest
		public void tc0() throws InterruptedException {
			WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();//launching the browser
			    driver.get(url2);//initiating a url
			    driver.manage().window().maximize();//used to maximize the web. 
			    Thread.sleep(5000);
	}
		@Test
		public void tc1() throws InterruptedException {
			Actions act=new Actions(driver);
			act.sendKeys(Keys.PAGE_DOWN).build().perform();//downing webpage/scrolling
		    Thread.sleep(6000);
			
		    driver.findElement(By.id("alertButton")).click();
			Alert a=driver.switchTo().alert();
			String msg=a.getText();
			System.out.println(msg);
			a.accept();
		    Thread.sleep(5000);

		}
		@Test
		public void tc2() throws InterruptedException {
			WebElement k=driver.findElement(By.id("timerAlertButton"));
					k.click();
			Thread.sleep(10000);
			Alert a=driver.switchTo().alert();
			a.accept();
			Thread.sleep(25000);	
			}
		
		@Test(enabled = true)
		public void tc3() throws InterruptedException, AWTException {
			WebElement e=driver.findElement(By.xpath("//button[@id='confirmButton']"));
			e.click();
			Alert a=driver.switchTo().alert();			
			a.dismiss();
			 WebElement y=driver.findElement(By.id("confirmResult"));
			 System.out.println("promt result is:"+" "+y.getText());
				Thread.sleep(5000);	
	}

	@Test(enabled = true)
	public void tc4() throws InterruptedException {
	 driver.findElement(By.id("promtButton")).click();
	 Alert a=driver.switchTo().alert();
	 a.sendKeys("hp");
	 a.accept();
	 WebElement y=driver.findElement(By.xpath("//span[@id='promptResult']"));
	 System.out.println("promt result is:"+" "+y.getText());
		Thread.sleep(5000);
		}	
}
}
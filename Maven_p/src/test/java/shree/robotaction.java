package shree;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class robotaction {
	public class orangeHRMassesment {
		WebDriver driver;
		String url ="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";//

	@BeforeTest //launching and getting website
	public  void tc1() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();//launching the browser
		driver.get(url);//initiating a url
		driver.manage().window().maximize();//used to maximize the web.  
		Thread.sleep(5000);
	}
	@Test
	public void tc2() throws InterruptedException, AWTException {//sending keys to particular element
		WebElement web=driver.findElement(By.name("username"));
		Robot r=new Robot();
		Thread.sleep(5000);
		r.keyPress(KeyEvent.VK_SHIFT);
		r.keyPress(KeyEvent.VK_A);
		Thread.sleep(5000);
		r.keyRelease(KeyEvent.VK_SHIFT);
		r.keyPress(KeyEvent.VK_D);
		r.keyPress(KeyEvent.VK_M);
		r.keyPress(KeyEvent.VK_I);
		r.keyPress(KeyEvent.VK_N);
		
	}
	@Test
	public void tc3() throws InterruptedException, AWTException {
	WebElement web1=driver.findElement(By.name("password"));
	web1.click();
	Robot r=new Robot();
	Thread.sleep(5000);
	r.keyPress(KeyEvent.VK_A);
	r.keyPress(KeyEvent.VK_D);
	r.keyPress(KeyEvent.VK_M);
	r.keyPress(KeyEvent.VK_I);
	r.keyPress(KeyEvent.VK_N);
	r.keyPress(KeyEvent.VK_1);
	r.keyPress(KeyEvent.VK_2);	
	r.keyPress(KeyEvent.VK_3);
	Thread.sleep(5000);
	}
	
	@Test
	public void tc4() throws InterruptedException, AWTException {
	WebElement web =driver.findElement(By.className("oxd-button"));
	Robot r=new Robot();
	r.keyPress(KeyEvent.VK_ENTER);
	Thread.sleep(5000);
	}
	
}
}
package Shree;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class hp {

public static void main(String[] args) throws InterruptedException {

	System.setProperty("webdriver.chrome.driver","D:\\Moolyaed\\Selenium\\selenium-java-4.8.0\\Chromedriver\\chromedriver.exe");
	WebDriver driver= new ChromeDriver();
driver.manage().window().maximize();
String url ="https://rahulshettyacademy.com/locatorspractice";
driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
driver.get(url);

System.out.println(driver.getTitle());
System.out.println(driver.getCurrentUrl());

driver.findElement(By.id("inputUsername")).sendKeys("Kavyashree");
driver.findElement(By.name("inputPassword")).sendKeys("1234");
driver.findElement(By.name("chkboxOne")).click();
driver.findElement(By.name("chkboxTwo")).click();
driver.findElement(By.className("signInBtn")).click();
System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
Thread.sleep(3000);
driver.findElement(By.name("chkboxOne")).click();
driver.findElement(By.name("chkboxTwo")).click();
driver.findElement(By.linkText("Forgot your password?")).click();
driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Kavyashree");
driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("Kavyashree@gmail.com");
driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("7658432879");
driver.findElement(By.className("go-to-login-btn")).click();
Thread.sleep(5000);
driver.findElement(By.linkText("Forgot your password?")).click();
driver.findElement(By.xpath("//input[@placeholder='Name']")).clear();
driver.findElement(By.xpath("//input[@placeholder='Email']")).clear();
driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).clear();
Thread.sleep(5000);
driver.findElement(By.className("go-to-login-btn")).click();
Thread.sleep(5000);
driver.findElement(By.linkText("Forgot your password?")).click();
driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Kavyashree");
driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("Kavyashree@gmail.com");
driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("7658432879");
driver.findElement(By.className("reset-pwd-btn")).click();
System.out.println(driver.findElement(By.cssSelector("p.infoMsg")).getText());



	}

}

package Shree;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class orange {
public static void main(String[]args) throws InterruptedException {
System.setProperty("webdriver.chrome.driver","D:\\Moolyaed\\Selenium\\selenium-java-4.8.0\\Chromedriver\\chromedriver.exe");	
ChromeOptions options = new ChromeOptions();
options.setHeadless(true);
WebDriver driver = new ChromeDriver();
driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
driver.manage().window().maximize();//used to maximize the web. 
driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);//adding 5000sec timeunit to wait for loading particular web. 
System.out.println(driver.getTitle());//to get web name in console. 
System.out.println(driver.getCurrentUrl());//to get web url in console.
System.out.println(driver.findElement(By.cssSelector("div.orangehrm-login-slot")).getText());//the login page get in console.

driver.findElement(By.name("username")).sendKeys("Admin");//sending name to username box by  sendkeys.
driver.findElement(By.name("password")).sendKeys("admin123");//sending password to password box using sendkeys.
driver.findElement(By.className("oxd-button")).click();//clicking login button using click().

driver.findElement(By.className("oxd-userdropdown")).click();//clicking dropdown by entering classname as address & making action by using click(). 
driver.findElement(By.linkText("Logout")).click();// logout from orangehrm by enetering linkText as address & making action by using click(). 

driver.findElement(By.name("username")).sendKeys("kavya");//sending name to username box using sendkeys.
driver.findElement(By.name("password")).sendKeys("admin123");//sending password to password box using sendkeys.
driver.findElement(By.className("oxd-button")).click();//clicking login button using click().

System.out.println(driver.findElement(By.cssSelector("p.oxd-text")).getText());

driver.findElement(By.className("orangehrm-login-forgot")).click();
System.out.println(driver.findElement(By.cssSelector("div.orangehrm-forgot-password-container")).getText());
driver.findElement(By.cssSelector("input.oxd-input--active")).sendKeys("Admin");
driver.findElement(By.className("orangehrm-forgot-password-button--cancel")).click();
Thread.sleep(5000);
driver.findElement(By.className("orangehrm-login-forgot")).click();
driver.findElement(By.cssSelector("input.oxd-input--active")).sendKeys("Admin");
driver.findElement(By.className("orangehrm-forgot-password-button--reset")).click();
	}

}

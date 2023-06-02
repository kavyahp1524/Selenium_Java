package Shree;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class orangehrmusingjava {
	public static void main(String[]args) throws InterruptedException {
	
	System.setProperty("webdriver.chrome.driver","D:\\Moolyaed\\Selenium\\selenium-java-4.8.0\\Chromedriver\\chromedriver.exe");	
	WebDriver driver = new ChromeDriver();
	
	String url ="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	driver.get(url);
	driver.manage().window().maximize();//used to maximize the web. 
	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);//adding 5000sec timeunit to wait for loading particular web. 
	System.out.println(driver.getTitle());//to get web name in console. 
	System.out.println(driver.getCurrentUrl());//to get web url in console.
	
	System.out.println(driver.findElement(By.cssSelector("div.orangehrm-login-slot")).getText());//the login page get in console.

	//checking login button functionality if it is login to web or not
	driver.findElement(By.name("username")).sendKeys("Admin");//sending name to username box by  sendkeys.
	driver.findElement(By.name("password")).sendKeys("admin123");//sending password to password box using sendkeys.
	driver.findElement(By.className("oxd-button")).click();//clicking login button using click().
    
	//if it login to web then it will get title in console and test is passed.
	System.out.println(driver.getTitle());
	String exp_title="OrangeHRM";
	String act_title=driver.getTitle();{
		if(exp_title.equals(act_title)==true) {
			System.out.println("Title matched.Test is passed");
		}else {
			System.out.println("Title not matched.Test is failed");
		}
	}
	
	driver.findElement(By.className("oxd-userdropdown")).click();//clicking dropdown by entering classname as address & making action by using click(). 
	driver.findElement(By.linkText("Logout")).click();// logout from orangehrm by enetering linkText as address & making action by using click(). 
}
}
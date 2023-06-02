package shree;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assertion_sa {
	WebDriver driver;
	String url ="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";//

@BeforeTest 
public  void tc1() {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.manage().window().maximize(); 
	driver.get(url);
	
}
@Test 
public void tc2() throws InterruptedException {
	String exp_title=" OrangeHRM";                    
	String act_title=driver.getTitle(); 
	SoftAssert Assert =new SoftAssert();
	Assert.assertEquals(act_title, exp_title);        
	System.out.println(driver.getTitle());           	
	Thread.sleep(5000);
	//Assert.assertAll();
	
}

}

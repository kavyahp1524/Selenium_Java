package Shree;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class mouseactions {
	WebDriver driver;
	String url ="https://www.bput.ac.in";

@BeforeTest //launching and getting website
public  void tc1() {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();//launching the browser
	driver.get(url);//initiating a url
	driver.manage().window().maximize();//used to maximize the web. 

}
@Test
public void tc2() {
	WebElement web=driver.findElement(By.className("has_child"));
	System.out.println(web.getText());

}
}

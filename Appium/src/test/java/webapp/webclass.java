package webapp;

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Hybrid_app.Capability1;
import Web_app.Capability2;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class webclass extends Capability2{
	AndroidDriver<AndroidElement>driver;
	
	@BeforeTest
	public void bt() throws MalformedURLException {
		driver=capabilities();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	@Test(enabled=true)
	public void tc1() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.get("https://google.com");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys("appium",Keys.ENTER);
		Thread.sleep(4000);
		List<AndroidElement> vv=driver.findElements(By.tagName("a"));
		   System.out.println(vv.size());
		   for (int i=0;i<vv.size();i++) {
			   System.out.println(vv.get(i).getText());
		   }
		   for (int i=0;i<vv.size();i++) {
			   System.out.println(vv.get(i).getText());
			   System.out.println(vv.get(i).getAttribute("href"));
			   
		   }
	}

}

package framework;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Framework.Capability3;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Testcase extends Capability3{
	AndroidDriver<AndroidElement>driver;
	
	@BeforeTest
	public void bt() throws IOException, InterruptedException {
	System.out.println("hai");
	}
		
	@Test(enabled=true)
	public void tc1() throws InterruptedException, IOException{
		
		service =startserver();
		
		driver=capabilities(deviceName,platformName,appPackage,appActivity,chromeDriver);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(3000);
       
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
        Thread.sleep(3000);
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Brazil\"))").click();
		Thread.sleep(3000);
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Kavyashree");
		Thread.sleep(3000);
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();  
		Thread.sleep(3000);
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click(); 
		 Thread.sleep(3000);
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"ADD TO CART\")")).click();
		     Thread.sleep(3000);
		    driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
		    Thread.sleep(3000);
		    String s= driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Converse All Star\"))").getText();
		    System.out.println(s);
		    driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(1).click();
		    Thread.sleep(3000);
	    driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();  
 		Thread.sleep(5000);
 		driver.pressKey(new KeyEvent(AndroidKey.BACK));		
		Thread.sleep(3000);
	    driver.pressKey(new KeyEvent(AndroidKey.BACK));
	    Thread.sleep(3000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(3000);
		
	}
}

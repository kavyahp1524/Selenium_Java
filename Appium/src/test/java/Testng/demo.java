package Testng;

import java.awt.Dimension;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Native_app.Capability;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import io.appium.java_client.touch.LongPressOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import io.appium.java_client.touch.TapOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import io.appium.java_client.TouchAction;
import java.time.Duration;
import static java.time.Duration.ofSeconds;

public class demo extends Capability {
	AndroidDriver<AndroidElement>driver;
	
	@BeforeTest
	public void bt() throws MalformedURLException {
		driver=capabilities();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	//@Test(enabled=false)
	public void tc1() {
		driver.findElement(MobileBy.AccessibilityId("Preference")).click();
		driver.findElement(MobileBy.AccessibilityId("3. Preference dependencies")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		driver.findElement(By.xpath("//*[@text='WiFi settings']")).click();
		//driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"WiFi settings\")")).click();
		driver.findElement(MobileBy.id("android:id/edit")).sendKeys("kavya123");
		driver.findElement(MobileBy.id("android:id/button1")).click();
		driver.hideKeyboard();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	    driver.pressKey(new KeyEvent(AndroidKey.BACK));
	    driver.pressKey(new KeyEvent(AndroidKey.BACK));

	}
	//@Test(enabled=false)
	public void notification() throws InterruptedException{
		driver.openNotifications();
		driver.findElements(By.className("android.widget.ImageView")).get(1).click();
		driver.findElements(By.className("android.widget.ImageView")).get(2).click();
		driver.findElements(By.className("android.widget.ImageView")).get(3).click();
		driver.findElements(By.className("android.widget.ImageView")).get(4).click();
		driver.findElements(By.className("android.widget.ImageView")).get(5).click();
		driver.findElement(MobileBy.AccessibilityId("Open quick settings.")).click();
		
	}
	
	//@Test(enabled=false)
	public void scroll() throws InterruptedException {
		driver.findElement(MobileBy.AccessibilityId("Views")).click();
		 Thread.sleep(3000);
		 driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))").click();
		 Thread.sleep(5000);
		
	}
	//@Test(enabled=false)
	public void clickable() {
		driver.findElement(MobileBy.AccessibilityId("Views")).click();
		//to check elements are present and clickable
		AndroidElement click=driver.findElementByAndroidUIAutomator("new UiSelector().clickable(true)");
		org.openqa.selenium.Dimension c=click.getSize();
		System.out.println(c);
	}
	
	@Test(enabled=false)
	public void view() throws InterruptedException {
		 driver.findElement(MobileBy.AccessibilityId("Views")).click();
		 Thread.sleep(3000);
		 
		 AndroidElement ta= driver.findElement(MobileBy.AccessibilityId("Expandable Lists"));
		 Thread.sleep(3000);
		 
		 TouchAction tp= new TouchAction(driver);
		 tp.tap(tapOptions().withElement(element(ta))).perform();
		 
		 driver.findElement(MobileBy.AccessibilityId("1. Custom Adapter")).click();
		 Thread.sleep(3000);
		 
		 //long press
		 AndroidElement lp=driver.findElement(By.xpath("//*[@text='Fish Names']"));
		 tp.longPress(longPressOptions().withElement(element(lp)).withDuration(ofSeconds(3))).release().perform();
		 
		 //assigning string because printing a string 
         String pr=driver.findElements(MobileBy.className("android.widget.TextView")).get(0).getText();
         String pr1=driver.findElements(MobileBy.className("android.widget.TextView")).get(1).getText();
         System.out.println(pr);
         System.out.println(pr1);

		
	}
	@Test(enabled=false)
	public void longpress() throws InterruptedException {
		driver.findElement(MobileBy.AccessibilityId("Views")).click();
	    Thread.sleep(2000);
	    
	    driver.findElement(MobileBy.AccessibilityId("Date Widgets")).click();
	    
	    driver.findElement(MobileBy.AccessibilityId("2. Inline")).click();
	    Thread.sleep(2000);
	    
	    AndroidElement x= driver.findElement(MobileBy.AccessibilityId("12"));
	    Thread.sleep(2000);
	    
	    AndroidElement y= driver.findElement(MobileBy.AccessibilityId("6"));
	    
	    TouchAction q=new TouchAction(driver);
	    q.longPress(longPressOptions().withElement(element(x)).withDuration(ofSeconds(3))).moveTo(element(y)).release().perform();
	    
	    driver.findElement(MobileBy.id("android:id/pm_label")).click();
	    driver.pressKey(new KeyEvent(AndroidKey.BACK));
	    driver.pressKey(new KeyEvent(AndroidKey.BACK));
	    driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}
		
	@Test(enabled=false)
		public void draganddtrop() throws InterruptedException {
		driver.findElement(MobileBy.AccessibilityId("Views")).click();
		 Thread.sleep(3000);
		 driver.findElement(MobileBy.AccessibilityId("Drag and Drop")).click();
		Thread.sleep(3000);
		AndroidElement dd=driver.findElement(null);
 
		
	}
		@Test(enabled=true)
		public void sendkeys() throws InterruptedException {
		driver.findElement(MobileBy.AccessibilityId("OS")).click();
		 Thread.sleep(3000);
		driver.findElement(MobileBy.AccessibilityId("SMS Messaging")).click(); 
		 Thread.sleep(3000);
		driver.findElement(MobileBy.AccessibilityId("Enable SMS broadcast receiver")).click(); 
		Thread.sleep(3000);
		driver.findElement(By.id("io.appium.android.apis:id/sms_recipient")).sendKeys("650 555-6789"); 
		Thread.sleep(3000);
		driver.findElement(By.id("io.appium.android.apis:id/sms_content")).sendKeys("Hello"); 
		 Thread.sleep(3000);
		driver.hideKeyboard();
		driver.findElement(MobileBy.AccessibilityId("Send")).click(); 
		 Thread.sleep(9000);
		 driver.activateApp("com.google.android.apps.messaging");

		
		}	

}

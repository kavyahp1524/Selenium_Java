package Hybrid;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Hybrid_app.Capability1;
import Native_app.Capability;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;

public class general_store extends Capability1{
		AndroidDriver<AndroidElement>driver;
		
		@BeforeTest
		public void bt() throws MalformedURLException {
			driver=capabilities();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}
		@Test(enabled=false)
		public void tc1() throws InterruptedException{
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
     		 driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Converse All Star\"))");
     		String s1=driver.findElements(By.xpath("//*[@text='Converse All Star']")).get(2).getText();
     		//Thread.sleep(5000);
     		//
  		    Thread.sleep(3000);
  		    //System.out.println(s1);
     		//Thread.sleep(3000);

 		   //Assert.assertEquals(s,s1);
		}
		
		@Test(enabled=true)
		public void tc2() throws InterruptedException{
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
 		   driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();  
    		Thread.sleep(5000);
   		   
    		String Productprice1 = driver.findElement(By.xpath("//*[@text='$160.97']")).getText();
   		   Thread.sleep(2000);
   		   String Productprice2 = driver.findElement(By.xpath("//*[@text='$120.0']")).getText();
   		   Thread.sleep(2000);
   		  String Totalprice =  driver.findElement(By.xpath("//*[@text='$ 280.97']")).getText();
   		
   		  Thread.sleep(5000);
   		Productprice1=Productprice1.substring(1);
		Thread.sleep(2000);
		Productprice2=Productprice2.substring(1);
		Thread.sleep(2000);
		Totalprice=Totalprice.substring(1);
		Thread.sleep(2000);
		
		Double firstproduct= Double.parseDouble(Productprice1);
		Thread.sleep(2000);
		Double secondproduct=Double.parseDouble(Productprice2);
		Thread.sleep(2000);
		Double Totalprice1=Double.parseDouble(Totalprice);
		Thread.sleep(2000);
		Double total=firstproduct+secondproduct;
		Thread.sleep(2000);
		//Assert.assertEquals(Totalprice1, total);
		/*if(Totalprice1.equals(total)) {
			System.out.println("price matched");
		}
		else {
			System.out.println("price not matched");
		}*/
		 driver.findElement(By.xpath("//*[@text='Send me e-mails on discounts related to selected products in future']")).click();
		    Thread.sleep(3000);
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click(); 
		Thread.sleep(3000);
		
		Set<String> contextNames = driver.getContextHandles();
		for (String contextName : contextNames) {
		    System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
		}
		driver.context("WEBVIEW_com.androidsample.generalstore");	
		//driver.pressKey(new KeyEvent(AndroidKey.BACK));		
		//Thread.sleep(3000);
	    //driver.pressKey(new KeyEvent(AndroidKey.BACK));
	    //Thread.sleep(3000);
		//driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(3000);
		driver.activateApp("com.androidsample.generalstore");
		
		}
		

}





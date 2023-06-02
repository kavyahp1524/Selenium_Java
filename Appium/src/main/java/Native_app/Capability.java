package Native_app;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class Capability {
	
	public static AndroidDriver<AndroidElement> capabilities() throws MalformedURLException {
		DesiredCapabilities dc=new DesiredCapabilities();
		
		//general capability for mobile capability
		
		
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Kavya");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		
		//android -app package appa activity
		
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.appium.android.apis");
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "io.appium.android.apis.ApiDemos");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,AutomationName.ANDROID_UIAUTOMATOR2);
		
		//dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,AutomationName.APPIUM);//(both ios and android)
		//dc.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
		//dc.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE,"D://Moolyaed//Selenium//selenium-java-4.8.0//Chromedriver//chromedriver.exe");

		AndroidDriver<AndroidElement> driver=new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
		//if i want to call capabilities in other class i ll use return driver
		return driver;
			
	}

}

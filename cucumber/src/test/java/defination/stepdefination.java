package defination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class stepdefination {
	WebDriver driver;
	String url ="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";//
	
	@Given("I should be in the login page")
	public void i_should_be_in_the_login_page() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();//launching the browser
		driver.get(url);//initiating a url
		driver.manage().window().maximize();//used to maximize the web. 
		Thread.sleep(5000);
	}

	@When("Enter the username {string}")
	public void enter_the_username(String string) throws InterruptedException {
		WebElement web = driver.findElement(By.name("username"));
		if (web.isDisplayed() == true) {
			web.sendKeys(string);
		}
		Thread.sleep(5000);
	}
	@When("Enter the password {string}")
	public void enter_the_password(String string) throws InterruptedException {
		WebElement web1=driver.findElement(By.name("password"));
		if(web1.isDisplayed()==true) {
			web1.sendKeys(string);}
		Thread.sleep(5000);
	}
	@When("Click on the login button")
	public void click_on_the_login_button() throws InterruptedException {
		WebElement web2=driver.findElement(By.className("oxd-button"));
		if(web2.isDisplayed()==true) {
			web2.click();}
		Thread.sleep(5000);
 
	}
	@Then("I should see the Title as {string}")
	public void i_should_see_the_title_as(String string) throws InterruptedException {
		String exp_title=string; // assigning expected title
		String act_title=driver.getTitle(); //getting actual title
		Assert.assertEquals(act_title, exp_title); //comparing expected and actual title
		System.out.println(driver.getTitle());//getting actual title in console 
		Thread.sleep(5000);
	}
		@Then("Click on the dropdown")
		public void click_on_the_dropdown() throws InterruptedException {
			WebElement web3=driver.findElement(By.className("oxd-userdropdown"));
			if(web3.isDisplayed()==true) {
				web3.click();
				}
			Thread.sleep(5000);
		}
		@Then("Click on the logout button")
		public void click_on_the_logout_button() {
			WebElement web4=driver.findElement(By.linkText("Logout"));
			if(web4.isDisplayed()==true) {
				web4.click();
				}	
	}

}

package hotelLogin;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageBeans.PFLogin;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;




public class StepDefinitionsHotelLogin {
	private PFLogin pfLoginObj;
	private WebDriver driver;
	WebDriverWait wait;

	@Given("^User is on login page$")
	public void user_is_on_login_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\likhi\\Desktop\\chromedriver\\chromedriver.exe");
		driver=new ChromeDriver();
		String baseUrl="C:\\Users\\likhi\\Desktop\\hotelBooking question\\login.html";
		driver.get(baseUrl);

		   pfLoginObj = new PFLogin(driver);
		   
		   wait = new WebDriverWait(driver, 10);
	}

	@Then("^Validate the heading of the page$")
	public void validate_the_heading_of_the_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		String strheading = driver.findElement(By.xpath("/html/body/div/div[1]/h1")).getText();
		   Assert.assertEquals("Hotel Booking Application", strheading);
		    
	}

	@When("^User enters valid username, valid password and clicks login button$")
	public void user_enters_valid_username_valid_password_and_clicks_login_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		pfLoginObj.setPfuname("Neelima");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		pfLoginObj.setPfpwd("neel1234");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		pfLoginObj.setPfbtn();
	}

	@Then("^Hotel Booking page should be displayed$")
	public void hotel_Booking_page_should_be_displayed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		wait.until(ExpectedConditions.titleContains("Hotel Booking"));
		   
		   
	}

	@When("^User leaves \"([^\"]*)\" or \"([^\"]*)\" blank$")
	public void user_leaves_or_blank(String arg1, String arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		pfLoginObj.setPfuname(arg1);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		pfLoginObj.setPfpwd(arg2);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		pfLoginObj.setPfbtn();
	}

	@Then("^Error message should be displayed$")
	public void error_message_should_be_displayed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("errMessage")));
		   
		
	}

	@When("^User enters invalid input in \"([^\"]*)\" or \"([^\"]*)\"$")
	public void user_enters_invalid_input_in_or(String arg1, String arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		pfLoginObj.setPfuname(arg1);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		pfLoginObj.setPfpwd(arg2);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		pfLoginObj.setPfbtn();
	}

	@Then("^Alert message should be displayed$")
	public void alert_message_should_be_displayed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		wait.until(ExpectedConditions.alertIsPresent());
		   String alertText = driver.switchTo().alert().getText();
		   driver.switchTo().alert().accept();
		   Assert.assertEquals("Invalid login! Please try again!", alertText);
		   
		
	}
	@AfterClass
	public void terminateBrowser(){
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.quit();
	}




}
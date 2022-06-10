package hotelBooking;
import org.openqa.selenium.By;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import PageBeans.PFHotelBooking;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import java.util.regex.Pattern;


import org.junit.Assert;


public class StepDefinitionsHotelBooking {
	
	private PFHotelBooking pfhotelbookingObj;
	private WebDriver driver;
	 WebDriverWait wait;
	
	@Given("^User is on hotelbooking page$")
	public void user_is_on_hotelbooking_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new PendingException();
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\likhi\\Desktop\\chromedriver\\chromedriver.exe");
		driver=new ChromeDriver();	
		pfhotelbookingObj = new PFHotelBooking(driver);
		 wait= new WebDriverWait(driver,10);
		String baseUrl="C:\\Users\\likhi\\Desktop\\hotelBooking question\\hotelbooking.html";
		driver.get(baseUrl);
		Thread.sleep(1000);
	}

	@Then("^Validate page title$")
	public void validate_page_title() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		String strtitle = driver.getTitle();
		Assert.assertEquals("Hotel Booking", strtitle);
		driver.close();
	}

	@When("^User enter all valid data and clicks on ConfirmBooking button$")
	public void user_enter_all_valid_data_and_clicks_on_ConfirmBooking_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new PendingException();
		pfhotelbookingObj.setFn("likhitha");
		pfhotelbookingObj.setLn("mandava");
		pfhotelbookingObj.setEmail("likhithamandava1@gmail.com");
		pfhotelbookingObj.setPhone("8008703101");
		pfhotelbookingObj.setAddress("Bandra, Mumbai");
		pfhotelbookingObj.setCty("Pune");
		pfhotelbookingObj.setSt("Maharashtra");
		pfhotelbookingObj.setPerson("2");
		pfhotelbookingObj.setCardname("likhithamandava");
		pfhotelbookingObj.setDb("478963254125");
		pfhotelbookingObj.setCvv("1234");
		pfhotelbookingObj.setMonth("march");
		pfhotelbookingObj.setYr("2025");
		//pfhotelbookingObj.setBtn();
	}

	@When("^User clicks the ConfirmBooking button$")
	public void user_clicks_the_ConfirmBooking_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new PendingException();
		pfhotelbookingObj.setBtn();
	}

	@Then("^Booking Successful page is displayed$")
	public void booking_Successful_page_is_displayed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();/html/body/h1
		
		String msg = driver.findElement(By.xpath("/html/body/h1")).getText();
		Assert.assertEquals("Booking Completed!", msg);
		driver.close();
		
	}

	@When("^User leaves the firstName blank$")
	public void user_leaves_the_firstName_blank() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		pfhotelbookingObj.setLn("mandava");
		pfhotelbookingObj.setEmail("likhithamandava1@gmail.com");
		pfhotelbookingObj.setPhone("8008703101");
		pfhotelbookingObj.setAddress("Bandra, Mumbai");
		pfhotelbookingObj.setCty("Pune");
		pfhotelbookingObj.setSt("Maharashtra");
		pfhotelbookingObj.setPerson("2");
		pfhotelbookingObj.setCardname("likhithamandava");
		pfhotelbookingObj.setDb("478963254125");
		pfhotelbookingObj.setCvv("1234");
		pfhotelbookingObj.setMonth("march");
		pfhotelbookingObj.setYr("2025");
	}

	@Then("^Display suitable alert msg$")
	public void display_suitable_alert_msg() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new PendingException();
		Pattern mailP = Pattern.compile("[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}$");
		Pattern contactP = Pattern.compile("^[7-9]{1}[0-9]{9}$");

		String exRes="";
		wait.until(ExpectedConditions.alertIsPresent());
		String alert = driver.switchTo().alert().getText();
		Thread.sleep(1000);
		System.out.println(alert);
		driver.switchTo().alert().accept();
		
		
		if(pfhotelbookingObj.getFn().getAttribute("value").isEmpty()) { 
	    exRes="Please fill the First Name";
		System.out.println("Sop from if statement = Enter fn");
		Assert.assertEquals(exRes, alert);}
		
		
		else if(pfhotelbookingObj.getLn().getAttribute("value").isEmpty()) 
		{exRes="Please fill the Last Name";
		System.out.println("Sop from if statement = Enter last name");
		Assert.assertEquals(exRes, alert);}
		
		 
		else if(!(mailP.matcher(pfhotelbookingObj.getEmail().getAttribute("value")).matches()))
		{exRes = "Please enter valid Email Id.";
		System.out.println("Sop from if statement = Enter valid email id");
		Assert.assertEquals(exRes, alert);}
		
		
		else if(pfhotelbookingObj.getCty().getAttribute("value").equals("Select City"))
		{exRes="Please select city";
		System.out.println("SOP from if statement for city alert");
		Assert.assertEquals(exRes, alert);}
		
		
		else if(pfhotelbookingObj.getSt().getAttribute("value").equals("Select State"))
		{exRes="Please select state";
		System.out.println("SOP from if statement for state alert");
		Assert.assertEquals(exRes, alert);}
		
		
		else if(pfhotelbookingObj.getYr().getAttribute("value").isEmpty()) 
		{exRes="Please fill the expiration year";
		System.out.println("SOP from if statement for year alert");
		Assert.assertEquals(exRes, alert);}
		
		
		else if(!(contactP.matcher(pfhotelbookingObj.getPhone().getAttribute("value")).matches()))
		{exRes="Please enter valid Contact no." ;
		System.out.println("Sop from if statement = Enter valid contact number");
		Assert.assertEquals(exRes, alert);}
		
		driver.quit();
		
//		if(wait.until(ExpectedConditions.alertIsPresent())==null) {}
//		  else {
//			 // String alert=driver.switchTo().alert().getText();
//			  //Assert.assertEquals("Invalid login! Please try again!", alert);
//			  driver.switchTo().alert().accept();
//			  driver.close();
//		  }
	}

	@When("^User enters firstName and leaves the lastName blank$")
	public void user_enters_firstName_and_leaves_the_lastName_blank() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		
		pfhotelbookingObj.setFn("likhitha");
		pfhotelbookingObj.setLn("");
	}

	@When("^User enters all valid data$")
	public void user_enters_all_valid_data() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		pfhotelbookingObj.setFn("anush");
		pfhotelbookingObj.setLn("nayak");
		pfhotelbookingObj.setEmail("anush@gmail.com");
		pfhotelbookingObj.setPhone("9878765678");
		pfhotelbookingObj.setAddress("Bandra, Mumbai");
		pfhotelbookingObj.setCty("Pune");
		pfhotelbookingObj.setSt("Karnataka");
		pfhotelbookingObj.setPerson("2");
		pfhotelbookingObj.setCardname("anushnayak");
		pfhotelbookingObj.setDb("478963254125");
		pfhotelbookingObj.setCvv("1234");
		pfhotelbookingObj.setMonth("march");
		pfhotelbookingObj.setYr("2025");
	}

	@When("^User enters incorrect email id$")
	public void user_enters_incorrect_email_id() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		pfhotelbookingObj.getEmail().clear();
		pfhotelbookingObj.setEmail("anushgmail.com"); //incorrect mail
		
	}

	@When("^User enters incorrect format of mobile no$")
	public void user_enters_incorrect_format_of_mobile_no(DataTable arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
	    //throw new PendingException();
	
		
		List<String> objlist=arg1.asList(String.class);
		for(int i=0;i<objlist.size();i++) {
			pfhotelbookingObj.getPhone().clear();
			pfhotelbookingObj.setPhone(objlist.get(i));	
		}
	}

	@When("^User does not select city$")
	public void user_does_not_select_city() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		pfhotelbookingObj.setCty("Select City");
		
		
	}

	@When("^User does not select state$")
	public void user_does_not_select_state() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		pfhotelbookingObj.setSt("Select State");
		
	}

	@When("^User selects count of persons (\\d+)$")
	public void user_selects_count_of_persons(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		String i=Integer.toString(arg1);
		pfhotelbookingObj.setPerson(i);
	
	}

	@Then("^allocate suitable number of rooms as per number of persons (\\d+)$")
	public void allocate_suitable_number_of_rooms_as_per_number_of_persons(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		int htmlres = Integer.parseInt(pfhotelbookingObj.getRm());
		int noPersons=arg1;
		if(noPersons<=3) {
			System.out.println("expected = 1 got "+htmlres);
			Assert.assertEquals(1,htmlres);}
		else if(noPersons<=6) {
			System.out.println("expected = 2 got "+htmlres);
			Assert.assertEquals(2,htmlres);}
		else {
			System.out.println("expected = 3 got "+htmlres);
			Assert.assertEquals(3,htmlres);}
		driver.close();
		
	}

	@When("^User enters valid data for previous fields and leaves the year blank$")
	public void user_enters_valid_data_for_previous_fields_and_leaves_the_year_blank() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		pfhotelbookingObj.setFn("anush");
		pfhotelbookingObj.setLn("nayak");
		pfhotelbookingObj.setEmail("anush@gmail.com");
		pfhotelbookingObj.setPhone("9878765678");
		pfhotelbookingObj.setAddress("Bandra, Mumbai");
		pfhotelbookingObj.setCty("Pune");
		pfhotelbookingObj.setSt("Karnataka");
		pfhotelbookingObj.setPerson("2");
		pfhotelbookingObj.setCardname("anushnayak");
		pfhotelbookingObj.setDb("478963254125");
		pfhotelbookingObj.setCvv("1234");
		pfhotelbookingObj.setMonth("march");
		//pfhotelbookingObj.setYr("2025");
	}
}
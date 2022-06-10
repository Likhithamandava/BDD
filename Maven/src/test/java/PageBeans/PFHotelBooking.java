package PageBeans;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PFHotelBooking {
	WebDriver driver;
	
	public PFHotelBooking(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="txtFirstName")
	@CacheLookup
	WebElement fn;
	
	@FindBy(id="txtLastName")
	@CacheLookup
	WebElement ln;
	
	@FindBy(id="txtEmail")
	@CacheLookup
	WebElement email;
	
	@FindBy(id="txtPhone")
	@CacheLookup
	WebElement phone;
	
	@FindBy(tagName ="textarea")
	@CacheLookup
	WebElement address;
	
	@FindBy(name  ="city")
	@CacheLookup
	WebElement cty;
	
	
	@FindBy(id  ="txtCvv")
	@CacheLookup
	WebElement cvv;
	
	@FindBy(id  ="rooms")
	@CacheLookup
	WebElement rm;
	
	@FindBy(id  ="txtCardholderName")
	@CacheLookup
	WebElement cardname;
	
	@FindBy(id  ="txtDebit")
	@CacheLookup
	WebElement db;
	
	
	@FindBy(how=How.NAME , using="state")
	@CacheLookup
	WebElement st;
	
	
	
	@FindBy(id  ="txtYear")
	@CacheLookup
	WebElement yr;
	
	@FindBy(id  ="txtMonth")
	@CacheLookup
	WebElement month;
	
	@FindBy(id  ="btnPayment")
	@CacheLookup
	WebElement btn;
	
	@FindBy(name  ="persons")
	@CacheLookup
	WebElement person;

//	public WebDriver getDriver() {
//		return driver;
//	}
//
//	public void setDriver(WebDriver driver) {
//		this.driver = driver;
//	}

	public WebElement getFn() {
		return fn;
	}

	public void setFn(String fname) {
		fn.sendKeys(fname);
	}

	public WebElement getLn() {
		return ln;
	}

	public void setLn(String lname) {
		ln.sendKeys(lname);
	}

	public WebElement getEmail() {
		return email;
	}

	public void setEmail(String mail) {
		email.sendKeys(mail);
	}

	public WebElement getPhone() {
		return phone;
	}

	public void setPhone(String ph) {
		phone.sendKeys(ph);
	}

	public WebElement getAddress() {
		return address;
	}

	public String getRm() {
		return rm.getText();
	}

//	public void setRm(WebElement rm) {
//		this.rm = rm;
//	}

	public void setAddress(String add) {
		address.sendKeys(add);
	}

	public WebElement getCty() {
		return cty;
	}

	public void setCty(String city) {
		Select drpcity= new Select(cty);
		drpcity.selectByVisibleText(city);
	}

	public WebElement getCvv() {
		return cvv;
	}

	public void setCvv(String c) {
		cvv.sendKeys(c);
	}

	public WebElement getCardname() {
		return cardname;
	}

	public void setCardname(String cardn) {
		cardname.sendKeys(cardn);
	}

	public WebElement getDb() {
		return db;
	}

	public void setDb(String dbn) {
		db.sendKeys(dbn);
	}

	public WebElement getSt() {
		return st;
	}

	public void setSt(String sta) {
		Select drpstate= new Select(st);
		drpstate.selectByVisibleText(sta);
	}

	public WebElement getYr() {
		return yr;
	}

	public void setYr(String year) {
		yr.sendKeys(year);
	}

	public WebElement getMonth() {
		return month;
	}

	public void setMonth(String m) {
		month.sendKeys(m);
	}

//	public WebElement getBtn() {
//		return btn;
//	}

	public void setBtn() {
		btn.click();
	}

	public WebElement getPerson() {
		return person;
	}

	public void setPerson(String p) {
		Select drppersons= new Select(person);
		drppersons.selectByVisibleText(p);
	}
	
}
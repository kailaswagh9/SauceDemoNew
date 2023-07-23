package com.saucedemo.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class KwPracticeFormpage {
	WebDriver driver;
	public KwPracticeFormpage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	//locators
	@FindBy(xpath="//input[@id='fname']")
	private WebElement fname;
	@FindBy(xpath="//input[@id='lname']")
	private WebElement lname;
	@FindBy(xpath="//input[@id='email']")
	private WebElement email;
	@FindBy(xpath="//input[@id='female']")
	private WebElement female;
	@FindBy(xpath="//input[@id='mobile']")
	private WebElement mobile;
	@FindBy(xpath="//input[@id='dob']")
	private WebElement dob;
	@FindBy(xpath="//input[@id='subjects']")
	private WebElement subjects;
	@FindBy(xpath="//input[@id='sports']")
	private WebElement sports;
	@FindBy(xpath="//textarea[@id='address']")
	private WebElement address;
	@FindBy(xpath="//select[@id='countrySelect']")
	private WebElement countrySelect;
	@FindBy(xpath="//select[@id='citySelect']")
	private WebElement citySelect;
	@FindBy(xpath="//button[@id='submitbtn']")
	private WebElement submitBtn;
	//locators actions
	public void enterFname(String firstname) {
		fname.sendKeys(firstname);
	}
	public void enterlastName(String lastname) {
		lname.sendKeys(lastname);
	}
	public void enterEmail(String emailId) {
		email.sendKeys(emailId);
	}
	public void clickFemaleGender() {
		female.click();
	}
	public void enterMobile(String mobileNum) {
		mobile.sendKeys(mobileNum);
	}
	public void enterDob(String DobValue) {
		dob.sendKeys(DobValue);
	}
	public void enterSubject(String subjectValue) {
		subjects.sendKeys(subjectValue);
	}
	public void clickOnSports() {
		sports.click();
	}
	public void enterAddress(String addressValue) {
		address.sendKeys(addressValue);
	}
	public void selectStateByVisibleText(String stateValue) {
		Select state = new Select(countrySelect);
		state.selectByVisibleText(stateValue);
	}
	public void selectCityByVisibleText(String cityValue) {
		Select city = new Select(citySelect);
		city.selectByVisibleText(cityValue);
	}
	
}

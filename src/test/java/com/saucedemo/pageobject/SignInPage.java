package com.saucedemo.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SignInPage {

	WebDriver ldriver;
	public SignInPage(WebDriver rdriver){
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	//identify web elements
	@FindBy(name= "user-name")
	private WebElement username;
	//identifying action
	public void enterUsername(String usern) {
		username.sendKeys(usern);
	}
	
	@FindBy(name="password")
	private WebElement password;
	//identifying password field action
	public void enterPassword(String pass) {
		password.sendKeys(pass);
	}
	
	@FindBy(name="login-button")
	private WebElement loginButton;
	//identifying password field action
	public void clickOnLoginButton() {
		loginButton.click();
	}
	@FindBy(xpath="//div[normalize-space()='Sauce Labs Backpack']")
	private WebElement labBackpack;
	public String verifyLogin() {
		return labBackpack.getText();
	}
}

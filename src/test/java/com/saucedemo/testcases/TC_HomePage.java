package com.saucedemo.testcases;

import org.testng.annotations.Test;

import com.saucedemo.pageobject.Homepage;
import com.saucedemo.pageobject.SignInPage;

public class TC_HomePage extends BaseClass{

	
	@Test
	public void homepageTest() {
		driver.get(url);
		logger.info("url opened");
		SignInPage sip = new SignInPage(driver);
		sip.enterUsername("standard_user");
		logger.info("entered username");
		sip.enterPassword("secret_sauce");
		logger.info("entered password");
		sip.clickOnLoginButton();
		logger.info("clicked on loggin button");
		Homepage hpTest = new Homepage(driver);
		hpTest.addLabBackpack();
		logger.info("added Lab packpack");
		hpTest.clickShoppingCart();
		logger.info("clicked on cart button");
	
	}
}

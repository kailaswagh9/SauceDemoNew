package com.saucedemo.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {

	WebDriver ldriver;
	public Homepage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(name="add-to-cart-sauce-labs-backpack")
	WebElement acLabBackpack;
	public void addLabBackpack() {
		acLabBackpack.click();
	}
	@FindBy(xpath="//span[@class='shopping_cart_badge']")
	WebElement shoppingCart;
	public void clickShoppingCart() {
		shoppingCart.click();
	}
	
}

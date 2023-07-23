package com.saucedemo.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.model.Media;
import com.saucedemo.pageobject.Homepage;
import com.saucedemo.pageobject.SignInPage;
import com.saucedemo.utilities.ExtentManager;
import com.saucedemo.utilities.ReadExcelData;

public class TC_SingInPage extends BaseClass {

	@Test(dataProvider = "ExcelData",dataProviderClass = ReadExcelData.class)
	public void verifyLogin(String uname,String pass,String verifyLogint) throws IOException {
		driver.get(url);
		logger.info("url opened");
		SignInPage sip = new SignInPage(driver);
		sip.enterUsername(uname);
		logger.info("entered username");
		sip.enterPassword(pass);
		logger.info("entered password");
//		ExtentManager.test.log(Status.INFO, (Markup) ExtentManager.test.addScreenCaptureFromPath(captureScreenShot(driver, "realTimecapture")));
//		ExtentManager.test.log(Status.INFO, "Entered username: "+ uname + " and password: " + pass, MediaEntityBuilder.createScreenCaptureFromPath(captureScreenShot(driver, "realTimecapture")).build());
		sip.clickOnLoginButton();
		logger.info("clicked on loggin button");

		if (sip.verifyLogin().equals(verifyLogint)) {
			Assert.assertTrue(true);
//			ExtentManager.test.log(Status.PASS, "Verify Login Sucessfull.");
			logger.info("Login successfully verifed");
		} else {
//			ExtentManager.test.log(Status.FAIL, "Verify Login failed.");
			Assert.fail();
		}

	}

}

package com.saucedemo.testcases;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.util.Assert;
import com.saucedemo.pageobject.KwPracticeFormpage;
import com.saucedemo.utilities.ExtentManager;
import com.saucedemo.utilities.ReadExcelData;

public class TC_KwPracticeFormpage extends BaseClass{

	
	@Test(dataProvider = "ExcelData", dataProviderClass = ReadExcelData.class)
	public void fillPracticeForm(Method m,String fname,String lname,String email,String Mob,String dob, String subject,String currAdd,String verifyTest) throws IOException {
		KwPracticeFormpage kwpF = new KwPracticeFormpage(driver);
		
		driver.get(kwurl);
		kwpF.enterFname(fname);
		logger.info("Entered first name");
		kwpF.enterlastName(lname);
		logger.info("Entered last name ");
		kwpF.enterEmail(email);
		logger.info("Entered email address");
		kwpF.clickFemaleGender();
		logger.info("Clicked on geneder");
		kwpF.enterMobile(Mob);
		logger.info("Entered mobile number");
		kwpF.enterDob(dob);
		logger.info("Entered DOB");
		kwpF.enterSubject(subject);
		logger.info("Entered subject");
		kwpF.clickOnSports();
		logger.info("Clicked on Sport");
		kwpF.enterAddress(currAdd);
		logger.info("Entered Address");
		kwpF.selectStateByVisibleText("Rajasthan");
		logger.info("Selected state");
		kwpF.selectCityByVisibleText("Udaipur");
		logger.info("Selected city");
		
		if(driver.getTitle().equals(verifyTest)) {
			logger.info("title matched");
			ExtentManager.test.log(Status.PASS, "Title has matched");
			ExtentManager.test.createNode("Validation1");
			ExtentManager.test.createNode("Validation2");
			ExtentManager.test.createNode("Validation3");
			ExtentManager.test.createNode("Validation4");
			org.testng.Assert.assertTrue(true);
		}else {
			logger.info("title not matched");
			ExtentManager.test.log(Status.FAIL, "Title not matched");
			captureScreenShot(driver, m.getName());
			org.testng.Assert.assertTrue(false);
		}
	}
	
}

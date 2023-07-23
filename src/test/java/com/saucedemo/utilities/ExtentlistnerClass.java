package com.saucedemo.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.saucedemo.testcases.BaseClass;

public class ExtentlistnerClass extends ExtentManager implements ITestListener {

	// OnStart method is called when any Test starts.
	public void onStart(ITestContext Result) {
		System.out.println("On Start method invoked....");
	}

	// onFinish method is called after all Tests are executed
	public void onFinish(ITestContext Result) {
		System.out.println("On Finished method invoked....");
	}

	// When Test case get failed, this method is called.

	public void onTestFailure(ITestResult Result) {
		System.out.println("Name of test method failed:" + Result.getName());
		test.log(Status.FAIL,
				MarkupHelper.createLabel("Name of the failed test case is: " + Result.getName(), ExtentColor.RED));

		String screenShotPath = null;
		try {
			screenShotPath = BaseClass.captureScreenShot(BaseClass.driver, Result.getName());
		} catch (IOException e) {
			e.printStackTrace();
		}

		File screenShotFile = new File(screenShotPath);
		if (screenShotFile.exists()) {
			test.addScreenCaptureFromPath(screenShotPath);
		}
	}

	// When Test case get Skipped, this method is called.

	public void onTestSkipped(ITestResult Result) {
		System.out.println("Name of test method skipped:" + Result.getName());

		test.log(Status.SKIP,
				MarkupHelper.createLabel("Name of the skip test case is: " + Result.getName(), ExtentColor.YELLOW));
	}

	// When Test case get Started, this method is called.

	public void onTestStart(ITestResult Result) {
		test = reports.createTest(Result.getName());
		System.out.println("Name of test method started:" + Result.getName());

	}

	// When Test case get passed, this method is called.

	public void onTestSuccess(ITestResult Result) {
		System.out.println("Name of test method sucessfully executed:" + Result.getName());

		test.log(Status.PASS,
				MarkupHelper.createLabel("Name of the passed test case is: " + Result.getName(), ExtentColor.GREEN));
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult Result) {

	}
}

package practice;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ITestListnerandExtentReport implements ITestListener{
	
	 ExtentSparkReporter htmlReporter;
	 ExtentReports reports;
	 ExtentTest test;

	 
	 public void configureReport() {
		 String timeStamp = new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());
		 String reportName = "SauceDemoReport-"+timeStamp+".html";
		 htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"//Reports//"+reportName);
		 reports = new ExtentReports();
		 reports.attachReporter(htmlReporter);
		 reports.setSystemInfo("machine: ", "KailasPC");
		 reports.setSystemInfo("os: ", "windows 10");
		 reports.setSystemInfo("username: ", "Kailas Wagh");
		 reports.setSystemInfo("browser: ", "chrome");
		 htmlReporter.config().setDocumentTitle("Sauce Demo Report");
		 htmlReporter.config().setReportName("This is my first report");
		 htmlReporter.config().setTheme(Theme.STANDARD);
		 			 
	 }
	
	  /**
	   * Invoked before running all the test methods belonging to the classes inside the &lt;test&gt;
	   */
	  public void onStart(ITestContext context) {
		  configureReport();
		  System.out.println("On start method invoked...");
	  }
	  
	  /**
	   * Invoked after all the test methods belonging to the classes inside the &lt;test&gt; tag have
	   * run and all their Configuration methods have been called.
	   */
	  public void onFinish(ITestContext context) {
		  System.out.println("On finished method invoked...");
		  reports.flush();
	  }
	  /**
	   * Invoked each time before a test will be invoked.
	   */
	  public void onTestStart(ITestResult result) {
		System.out.println("Name of the test method started --> " + result.getName());
	  }

	  /**
	   * Invoked each time a test succeeds.
	   */
	  public void onTestSuccess(ITestResult result) {
		  System.out.println("Name of the test method sucessfully executed --> "+ result.getName());
		  test = reports.createTest(result.getName());
		  test.log(Status.PASS, MarkupHelper.createLabel("Name of the passed test case is --> " +result.getName(),ExtentColor.GREEN ));
	  }

	  /**
	   * Invoked each time a test fails.
	   */
	  public void onTestFailure(ITestResult result) {
		  String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
		  System.out.println("Name of the test method failed --> " + result.getName());
		  test= reports.createTest(result.getName());
		  test.log(Status.FAIL, MarkupHelper.createLabel("Name of the failed test case is --> " + result.getName() , ExtentColor.RED));
		  
		  String screenshotPath = System.getProperty("user.dir")+"\\snaps\\" + result.getName() + ".png";
		  File screenshotFile = new File(screenshotPath);
		  if(screenshotFile.exists()) {
			  test.fail("captured screenshot is below : " + test.addScreenCaptureFromPath(screenshotPath));
		  }else {
			  System.out.println("sreenshotFile not present");
		  }
	  }

	  /**
	   * Invoked each time a test is skipped.
	   */
	  public void onTestSkipped(ITestResult result) {
		  System.out.println("Name of the test method skipped --> " + result.getName());
		  test = reports.createTest(result.getName());
		  test.log(Status.SKIP, MarkupHelper.createLabel("Name of the skipped test cas is --> " + result.getMethod(),ExtentColor.YELLOW));
		 
	  }

	  /**
	   * Invoked each time a method fails but has been annotated with successPercentage and this failure
	   * still keeps it within the success percentage requested.
	   *
	   */
	  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	   
	  }
	  

	  
	}



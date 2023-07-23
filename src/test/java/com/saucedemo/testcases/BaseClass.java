package com.saucedemo.testcases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.saucedemo.utilities.ExtentManager;
import com.saucedemo.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	ReadConfig readConfig = new ReadConfig();
	String url = readConfig.getBaseUrl();
	String kwurl = readConfig.getKWUrl();
	String browser = readConfig.getBrowser();

	public static WebDriver driver;
	public static Logger logger;
	
	@BeforeSuite
	public void beforeSuite() throws IOException {
		ExtentManager.configureReport();
	}
	@AfterSuite
	public void afterSuite() {
		ExtentManager.endRepot();
	}
	
	@BeforeMethod
	public void setUp() {
		
		switch (browser.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
//			ChromeOptions op = new ChromeOptions();
//			op.addArguments("--remote-allow-origings=*");
			driver = new ChromeDriver();
			break;

		case "msedge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			driver = null;
			break;
		}
		//implicityWait for10sec
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		//for logging
		logger = LogManager.getLogger("Saucedemo");
		
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	
	
		public static String captureScreenShot(WebDriver driver,String testName) throws IOException
		{
				
			String timeStamp = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());
			
			//step1: convert webdriver object to TakesScreenshot interface
			TakesScreenshot screenshot = ((TakesScreenshot)driver);
			
			//step2: call getScreenshotAs method to create image file
			
			File src = screenshot.getScreenshotAs(OutputType.FILE);
			
			File dest = new File("./ScreenShots/" + testName +timeStamp+ ".png");
		
			//step3: copy image file to destination
			FileUtils.copyFile(src, dest);
			
			String errfl =dest.getAbsolutePath();
			return errfl;
		}
		
		public static void main(String[] args) throws IOException {
//			WebDriverManager.chromedriver().setup();
			ChromeOptions op = new ChromeOptions();
			op.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(op);
			driver.get("https://www.google.com");
			System.out.println(captureScreenShot(driver, "KGoogle"));
		}
}

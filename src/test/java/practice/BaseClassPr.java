package practice;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import com.github.dockerjava.transport.DockerHttpClient.Request.Method;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassPr {
	WebDriver driver;
	@BeforeTest
	public void beforeEachtest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
	}
	
	@AfterTest
	public void afterEachtest() {
		driver.close();
		driver.quit();
	}
	
	public void captureScreenshot(WebDriver driver, String testname) throws IOException {
//		String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot)driver;
		File sf =ts.getScreenshotAs(OutputType.FILE);
		File df= new File(System.getProperty("user.dir")+ "//snaps//"+ testname+ ".png");
		FileUtils.copyFile(sf, df);
	}
	
	
}

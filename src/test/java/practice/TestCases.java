package practice;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.github.dockerjava.transport.DockerHttpClient.Request.Method;

import junit.framework.Assert;

public class TestCases extends BaseClassPr{
	@Test
	public void TC1() {
		System.out.println("This i my passed test case1");
		Assert.assertTrue(true);
	}
	@Test
	public void TC2() {
		System.out.println("This i my passed test case2");
		Assert.assertTrue(true);
	}
	@Test
	public void TC3() throws IOException {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println("This i my failed test case1");
		WebElement uname = driver.findElement(By.xpath("//input[@placeholder='Username']"));
		uname.sendKeys("Admin");
		System.out.println(driver.getTitle());
		captureScreenshot(driver,"TC3");
		Assert.assertTrue(false);
	}
	@Test
	public void TC4() throws IOException {
		driver.get("https://www.google.com");
		System.out.println("This i my failed test case2");
		System.out.println(driver.getTitle());
		captureScreenshot(driver,"TC4");
		Assert.assertTrue(false);
	}
	@Test
	public void TC5() {
		System.out.println("This i my skipped test case1");
		throw new SkipException("Skipped exception1 thrown..");
	}
	@Test
	public void TC6() {
		System.out.println("This i my skipped test case2");
		throw new SkipException("Skiped exception2 thrown..");
	}

}

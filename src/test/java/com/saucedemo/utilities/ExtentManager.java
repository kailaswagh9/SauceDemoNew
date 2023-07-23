package com.saucedemo.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentManager {

	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports reports;
	public static ExtentTest test;
	
	public static void configureReport() throws IOException{
		ReadConfig readConfig = new ReadConfig();
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());
		String reportName = "SauceDemoTestReport-"+timeStamp+".html";
		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/Reports/"+reportName);
//		htmlReporter.loadXMLConfig(new File(System.getProperty("user.dir")+"/extent-config.xml"));
		htmlReporter.loadJSONConfig(new File(System.getProperty("user.dir")+"/spark-config.json"));
//		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/spark-config.xml");
//		htmlReporter.config().setJs("document.getElementsByClassName('logo')[0].style.display='none';");
//		htmlReporter.config().setCss(".badge-primary{background-color:red}");
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);
		//add system information/environment info to reports
		reports.setSystemInfo("OS name: ", System.getProperty("os.name"));
		reports.setSystemInfo("OS Version: ", System.getProperty("os.version"));
		reports.setSystemInfo("OS Architecture: ", System.getProperty("os.arch"));
		reports.setSystemInfo("Browser: ", readConfig.getBrowser());
		reports.setSystemInfo("User Name: ", System.getProperty("user.name"));
		//configuration to change look and feel of report
//		htmlReporter.config().setDocumentTitle("Extent Listner Report Demo");
//		htmlReporter.config().setReportName("This is my first report");
//		htmlReporter.config().setTheme(Theme.DARK);
	}
	public static void endRepot() {
		reports.flush();
	}
}

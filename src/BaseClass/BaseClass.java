package BaseClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import configuration.config_File;
import Library.ApplicationLibrary;
import Library.Utility;


public class BaseClass 


{
	public static WebDriver dr;
	public static ExtentReports report;
	public static ExtentTest logger;
	public static Library.ApplicationLibrary lib;
	public  String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
	Library.Utility ul= new Library.Utility();
	public static Properties p;
	
	@Parameters({"Browser"})
	@BeforeSuite
	public void initialize(String browser) throws IOException
	{
		report= new ExtentReports(config_File.reportPath+"AutomationReport_"+browser+"_"+timeStamp+".html");
		logger=report.startTest("Browser Launch");
		lib= new Library.ApplicationLibrary();
		//FileInputStream file= new FileInputStream(System.getProperty("user.dir")+"\\src\\objectRepository\\OR.properties");
		p= new Properties();		
		FileInputStream file= new FileInputStream("C:\\Users\\ejaybag\\Desktop\\Framework\\src\\objectRepository\\OR.properties");
		
		p.load(file);
		
		if(browser.equalsIgnoreCase("Chrome"))
		{
			ChromeOptions op= new ChromeOptions();
			op.addArguments("disable-infobars");
			this.dr= new ChromeDriver(op);
			dr.manage().window().maximize();
			logger.log(LogStatus.INFO, "Browser Launched");
			
			
			
		}else if(browser.equalsIgnoreCase("firefox"))
		{
			dr= new FirefoxDriver();
			logger.log(LogStatus.INFO, "Browser Launched");
		}else if(browser.equalsIgnoreCase("IE"))
		{
			dr= new InternetExplorerDriver();
			logger.log(LogStatus.INFO, "Browser Launched");
		}
		
		dr.get(config_File.url);
		String img=logger.addScreenCapture(lib.captureScreenShot(dr, ul.timeStamp()));
		logger.log(LogStatus.PASS, "Navigated to "+dr.getTitle(),img);
		
		if(dr.findElements(By.xpath(p.getProperty("popup"))).size()>0)
		{
			logger.log(LogStatus.INFO, "Pop up displayed", img);
			dr.findElement(By.xpath(p.getProperty("popup"))).click();
			img=logger.addScreenCapture(lib.captureScreenShot(dr, ul.timeStamp()));
			logger.log(LogStatus.INFO, "Pop up is closed", img);
		}
		report.endTest(logger);
	
		
		
		
		
	}
	
	
	
	@AfterSuite
	public void tearDown()
	{
		report.flush();
		dr.quit();
	}

}

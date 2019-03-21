package TestScripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import BaseClass.BaseClass;
import Library.Utility;


public class Tc_Registraction extends BaseClass
{

Library.Utility ul= new Library.Utility();
	
	@Test
	public void registration() throws IOException
	{
		logger=report.startTest("To test registration feature");
		
		//Click on Login button
		if(dr.findElements(By.xpath(p.getProperty("login"))).size()>0)
		{
			String img=logger.addScreenCapture(lib.captureScreenShot(dr, ul.timeStamp()));
			logger.log(LogStatus.INFO, "Login Button displayed", img);
			dr.findElement(By.xpath(p.getProperty("login"))).click();
			
			img=logger.addScreenCapture(lib.captureScreenShot(dr, ul.timeStamp()));
			logger.log(LogStatus.INFO, "Login Button displayed", img);
			
		}else
		{
			String img=logger.addScreenCapture(lib.captureScreenShot(dr, ul.timeStamp()));
			logger.log(LogStatus.FAIL, "Login Button is not displayed", img);
			
		}
		
		
		//Enter mobile number
		if(dr.findElements(By.xpath(p.getProperty("mobile"))).size()>0)
		{
			String img=logger.addScreenCapture(lib.captureScreenShot(dr, ul.timeStamp()));
			logger.log(LogStatus.INFO, "Mobile text box is displayed", img);
			dr.findElement(By.xpath(p.getProperty("mobile"))).sendKeys("7575757774");;
			
			img=logger.addScreenCapture(lib.captureScreenShot(dr, ul.timeStamp()));
			logger.log(LogStatus.INFO, "Mobile number entered successfully", img);
			
		}else
		{
			String img=logger.addScreenCapture(lib.captureScreenShot(dr, ul.timeStamp()));
			logger.log(LogStatus.FAIL, "Mobile text box is not displayed", img);
			
		}
		
		
		//Click on continue
		if(dr.findElements(By.xpath(p.getProperty("continue"))).size()>0)
		{
			String img=logger.addScreenCapture(lib.captureScreenShot(dr, ul.timeStamp()));
			logger.log(LogStatus.INFO, "Contnue button is displayed displayed", img);
			dr.findElement(By.xpath(p.getProperty("continue"))).click();
			
			img=logger.addScreenCapture(lib.captureScreenShot(dr, ul.timeStamp()));
			logger.log(LogStatus.INFO, "Successfully clicked on continue button", img);
			
		}else
		{
			String img=logger.addScreenCapture(lib.captureScreenShot(dr, ul.timeStamp()));
			logger.log(LogStatus.FAIL, "Continue button is not displayed", img);
			
		}
		
		
		//Verify OTP field is displayed
		if(dr.findElements(By.xpath(p.getProperty("otp"))).size()>0)
		{
			String img=logger.addScreenCapture(lib.captureScreenShot(dr, ul.timeStamp()));
			logger.log(LogStatus.INFO, "OTP field is displayed displayed", img);
			
		}else
		{
			String img=logger.addScreenCapture(lib.captureScreenShot(dr, ul.timeStamp()));
			logger.log(LogStatus.FAIL, "OTP field is not displayed", img);
			
		}
		
		report.endTest(logger);
		
		
	}
	
}

package TestScripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import BaseClass.BaseClass;
import Library.Utility;


public class TC_Staticlinks extends BaseClass
{

Library.Utility ul= new Library.Utility();
	
	@Test
	public void staticlinks() throws IOException
	{
		logger=report.startTest("To test static feature");
		
		//Click on Login button
		if(dr.findElements(By.xpath(p.getProperty("returnpolicy"))).size()>0)
		{
			String img=logger.addScreenCapture(lib.captureScreenShot(dr, ul.timeStamp()));
			logger.log(LogStatus.INFO, "static link is displayed", img);
			dr.findElement(By.xpath(p.getProperty("returnpolicy"))).click();
			
			img=logger.addScreenCapture(lib.captureScreenShot(dr, ul.timeStamp()));
			logger.log(LogStatus.INFO, "static link is displayed", img);
			
		}else
		{
			String img=logger.addScreenCapture(lib.captureScreenShot(dr, ul.timeStamp()));
			logger.log(LogStatus.FAIL, "static link  is not displayed", img);
			
		}
		
		
	}
}
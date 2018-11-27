package VTS_Admin_IT_Testing;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
public class Extent_Report {

	public static ExtentReports extent;
	public static ExtentTest logger;	
	WebDriver driver;
	@BeforeSuite(alwaysRun = true)
	public void setUp()
	{
	    extent = new ExtentReports(System.getProperty("user.dir") +"/test-output/STMExtentReport.html",true);
	    extent
		 .addSystemInfo("Host Name", "SoftwareTesting")
		                .addSystemInfo("Environment", "Automation Testing")
		                .addSystemInfo("User Name", "Suresh Tester");
		             extent.loadConfig(new File(System.getProperty("user.dir")+"\\src\\testing.xml"));
	}

	@AfterMethod
	public void getReport(ITestResult result) throws Exception
	{
		if(result.getStatus() == ITestResult.FAILURE) {
		//log
		logger.log(LogStatus.FAIL, "Test Case Failed is "+ result.getName());
		logger.log(LogStatus.FAIL, "Test Case Failed is "+ result.getThrowable());
		//String screenshotPath = screenshot.getScreenhot(driver, result.getName());
		 //To add it in the extent report 
		 //logger.log(LogStatus.FAIL, logger.addScreenCapture(screenshotPath));
		}
		else if(result.getStatus() == ITestResult.SKIP){
			logger.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
			logger.log(LogStatus.SKIP, "Test Case Skipped is "+ result.getThrowable());
			
		}
		extent.endTest(logger);
	}
	@AfterSuite
	public void tearDown(){
	    extent.flush();
	    extent.close();
	    
	   } 
	}
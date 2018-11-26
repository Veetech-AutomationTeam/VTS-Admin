package VTS_Cab;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
//commit
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
public class Cabmodule extends Extendreport_with_Screenshot {
	 WebDriver driver;
	String username= "surv2e11855";
	String password="Temp!123"; 
	String url="http://172.18.1.4/vts-admin/Login.aspx";
	@BeforeClass
	  public void Init1() throws Exception {
		System.setProperty("webdriver.gecko.driver", "D:\\suresh QA\\automationwork\\geckodriver\\geckodriver-v0.19.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		driver.get(url);
	}	
		@Test(priority=1)
			//login page
			public void cabRequest() throws Exception
			{ 
			logger = extent.startTest("pass Test");
			 Assert.assertTrue(true);
		    driver.findElement(By.id("txtUserName")).sendKeys(username);
		    driver.findElement(By.id("txtPassword")).sendKeys(password);
		    driver.findElement(By.id("btnLogin")).click();
		    //cab request
		    driver.findElement(By.id("aCabRequest")).click();
		    Thread.sleep(1000);
		    driver.findElement(By.id("aCabRequestRaise")).click();
		    driver.findElement(By.id("ContentPlaceHolderBody_txtPickUpPlace")).sendKeys("salem");
		    driver.findElement(By.id("ContentPlaceHolderBody_txtDropPlace")).sendKeys("tiruppur");
		    
		    //date picker
		    driver.findElement(By.id("ContentPlaceHolderBody_txtPickUpDateTime")).click();

		    Thread.sleep(1000);
		    driver.findElement(By.xpath("/html/body/div/div[3]/table/tbody/tr[5]/td[3]")).click();
		    driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td/fieldset[2]/span[11]")).click();
		    driver.findElement(By.xpath("/html/body/div/div[1]/table/tbody/tr/td/fieldset/span[7]")).click();
		    driver.findElement(By.id("ContentPlaceHolderBody_ddlvehicle")).click();
		    new Select(driver.findElement(By.id("ContentPlaceHolderBody_ddlvehicle"))).selectByVisibleText("Car");
		    driver.findElement(By.id("ContentPlaceHolderBody_txtMobNo")).sendKeys("9685744152");
		    driver.findElement(By.id("ContentPlaceHolderBody_TxtExtensionNo")).clear();
		    driver.findElement(By.id("ContentPlaceHolderBody_TxtExtensionNo")).sendKeys("2086");
		    driver.findElement(By.id("ContentPlaceHolderBody_txtPurpose")).clear();
		    driver.findElement(By.id("ContentPlaceHolderBody_txtPurpose")).sendKeys("Automation tester");
		    driver.findElement(By.id("ContentPlaceHolderBody_btnSubmit")).click();
		    //takeScreenshot("new ticket");
		    driver.switchTo().alert().accept();
		    //logout
		    Thread.sleep(5000);
		    driver.findElement(By.xpath("/html/body/form/div[3]/div/nav[1]/ul/li[2]/a/i[2]")).click();
		    Thread.sleep(5000);
		    driver.findElement(By.id("lnkLogout")).click();
		   //takeScreenshot("logout"); 
		    //driver.quit();
		    //logger = extent.startTest("pass Test");
		    logger.log(LogStatus.PASS, "Test Case cab request is Passed");
		    
		    
		  }
		
		@Test(priority=2)
		public void cab_Approver() throws Exception
		
		{	
			 logger = extent.startTest("pass Test");
			Assert.assertTrue(true);
			 driver.navigate().to(driver.getCurrentUrl());
		    driver.findElement(By.id("txtUserName")).sendKeys("selV2E08792");
		    driver.findElement(By.id("txtPassword")).sendKeys("Temp!123");
		    driver.findElement(By.id("btnLogin")).click();
		   // takeScreenshot("Approver login"); 
		    //chosse role
		    Select sel=new Select(driver.findElement(By.id("ddlRole")));
		    sel.selectByVisibleText("Approver");
		    driver.findElement(By.id("btnNext")).click();
		  //cab request
		    driver.findElement(By.id("aCabRequest")).click();
		    Thread.sleep(1000);
		    driver.findElement(By.id("aCabRequestApproval")).click();
		    //Approve Ticket
		    Thread.sleep(2000);
		    driver.findElement(By.id("ContentPlaceHolderBody_dgvCabRequestDetails_dgvlbtnApprove_0")).click();
			driver.findElement(By.id("ContentPlaceHolderBody_dgvResolversList_rdoSelect_0")).click();
			driver.findElement(By.id("ContentPlaceHolderBody_txtApproverComments")).sendKeys("Automation tester suresh");
			driver.findElement(By.id("ContentPlaceHolderBody_btnApprove")).click();
			///takeScreenshot("Approver Apptoved ticket"); 
			driver.switchTo().alert().accept();
			Thread.sleep(5000);
		    driver.findElement(By.xpath("/html/body/form/div[3]/div/nav[1]/ul/li[2]/a/i[2]")).click();
		    Thread.sleep(5000);
		    driver.findElement(By.id("lnkLogout")).click();
			//Assert.assertTrue(true);
			logger.log(LogStatus.PASS, "Approver role is passed");	
		}


		@Test(priority=3)
		//resolver role
				public void cab_Resolver() throws Exception
				{
					 driver.navigate().to(driver.getCurrentUrl());
				    driver.findElement(By.id("txtUserName")).sendKeys("selV2E08793");
				    driver.findElement(By.id("txtPassword")).sendKeys("Temp!123");
				    driver.findElement(By.id("btnLogin")).click();
				   //takeScreenshot("Resolver login"); 
				  //chosse role
				    Select sel=new Select(driver.findElement(By.id("ddlRole")));
				    sel.selectByVisibleText("Resolver");
				    driver.findElement(By.id("btnNext")).click();
				  //cab request
				    driver.findElement(By.id("aCabRequest")).click();
				    Thread.sleep(1000);
				    driver.findElement(By.id("aCabRequestResolved")).click();
				    //resolve tickets
				    driver.findElement(By.id("ContentPlaceHolderBody_dgvCabApprovalWaiting_dgvlbtnResolve_0")).click();
				    driver.findElement(By.id("ContentPlaceHolderBody_txtCABName")).sendKeys("Flight");
				    driver.findElement(By.id("ContentPlaceHolderBody_txtTravelsName")).sendKeys("suresh k");
				    driver.findElement(By.id("ContentPlaceHolderBody_txtMobile")).sendKeys("9685741452");
				    //date picker
				    driver.findElement(By.id("ContentPlaceHolderBody_txtDepartureDateTime")).click();
				    driver.findElement(By.xpath("/html/body/div/div[3]/table/tbody/tr[5]/td[3]")).click();
				    driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr/td/fieldset[2]/span[12]")).click();
				    driver.findElement(By.xpath("/html/body/div/div[1]/table/tbody/tr/td/fieldset/span[7]")).click();
				    driver.findElement(By.id("ContentPlaceHolderBody_txtDriverName")).sendKeys("tester");
				    driver.findElement(By.id("ContentPlaceHolderBody_txtVehicleNo")).sendKeys("9645454454");
				    driver.findElement(By.id("ContentPlaceHolderBody_txtComments")).sendKeys("tester suresh");
				    driver.findElement(By.id("ContentPlaceHolderBody_btnSubmit")).click();
				   // takeScreenshot("Resolver Resolve ticket"); 
				    driver.switchTo().alert().accept();
				    Thread.sleep(5000);
				    driver.findElement(By.xpath("/html/body/form/div[3]/div/nav[1]/ul/li[2]/a/i[2]")).click();
				    Thread.sleep(5000);
				    driver.findElement(By.id("lnkLogout")).click();
				    driver.close();
				    logger = extent.startTest("pass Test");
					Assert.assertTrue(true);
				   logger.log(LogStatus.PASS, "Resolver role is passed");	

		}
		@AfterMethod
				 public void getResult(ITestResult result) throws Exception{
			 if(result.getStatus() == ITestResult.FAILURE){
			 logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
			 logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
			 //To capture screenshot path and store the path of the screenshot in the string "screenshotPath"
			                        //We do pass the path captured by this mehtod in to the extent reports using "logger.addScreenCapture" method. 
			 
			  String screenshotPath = Extendreport_with_Screenshot.getScreenhot(driver, result.getName());
			 //To add it in the extent report 
			 logger.log(LogStatus.FAIL, logger.addScreenCapture(screenshotPath));
			 }else if(result.getStatus() == ITestResult.SKIP){
			 logger.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
			 }
			 // ending test
			 //endTest(logger) : It ends the current test and prepares to create HTML report
			 extent.endTest(logger);
			 }	

			}	


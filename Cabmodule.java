package VTS_Cab;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

import VTS_Cab.Extentreport.*;

public class Cabmodule extends Extentreport {
	public static WebDriver driver;
	String username= "surv2e11855";
	String password="Temp!123"; 
	String url="http://172.18.1.4/vts-admin/Login.aspx";
		@Test(priority=1)
			//login page
			public void cabRequest() throws Exception
			{
			logger = extent.startTest("pass Test");
		    System.setProperty("webdriver.gecko.driver", "D:\\suresh QA\\automationwork\\geckodriver\\geckodriver-v0.19.1-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		    driver.findElement(By.id("txtUserName")).sendKeys(username);
		    driver.findElement(By.id("txtPassword")).sendKeys(password);
		    driver.findElement(By.id("btnLogin")).click();
		    takeScreenshot("Requester login"); 
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
		 
		    //edit ticket
		    Thread.sleep(1000);
		    driver.findElement(By.id("ContentPlaceHolderBody_dgvCabRequestDetails_dgvlbtnEdit_0")).click();
		    driver.switchTo().alert().accept();
		    driver.findElement(By.id("ContentPlaceHolderBody_btnEdit")).click();
		    takeScreenshot("edit ticket");
		    driver.switchTo().alert().accept();
		    //view ticket
		    Thread.sleep(1000);
		    driver.findElement(By.id("ContentPlaceHolderBody_dgvCabRequestDetails_dgvlbtnTicketID_0")).click();
		    //takeScreenshot("view");
		    driver.findElement(By.id("ContentPlaceHolderBody_btnBack")).click();
		    //logout
		    Thread.sleep(5000);
		    driver.findElement(By.xpath("/html/body/form/div[3]/div/nav[1]/ul/li[2]/a/i[2]")).click();
		    Thread.sleep(5000);
		    driver.findElement(By.id("lnkLogout")).click();
		   takeScreenshot("logout"); 
		    //driver.quit();
		    Assert.assertTrue(true);
		    logger.log(LogStatus.PASS, "Test Case cab request is Passed");
		    
		    
		  }
		
		@Test(priority=2)
		public void Approverlogin() throws Exception
		
		{
			logger = extent.startTest("pass Test");
			 driver.navigate().to(driver.getCurrentUrl());
		    driver.findElement(By.id("txtUserName")).sendKeys("selV2E08792");
		    driver.findElement(By.id("txtPassword")).sendKeys("Temp!123");
		    driver.findElement(By.id("btnLogin")).click();
		    takeScreenshot("Approver login"); 
		    //chosse role
		    Select sel=new Select(driver.findElement(By.id("ddlRole")));
		    sel.selectByVisibleText("Approver");
		    driver.findElement(By.id("btnNext")).click();
		  //cab request
		    driver.findElement(By.id("aCabRequest")).click();
		    Thread.sleep(1000);
		    driver.findElement(By.id("aCabRequestApproval")).click();
		    //Approve Ticket
		    driver.findElement(By.id("ContentPlaceHolderBody_dgvCabRequestDetails_dgvlbtnApprove_0")).click();
			driver.findElement(By.id("ContentPlaceHolderBody_dgvResolversList_rdoSelect_0")).click();
			driver.findElement(By.id("ContentPlaceHolderBody_txtApproverComments")).sendKeys("Automation tester suresh");
			driver.findElement(By.id("ContentPlaceHolderBody_btnApprove")).click();
			takeScreenshot("Approver Apptoved ticket"); 
			driver.switchTo().alert().accept();
			Thread.sleep(5000);
		    driver.findElement(By.xpath("/html/body/form/div[3]/div/nav[1]/ul/li[2]/a/i[2]")).click();
		    Thread.sleep(5000);
		    driver.findElement(By.id("lnkLogout")).click();
			Assert.assertTrue(true);
			logger.log(LogStatus.PASS, "Approver role is passed");	
		}


		@Test(priority=3)
		//resolver role
				public void Resolverlogin() throws Exception
				{
					logger = extent.startTest("pass Test");
					 driver.navigate().to(driver.getCurrentUrl());
				    driver.findElement(By.id("txtUserName")).sendKeys("selV2E08792");
				    driver.findElement(By.id("txtPassword")).sendKeys("Temp!123");
				    driver.findElement(By.id("btnLogin")).click();
				   takeScreenshot("Resolver login"); 
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
				    takeScreenshot("Resolver Resolve ticket"); 
				    driver.switchTo().alert().accept();
				    Thread.sleep(5000);
				    driver.findElement(By.xpath("/html/body/form/div[3]/div/nav[1]/ul/li[2]/a/i[2]")).click();
				    Thread.sleep(5000);
				    driver.findElement(By.id("lnkLogout")).click();
				    driver.close();
					//suresh commit
				    Assert.assertTrue(true);
				   logger.log(LogStatus.PASS, "Resolver role is passed");	

		}
		public static void takeScreenshot(String name) throws Exception {
			
	    	String timeStamp;
	    	File screenShotName;
	    	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    	//The below method will save the screen shot in d drive with name "screenshot.png"
	    	timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()); 
	    	screenShotName = new File("D:\\screenshot\\Approver"+timeStamp+"_"+name+".png");
	    	//FileUtils.copyFile(scrFile, screenShotName);
	    	 
	    	}

		
		
		
			   	}

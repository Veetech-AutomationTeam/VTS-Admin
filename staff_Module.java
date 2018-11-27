package VTS_Admin_IT_Testing;

import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
public class Staff_Module extends Extent_Report{
	WebDriver driver;
	String username= "surv2e11855";
	String password="Temp!123"; 
	public String url="http://172.18.1.4/vts-admin/Login.aspx";
	@BeforeClass
	  public void Init() throws Exception {
		System.setProperty("webdriver.gecko.driver", "D:\\suresh QA\\automationwork\\geckodriver\\geckodriver-v0.19.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		driver.get(url);
	}	
		@Test(priority=0)
			//login page
			public void Staff_Request() throws Exception
			{
			logger = extent.startTest("pass Test");
			Assert.assertTrue(true);
			driver.get(url);
		    driver.findElement(By.id("txtUserName")).sendKeys(username);
		    driver.findElement(By.id("txtPassword")).sendKeys(password);
		    driver.findElement(By.id("btnLogin")).click();
		    //Staff request
		    driver.findElement(By.linkText("Staff Quarters")).click();
		    Thread.sleep(1000);
		    driver.findElement(By.partialLinkText("Create")).click();
		    driver.findElement(By.id("ContentPlaceHolderBody_ddlHostelType")).click();
		    new Select(driver.findElement(By.id("ContentPlaceHolderBody_ddlHostelType"))).selectByVisibleText("Men");
		    driver.findElement(By.id("ContentPlaceHolderBody_txtEmployeeMobileNumber")).sendKeys("5263987485");
		    driver.findElement(By.id("ContentPlaceHolderBody_txtEmpEmergencyMobileNumber")).sendKeys("4152639874");
		    driver.findElement(By.id("ContentPlaceHolderBody_txtEmpAddress")).sendKeys("tester salem");
		    driver.findElement(By.id("ContentPlaceHolderBody_txtEmpCommends")).sendKeys("tester suresh");
		   driver.findElement(By.id("ContentPlaceHolderBody_dgvStaffQuarterEmployee_txtHostelCheckInDateTime_0")).click();
		   driver.findElement(By.xpath(" /html/body/div/div[1]/table/tbody/tr[5]/td[3]")).click();
		   driver.findElement(By.id("ContentPlaceHolderBody_btnSubmit")).click();
		   Thread.sleep(1000);
		   
		   driver.findElement(By.id("ContentPlaceHolderBody_btnAgree")).click();
		    driver.switchTo().alert().accept();
		    //logout
		    Thread.sleep(5000);
		    driver.findElement(By.xpath("/html/body/form/div[3]/div/nav[1]/ul/li[2]/a/i[2]")).click();
		    Thread.sleep(5000);
		    driver.findElement(By.id("lnkLogout")).click();
		    
		    logger.log(LogStatus.PASS, "Test Case Staff request is Passed");
		  }
		
		//approver
		@Test(priority=1)
		public void staff_Approver_Ticket() throws Exception
		{
			logger = extent.startTest("pass Test");
			Assert.assertTrue(true);
			driver.navigate().to(driver.getCurrentUrl());
		    driver.findElement(By.id("txtUserName")).sendKeys("selV2E08792");
		    driver.findElement(By.id("txtPassword")).sendKeys("Temp!123");
		    driver.findElement(By.id("btnLogin")).click(); 
		    //chosse role
		    Select sel=new Select(driver.findElement(By.id("ddlRole")));
		    sel.selectByVisibleText("Approver");
		    driver.findElement(By.id("btnNext")).click();
		  //staff approval
		    driver.findElement(By.linkText("Staff Quarters")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.id("aStaffQuarterRequestApproval")).click();
		    //Approve Ticket
		    driver.findElement(By.id("ContentPlaceHolderBody_VTSAdminApprovalControl1_dgvApprovalDetails_dgvlnkApprove_0")).click();
			driver.findElement(By.id("ContentPlaceHolderBody_VTSAdminApprovalControl1_dgvResolversList_rdoSelect_0")).click();
			driver.findElement(By.id("ContentPlaceHolderBody_VTSAdminApprovalControl1_txtApproverComments")).sendKeys("Automation tester suresh");
			driver.findElement(By.id("ContentPlaceHolderBody_VTSAdminApprovalControl1_btnApprove")).click();
			driver.switchTo().alert().accept();
			Thread.sleep(5000);
		    driver.findElement(By.xpath("/html/body/form/div[3]/div/nav[1]/ul/li[2]/a/i[2]")).click();
		    Thread.sleep(5000);
		    driver.findElement(By.id("lnkLogout")).click();
		   
		    logger.log(LogStatus.PASS, "Test Case Staff Approval is Passed");
		}
		
		@Test(priority=2)
		//resolver role
				public void staff_Resolve_Ticket() throws Exception
				{
					logger = extent.startTest("pass Test");
					 Assert.assertTrue(true);
					driver.navigate().to(driver.getCurrentUrl());
				    driver.findElement(By.id("txtUserName")).sendKeys("selV2E08792");
				    driver.findElement(By.id("txtPassword")).sendKeys("Temp!123");
				    driver.findElement(By.id("btnLogin")).click();
				    Select sel=new Select(driver.findElement(By.id("ddlRole")));
				    sel.selectByVisibleText("Resolver");
				    driver.findElement(By.id("btnNext")).click();
				    //staff resolver
				    driver.findElement(By.linkText("Staff Quarters")).click();
				    Thread.sleep(2000);
				    driver.findElement(By.id("aStaffQuarterRequestResolved")).click();
				    //follow-up
				    Thread.sleep(5000);	
				    driver.findElement(By.id("ContentPlaceHolderBody_dgvSQResolvingTickets_hylFollowUp_0")).click();
				    driver.findElement(By.id("ContentPlaceHolderBody_txtFollowUpComments")).sendKeys("tester suresh follow up");
				    driver.findElement(By.id("ContentPlaceHolderBody_btnFollowUp")).click();
				    driver.switchTo().alert().accept();
				    //resolve tickets
				    Thread.sleep(5000);
				    driver.findElement(By.id("ContentPlaceHolderBody_dgvSQResolvingTickets_hylApproval_0")).click();
				    driver.findElement(By.id("ContentPlaceHolderBody_ddlHostelName")).click();
				    new Select(driver.findElement(By.id("ContentPlaceHolderBody_ddlHostelName"))).selectByVisibleText("Raja Reddipatty");
				    driver.findElement(By.id("ContentPlaceHolderBody_ddlHostelAddress")).click();
				    new Select(driver.findElement(By.id("ContentPlaceHolderBody_ddlHostelAddress"))).selectByVisibleText("Salem");
				    driver.findElement(By.id("ContentPlaceHolderBody_ddlHostelRoomNumber")).click();
				    new Select(driver.findElement(By.id("ContentPlaceHolderBody_ddlHostelRoomNumber"))).selectByVisibleText("Room No-1");
				    driver.findElement(By.id("ContentPlaceHolderBody_txtHostelWardenName")).sendKeys("tester");
				    driver.findElement(By.id("ContentPlaceHolderBody_txtHostelWardenNumber")).sendKeys("4785963652");
				    //date picker
				    Thread.sleep(5000);
				    driver.findElement(By.id("ContentPlaceHolderBody_txtHostelAllotedDate")).click();
				    driver.findElement(By.xpath(" /html/body/div/div[1]/table/tbody/tr[5]/td[3]")).click();
				    driver.findElement(By.id("ContentPlaceHolderBody_txtHostelFeeAmountDeduction")).sendKeys("1000");
				    driver.findElement(By.id("ContentPlaceHolderBody_txtHostelResolverComments")).sendKeys("tester suresh");
				    driver.findElement(By.id("ContentPlaceHolderBody_btnSubmit")).click();
				    driver.switchTo().alert().accept();
				   driver.close();	   	
				    
				    logger.log(LogStatus.PASS, "Test Case staff resolvation is Passed");

				}

		 }

package VTS_Cab;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class Transport extends Extendreport_with_Screenshot{

	public static WebDriver driver;
	String username= "aruv2e11238";
	String password="Temp!123"; 
	public String url="http://172.18.1.4/vts-admin/Login.aspx";
	@BeforeClass
	  public void Transport() throws Exception {
		System.setProperty("webdriver.gecko.driver", "D:\\suresh QA\\automationwork\\geckodriver\\geckodriver-v0.19.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		driver.get(url);
	}	
		@Test(priority=1)
			//login page
			public void Transport_Request() throws Exception
			{
		    driver.get(url);
		    driver.findElement(By.id("txtUserName")).sendKeys(username);
		    driver.findElement(By.id("txtPassword")).sendKeys(password);
		    driver.findElement(By.id("btnLogin")).click();
		    //Transport request
		    driver.findElement(By.linkText("Transport")).click();
		    Thread.sleep(1000);
		    driver.findElement(By.partialLinkText("Create Tick")).click();
		    driver.findElement(By.id("ContentPlaceHolderBody_ddlRoute")).click();
		    new Select(driver.findElement(By.id("ContentPlaceHolderBody_ddlRoute"))).selectByVisibleText("DoctorColony-Vee2");
		    driver.findElement(By.id("ContentPlaceHolderBody_ddlShift")).click();
		    new Select(driver.findElement(By.id("ContentPlaceHolderBody_ddlShift"))).selectByVisibleText("General (10AM-6PM)");
		    driver.findElement(By.id("ContentPlaceHolderBody_txtComments")).sendKeys("tester suresh");
		    driver.findElement(By.id("ContentPlaceHolderBody_dgvTravelEmployee_txtPickupPlace_0")).sendKeys("salem");
		    driver.findElement(By.id("ContentPlaceHolderBody_dgvTravelEmployee_txtDestination_0")).sendKeys("tiruppur");
		    driver.findElement(By.id("ContentPlaceHolderBody_btnSubmit")).click();
		    driver.switchTo().alert().accept();
		    //logout
		    Thread.sleep(5000);
		    driver.findElement(By.xpath("/html/body/form/div[3]/div/nav[1]/ul/li[2]/a/i[2]")).click();
		    Thread.sleep(5000);
		    driver.findElement(By.id("lnkLogout")).click();
			}
		//approver
				@Test(priority=2)
				public void transport_Approver_Ticket() throws Exception
				{
				    driver.findElement(By.id("txtUserName")).sendKeys("selV2E08792");
				    driver.findElement(By.id("txtPassword")).sendKeys("Temp!123");
				    driver.findElement(By.id("btnLogin")).click();
				    Select sel=new Select(driver.findElement(By.id("ddlRole")));
				    sel.selectByVisibleText("Approver");
				    driver.findElement(By.id("btnNext")).click();
				    driver.findElement(By.linkText("Transport")).click();
				    Thread.sleep(2000);
				    driver.findElement(By.id("aTransportRequestApproval")).click();
				    driver.findElement(By.id("ContentPlaceHolderBody_VTSAdminApprovalControl1_dgvApprovalDetails_dgvlnkApprove_0")).click();
					driver.findElement(By.id("ContentPlaceHolderBody_VTSAdminApprovalControl1_dgvResolversList_rdoSelect_0")).click();
					driver.findElement(By.id("ContentPlaceHolderBody_VTSAdminApprovalControl1_txtApproverComments")).sendKeys("Automation tester suresh");
					driver.findElement(By.id("ContentPlaceHolderBody_VTSAdminApprovalControl1_btnApprove")).click();
					driver.switchTo().alert().accept();
					Thread.sleep(5000);
				    driver.findElement(By.xpath("/html/body/form/div[3]/div/nav[1]/ul/li[2]/a/i[2]")).click();
				    Thread.sleep(5000);
				    driver.findElement(By.id("lnkLogout")).click();	
				}
	
				@Test(priority=3)
				//resolver role
						public void tranport_Resolve_Ticket() throws Exception
						{
						    driver.findElement(By.id("txtUserName")).sendKeys("selV2E08792");
						    driver.findElement(By.id("txtPassword")).sendKeys("Temp!123");
						    driver.findElement(By.id("btnLogin")).click();
						    Select sel=new Select(driver.findElement(By.id("ddlRole")));
						    sel.selectByVisibleText("Resolver");
						    driver.findElement(By.id("btnNext")).click();
						    driver.findElement(By.linkText("Transport")).click();
						    Thread.sleep(2000);
						    driver.findElement(By.id("aTransportRequestResolved")).click();
						    //follow-up
						    Thread.sleep(2000);	
						    driver.findElement(By.id("ContentPlaceHolderBody_dgvTravelList_hylFollowUp_0")).click();
						    driver.findElement(By.id("ContentPlaceHolderBody_txtFollowUpComments")).sendKeys("tester suresh follow up");
						    driver.findElement(By.id("ContentPlaceHolderBody_btnFollowUp")).click();
						    driver.switchTo().alert().accept();
						    //resolve tickets
						    Thread.sleep(1000);
						    driver.findElement(By.id("ContentPlaceHolderBody_dgvTravelList_hylApproval_0")).click();
						    driver.findElement(By.id("ContentPlaceHolderBody_dgvResolveData_txtCab_0")).sendKeys("bus");
						    driver.findElement(By.id("ContentPlaceHolderBody_dgvResolveData_txtContactName_0")).sendKeys("suresh");
						    driver.findElement(By.id("ContentPlaceHolderBody_dgvResolveData_txtContactNo_0")).sendKeys("8574963652");
						    driver.findElement(By.id("ContentPlaceHolderBody_dgvResolveData_txtComments_0")).sendKeys("tester suresh");
						    driver.findElement(By.id("ContentPlaceHolderBody_txtTransDeductionFee")).sendKeys("3456");
						    driver.findElement(By.id("ContentPlaceHolderBody_btnSubmit")).click();
						    driver.switchTo().alert().accept();
						    driver.close();
		
						    
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


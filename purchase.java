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
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class purchase extends Extendreport_with_Screenshot{
	public static WebDriver driver;
	String username= "aruv2e11238";
	String password="Temp!123"; 
	public String url="http://172.18.1.4/vts-admin/Login.aspx";
	@BeforeClass
	  public void Init() throws Exception {
		System.setProperty("webdriver.gecko.driver", "D:\\suresh QA\\automationwork\\geckodriver\\geckodriver-v0.19.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		driver.get(url);
	}	
		@Test(priority=1)
			//login page
			public void purchase_Request() throws Exception
			{
			
		    driver.get(url);
		    driver.findElement(By.id("txtUserName")).sendKeys(username);
		    driver.findElement(By.id("txtPassword")).sendKeys(password);
		    driver.findElement(By.id("btnLogin")).click();
		    driver.findElement(By.linkText("Purchase Indent")).click();
		    Thread.sleep(1000);
		    driver.findElement(By.partialLinkText("Create Ticket")).click();
		    driver.findElement(By.id("ContentPlaceHolderBody_txtJustification")).sendKeys("suresh autyomation");
		    driver.findElement(By.id("ContentPlaceHolderBody_dgvPRItems_txtProduct_0")).sendKeys("Laptop");
		    new Select(driver.findElement(By.id("ContentPlaceHolderBody_dgvPRItems_ddlUnits_0"))).selectByVisibleText("KG");
		    driver.findElement(By.id("ContentPlaceHolderBody_dgvPRItems_txtQuantity_0")).sendKeys("5");
			driver.findElement(By.id("ContentPlaceHolderBody_btnSubmit")).click();
			driver.switchTo().alert().accept();
			Thread.sleep(2000);
		    driver.findElement(By.xpath("/html/body/form/div[3]/div/nav[1]/ul/li[2]/a/i[2]")).click();
		    Thread.sleep(5000);
		    driver.findElement(By.id("lnkLogout")).click();
		    logger = extent.startTest("pass Test");
			Assert.assertTrue(true);
		    logger.log(LogStatus.PASS, "Test Case purchase request is Passed");
			}
			
	//approver
			@Test(priority=2)
			public void purchase_Approver_Ticket() throws Exception
			{
				logger = extent.startTest("pass Test");
			    driver.findElement(By.id("txtUserName")).sendKeys("selV2E08792");
			    driver.findElement(By.id("txtPassword")).sendKeys("Temp!123");
			    driver.findElement(By.id("btnLogin")).click();
			    Select sel=new Select(driver.findElement(By.id("ddlRole")));
			    sel.selectByVisibleText("Approver");
			    driver.findElement(By.id("btnNext")).click();
			    driver.findElement(By.linkText("Purchase Indent")).click();
			    Thread.sleep(2000);
			    driver.findElement(By.id("aPurcahseRequestApproval")).click();
			    driver.findElement(By.id("ContentPlaceHolderBody_VTSAdminApprovalControl1_dgvApprovalDetails_dgvlnkApprove_0")).click();
				driver.findElement(By.id("ContentPlaceHolderBody_VTSAdminApprovalControl1_dgvResolversList_rdoSelect_0")).click();
				driver.findElement(By.id("ContentPlaceHolderBody_VTSAdminApprovalControl1_txtApproverComments")).sendKeys("Automation tester suresh");
				driver.findElement(By.id("ContentPlaceHolderBody_VTSAdminApprovalControl1_btnApprove")).click();
				driver.switchTo().alert().accept();
				Thread.sleep(2000);
			    driver.findElement(By.xpath("/html/body/form/div[3]/div/nav[1]/ul/li[2]/a/i[2]")).click();
			    Thread.sleep(5000);
			    driver.findElement(By.id("lnkLogout")).click();
			    Assert.assertTrue(true);
			    logger.log(LogStatus.PASS, "Test Case purchase request is Passed");
			}
		@Test(priority=3)
		//resolver role
			public void purchase_Resolve_Ticket() throws Exception
			{	logger = extent.startTest("pass Test");
			    driver.findElement(By.id("txtUserName")).sendKeys("selV2E08792");
			    driver.findElement(By.id("txtPassword")).sendKeys("Temp!123");
			    driver.findElement(By.id("btnLogin")).click();
			    Select sel=new Select(driver.findElement(By.id("ddlRole")));
			    sel.selectByVisibleText("Resolver");
			    driver.findElement(By.id("btnNext")).click();
			    //purchase resolver
			    Thread.sleep(1000);
			    driver.findElement(By.linkText("Purchase Indent")).click();
			    Thread.sleep(2000);
			    driver.findElement(By.id("aPurcahseRequestResolver")).click();
			    //follow-up
			    Thread.sleep(2000);	
			    driver.findElement(By.id("ContentPlaceHolderBody_dgvPurchaseRequest_hylFollowUp_0")).click();
			    driver.findElement(By.id("ContentPlaceHolderBody_txtFollowUpComments")).sendKeys("tester suresh follow up");
			    driver.findElement(By.id("ContentPlaceHolderBody_btnFollowUp")).click();
			    driver.switchTo().alert().accept();
			    //resolve tickets
			    Thread.sleep(10000);
			    driver.findElement(By.xpath("/html/body/form/div[3]/div[1]/div/div/div[2]/div[1]/div[1]/div/div/div/div/div[2]/div/table/tbody/tr/td[1]/center/div[1]/a/i")).click();
			    driver.findElement(By.id("ContentPlaceHolderBody_txtResolverComments")).sendKeys("tester suresh");
			    driver.findElement(By.id("ContentPlaceHolderBody_btnChangerole1")).click();
			    driver.switchTo().alert().accept();
			    driver.close();Assert.assertTrue(true);
			    logger.log(LogStatus.PASS, "Test Case purchase request is Passed");

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

package VTS_Admin_IT_Testing;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Ticket_Cancellation extends Extent_Report{
	 WebDriver driver;
	String username= "surv2e11855";
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

	@Test(priority = 0)
	public void requestor_cancellation() throws Exception {
		logger = extent.startTest("pass Test");
		Assert.assertTrue(true);
		driver.get(url);
	    driver.findElement(By.id("txtUserName")).sendKeys(username);
	    driver.findElement(By.id("txtPassword")).sendKeys(password);
	    driver.findElement(By.id("btnLogin")).click();
	    driver.findElement(By.id("aTicketCancel")).click();
	    Thread.sleep(5000);
	    driver.findElement(By.id("aCancelTicket")).click();
	    driver.findElement(By.id("ContentPlaceHolderBody_ddlServices")).click();
	    Select dropdown1 = new Select(driver.findElement(By.id("ContentPlaceHolderBody_ddlServices")));
		dropdown1.selectByIndex(1);
		driver.findElement(By.id("ContentPlaceHolderBody_txtReason")).sendKeys("suresh tester");
		driver.findElement(By.id("ContentPlaceHolderBody_btnSubmit")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Thread.sleep(5000);
		driver.findElement(By.ByClassName.className("dropdown-toggle")).click();
		driver.findElement(By.id("lnkLogout")).click();
		Thread.sleep(1000);
		
		logger.log(LogStatus.PASS, "Test Case Travel Request is Passed");
	}
	@Test(priority=1)
	public void Resolver_Cancel() throws InterruptedException
	{
		logger = extent.startTest("pass Test");
		Assert.assertTrue(true);
		driver.findElement(By.id("txtUserName")).sendKeys("selv2e08792");
		driver.findElement(By.id("txtPassword")).sendKeys("Temp!123");
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.id("ddlRole"));
		Select dropdown4 = new Select(driver.findElement(By.id("ddlRole")));
		dropdown4.selectByIndex(3);
		driver.findElement(By.id("btnNext")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("aTicketCancel")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("aResolveCancelTicket")).click();
		driver.findElement(By.id("ContentPlaceHolderBody_dgvTickets_hylclose_0")).click();
		driver.findElement(By.id("ContentPlaceHolderBody_txtComments")).sendKeys("tester suresh");
		driver.findElement(By.id("ContentPlaceHolderBody_btnReslove")).click();
		driver.switchTo().alert().accept();
		driver.close();
		
		logger.log(LogStatus.PASS, "Test Case Travel Request is Passed");
	}

}






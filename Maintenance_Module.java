package VTS_Admin_IT_Testing;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
public class Maintenance_Module extends Extent_Report{
	String username= "surv2e11855";
	String password="Temp!123"; 
	public String url="http://172.18.1.4/vts-admin/Login.aspx";
	WebDriver driver;
	@BeforeClass
	  public void Init() throws Exception {
		System.setProperty("webdriver.gecko.driver", "D:\\suresh QA\\automationwork\\geckodriver\\geckodriver-v0.19.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		driver.get(url);
	}	

	@Test(priority = 0)
	public void requestor() throws Exception {
		logger = extent.startTest("pass Test");
		Assert.assertTrue(true);
		driver.get(url);
	    driver.findElement(By.id("txtUserName")).sendKeys(username);
	    driver.findElement(By.id("txtPassword")).sendKeys(password);
	    driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.xpath(".//*[@id='aMaintenances']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='aMaintenanceRequestRaise']")).click();
		driver.findElement(By.id("ContentPlaceHolderBody_ddlVenue")).click();
		Select dropdown1 = new Select(driver.findElement(By.id("ContentPlaceHolderBody_ddlVenue")));
		dropdown1.selectByIndex(1);
		driver.findElement(By.id("ContentPlaceHolderBody_txtSubject")).sendKeys("maintain");
		driver.findElement(By.id("ContentPlaceHolderBody_txtDescription"))
				.sendKeys("maintain in the ground floor production");
		driver.findElement(By.id("ContentPlaceHolderBody_ddlTicketType"));
		Select dropdown2 = new Select(driver.findElement(By.id("ContentPlaceHolderBody_ddlTicketType")));
		dropdown2.selectByIndex(1);
		driver.findElement(By.id("ContentPlaceHolderBody_ddlCategory"));
		Select dropdown3 = new Select(driver.findElement(By.id("ContentPlaceHolderBody_ddlCategory")));
		dropdown3.selectByIndex(2);
		driver.findElement(By.id("ContentPlaceHolderBody_ddlSLA"));
		Select dropdown4 = new Select(driver.findElement(By.id("ContentPlaceHolderBody_ddlSLA")));
		dropdown4.selectByIndex(3);
		driver.findElement(By.xpath(".//*[@id='ContentPlaceHolderBody_btnSubmit']")).click();// Ticket created
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		driver.findElement(By.ByClassName.className("dropdown-toggle")).click();
		driver.findElement(By.id("lnkLogout")).click();
		 
		 logger.log(LogStatus.PASS, "Test Case Maintenance request is Passed");
	}

	@Test(priority = 1)
	public void Approver() throws Exception {
		logger = extent.startTest("pass Test");
		Assert.assertTrue(true);
		driver.findElement(By.id("txtUserName")).clear();
		driver.findElement(By.id("txtUserName")).sendKeys("selv2e08792");
		driver.findElement(By.id("txtPassword")).sendKeys("Temp!123");
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.id("ddlRole"));
		Select dropdown3 = new Select(driver.findElement(By.id("ddlRole")));
		dropdown3.selectByVisibleText("Approver");
		driver.findElement(By.id("btnNext")).click();
		// Approval login page
		Actions action2 = new Actions(driver);
		action2.sendKeys(Keys.ENTER).build().perform();
		driver.findElement(By.xpath(".//*[@id='aMaintenances']")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath(".//*[@id='aMaintenanceRequestApproval']")).sendKeys(Keys.ENTER);
		driver.findElement(By.id("ContentPlaceHolderBody_dgvApprovalPending_hylEdit_0")).click();
		driver.findElement(By.id("ContentPlaceHolderBody_dgvResolversList_lblResolverName_0"));
		driver.findElement(By.id("ContentPlaceHolderBody_dgvResolversList_lblEmployeeCode_0")).click();
		driver.findElement(By.xpath(".//*[@id='ContentPlaceHolderBody_dgvResolversList_rdoSelect_0']")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("ContentPlaceHolderBody_txtApproverComments")).sendKeys("Approved");// Ticket Approved
		driver.findElement(By.id("ContentPlaceHolderBody_btnApprove")).click();
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		driver.findElement(By.ByClassName.className("dropdown-toggle")).click();
		driver.findElement(By.id("lnkLogout")).click(); 
		
	    logger.log(LogStatus.PASS, "Test Case Maintenace Approval is Passed");
	}

	@Test(priority = 2)
	public void Resolver() throws Exception
	{
		logger = extent.startTest("pass Test");
		Assert.assertTrue(true);
		driver.findElement(By.id("txtUserName")).clear();
		driver.findElement(By.id("txtUserName")).sendKeys("selv2e08792");
		driver.findElement(By.id("txtPassword")).sendKeys("Temp!123");
		driver.findElement(By.id("btnLogin")).click();
		// Resolver login page
		driver.findElement(By.id("ddlRole"));
		Select dropdown4 = new Select(driver.findElement(By.id("ddlRole")));
		dropdown4.selectByVisibleText("Resolver");
		driver.findElement(By.id("btnNext")).click();
		Actions action3 = new Actions(driver);
		action3.sendKeys(Keys.ENTER).build().perform();
		driver.findElement(By.xpath(".//*[@id='aMaintenances']")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath(".//*[@id='aMaintenanceRequestResolved']")).sendKeys(Keys.ENTER);
		driver.findElement(By.id("ContentPlaceHolderBody_dgvMaintenanceRequest_hylEdit_0")).click();
		driver.switchTo().alert().accept();
		Thread.sleep(5000);
		//Allocated date picker 
		driver.findElement(By.id("ContentPlaceHolderBody_txtAllocatedDate")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/table/tbody/tr[5]/td[4]")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td/fieldset[2]/span[2]")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/table/tbody/tr/td/fieldset/span[8]")).click();
		
		Thread.sleep(5000);
		//Estimation-compeletion date-picker 
		driver.findElement(By.id("ContentPlaceHolderBody_txtEstimateCompletion")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div[3]/table/tbody/tr[5]/td[5]")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/table/tbody/tr/td/fieldset[2]/span[12]")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/table/tbody/tr/td/fieldset/span[8]")).click();
		//Actual completion date picker 
		
		Thread.sleep(5000);
		driver.findElement(By.id("ContentPlaceHolderBody_txtActualCompletionDate")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div[3]/div[3]/table/tbody/tr[5]/td[5]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/table/tbody/tr/td/fieldset[2]/span[2]")).click();
		driver.findElement(By.xpath("/html/body/div[3]/div[1]/table/tbody/tr/td/fieldset/span[8]")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("ContentPlaceHolderBody_txtCommants")).sendKeys("Test Data");
		driver.findElement(By.id("ContentPlaceHolderBody_btnSubmit")).click();// Ticket Resolved in Maintenance module
		Thread.sleep(5000);
		driver.switchTo().alert().accept();
		driver.findElement(By.ByClassName.className("dropdown-toggle")).click();
		driver.findElement(By.id("lnkLogout")).click();
		driver.close();
		
		 logger.log(LogStatus.PASS, "Test Case maintenance resolve is Passed");
		 
	}
	 }
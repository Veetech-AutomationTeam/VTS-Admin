package VTS_Admin_IT_Testing;
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
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
public class Feedback_Module extends Extent_Report {
	WebDriver driver;
	String username= "chav1e02581";
	String password="Temp!123"; 
	public String url="http://172.18.1.4/vts-admin/Login.aspx";
	@BeforeClass
	  public void Init() throws Exception {
		System.setProperty("webdriver.gecko.driver", "D:\\suresh QA\\automationwork\\geckodriver\\geckodriver-v0.19.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(url);
	}	

	@Test(priority = 0)
	public void Requestor() throws Exception {
		logger = extent.startTest("pass Test");
		Assert.assertTrue(true);
		driver.get(url);
	    driver.findElement(By.id("txtUserName")).sendKeys(username);
	    driver.findElement(By.id("txtPassword")).sendKeys(password);
	    driver.findElement(By.id("btnLogin")).click();
	    driver.findElement(By.id("ddlRole"));
		Select dropdown = new Select(driver.findElement(By.id("ddlRole")));
		dropdown.selectByVisibleText("Requestor");
		driver.findElement(By.id("btnNext")).click();
		Thread.sleep(3000);
		//Ticket Requestor
		Actions action1 = new Actions(driver);
		action1.sendKeys(Keys.ENTER).build().perform();
		driver.findElement(By.xpath(".//*[@id='aFeedback']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='acreatefeedback']")).click();
		driver.findElement(By.id("ContentPlaceHolderBody_ddlType")).click();
		Select dropdown1 = new Select(driver.findElement(By.id("ContentPlaceHolderBody_ddlType")));
		dropdown1.selectByIndex(2);
		driver.findElement(By.id("ContentPlaceHolderBody_txtfeedback")).sendKeys("It was good");
		driver.findElement(By.id("ContentPlaceHolderBody_txtsug")).sendKeys("no suggestions");
		driver.findElement(By.xpath(".//*[@id='ContentPlaceHolderBody_btnsubmit']")).click();// Ticket created in Feedback
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		driver.findElement(By.ByClassName.className("dropdown-toggle")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.id("lnkLogout")).click();
		
	    logger.log(LogStatus.PASS, "Test Case feeedback request is Passed");
	    
	}

	@Test(priority = 1)
	public void Resolver() throws Exception {
		logger = extent.startTest("pass Test");
		Assert.assertTrue(true);
		driver.findElement(By.id("txtUserName")).clear();
		driver.findElement(By.id("txtUserName")).sendKeys("chav1e02581");
		driver.findElement(By.id("txtPassword")).sendKeys("Temp!123");
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.id("ddlRole"));
		Select dropdown = new Select(driver.findElement(By.id("ddlRole")));
		dropdown.selectByVisibleText("Resolver");
		driver.findElement(By.id("btnNext")).click();
		// Resolver login page
		Thread.sleep(3000);
		Actions action1 = new Actions(driver);
		action1.sendKeys(Keys.ENTER).build().perform();
		driver.findElement(By.xpath(".//*[@id='aFeedback']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"aResolved\"]")).click();	
		driver.findElement(By.xpath(".//*[@id='ContentPlaceHolderBody_dgvTickets_hylResolve_0']")).click();
		driver.findElement(By.id("ContentPlaceHolderBody_txtsolution")).sendKeys("resolve cab");
		driver.findElement(By.xpath(".//*[@id='ContentPlaceHolderBody_btnReslove']")).click();//Ticket Resolved in Feedback Module
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		 driver.close();
		
	    logger.log(LogStatus.PASS, "Test Case feedback request is Resolved");
	    
	}
	 }
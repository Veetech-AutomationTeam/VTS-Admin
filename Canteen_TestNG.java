package Canteen;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Canteen_TestNG {

	public static WebDriver driver;

	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:/chrome latest/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://172.18.1.4/VTS-Admin/Login.aspx");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.id("txtUserName")).sendKeys("ashv2c11677");
		driver.findElement(By.xpath(".//*[@id='txtPassword']")).sendKeys("234234234233242423");
		driver.findElement(By.id("btnLogin")).click();
		driver.switchTo().alert().accept();
		driver.findElement(By.id("txtUserName")).clear();
		driver.findElement(By.id("txtUserName")).sendKeys("Ashv2e11677");
		driver.findElement(By.id("txtPassword")).sendKeys("Temp!123"); //Login successfully
	}
	
	@Test(priority = 0)
	public void requestor() throws Exception {
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.id("ddlRole"));
		Select dropdown = new Select(driver.findElement(By.id("ddlRole")));
		dropdown.selectByVisibleText("Requestor");
		driver.findElement(By.id("btnNext")).click();
		Actions action1 = new Actions(driver);
		action1.sendKeys(Keys.ENTER).build().perform();
		driver.findElement(By.xpath(".//*[@id='aCanteenFoodRequestTicketHistory']")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath(".//*[@id='aCanteenFoodRequestRaise']")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath(".//*[@id='ContentPlaceHolderBody_ddlCategory']")).sendKeys(Keys.TAB);
		Thread.sleep(2000);
		driver.findElement(By.id("ContentPlaceHolderBody_ddlCategory"));
		Select dropdown1 = new Select(driver.findElement(By.id("ContentPlaceHolderBody_ddlCategory")));
		dropdown1.selectByVisibleText("Guest Food Coupon");
		driver.findElement(By.id("ContentPlaceHolderBody_txtFoodCount")).sendKeys("2");
		driver.findElement(By.id("ContentPlaceHolderBody_ddlItemCategory"));
		Select dropdown2 = new Select(driver.findElement(By.id("ContentPlaceHolderBody_ddlItemCategory")));
		dropdown2.selectByVisibleText("BreakFast");
		driver.findElement(By.id("ContentPlaceHolderBody_txtComments")).sendKeys("For meeting purpose");
		driver.findElement(By.xpath(".//*[@id='ContentPlaceHolderBody_btnSubmit']")).click();
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		driver.findElement(By.ByClassName.className("dropdown-toggle")).click(); // Ticket created 
		driver.findElement(By.id("lnkLogout")).click();
	}

	@Test(priority = 1)
	public void Approver() throws Exception {
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
		driver.findElement(By.xpath(".//*[@id='aCanteenFoodRequestTicketHistory']")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath(".//*[@id='aCanteenFoodRequestApproval']")).sendKeys(Keys.ENTER);
		driver.findElement(By.id("ContentPlaceHolderBody_dgvCanteenFoodRequest_hylEdit_0")).click();
		driver.findElement(By.id("ContentPlaceHolderBody_dgvResolversList_lblResolverName_0"));
		driver.findElement(By.id("ContentPlaceHolderBody_dgvResolversList_lblEmployeeCode_0")).click();
		driver.findElement(By.xpath(".//*[@id='ContentPlaceHolderBody_dgvResolversList_rdoSelect_0']")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("ContentPlaceHolderBody_txtApproverComments")).sendKeys("Approved");
		driver.findElement(By.id("ContentPlaceHolderBody_btnApprove")).click();// Ticket Approved
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		driver.findElement(By.ByClassName.className("dropdown-toggle")).click();
		driver.findElement(By.id("lnkLogout")).click();
	}

	@Test(priority = 2)
	public void Resolver() throws Exception {
		driver.findElement(By.id("txtUserName")).clear();
		driver.findElement(By.id("txtUserName")).sendKeys("bhaV2E08026");
		driver.findElement(By.id("txtPassword")).sendKeys("Temp!123");
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.id("ddlRole"));
		Select dropdown4 = new Select(driver.findElement(By.id("ddlRole")));
		dropdown4.selectByVisibleText("Resolver");
		driver.findElement(By.id("btnNext")).click();
		// Resolver login page
		Actions action3 = new Actions(driver);
		action3.sendKeys(Keys.ENTER).build().perform();
		driver.findElement(By.xpath(".//*[@id='aCanteenFoodRequestTicketHistory']")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath(".//*[@id='aCanteenFoodRequestResolved']")).sendKeys(Keys.ENTER);
		driver.findElement(By.id("ContentPlaceHolderBody_dgvResolvationWaiting_hylEdit_0")).click();
		driver.switchTo().alert().accept();
		driver.findElement(By.id("ContentPlaceHolderBody_txtResolverComments")).sendKeys("Resolved");
		driver.findElement(By.id("ContentPlaceHolderBody_btnSubmit")).click();// Ticket Resolved in CanteenFood
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		driver.findElement(By.ByClassName.className("dropdown-toggle")).click();
		driver.findElement(By.id("lnkLogout")).click();
	}

	@Test(priority = 3)
	public void reports() throws Exception {
		driver.findElement(By.id("txtUserName")).clear();
		driver.findElement(By.id("txtUserName")).sendKeys("selv2e08792");
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='txtPassword']")).sendKeys("Temp!123");
		// report page login
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.id("ddlRole")).click();
		Select dropdown11 = new Select(driver.findElement(By.id("ddlRole")));
		dropdown11.selectByIndex(3);
		driver.findElement(By.id("btnNext")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("aCanteenFoodRequestTicketHistory")).click();
		driver.findElement(By.id("aCanteenFoodRequestResolved")).click();
		driver.findElement(By.xpath(".//*[@id='ContentPlaceHolderBody_lbtnCabTicketsResolvation']")).click();
		// canteen food ticket resolved detail
		driver.findElement(By.id("aReports")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("aCanteenTicketStatus")).click();
		driver.findElement(By.xpath(".//*[@id='ContentPlaceHolderBody_lbtnClosedTickets']")).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(".//*[@id='ContentPlaceHolderBody_lbtnClosedTickets']"));
		System.out.println(element);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(2000);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	@AfterTest
	public void close_Canteenfood() {
		driver.close();
	}

}

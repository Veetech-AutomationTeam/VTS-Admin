package New;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Maintenance {

	public static WebDriver driver;

	@BeforeTest
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "C:/chrome latest/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://172.18.1.4/VTS-Admin/Login.aspx");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.id("txtUserName")).clear();
		driver.findElement(By.id("txtUserName")).sendKeys("Ashv2e11677");
		driver.findElement(By.id("txtPassword")).sendKeys("Temp!123");
		driver.findElement(By.id("btnLogin")).click();
	}

	@Test(priority = 0)
	public void requestor() throws Exception {
		driver.findElement(By.id("ddlRole"));
		Select dropdown = new Select(driver.findElement(By.id("ddlRole")));
		dropdown.selectByVisibleText("Requestor");
		driver.findElement(By.id("btnNext")).click();
		//Ticket Requestor
		Actions action1 = new Actions(driver);
		action1.sendKeys(Keys.ENTER).build().perform();
		driver.findElement(By.xpath(".//*[@id='aMaintenances']")).click();
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
	}

	@Test(priority = 2)
	public void Resolver() throws Exception {
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
		driver.findElement(By.id("ContentPlaceHolderBody_txtAllocatedDate")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/table/tbody/tr[4]/td[3]")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td/fieldset[2]/span[5]")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/table/tbody/tr/td/fieldset/span[11]")).click();
		driver.findElement(By.id("ContentPlaceHolderBody_txtEstimateCompletion")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div[3]/table/tbody/tr[4]/td[6]")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/table/tbody/tr/td/fieldset[2]/span[5]")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/table/tbody/tr/td/fieldset/span[12]")).click();
		driver.findElement(By.id("ContentPlaceHolderBody_txtActualCompletionDate")).click();
		driver.findElement(By.xpath("/html/body/div[3]/div[3]/table/tbody/tr[4]/td[4]")).click();
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/table/tbody/tr/td/fieldset[2]/span[7]")).click();
		driver.findElement(By.xpath("/html/body/div[3]/div[1]/table/tbody/tr/td/fieldset/span[3]")).click();
		driver.findElement(By.name("ctl00$ContentPlaceHolderBody$txtCommants")).sendKeys("Test Data");
		driver.findElement(By.id("ContentPlaceHolderBody_btnSubmit")).click();// Ticket Resolved in Maintenance module
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		driver.findElement(By.ByClassName.className("dropdown-toggle")).click();
		driver.findElement(By.id("lnkLogout")).click();
	}

	@AfterTest
	public void close_Maintenance() {
		driver.close();
	}
}



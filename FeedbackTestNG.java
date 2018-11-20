package feedbackpkg;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FeedbackTestNG {

	public static WebDriver driver;

	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:/chrome latest/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://172.18.1.4/VTS-Admin/Login.aspx");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.id("txtUserName")).clear();
		driver.findElement(By.id("txtUserName")).sendKeys("chav1e02581");
		driver.findElement(By.id("txtPassword")).sendKeys("Temp!123");
	}

	@Test(priority = 0)
	public void Requestor() throws Exception {
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.id("ddlRole"));
		Select dropdown = new Select(driver.findElement(By.id("ddlRole")));
		dropdown.selectByVisibleText("Requestor");
		driver.findElement(By.id("btnNext")).click();
		//Ticket Requestor
		Actions action1 = new Actions(driver);
		action1.sendKeys(Keys.ENTER).build().perform();
		driver.findElement(By.xpath(".//*[@id='aFeedback']")).click();
		driver.findElement(By.xpath(".//*[@id='acreatefeedback']")).click();
		driver.findElement(By.id("ContentPlaceHolderBody_ddlType")).click();
		Select dropdown1 = new Select(driver.findElement(By.id("ContentPlaceHolderBody_ddlType")));
		dropdown1.selectByIndex(2);
		driver.findElement(By.id("ContentPlaceHolderBody_txtfeedback")).sendKeys("It was good");
		driver.findElement(By.id("ContentPlaceHolderBody_txtsug")).sendKeys("no suggestions");
		driver.findElement(By.xpath(".//*[@id='ContentPlaceHolderBody_btnsubmit']")).click();// Ticket created in Feedback
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		driver.findElement(By.ByClassName.className("dropdown-toggle")).click();
		driver.findElement(By.id("lnkLogout")).click();
	}

	@Test(priority = 1)
	public void Resolver() throws Exception {
		driver.findElement(By.id("txtUserName")).clear();
		driver.findElement(By.id("txtUserName")).sendKeys("chav1e02581");
		driver.findElement(By.id("txtPassword")).sendKeys("Temp!123");
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.id("ddlRole"));
		Select dropdown = new Select(driver.findElement(By.id("ddlRole")));
		dropdown.selectByVisibleText("Resolver");
		driver.findElement(By.id("btnNext")).click();
		// Resolver login page
		Actions action1 = new Actions(driver);
		action1.sendKeys(Keys.ENTER).build().perform();
		driver.findElement(By.xpath(".//*[@id='aFeedback']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='aResolved']")).click();
		driver.findElement(By.xpath(".//*[@id='ContentPlaceHolderBody_dgvTickets_hylResolve_0']")).click();
		driver.findElement(By.id("ContentPlaceHolderBody_txtsolution")).sendKeys("resolve cab");
		driver.findElement(By.xpath(".//*[@id='ContentPlaceHolderBody_btnReslove']")).click();//Ticket Resolved in Feedback Module
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		driver.findElement(By.ByClassName.className("dropdown-toggle")).click();
		driver.findElement(By.id("lnkLogout")).click();
	}

	@AfterTest
	public void close_Feedback() {
		driver.close();
	}
}


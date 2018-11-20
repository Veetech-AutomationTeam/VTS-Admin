package travel;

import java.util.concurrent.TimeUnit;

/*import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;*/
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TravelAccomodation_TestNG {

	public static WebDriver driver;

	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:/chrome latest/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://172.18.1.4/VTS-Admin/Login.aspx");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.id("txtUserName")).sendKeys("Ashv2e11677");
		driver.findElement(By.id("txtPassword")).sendKeys("Temp!123");
		driver.findElement(By.id("btnLogin")).click();//Login successfully
	}

	@Test(priority = 0)
	public void requestor() throws Exception {
		driver.findElement(By.id("ddlRole"));
		Select dropdown = new Select(driver.findElement(By.id("ddlRole")));
		dropdown.selectByVisibleText("Requestor");
		driver.findElement(By.id("btnNext")).click();
		//Ticket Requestor
		driver.findElement(By.id("aTravelDetail")).click();
		driver.findElement(By.id("aTravelRequestRaise")).click();
		driver.findElement(By.id("ContentPlaceHolderBody_txtDepartureDate")).click();
		driver.findElement(By.xpath("html/body/div[1]/div[3]/table/tbody/tr[5]/td[3]")).click();
		driver.findElement(By.xpath("html/body/div[1]/div[2]/table/tbody/tr/td/fieldset[2]/span[11]")).click();
		driver.findElement(By.xpath("html/body/div[1]/div[1]/table/tbody/tr/td/fieldset/span[10]")).click();
		driver.findElement(By.id("ContentPlaceHolderBody_txtPickupPlace")).sendKeys("Salem");
		driver.findElement(By.id("ContentPlaceHolderBody_txtDestinationDate")).click();
		driver.findElement(By.xpath("html/body/div[2]/div[3]/table/tbody/tr[5]/td[4]")).click();
		driver.findElement(By.xpath("html/body/div[2]/div[2]/table/tbody/tr/td/fieldset[2]/span[12]")).click();
		driver.findElement(By.xpath("html/body/div[2]/div[1]/table/tbody/tr/td/fieldset/span[10]")).click();
		driver.findElement(By.id("ContentPlaceHolderBody_txtDestinationPlace")).sendKeys("Bangalore");
		driver.findElement(By.id("ContentPlaceHolderBody_ddlDepartments")).click();
		driver.findElement(By.id("ContentPlaceHolderBody_txtEmployeeName")).sendKeys("S");
		driver.findElement(
				By.xpath(".//*[@id='page-wrapper']/div/div[2]/div[1]/div[2]/table[1]/tbody/tr[2]/td[3]/div/ul/li[1]/a"))
				.click();
		driver.findElement(By.id("ContentPlaceHolderBody_btnAdd")).click();
		driver.findElement(By.id("ContentPlaceHolderBody_ddlModeofTravel")).click();
		Select dropdown1 = new Select(driver.findElement(By.id("ContentPlaceHolderBody_ddlModeofTravel")));
		dropdown1.selectByIndex(3);
		driver.findElement(By.id("ContentPlaceHolderBody_txtComments")).sendKeys("To meet client");
		driver.findElement(By.id("ContentPlaceHolderBody_btnSubmit")).click();	// Ticket created
		Thread.sleep(2000);
		Alert alt = driver.switchTo().alert();
		alt.accept();
		Thread.sleep(2000);
		driver.findElement(By.ByClassName.className("dropdown-toggle")).click();
		driver.findElement(By.id("lnkLogout")).click();
		Thread.sleep(1000);
	}

	@Test(priority = 1)
	public void Approver1() throws Exception {
		driver.findElement(By.id("txtUserName")).sendKeys("chiv3e10836");
		driver.findElement(By.id("txtPassword")).sendKeys("Temp!123");
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.id("ddlRole"));
		Select dropdown2 = new Select(driver.findElement(By.id("ddlRole")));
		dropdown2.selectByIndex(0);
		driver.findElement(By.id("btnNext")).click();
		// Approval1 login page
		driver.findElement(By.id("aTravelDetail")).click();
		driver.findElement(By.id("aTravelRequestApproval")).click();
		driver.findElement(By.id("ContentPlaceHolderBody_VTSAdminApprovalControl1_dgvApprovalDetails_dgvlnkApprove_0"))
				.click();
		Alert alt150 = driver.switchTo().alert();//Approver 1
		alt150.accept();
		Thread.sleep(2000);
		driver.findElement(By.ByClassName.className("dropdown-toggle")).click();
		driver.findElement(By.id("lnkLogout")).click();
	}

	@Test(priority = 2)
	public void Approver2() throws Exception {
		driver.findElement(By.id("txtUserName")).sendKeys("selv2e08792");
		driver.findElement(By.id("txtPassword")).sendKeys("Temp!123");
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.id("ddlRole"));
		Select dropdown3 = new Select(driver.findElement(By.id("ddlRole")));
		dropdown3.selectByIndex(1);
		driver.findElement(By.id("btnNext")).click();
		// Approval2 login page
		driver.findElement(By.id("aTravelDetail")).click();
		driver.findElement(By.id("aTravelRequestApproval")).click();
		driver.findElement(By.id("ContentPlaceHolderBody_VTSAdminApprovalControl1_dgvApprovalDetails_dgvlnkApprove_0"))
				.click();
		driver.findElement(By.id("ContentPlaceHolderBody_VTSAdminApprovalControl1_dgvResolversList_lblResolverName_2"))
				.click();
		driver.findElement(By.id("ContentPlaceHolderBody_VTSAdminApprovalControl1_dgvResolversList_lblEmployeeCode_2"))
				.click();
		driver.findElement(By.id("ContentPlaceHolderBody_VTSAdminApprovalControl1_dgvResolversList_rdoSelect_2"))
				.click();
		driver.findElement(By.id("ContentPlaceHolderBody_VTSAdminApprovalControl1_txtApproverComments"))
				.sendKeys("Approved");
		driver.findElement(By.id("ContentPlaceHolderBody_VTSAdminApprovalControl1_btnApprove")).click();// Ticket Approved
		Alert alt151 = driver.switchTo().alert();
		alt151.accept();
		Thread.sleep(2000);
		driver.findElement(By.ByClassName.className("dropdown-toggle")).click();
		driver.findElement(By.id("lnkLogout")).click();
	}

	@Test(priority = 3)
	public void Resolver() throws Exception {
		driver.findElement(By.id("txtUserName")).sendKeys("selv2e08792");
		driver.findElement(By.id("txtPassword")).sendKeys("Temp!123");
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.id("ddlRole"));
		Select dropdown4 = new Select(driver.findElement(By.id("ddlRole")));
		dropdown4.selectByIndex(3);
		driver.findElement(By.id("btnNext")).click();
		// Resolver login page
		driver.findElement(By.id("aTravelDetail")).click();
		driver.findElement(By.id("aTravelRequestResolved")).click(); 
		driver.findElement(By.id("ContentPlaceHolderBody_dgvTravelList_hylResolvation_0")).click();
		driver.findElement(By.id("ContentPlaceHolderBody_txtTravelsName")).sendKeys("Ravi.R");
		driver.findElement(By.id("ContentPlaceHolderBody_txtBillAmount")).sendKeys("2000");
		driver.findElement(By.id("ContentPlaceHolderBody_ddlPaymentMode")).click();
		Select dropdown5 = new Select(driver.findElement(By.id("ContentPlaceHolderBody_ddlPaymentMode")));
		dropdown5.selectByIndex(0);
		driver.findElement(By.id("ContentPlaceHolderBody_txtTravelsContactName")).sendKeys("Suresh.S");
		driver.findElement(By.id("ContentPlaceHolderBody_txtTravelsPhone")).sendKeys("04343-2345678");
		driver.findElement(By.id("ContentPlaceHolderBody_txtTravelBookingCharge")).sendKeys("3000");
		driver.findElement(By.id("ContentPlaceHolderBody_txtComments")).sendKeys("Meeting Purpose");
		driver.findElement(By.xpath(".//*[@id='ContentPlaceHolderBody_chkBoxAccomataion']")).click();
		driver.findElement(By.id("ContentPlaceHolderBody_txtHotelName")).sendKeys("Star hotel");
		driver.findElement(By.id("ContentPlaceHolderBody_txtHotelAddress")).sendKeys("12,north street, bangalore.");
		driver.findElement(By.id("ContentPlaceHolderBody_txtHotelContactPerson")).sendKeys("balu.A");
		driver.findElement(By.id("ContentPlaceHolderBody_txtHotelContactPhone")).sendKeys("1472583690");
		driver.findElement(By.id("ContentPlaceHolderBody_txtCheckInDateTime")).click();
		driver.findElement(By.xpath("html/body/div[3]/div[3]/table/tbody/tr[5]/td[5]")).click();
		driver.findElement(By.xpath("html/body/div[3]/div[2]/table/tbody/tr/td/fieldset[2]/span[11]")).click();
		driver.findElement(By.xpath("html/body/div[3]/div[1]/table/tbody/tr/td/fieldset/span[10]")).click();
		driver.findElement(By.id("ContentPlaceHolderBody_txtCheckOutDateTime")).click();
		driver.findElement(By.xpath("html/body/div[4]/div[3]/table/tbody/tr[5]/td[6]")).click();
		driver.findElement(By.xpath("html/body/div[4]/div[2]/table/tbody/tr/td/fieldset[2]/span[12]")).click();
		driver.findElement(By.xpath("html/body/div[4]/div[1]/table/tbody/tr/td/fieldset/span[12]")).click();
		driver.findElement(By.id("ContentPlaceHolderBody_ddlAccomataionPaymentMode")).click();
		Select dropdown7 = new Select(driver.findElement(By.id("ContentPlaceHolderBody_ddlAccomataionPaymentMode")));
		dropdown7.selectByIndex(0);
		driver.findElement(By.id("ContentPlaceHolderBody_ddlHotelFood")).click();
		Select dropdown6 = new Select(driver.findElement(By.id("ContentPlaceHolderBody_ddlHotelFood")));
		dropdown6.selectByIndex(0);
		driver.findElement(By.id("ContentPlaceHolderBody_txtHotelComments")).sendKeys("Yes i need accomodation");
		driver.findElement(By.id("ContentPlaceHolderBody_btnSubmit")).click();// Ticket Resolved in Travel & Accommodation module
		Thread.sleep(2000);
		Alert alt2 = driver.switchTo().alert();
		alt2.accept();
		driver.findElement(By.ByClassName.className("dropdown-toggle")).click();
		driver.findElement(By.id("lnkLogout")).click();
	}

	@AfterTest
	public void close_TravelAccomodation() {
		driver.close();
	}

}
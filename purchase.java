package Purchaseintent;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class purchase {
	public static WebDriver driver;
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
			}
			
	//approver
			@Test(priority=2)
			public void Approver_Ticket() throws Exception
			{
				//logger = extent.startTest("pass Test");
			    driver.findElement(By.id("txtUserName")).sendKeys("selV2E08792");
			    driver.findElement(By.id("txtPassword")).sendKeys("Temp!123");
			    driver.findElement(By.id("btnLogin")).click();
			    //takeScreenshot("Approver login"); 
			    //chosse role
			    Select sel=new Select(driver.findElement(By.id("ddlRole")));
			    sel.selectByVisibleText("Approver");
			    driver.findElement(By.id("btnNext")).click();
			  //staff approval
			    driver.findElement(By.linkText("Purchase Indent")).click();
			    Thread.sleep(2000);
			    driver.findElement(By.id("aPurcahseRequestApproval")).click();
			    
			    //Approve Ticket
			    driver.findElement(By.id("ContentPlaceHolderBody_VTSAdminApprovalControl1_dgvApprovalDetails_dgvlnkApprove_0")).click();
				driver.findElement(By.id("ContentPlaceHolderBody_VTSAdminApprovalControl1_dgvResolversList_rdoSelect_0")).click();
				driver.findElement(By.id("ContentPlaceHolderBody_VTSAdminApprovalControl1_txtApproverComments")).sendKeys("Automation tester suresh");
				driver.findElement(By.id("ContentPlaceHolderBody_VTSAdminApprovalControl1_btnApprove")).click();
				 //takeScreenshot("Approver Apptoved ticket"); 
				driver.switchTo().alert().accept();
				Thread.sleep(2000);
			    driver.findElement(By.xpath("/html/body/form/div[3]/div/nav[1]/ul/li[2]/a/i[2]")).click();
			    Thread.sleep(5000);
			    driver.findElement(By.id("lnkLogout")).click();
}


		@Test(priority=3)
		//resolver role
			public void Resolve_Ticket() throws Exception
			{
			    driver.findElement(By.id("txtUserName")).sendKeys("selV2E08792");
			    driver.findElement(By.id("txtPassword")).sendKeys("Temp!123");
			    driver.findElement(By.id("btnLogin")).click();
			    Select sel=new Select(driver.findElement(By.id("ddlRole")));
			    sel.selectByVisibleText("Resolver");
			    driver.findElement(By.id("btnNext")).click();
			    //purchase resolver
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
			    driver.close();

			}
}

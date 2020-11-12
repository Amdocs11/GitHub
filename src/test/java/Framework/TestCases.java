package Framework;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.ExtentReportsNG;
import resources.Reusable;

public class TestCases extends Reusable {

	public static Logger log = LogManager.getLogger(Reusable.class.getName()); 
	
	ExtentTest test;
	ExtentReports extent= ExtentReportsNG.getReportObjects();
	
	

	@BeforeMethod
	public void openBrowser() throws IOException {
		driver = initiateDriver();

		driver.get("https://www.rahulshettyacademy.com/#/index");

		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		test = extent.createTest("signIN");
	}
	
	

	@Test(dataProvider = "getData")
	public void browserInvoke(String emailID, String pass) throws IOException {

		LandingPage tc = new LandingPage(driver);
		LoginPage lp = tc.Signin();
		log.info("clicked signin successfully");

		lp.Email().sendKeys(emailID);

		lp.Password().sendKeys(pass);

		ForgotPassword fp = lp.ForgotPass();
		
		fp.Email().sendKeys("ankita.com");
	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
		extent.flush();
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][2];

		data[0][0] = "angelina@gmail.com";
		data[0][1] = "Angelina";

		data[1][0] = "anku@gmail.com";
		data[1][1] = "Anku";

		return data;

	}

}

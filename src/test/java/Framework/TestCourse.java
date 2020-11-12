package Framework;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.Reusable;

public class TestCourse extends Reusable{

	@BeforeMethod
	public void openBrowser() throws IOException
	{
		driver = initiateDriver();
		
		driver.get("https://www.rahulshettyacademy.com/#/index");
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
		
	
	@Test
	public void getCourse() throws IOException, InterruptedException
	{
		
		LandingPage tc = new LandingPage(driver);
		
		
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.elementToBeClickable(tc.Course()));
		
	//	wait.until(ExpectedConditions.titleContains(title)
		//tc.Course().click()
		tc.Course().click();
		
	//	Thread.sleep(3000);
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.close();
	}
	
	
}

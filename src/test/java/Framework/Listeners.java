package Framework;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReportsNG;
import resources.Reusable;

public class Listeners extends Reusable implements ITestListener {
	
	ExtentTest test;
	ExtentReports extent= ExtentReportsNG.getReportObjects();

	public void onTestStart(ITestResult result) {

		test = extent.createTest(result.getMethod().getMethodName());
		
	}

	public void onTestSuccess(ITestResult result) {

		test.log(Status.PASS, "Test is passed");
	}

	public void onTestFailure(ITestResult result) {
		// need to take SS here
	
	WebDriver driver = null;
	try {
		driver=	(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
	} catch (Exception e) {
		
		e.printStackTrace();
	} 
		
		test.fail(result.getThrowable());
		String testMethodName = result.getMethod().getMethodName();
		try {
			getScreenShots(testMethodName, driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		extent.flush();
		
	}

}

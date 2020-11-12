package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//

public class ExtentReportsNG {
	
	static ExtentReports extent;
	
	public static ExtentReports getReportObjects()
	{
		String path = System.getProperty("user.dir")+"\\reporter\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation");
		reporter.config().setDocumentTitle("Test Results");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Ankita B");
		return extent;
	}

}

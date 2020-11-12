package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Reusable{
	
public WebDriver driver;	

	public WebDriver initiateDriver() throws IOException
	
	{
		Properties pro = new Properties();
		
		FileInputStream fis = new FileInputStream("C:\\new Scripts\\EndToEnd\\src\\main\\java\\data.properties");
		
		pro.load(fis);
		
	String browserName = pro.getProperty("browser");
		
		//String browserName = System.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\new Scripts\\chromedriver_win32 (4)\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\new Scripts\\geckodriver-v0.27.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		return driver;
	}
	
	public void getScreenShots(String testname, WebDriver driver) throws IOException
	{
		TakesScreenshot ss = (TakesScreenshot)driver;
		
		File src = ss.getScreenshotAs(OutputType.FILE);
		String destFile = System.getProperty("user.dir"+"\\reports\\"+testname+".png"); //points to project dir i.e EndToEnd
		
		FileUtils.copyDirectory(src, new File(destFile));
	}

}

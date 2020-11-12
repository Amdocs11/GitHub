package Framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class waste {
	
	public static void main(String[] args) {
	
		
		
		System.setProperty("webdriver.gecko.driver", "C:\\new Scripts\\geckodriver-v0.27.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.rahulshettyacademy.com/#/index");
	}
	
	
	
	
	//System.setProperty("webdriver.chrome.driver", "C:\\new Scripts\\geckodriver-v0.27.0-win64\\geckodriver.exe");
	

}

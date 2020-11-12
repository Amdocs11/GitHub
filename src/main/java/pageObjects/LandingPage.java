package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	public WebDriver driver;
	
	PageFactory po = new PageFactory();
	
	public LandingPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class = 'theme-btn register-btn']")
	WebElement signin;

	@FindBy(xpath = "//div[@class='nav-outer clearfix']//a[contains(text(),'Courses')]")
	WebElement course;
	
	public LoginPage Signin()
	{
		signin.click();
		LoginPage lp = new LoginPage(driver);
		return lp;
	}
	
	public WebElement Course()
	{
		return course;
	}
}
//@FindBy(linkText = "//a[@class = 'theme-btn register-btn']")
package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	
	WebDriver driver;
	
	public PageFactory po = new PageFactory();
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "user_email")
	WebElement email;
	
	@FindBy(id = "user_password")
	WebElement password;
	
/*	@FindBy(xpath = "//*[@value = 'Log In']")
	WebElement submit;*/
	
	@FindBy(css = "a[href*='password/new']")
	WebElement forgotPassword;
	
    public WebElement Email()
    {
    	return email;
    }
    
    public WebElement Password()
    {
    	return password;
    }
    
    public ForgotPassword ForgotPass()
    {
    	
    	forgotPassword.click();
    	
    	return new ForgotPassword(driver);
    }
    
   /* public WebElement Submit()
    {
    	return submit;
    }*/
    
    
    
    
    
}

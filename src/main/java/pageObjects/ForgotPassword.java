package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPassword {
	
	
	WebDriver driver;
	
	public PageFactory po = new PageFactory();
	
	public ForgotPassword(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "user_email")
	WebElement email;
	

	
    public WebElement Email()
    {
    	return email;
    }
    

    
    
}

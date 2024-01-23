package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
    @FindBy(id="input-email")
    private WebElement username;
    
    @FindBy(id="input-password")
    private WebElement password;
    
    @FindBy(css="input[value='Login']")
    private WebElement login;
    
    public WebElement getUser()
    {
    	return username;
    }
    public WebElement getPassword()
    {
    	return password;
    }
    
    public WebElement clickLogin()
    {
    	return login;
    }
    
}

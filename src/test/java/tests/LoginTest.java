package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobjects.AccountPage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.Base;

public class LoginTest  extends Base {
	WebDriver driver;
	Logger log;
	@Test(dataProvider="getData")
	public void login(String email,String password,String status) throws IOException{
		
		LandingPage page=new LandingPage(driver);
		log.debug("Landed to main page");
		page.accountPage().click();
		log.debug("Landing to account page");
		page.loginPage().click();
		log.debug("Landing to Login Page");
		
		LoginPage login=new LoginPage(driver);
		login.getUser().sendKeys(email);
		login.getPassword().sendKeys(password);
		login.clickLogin().click();
		
		AccountPage acc=new AccountPage(driver);
		String actual = null;
		try {
		     if(acc.editAccount().isDisplayed())
		     {
		    	 actual="success"; 
		    	 log.debug("Success");
		     }
		     
		}
		catch(Exception e)
		{
			actual="failure";
			log.error("Failed");
		}
		Assert.assertEquals(actual, status);			
		
	}
	
	@BeforeMethod
	public void open() throws IOException
	{
		log = LogManager.getLogger(LoginTest.class.getName());
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	@AfterMethod
	public void finish()
	{
		driver.close();
		System.out.println("Succesfully logged in");
	}
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data={{"bhagya12@gmail.com","123456","success"},{"dummy@gmail.com","123","failure"}};
		return data;
	}

}

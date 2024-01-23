package finalfeatures;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.AccountPage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.Base;

public class FinalLogin extends Base{
	WebDriver driver;
	LandingPage page;
	LoginPage login;
	AccountPage acc;
	@Given("Open any Browser")
	public void open_any_browser() throws IOException {

		driver=initializeDriver();
	}

	@And("Navigate to Login page")
	public void navigate_to_login_page() {
		driver.get(prop.getProperty("url"));
		page=new LandingPage(driver);
		page.accountPage().click();
		page.loginPage().click();
	}

	@When("User enters username as {string} and password as {string} into the fields")
	public void user_enters_username_as_and_password_as_into_the_fields(String email, String password) {
		login=new LoginPage(driver);
		login.getUser().sendKeys(email);
		login.getPassword().sendKeys(password);
		
	}

	@And("User clicks on Login button")
	public void user_clicks_on_login_button() {

		login.clickLogin().click();
	}

	@Then("Verify user is able to successfully login")
	public void verify_user_is_able_to_successfully_login() {
		acc=new AccountPage(driver);
		Assert.assertTrue(acc.editAccount().isDisplayed());

	}
	
	@After
	public void closure()
	{
		driver.close();
		System.out.println("Success"); 
		
	}

}

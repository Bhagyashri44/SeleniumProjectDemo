package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import resources.Base;

public class DemoTest1 extends Base {
	
	public WebDriver driver;
	@Test
	public void demoTest() throws IOException, InterruptedException
	{
		driver=initializeDriver();
		driver.get("https://chat.openai.com/c/627a60a4-a2dc-4168-bb5c-d8703cb7997a");
		System.out.println("Demo Test 1");
		Thread.sleep(2000);
		Assert.assertTrue(false);
		driver.close();
		
	}

}

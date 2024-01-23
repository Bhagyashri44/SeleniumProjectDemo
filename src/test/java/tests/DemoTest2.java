package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.Base;

public class DemoTest2 extends Base{
	WebDriver driver;
	@Test
	public void demoTest2() throws IOException
	{
		driver=initializeDriver();
		driver.get("https://maven.apache.org/plugins/maven-resources-plugin/examples/filter.html");
		System.out.println("Demo Test 2");
		driver.close();
		
	}

}

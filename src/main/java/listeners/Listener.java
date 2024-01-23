package listeners;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Base;
import utilities.ExtentReportDemo;

public class Listener extends Base implements ITestListener {

	ThreadLocal<ExtentTest> extentTestThread = new ThreadLocal<ExtentTest>();
	ExtentReports extentreport = ExtentReportDemo.getExtentReport();
	ExtentTest extentTest;
	@Override
	public void onTestStart(ITestResult result) {
		extentTest = extentreport.createTest(result.getName()+"Execution Started");
		extentTestThread.set(extentTest);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
        //extentTest.log(Status.PASS,result.getName()+"Got Passed");
        extentTestThread.get().log(Status.PASS,"Test Passed");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		//Takes screenshot
		
		WebDriver driver=null;
		String testName=result.getName();
		//extentTest.log(Status.FAIL,result.getName()+"Got Failed");
		extentTestThread.get().fail(result.getThrowable());
		try {
			//Takes exact driver that is currently running
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} 
		catch (Exception e) {
			
			e.printStackTrace();
		}
		try {
			
			//Adding the SS to ExtentReport
			//takeScreenshots(testName,driver);
			String screenshotFilePath = takeScreenshots(testName,driver);
			extentTestThread.get().addScreenCaptureFromPath(screenshotFilePath, testName);
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		extentreport.flush();
	}

}

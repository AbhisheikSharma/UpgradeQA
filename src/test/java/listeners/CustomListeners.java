package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import utilities.Screenshots;

public class CustomListeners implements ITestListener {
	WebDriver driver;

	@Override
	public void onTestSuccess(ITestResult result) {
		Reporter.log("Test Method passed from class:"+ result.getTestClass().getName());
		Reporter.log("Test Method name is: "+ result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
			Screenshots.getScreenshot(result);
		}
	}

	@Override
	public void onStart(ITestContext context) {
		Reporter.log("Starting the test from XML. Test tag name is: "+ context.getName());
	}

	@Override
	public void onFinish(ITestContext context) {
		Reporter.log("Ended the test from XML. Test tag name is: "+ context.getName());

	}

}

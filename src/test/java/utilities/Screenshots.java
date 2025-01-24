package utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

public class Screenshots {
	static WebDriver driver;
	static File file;
	
	public Screenshots(WebDriver driver) {
		Screenshots.driver = driver;
	}
	
	
	public static void getScreenshot(ITestResult itr) {
		System.out.println("Inside actual method");
		file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("./Screenshots/"+ itr.getTestClass().getName()+"_"+itr.getMethod().getMethodName()+"_"+Screenshots.nameAppender()+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static String nameAppender() {
		DateFormat df = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date dt = new Date();
		return df.format(dt);
	}

}

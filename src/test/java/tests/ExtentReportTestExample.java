package tests;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.github.javafaker.Faker;

public class ExtentReportTestExample {
   static  ExtentReports report;
   static  ExtentSparkReporter spark;
   static ExtentTest logger;

    @BeforeMethod
    public void initialize() {
    	Faker faker = new Faker();
    	String randomname = faker.regexify("abcdefghijklmnop");
        spark = new ExtentSparkReporter("./Reports/sample"+randomname+".html");
        report = new ExtentReports();
        report.attachReporter(spark);
        
    }

    @Test
    public void f1() {
         logger = report.createTest("This is Test 1");
        logger.info("Starting Test 1");
        Assert.assertTrue(false); // Assertion fails here, stopping execution
        logger.fail("1 gaya"); // This line is never executed
    }

    @Test
    public void f2() {
       logger = report.createTest("This is Test 2");
        logger.info("Starting Test 2");
        Assert.assertTrue(true);
        logger.pass("2 raha");
    }

    @Test
    public void f3() {
        logger = report.createTest("This is Test 3");
        logger.info("Starting Test 3");
        Assert.assertEquals(false, true); // Assertion fails here, stopping execution
        logger.fail("3 gaya"); // This line is never executed
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
        	System.out.println("Test failed "+ result.getName());
            logger.fail("Test failed: " + result.getName());
            report.flush();
            System.out.println("reported "+ result.getName());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
        	System.out.println("Test passed "+ result.getName());
            logger.pass("Test passed: " + result.getName());
            report.flush();
        } else if (result.getStatus() == ITestResult.SKIP) {
        	System.out.println("Test skipped "+ result.getName());
            logger.skip("Test skipped: " + result.getName());
            report.flush();
        }
      
    }
}
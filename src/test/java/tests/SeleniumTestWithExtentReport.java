package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumTestWithExtentReport {
    WebDriver driver;
    ExtentReports report;
    ExtentSparkReporter spark;
    ExtentTest test;

    @BeforeMethod
    public void setup() {
        // Initialize ExtentReport
        spark = new ExtentSparkReporter("./Reports/extentReport.html");
        report = new ExtentReports();
        report.attachReporter(spark);

        // Initialize WebDriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.example.com"); // Replace with your target URL
    }

    @Test
    public void test1() {
        test = report.createTest("Test 1: Validating Example Title");
        test.info("Starting Test 1");

        // Test 1 - Assertion fails deliberately
        String title = driver.getTitle();
        test.info("Page title: " + title);
        Assert.assertEquals(title, "InvalidTitle"); // This will fail
        test.fail("Test 1 failed: Title mismatch");
    }

    @Test
    public void test2() {
        test = report.createTest("Test 2: Validating Invalid Element");
        test.info("Starting Test 2");

        // Test 2 - Assertion fails deliberately
        boolean elementExists = driver.findElements(By.id("nonExistentElement")).size() > 0;
        test.info("Element found: " + elementExists);
        Assert.assertTrue(elementExists); // This will fail as the element doesn't exist
        test.fail("Test 2 failed: Element not found");
    }

    @Test
    public void test3() {
        test = report.createTest("Test 3: Validating Successful Assertion");
        test.info("Starting Test 3");

        // Test 3 - Successful test
        String url = driver.getCurrentUrl();
        test.info("Current URL: " + url);
        Assert.assertEquals(url, "https://www.example.com"); // This will pass
        test.pass("Test 3 passed: URL matched");
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        // Capture status of test (Pass/Fail)
        if (result.getStatus() == ITestResult.FAILURE) {
            test.fail("Test failed: " + result.getName());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.pass("Test passed: " + result.getName());
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.skip("Test skipped: " + result.getName());
        }
        
        // End test and flush report
        report.flush();
        driver.quit(); // Close browser after test execution
    }
}

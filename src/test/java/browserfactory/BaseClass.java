package browserfactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import pagefactory.FrontierPage;
import utilities.DataReader;
import utilities.Screenshots;

public class BaseClass {
	protected WebDriver driver;
	protected FrontierPage frontierpage;
	protected DataReader datareader;
	Screenshots screenshots;
	
	@BeforeSuite
	public void setUpDataSources() {
		datareader = new DataReader();
	}

	@BeforeMethod
	@Parameters({"browsername","appurl"})
	public void setUpBrowserAndApp(String browsername, String auturl) throws InterruptedException {
		if(browsername.equalsIgnoreCase("chrome")) {
	//	ChromeOptions opt = new ChromeOptions();
	//	opt.addArguments("--headless");
	//	opt.addArguments("--window-size=1920,1080");
	//	opt.addArguments("--disable-gpu");
	//	opt.addArguments("--no-sandbox");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		}
		else if(browsername.equalsIgnoreCase("firefox")) {
	//		FirefoxOptions fopt = new FirefoxOptions();
	//		fopt.addArguments("--headless");
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		}
		frontierpage = PageFactory.initElements(driver, FrontierPage.class);
		screenshots = new Screenshots(driver);
		driver.manage().window().maximize();
		driver.get(auturl);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Thread.sleep(3000);
	}
	@AfterMethod
	public void cleanUp() {
		driver.quit();
	}
}
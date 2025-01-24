package browserfactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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
	public void setUpBrowserAndApp(String browsername, String auturl) {
		if(browsername.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		}
		else if(browsername.equalsIgnoreCase("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		}
		frontierpage = PageFactory.initElements(driver, FrontierPage.class);
		screenshots = new Screenshots(driver);
		System.out.println("Screenshots class driver assigned");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get(auturl);
	}
	@AfterMethod
	public void cleanUp() {
		driver.quit();
	}
}
package pagefactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FrontierPage {
WebDriver driver;

public FrontierPage(WebDriver driver) {
	this.driver = driver;
}

@FindBy(xpath="//input[starts-with(@id,'street-address')]")
WebElement addressfield;

public void enterSearchAddress(String address) {
	System.out.println("Whats in address field element"+ addressfield);
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.elementToBeClickable(addressfield));
	addressfield.click();
	addressfield.sendKeys(address);
	
}
}

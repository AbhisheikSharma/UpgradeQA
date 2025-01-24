package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FrontierPage {
WebDriver driver;

public FrontierPage(WebDriver driver) {
	this.driver = driver;
}

@FindBy(xpath="//input[starts-with(@id,'street-address')]")
WebElement addressfield;


public void enterSearchAddress(String address) {
	addressfield.click();
	addressfield.sendKeys(address);
	
}
}

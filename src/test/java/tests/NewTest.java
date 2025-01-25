package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

public class NewTest {
	WebDriver driver = new ChromeDriver();
  @Test
  public void f() {
	  Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
	  .withTimeout(Duration.ofSeconds(5))
	  .pollingEvery(Duration.ofSeconds(1))
	  .ignoring(Exception.class);
  }
}

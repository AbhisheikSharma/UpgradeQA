package tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import browserfactory.BaseClass;
import utilities.DataReader;

@Listeners(listeners.CustomListeners.class)

public class FrontierValidAddressCheckTest extends BaseClass {

@Test
public void checkAvailability() {
		frontierpage.enterSearchAddress(DataReader.readStringData(0, 0));
	try {
		Thread.sleep(2000);
	} catch (Exception e) {
		System.out.println("Failed because unable to enter address in the field "+ e.getMessage());
	}
	Assert.assertTrue(false);
	
}
}

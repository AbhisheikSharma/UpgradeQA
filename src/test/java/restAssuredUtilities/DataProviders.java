package restAssuredUtilities;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="Books")
	public Object[][] booksAndAuthor() {
		return new Object[][] {
			{"JavaScript","AK Verma","bqc"},
			{"Zalenium","Zalim Daku","cpd"},
			{"kaatilkatli","Mangal Singh","bjb"}
		};
	}

}

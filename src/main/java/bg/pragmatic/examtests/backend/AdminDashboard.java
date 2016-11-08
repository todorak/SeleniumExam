package bg.pragmatic.examtests.backend;

import bg.pragmatic.examtests.browser.Browser;
import org.junit.Assert;


public class AdminDashboard {

	public static void verifyTitle(String messageOnFailure, String expectedTitle) {
		Assert.assertEquals(messageOnFailure, expectedTitle, Browser.driver.getTitle());
	}

		

}

package bg.pragmatic.examtests;

import bg.pragmatic.examtests.backend.AdminDashboard;
import bg.pragmatic.examtests.backend.AdminLogin;
import bg.pragmatic.examtests.browser.Browser;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AdminLoginTests {

	@Before
	public void setup(){
		Browser.init();
	}
	
	@Test
	public void successfulLogin(){
		AdminLogin.goTo();
		AdminLogin.login("admin", "parola");
		AdminDashboard.verifyTitle("It was unable to login successfully", "Dashboard");
	}
	
	
	
	@After
	public void tearDown(){
		Browser.quit();
	}
	
	
}

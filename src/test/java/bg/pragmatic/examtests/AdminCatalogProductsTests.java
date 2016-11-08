package bg.pragmatic.examtests;

import bg.pragmatic.examtests.backend.AdminCatalogProducts;
import bg.pragmatic.examtests.backend.AdminDashboard;
import bg.pragmatic.examtests.backend.AdminLogin;
import bg.pragmatic.examtests.browser.Browser;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AdminCatalogProductsTests {

	@Before
	public void setUp() {
		Browser.init();
	}

	@Test
	public void insertNewCatalogProduct() {
		AdminLogin.goTo();
		AdminLogin.login("admin", "parola");
		AdminDashboard.verifyTitle("It was unable to login successfully", "Dashboard");
		AdminCatalogProducts.insertNewProduct("Google Phone", "Google phone Pixel", "Google phone Pixel", 
				"Google, phone, Pixel", "Pixel", "Pixel001", "UPC123", "EANl321", "JAN123", "IsbnPixel1234", "Pixel1234567", 
				"Sofia", "500", "9", "50", "1", "1", "7", "Google Pixel", "2016-11-20", "154.7", "75.7",
				"8.5", "2", "168", "2", "1", "2", "Google", "Phones", "Clockspeed",
				"Quad-core (2x2.15 GHz Kryo & 2x1.6 GHz Kryo)");
		AdminCatalogProducts.verifyInsertNewProduct("The new product was not created!",
				"Success: You have modified products!");
	}

	

	 @After
	 public void tearDown() {
	 Browser.quit();
	 }
}

package bg.pragmatic.examtests.backend;

import bg.pragmatic.examtests.browser.Browser;
import bg.pragmatic.utils.WaitTool;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertTrue;

import java.util.List;

public class AdminCatalogProducts {

	public static void insertNewProduct(String ProductName, String MetaTagDescription, String MetaTagKeywords,
			String ProductTags, String ProductModel, String ProductSku, String ProductUps, String ProductEan,
			String ProductJan, String ProductIsbn, String ProductMpn, String ProductLocation, String ProductPrice,
			String TaxClassListDefault9, String ProductQuantity, String ProductMinimumQuantity,
			String SubTractList1YES0NO, String StockStatus, String ProductSeokeyword,
			String ProductDateAvailableYYYYMMDD, String ProductDimensionsLenght, String ProductDimensionsWidth,
			String ProductDimensionsHeight, String LengthClass1cm2mm3inch, String ProductWeight,
			String WeightClass1Kg2Gr5Po6Ou, String ProductStatus1Enab0Disab, String ProductSortOrder,
			String ProductManufacturer, String ProductCategories, String ProductAddAttribute,
			String ProductAddAttributeText) {
		WebElement menu = WaitTool.waitForElement(Browser.driver, By.id("catalog"), 10);
		menu.click();
		WebElement products = Browser.driver.findElement(By.id("catalog"));
		Actions action = new Actions(Browser.driver);
		action.moveToElement(products).build().perform();
		WebElement Products = WaitTool.waitForElement(Browser.driver, By.linkText("Products"), 10);
		Products.click();
		WebElement findProductName = Browser.driver.findElement(By.name("filter_name"));
		findProductName.sendKeys(ProductName);
		WebElement filterButton = Browser.driver.findElement(By.linkText("Filter"));
		filterButton.click();

		String searchName = ProductName;
		List<WebElement> productsNamePage = Browser.driver
				.findElements(By.xpath("//table[contains(@class,'list')]//tr[2]//td[3]"));
		List<WebElement> checkbox = Browser.driver.findElements(By.name("selected[]"));
		WebElement deleteButton = Browser.driver.findElement(By.linkText("Delete"));
		for (int i = 0; i < productsNamePage.size(); i++) {
			String product = productsNamePage.get(i).getText();
			System.out.println("Product Name : " + product);
			if (product.equalsIgnoreCase(searchName)) {
				System.out.println("Product name already exist!");
				checkbox.get(i).click();
				deleteButton.click();
				Alert alert = Browser.driver.switchTo().alert();
				alert.accept();
				Assert.assertEquals("Product was not deleted!", "Success: You have modified products!",
						Browser.driver.findElement(By.className("success")).getText());
			}
		}

		WebElement insertButton = Browser.driver.findElement(By.xpath("//div[contains(@class, 'button')]//a"));
		insertButton.click();
		WebElement productName = Browser.driver.findElement(By.name("product_description[1][name]"));
		productName.sendKeys(ProductName);
		WebElement metaTagDescription = Browser.driver.findElement(By.name("product_description[1][meta_description]"));
		metaTagDescription.sendKeys(MetaTagDescription);
		WebElement metaTagKeywords = Browser.driver.findElement(By.name("product_description[1][meta_keyword]"));
		metaTagKeywords.sendKeys(MetaTagKeywords);
		WebElement productTags = Browser.driver.findElement(By.name("product_description[1][tag]"));
		productTags.sendKeys(ProductTags);
		WebElement Data = Browser.driver.findElement(By.linkText("Data"));
		Data.click();
		WebElement productModel = Browser.driver.findElement(By.name("model"));
		productModel.sendKeys(ProductModel);
		WebElement productSku = Browser.driver.findElement(By.name("sku"));
		productSku.sendKeys(ProductSku);
		WebElement productUps = Browser.driver.findElement(By.name("upc"));
		productUps.sendKeys(ProductUps);
		WebElement productEan = Browser.driver.findElement(By.name("ean"));
		productEan.sendKeys(ProductEan);
		WebElement productJan = Browser.driver.findElement(By.name("jan"));
		productJan.sendKeys(ProductJan);
		WebElement productIsbn = Browser.driver.findElement(By.name("isbn"));
		productIsbn.sendKeys(ProductIsbn);
		WebElement productMpn = Browser.driver.findElement(By.name("mpn"));
		productMpn.sendKeys(ProductMpn);
		WebElement productLocation = Browser.driver.findElement(By.name("location"));
		productLocation.sendKeys(ProductLocation);
		WebElement productPrice = Browser.driver.findElement(By.name("price"));
		productPrice.sendKeys(ProductPrice);
		WebElement taxClassDropDown = Browser.driver.findElement(By.name("tax_class_id"));
		Select taxClassList = new Select(taxClassDropDown);
		taxClassList.selectByValue(TaxClassListDefault9);
		WebElement productQuantity = Browser.driver.findElement(By.name("quantity"));
		productQuantity.clear();
		productQuantity.sendKeys(ProductQuantity);
		WebElement productMinimumQuantity = Browser.driver.findElement(By.name("minimum"));
		productMinimumQuantity.clear();
		productMinimumQuantity.sendKeys(ProductMinimumQuantity);
		WebElement subTractDropDown = Browser.driver.findElement(By.name("subtract"));
		Select subTractList = new Select(subTractDropDown);
		subTractList.selectByValue(SubTractList1YES0NO);
		WebElement stockStatus = Browser.driver.findElement(By.name("stock_status_id"));
		Select stockStatusList = new Select(stockStatus);
		stockStatusList.selectByValue(StockStatus);
		WebElement shippingRadioButton = Browser.driver.findElement(By.name("shipping"));
		if (!shippingRadioButton.isSelected())
			shippingRadioButton.click();
		assertTrue(shippingRadioButton.isSelected());
		WebElement productSeokeyword = Browser.driver.findElement(By.name("keyword"));
		productSeokeyword.sendKeys(ProductSeokeyword);
		WebElement productDateAvailable = Browser.driver.findElement(By.name("date_available"));
		productDateAvailable.clear();
		productDateAvailable.sendKeys(ProductDateAvailableYYYYMMDD);
		WebElement productDimensionsLenght = Browser.driver.findElement(By.name("length"));
		productDimensionsLenght.sendKeys(ProductDimensionsLenght);
		WebElement productDimensionsWidth = Browser.driver.findElement(By.name("width"));
		productDimensionsWidth.sendKeys(ProductDimensionsWidth);
		WebElement productDimensionsHeight = Browser.driver.findElement(By.name("height"));
		productDimensionsHeight.sendKeys(ProductDimensionsHeight);
		WebElement lengthClassDropDown = Browser.driver.findElement(By.name("length_class_id"));
		Select lengthClass = new Select(lengthClassDropDown);
		lengthClass.selectByValue(LengthClass1cm2mm3inch);
		WebElement productWeight = Browser.driver.findElement(By.name("weight"));
		productWeight.sendKeys(ProductWeight);
		WebElement weightClassDropDown = Browser.driver.findElement(By.name("weight_class_id"));
		Select weightClass = new Select(weightClassDropDown);
		weightClass.selectByValue(WeightClass1Kg2Gr5Po6Ou);
		WebElement productStatus = Browser.driver.findElement(By.name("status"));
		Select status = new Select(productStatus);
		status.selectByValue(ProductStatus1Enab0Disab);
		WebElement productSortOrder = Browser.driver.findElement(By.name("sort_order"));
		productSortOrder.clear();
		productSortOrder.sendKeys(ProductSortOrder);
		WebElement links = Browser.driver.findElement(By.linkText("Links"));
		links.click();
		WebElement productManufacturer = Browser.driver.findElement(By.name("manufacturer"));
		productManufacturer.sendKeys(ProductManufacturer);

		WebElement productCategories = Browser.driver.findElement(By.name("category"));
		productCategories.sendKeys(ProductCategories);
		productCategories = WaitTool.waitForElementPresent(Browser.driver,
				By.xpath("//li[contains(@class, 'ui-menu-item')]"), 10);
		productCategories.findElement(By.xpath("//li[contains(@class, 'ui-menu-item')]")).click();

		WebElement attribute = Browser.driver.findElement(By.linkText("Attribute"));
		attribute.click();
		WebElement addAttributeButton = Browser.driver.findElement(By.linkText("Add Attribute"));
		addAttributeButton.click();
		WebElement productAddAttribute = Browser.driver.findElement(By.name("product_attribute[0][name]"));
		productAddAttribute.sendKeys(ProductAddAttribute);
		WebElement productAddAttributeText = WaitTool.waitForElement(Browser.driver,
				By.name("product_attribute[0][product_attribute_description][1][text]"), 10);
		productAddAttributeText.sendKeys(ProductAddAttributeText);
		WebElement addAttributeButton1 = Browser.driver.findElement(By.linkText("Add Attribute"));
		addAttributeButton1.click();
		WebElement productOptionTab = Browser.driver.findElement(By.linkText("Option"));
		productOptionTab.click();
		WebElement saveButton = Browser.driver.findElement(By.linkText("Save"));
		saveButton.click();
	}

	public static void verifyInsertNewProduct(String messageOnFailure, String expectedValidationMessage) {
		String actualValidationMessage = null;
		try {
			WebElement validationMessage = Browser.driver.findElement(By.className("success"));
			actualValidationMessage = validationMessage.getText();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			Assert.fail("There was a missing web element on the page");
		}

		Assert.assertEquals(messageOnFailure, expectedValidationMessage, actualValidationMessage);
	}
}

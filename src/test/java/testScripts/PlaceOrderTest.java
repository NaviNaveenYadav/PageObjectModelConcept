package testScripts;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductsListPage;

public class PlaceOrderTest {

	WebDriver driver;
	LoginPage loginPage;
	ProductsListPage productsListPage;
	CartPage cartPage;
	CheckoutPage checkoutPage;
	
	public PlaceOrderTest() {
		TestBase.initDriver();
		driver = TestBase.getDriver();
		
		loginPage = new LoginPage(driver);	
		productsListPage = new ProductsListPage(driver);
		cartPage = new CartPage(driver);
		checkoutPage = new CheckoutPage(driver);
	}
	
	@BeforeTest
	public void setup() {
		TestBase.openUrl("https://www.saucedemo.com/");
		loginPage.loginIntoApp("standard_user", "secret_sauce");
	}
	
	@Test
	public void addItem() {
		
		productsListPage.addToCart();
		productsListPage.viewCart();
		Assert.assertTrue(cartPage.isItemAdded());
	}
	
	@Test
	public void checkoutItems() {
		cartPage.checkoutItems();
	}
	
	@Test
	public void placeOrder() {
		checkoutPage.addDetails();
	}
	
	@Test
	public void submitOrder() {
		checkoutPage.overView();
	}
	
	@Test
	public void successMsg() {
		checkoutPage.successMsg();
	}
	
	@Test
	public void tearDown() {
		TestBase.tearDown();
	}
	
}

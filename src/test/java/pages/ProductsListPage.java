package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsListPage {

	@FindBy(xpath = "//div[@id='header_container']//div[@class='header_label']/div")
	WebElement mainHeader;
	
	@FindBy(xpath = "//div[@id='header_container']//div[contains(@class,'header_secondary')]/span")
	WebElement subHeader;
	
	@FindBy(xpath = "//button[contains(@id,'sauce-labs-bolt-t-shirt')]")
	WebElement itemOne;
	
	@FindBy(id = "shopping_cart_container")
	WebElement cartIcon;
	
	public ProductsListPage(WebDriver driver) {
		PageFactory.initElements(driver, this);		
	}
	
	
	public void addToCart() {
		itemOne.click();
	}
	
	public void viewCart() {
		cartIcon.click();
	}
	
	
	
	
}

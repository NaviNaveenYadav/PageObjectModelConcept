package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

	@FindBy(css = "div.cart_item")
	WebElement cartList;
	
	@FindBy(id = "remove-sauce-labs-bolt-t-shirt")
	WebElement rmvBtn;
	
	@FindBy(css = "button#continue-shopping")
	WebElement conBtn;
	
	@FindBy(css = "button#checkout")
	WebElement chkoutBtn;
	
	
	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public boolean isItemAdded() {
		return cartList.isDisplayed();
	}
	
	
	
	public void checkoutItems() {
		chkoutBtn.click();
	}
	
}

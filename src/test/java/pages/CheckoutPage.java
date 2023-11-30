package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CheckoutPage {

	@FindBy(id = "first-name")
	WebElement firstName;
	
	@FindBy(id = "last-name")
	WebElement lastName;
	
	@FindBy(name = "postalCode")
	WebElement zipCode;
	
	@FindBy(xpath = "//input[@id='continue']")
	WebElement continueBtn;
	
	@FindBy(css = "button#finish")
	WebElement finishCTA;
	
	@FindBy(css = "h2.complete-header")
	WebElement successMsg;
	
	public CheckoutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public void addDetails() {
		firstName.sendKeys("Naveen");
		lastName.sendKeys("Vaddarapu");
		zipCode.sendKeys("111111");
		continueBtn.click();
	}
	
	public void overView() {
		finishCTA.click();
	}
	
	public void successMsg() {
		Assert.assertEquals(successMsg.getText(), "Thank you for your order!");
		System.out.println("Completed.....");
	}
	
}

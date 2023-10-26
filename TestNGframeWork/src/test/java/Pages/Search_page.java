package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Commons.Common_methods;

public class Search_page extends Common_methods {
	@FindBy(xpath = "//h2[contains(text(),'Products meeting th')]")
	WebElement texttitle;
	@FindBy(linkText = "Search in subcategories")
	WebElement subcategories;

	public void click_subcategories() {
		explecit_wait(subcategories);
		log.info("wait for Subcategories");
		javascript_click(subcategories);
		log.info("clicked on subcategories");
		
	}

	public Search_page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

}

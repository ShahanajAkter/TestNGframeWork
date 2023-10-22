package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Commons.Common_methods;


public class HomePage extends Common_methods {
	@FindBy(xpath="//input[@class='form-control input-lg']")WebElement searchfield;
	@FindBy(xpath = "//button[@class='btn btn-default btn-lg']")WebElement searchbtn;
	public void clickSearchfield() {
		explecit_wait(searchfield);
		log.info("wait for search field");
		javascript_click(searchfield);
		log.info("Clicked on search field");
	}
		public void type_onSearchfield(String type) {
			explecit_wait(searchfield);
			log.info("wait for search field");
		searchfield.sendKeys(type);
		log.info("type on search field");
	}
	public void clicksearchbtn() {		
		
		explecit_wait(searchbtn);
		log.info("wait for search button");
		javascript_click(searchbtn);
		log.info("Clicked the search button");
		Search_page Sp= new Search_page(driver);
		Sp.click_subcategories();
		test.info("clicked on subcategories");
		test.addScreenCaptureFromPath(screenshotsforExtentRe("er_ss"));
		
	}

	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
}

package TestNG;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import UtilityPackage.Utility;


public class Search_FeatureTest extends Utility{
	
  @Test(priority = 1,threadPoolSize = 3,groups = "Smoke")
  public void Validate_Search_button_functional() throws IOException, InterruptedException {
	  test=reports.createTest("Validate Search button functional").assignAuthor("Shanu").assignCategory("Smoke").assignDevice("windows 11","Chrome");
	  String actual_title= driver.getTitle();
	  test.info("capture the page title as:"+actual_title);
	  log.info("capture page title as :"+actual_title);
	  String expected_page_title="Your Store";
	  log.info("capturing page title");
	  
	  Assert.assertEquals(actual_title, expected_page_title, "the title is varified");
	  //test.addScreenCaptureFromPath(screenshotsforExtentRe("er_ss"),"test pass");
	  screenshotsforExtentRe("er_ss");
	  
	 Thread.sleep(2000);
	 HomePage hp= new HomePage(driver);
	  hp.clickSearchfield();
	  test.info("Clicked on search field");
	  hp.type_onSearchfield("computer");
	  test.info("typed on search field");
	  hp.clicksearchbtn();
	  test.info("Clicked on search button");
	 // test.addScreenCaptureFromPath(screenshotsforExtentRe("er_ss"),"test pass");
	  screenshotsforExtentRe("er_ss");
	  
  }

	@Test(priority = 2,threadPoolSize = 3,groups = "Smoke")  
public void ValidateProducts_meeting_the_search_criteria_IsPresent() throws InterruptedException {
		
		 test=reports.createTest("Validate Products meeting the search criteria Is Present").assignAuthor("Shanu").assignCategory("Smoke").assignDevice("windows 11","Chrome");
		HomePage hp= new HomePage(driver);
		hp.clicksearchbtn();
		Thread.sleep(1000);
boolean text=	driver.findElement(By.xpath("//h2[contains(text(),'Products meeting th')]")).isDisplayed();
	if(text==true) {
		driver.findElement(By.xpath("//h2[contains(text(),'Products meeting th')]")).getText();
		log.info(text +"text varified");
		System.out.println(driver.findElement(By.xpath("//h2[contains(text(),'Products meeting th')]")).getText());
		//test.addScreenCaptureFromPath(screenshotsforExtentRe("er_ss"),"text varified");
		screenshotsforExtentRe("er_ss");
	}
	else {
		
		log.error("text not found",new Exception("text not visible"));
		test.fail("text not matched");
		//test.addScreenCaptureFromPath(screenshotsforExtentRe("er_ss"));
		screenshotsforExtentRe("er_ss");
	}
}
@Test(priority = 3,threadPoolSize = 2,groups = "Sanity")
public void ValidateInput_withLeading_and_TrailingSpaces() throws InterruptedException {
	 test=reports.createTest("ValidateInput_withLeading_and_TrailingSpaces").assignAuthor("Shanu").assignCategory("Smoke").assignDevice("windows 11","Chrome");  
	 HomePage hp= new HomePage(driver);
	 hp.clickSearchfield();
	 test.pass("Clicked on search field");
	 hp.type_onSearchfield("Phone %");
	 test.info("typed on search field");
	 Thread.sleep(200);
	 hp.clicksearchbtn();
	 test.info("Clicked on search button");
	 test.pass("test varified");
	 screenshotsforExtentRe("er_ss");



}
@Test(priority = 4,threadPoolSize = 3,groups = "Smoke")
public void Validate_SearchInSubcategories_is_clickable() {
	 test=reports.createTest("Validate_SearchInSubcategories_is_clickable").assignAuthor("Shanu").assignCategory("Smoke").assignDevice("windows 11","Chrome");
	 HomePage hp= new HomePage(driver);
	 hp.clicksearchbtn();
	 test.info("Search button is clicked");
	 screenshotsforExtentRe("er_ss");
	 
}
@Test(priority = 5,threadPoolSize = 3,groups = "Regression")
public void Assert_Sort_option() {
	 test=reports.createTest("Assert_Sort_option").assignAuthor("Shanu").assignCategory("Regression").assignDevice("windows 11","Chrome");
	  
}
@Test(priority = 6,threadPoolSize = 2,groups = "Smoke")
public void Validate_feature_returns_Accurate_Relevant_Results () {
	 test=reports.createTest("Validate_feature_returns_Accurate_Relevant_Results").assignAuthor("Shanu").assignCategory("Smoke").assignDevice("windows 11","Chrome");
	  
}
@Test(priority = 7,threadPoolSize = 3,groups = "Sanity")
public void ValidateSearch_with_SearchInProductDescriptions(){
	 test=reports.createTest("ValidateSearch_with_SearchInProductDescriptions").assignAuthor("Shanu").assignCategory("Smoke").assignDevice("windows 11","Chrome");
  
}
@Test(priority = 8,threadPoolSize = 3,groups = "Sanity")
public void Validate_Search_without_SearchInProductDescriptions() {
	 test=reports.createTest("Validate_Search_without_SearchInProductDescriptions").assignAuthor("Shanu").assignCategory("Smoke").assignDevice("windows 11","Chrome");
	  
}
@Test(priority = 9,threadPoolSize = 3,groups = "Smoke")
public void Assert_Empty_search_query() {
	 test=reports.createTest("Assert_Empty_search_query").assignAuthor("Shanu").assignCategory("Sanity").assignDevice("windows 11","Chrome");
	  
}
@Test(priority = 10,threadPoolSize = 3,groups = "Smoke")
public void Validate_Pagination() {

	 test=reports.createTest("Validate_Pagination").assignAuthor("Shanu").assignCategory("Sanity").assignDevice("windows 11","Chrome"); 
}


}











package UtilityPackage;

import org.testng.annotations.Test;

import com.aventstack.extentreports.reporter.configuration.Theme;

import Commons.Common_methods;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;

public class Utility  extends Common_methods{
  @Parameters({"browser","websiteUrl"})
  @BeforeClass
  public void beforeClass(String nameofBrowser, String url) {
	  ibrowser(nameofBrowser, url);
	  log.info("land on homePage");
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
	  log.info("browser close");
  }

  @BeforeTest
  public void beforeTest() {
	repoter.config().setTheme(Theme .STANDARD);
	repoter.config().setDocumentTitle("ExtentReport_Shanu");;
	reports.attachReporter(repoter);
  }
 

  @AfterTest
  public void afterTest() {

	  reports.flush();

} 
}
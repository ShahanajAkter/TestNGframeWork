package Extent_pack;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class NewTest {
	
	  ExtentReports reports = new ExtentReports();
	  ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReport/Shanu"+System.currentTimeMillis() +".html");
  ExtentTest test;
	  @Test
  public void f() {
	test=  reports.createTest("Validate Search button");
  }
	  public void test1() {
		  
	  test= reports.createTest("ValidateProducts_meeting_the_search_criteria");
	  }
	  
	  public void test2() {
		test=	reports.createTest("ValidateInput_withLeading_and_TrailingSpaces");
			test.log(Status.PASS, "Validate Input withLeading and TrailingSpaces" );
			test.pass("ValidateInput_withLeading_and_TrailingSpaces");
			test.info("ValidateInput_withLeading_and_TrailingSpaces");
	  }
	  public void test3() {
		test=  reports.createTest("validate *********");
		test.pass("its pass");
		test.fail("its not worked");
		test.info("nedd to provide same data");
		test.warning("alert box pop up");
		test.skip("skip the add");
		test.assignAuthor("shanu").assignCategory("SmokeTest").assignDevice("windows11","chrome");
	  	  
	  }
  @BeforeTest
  public void beforeTest() {
	
	  reports.attachReporter(spark);
  }

  @AfterTest
  public void afterTest() {
	  reports.flush();
  }

}

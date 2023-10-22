package Listener_Pack;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import Commons.Common_methods;

public class IListerners extends Common_methods implements ITestListener{
	@Override
	public void onStart(ITestContext context) {
		configureReport();
	}

	@Override
	public void onFinish(ITestContext context) {
		reports.flush();
		log.info("after finishing testing methods");
		
	}
	
	@Override
	public void onTestStart(ITestResult result) {
	test=reports.createTest(result.getName()).assignAuthor("shanu").assignCategory("Smoke").assignDevice("windows 11","Chrome");
		System.out.println("before every test methods first step of start"+result.getName());
		
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	

	@Override
	public void onTestSuccess(ITestResult result) {
		
		this.driver=((Common_methods)result.getInstance()).driver;
	test=	reports.createTest(result.getName());
	test.log(Status.PASS, MarkupHelper.createLabel("Name of the method that passed is: "+result.getName(), ExtentColor.LIME));	
	screenshots("passed");
			log.info("test passed and screenshots taken");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		this.driver=((Common_methods)result.getInstance()).driver;
		test=	reports.createTest(result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel("Name of the method that failed is: "+result.getName(), ExtentColor.RED));
			log.info("test failed and screenshots taken");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test=	reports.createTest(result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel("Name of the method that skiped is: "+result.getName(), ExtentColor.BROWN));
		this.driver=((Common_methods)result.getInstance()).driver;
	}

}

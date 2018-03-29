package com.ewbautomation.base;

import java.io.File;
import java.lang.reflect.Method;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.ewb.utils.ConfigManager;
import com.ewb.utils.Log;

public class BaseTest {
	public static ConfigManager config;
	final String PROPERTIES_FILE = "/properties/Input.properties";
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public BaseTest() {
	}

	@BeforeSuite(alwaysRun = true)
	public final void mandatoryBeforeSuite(ITestContext context) {
		config = ConfigManager.getInstance(PROPERTIES_FILE);	
		String workingDir = System.getProperty("user.dir");
        extent = new ExtentReports(workingDir+"//target//TestExecutionResults.html", true);
        extent.loadConfig(new File(workingDir+"//src/main//java//com//ewbautomation//utils//ExtentReport//reportconfig.xml"));
	}

	@AfterSuite(alwaysRun = true)
	public final void mandatoryAfterSuite(ITestContext context) {
		Log.info("************ Suite execution completed *************");
		extent.flush();
	}

	@BeforeMethod
	public void mandatoryBeforeMethod(Method method) {
		test = extent.startTest((this.getClass().getSimpleName() + " :: "+method.getName()), method.getName());
		test.log(LogStatus.INFO, "Started Test"+ method.getName());
		Log.info("Started test case "+method.getName());
	}

	@AfterMethod
	public void mandatoryAfterMethod(ITestResult result, Method method) {
		Log.info("Finished test case "+method.getName());
		test.log(LogStatus.INFO, "Finished Test"+ method.getName());
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(LogStatus.FAIL, "TEST CASE IS FAILED"); // to add name in extent report
			test.log(LogStatus.FAIL, "TEST CASE IS FAILED WITH REASON " + result.getThrowable()); // to add error/exception in
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(LogStatus.SKIP, "TEST CASE IS SKIPPED ");
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(LogStatus.PASS, "TEST CASE IS PASED");

		}
		extent.endTest(test);
	}

	@BeforeClass
	public void mandatoryBeforeClass() {
		Log.startTestCase(this.getClass().getName());
	}

	@AfterClass
	public void mandatoryAfterClass() {
		Log.endTestCase(this.getClass().getName());
	}

}

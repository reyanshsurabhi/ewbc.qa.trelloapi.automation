package com.ewb.utils.Listeners;
 
import com.relevantcodes.extentreports.LogStatus;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.ewb.base.BaseTest;
import com.ewb.utils.Log;
import com.ewb.utils.ExtentReport.ExtentManager;
import com.ewb.utils.ExtentReport.ExtentTestManager;
 
 
public class TestListener extends BaseTest implements ITestListener {
 
    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }
    
    //Before starting all tests, below method runs.
    public void onStart(ITestContext iTestContext) {
    	Log.info("Started Test " + iTestContext.getName());
    	//ExtentManager.getReporter().addSystemInfo(info)
    }
 
    //After ending all tests, below method runs.
    public void onFinish(ITestContext iTestContext) {
    	Log.info("Finished Test " + iTestContext.getName());
        //Do tier down operations for extentreports reporting!
        ExtentTestManager.endTest();
        ExtentManager.getReporter().flush();
    }
 
    public void onTestStart(ITestResult iTestResult) {
        Log.info("Execution started *** " +  getTestMethodName(iTestResult));
        //Start operation for extentreports.
        ExtentTestManager.startTest(iTestResult.getMethod().getMethodName(),"");
    }
 
    public void onTestSuccess(ITestResult iTestResult) {
    	Log.info("Exceution Finished **** " +  getTestMethodName(iTestResult) + " *** With Status :: Success");
        //Extentreports log operation for passed tests.
        ExtentTestManager.getTest().log(LogStatus.PASS, "Test passed");
    }
    
    public void onTestFailure(ITestResult iTestResult) {
    	Log.info("Exceution Finished *** " +  getTestMethodName(iTestResult) + " *** With Status :: Failed");
 
        //Get driver from BaseTest and assign to local webdriver variable.
        Object testClass = iTestResult.getInstance();
        //Extentreports log and screenshot operations for failed tests.
        ExtentTestManager.getTest().log(LogStatus.FAIL,"Test Failed");
    }
 
    public void onTestSkipped(ITestResult iTestResult) {
    	Log.info("Exceution Finished *** "+  getTestMethodName(iTestResult) + " *** With Status :: Skipped");
        //Extentreports log operation for skipped tests.
    	Object testClass = iTestResult.getInstance();
        ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped");
    }
 
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
    	Log.info("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
    }
 
}
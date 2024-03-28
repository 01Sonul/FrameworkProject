package vtiger.GenericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class will provide implementation to iTestListener interface
 * @author HP
 *
 */
public class ListenersImplementation implements ITestListener{
	
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+ " Test script execution started");
		
		//Create a test in extent report
		test = report.createTest(methodName);	
		
	}

	public void onTestSuccess(ITestResult result) {
		
		String methodName = result.getMethod().getMethodName();
		//System.out.println(methodName + " PASS");
		
		test.log(Status.PASS, methodName + " PASS");
		
	}

	public void onTestFailure(ITestResult result) {
		
		WebDriverUtility w = new WebDriverUtility();		//for taking screenshot
		JavaUtility j = new JavaUtility();					//whats the time when the screenshot is taken
		
		String methodName = result.getMethod().getMethodName();
		String screenShotName = methodName+j.getSystemDate();	//to give the parameter of the method inside WebDriverUtility
		
		//System.out.println(result.getThrowable()); 		//this will show why the test script got failed
		//System.out.println(methodName + " FAIL");
		
		test.log(Status.INFO, result.getThrowable());
		test.log(Status.FAIL, methodName + " FAIL");
		
		try {
			w.captureScreenShot(BaseClass.sdriver, screenShotName);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		
		//System.out.println(result.getThrowable());		///this will show why the test script got skipped
		
		String methodName = result.getMethod().getMethodName();
		//System.out.println(methodName + " SKIP");
		
		test.log(Status.INFO, result.getThrowable());
		test.log(Status.SKIP, methodName + " SKIP");
	}

	public void onStart(ITestContext context) {
		System.out.println("Suite execution started");
		
		//Configure the extent Reports
		ExtentSparkReporter htmlReport = new ExtentSparkReporter(".\\ExtendReports\\Report-"+ new JavaUtility().getSystemDate()+".html");
		htmlReport.config().setDocumentTitle("Vtiger Execution Report");
		htmlReport.config().setReportName("Automation Execution Report");
		htmlReport.config().setTheme(Theme.DARK);
		
		report = new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base Platform", "Windows");
		report.setSystemInfo("Base Browser", "Edge");
		report.setSystemInfo("Base URL", "https://localhost:8888");
		report.setSystemInfo("Base Environment", "Testing");
		report.setSystemInfo("Reporter Name", "Sanghamitra");
		
		
	}

	public void onFinish(ITestContext context) {
		System.out.println("Suite Execution finished");
		
		//this method will generate the report after execution
		report.flush();
		
	}
	
	

}

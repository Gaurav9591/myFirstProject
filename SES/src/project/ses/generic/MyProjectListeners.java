package project.ses.generic;

import java.io.File;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;



public class MyProjectListeners implements ITestListener, WebDriverEventListener{
	public static int iPassCount=0;
	public static int iFailCount=0;
	public Logger eoddLogs;
	long startTime, stopTime;
	
public MyProjectListeners() {
	DateFormat dateFormat=new SimpleDateFormat("yy_MM_dd");
	Date date=new Date();
	System.setProperty("timeStamp", dateFormat.format(date));
	eoddLogs=Logger.getLogger(this.getClass());
	PropertyConfigurator.configure("log4j.properties");
}

	//IExecutionListener

	//ITestListener
	public void onFinish(ITestContext arg0) {
		stopTime=System.currentTimeMillis();
		eoddLogs.info("Test Suite execution finished: "+new Timestamp
				(new Date().getTime()));
		eoddLogs.info("Total time for test suite execution: "+
				(double)(stopTime-startTime)/1000+"seconds");
	}
	//ITestListener
	public void onStart(ITestContext arg0,ITestResult a) {
		startTime=System.currentTimeMillis();
		eoddLogs.info("Test Suite Execution started: "+new Timestamp
				(new Date().getTime()));
	}
	//ITestListener
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		eoddLogs.info("Test failed within success percentage");
	}
	//ITestListener
	
	public void onTestFailure(ITestResult result) {
		iFailCount++;
		System.out.println("Test Failure:"+ iFailCount);
		eoddLogs.info("Test has been failed");
		BaseLib obj= (BaseLib) result.getInstance();
		DateFormat dateFormat=new SimpleDateFormat("yy_MM_dd_hh_mm_ss");
		Date date=new Date();
		try{
			String fileName=result.getMethod().getMethodName().replace("Test", "");
			TakesScreenshot screenShots=(TakesScreenshot) obj.driver;
			File srcFile = screenShots.getScreenshotAs(OutputType.FILE);
			File destFile=new File(".//Screenshots//failed//failedScreenshotsFor_"+fileName+
					"_"+dateFormat.format(date)+".png");
			FileUtils.copyFile(srcFile, destFile);
			File[] screenshots = new File(".\\Screenshots\\failed").listFiles();
			if(screenshots.length!=0){
				Arrays.sort(screenshots,LastModifiedFileComparator.LASTMODIFIED_REVERSE);
			//	obj.test.log(LogStatus.INFO,"<a href='file:///"+screenshots[0].getAbsolutePath()+"'>Click here to see <b>Failed </b> screenshots </a>");
			}
		}
		catch(Exception e){
			eoddLogs.error("Error: "+e);
		}
	}
	//ITestListener
		public void onTestSkipped(ITestResult result) {
		eoddLogs.info("Test has been skipped: "+result.getName());
	}
	//ITestListener
	public void onTestStart(ITestResult arg0) {
		eoddLogs.info("Test execution has been started: "+new Timestamp(new Date().getTime()));
	}
	//ITestListener

	public void onTestSuccess(ITestResult result) {
		iPassCount++;
		System.out.println("Test Pass: "+iPassCount);
		eoddLogs.info("TestScript Name: '"+result.getName()+"' /Status--->Pass :)");
	//	BaseLib obj= (BaseLib) result.getInstance();
	//	DateFormat dateFormat=new SimpleDateFormat("yy_MM_dd_hh_mm_ss");
	//	Date date=new Date();
		/*try{
			String fileName=result.getMethod().getMethodName().replace("Test", "");
			TakesScreenshot screenShots=(TakesScreenshot) obj.driver;
			File srcFile = screenShots.getScreenshotAs(OutputType.FILE);
			File destFile=new File(".\\Screenshots\\passed\\passedScreenshotFor_"+fileName+
					"_"+dateFormat.format(date)+".png");
			FileUtils.copyFile(srcFile, destFile);
			File[] screenshots = new File(".\\Screenshots\\passed").listFiles();
			if(screenshots.length!=0){
				Arrays.sort(screenshots,LastModifiedFileComparator.LASTMODIFIED_REVERSE);
				//obj.test.log(LogStatus.INFO,"<a href='file:///"+screenshots[0].getAbsolutePath()+"'>Click here to see <b>Passed </b> screenshots </a>");
			}
		}
		catch(Exception e){
			eoddLogs.error("Error: "+e);
		}*/
	}

	//WebDriverEventListener
	public void afterChangeValueOf(WebElement arg0, WebDriver arg1) {

	}
	//WebDriverEventListener
	public void afterClickOn(WebElement arg0, WebDriver arg1) {

	}
	//WebDriverEventListener
	public void afterFindBy(By arg0, WebElement arg1, WebDriver arg2) {

	}
	//WebDriverEventListener
	public void afterNavigateBack(WebDriver arg0) {

	}
	//WebDriverEventListener
	public void afterNavigateForward(WebDriver arg0) {

	}
	//WebDriverEventListener
	public void afterNavigateRefresh(WebDriver arg0) {

	}
	//WebDriverEventListener
	public void afterNavigateTo(String arg0, WebDriver arg1) {

	}
	//WebDriverEventListener
	public void afterScript(String arg0, WebDriver arg1) {

	}
	//WebDriverEventListener
	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1) {

	}
	//WebDriverEventListener
	
	public void beforeClickOn(WebElement arg0, WebDriver arg1) {

	}
	//WebDriverEventListener
	
	public void beforeFindBy(By arg0, WebElement arg1, WebDriver arg2) {

	}
	//WebDriverEventListener
	
	public void beforeNavigateBack(WebDriver arg0) {

	}
	//WebDriverEventListener
	
	public void beforeNavigateForward(WebDriver arg0) {

	}
	//WebDriverEventListener
	
	public void beforeNavigateRefresh(WebDriver arg0) {

	}
	//WebDriverEventListener
	
	public void beforeNavigateTo(String arg0, WebDriver arg1) {

	}
	//WebDriverEventListener
	
	public void beforeScript(String arg0, WebDriver arg1) {

	}
	//WebDriverEventListener
	
	public void onException(Throwable t, WebDriver arg1) {
		eoddLogs.fatal("Execution interrupted....");
		eoddLogs.fatal(t.getMessage());
	}

	public void afterAlertAccept(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void afterAlertDismiss(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void afterChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		// TODO Auto-generated method stub
		
	}

	public void beforeAlertAccept(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void beforeAlertDismiss(WebDriver arg0) {
		// TODO Auto-generated method stub
		
	}

	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		// TODO Auto-generated method stub
		
	}

	
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
}

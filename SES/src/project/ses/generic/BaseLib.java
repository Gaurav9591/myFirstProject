package project.ses.generic;

import static project.ses.generic.MyProjectListeners.iFailCount;
import static project.ses.generic.MyProjectListeners.iPassCount;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class BaseLib {
	//public ExtentHtmlReporter htmlRepoter;
	public ExtentTest test;
	//public ExtentReports extent;
	//public ExtentTest childTest;
	public WebDriver wDriver;
	public EventFiringWebDriver driver;
	MyProjectListeners listeners;	
	public Date date = new Date() ;
	
	 ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	@BeforeTest
	public void configBT(){
		
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd-HH");
		
//report=new ExtentReports(".\\reports\\extentreports\\extentreport"+dateFormat.format(date) +".html")
 		
htmlReporter = new ExtentHtmlReporter("C:\\Users\\gaurav.kumar\\eclipse-workspace-1\\SES\\reports\\automation-report"+dateFormat.format(date)+".html");
        
    extent = new ExtentReports();
    extent.attachReporter(htmlReporter);	
    extent.setSystemInfo("OS", "windows 7");
    extent.setSystemInfo("Browser", "Chrome");
    extent.setSystemInfo("Automated By", "Gaurav");
    htmlReporter.config().setChartVisibilityOnOpen(true);
    htmlReporter.config().setDocumentTitle("SES Automation Report");
    htmlReporter.config().setReportName("SES Tests");
    htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
    htmlReporter.config().setTheme(Theme.DARK);
    htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
		
		
	}
	@BeforeMethod
	@Parameters(value="browser")
	public void preCondition(String browser){
		if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver.exe");
			wDriver  =new FirefoxDriver();
		//	WebDriver  wdriver = new FirefoxDriver();
			
			listeners=new MyProjectListeners();
			driver=new EventFiringWebDriver(wDriver);
			driver.register(listeners);
			Reporter.log("Firefox launched", true);
		}
		else if(browser.equals("chrome")){
			System.out.println("chrome");
			System.setProperty("webdriver.chrome.driver", 
								".\\drivers\\chromedriver.exe");
			wDriver=new ChromeDriver();
			listeners=new MyProjectListeners();
			driver=new EventFiringWebDriver(wDriver);
			driver.register(listeners);
			Reporter.log("Chrome launched", true);
		}
		else if(browser.equals("ie")){
			System.setProperty("webdriver.ie.driver", 
							".\\drivers\\IEDriverServer.exe");
			wDriver=new InternetExplorerDriver();
			listeners=new MyProjectListeners();
			driver=new EventFiringWebDriver(wDriver);
			driver.register(listeners);
			Reporter.log("IE launched", true);
		}
		else{
			wDriver=new FirefoxDriver();
			listeners=new MyProjectListeners();
			driver=new EventFiringWebDriver(wDriver);
			driver.register(listeners);
			Reporter.log("Firefox launched", true);
		}
		driver.manage().window().maximize();
		System.out.println("hello");
		System.out.println(GetPropertyValues.getPropertyValue("testUrl"));
		driver.get(GetPropertyValues.getPropertyValue("testUrl"));
		Reporter.log("Navigating to url", true);
		WaitStatementLib.implicitWaitForSeconds(driver, 20);
	}
	@AfterMethod
	public void postCondition(){
		htmlReporter.flush();
		extent.flush();
		
		driver.quit();
		Reporter.log("Browser closed", true);
	/*	File[] htmlfiles = new File(".\\reports\\html").listFiles();
		if(htmlfiles.length!=0){
			Arrays.sort(htmlfiles,LastModifiedFileComparator.LASTMODIFIED_REVERSE);
	//test.log(LogStatus.INFO,"<a href='file:///"+htmlfiles[0].getAbsolutePath()+"'>Click here to see <b>HTML</b> logs </a>");
		}
		File[] logsFiles = new File(".\\reports\\logs").listFiles();
		if(logsFiles.length!=0){
			Arrays.sort(logsFiles,LastModifiedFileComparator.LASTMODIFIED_REVERSE);
//test.log(LogStatus.INFO,"<a href='file:///"+logsFiles[0].getAbsolutePath()+"'>Click here to see <b>LOGs</b> </a>");
		}
		*/
	htmlReporter.flush();
		extent.flush();
	}
	@AfterSuite
	public void configAfterSuite()
	{   

		Reporter.log("Runninng After Suite: ", true);
		DateFormat dateFormat = new SimpleDateFormat("yy_MM_dd_hh");
		Date date = new Date();	
		String TimeStamp = dateFormat.format(date);
		String XlPath = ".//reports//excelreports//Report"+TimeStamp+".xlsx";
		FileOutputStream Fos;
		try {
			Fos = new FileOutputStream(XlPath);
			Workbook wb = new HSSFWorkbook();
			Sheet s = wb.createSheet();
			ExcelUtils.writeData(s, 0, "Total:", iPassCount+iFailCount);
			ExcelUtils.writeData(s, 1, "Pass:", iPassCount);
			ExcelUtils.writeData(s, 2, "Fail:", iFailCount);	
			
			
			try 
			{
				wb.write(Fos);
			}
			catch (IOException e)
			{
				Reporter.log("Unable to write messages to Excel", true);
				e.printStackTrace();
			}
			wb.close();
		} catch (FileNotFoundException e) 
		{
			Reporter.log("Excel file is not creating ", true);
		} catch (IOException e) {
			e.printStackTrace();
		}		

	}

}

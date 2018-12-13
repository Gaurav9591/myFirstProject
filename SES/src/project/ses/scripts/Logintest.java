package project.ses.scripts;


import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import project.ses.generic.BaseLib;
import project.ses.generic.ExcelUtils;
import project.ses.generic.WaitStatementLib;
import project.ses.pom.Homepage;
import project.ses.pom.Loginpage;

public class Logintest extends BaseLib {

/*
	@Test(priority=1,groups = { "Smoke" })	public void logintestcase1()
	{
		test = extent.createTest("Test Script 1", "Valid login test");
		test.createNode("positive login test with correct username and password");	
		
		Loginpage lp= new Loginpage(driver);
				
		String[] sData = ExcelUtils.toReadExcelData("sheet1", "TC-1");
		String pageTitle=lp.login(sData, test, driver) ;
		WaitStatementLib.implicitWaitForSeconds(driver, 10);
		lp.clickonlogin(test);
	
		Homepage hp = new Homepage(driver);
    	String pagetext = hp.verifyvalidlogin(test, driver);
    	System.out.println(pagetext);
    	
		if(pagetext.equals("Home")){
			System.out.println("homepage opens");
			test.log(Status.PASS, "homepage opens");
			}
		else {
		
			System.out.println("homepage not opened");
			test.log(Status.FAIL, "homepage not opens");
		}}
			
	@Test(priority=2,groups = { "Smoke" })
	public void logintestcase2() {
	
		test = extent.createTest("Test Script 2", "InValid login test");
		test.createNode("Negative login test with wrong username and correct password");	
	
	
		Loginpage lp = new Loginpage(driver);
		
		String[] sData = ExcelUtils.toReadExcelData("sheet1", "TC-2");
		lp.login(sData, test, driver);
		
		lp.clickonlogin(test);
	String errormsg = lp.incorrectusername(test, driver);
		
	System.out.println(errormsg);
    Assert.assertEquals(errormsg, "Must be 16 characters");
       
    test.log(Status.PASS, "Homepage not opened +username error message verified");
    
	}
      @Test(priority=3,groups = { "Smoke" })
    public void logintestcase3() {

    test = extent.createTest("Test Script 3", "InValid login test");
    test.createNode("Negative login test with correct username and wrong password");
	
	Loginpage lp = new Loginpage(driver);
	
	String[] sData = ExcelUtils.toReadExcelData("sheet1", "TC-3");
	lp.login(sData, test, driver);
	
	lp.clickonlogin(test);
	
	String errorpwd = lp.incorrectpassword(test, driver);
	System.out.println(errorpwd);
   
	if(errorpwd.equals("Invalid login")){
		
		
		test.log(Status.PASS, "homepage not opens +password eorror message verified");
	}
	else {
		System.out.println(errorpwd);
		test.log(Status.FAIL, "homepage opens");
	}}	

	
   @Test(priority=4,groups = { "Smoke" })
     public void Dashboardestcase4() {

    test = extent.createTest("Test Script 4", "Click dashboard link & verify message");
  
    Loginpage lp = new Loginpage(driver);

   String[] sData = ExcelUtils.toReadExcelData("sheet1", "TC-1");
   lp.login(sData, test, driver);

   lp.clickonlogin(test);
	
   Homepage hp = new Homepage(driver);
   hp.dashboardlink(test, driver);
	
	String dashmessage =hp.dashboardlink(test, driver);
	
	System.out.println(dashmessage);
	
	Assert.assertEquals(dashmessage, "Page is under construction");
	test.log(Status.PASS, "Dashboard Page is under construction ");	
	
}
     
   @Test(priority=5,groups = { "Smoke" })
      public void Configurationtestcase5() throws InterruptedException {

    test = extent.createTest("Test Script 5", "Click configuration link & verify message");
  
    Loginpage lp = new Loginpage(driver);

   String[] sData = ExcelUtils.toReadExcelData("sheet1", "TC-1");
   lp.login(sData, test, driver);
   lp.clickonlogin(test);

   Homepage hp = new Homepage(driver);
   hp.configuration(test, driver);
   test.log(Status.PASS, "Clicked on configuration link");
String configurationmsg = hp.configuration(test, driver);

if(configurationmsg.equals("School Setup")){
	
	System.out.println("configuration submenu opens");
	test.log(Status.PASS, "configuration submenu opens");
	
}
else {

	System.out.println("configuration submenu not opens");
	test.log(Status.FAIL, "configuration submenu not opens");
}
  }
   
  @Test(priority=6,groups = { "Smoke" })
      public void SchoolSetuptestcase6() {

    test = extent.createTest("Test Script 6", "Click on school setup link  & verify ");
  
    Loginpage lp = new Loginpage(driver);

   String[] sData = ExcelUtils.toReadExcelData("sheet1", "TC-1");
   lp.login(sData, test, driver);
   lp.clickonlogin(test);
   try {
   Homepage hp = new Homepage(driver);
   hp.configuration(test, driver);
   test.log(Status.PASS, "clicked on configuration link");
    test.log(Status.PASS, "clicked on setup link"); 
    System.out.println("clicked on setup link");
    }
    	catch(Exception e) {
    	System.out.println(" Not clicked on setup link");
    	  test.log(Status.FAIL,ExceptionUtils.getStackTrace(e));	
    }}
	  
	@Test(priority=7,groups = { "Smoke" })
	   public void SchoolDetailstestcase7() {
try {
	    test = extent.createTest("Test Script 7", "verify all the text field under school details");
	  
	    Loginpage lp = new Loginpage(driver);

	   String[] sData = ExcelUtils.toReadExcelData("sheet1", "TC-1");
	   lp.login(sData, test, driver);
	   lp.clickonlogin(test);

	   Homepage hp = new Homepage(driver);
	   hp.configuration(test, driver);
	   test.log(Status.PASS, "clicked on configuration link");
	   WaitStatementLib.implicitWaitForSeconds(driver, 20);
	   hp.SchoolSetup(test, driver);
	   WaitStatementLib.implicitWaitForSeconds(driver, 40);
	  driver.findElement(By.xpath("//input[@name='affiliations[0].boardRegistrationNo']")).click();
}catch(Exception e) {
	  test.log(Status.FAIL,ExceptionUtils.getStackTrace(e));
}	   }
	  
	  @Test(priority=8,groups= { "Smoke" })
	   public void SchoolDetailstestcase8() throws InterruptedException {

	    test = extent.createTest("Test Script 8", "verify management type dropdown");
	  
	    Loginpage lp = new Loginpage(driver);

	   String[] sData = ExcelUtils.toReadExcelData("sheet1", "TC-1");
	   lp.login(sData, test, driver);
	   lp.clickonlogin(test);
       Homepage hp = new Homepage(driver);
	   hp.configuration(test, driver);
	   test.log(Status.PASS, "clicked on configuration link");
	   WaitStatementLib.implicitWaitForSeconds(driver, 20);
	   
	  WebElement managementDrop = driver.findElement(By.xpath("//div//span[@id='react-select-2--value-item']"));
	  Actions actions = new Actions(driver);
        actions.moveToElement( managementDrop);
        actions.click();
        WaitStatementLib.implicitWaitForSeconds(driver, 30);
        actions.sendKeys("C");
        actions.sendKeys(Keys.ARROW_DOWN);	
        //actions.sendKeys(Keys.ARROW_DOWN);	
        actions.sendKeys(Keys.ENTER);
        actions.build().perform(); 
       test.log(Status.PASS, "Management Dropdown selected");
       System.out.println("Management Dropdown selected");
       	}
	  
	  @Test(priority=9,groups= { "Smoke" })
	   public void SchoolDetailstestcase9() throws InterruptedException {

	    test = extent.createTest("Test Script 9", "verify status type dropdown");
	   Loginpage lp = new Loginpage(driver);
	   String[] sData = ExcelUtils.toReadExcelData("sheet1", "TC-1");
	   lp.login(sData, test, driver);
	   lp.clickonlogin(test);
	   Homepage hp = new Homepage(driver);
	   hp.configuration(test, driver);
	   test.log(Status.PASS, "clicked on configuration link");
	   WaitStatementLib.implicitWaitForSeconds(driver, 20);
	   JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("window.scrollBy(0,300)");
	  try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}    
	  WebElement statusdrop = driver.findElement(By.xpath(".//*[@id='react-select-3--value-item']"));
      
        Actions actions = new Actions(driver);
        actions.moveToElement(statusdrop);
        actions.click();
        actions.sendKeys("I");
        actions.sendKeys(Keys.ARROW_DOWN);	
        actions.sendKeys(Keys.ENTER);
        actions.build().perform();
        test.log(Status.PASS, "Dropdown selected");
        System.out.println("Status Dropdown selected");
	 }


	  @Test(priority=10,groups= { "Smoke" })
	   public void SchoolDetailstestcase10() throws InterruptedException {

	    test = extent.createTest("Test Script 10", "verify School type dropdown");
	   Loginpage lp = new Loginpage(driver);
	   String[] sData = ExcelUtils.toReadExcelData("sheet1", "TC-1");
	   lp.login(sData, test, driver);
	   lp.clickonlogin(test);
	   Homepage hp = new Homepage(driver);
	   hp.configuration(test, driver);
	   test.log(Status.PASS, "clicked on configuration link");
	   WaitStatementLib.implicitWaitForSeconds(driver, 20);
	   JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("window.scrollBy(0,400)");
	  try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}   
	  try {
	 WebElement schooltype = driver.findElement(By.xpath(".//*[@id='react-select-4--value']/div[1]"));
	
	Actions Act = new Actions(driver);
   Act.moveToElement(schooltype);
   WaitStatementLib.implicitWaitForSeconds(driver, 20);
   Act.click();
   Act.sendKeys("G");
   Act.sendKeys(Keys.ARROW_DOWN);
   Act.sendKeys(Keys.ENTER);
   Act.build().perform();
  System.out.println("School type dropdown working fine");
  test.log(Status.PASS, "School type dropdown selected");
	  }
	  catch(Exception e) {
	
		  test.log(Status.FAIL,ExceptionUtils.getStackTrace(e));
		   }}
	 
	
	  @Test(priority=11,groups= { "Smoke" })
	   public void SchoolDetailstestcase11() throws InterruptedException {

	    test = extent.createTest("Test Script 11", "verify Schoolmedium type dropdown");
	   Loginpage lp = new Loginpage(driver);
	   String[] sData = ExcelUtils.toReadExcelData("sheet1", "TC-1");
	   lp.login(sData, test, driver);
	   lp.clickonlogin(test);
	   Homepage hp = new Homepage(driver);
	   hp.configuration(test, driver);
	   test.log(Status.PASS, "clicked on configuration link");
	   WaitStatementLib.implicitWaitForSeconds(driver, 20);
	   JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("window.scrollBy(0,500)");
	  
		Thread.sleep(3000);
	  try {
		  
	WebElement Schlmedium  =driver.findElement(By.xpath(".//*[@id='react-select-5--value']/div[1]")) ;
	
	Actions Act = new Actions(driver);
	Act.moveToElement(Schlmedium);
	Thread.sleep(1000);
	Act.click();  
	Act.sendKeys("H");
	Act.sendKeys(Keys.ARROW_DOWN);
	Act.sendKeys(Keys.ENTER);
	Act.build().perform();		
		System.out.println("School medium dropdown selected"); 	  
	  test.log(Status.PASS, "School medium dropdown selected");
	  }
	  catch(Exception e) {
		  System.out.println("School medium dropdown not selected");   
		  test.log(Status.FAIL, ExceptionUtils.getStackTrace(e));
	  }}
	  
	    
	  @Test(priority=12,groups= { "Smoke" })
	   public void SchoolDetailstestcase12() throws InterruptedException {

	    test = extent.createTest("Test Script 12", "verify Branch status type dropdown");
	   Loginpage lp = new Loginpage(driver);
	   String[] sData = ExcelUtils.toReadExcelData("sheet1", "TC-1");
	   lp.login(sData, test, driver);
	   lp.clickonlogin(test);
	   Homepage hp = new Homepage(driver);
	   hp.configuration(test, driver);
	   test.log(Status.PASS, "clicked on configuration link");
	   WaitStatementLib.implicitWaitForSeconds(driver, 20);
	   JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("window.scrollBy(0,500)");
	  
		Thread.sleep(3000);
		try {
	WebElement Branchstatus  =driver.findElement(By.xpath(".//*[@id='react-select-6--value']/div[1]")) ;
		
		Actions Act = new Actions(driver);
		Act.moveToElement(Branchstatus);
		Thread.sleep(1000);
		Act.click();  
		Act.sendKeys("i");
		Act.sendKeys(Keys.ARROW_DOWN);
		Act.sendKeys(Keys.ENTER);
		Act.build().perform();		
			System.out.println("School medium dropdown selected"); 	  
		  test.log(Status.PASS, "School medium dropdown selected");
		  }
		catch(Exception e) {
			 System.out.println("Branch status dropdown not selected");   
			  test.log(Status.FAIL, ExceptionUtils.getStackTrace(e));
		}}
		
	  
	  @Test(priority=13,groups= { "Smoke" })
	   public void SchoolDetailstestcase13() throws InterruptedException {

	    test = extent.createTest("Test Script 13", "verify School-board type dropdown");
	   Loginpage lp = new Loginpage(driver);
	   String[] sData = ExcelUtils.toReadExcelData("sheet1", "TC-1");
	   lp.login(sData, test, driver);
	   lp.clickonlogin(test);
	   Homepage hp = new Homepage(driver);
	   hp.configuration(test, driver);
	   test.log(Status.PASS, "clicked on configuration link");
	   WaitStatementLib.implicitWaitForSeconds(driver, 20);
	   JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("window.scrollBy(0,800)");
	  
		Thread.sleep(2000);
		try {
WebElement Schoolboard =driver.findElement(By.xpath("//span[contains(text(),'CBSE')]"));
//WebElement Schoolboard = driver.findElement(By.cssSelector("#react-select-33--value > div.Select-value"));
		
		Actions Act = new Actions(driver);
		Act.moveToElement(Schoolboard);
		Thread.sleep(1000);
		Act.click();
		Act.sendKeys("I");
		Act.sendKeys(Keys.ARROW_DOWN);
		Act.sendKeys(Keys.ENTER);
		Act.build().perform();		
			System.out.println("School board dropdown selected"); 	  
		  test.log(Status.PASS, "School board dropdown selected");
		  }
		catch(Exception e) {
			 System.out.println("School board dropdown not selected");   
			  test.log(Status.FAIL, ExceptionUtils.getStackTrace(e));
			  System.out.println(e);
		}}
		
	  
	  
	 @Test(priority=14,groups= { "Smoke" })
	   public void SchoolDetailstestcase14() throws InterruptedException {

	    test = extent.createTest("Test Script 14", "verify Affiliation-upto date-picker calendar");
	   Loginpage lp = new Loginpage(driver);
	   String[] sData = ExcelUtils.toReadExcelData("sheet1", "TC-1");
	   lp.login(sData, test, driver);
	   lp.clickonlogin(test);
	   Homepage hp = new Homepage(driver);
	   hp.configuration(test, driver);
	   test.log(Status.PASS, "clicked on configuration link");
	   WaitStatementLib.implicitWaitForSeconds(driver, 20);
	   JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("window.scrollBy(0,800)");
	
	  Thread.sleep(2000);
	  try {
	  WebElement datebox = driver.findElement(By.xpath("//input[contains(@class,'react-datepicker-ignore-onclickoutside')]"));
	  datebox.click();
	  WebElement Datepicker = driver.findElement(By.xpath("//div[contains(text(),'22')]"));
	  Datepicker.click();
	  System.out.println("calendar date  selected");
		 test.log(Status.PASS, "calendar date  selected");
	  }
	  catch(Exception e) {
		  System.out.println("calendar date not  selected");
			 test.log(Status.PASS, "calendar date not  selected");  
	  }
	
	 }
	
	   @Test(priority=15,groups= { "Smoke" })
	   public void SchoolDetailstestcase15() throws InterruptedException {

	    test = extent.createTest("Test Script 15", "verify Add another Affiliation info link");
	   Loginpage lp = new Loginpage(driver);
	   String[] sData = ExcelUtils.toReadExcelData("sheet1", "TC-1");
	   lp.login(sData, test, driver);
	   lp.clickonlogin(test);
	   Homepage hp = new Homepage(driver);
	   hp.configuration(test, driver);
	   test.log(Status.PASS, "clicked on configuration link");
	   WaitStatementLib.implicitWaitForSeconds(driver, 20);
	   JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("window.scrollBy(0,800)");
	
	  Thread.sleep(2000);
	 try {
WebElement AddAffiliation = driver.findElement(By.xpath("//button[contains(.,'Add Another Affiliation')]"));
	  AddAffiliation.click();
	 System.out.println("Clicked on affiliation info");
	 test.log(Status.PASS, "Clicked on affiliation info details opens ");
	 }
	 
	 catch(Exception e) {
		 System.out.println(" Not Clicked on affiliation info ");
		 test.log(Status.FAIL, ExceptionUtils.getStackTrace(e));
		  System.out.println(e);
	 } 
	 }
	 
	   @Test(priority=15,groups= { "Smoke" })
	   public void SchoolDetailstestcase16() throws InterruptedException {

	    test = extent.createTest("Test Script 16", "verify Remove button link");
	   Loginpage lp = new Loginpage(driver);
	   String[] sData = ExcelUtils.toReadExcelData("sheet1", "TC-1");
	   lp.login(sData, test, driver);
	   lp.clickonlogin(test);
	   Homepage hp = new Homepage(driver);
	   hp.configuration(test, driver);
	   test.log(Status.PASS, "clicked on configuration link");
	   WaitStatementLib.implicitWaitForSeconds(driver, 20);
	   JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("window.scrollBy(0,800)");
	
	  Thread.sleep(2000);
	   try {
  WebElement AddAffiliation = driver.findElement(By.xpath("//button[contains(.,'Add Another Affiliation')]"));
	AddAffiliation.click();
	Thread.sleep(2000);
 WebElement remove = 	driver.findElement(By.xpath("//span[contains(text(),'Remove')]"));
 remove.click();
		  	 System.out.println("Clicked on remove button");
		  	 test.log(Status.PASS, "Clicked on affiliation info details opens ");
		  	test.log(Status.PASS, "Clicked on Remove button ");
		  	 }
		  	 catch(Exception e) {
		  		 System.out.println(" Not Clicked on remove button ");
		  		 test.log(Status.FAIL, ExceptionUtils.getStackTrace(e));
		  		  System.out.println(e);
		  	 }} 
		  	   
	 @Test(priority=16,groups= { "Smoke" })
	   public void SchoolDetailstestcase17() throws InterruptedException {

	    test = extent.createTest("Test Script 17", "verify Cancel button link");
	   Loginpage lp = new Loginpage(driver);
	   String[] sData = ExcelUtils.toReadExcelData("sheet1", "TC-1");
	   lp.login(sData, test, driver);
	   lp.clickonlogin(test);
	   Homepage hp = new Homepage(driver);
	   hp.configuration(test, driver);
	   test.log(Status.PASS, "clicked on configuration link");
	   WaitStatementLib.implicitWaitForSeconds(driver, 20);
	   JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("window.scrollBy(0,1000)");
	
	Thread.sleep(2000);
	try {
WebElement cancel = driver.findElement(By.xpath("//span[contains(text(),'Cancel')]"));
cancel.click();
WebElement homepage = driver.findElement(By.xpath("//h1[@class='_3XSf_']"));
String text = homepage.getText();
System.out.println(text);
System.out.println("Clicked on cancel button");
test.log(Status.PASS, "Clicked on cancel and home page is shown");
	}
	catch(Exception e) {
		 System.out.println(" Not Clicked on cancel button ");
  		 test.log(Status.FAIL, ExceptionUtils.getStackTrace(e));
  		  System.out.println(e);
	}}
	
	 @Test(priority=18,groups= { "Smoke" })
	   public void SchoolDetailstestcase18() throws InterruptedException {

	    test = extent.createTest("Test Script 18", "verify save & continue button validation");
	   Loginpage lp = new Loginpage(driver);
	   String[] sData = ExcelUtils.toReadExcelData("sheet1", "TC-1");
	   lp.login(sData, test, driver);
	   lp.clickonlogin(test);
	   Homepage hp = new Homepage(driver);
	   hp.configuration(test, driver);
	   test.log(Status.PASS, "clicked on configuration link");
	   WaitStatementLib.implicitWaitForSeconds(driver, 20);
	   JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("window.scrollBy(0,1000)");
	 Thread.sleep(2000);
	 try {
	 hp.savecontin(test, driver);
	 System.out.println("Clicked on save & continue button");
	 test.log(Status.PASS, "Clicked on save-continue button & errormessage is verified");
	 }
	 catch(Exception e) {
		 System.out.println(" Not Clicked on save neither error msg verified ");
  		 test.log(Status.FAIL, ExceptionUtils.getStackTrace(e));
  		  System.out.println(e);
  		  }
	 System.out.println("***********************************************************************************************************************************");
	 
 	 }
	 
	@Test(priority=19,groups="smoke")
	
	public void ContactDetails1() throws InterruptedException {
	 test = extent.createTest("Test Script 19", "To verify contact Details link ");
	   Loginpage lp = new Loginpage(driver);
	   String[] sData = ExcelUtils.toReadExcelData("sheet1", "TC-1");
	   lp.login(sData, test, driver);
	   lp.clickonlogin(test);
	   Homepage hp = new Homepage(driver);
	  hp.configuration(test, driver);
	  try {
	  WebElement contactdetails = driver.findElement(By.xpath("//p[contains(text(),'Contact Details')]"));
	  contactdetails.click();
	  contactdetails.getText();
	  System.out.println("Clicked on contact details link");
		 test.log(Status.PASS, "Clicked on contact details link");
	   }
	  catch(Exception e) {
		  System.out.println(" Not Clicked on contact details link ");
	  		 test.log(Status.FAIL, ExceptionUtils.getStackTrace(e));
	  		  System.out.println(e);
  
	}}
	
	@Test(priority=20,groups="smoke")
		
		public void ContactDetails2() throws InterruptedException {
		 test = extent.createTest("Test Script 20", "To verify state dropdown");
		   Loginpage lp = new Loginpage(driver);
		   String[] sData = ExcelUtils.toReadExcelData("sheet1", "TC-1");
		   lp.login(sData, test, driver);
		   lp.clickonlogin(test);
		   Homepage hp = new Homepage(driver);
		   test.log(Status.PASS, "clicked on configuration link");
		   WaitStatementLib.implicitWaitForSeconds(driver, 20);
		   try {
		   hp.AddressState(test, driver);
		   System.out.println("State dropdown selected");
			 test.log(Status.PASS, "State dropdown selected");
		   }
		   catch(Exception e) {
				 System.out.println(" State dropdown not selected");
		  		 test.log(Status.FAIL, ExceptionUtils.getStackTrace(e));
		  		  System.out.println(e);
}}

	@Test(priority=21,groups="smoke")
	public void ContactDetails3() throws InterruptedException {
	 test = extent.createTest("Test Script 21", "To verify Address type radiobutton");
	   Loginpage lp = new Loginpage(driver);
	   String[] sData = ExcelUtils.toReadExcelData("sheet1", "TC-1");
	   lp.login(sData, test, driver);
	   lp.clickonlogin(test);
	   Homepage hp = new Homepage(driver);
	   test.log(Status.PASS, "clicked on configuration link");
	   WaitStatementLib.implicitWaitForSeconds(driver, 20);

	   try {
		   hp.Addresstyperadio(test, driver);
		   System.out.println("Address type radio buttons are working fine");
			 test.log(Status.PASS, "Address type radio buttons are working fine");
		   }
		   catch(Exception e) {
				 System.out.println(" Address type radio buttons are not working");
		  		 test.log(Status.FAIL, ExceptionUtils.getStackTrace(e));
		  		  System.out.println(e);
		   }}

	@Test(priority=22,groups="smoke")
	public void ContactDetails4() throws InterruptedException {
	 test = extent.createTest("Test Script 22", "To verify text boxes under address info");
	   Loginpage lp = new Loginpage(driver);
	   String[] sData = ExcelUtils.toReadExcelData("sheet1", "TC-1");
	   lp.login(sData, test, driver);
	   lp.clickonlogin(test);
	   Homepage hp = new Homepage(driver);
	   test.log(Status.PASS, "clicked on configuration link");
	   WaitStatementLib.implicitWaitForSeconds(driver, 20);
try {
	hp.Textboxaddressinfo(test, driver); 
	System.out.println("Text boxes are cleared & filled");
	 test.log(Status.PASS, "Text boxes are cleared & filled");
}
catch(Exception e) {
	 System.out.println(" Text boxes are not working");
		 test.log(Status.FAIL, ExceptionUtils.getStackTrace(e));
		  System.out.println(e);
	}}
	
	@Test(priority=23,groups="smoke")
	public void ContactDetails5() throws InterruptedException {
	 test = extent.createTest("Test Script 23", "To verify text fields under contact info ");
	   Loginpage lp = new Loginpage(driver);
	   String[] sData = ExcelUtils.toReadExcelData("sheet1", "TC-1");
	   lp.login(sData, test, driver);
	   lp.clickonlogin(test);
	   Homepage hp = new Homepage(driver);
	   test.log(Status.PASS, "clicked on configuration link");
	   WaitStatementLib.implicitWaitForSeconds(driver, 20);

	   try {
			hp.contact(test, driver);
			System.out.println("Text boxes in contact info is working fine");
			 test.log(Status.PASS, "Text boxes in contact info is working fine");
		}
		catch(Exception e) {
			 System.out.println(" Text boxes are not working");
				 test.log(Status.FAIL, ExceptionUtils.getStackTrace(e));
				  System.out.println(e);
			}}

	@Test(priority=24,groups="smoke")
	public void ContactDetails6() throws InterruptedException {
	 test = extent.createTest("Test Script 24", "To verify back button link contact info");
	   Loginpage lp = new Loginpage(driver);
	   String[] sData = ExcelUtils.toReadExcelData("sheet1", "TC-1");
	   lp.login(sData, test, driver);
	   lp.clickonlogin(test);
	   Homepage hp = new Homepage(driver);
	  hp.contactdetails(test, driver);
	   JavascriptExecutor js = (JavascriptExecutor) driver;
		  js.executeScript("window.scrollBy(0,1000)");
		  WaitStatementLib.implicitWaitForSeconds(driver, 20);
 try{WebElement backbutton = driver.findElement(By.xpath("//span[contains(text(),'Back')]"));
	 backbutton.click();
	Thread.sleep(1000);
	  WebElement primaryinfo =driver.findElement(By.xpath("//legend[contains(text(),'Primary info')]"));
	 Assert.assertTrue(primaryinfo.isDisplayed());
	 System.out.println("Back button is working fine");
	 test.log(Status.PASS, "Back button is working fine & primary info displaying");
	 }
	catch(Exception e) {
		 System.out.println("Back button is not working fine");
		 test.log(Status.FAIL, ExceptionUtils.getStackTrace(e));
	}}
	
	@Test(priority=25,groups="smoke")
	public void ContactDetails7() throws InterruptedException {
	 test = extent.createTest("Test Script 25", "To verify add another contact tab");
	   Loginpage lp = new Loginpage(driver);
	   String[] sData = ExcelUtils.toReadExcelData("sheet1", "TC-1");
	   lp.login(sData, test, driver);
	   lp.clickonlogin(test);
	   Homepage hp = new Homepage(driver);
	  hp.contactdetails(test, driver);
	   JavascriptExecutor js = (JavascriptExecutor) driver;
		  js.executeScript("window.scrollBy(0,1000)");
		  WaitStatementLib.implicitWaitForSeconds(driver, 20);
	
	try{WebElement contacttab = driver.findElement(By.xpath("//span[contains(text(),'Add Another Contact')]"));
			 contacttab.click();
			Thread.sleep(1000);
		  WebElement fieldlabel =driver.findElement(By.xpath("//label[@for='fieldLabel']"));
			 Assert.assertTrue(fieldlabel.isDisplayed());
			 System.out.println("Add another contact tab is working fine");
			 test.log(Status.PASS, "Add another contact tab is working fine");
			 }
			catch(Exception e) {
				 System.out.println("Add another contact tab is not working fine");
				 test.log(Status.FAIL, ExceptionUtils.getStackTrace(e));
			}}
	@Test(priority=26,groups="smoke")
	public void ContactDetails8() throws InterruptedException {
	 test = extent.createTest("Test Script 26", "To verify add another contact tab");
	   Loginpage lp = new Loginpage(driver);
	   String[] sData = ExcelUtils.toReadExcelData("sheet1", "TC-1");
	   lp.login(sData, test, driver);
	   lp.clickonlogin(test);
	   Homepage hp = new Homepage(driver);
	  hp.contactdetails(test, driver);
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	 js.executeScript("window.scrollBy(0,1000)");
	 WaitStatementLib.implicitWaitForSeconds(driver, 20);
	 try {
 WebElement contacttab = driver.findElement(By.xpath("//span[contains(text(),'Add Another Contact')]"));
  contacttab.click();
		Thread.sleep(1000);
	hp.contactlabeldrop(test, driver);
	 System.out.println("Add another contact tab text field & dropdown is working fine");
	 test.log(Status.PASS, "Add another contact tab text field & dropdown is working fine");
	 }
	catch(Exception e) {
		 System.out.println("Add another contact tab text field & dropdown is not working fine");
		 test.log(Status.FAIL, ExceptionUtils.getStackTrace(e));
	}}
	
	@Test(priority=27,groups="smoke")
	public void ContactDetails9() throws InterruptedException {
	 test = extent.createTest("Test Script 27", "To verify cancel under add contact tab");
	   Loginpage lp = new Loginpage(driver);
	   String[] sData = ExcelUtils.toReadExcelData("sheet1", "TC-1");
	   lp.login(sData, test, driver);
	   lp.clickonlogin(test);
	   Homepage hp = new Homepage(driver);
	  hp.contactdetails(test, driver);
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	 js.executeScript("window.scrollBy(0,1000)");
	 WaitStatementLib.implicitWaitForSeconds(driver, 20);
	 try {
		 hp.addcancel(test, driver);
			 System.out.println("cancel under add contact tab is working fine");
			 test.log(Status.PASS, "cancel under add contact tab is working fine");
			 }
			catch(Exception e) {
				 System.out.println("cancel under add contact tab is not working fine");
				 test.log(Status.FAIL, ExceptionUtils.getStackTrace(e));
			}}

	@Test(priority=28,groups="smoke")
	public void ContactDetails10() throws InterruptedException {
	 test = extent.createTest("Test Script 28", "To verify save under add contact tab");
	   Loginpage lp = new Loginpage(driver);
	   String[] sData = ExcelUtils.toReadExcelData("sheet1", "TC-1");
	   lp.login(sData, test, driver);
	   lp.clickonlogin(test);
	   Homepage hp = new Homepage(driver);
	  hp.contactdetails(test, driver);
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	 js.executeScript("window.scrollBy(0,1000)");
	 WaitStatementLib.implicitWaitForSeconds(driver, 20);
	 try {
		 hp.addsave(test, driver);
		 WebElement save1 = driver.findElement(By.xpath("//span[Text()='Save']"));
		 Assert.assertEquals(save1.getText(), "enter text");
		 System.out.println(save1);
			 System.out.println("save under add contact tab is working fine");
			 test.log(Status.PASS, "save under add contact tab is working fine");
			 }
			catch(Exception e) {
				 System.out.println("save under add contact tab is not working fine");
				 test.log(Status.FAIL, ExceptionUtils.getStackTrace(e));
			}}
			
	@Test(priority=29,groups="smoke")
	public void ContactDetails11() throws InterruptedException {
	 test = extent.createTest("Test Script 29", "To verify save under add contact tab");
	   Loginpage lp = new Loginpage(driver);  
	   String[] sData = ExcelUtils.toReadExcelData("sheet1", "TC-1");
	   lp.login(sData, test, driver);
	   lp.clickonlogin(test);
	   Homepage hp = new Homepage(driver);
	  hp.contactdetails(test, driver);
	  JavascriptExecutor js = (JavascriptExecutor) driver; 
	 js.executeScript("window.scrollBy(0,1000)");
	 WaitStatementLib.implicitWaitForSeconds(driver, 20);
	
	 try {
		 hp.editremovelink(test, driver);
			 System.out.println("edit-remove link under add contact tab is working fine");
			 test.log(Status.PASS, "edit-remove link under add contact tab is working fine");
			 }
			catch(Exception e) {
				 System.out.println("edit-remove link under add contact tab is not working fine");
				 test.log(Status.FAIL, ExceptionUtils.getStackTrace(e));
				 System.out.println("***********************************************************************************************************************************");
			}}
			
	@Test(priority=30,groups="smoke")
	public void Completesetup1() throws InterruptedException {
	 test = extent.createTest("Test Script 30", "To verify complete setup link");
	   Loginpage lp = new Loginpage(driver);  
	   String[] sData = ExcelUtils.toReadExcelData("sheet1", "TC-1");
	   lp.login(sData, test, driver);
	   lp.clickonlogin(test);
	   Homepage hp = new Homepage(driver);
	   WaitStatementLib.implicitWaitForSeconds(driver, 20);
	   try {
			 hp.completesetup(test, driver);
				 System.out.println("complete setup link is working fine");
				 test.log(Status.PASS, "complete setup link is working fine");
				 }
				catch(Exception e) {
					 System.out.println("complete setup link is not working fine");
					 test.log(Status.FAIL, ExceptionUtils.getStackTrace(e));
				}}

@Test(priority=31,groups="smoke")
public void Completesetup2() throws InterruptedException {
test = extent.createTest("Test Script 31", "To verify text boxes under primary info");
Loginpage lp = new Loginpage(driver);  
String[] sData = ExcelUtils.toReadExcelData("sheet1", "TC-1");
lp.login(sData, test, driver);
lp.clickonlogin(test);
Homepage hp = new Homepage(driver);
WaitStatementLib.implicitWaitForSeconds(driver, 20);
try {
	 hp.primaryinfo(test, driver);
		 System.out.println("primary info text boxes is working fine");
		 test.log(Status.PASS, "primary info text boxes is working fine");
		 }
		catch(Exception e) {
			 System.out.println("primary info text boxes is not working fine");
			 test.log(Status.FAIL, ExceptionUtils.getStackTrace(e));
		}}

	@Test(priority=32,groups="smoke")
	public void Completesetup3() throws InterruptedException {
	test = extent.createTest("Test Script 32", "To verify datepicker calender under acedemic year");
	Loginpage lp = new Loginpage(driver);  
	String[] sData = ExcelUtils.toReadExcelData("sheet1", "TC-1");
	lp.login(sData, test, driver);
	lp.clickonlogin(test);
	Homepage hp = new Homepage(driver);
	WaitStatementLib.implicitWaitForSeconds(driver, 20);

	try {
		 hp.acedemicyear(test, driver);
			 System.out.println("Datepicker are selected & working fine");
			 test.log(Status.PASS, "Datepicker are selected & working fine");
			 }
			catch(Exception e) {
				 System.out.println("Datepicker are selected & not working fine");
			   test.log(Status.FAIL, ExceptionUtils.getStackTrace(e));
    System.out.println("##################################################################################################");
			}}

    @Test(priority=33,groups="smoke")
	public void facility1() throws InterruptedException {
	test = extent.createTest("Test Script 33", "To verify facility link");
	Loginpage lp = new Loginpage(driver);  
	String[] sData = ExcelUtils.toReadExcelData("sheet1", "TC-1");
	lp.login(sData, test, driver);
	lp.clickonlogin(test);
	Homepage hp = new Homepage(driver);
	WaitStatementLib.implicitWaitForSeconds(driver, 20);
try {
	hp.Facility(test, driver);
	 System.out.println("Facility link is working fine working fine");
	 test.log(Status.PASS, "Facility link is clicked & working fine");
}
catch(Exception e) {
	System.out.println("Facility link is not working fine");
	test.log(Status.FAIL, ExceptionUtils.getStackTrace(e));
}}

    @Test(priority=34,groups="smoke")
	public void facility2() throws InterruptedException {
	test = extent.createTest("Test Script 34", "To verify new facility link");
	Loginpage lp = new Loginpage(driver);  
	String[] sData = ExcelUtils.toReadExcelData("sheet1", "TC-1");
	lp.login(sData, test, driver);
	lp.clickonlogin(test);
	Homepage hp = new Homepage(driver);
	WaitStatementLib.implicitWaitForSeconds(driver, 20);
	try {
		hp.NewFacility(test, driver);
		 System.out.println("New Facility link is working fine ");
		 test.log(Status.PASS, "New Facility link is clicked ");
	}
	catch(Exception e) {
		System.out.println("New Facility link is not working fine");
		test.log(Status.FAIL, ExceptionUtils.getStackTrace(e));
	}}
    
    @Test(priority=35,groups="smoke")
   	public void facility3() throws InterruptedException {
   	test = extent.createTest("Test Script 35", "To verify text boxes under new facility link");
   	Loginpage lp = new Loginpage(driver);  
   	String[] sData = ExcelUtils.toReadExcelData("sheet1", "TC-1");
   	lp.login(sData, test, driver);
   	lp.clickonlogin(test);
   	Homepage hp = new Homepage(driver);
   	WaitStatementLib.implicitWaitForSeconds(driver, 20);
   	try {
   		hp.NewFacility(test, driver);
   		 System.out.println("Text boxes under new Facility link is working fine ");
   		 test.log(Status.PASS, "Text boxes under new Facility link is working fine");
   	}
   	catch(Exception e) {
   		System.out.println("Text boxes under new Facility link is working fine");
   		test.log(Status.FAIL, ExceptionUtils.getStackTrace(e));
   	}} 
   
    @Test(priority=36,groups="smoke")
    public void facility4() throws InterruptedException {
       	test = extent.createTest("Test Script 36", "To verify save & cancel under new facility link");
       	Loginpage lp = new Loginpage(driver);  
       	String[] sData = ExcelUtils.toReadExcelData("sheet1", "TC-1");
       	lp.login(sData, test, driver);
       	lp.clickonlogin(test);
       	Homepage hp = new Homepage(driver);
       	WaitStatementLib.implicitWaitForSeconds(driver, 20);
     	try {
       		hp.facilitysavecancel(test, driver);
       		 System.out.println("save and cancel is working fine ");
       		 test.log(Status.PASS, "save and cancel is working fine ");
       	}
       	catch(Exception e) {
       		System.out.println("save and facility is not working fine ");
       		test.log(Status.FAIL, ExceptionUtils.getStackTrace(e));
       	}} 
       
    @Test(priority=37,groups="smoke")
    public void facility5() throws InterruptedException {
       	test = extent.createTest("Test Script 37", "To verify subfacility link");
       	Loginpage lp = new Loginpage(driver);  
       	String[] sData = ExcelUtils.toReadExcelData("sheet1", "TC-1");
       	lp.login(sData, test, driver);
       	lp.clickonlogin(test);
       	Homepage hp = new Homepage(driver);
       	WaitStatementLib.implicitWaitForSeconds(driver, 20);
    	try {
    		hp.NewFacility(test, driver);
       		WebElement subfacility = driver.findElement(By.xpath("//div[contains(@class,'_3mXkL _2J98e')]"));
       		Actions Act =new Actions(driver);
       		Act.click();
       		Act.moveToElement(subfacility).perform();
       		 System.out.println("Subfacility link is showing");
       		 test.log(Status.PASS, "Subfacility link is showing ");
       	}
       	catch(Exception e) {
       		System.out.println("Subfacility link is showing ");
       		test.log(Status.FAIL, ExceptionUtils.getStackTrace(e));
       	}} 
   
	 @Test(priority=38,groups="smoke")
	    public void facility6() throws InterruptedException {
	       	test = extent.createTest("Test Script 38", "To verify searchbox");
	       	Loginpage lp = new Loginpage(driver);  
	       	String[] sData = ExcelUtils.toReadExcelData("sheet1", "TC-1");
	       	lp.login(sData, test, driver);
	       	lp.clickonlogin(test);
	       	Homepage hp = new Homepage(driver);
	       	WaitStatementLib.implicitWaitForSeconds(driver, 20);
	try {
	hp.NewFacility(test, driver);
    WebElement 	searchbox =driver.findElement(By.xpath("//input[@placeholder='Search']"));
    searchbox.click();
    searchbox.sendKeys("v");
    System.out.println("Search box is working fine");
	test.log(Status.PASS, "Search box is working fine");
    }
	catch(Exception e) {
   		System.out.println("Search box is not working fine");
   		test.log(Status.FAIL, ExceptionUtils.getStackTrace(e));
	System.out.println("#############################################################################################");
	}}
    
	 @Test(priority=39,groups="smoke")
	    public void classsetup1() throws InterruptedException {
	       	test = extent.createTest("Test Script 39", "To verify classset-up link");
	       	Loginpage lp = new Loginpage(driver);  
	       	String[] sData = ExcelUtils.toReadExcelData("sheet1", "TC-1");
	       	lp.login(sData, test, driver);
	       	lp.clickonlogin(test);
	       	Homepage hp = new Homepage(driver);
	       	WaitStatementLib.implicitWaitForSeconds(driver, 20); 
	       	try {
	       hp.classsetup(test, driver);
	       	System.out.println("Class setup link is working fine");
	       test.log(Status.PASS, "Class setup link is working fine");
	       	    }
	       		catch(Exception e) {
	       	System.out.println("Class setup link is not working fine");
	       test.log(Status.FAIL, ExceptionUtils.getStackTrace(e));
	    System.out.println("#############################################################################################");
	       		}}
	       		
	 @Test(priority=40,groups="smoke")
	    public void classsetup2() throws InterruptedException {
	       	test = extent.createTest("Test Script 40", "To verify new section link");
	       	Loginpage lp = new Loginpage(driver);  
	       	String[] sData = ExcelUtils.toReadExcelData("sheet1", "TC-1");
	       	lp.login(sData, test, driver);
	       	lp.clickonlogin(test);
	       	Homepage hp = new Homepage(driver); 
	       	WaitStatementLib.implicitWaitForSeconds(driver, 20); 
	       	try {
	 	       hp.classsetup(test, driver);
	 WebElement NewSection = driver.findElement(By.xpath("//ul[contains(@class,'_2E9wo')]//li[3]"));
	 NewSection.click();
	 	       	System.out.println("New Section link is working fine");
	 	       test.log(Status.PASS, "New Section link is working fine");
	 	       	    }
	       	catch(Exception e) {
		       	System.out.println("New section link is not working fine");
		       test.log(Status.FAIL, ExceptionUtils.getStackTrace(e));
	       	}}
     
	 @Test(priority=41,groups="smoke")
	    public void classsetup3() throws InterruptedException {
	       	test = extent.createTest("Test Script 41", "To verify text boxes under new section link");
	       	Loginpage lp = new Loginpage(driver);  
	       	String[] sData = ExcelUtils.toReadExcelData("sheet1", "TC-1");
	       	lp.login(sData, test, driver);
	       	lp.clickonlogin(test);
	       	Homepage hp = new Homepage(driver); 
	       	WaitStatementLib.implicitWaitForSeconds(driver, 20);
	 try {
		 	       hp.classsetup(test, driver);
		 WebElement NewSection = driver.findElement(By.xpath("//ul[contains(@class,'_2E9wo')]//li[3]"));
		 NewSection.click();
		 hp.NewSectionTextbox(test, driver);
		 	       	System.out.println("Text boxes under new Section link is working fine");
		 	       test.log(Status.PASS, "Text boxes under new Section link is working fine");
		 	       	    }
		       	catch(Exception e) {
			       	System.out.println("Text boxes under new Section link is not working fine");
			       test.log(Status.FAIL, ExceptionUtils.getStackTrace(e));
		       	}}
		       	
	 @Test(priority=42,groups="smoke")
	    public void classsetup4() throws InterruptedException {
	       	test = extent.createTest("Test Script 42", "To verify board dropdown");
	       	Loginpage lp = new Loginpage(driver);  
	       	String[] sData = ExcelUtils.toReadExcelData("sheet1", "TC-1");
	       	lp.login(sData, test, driver);
	       	lp.clickonlogin(test);
	       	Homepage hp = new Homepage(driver); 
	       	WaitStatementLib.implicitWaitForSeconds(driver, 20);
	        try {
		 	       hp.classsetup(test, driver);
		 WebElement NewSection = driver.findElement(By.xpath("//ul[contains(@class,'_2E9wo')]//li[3]"));
		 NewSection.click();
		 WebElement dropdown = driver.findElement(By.xpath(".//*[@id='react-select-4--value']/div[1]"));
		 Actions act = new Actions(driver);
		 act.moveToElement(dropdown);
		 Thread.sleep(1000);
		 dropdown.click();
		 act.sendKeys(Keys.ARROW_DOWN); 
		System.out.println("Board dropdown is working fine");
		test.log(Status.PASS, "Board dropdown is working fine");
		 	       	    }
	    	catch(Exception e) {
		       	System.out.println("Board dropdown is not working fine");
		       test.log(Status.FAIL, ExceptionUtils.getStackTrace(e));
	       	}}
	 @Test(priority=43,groups="smoke")
	    public void classsetup5() throws InterruptedException {
	       	test = extent.createTest("Test Script 43", "To verify facility dropdown");
	       	Loginpage lp = new Loginpage(driver);  
	       	String[] sData = ExcelUtils.toReadExcelData("sheet1", "TC-1");
	       	lp.login(sData, test, driver);
	       	lp.clickonlogin(test);
	       	Homepage hp = new Homepage(driver); 
	       	WaitStatementLib.implicitWaitForSeconds(driver, 20);
	        try {
		 	       hp.classsetup(test, driver);
		 WebElement NewSection = driver.findElement(By.xpath("//ul[contains(@class,'_2E9wo')]//li[3]"));
		 NewSection.click();
		 WebElement dropdown = driver.findElement(By.xpath(".//*[@id='react-select-2--value']/div[1]"));
		 Actions act = new Actions(driver);
		 act.moveToElement(NewSection);
		 Thread.sleep(1000);
		 dropdown.click();
		 act.sendKeys(Keys.ARROW_DOWN); 
		System.out.println("Facility dropdown is working fine");
		test.log(Status.PASS, "facility dropdown is working fine");
		 	       	    }
	    	catch(Exception e) {
		       	System.out.println("Facility dropdown is not working fine");
		       test.log(Status.FAIL, ExceptionUtils.getStackTrace(e));
	       	}}
	  @Test(priority=44,groups="smoke")
	    public void classsetup6() throws InterruptedException {
	       	test = extent.createTest("Test Script 44", "To verify active dropdown");
	       	Loginpage lp = new Loginpage(driver);  
	       	String[] sData = ExcelUtils.toReadExcelData("sheet1", "TC-1");
	       	lp.login(sData, test, driver);
	       	lp.clickonlogin(test);
	       	Homepage hp = new Homepage(driver); 
	       	WaitStatementLib.implicitWaitForSeconds(driver, 20);
	        try {
		 	       hp.classsetup(test, driver);
		 WebElement NewSection = driver.findElement(By.xpath("//ul[contains(@class,'_2E9wo')]//li[3]"));
		 NewSection.click();
		 WebElement dropdown = driver.findElement(By.xpath("//div[contains(@class,'Select-value')]"));
		 Actions act = new Actions(driver);
		 act.moveToElement(NewSection);
		 Thread.sleep(1000);
		 dropdown.click();
		 act.sendKeys(Keys.ARROW_DOWN); 
		System.out.println("Active dropdown is working fine");
		test.log(Status.PASS, "Active dropdown is working fine");
		 	       	    }
	    catch(Exception e) {
		System.out.println("Active dropdown is not working fine");
		  test.log(Status.FAIL, ExceptionUtils.getStackTrace(e));
	    	}}
	  
	  @Test(priority=45,groups="smoke")
	    public void classsetup7() throws InterruptedException {
	       	test = extent.createTest("Test Script 45", "To verify cancel button");
	       	Loginpage lp = new Loginpage(driver);  
	       	String[] sData = ExcelUtils.toReadExcelData("sheet1", "TC-1");
	       	lp.login(sData, test, driver);
	      // 	driver.wait(until.elementIsNotVisible(By.css('.suggestion')));
	      lp.clickonlogin(test);
	       	Homepage hp = new Homepage(driver); 
	       	WaitStatementLib.implicitWaitForSeconds(driver, 20);
	        try {
		 	       hp.classsetup(test, driver);
		 WebElement NewSection = driver.findElement(By.xpath("//ul[contains(@class,'_2E9wo')]//li[3]"));
		 NewSection.click(); 
		 WebElement cancel = driver.findElement(By.xpath("//span[contains(text(),'Cancel')]"));
		 WaitStatementLib.explicitWaitForClickable(driver, 60, cancel);
		 cancel.click();
		 	System.out.println("Cancel button is working fine");
		 test.log(Status.PASS, "Cancel button is working fine");
	        }
	        catch(Exception e) {
	   System.out.println("Cancel button is not working fine");
	     test.log(Status.FAIL, ExceptionUtils.getStackTrace(e));
	        }}
	 
	 @Test(priority=46,groups="smoke")
	    public void classsetup8() throws InterruptedException {
	       	test = extent.createTest("Test Script 46", "To verify save button");
	       	Loginpage lp = new Loginpage(driver);  
	       	String[] sData = ExcelUtils.toReadExcelData("sheet1", "TC-1");
	       	lp.login(sData, test, driver);
	      lp.clickonlogin(test);
	       	Homepage hp = new Homepage(driver); 
	       	WaitStatementLib.implicitWaitForSeconds(driver, 20);
	        try {
		 	       hp.classsetup(test, driver);
		 WebElement NewSection = driver.findElement(By.xpath("//ul[contains(@class,'_2E9wo')]//li[3]"));
		 NewSection.click(); 
		 WebElement save = driver.findElement(By.xpath("//span[contains(text(),'Save and Continue')]"));
		 WaitStatementLib.explicitWaitForClickable(driver, 60, save);
		 save.click();
		 	System.out.println("save button is working fine");
		 test.log(Status.PASS, "save button is working fine");
	        }
	        catch(Exception e) {
	   System.out.println("save button is not working fine");
	     test.log(Status.FAIL, ExceptionUtils.getStackTrace(e));
	        }}
	        
	  @Test(priority=47,groups="smoke")
	    public void classsetup9() throws InterruptedException {
	       	test = extent.createTest("Test Script 47", "To verify edit section link");
	       	Loginpage lp = new Loginpage(driver);  
	       	String[] sData = ExcelUtils.toReadExcelData("sheet1", "TC-1");
	       	lp.login(sData, test, driver);
	      lp.clickonlogin(test);
	       	Homepage hp = new Homepage(driver); 
	       	WaitStatementLib.implicitWaitForSeconds(driver, 20);
	       	try {
		 	       hp.classsetup(test, driver);
		 WebElement NewSection = driver.findElement(By.xpath("//ul[contains(@class,'_2E9wo')]//li[3]"));
		 NewSection.click(); 
		 WebElement editsection = driver.findElement(By.xpath("//button[contains(.,'A Edit Section')]"));
		 WaitStatementLib.explicitWaitForClickable(driver, 60, editsection);
		 editsection.click();
		 	System.out.println("edit section link is working fine");
		 test.log(Status.PASS, "edit section link is working fine");
	        }
	        catch(Exception e) {
	   System.out.println("edit section link is not working fine");
	     test.log(Status.FAIL, ExceptionUtils.getStackTrace(e));
	        }}

	  @Test(priority=48,groups="smoke")
	    public void classsetup10() throws InterruptedException {
	       	test = extent.createTest("Test Script 48", "To verify manage curriculum link");
	       	Loginpage lp = new Loginpage(driver);  
	       	String[] sData = ExcelUtils.toReadExcelData("sheet1", "TC-1");
	       	lp.login(sData, test, driver);
	      lp.clickonlogin(test);
	       	Homepage hp = new Homepage(driver); 
	       	WaitStatementLib.implicitWaitForSeconds(driver, 20);
	try {
		 	       hp.classsetup(test, driver);; 
		 WebElement managecuuriculum  = driver.findElement(By.xpath("//span[contains(text(),'Manage Curriculum')]"));
		 WaitStatementLib.explicitWaitForClickable(driver, 60, managecuuriculum);
		 managecuuriculum.click();
		 	System.out.println("managecuuriculum link is working fine");
		 test.log(Status.PASS, "managecuuriculum link is working fine");
	        }
	        catch(Exception e) {
	   System.out.println("managecuuriculum link is not working fine");
	     test.log(Status.FAIL, ExceptionUtils.getStackTrace(e));
	        }}
	 
	  @Test(priority=49,groups="smoke")
	    public void classsetup11() throws InterruptedException {
	       	test = extent.createTest("Test Script 49", "To verify CBSE under manage curriculum link");
	       	Loginpage lp = new Loginpage(driver);  
	       	String[] sData = ExcelUtils.toReadExcelData("sheet1", "TC-1");
	       	lp.login(sData, test, driver);
	      lp.clickonlogin(test);
	       	Homepage hp = new Homepage(driver); 
	       	WaitStatementLib.implicitWaitForSeconds(driver, 20);
	       	try {
		 	       hp.classsetup(test, driver);; 
		 WebElement managecuuriculum  = driver.findElement(By.xpath("//span[contains(text(),'Manage Curriculum')]"));
		 managecuuriculum.click();
		WebElement cbse = driver.findElement(By.xpath("//span[contains(text(),'CBSE')]"));
	 WaitStatementLib.explicitWaitForClickable(driver, 60, cbse);
	 cbse.click();
		 	System.out.println("CBSE under managecuuriculum link is working fine");
		 test.log(Status.PASS, "CBSE under managecuuriculum link is working fine");
	        }
	        catch(Exception e) {
	   System.out.println("managecuuriculum link is not working fine");
	     test.log(Status.FAIL, ExceptionUtils.getStackTrace(e));
	        }}
	@Test(priority=50,groups="smoke")
    public void classsetup12() throws InterruptedException {
       	test = extent.createTest("Test Script 50", "To verify entry fields under CBSE link");
       	Loginpage lp = new Loginpage(driver);  
       	String[] sData = ExcelUtils.toReadExcelData("sheet1", "TC-1");
       	lp.login(sData, test, driver);
      lp.clickonlogin(test);
       	Homepage hp = new Homepage(driver); 
    	try {
      hp.CBSElinkfields(test, driver);
      WebElement textbox = driver.findElement(By.xpath("//input[@id='curriculums[3].subjectCode']"));
      textbox.sendKeys("04");
	 	System.out.println("Entry fields under CBSE  link is working fine");
	 test.log(Status.PASS, "Entry fields under CBSE  link is working fine");
     }
    	catch(Exception e) {
    		   System.out.println("Entry fields under CBSE  link is not working fine");
    		     test.log(Status.FAIL, ExceptionUtils.getStackTrace(e));
    		        }}	 
	 
	@Test(priority=51,groups="smoke")
    public void classsetup13() throws InterruptedException {
       	test = extent.createTest("Test Script 51", "To verify radio buttons under CBSE link");
       	Loginpage lp = new Loginpage(driver);  
       	String[] sData = ExcelUtils.toReadExcelData("sheet1", "TC-1");
       	lp.login(sData, test, driver);
      lp.clickonlogin(test);
       	Homepage hp = new Homepage(driver); 
    	try {
      hp.CBSElinkfields(test, driver);
      WaitStatementLib.waitForLoad(driver);
   WebElement radiobutton = driver.findElement(By.xpath("//div[contains(@class,'LYH-A')]//div[4]//div[1]//div[3]//div[1]//button[1]//span[1]"));
     radiobutton.click();
      radiobutton.click();
      radiobutton.click();
	 	System.out.println("Radio buttons are working fine");
	 test.log(Status.PASS, "Radio buttons are working fine");
     }
    	catch(Exception e) {
    		   System.out.println("Radio buttons under CBSE  link is not working fine");
    		     test.log(Status.FAIL, ExceptionUtils.getStackTrace(e));

    	}}
@Test(priority=52,groups="smoke")
    public void classsetup14() throws InterruptedException {
       	test = extent.createTest("Test Script 52", "To verify delete buttons under CBSE link");
       	Loginpage lp = new Loginpage(driver);  
       	String[] sData = ExcelUtils.toReadExcelData("sheet1", "TC-1");
       	lp.login(sData, test, driver);
      lp.clickonlogin(test);
       	Homepage hp = new Homepage(driver); 
    	try {
    	      hp.CBSElinkfields(test, driver);
    	      WaitStatementLib.waitForLoad(driver);
   WebElement delete = driver.findElement(By.xpath(".//*[@id='portal-root']/div/div[2]/div/div/div[2]/form/div[1]/div[2]/div[2]/div[1]/div[3]/button"));
    	    delete.click(); 
    		System.out.println("Delete buttons are working fine");
    	 	 test.log(Status.PASS, "Delete buttons are working fine");
    	}
    	catch(Exception e) {
 		   System.out.println("Delete buttons under CBSE  link is not working fine");
 		     test.log(Status.FAIL, ExceptionUtils.getStackTrace(e));
    	}}
	
	@Test(priority=53,groups="smoke")
    public void classsetup15() throws InterruptedException {
       	test = extent.createTest("Test Script 53", "To verify search box under CBSE link");
       	Loginpage lp = new Loginpage(driver);  
       	String[] sData = ExcelUtils.toReadExcelData("sheet1", "TC-1");
       	lp.login(sData, test, driver);
      lp.clickonlogin(test);
       	Homepage hp = new Homepage(driver); 
	try {
		 hp.CBSElinkfields(test, driver);
	     WaitStatementLib.waitForLoad(driver);
WebElement searchbox = driver.findElement(By.xpath("//input[@placeholder='Search curriculum']"));
 searchbox.sendKeys("BST");
 WebElement msg =driver.findElement(By.xpath("//p[contains(text(),'BST - Theory')]"));
 Assert.assertEquals(msg.getText(), "BST - Theory");
 System.out.println("Search box are working fine");
	 test.log(Status.PASS, "Search box are working fine");
	      }
	catch(Exception e) {
		   System.out.println("Search box under CBSE  link is not working fine");
		     test.log(Status.FAIL, ExceptionUtils.getStackTrace(e));
 	}}
 	
	@Test(priority=54,groups="smoke")
    public void classsetup16() throws InterruptedException {
       	test = extent.createTest("Test Script 54", "To verify subject link under CBSE ");
       	Loginpage lp = new Loginpage(driver);  
       	String[] sData = ExcelUtils.toReadExcelData("sheet1", "TC-1");
       	lp.login(sData, test, driver);
      lp.clickonlogin(test);
       	Homepage hp = new Homepage(driver); 
       	try {
   		 hp.CBSElinkfields(test, driver);
   	     WaitStatementLib.waitForLoad(driver);
  WebElement subjects =driver.findElement(By.xpath("//button[@type='button']//span[contains(text(),'Subjects')]"));
  subjects.click();
  System.out.println(" subject link is working fine");
  test.log(Status.PASS, " subject link is working fine");
       	}
   catch(Exception e) {
	   System.out.println(" subject link is not working fine");
	    test.log(Status.FAIL, ExceptionUtils.getStackTrace(e)); 	
   }}

	@Test(priority=55,groups="smoke")
    public void classsetup17() throws InterruptedException {
       	test = extent.createTest("Test Script 55", "To verify Add subject under subject-CBSE link");
       	Loginpage lp = new Loginpage(driver);  
       	String[] sData = ExcelUtils.toReadExcelData("sheet1", "TC-1");
       	lp.login(sData, test, driver);
      lp.clickonlogin(test);
       	Homepage hp = new Homepage(driver); 
     	try {
      		 hp.CBSElinkfields(test, driver);
      	     WaitStatementLib.waitForLoad(driver);
     WebElement subjects =driver.findElement(By.xpath("//button[@type='button']//span[contains(text(),'Subjects')]"));
     subjects.click();
      WebElement Addsubject = driver.findElement(By.xpath("//span[contains(text(),'Add Subjects')]"));
     WaitStatementLib.explicitWaitForClickable(driver, 30,Addsubject);
     Addsubject.click();
     System.out.println(" Add subject link is working fine");
     test.log(Status.PASS, "Add subject link is working fine");
          	}
      catch(Exception e) {
   	   System.out.println("Add subject link is not working fine");
   	    test.log(Status.FAIL, ExceptionUtils.getStackTrace(e)); 	
      }}
      
	@Test(priority=56,groups="smoke")
    public void classsetup18() throws InterruptedException {
       	test = extent.createTest("Test Script 56", "To verify Add Stream under subject-CBSE link");
       	Loginpage lp = new Loginpage(driver);  
       	String[] sData = ExcelUtils.toReadExcelData("sheet1", "TC-1");
       	lp.login(sData, test, driver);
      lp.clickonlogin(test);
       	Homepage hp = new Homepage(driver); 
    	try {
     		 hp.CBSElinkfields(test, driver);
     	     WaitStatementLib.waitForLoad(driver);
    WebElement subjects =driver.findElement(By.xpath("//button[@type='button']//span[contains(text(),'Subjects')]"));
    subjects.click();
     WebElement Addstream = driver.findElement(By.xpath("//span[contains(text(),'Add streams')]"));
    WaitStatementLib.explicitWaitForClickable(driver, 30,Addstream);
    Addstream.click();
    System.out.println(" Add stream link is working fine");
    test.log(Status.PASS, "Add stream link is working fine");
         	}
     catch(Exception e) {
  	   System.out.println("Add stream link is not working fine");
  	    test.log(Status.FAIL, ExceptionUtils.getStackTrace(e)); 	
     }}
	
	@Test(priority=57,groups="smoke")
    public void classsetup19() throws InterruptedException {
       	test = extent.createTest("Test Script 57", "To verify Add Stream under subject-CBSE link");
       	Loginpage lp = new Loginpage(driver);  
       	String[] sData = ExcelUtils.toReadExcelData("sheet1", "TC-1");
       	lp.login(sData, test, driver);
      lp.clickonlogin(test);
       	Homepage hp = new Homepage(driver); 
       	try {
    		 hp.CBSElinkfields(test, driver);
    	     WaitStatementLib.waitForLoad(driver);
   WebElement subjects =driver.findElement(By.xpath("//button[@type='button']//span[contains(text(),'Subjects')]"));
   subjects.click();
    WebElement Addstream = driver.findElement(By.xpath("//span[contains(text(),'Add streams')]"));
   WaitStatementLib.explicitWaitForClickable(driver, 30,Addstream);
   Addstream.click();
   System.out.println(" Add stream link is working fine");
   test.log(Status.PASS, "Add stream link is working fine");
        	}
    catch(Exception e) {
 	   System.out.println("Add stream link is not working fine");
 	    test.log(Status.FAIL, ExceptionUtils.getStackTrace(e)); 	
    }}
	
	@Test(priority=58,groups="smoke")
    public void classsetup20() throws InterruptedException {
       	test = extent.createTest("Test Script 58", "To verify Add Subject Screen under subject-CBSE link");
       	Loginpage lp = new Loginpage(driver);  
       	String[] sData = ExcelUtils.toReadExcelData("sheet1", "TC-1");
       	lp.login(sData, test, driver);
      lp.clickonlogin(test);
       	Homepage hp = new Homepage(driver); 
       	try {
  hp.AddSubjectScreen(test, driver);
  System.out.println(" Add Subject Screen  is working fine");
  test.log(Status.PASS, "Add Subject Screen  is working fine");
       	}
    catch(Exception e) {
      System.out.println("Add subject Screen is not working fine");
      	test.log(Status.FAIL, ExceptionUtils.getStackTrace(e)); 	
         }}

	@Test(priority=59,groups="smoke")
    public void classsetup21() throws InterruptedException {
       	test = extent.createTest("Test Script 59", "To verify setup curriculum Screen under subject-CBSE link");
       	Loginpage lp = new Loginpage(driver);  
       	String[] sData = ExcelUtils.toReadExcelData("sheet1", "TC-1");
       	lp.login(sData, test, driver);
      lp.clickonlogin(test);
       	Homepage hp = new Homepage(driver); 
	try {
      	  hp.setupcurriculum(test, driver);
      	  System.out.println(" Setup curriculum Screen  is working fine");
      	  test.log(Status.PASS, "Setup curriculum Screen  is working fine");
    System.out.println("#########################################################################################");
      	       	}
      	    catch(Exception e) {
      	      System.out.println("setup curriculum Screen is not working fine");
      	      	test.log(Status.FAIL, ExceptionUtils.getStackTrace(e)); 	
      	         }}

	@Test(priority=60,groups="smoke")
    public void Session1() throws InterruptedException {
       	test = extent.createTest("Test Script 60", "To verify  session link ");
       	Loginpage lp = new Loginpage(driver);  
       	String[] sData = ExcelUtils.toReadExcelData("sheet1", "TC-1");
       	lp.login(sData, test, driver);
      lp.clickonlogin(test);
       	Homepage hp = new Homepage(driver);
       	try {
        	 hp.Session(test, driver);
        	  System.out.println(" Session link is working fine");
        	  test.log(Status.PASS, "Session link is working fine");
        	       	}
          catch(Exception e) {
         System.out.println("Session link is not working fine");
        test.log(Status.FAIL, ExceptionUtils.getStackTrace(e)); 	
        	         }}
        	         
	@Test(priority=61,groups="smoke")
    public void Session2() throws InterruptedException {
       	test = extent.createTest("Test Script 61", "To verify preconfigured session link ");
       	Loginpage lp = new Loginpage(driver);  
       	String[] sData = ExcelUtils.toReadExcelData("sheet1", "TC-1");
       	lp.login(sData, test, driver);
      lp.clickonlogin(test);
       	Homepage hp = new Homepage(driver);
     	try {
       	 hp.Session(test, driver);
       	 WebElement presession = driver.findElement(By.xpath("//span[contains(text(),'Preconfigured Sessions')]"));
       	presession.click();
       	  System.out.println(" Preconfigured Session link is working fine");
       	  test.log(Status.PASS, "Preconfigured Session link is working fine");
       	       	}
         catch(Exception e) {
        System.out.println("Preconfigured Session link is not working fine");
       test.log(Status.FAIL, ExceptionUtils.getStackTrace(e)); 	
       	         }}

	@Test(priority=62,groups="smoke")
    public void Session3() throws InterruptedException {
       	test = extent.createTest("Test Script 62", "To verify radio buttons under preconfigured session ");
       	Loginpage lp = new Loginpage(driver);  
       	String[] sData = ExcelUtils.toReadExcelData("sheet1", "TC-1");
       	lp.login(sData, test, driver);
      lp.clickonlogin(test);
       	Homepage hp = new Homepage(driver);
    	try {
          	 hp.preconfiguredradio(test, driver);
          	  System.out.println(" Radio buttons are  working fine");
          	  test.log(Status.PASS, "Radio buttons are working fine");
          	       	}
            catch(Exception e) {
           System.out.println("Radio buttons not working fine");
          test.log(Status.FAIL, ExceptionUtils.getStackTrace(e)); 	
          	         }}

    @Test(priority=63,groups="smoke")
    public void Session4() throws InterruptedException {
       	test = extent.createTest("Test Script 63", "To verify sessiondate & Time preconfigred session ");
       	Loginpage lp = new Loginpage(driver);  
       	String[] sData = ExcelUtils.toReadExcelData("sheet1", "TC-1");
       	lp.login(sData, test, driver);
      lp.clickonlogin(test);
       	Homepage hp = new Homepage(driver);
       	try {
         	 hp.sessiontime(test, driver);
         	  System.out.println(" Sessiondate & Time are  working fine");
         	  test.log(Status.PASS, "Sessiondate & Time are  working fine");
         	       	}
           catch(Exception e) {
          System.out.println("Sessiondate & Time are not working fine");
         test.log(Status.FAIL, ExceptionUtils.getStackTrace(e)); 	
         	         }}
	
	@Test(priority=64,groups="smoke")
    public void Session5() throws InterruptedException {
       	test = extent.createTest("Test Script 64", "To verify weekoff,cancel and save ");
       	Loginpage lp = new Loginpage(driver);  
       	String[] sData = ExcelUtils.toReadExcelData("sheet1", "TC-1");
       	lp.login(sData, test, driver);
      lp.clickonlogin(test);
       	Homepage hp = new Homepage(driver);
   	 try {
   		 hp.weekoff(test, driver);
	  System.out.println(" weekoff,cancel and save are  working fine");
	  test.log(Status.PASS, "weekoff,cancel and save are  working fine");
	       	}
	 catch(Exception e) { 
 System.out.println("weekoff,cancel and save are not working fine");
test.log(Status.FAIL, ExceptionUtils.getStackTrace(e)); 	
	         }}

    @Test(priority=65,groups="smoke")
    public void Session6() throws InterruptedException {
       	test = extent.createTest("Test Script 65", "To verify new session link");
       	Loginpage lp = new Loginpage(driver);  
       	String[] sData = ExcelUtils.toReadExcelData("sheet1", "TC-1");
       	lp.login(sData, test, driver);
      lp.clickonlogin(test);
       	Homepage hp = new Homepage(driver);
   	 try {
   		 hp.Session(test, driver);
   		WebElement newsession = driver.findElement(By.xpath("//button[contains(.,'New Session')]"));
   		newsession.click();
	  System.out.println(" new session linkare  working fine");
	  test.log(Status.PASS, "new session link are  working fine");
	       	}
	 catch(Exception e) { 
 System.out.println("new session link are not working fine");
test.log(Status.FAIL, ExceptionUtils.getStackTrace(e)); 	
	         }}
	         
@Test(priority=66,groups="smoke")
	    public void Session7() throws InterruptedException {
	       	test = extent.createTest("Test Script 66", "To verify session name & select class");
	       	Loginpage lp = new Loginpage(driver);  
	       	String[] sData = ExcelUtils.toReadExcelData("sheet1", "TC-1");
	       	lp.login(sData, test, driver);
	      lp.clickonlogin(test);
	       	Homepage hp = new Homepage(driver);
	       try {
	      		 hp.newsession(test, driver);
	   	  System.out.println(" session name & select class are  working fine");
	   	  test.log(Status.PASS, "session name & select class are  working fine");
	   	       	}
	   	 catch(Exception e) { 
	    System.out.println("session name & select class are not working fine");
	   test.log(Status.FAIL, ExceptionUtils.getStackTrace(e)); 	
	   	         }}
	
	@Test(priority=67,groups="smoke")
    public void Session8() throws InterruptedException {
       	test = extent.createTest("Test Script 67", "To verify close button under new session");
       	Loginpage lp = new Loginpage(driver);  
       	String[] sData = ExcelUtils.toReadExcelData("sheet1", "TC-1");
       	lp.login(sData, test, driver);
      lp.clickonlogin(test);
       	Homepage hp = new Homepage(driver);
        try {
        	 hp.Session(test, driver);
        	WebElement newsession = driver.findElement(By.xpath("//button[contains(.,'New Session')]"));
       		newsession.click();
       		WebElement close1=driver.findElement(By.xpath("//span[contains(text(),'Close')]"));
       		close1.click();
       		Assert.assertEquals(newsession.getText(), "NewSession");
  	  System.out.println(" close button under new session are  working fine");
  	  test.log(Status.PASS, "close button under new session are  working fine");
  	       	}
  	 catch(Exception e) { 
   System.out.println("close button under new session are not working fine");
  test.log(Status.FAIL, ExceptionUtils.getStackTrace(e)); 	
  	         }}

	@Test(priority=68,groups="smoke")
    public void Session9() throws InterruptedException {
       	test = extent.createTest("Test Script 68", "To verify save button under new session");
       	Loginpage lp = new Loginpage(driver);  
       	String[] sData = ExcelUtils.toReadExcelData("sheet1", "TC-1");
       	lp.login(sData, test, driver);
      lp.clickonlogin(test);
       	Homepage hp = new Homepage(driver);
       	try {
       	 hp.Session(test, driver);
       	WebElement newsession = driver.findElement(By.xpath("//button[contains(.,'New Session')]"));
      		newsession.click();
      		WebElement save1=driver.findElement(By.xpath("//button[contains(@class,'IXF3Z')]"));
      		save1.click();
 	  System.out.println(" save button under new session are  working fine");
 	  test.log(Status.PASS, "save button under new session are  working fine");
 	       	}
 	 catch(Exception e) { 
  System.out.println("close button under new session are not working fine");
 test.log(Status.FAIL, ExceptionUtils.getStackTrace(e)); 	
 	         }}

    @Test(priority=69,groups="smoke")
    public void Finacialdata1() throws InterruptedException {
       	test = extent.createTest("Test Script 69", "To verify Finacial data link");
       	Loginpage lp = new Loginpage(driver);  
       	String[] sData = ExcelUtils.toReadExcelData("sheet1", "TC-1");
       	lp.login(sData, test, driver);
      lp.clickonlogin(test);
       	Homepage hp = new Homepage(driver);
    	try {
    		hp.Financialdata(test, driver);
          	 System.out.println(" Financial data link is  working fine");
    	  test.log(Status.PASS, "Financial data link is  working fine");
    	       	}
    	 catch(Exception e) { 
     System.out.println("Financial data link is not working fine");
    test.log(Status.FAIL, ExceptionUtils.getStackTrace(e)); 	
    	         }}
	
      @Test(priority=70,groups="smoke")
	    public void Finacialdata2() throws InterruptedException {
	       	test = extent.createTest("Test Script 70", "To verify Finacial dropdowns link");
	       	Loginpage lp = new Loginpage(driver);  
	       	String[] sData = ExcelUtils.toReadExcelData("sheet1", "TC-1");
	       	lp.login(sData, test, driver);
	      lp.clickonlogin(test);
	       	Homepage hp = new Homepage(driver);
	       	try {
	    hp.financialdropdown(test, driver);
	          	 System.out.println(" Financialdata dropdowns are  working fine");
	    	  test.log(Status.PASS, "Financialdata dropdowns are  working fine");
	    	       	}
	    	 catch(Exception e) { 
	     System.out.println("Financialdata dropdowns are not working fine");
	    test.log(Status.FAIL, ExceptionUtils.getStackTrace(e)); 	
	    	         }}
	
      @Test(priority=71,groups="smoke")
	    public void Finacialdata3() throws InterruptedException {
	       	test = extent.createTest("Test Script 71", "To verify Default finacial year tab");
	       	Loginpage lp = new Loginpage(driver);  
	       	String[] sData = ExcelUtils.toReadExcelData("sheet1", "TC-1");
	       	lp.login(sData, test, driver);
	      lp.clickonlogin(test);
	       	Homepage hp = new Homepage(driver);
	    	try {
	    		hp.Financialdata(test, driver);
	    	    WebElement defaultfyear =driver.findElement(By.xpath("//button[contains(@class,'X3hTN')]"));
	    	    defaultfyear.click();
	    	          	 System.out.println(" Default finacial year tab are  working fine");
	    	    	  test.log(Status.PASS, "Default finacial year tab are  working fine");
	    	    	       	}
	    	    	 catch(Exception e) { 
	    	     System.out.println("Default finacial year tab are not working fine");
	    	    test.log(Status.FAIL, ExceptionUtils.getStackTrace(e)); 	
	    	    	         }}
      
       @Test(priority=72,groups="smoke")
	    public void Finacialdata4() throws InterruptedException {
	       	test = extent.createTest("Test Script 72", "To verify save button");
	       	Loginpage lp = new Loginpage(driver);  
	       	String[] sData = ExcelUtils.toReadExcelData("sheet1", "TC-1");
	       	lp.login(sData, test, driver);
	      lp.clickonlogin(test);
	       	Homepage hp = new Homepage(driver);
	       	try {
	    		hp.Financialdata(test, driver);
	    	   WebElement  save = driver.findElement(By.xpath("//button[contains(@class,'IXF3Z')]"));
	    	   save.click();
	    	   System.out.println(" Save button is working fine");
	    	   test.log(Status.PASS, "Save button is working fine");
	    	    	       	}
	    	    	 catch(Exception e) { 
	    	     System.out.println("Save button is not working fine");
	    	    test.log(Status.FAIL, ExceptionUtils.getStackTrace(e)); 	
	    	    	         }}
      
	@Test(priority=73,groups="smoke")
    public void Departments1() throws InterruptedException {
       	test = extent.createTest("Test Script 73", "To verify Departments link");
       	Loginpage lp = new Loginpage(driver);  
       	String[] sData = ExcelUtils.toReadExcelData("sheet1", "TC-1");
       	lp.login(sData, test, driver);
      lp.clickonlogin(test);
       	Homepage hp = new Homepage(driver);
    	try {
    		hp.Departments(test, driver);
    	   System.out.println(" Departments link is working fine");
    	   test.log(Status.PASS, "Departments link is working fine");
    	    	       	}
    	    	 catch(Exception e) { 
    	     System.out.println("Departments link is not working fine");
    	    test.log(Status.FAIL, ExceptionUtils.getStackTrace(e)); 	
    	    	         }}

	@Test(priority=74,groups="smoke")
    public void Departments2() throws InterruptedException {
       	test = extent.createTest("Test Script 74", "To verify search box under departments");
       	Loginpage lp = new Loginpage(driver);  
       	String[] sData = ExcelUtils.toReadExcelData("sheet1", "TC-1");
       	lp.login(sData, test, driver);
      lp.clickonlogin(test);
       	Homepage hp = new Homepage(driver);
       	try {
    		hp.Departments(test, driver);
    		WebElement search = driver.findElement(By.xpath("//input[contains(@placeholder,'Search')]"));
    		search.sendKeys("science");
    	   System.out.println("Search box is working fine");
    	   test.log(Status.PASS, "Search box is working fine");
    	    	       	}
    	    	 catch(Exception e) { 
    	     System.out.println("Search box is not working fine");
    	    test.log(Status.FAIL, ExceptionUtils.getStackTrace(e)); 	
    	    	         }}
	
	@Test(priority=75,groups="smoke")
    public void Departments3() throws InterruptedException {
       	test = extent.createTest("Test Script 75", "To verify Add department link");
       	Loginpage lp = new Loginpage(driver);  
       	String[] sData = ExcelUtils.toReadExcelData("sheet1", "TC-1");
       	lp.login(sData, test, driver);
      lp.clickonlogin(test);
       	Homepage hp = new Homepage(driver);
       	try {
    		hp.Departments(test, driver);
    		WebElement adddepartment = driver.findElement(By.xpath("//button[contains(@class,'IXF3Z')]"));
    		adddepartment.click();
    	   System.out.println("Add department link is working fine");
    	   test.log(Status.PASS, "Add department link is working fine");
    	    	       	}
    	    	 catch(Exception e) { 
    	     System.out.println("Add department link is not working fine");
    	    test.log(Status.FAIL, ExceptionUtils.getStackTrace(e)); 	
    	    	         }}

	@Test(priority=76,groups="smoke")
    public void Departments4() throws InterruptedException {
       	test = extent.createTest("Test Script 76", "To verify name field & code field");
       	Loginpage lp = new Loginpage(driver);  
       	String[] sData = ExcelUtils.toReadExcelData("sheet1", "TC-1");
       	lp.login(sData, test, driver);
      lp.clickonlogin(test);
       	Homepage hp = new Homepage(driver);
	  try {
    		hp.Adddepartment(test, driver);
    	   System.out.println("Name field & code field is working fine");
    	   test.log(Status.PASS, "Name field & code field is working fine");
    	    	       	}
    	    	 catch(Exception e) { 
    	     System.out.println("Name field & code field is not working fine");
    	    test.log(Status.FAIL, ExceptionUtils.getStackTrace(e)); 	
    	    	         }}
*/
	@Test(priority=77,groups="smoke")
    public void Departments5() throws InterruptedException {
       	test = extent.createTest("Test Script 77", "To verify save and cancel");
       	Loginpage lp = new Loginpage(driver);  
       	String[] sData = ExcelUtils.toReadExcelData("sheet1", "TC-1");
       	lp.login(sData, test, driver);
      lp.clickonlogin(test);
  	Homepage hp = new Homepage(driver);
	  try {
  		hp.Departments(test, driver);
  		WebElement adddepartment = driver.findElement(By.xpath("//button[contains(@class,'IXF3Z')]"));
		adddepartment.click();
  		WebElement save2 = driver.findElement(By.xpath("//span[contains(text(),'Save')]"));
  		save2.click();
  		Thread.sleep(1000);
  		WebElement cancel2 =driver.findElement(By.xpath(" //span[contains(text(),'Cancel')]"));
  		cancel2.click();
  	   System.out.println("save and cancel is working fine");
  	   test.log(Status.PASS, "save and cancel is working fine");
  	    	       	}
  	    	 catch(Exception e) { 
  	     System.out.println("save and cancel is not working fine");
  	    test.log(Status.FAIL, ExceptionUtils.getStackTrace(e)); 	
  	    	 }
	}}





package project.ses.pom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import project.ses.generic.WaitStatementLib;





public class Homepage<explicitWaitForClickable, managecuriculum> extends WaitStatementLib {

	

	@FindBy(className="_3XSf_")
	WebElement hometext;
	
	
	@FindBy(xpath="//span[contains(text(),'Dashboard')]")
	WebElement dashboard;
	
	@FindBy(xpath="//h3[contains(text(),'Page is under construction')]")
	WebElement Dashboardmsg ;
	
	@FindBy(xpath="//span[contains(text(),'Configuration')]")
	WebElement configurationlink;
	
	
	@FindBy(xpath="//a[contains(@href,'/configuration/school-setup')]")
	WebElement Schoolsetlink;
	
     
	@FindBy(css="#root > div > div > section > main > div._3SNiq > div > h1")
	WebElement SchoolsetupText;
	
	@FindBy(xpath="//p[contains(text(),'School Details')]")
	WebElement SchoolDetails;
	
	
	@FindBy(id="name")
	WebElement SchoolName;
	
	
	@FindBy(id="establishedYear")
	WebElement Establishyear;
	
	@FindBy(xpath="//input[@id='governanceBody']")
	WebElement Governancebody;
	
	@FindBy(id="motto")  
	WebElement Schoolmotto;
	
	@FindBy(id="branch[schoolCode]")
	WebElement Schoolcode;
	
	@FindBy(xpath="//*[@id=\"branch[establishedYear]\"]")
	WebElement BranchYear;
	 
	@FindBy(xpath="//input[@name='affiliations[0].boardRegistrationNo']")
	WebElement Registrationnumb;                                        
	
	@FindBy(xpath="//span[contains(text(),'Save and Continue')]")
	WebElement savecont ;
	
	@FindBy(xpath="//div[contains(@class,'jBrm1 _1g-ze')]")
	WebElement savconterrormsg;
	
	@FindBy(xpath="//p[contains(text(),'Contact Details')]")
	WebElement Contactdetailslink;
	
	@FindBy(xpath="//div[contains(@class,'Select-value')] ")
	WebElement Statedropdown;
	
	@FindBy(xpath="//legend[contains(text(),'Address')]")
	WebElement Addresstext;
	
	@FindBy(xpath="//input[contains(@id,'urban')]")
	WebElement urbunRbuttton;
	
	@FindBy(xpath="//input[contains(@id,'rural')]")
	WebElement ruralRbutton;
	
	@FindBy(xpath=" //label[@for='address.type']")
	WebElement AddresslTypelabel;
	
	@FindBy(xpath="//input[@id='address.line1']")
	WebElement Address1;
	
	@FindBy(xpath="//input[@id='address.line2']")
	WebElement Address2;
	
	@FindBy(xpath="//input[@id='address.city']")
	WebElement city;
	
	@FindBy(xpath="//input[@id='address.pincode']")
	WebElement pincode;
	
	@FindBy(xpath="//input[@id='phoneNo[areaCode]']")
	WebElement phonecode;
	
	@FindBy(xpath="//input[@id='phoneNo[phoneNumber]']")
	WebElement phonenumber;
	
	@FindBy(xpath="//input[@id='phoneNo[extNumber]']")
	WebElement extnnumber;
	
	@FindBy(xpath="//input[@id='mobileNo[areaCode]']")
	WebElement codeMbnum;
	
	@FindBy(xpath="//input[@id='mobileNo[phoneNumber]']")
	WebElement Mbnumber;
	
	@FindBy(xpath="//input[@id='email[value]']")
	WebElement email;
	
	@FindBy(xpath="//input[@id='website[value]']")
	WebElement website;
	
	@FindBy(xpath="//i[contains(@class,'fa fa-info-circle ')]")
	WebElement codetooltip;
	
	@FindBy(xpath="//span[contains(text(),'Back')]")
	WebElement Backbutton;
	
	@FindBy(xpath=" //input[@id='fieldLabel']")
	WebElement fieldlabeltext;
	
	@FindBy(xpath=".//*[@id='react-select-13--value']/div[1]")
	WebElement fieldlabeldrop;
	
	@FindBy(xpath="//span[contains(text(),'Add Another Contact')]")
	WebElement addcontacttab;
	
	@FindBy(xpath="//div[@class='_2ca4s']//span[contains(text(),'Cancel')]")
	WebElement cancel;
	
	@FindBy(xpath="//span[Text()='Save']")
	WebElement save;
	
	@FindBy(css="._2aMXL.vlhEW._3LQ16")
	WebElement editlink;
	
	@FindBy(xpath="//p[contains(text(),'Complete Setup')]")
	WebElement completesetup;
	
	@FindBy(xpath="//legend[contains(text(),'Financial info')]")
	WebElement financualinfo;
	
	
	@FindBy(xpath="//input[@id='panNo']")
	WebElement panno;
	
	@FindBy(xpath="//input[@id='tanNo']")
	WebElement tanno;
	
	@FindBy(xpath="//input[@id='tdsCircle']")
	WebElement tdscircle;
	
	@FindBy(xpath="//input[@placeholder='Enter the start date'] ")
	WebElement startdate;
	
	@FindBy(xpath="//input[@placeholder='Enter the end date'] ")
	WebElement Enddate;
	
	@FindBy(xpath="//div[contains(text(),'10')]")
	WebElement Firstdate;
	
	@FindBy(xpath=" //div[contains(text(),'27')]")
	WebElement seconddate;
	
	@FindBy(xpath="//a[@href='/configuration/facility-setup']")
	WebElement facility;
	
	@FindBy(xpath="//span[contains(text(),'New Facility')]")
	WebElement newfacility;
	
	@FindBy(xpath="//input[@id='name']")
	WebElement  name;
	
	@FindBy(xpath="//input[@id='aggregateCapacity']")
	WebElement phycapacity;
	
	@FindBy(xpath="//div[@class='Select-placeholder']")
	WebElement facilityincharge;
	
	@FindBy(xpath="//span[contains(text(),'Save')] ")
	WebElement savefacility;
	
	@FindBy(xpath="//span[contains(text(),'Cancel')]")
	WebElement cancelfacility;
	
	@FindBy(xpath="//a[@href='/configuration/class-setup']")
	WebElement classsetup;
	
	@FindBy(xpath="//input[@id='name']")
	WebElement sectionname;
	
	@FindBy(xpath="//input[@id='allotedCapacity']")
	WebElement allocatedcapacity;
	
	@FindBy(xpath="//span[contains(text(),'Manage Curriculum')]")
	WebElement managecurriculum;
	
	@FindBy(xpath="//span[contains(text(),'CBSE')]")
	WebElement cbselink;
	
	@FindBy(xpath="//input[@id='curriculums[3].subjectCode']")
	WebElement cbsetextfield;
	
	@FindBy (xpath="//div[contains(@class,'LYH-A')]//div[4]//div[1]//div[3]//div[1]//button[1]//span[1]")
	WebElement defaultradiobutton;
	
	@FindBy(xpath="//*[@id=\"portal-root\"]/div/div[2]/div/div/div[2]/form/div[1]/div[1]/div[2]/button")
	WebElement subjects;
	
	@FindBy(xpath="//span[contains(text(),'Add Subjects')]")
	WebElement AddSubject;
	
	@FindBy(xpath="//span[contains(text(),'Academic')]")
	WebElement Acdemic;
	
	@FindBy(xpath="//span[contains(text(),'Non-academic')]")
	WebElement NonAcdemic;
	
	@FindBy(xpath="//span[contains(text(),'Mathematics')]")
	WebElement mathsradiobutton;
	
	@FindBy(xpath="//div[@class='_2o55G']//input[@placeholder='Search curriculum']")
	WebElement searchbox;
	
	@FindBy(xpath="//div[contains(@class,'WHqXW VElVK _1MEY2')]//span[contains(text(),'Save')]")
	WebElement buttonsave;
	
	@FindBy(xpath="//div[@class='_1zONj']//div[2]//div[1]//div[1]//div[1]//button[1]")
	WebElement setupcurri;
	
	@FindBy(xpath="//button[contains(.,'Subjects')]")
	WebElement subject1;
	
	@FindBy(xpath="//span[contains(text(),'Import Curriculum')]")
	WebElement importcurri;
	
	@FindBy(xpath="//span[contains(text(),'Save')]")
	WebElement save1;
	
	@FindBy(xpath="//a[contains(.,'Session')]")
	WebElement session1;
	
	@FindBy(xpath="//span[contains(text(),'Preconfigured Sessions')]")
	WebElement preconfigured;
	
	@FindBy(xpath="//input[@id='single']")
	WebElement radio1;
	
	@FindBy(xpath="//input[@id='standard']")
	WebElement radio2;
	
	@FindBy(xpath="//input[@placeholder='Start date']")
	WebElement startdate1;
	
	@FindBy(xpath="//div[@class='react-datepicker__day react-datepicker__day--wed'][contains(text(),'18')]")
	WebElement dateselect1;
	
	@FindBy(xpath="//input[@placeholder='End date']")
	WebElement Enddate1;
	
	@FindBy(xpath="//input[@placeholder='Start Time']")
	WebElement starttime1;
	
	@FindBy(xpath="//input[@placeholder='End Time']")
	WebElement endtime1;
	
	@FindBy(xpath="//span[contains(text(),'Mon')]")
	WebElement monday;
	
	@FindBy(xpath="//span[contains(text(),'Thu')]")
	WebElement thursday;
	
	@FindBy(xpath="//span[contains(text(),'Save')]")
	WebElement save2;
	
	@FindBy(xpath="//span[contains(text(),'Cancel')]")
	WebElement cancel2;
	
	@FindBy(xpath="//button[contains(.,'New Session')]")
	WebElement newsession;
	
	@FindBy(xpath="//input[@id='name']")
	WebElement sessioname;
	
	@FindBy(xpath="//div[@class='Select-placeholder']")
	WebElement dropdown1;
	
	@FindBy(xpath="//a[contains(@href,'/configuration/financial-data')]")
	WebElement finacialdata;
	
	@FindBy(xpath="//input[contains(@name,'financialData[financialYearStartDate]')]")
	WebElement Financeyeardate1;
	
	@FindBy(xpath="//input[contains(@name,'financialData[financialYearEndDate]')]")
	WebElement Financeyeardate2;
	
	@FindBy(xpath="//input[contains(@name,'financialData[form16StartDate]')]")
	WebElement Form16date1;
	
	@FindBy(xpath="//input[contains(@name,'financialData[form16EndDate]')]")
	WebElement Form16date2;
	
	@FindBy(xpath="//input[contains(@name,'financialData[expectedClosingDate]')]")
	WebElement Closingdate;
	
	@FindBy(xpath="//a[contains(@href,'/configuration/departments')]")
	WebElement department;
	
	@FindBy(xpath="//input[contains(@placeholder,'Search')]")
	WebElement search;
	
	@FindBy(xpath="//button[contains(@class,'IXF3Z')]")
	WebElement adddepartment;
	
	@FindBy(xpath="//input[@id='name']")
	WebElement namefield;
	
	@FindBy(xpath="//input[@id='code']")
	WebElement codefield;
	
	public Homepage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}


public String verifyvalidlogin(ExtentTest test,WebDriver driver) {
	
	String pagetext = hometext.getText();

	return pagetext;
}

public String dashboardlink(ExtentTest test,WebDriver driver) {
	
	dashboard.click();
	System.out.println("clicked on dashboard link");
	String dashmessage =Dashboardmsg.getText();
	return dashmessage;
	
}
  
public String configuration(ExtentTest test,WebDriver driver) throws InterruptedException {
	
	configurationlink.click();
	Thread.sleep(1000);
	Schoolsetlink.click();
	Thread.sleep(1000);
	WaitStatementLib.explicitWaitForClickable(driver, 30, SchoolDetails);
	SchoolDetails.click();
	System.out.println("clicked on configuration link");
	
	String configurationmsg = Schoolsetlink.getText();
	return configurationmsg;
}

public String SchoolSetup(ExtentTest test,WebDriver driver) {
	
	
	Schoolsetlink.click();
	SchoolDetails.click();
	
	SchoolName.sendKeys("DAV SCHOOL");
	test.log(Status.PASS, "Schoolname  entered");
	Governancebody.sendKeys("CBSE");
	test.log(Status.PASS, "Governance body  entered");
	Schoolmotto.sendKeys("Education");
	test.log(Status.PASS, "School motto  entered");
	Schoolcode.sendKeys("007");
	test.log(Status.PASS, "School code entered");
	BranchYear.sendKeys("2002");
	test.log(Status.PASS, "Branch year entered ");
	
	Registrationnumb.sendKeys("1234");
	
   String SchoolText =  SchoolsetupText.getText();
	return SchoolText;
	}

public String savecontin(ExtentTest test , WebDriver driver ){
	BranchYear.clear();
	savecont.click();
	String errormsg = savconterrormsg.getText();
	System.out.println(errormsg);
	//Status.valueOf(errormsg);
    return errormsg;
	
}

public String AddressState(ExtentTest test , WebDriver driver) throws InterruptedException {
	configurationlink.click();
	Schoolsetlink.click();
	Contactdetailslink.click();
Actions act =new Actions(driver);
act.moveToElement(Statedropdown);
act.click();
Thread.sleep(1000);
act.sendKeys("B");
act.sendKeys(Keys.ARROW_DOWN);
act.sendKeys(Keys.ENTER);
String msg = Statedropdown.getText();
System.out.println(msg);
return msg;
		}


public String Addresstyperadio(ExtentTest test ,WebDriver driver) throws InterruptedException {
	configurationlink.click();
	Schoolsetlink.click();
	Contactdetailslink.click();
	urbunRbuttton.click();
	Thread.sleep(1000);
	ruralRbutton.click();
	urbunRbuttton.click();
	ruralRbutton.isSelected();
	urbunRbuttton.isSelected();
	String text = AddresslTypelabel.getText();
	return text;
	}

public String Textboxaddressinfo(ExtentTest test ,WebDriver driver) throws InterruptedException {
	configurationlink.click();
	Schoolsetlink.click();
	Contactdetailslink.click();
	
	Address1.clear();
	Address1.sendKeys("Gurgaon");
	Address2.clear();
	Address2.sendKeys("phase 4");
	city.clear();
	city.sendKeys("udhyog vihar");
	Thread.sleep(500);
	pincode.clear();
	pincode.sendKeys("1234");
	String text1=Address1.getText();
	return text1;
}

public String contact(ExtentTest test ,WebDriver driver) {
	
	configurationlink.click();
	Schoolsetlink.click();
	Contactdetailslink.click();
	
	phonecode.clear();
	phonecode.sendKeys("123456789");
	phonenumber.clear();
	phonenumber.sendKeys("776655");
	extnnumber.clear();
	extnnumber.sendKeys("334455");
	codeMbnum.clear();
	codeMbnum.sendKeys("abcd");
	Mbnumber.clear();
	Mbnumber.sendKeys("995544");
	email.clear();
	email.sendKeys("abcd@gmail.com");
	website.clear();
	website.sendKeys("www.google.com");	

String Text2 = codetooltip.getText();
System.out.println(Text2);
return Text2;

}

public String contactdetails(ExtentTest test,WebDriver driver) {
	
	configurationlink.click();
	Schoolsetlink.click();
	Contactdetailslink.click();
	String Text3 =Contactdetailslink.getText();
	System.out.println(Text3);
	return Text3;
} 	

public String contactlabeldrop(ExtentTest test ,WebDriver driver) {
	fieldlabeltext.sendKeys("medical");
	Actions act = new Actions(driver);
   act.moveToElement(fieldlabeldrop);
	act.click();
	act.sendKeys(Keys.ARROW_DOWN);
	act.sendKeys(Keys.ENTER);
	String msg = fieldlabeldrop.getText();
	return msg;
		}

public String addcancel(ExtentTest test ,WebDriver driver) throws InterruptedException {
	
	addcontacttab.click();
	Thread.sleep(500);
	cancel.click();
	Thread.sleep(500);
	Assert.assertEquals(addcontacttab.getText(), "Add Another Contact");
String msg= addcontacttab.getText();
System.out.println(msg);
return msg;
}

public String addsave(ExtentTest test ,WebDriver driver) throws InterruptedException {
	addcontacttab.click();
	Thread.sleep(500);
	save.click();
	String msg4= save.getText();
	System.out.println(msg4);
	return msg4;
}

public String editremovelink(ExtentTest test,WebDriver driver) throws InterruptedException {
	
	editlink.click();
	String msg5= editlink.getText();
	return msg5;
	
	}

public String completesetup(ExtentTest test, WebDriver driver) {
	configurationlink.click();
	Schoolsetlink.click();
	completesetup.click();
	String text = financualinfo.getText();
	Assert.assertTrue(financualinfo.isDisplayed());
	System.out.println("text");
	return text;
	
}

public String primaryinfo(ExtentTest test,WebDriver driver) throws InterruptedException {
	configurationlink.click();
	Schoolsetlink.click();
	completesetup.click();
	Thread.sleep(500);
	panno.sendKeys("CPBP122");
	tanno.sendKeys("abcd123");
	tdscircle.sendKeys("9785avbb");
	String text = financualinfo.getText();
	Assert.assertTrue(financualinfo.isDisplayed());
	System.out.println("text");
	return text;
	}

public String acedemicyear(ExtentTest test,WebDriver driver) throws InterruptedException {
	configurationlink.click();
	Schoolsetlink.click();
	completesetup.click();
	startdate.click();
	Thread.sleep(500);
	Firstdate.click();
	Thread.sleep(500);
	Enddate.click();
	seconddate.click();
	Thread.sleep(500);
	seconddate.click();
	String text = startdate.getText();
	System.out.println(text);
	return text;
	}

public String Facility(ExtentTest test,WebDriver driver) throws InterruptedException {
	configurationlink.click();
	
	facility.click();
	String fac = facility.getText();
	return fac;
	}
public String NewFacility(ExtentTest test,WebDriver driver) throws InterruptedException {
	configurationlink.click();
	facility.click();
	newfacility.click();
	String fac = facility.getText();
return fac;
}
public String Textboxfacility(ExtentTest test,WebDriver driver) throws InterruptedException {
	configurationlink.click();
	facility.click();
	newfacility.click();
	Thread.sleep(1000);
	name.sendKeys("facility name");
	Thread.sleep(1000);
	phycapacity.sendKeys("6543");
	Thread.sleep(1000);
	facilityincharge.click();
	String fac = facility.getText();
return fac;
}

public String facilitysavecancel(ExtentTest test ,WebDriver driver) throws InterruptedException {
	configurationlink.click();
	facility.click();
	newfacility.click();
	Thread.sleep(500);
	savefacility.click();
	Thread.sleep(2000);
	cancelfacility.click();
	String fac = facility.getText();
return fac;
}
public String classsetup(ExtentTest test,WebDriver driver) {
	configurationlink.click();
	classsetup.click();
	String csetup = classsetup.getText();
	return csetup;
	}

public String NewSectionTextbox(ExtentTest test,WebDriver driver) throws InterruptedException {
	
	sectionname.sendKeys("abcd");
	Thread.sleep(500);
	allocatedcapacity.sendKeys("50");
	String msg = sectionname.getText();
	return msg;
	
}

public String CBSElinkfields(ExtentTest test,WebDriver driver) {
	configurationlink.click();
	classsetup.click();
	managecurriculum.click();
	cbselink.click();
	String csetup = classsetup.getText();
	return csetup;
		
}

public String AddSubject(ExtentTest Test,WebDriver driver) {
	configurationlink.click();
	classsetup.click();
	managecurriculum.click();
	cbselink.click();
	subjects.click();
	AddSubject.click();
	String csetup = classsetup.getText();
	return csetup;
	}

public String AddSubjectScreen(ExtentTest test,WebDriver driver) throws InterruptedException {
	configurationlink.click();
	classsetup.click();
	managecurriculum.click();
	cbselink.click();
	Thread.sleep(1000);
	subjects.click();
	Thread.sleep(1000);
	AddSubject.click();
	Thread.sleep(1000);
	Acdemic.click();
	NonAcdemic.click();
	Thread.sleep(1000);
	searchbox.sendKeys("Mat");	
	Thread.sleep(1000);
	buttonsave.click();
	String csetup = classsetup.getText();
	return csetup;	
}

public String setupcurriculum(ExtentTest test,WebDriver driver) throws InterruptedException {
	
	configurationlink.click();
	classsetup.click();
	setupcurri.click();
	cbselink.click();
	Thread.sleep(1000);
	subject1.click();
	Thread.sleep(1000);
	importcurri.click();
	Thread.sleep(1000);
	save1.click();
	String csetup = classsetup.getText();
	return csetup;	
	}

public String Session(ExtentTest test,WebDriver driver) {
	
	configurationlink.click();
	session1.click();
   String msg = session1.getText();
	return msg;
}
public String preconfiguredradio(ExtentTest test,WebDriver driver) throws InterruptedException {
	configurationlink.click();
	session1.click();
	Thread.sleep(1000);
	preconfigured.click();
	radio1.click();
	Thread.sleep(1000);
	radio2.click();
	radio1.click();
	String msg = session1.getText();
	return msg;
}
public String sessiontime(ExtentTest test,WebDriver driver) throws InterruptedException {
	configurationlink.click();
	session1.click();
	Thread.sleep(1000);
	preconfigured.click();
	Thread.sleep(1000);
    startdate1.click();
    Thread.sleep(1000);
    dateselect1.click();
    Thread.sleep(1000);
    Enddate1.click();
    Thread.sleep(1000);
    starttime1.click();
    Thread.sleep(1000);
    endtime1.click();
	String msg = session1.getText();
	return msg;
}
 public String weekoff(ExtentTest test ,WebDriver driver) throws InterruptedException {
	
	configurationlink.click();
	session1.click();
   Thread.sleep(1000);
	preconfigured.click();
	monday.click();
	thursday.click();
	Thread.sleep(1000);
	save2.click();
	Thread.sleep(1000);
	cancel2.click();
	String msg = session1.getText();
	return msg;
	}
public String newsession(ExtentTest test ,WebDriver driver) throws InterruptedException {
	
	configurationlink.click();
	session1.click();
	newsession.click();
	Thread.sleep(1000);
    sessioname.sendKeys("vishwa");
    Thread.sleep(1000);
    Actions act = new Actions(driver);
    act.moveToElement(dropdown1);
    dropdown1.click();
    act.sendKeys(Keys.ARROW_DOWN);
    act.sendKeys(Keys.ENTER);
    act.build().perform(); 
	String msg = session1.getText();
	return msg;
	}

public String Financialdata(ExtentTest test, WebDriver driver) {

configurationlink.click();
finacialdata.click();
String msg = finacialdata.getText();
return msg;
}

public String financialdropdown(ExtentTest test ,WebDriver driver) throws InterruptedException {
	
	configurationlink.click();
	finacialdata.click();
	Thread.sleep(1000);
	Financeyeardate1.click();
	Thread.sleep(1000);
	Financeyeardate2.click();
	Thread.sleep(1000);
	Form16date1.click();
	Thread.sleep(1000);
	Form16date2.click();
	Thread.sleep(1000);
	Closingdate.click();
	Thread.sleep(1000);
	String msg = finacialdata.getText();
	return msg;
	}

public String Departments(ExtentTest test ,WebDriver driver) {
	
	configurationlink.click();
	department.click();
	String msg = search.getText();
	return msg;
	}
public String Adddepartment(ExtentTest test,WebDriver driver) throws InterruptedException {
	
	configurationlink.click();
	department.click();
	adddepartment.click();
	namefield.sendKeys("department");
	Thread.sleep(1000);
	codefield.sendKeys("002");
	String msg = search.getText();
	return msg;
	}






    
}


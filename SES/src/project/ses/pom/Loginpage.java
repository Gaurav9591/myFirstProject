package project.ses.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.aventstack.extentreports.ExtentTest;


public class Loginpage {

	
	@FindBy(id="omVNumber")
	 WebElement username;
	
	
	@FindBy(id="password")
	 WebElement password;
	
	
	@FindBy(css="#root > div > div > main > div > section > form > div._2IswR > button")
	 WebElement loginbutton;
	
	
	@FindBy(className="_3XSf_")
	WebElement hometext;
	
	@FindBy(className="_3mTGE")
	WebElement userrmsg;
	
	
	
	@FindBy(className ="_2p9sA")
	WebElement pwdmsg;
	
	public Loginpage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickonlogin (ExtentTest test ) {
		loginbutton.click();
		
		System.out.println("sign in clicked");
	}
	
	
	public String login(String sData[] ,ExtentTest test,WebDriver driver) {
		
		username.sendKeys(sData[1]);
		password.sendKeys(sData[2]);
		loginbutton.click();
		//test.log(LogStatus.INFO);
		String pageTitle = driver.getTitle();
		return pageTitle;
		
		
	}
	
	public String incorrectusername(ExtentTest test , WebDriver driver) {
	
		String errormsg = userrmsg.getText();
		return errormsg;	
	}

	public String incorrectpassword(ExtentTest test , WebDriver driver) {
		 
		String errorpwd = pwdmsg.getText();
		return errorpwd;
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
}

package project.ses.generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitStatementLib {
	public static void implicitWaitForSeconds
	(WebDriver driver, int time){
		driver.manage().timeouts().implicitlyWait
										(time, TimeUnit.SECONDS);
	}
	public static void implicitWaitForMinutes
	(WebDriver driver, int time){
		driver.manage().timeouts().implicitlyWait
										(time, TimeUnit.MINUTES);
	}
	public static void explicitWaitForVisibility
	(WebDriver driver, int time, WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public static void explicitWaitForClickable
	(WebDriver driver, int time, WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, time);
	wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	   public static void waitForLoad(WebDriver driver) {
	        ExpectedCondition<Boolean> pageLoadCondition = new
	                ExpectedCondition<Boolean>() {
	                    public Boolean apply(WebDriver driver) {
	                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
	                    }
	                };
	        WebDriverWait wait = new WebDriverWait(driver, 30);
	        wait.until(pageLoadCondition);
	        }}


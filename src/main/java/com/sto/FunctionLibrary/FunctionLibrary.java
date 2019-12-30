package com.sto.FunctionLibrary;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sto.Utilities.PropertyFileUtility;

public class FunctionLibrary {
	
	public static WebDriver startBrowser(WebDriver driver) throws IOException{
		
		if(PropertyFileUtility.getValueForKey("Browser").equalsIgnoreCase("chrome")){
			
			System.setProperty("webdriver.chrome.driver", "./Browser Drivers/chromedriver.exe");
		
			driver=new ChromeDriver();
		}
		if(PropertyFileUtility.getValueForKey("Browser").equalsIgnoreCase("firefox")){
			
			System.setProperty("webdriver.gecko.driver", "./Browser Drivers/geckodriver.exe");
		
			driver=new FirefoxDriver();
		}
		
		return driver;
	}
	
	public static String generateDate(){
		
		Date date=new Date();
		
		SimpleDateFormat sdf=new SimpleDateFormat("YYYY_MM_dd_ss");
		
		return sdf.format(date);
		
	}
	
	public static void openApplication(WebDriver driver) throws IOException{
		
		driver.manage().window().maximize();
		driver.navigate().to(PropertyFileUtility.getValueForKey("Home_page_URL"));
	
	}
	
	public static void openPage(WebDriver driver) throws IOException{
		driver.navigate().to(PropertyFileUtility.getValueForKey("Stay_Connected_page_URL"));
	}
	
	public static void clickAction(WebDriver driver, String locatortype, String locatorvalue) {
		
		
		if(locatortype.equalsIgnoreCase("id")) {
			
			driver.findElement(By.id(locatorvalue)).click();;
		}
		else 
			if(locatortype.equalsIgnoreCase("name")) {
		
		    driver.findElement(By.name(locatorvalue)).click();
		}
		else
			if(locatortype.equalsIgnoreCase("xpath")) {
				
			driver.findElement(By.xpath(locatorvalue)).click();
			}
		
	}

	public static void typeAction(WebDriver driver, String locatortype, String locatorvalue, String data)
{
	if(locatortype.equalsIgnoreCase("id"))
	{
		driver.findElement(By.id(locatorvalue)).clear();
		driver.findElement(By.id(locatorvalue)).sendKeys(data);
	}
	else
		if(locatortype.equalsIgnoreCase("name"))
		{	driver.findElement(By.name(locatorvalue)).clear();
			driver.findElement(By.name(locatorvalue)).sendKeys(data);
		}
		else
			if(locatortype.equalsIgnoreCase("xpath"))
			{
				driver.findElement(By.xpath(locatorvalue)).clear();
				driver.findElement(By.xpath(locatorvalue)).sendKeys(data);
			}
	
}

	/*public static void waitForElement(WebDriver driver, String locatortype, String locatorvalue, String waittime){
		
		WebDriverWait wait = new WebDriverWait(driver, Integer.parseInt(waittime));
		
		if(locatortype.equalsIgnoreCase("id")){
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorvalue)));
		}
		else if(locatortype.equalsIgnoreCase("name")){
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locatorvalue)));
			
		}
		else if(locatortype.equalsIgnoreCase("xpath")){
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorvalue)));
		}
		
	}*/
/*For time being we are using this wait, as the explicit wait is not working properly . 
	We need to make sure we make "waitForElement" work perfectly in future for better approach*/
	public static void tempWait(WebDriver driver) throws InterruptedException{
		Thread.sleep(1000);
	}

	
	
	public static WebDriver rightClickAction(WebDriver driver, String locatortype, String locatorvalue ){
		
		WebElement ele = null;
		
		
		if(locatortype.equalsIgnoreCase("id")){
		
			 ele=driver.findElement(By.id(locatorvalue));
		}
		else if(locatortype.equalsIgnoreCase("name")){
			
			 ele=driver.findElement(By.name(locatorvalue));
		}
		else if(locatortype.equalsIgnoreCase("xpath")){
			
			 ele=driver.findElement(By.xpath(locatorvalue));
		}
		
		Actions act =new Actions(driver);
		
		act.contextClick(ele).perform();
		
		return driver;
		
	}
	
	public static void selectFromDropdown(WebDriver driver, String locatortype, String locatorvalue, String data){
		
		List<WebElement> elements = null;
		
		if(locatortype.equalsIgnoreCase("id")){
			elements=driver.findElements(By.id(locatorvalue));
		}
		else if(locatortype.equalsIgnoreCase("name")){
			elements=driver.findElements(By.name(locatorvalue));
		}
		else if(locatortype.equalsIgnoreCase("xpath")){
			elements=driver.findElements(By.xpath(locatorvalue));
		}
			
		for(WebElement ele : elements){
			if(ele.getText().equalsIgnoreCase(data))
				ele.click();
			}
	}
	public static void closeBrowser(WebDriver driver){
		
		driver.close();
	}
}


package run;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.sto.Utilities.PropertyFileUtility;

public class TempRun {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.gecko.driver", "./Browser Drivers/geckodriver.exe");
		
		WebDriver driver=new FirefoxDriver();
		
		driver.get("https://sto-stage.innoraft-sites.com/user/login");
		
		driver.findElement(By.xpath("//input[@id='edit-name']")).sendKeys("superadmin");
		
		driver.findElement(By.xpath("//input[@id='edit-pass']")).sendKeys("t{PNR9}6:E");
		
		driver.findElement(By.xpath("//button[@id='edit-submit']")).click();

		Thread.sleep(3000);
		
		driver.get("https://sto-stage.innoraft-sites.com/content/stay-connected");
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("(//*[contains(text(),'Country')])[3]")).click();
		
		List<WebElement> dropdown=driver.findElements(By.xpath("//div[@id='edit_submitted_gdpr_country_chosen']/div/ul/li"));


		
		//System.out.println(dropdown.size());
		
		for(WebElement ele : dropdown){  
			if(ele.getText().equalsIgnoreCase("India")){
				ele.click();
			}
		}
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("edit-submitted-phone")).sendKeys("1234567890");
		
		
	}

}

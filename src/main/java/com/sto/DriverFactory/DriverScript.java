package com.sto.DriverFactory;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.sto.FunctionLibrary.FunctionLibrary;
import com.sto.Utilities.ExcelFileUtility;

public class DriverScript {
	
	WebDriver driver;
	ExtentHtmlReporter reporter=null;
	ExtentReports extent=null;
	ExtentTest logger=null;

	public void startTest() throws InvalidFormatException, IOException{
		
		ExcelFileUtility excel=new ExcelFileUtility();
		
		for(int i=1; i<=excel.rowCount("TestCases"); i++){
			
			String ModuleStatus="";
			
			if(excel.getData("TestCases", i, 2).equalsIgnoreCase("Y")){
				
				String TCModule=excel.getData("TestCases", i, 1);
				
				/*reporter=new ExtentHtmlReporter("./Reports/TestReport.html");
				
				extent=new ExtentReports();
				
				extent.attachReporter(reporter);
				
				logger=extent.createTest("Login Test");*/
				
				int total_rows=excel.rowCount(TCModule);
				
				for(int j=1; j<=total_rows; j++){
					
					String description = excel.getData(TCModule, j, 0);
					
					String object_type = excel.getData(TCModule, j, 1);
					
					String locator_type = excel.getData(TCModule, j, 2);
					
					String locator_value = excel.getData(TCModule, j, 3);
					
					String test_data = excel.getData(TCModule, j, 4);
					
					try{
						if(object_type.equalsIgnoreCase("startBrowser")){
							
							driver=FunctionLibrary.startBrowser(driver);
							//logger.log(Status.INFO,description );
							
						}
						if(object_type.equalsIgnoreCase("openApplication")){
							
							FunctionLibrary.openApplication(driver);
							//logger.log(Status.INFO,description);
						}
						
						//--not being used currently. check FunctionLibrary for further info--
						/*if(object_type.equalsIgnoreCase("waitForElement")){
							
							FunctionLibrary.waitForElement(driver, locator_type, locator_type, test_data);
							//logger.log(Status.PASS, description);
						}*/
						
						if(object_type.equalsIgnoreCase("typeAction")){
							
							FunctionLibrary.typeAction(driver, locator_type, locator_value, test_data);
							//logger.log(Status.INFO, description);
						}
						
						if(object_type.equalsIgnoreCase("clickAction")){
							
							FunctionLibrary.clickAction(driver, locator_type, locator_value);
							//logger.log(Status.INFO, description);
						}
						
						if(object_type.equalsIgnoreCase("selectFromDropdown")){
							
							FunctionLibrary.selectFromDropdown(driver, locator_type, locator_value, test_data);
							//logger.log(Status.INFO, description);
						}
						
						if(object_type.equalsIgnoreCase("openPage")){
							
							FunctionLibrary.openPage(driver);
							//logger.log(Status.INFO, description);
						}
						
						if(object_type.equalsIgnoreCase("tempWait")){
							
							FunctionLibrary.tempWait(driver);
							//logger.log(Status.INFO, description);
						}
						
						if(object_type.equalsIgnoreCase("closeBrowser")){
							
							FunctionLibrary.closeBrowser(driver);
							//logger.log(Status.INFO, description);
						}
						
						/*excel.setData(TCModule, j, 5, "PASS");
						ModuleStatus="true";*/
						
					}
						
					catch(Exception e){
						/*excel.setData(TCModule, j, 5,"FAIL" );
						ModuleStatus="false";*/
						break;
					}
				}
					/*if(ModuleStatus.equalsIgnoreCase("true")){
						
						excel.setData("TestCases", i, 3, "Pass");
					}
					else{
					     excel.setData("TestCases", i, 3, "Fail");
						
					}*/
				}
						/*else{
							excel.setData("TestCases", i, 3, "Not Executed");
						}
				
						reporter.stop();
						reporter.flush();*/
					
				}
			}
			
		
	}


		
	


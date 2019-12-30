package run;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import java.io.FileInputStream;
import java.io.IOException;

public class TempRun2 {

	@Test    
	public static void rowCountTest() throws Exception
	   {
		ExtentHtmlReporter reporter= new ExtentHtmlReporter("./Reports/TestReport.html");
		
		ExtentReports extent =new ExtentReports();
		
		extent.attachReporter(reporter);
		
		ExtentTest logger=extent.createTest("RowCount Test");
		
		   rowCount("TestCases");
		   
		   logger.log(Status.INFO, "count the number of lines");
		   
		   extent.flush();
	   } 
		   
		   
		   public static void rowCount(String sheetName) throws InvalidFormatException, IOException{
		   Workbook wb;
		   FileInputStream fis = new FileInputStream("C:\\Users\\BaisaliInnoraft\\workspace\\sto-automation\\Test Inputs\\Input Sheet_STO.xlsx");
	       wb=WorkbookFactory.create(fis);
	       System.out.println(wb);
	       int total=wb.getSheet(sheetName).getLastRowNum();
	       System.out.println("total number of rows :"+total);
	       
	       }
	       /*XSSFWorkbook workbook = new XSSFWorkbook(fis);
	       XSSFSheet sheet = workbook.getSheet("Sheet");
	       XSSFRow row = sheet.getRow(0);
	       int colNum = row.getLastCellNum();
	       System.out.println("Total Number of Columns in the excel is : "+colNum);
	       int rowNum = sheet.getLastRowNum()+1;
	       System.out.println("Total Number of Rows in the excel is : "+rowNum);*/
	   }
	


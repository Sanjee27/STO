package com.sto.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class ExcelFileUtility {
	
	Workbook wb;
	
	public ExcelFileUtility() throws InvalidFormatException, IOException{
	
	FileInputStream fis=new FileInputStream(new File(".\\Test Inputs\\Input sheet_STO.xlsx"));

	wb=WorkbookFactory.create(fis);
	
	}
	
	public int rowCount(String sheetname){
		return wb.getSheet(sheetname).getLastRowNum();
		
	}
	
	public int colCount(String sheetname, int rownum){
		return wb.getSheet(sheetname).getRow(rownum).getLastCellNum();
		
		
	}
	
	public String getData(String sheetname, int rownum, int colnum){
		
		String data=" ";
		
		if(wb.getSheet(sheetname).getRow(rownum).getCell(colnum).getCellType()==Cell.CELL_TYPE_NUMERIC){
			
			int celldata=(int)wb.getSheet(sheetname).getRow(rownum).getCell(colnum).getNumericCellValue();
			
			data=String.valueOf(celldata);
		}else{
			
			data=wb.getSheet(sheetname).getRow(rownum).getCell(colnum).getStringCellValue();
		}
		
		return data;
		
	}
	
	/*public void setData(String sheetname, int rownum, int column, String data) throws IOException{
		
		Sheet sh=wb.getSheet(sheetname);
		
		Row row_no=sh.getRow(rownum);
		
		Cell cell=row_no.createCell(column);
		
		cell.setCellValue(data);
		
		FileOutputStream fos=new FileOutputStream(new File(".\\TestOutput\\OutputSheet.xlsx"));
		
		wb.write(fos);
		
		fos.flush();
		
		fos.close();
		
		
	}*/
	
	public void setData(String sheetname, int rownum, int column, String data) throws IOException{
		
		Sheet sh=wb.getSheet(sheetname);
		Row rowNum=sh.getRow(rownum);
		Cell cell=rowNum.createCell(column);
		
		cell.setCellValue(data);
		
	 if (data.equalsIgnoreCase("PASS")){
		 
		 CellStyle style=wb.createCellStyle();
		 
		 Font font=wb.createFont();
		 
		 font.setColor(IndexedColors.GREEN.getIndex());
		 
		 font.setBoldweight(Font.BOLDWEIGHT_BOLD);
		 
		 style.setFont(font);
		 
		 rowNum.getCell(column).setCellStyle(style);
	 }
	 else
		 if(data.equalsIgnoreCase("FAIL")){
			 CellStyle style=wb.createCellStyle();
			 
			 Font font=wb.createFont();
			 
			 font.setColor(IndexedColors.RED.getIndex());
			 
			 font.setBoldweight(Font.BOLDWEIGHT_BOLD);
			 
			 style.setFont(font);
			 
			 rowNum.getCell(column).setCellStyle(style);
		 
		 }
		 else
			 if(data.equalsIgnoreCase("NOT EXECUTED")){
				 CellStyle style=wb.createCellStyle();
				 
				 Font font=wb.createFont();
				 
				 font.setColor(IndexedColors.BLUE.getIndex());
				 
				 font.setBoldweight(Font.BOLDWEIGHT_BOLD);
				 
				 style.setFont(font);
				 
				 rowNum.getCell(column).setCellStyle(style);
			 }
	 
	 FileOutputStream fos=new FileOutputStream("./TestOutput/OutputSheet.xlsx");
	 
	 			wb.write(fos);
	 			fos.close();
			 }
	
}

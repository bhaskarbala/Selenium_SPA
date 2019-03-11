package com.SpaSelenium.generic.lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/*
 * it provide libraries to get the data for .xlsx and properties
 */
public class readDataExternalFile {

		/**
		 * This method has get property for property files 
		 * than user given  ,key
		 * 
		 * @param Key
		 * @return
		 * @throws Throwable
		 */
		public String getPropertyKeyValue(String Key) throws Throwable {
			// addrres of Location of The File
			String filepath="./data/comman.properties";
			/* get the java Object in Physical file*/
			FileInputStream fis=new FileInputStream(filepath);
			/* Create object of propeties class and load the data*/
			Properties p=new Properties();
			p.load(fis);
			/* the Data form Comman properties*/
			String value=p.getProperty(Key);
			return value;
					
		
			
		}
		/**
		 * this method get data from Excel file 
		 * @param filepath
		 * @param sheet
		 * @param rowIndex
		 * @param columIndex
		 * @return
		 * @throws Throwable
		 * @throws Exception
		 */
		
		public String getExcelData(String filepath,String sheet,int rowIndex,int columIndex) throws Throwable, Exception {
	
		
		
		
				FileInputStream fis=new FileInputStream(filepath);
				Workbook wb=WorkbookFactory.create(fis);
				Sheet sh=wb.getSheet(sheet);
				Row row=sh.getRow(rowIndex);
				Cell cell=row.getCell(columIndex);
				String data1 =cell.toString();
				wb.close();
	
				// TODO Auto-generated catch block
			
		
			
			
			return data1;
			
		}
		
/**
 * Set data from a Excel 
 * @param filepath
 * @param sheet
 * @param rowIndex
 * @param columIndex
 * @param data
 * @return
 * @throws Throwable
 * @throws Exception
 */
		public void setExcelData(String filepath,String sheet,int rowIndex,int columIndex,String data) throws Throwable, Exception {
			
			
		

				FileInputStream fis=new FileInputStream(filepath);
				Workbook wb=WorkbookFactory.create(fis);
				Sheet sh=wb.getSheet(sheet);
				Row row=sh.getRow(rowIndex);
				Cell cell=row.createCell(columIndex);
				FileOutputStream fos=new FileOutputStream(filepath);
				wb.write(fos);
				wb.close();
		
			
		
	

}
}
package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	
	//repeated code or common code...

	public static void captureScreen(WebDriver driver, String screenShot) //to take screenshot
	   {
	        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH mm ss"); 
    	    LocalDateTime now=LocalDateTime.now();
    	    String a=dtf.format(now);
    	    System.out.println(a);
    	    File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	    
        	File dest=new File("test-output\\FailTestScreenShot\\Test"+screenShot+" "+a+".jpeg");
            
            	try {
					FileHandler.copy(src, dest);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		  }
	
    //static double data1;
	//static String data;
	public static String getExcelData(String sheetName, int rowNo, int cellNo) throws EncryptedDocumentException, IOException  {
		    String data ;
		    String path="src\\main\\resources\\data\\ExcelFetch.xlsx";
		
		    FileInputStream file = new FileInputStream(path);
		    Workbook book=WorkbookFactory.create(file);
		    Sheet sheet=book.getSheet(sheetName);
		    Row row=sheet.getRow(rowNo);
		    Cell cell=row.getCell(cellNo);
		    
			try {
				 data = cell.getStringCellValue();
			
			    }
			catch (IllegalStateException e) 
			{
				e.printStackTrace();
				double value = cell.getNumericCellValue();
				
				data=String.valueOf(value);	
			}
		return data;
     }
}

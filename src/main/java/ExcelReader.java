import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader 
{
    public static void main(String[] args) 
    {
 
    }
    
    public List<List<String>> getData() {
 
        try
        {
            FileInputStream file = new FileInputStream(new File("C:\\Users\\bhavi\\Downloads\\Stemming.xlsx"));
 
            //Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(file);
 
            //Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);
 
            //Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
            List<List<String>> data = new ArrayList<List<String>>(); 
            while (rowIterator.hasNext()) 
            {
                Row row = rowIterator.next();
                //For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();
                 List values = new ArrayList();
                while (cellIterator.hasNext()) 
                {
                    Cell cell = cellIterator.next();
                    //Check the cell type and format accordingly
                   
                    
                   switch (cell.getCellType()) 
                    {
                        case Cell.CELL_TYPE_NUMERIC:
                        	values.add(cell.getNumericCellValue());
                        //    System.out.print(cell.getNumericCellValue() + "\t");
                            break;
                        case Cell.CELL_TYPE_STRING:
                        	values.add(cell.getStringCellValue());
                          //  System.out.print(cell.getStringCellValue() + "\t");
                            break;
                    }
                   
                   if(!cellIterator.hasNext()) {
                	   data.add(values); 
                   }
                   
                }
           //     System.out.println("");
            }
            System.out.println("Records Added ::::"+data.size());
            
            file.close();
            return data;
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
		return null;
    	
    }
    
    
}
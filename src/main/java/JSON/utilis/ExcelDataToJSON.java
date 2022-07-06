package JSON.utilis;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;



public class ExcelDataToJSON {
	 private ObjectMapper mapper = new ObjectMapper();
	 

	    public JsonNode excelToJson(File excel) throws IOException {
	        
	        ObjectNode excelData = mapper.createObjectNode();
	        FileInputStream fis = null;
	        Workbook workbook = null;
	        try {
	          
	            fis = new FileInputStream(excel);
	 
	            String filename = excel.getName().toLowerCase();
	            if (filename.endsWith(".xls") || filename.endsWith(".xlsx")) {
	               
	                if (filename.endsWith(".xls")) {
	                    workbook = new HSSFWorkbook(fis);
	                } else {
	                    workbook = new XSSFWorkbook(fis);
	                }
	 
	               
	                for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
	                    Sheet sheet = workbook.getSheetAt(i);
	                    String sheetName = sheet.getSheetName();
	 
	                    List<String> headers = new ArrayList<String>();
	                    ArrayNode sheetData = mapper.createArrayNode();
	                    
	                    for (int j = 0; j <= sheet.getLastRowNum(); j++) {
	                        Row row = sheet.getRow(j);
	                        if (j == 0) {
	                            
	                            for (int k = 0; k < row.getLastCellNum(); k++) {
	                                headers.add(row.getCell(k).getStringCellValue());
	                            }
	                        } else {
	                            ObjectNode rowData = mapper.createObjectNode();
	                            for (int k = 0; k < headers.size(); k++) {
	                                Cell cell = row.getCell(k);
	                                String headerName = headers.get(k);
	                                if (cell != null) {
	                                    switch (cell.getCellType()) {
	                                    case Cell.CELL_TYPE_FORMULA:
	                                        rowData.put(headerName, cell.getCellFormula());
	                                        break;
	                                    case Cell.CELL_TYPE_NUMERIC:
	                                        rowData.put(headerName, cell.getNumericCellValue());
	                                        break;
	                                    }
	                                } else {
	                                    rowData.put(headerName, "");
	                                }
	                            }
	                            sheetData.add(rowData);
	                        }
	                    }
	                    excelData.set(sheetName, sheetData);
	                }
	                return excelData;
	            } else {
	                throw new IllegalArgumentException("File format not supported.");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            if (workbook != null) {
	            }
	            if (fis != null) {
	                try {
	                    fis.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	 
	        }
	        return null;
	    }
	 

	    public static void main(String[] args) throws IOException {
	 
	      
	        File excel = new File("StudentDetails.xlsx");
	        ExcelDataToJSON converter = new ExcelDataToJSON();
	        JsonNode data = converter.excelToJson(excel);
	        System.out.println("Excel file contains the Data:\n" + data);
	 

}


}

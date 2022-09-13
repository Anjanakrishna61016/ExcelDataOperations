package com.ECStraining.ExceldatatoJSON.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import com.fasterxml.jackson.databind.JsonNode;



public class ExcelDataToJSON {
	

	public static void main(String[] args) throws IOException {

		
		File excel = new File("/com.ECSTraining/src/test/resources/StudentDetails.xlsx");
		ReadingExcelData converter = new ReadingExcelData();
		JsonNode data = converter.excelToJson(excel);
		System.out.println("Excel file contains the Data:\n" + data);
		
		try {
			FileWriter file = new FileWriter("D:/output.json");
			file.write(data.toString());
			file.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		JsonNodetoEmail json=new  JsonNodetoEmail();
		json.SendFileToEmail();
	}
	
}
	
	


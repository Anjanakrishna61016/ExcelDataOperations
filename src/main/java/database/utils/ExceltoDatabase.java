package database.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExceltoDatabase {
	public static void main(String[] args) throws SQLException, IOException {
		
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/world","root","abc123");
		Statement stmt=con.createStatement();
		
		
		String sql="create table Myworkbook2 (Admission_no int NOT NULL PRIMARY KEY, Name varchar(40),Physics int,Chemistry int,Maths int)";
		stmt.execute(sql);
		
		
		FileInputStream fis=new FileInputStream("StudentDetails.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheetAt(0);
		
		int rows=sheet.getLastRowNum();
		
		for(int r=1;r<=rows;r++)
		{
			XSSFRow row=sheet.getRow(r);
			double Admission_no=row.getCell(0).getNumericCellValue();
			String name=row.getCell(1).getStringCellValue();
			double physics =row.getCell(2).getNumericCellValue();
			double chemistry=row.getCell(3).getNumericCellValue();
			double maths=row.getCell(4).getNumericCellValue();
			
			sql="insert into  Myworkbook2 values('"+Admission_no+"', '"+name+"', '"+physics+"', '"+chemistry+"', '"+maths+"')";
			stmt.execute(sql);
			stmt.execute("commit");
		}
		
		
		
		fis.close();
		con.close();
		
		System.out.println("Successfully stored excel data into DATABASE");
		
	}

}
	


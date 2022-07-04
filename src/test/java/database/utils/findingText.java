package database.utils;

import com.aspose.cells.Cell;
import com.aspose.cells.Cells;
import com.aspose.cells.FindOptions;
import com.aspose.cells.LookAtType;
import com.aspose.cells.Workbook;
import com.aspose.cells.Worksheet;

public class findingText {

	public static void main(String[] args) throws Exception {
	
	

	
		Workbook workbook = new Workbook("StudentDetails.xlsx");
		Worksheet worksheet = workbook.getWorksheets().get(0);


		Cells cells = worksheet.getCells();
		FindOptions findOptions = new FindOptions();

		findOptions.setLookAtType(LookAtType.ENTIRE_CONTENT);
		Cell cell = cells.find("Anu", null, findOptions);

		System.out.println("Name of the cell containing String: " + cell.getName());
		System.out.println("the cell value is: " + cell.getValue());
	}
}

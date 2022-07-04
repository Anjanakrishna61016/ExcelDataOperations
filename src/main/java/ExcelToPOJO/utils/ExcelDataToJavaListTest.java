package ExcelToPOJO.utils;

import java.io.File;
import java.util.List;

import com.poiji.bind.Poiji;

public class ExcelDataToJavaListTest {
public static void main(String[] args) {
		
		File file = new File("StudentDetails.xlsx.xlsx");
		List<StudentData> student = Poiji.fromExcel(file, StudentData.class);
		System.out.println("Printing List Data: " +student);

	}

}

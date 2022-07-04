package ExcelToPOJO.utils;

import com.poiji.annotation.ExcelCellName;
import com.poiji.annotation.ExcelRow;

public class StudentData {
	
	@ExcelRow                    
    private int rowIndex;

	@ExcelCellName("Admission_no")                
    private int Admission_no;     

	@ExcelCellName("name")
    private String name;

	@ExcelCellName("physics")
    private int physics;

	@ExcelCellName("chemistry")
    private int chemistry;

	@ExcelCellName("maths")
    private int maths;
	
	 @Override
	    public String toString() {
	        return "StudentDetailsExcel  [Admission_no=" + Admission_no+ ", name=" + name + ", physics=" + physics + ", chemistry=" + chemistry + ", maths=" + maths + "]";
	 }
}

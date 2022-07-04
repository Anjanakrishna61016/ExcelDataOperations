package excel.util;

import io.github.millij.poi.ss.model.annotations.Sheet;
import io.github.millij.poi.ss.model.annotations.SheetColumn;

@Sheet("Sheet1") 
public class StudentDetailsExcel {
	 


	    @SheetColumn("Admission_no")                
	    private int Admission_no;     

	    @SheetColumn("name")
	    private String name;

	    @SheetColumn("physics")
	    private int physics;

	    @SheetColumn("chemistry")
	    private int chemistry;

	    @SheetColumn("maths")
	    private int maths;
	    
	    public StudentDetailsExcel() {
	    }
	    
	    public StudentDetailsExcel(int Admission_no, String name, int physics, int chemistry,int maths) {
	        super();

	        this.Admission_no =Admission_no;
	        this.name = name;
	        this.physics = physics;
	        this.chemistry = chemistry;
	        this.maths = maths;
	    }
	    @SheetColumn("Admission_no")
	    public int getAdmission_no() {
	        return Admission_no;
	    }

	    public void setAdmission_no(int Admission_no) {
	        this.Admission_no= Admission_no;
	    }

	    @SheetColumn("Name")
	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public int  getphysics() {
	        return physics;
	    }

	    public void setphysics(int physics) {
	        this.physics = physics;
	    }

	    public int  getchemistry() {
	        return chemistry;
	    }

	    public void setGender(int  chemistry) {
	        this.chemistry = chemistry;
	    }

	    public int  getmaths() {
	        return maths;
	    }

	    public void setHeight(int  maths) {
	        this.maths = maths;
	    }
	    @Override
	    public String toString() {
	        return "StudentDetailsExcel  [Admission_no=" + Admission_no+ ", name=" + name + ", physics=" + physics + ", chemistry=" + chemistry + ", maths=" + maths + "]";
	    }
}

	    
	    






package ExcelMapping.Utils;


public class StudentExcelSheetDetails 
{

    private double Admission_no;     
    private String name;
    private int physics;
    private int chemistry;
    private int maths;
    
    public StudentExcelSheetDetails() {
    }
    
    public StudentExcelSheetDetails(double Admission_no, String name,  int physics,  int chemistry, int maths) {
        super();

        this.Admission_no =Admission_no;
        this.name = name;
        this.physics = physics;
        this.chemistry = chemistry;
        this.maths = maths;
    }
   
    public double getAdmission_no() {
        return Admission_no;
    }

    public void setAdmission_no(double Admission_no) {
        this.Admission_no= Admission_no;
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public  int  getPhysics() {
        return physics;
    }

    public void setPhysics( int physics) {
        this.physics = physics;
    }

    public  int getChemistry() {
        return chemistry;
    }

    public void setChemistry( int chemistry) {
        this.chemistry = chemistry;
    }

    public double  getMaths() {
        return maths;
    }

    public void setMaths( int maths) {
        this.maths = maths;
    }
}

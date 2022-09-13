package ExcelMapping.Utils;


public class StudentExcelSheetDetails 
{

    private double admissionNum;     
    private String name;
    private int physics;
    private int chemistry;
    private int maths;
    
    public StudentExcelSheetDetails() {
    }
    
    public StudentExcelSheetDetails(double admissionNum, String name,  int physics,  int chemistry, int maths) {
        super();

        this.admissionNum =admissionNum;
        this.name = name;
        this.physics = physics;
        this.chemistry = chemistry;
        this.maths = maths;
    }
   
    public double getAdmissionNum() {
        return admissionNum;
    }

    public void setAdmissionNum(double admissionNum) {
        this.admissionNum= admissionNum;
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

    public int  getMaths() {
        return maths;
    }

    public void setMaths( int maths) {
        this.maths = maths;
    }
}

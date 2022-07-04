package database.utils;


public class StudentData {

    private double Admission_no;     
    private String name;
    private double physics;
    private double chemistry;
    private double maths;
    
    public StudentData() {
    }
    
    public StudentData(double Admission_no, String name,  double physics,  double chemistry, double maths) {
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

    public double  getPhysics() {
        return physics;
    }

    public void setPhysics( double physics) {
        this.physics = physics;
    }

    public  double getChemistry() {
        return chemistry;
    }

    public void setChemistry( double  chemistry) {
        this.chemistry = chemistry;
    }

    public double  getMaths() {
        return maths;
    }

    public void setMaths(double maths) {
        this.maths = maths;
    }
}

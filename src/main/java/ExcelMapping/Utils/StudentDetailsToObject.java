package ExcelMapping.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class StudentDetailsToObject {


	public static void main(String[] args) {
		try
		{
			FileInputStream file = new FileInputStream(new File("StudentDetails.xlsx"));
			File files= new  File("StudentDetails.xlsx");

			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheetAt(0);

			ArrayList<StudentExcelSheetDetails> studentList = new ArrayList<>();
			ListIterator<StudentExcelSheetDetails> iterator =null;
			for(int i=sheet.getFirstRowNum()+1;i<=sheet.getLastRowNum();i++){
				StudentExcelSheetDetails student= new StudentExcelSheetDetails();
				Row ro=sheet.getRow(i);
				for(int j=ro.getFirstCellNum();j<=ro.getLastCellNum();j++)
				{
					Cell ce = ro.getCell(j);
					if(j==0){  
						student.setAdmissionNum(ce.getNumericCellValue());
					}
					if(j==1){
						student.setName(ce.getStringCellValue());
					}
					if(j==2){
						student.setPhysics((int) ce.getNumericCellValue());
					}
					if(j==3){
						student.setChemistry((int) ce.getNumericCellValue());
					}
					if(j==4){
						student.setMaths((int) ce.getNumericCellValue());
					}

				}
				studentList.add(student);
			}
			for(StudentExcelSheetDetails student: studentList)
			{


				int totalMarks= student.getPhysics()+student.getChemistry()+student.getMaths();
				double percentage=(totalMarks/300)*100;
				int choice = 0;	
				Gradeassignment gradingobject=new Gradeassignment();
			
				boolean found= false;
				do
				{
					System.out.println("1.Display  Excel Sheet Data ");
					System.out.println("2.Search Using Admission number");
					System.out.println("3.Search Using Name");
					System.out.println("Enter your choice : ");
					Scanner sc=new Scanner(System.in);
					choice=sc.nextInt();
					sc.close();
					switch(choice)
					{

					case 1:	
						for(StudentExcelSheetDetails studentdata: studentList) 
						{

							System.out.println("Admission Number:"+studentdata.getAdmissionNum()+"\r\n"+" Name:"+studentdata.getName()+"\r\n"+"Physics :"+studentdata.getPhysics()+"\r\n"+"Grade: "+gradingobject.assigngrades(studentdata.getPhysics())+"\r\n"+"gradepoint: " +gradingobject.assignGradePoints(studentdata.getPhysics())+"\r\n"+"Chemistry :"+studentdata.getChemistry()+"\r\n"+"Grade: "+gradingobject.assigngrades(studentdata.getChemistry())+"\r\n"+"gradepoint: " +gradingobject.assignGradePoints(studentdata.getChemistry())+"\r\n"+"Maths :"+studentdata.getMaths()+"\r\n"+"Grade: "+gradingobject.assigngrades(studentdata.getMaths())+"\r\n"+"gradepoint: "+gradingobject.assignGradePoints(studentdata.getMaths()));
							System.out.println("Total: " +totalMarks);
							System.out.println("Percentage: " +percentage);
						}
						break;

					case 2:
						System.out.println("Enter Admission number to Search:");
						int adm = sc.nextInt();
						System.out.println("___________________________________________");
						iterator=studentList.listIterator();
						while(iterator.hasNext())
						{
							for(StudentExcelSheetDetails studentdata: studentList) 
								if (studentdata.getAdmissionNum()==adm)
								{
									System.out.println("Admission Number:"+studentdata.getAdmissionNum()+"\r\n"+" Name:"+studentdata.getName()+"\r\n"+"Physics :"+studentdata.getPhysics()+"\r\n"+"Grade: "+gradingobject.assigngrades(studentdata.getPhysics())+"\r\n"+"gradepoint: " +gradingobject.assignGradePoints(studentdata.getPhysics())+"\r\n"+"Chemistry :"+studentdata.getChemistry()+"\r\n"+"Grade: "+gradingobject.assigngrades(studentdata.getChemistry())+"\r\n"+"gradepoint: " +gradingobject.assignGradePoints(studentdata.getChemistry())+"\r\n"+"Maths :"+studentdata.getMaths()+"\r\n"+"Grade: "+gradingobject.assigngrades(studentdata.getMaths())+"\r\n"+"gradepoint: "+gradingobject.assignGradePoints(studentdata.getMaths()));
									found=true;
								}
						}
						if(!found) 
						{
							System.out.println("Record Not Found");
						}
						System.out.println("_________________________________________________");
						break;
					case 3:

						if(files.isFile()) 
						{
							System.out.println("Enter Name to Search:");
							String name = sc.next();
							System.out.println("_____________________________________________");
							iterator=studentList.listIterator();
							while(iterator.hasNext())
							{
								StudentExcelSheetDetails studentdata = (StudentExcelSheetDetails)iterator.next();
								String tmp;

								tmp = studentdata.getName();
								if(tmp.equals(name))
								{
									System.out.println("Admission Number:"+studentdata.getAdmissionNum()+"\r\n"+" Name:"+studentdata.getName()+"\r\n"+"Physics :"+studentdata.getPhysics()+"\r\n"+"Grade: "+gradingobject.assigngrades(studentdata.getPhysics())+"\r\n"+"gradepoint: " +gradingobject.assignGradePoints(studentdata.getPhysics())+"\r\n"+"Chemistry :"+studentdata.getChemistry()+"\r\n"+"Grade: "+gradingobject.assigngrades(studentdata.getChemistry())+"\r\n"+"gradepoint: " +gradingobject.assignGradePoints(studentdata.getChemistry())+"\r\n"+"Maths :"+studentdata.getMaths()+"\r\n"+"Grade: "+gradingobject.assigngrades(studentdata.getMaths())+"\r\n"+"gradepoint: "+gradingobject.assignGradePoints(studentdata.getMaths()));

								}
								found=true;
							}
							if(!found)
								System.out.println("Record Not Found");
						}
						System.out.println("__________________________________________________");
					}

				}while(choice!=0);
			}
			file.close();
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}



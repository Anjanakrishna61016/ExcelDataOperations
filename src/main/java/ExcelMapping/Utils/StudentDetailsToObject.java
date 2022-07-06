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

	static char gradep,gradec,gradem;
	static int gpp,gpc,gpm;

	public static void setMathGrade(char n,int p)
	{
		gradem=n;
		gpm=p;
	}
	public char getMathGrade() 
	{
		return gradem;
	}
	public int getMathGradePoint()
	{
		return gpm;
	}
	public static void setChemGrade(char n,int p)
	{
		gradec=n;
		gpc=p;
	}
	public char getChemGrade() 
	{
		return gradec;
	}
	public int getChemGradePoint()
	{
		return gpc;
	}
	public static void setPhyGrade(char n,int p)
	{
		gradep=n;
		gpp=p;
	}
	public char getPhyGrade() 
	{
		return gradep;
	}
	public int getPhyGradePoint()
	{
		return gpp;
	}

	public static void main(String[] args) {
		try
		{
			FileInputStream file = new FileInputStream(new File("StudentDetails.xlsx"));
			File files= new  File("StudentDetails.xlsx");

			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheetAt(0);

			ArrayList<StudentExcelSheetDetails> studentList = new ArrayList<>();
			@SuppressWarnings("rawtypes")
			ListIterator it =null;


			for(int i=sheet.getFirstRowNum()+1;i<=sheet.getLastRowNum();i++){
				StudentExcelSheetDetails s= new StudentExcelSheetDetails();
				Row ro=sheet.getRow(i);
				for(int j=ro.getFirstCellNum();j<=ro.getLastCellNum();j++){
					Cell ce = ro.getCell(j);
					if(j==0)
					{  
						s.setAdmission_no(ce.getNumericCellValue());
					}
					if(j==1){
						s.setName(ce.getStringCellValue());
					}
					if(j==2){
						s.setPhysics((int) ce.getNumericCellValue());
					}
					if(j==3){
						s.setChemistry((int) ce.getNumericCellValue());
					}
					if(j==4){
						s.setMaths((int) ce.getNumericCellValue());
					}

				}
				studentList.add(s);
			}
			for(StudentExcelSheetDetails stu: studentList)
			{
				double Total= stu.getPhysics()+stu.getChemistry()+stu.getMaths();
				double perc= (double)(Total/300)*100;


				if((stu.getPhysics()<100) && (stu.getPhysics()>91))
				{
					setPhyGrade('A',9);
				}
				else if((stu.getPhysics()<91)&&(stu.getPhysics()>81))
				{
					setPhyGrade('B',8);
				}
				else if((stu.getPhysics()<81)&&(stu.getPhysics()>71))
				{
					setPhyGrade('C',7);
				}
				else if((stu.getPhysics()<71)&&(stu.getPhysics()>61))
				{
					setPhyGrade('D',6);
				}
				else if((stu.getPhysics()<61)&&(stu.getPhysics()>51))
				{
					setPhyGrade('E',5);
				}
				else if((stu.getPhysics()<51)&&(stu.getPhysics()>41))
				{
					setPhyGrade('F',4);
				}
				else if((stu.getPhysics()<41)&&(stu.getPhysics()>31))
				{
					setPhyGrade('G',3);
				}
				else if((stu.getPhysics()<31)&&(stu.getPhysics()>21))
				{
					setPhyGrade('H',0);
				}
				else
				{
					setPhyGrade('I',0);
				}

				if((stu.getChemistry()<100) && (stu.getChemistry()>91))
				{
					setChemGrade('A',9);
				}
				else if((stu.getChemistry()<91)&&(stu.getChemistry()>81))
				{
					setChemGrade('B',8);
				}
				else if((stu.getChemistry()<81)&&(stu.getChemistry()>71))
				{
					setChemGrade('C',7);
				}
				else if((stu.getChemistry()<71)&&(stu.getChemistry()>61))
				{
					setChemGrade('D',6);
				}
				else if((stu.getChemistry()<61)&&(stu.getChemistry()>51))
				{
					setChemGrade('E',5);
				}
				else if((stu.getChemistry()<51)&&(stu.getChemistry()>41))
				{
					setChemGrade('F',4);
				}
				else if((stu.getChemistry()<41)&&(stu.getChemistry()>31))
				{
					setChemGrade('G',3);
				}
				else if((stu.getChemistry()<31)&&(stu.getChemistry()>21))
				{
					setChemGrade('H',0);
				}
				else
				{
					setChemGrade('I',0);
				}

				if((stu.getMaths()<100) && (stu.getMaths()>91))
				{
					setMathGrade('A',9);
				}
				else if((stu.getMaths()<91)&&(stu.getMaths()>81))
				{
					setMathGrade('B',8);
				}
				else if((stu.getMaths()<81)&&(stu.getMaths()>71))
				{
					setMathGrade('C',7);
				}
				else if((stu.getChemistry()<71)&&(stu.getChemistry()>61))
				{
					setMathGrade('D',6);
				}
				else if((stu.getMaths()<61)&&(stu.getMaths()>51))
				{
					setMathGrade('E',5);
				}
				else if((stu.getMaths()<51)&&(stu.getMaths()>41))
				{
					setMathGrade('F',4);
				}
				else if((stu.getMaths()<41)&&(stu.getMaths()>31))
				{
					setMathGrade('G',3);
				}
				else if((stu.getMaths()<31)&&(stu.getMaths()>21))
				{
					setMathGrade('H',0);
				}
				else
				{
					setMathGrade('I',0);
				}


				int choice = 0;	
				@SuppressWarnings("resource")
				Scanner sc=new Scanner(System.in);



				boolean found= false;

				do
				{
					System.out.println("1.Display  Excel Sheet Data ");
					System.out.println("2.Search Using Admission number");
					System.out.println("3.Search Using Name");
					System.out.println("Enter your choice : ");
					choice=sc.nextInt();
					switch(choice)
					{

					case 1:	
						for(StudentExcelSheetDetails st: studentList) 
						{
							System.out.println("Admission Number:"+st.getAdmission_no()+"\r\n"+" Name:"+st.getName()+"\r\n"+"Physics :"+st.getPhysics()+"\r\n"+"Grade: "+gradep+"\r\n"+"gradepoint: "+ gpp +"\r\n"+"Chemistry :"+st.getChemistry()+"\r\n"+"Grade: "+gradec+"\r\n"+"gradepoint: "+ gpc +"\r\n"+"Maths :"+st.getMaths()+"\r\n"+"Grade: "+gradem+"\r\n"+"gradepoint: "+ gpm);
							System.out.println("Total: " +Total);
							System.out.println("Percentage: " +perc);
						}
						break;

					case 2:
						System.out.println("Enter Admission number to Search:");
						int adm = sc.nextInt();
						System.out.println("___________________________________________");
						it=studentList.listIterator();
						while(it.hasNext())
						{
							StudentExcelSheetDetails s = (StudentExcelSheetDetails)it.next();
							if (s.getAdmission_no()==adm)
							{
								System.out.println("Admission Number:" +s.getAdmission_no()+"\r\n"+" Name:"+s.getName()+"\r\n"+"Physics :"+s.getPhysics()+"\r\n"+"Grade: "+gradep+"\r\n"+"gradepoint: "+ gpp +"\r\n"+"Chemistry :"+s.getChemistry()+"\r\n"+"Grade: "+gradec+"\r\n"+"gradepoint: "+ gpc +"\r\n"+"Maths :"+s.getMaths()+"\r\n"+"Grade: "+gradem+"\r\n"+"gradepoint: "+ gpm+"\r\n"+"Total: "+Total+"\r\n"+"Percentage :"+perc);
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
							it=studentList.listIterator();
							while(it.hasNext())
							{
								StudentExcelSheetDetails s = (StudentExcelSheetDetails)it.next();
								String tmp;
							
									tmp = s.getName();
									if(tmp.equals(name))
									{
										System.out.println("Admission Number:" +s.getAdmission_no()+"\r\n"+" Name:"+s.getName()+"\r\n"+"Physics :"+s.getPhysics()+"\r\n"+"Grade: "+gradep+"\r\n"+"gradepoint: "+ gpp +"\r\n"+"Chemistry :"+s.getChemistry()+"\r\n"+"Grade: "+gradec+"\r\n"+"gradepoint: "+ gpc +"\r\n"+"Maths :"+s.getMaths()+"\r\n"+"Grade: "+gradem+"\r\n"+"gradepoint: "+ gpm+"\r\n"+"Total: "+Total+"\r\n"+"Percentage :"+perc);
										
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



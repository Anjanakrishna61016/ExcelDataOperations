package database.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.*;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class findingText {



	public static void main(String[] args) {

		System.out.println("MySQL JDBC Connection Testing ~");
		@SuppressWarnings("rawtypes")
		ListIterator it =null;
		int choice = 0;	
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		boolean found= false;

		List<StudentData> result = new ArrayList<>();

		String SQL_SELECT = "Select * from Myworkbook2";

		// auto close connection and preparedStatement
		try (Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/world", "root", "abc123");
				PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT)) {

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				double Admission_no = resultSet.getDouble("Admission_no");
				String name = resultSet.getString("NAME");
				double physics = resultSet.getDouble("Physics");
				double chemistry = resultSet.getDouble("Chemistry");
				double maths = resultSet.getDouble("Maths");

				StudentData obj = new StudentData();
				obj.setAdmission_no(Admission_no);
				obj.setName(name);
				obj.setPhysics(physics);
				obj.setChemistry(chemistry);
				obj.setMaths(maths);



				result.add(obj);

			}
			result.forEach(x -> System.out.println(x));

			do {
				System.out.println("1.Display  Table Data ");
				System.out.println("2.Search Using Admission number");
				System.out.println("3.Search Using Name");
				System.out.println("Enter your choice : ");
				choice=sc.nextInt();
				switch(choice)
				{
				case 1: 
					for(StudentData st: result) 
					{
						System.out.println("Admission Number:"+st.getAdmission_no()+"\r\n"+" Name:"+st.getName()+"\r\n"+"Physics :"+st.getPhysics()+"\r\n"+"Chemistry :"+st.getChemistry()+"\r\n"+"Maths :"+st.getMaths()+"\r\n");
					}
				case 2:{
					System.out.println("Enter Admission number to Search:");
					int adm = sc.nextInt();

					it=result.listIterator();
					while(it.hasNext())
					{
						StudentData s = (StudentData)it.next();
						if (s.getAdmission_no()==adm)
						{
							System.out.println("Admission Number:"+s.getAdmission_no()+"\r\n"+" Name:"+s.getName()+"\r\n"+"Physics :"+s.getPhysics()+"\r\n"+"Chemistry :"+s.getChemistry()+"\r\n"+"Maths :"+s.getMaths()+"\r\n");
							found=true;
						}
					}
					if(!found) 
					{
						System.out.println("Record Not Found");
					}
				}

					break;

				case 3:{

					System.out.println("Enter Name to Search:");
					String name = sc.next();

					it=result.listIterator();
					while(it.hasNext())
					{
						StudentData s = (StudentData)it.next();

						if (s.getName()==name)
						{
							System.out.println("Admission Number:"+s.getAdmission_no()+"\r\n"+" Name:"+s.getName()+"\r\n"+"Physics :"+s.getPhysics()+"\r\n"+"Chemistry :"+s.getChemistry()+"\r\n"+"Maths :"+s.getMaths()+"\r\n");
							found=true;
						}

					}
					if(!found)
						System.out.println("Record Not Found");
				}
				}

			}while(choice!=0);




		} catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

package testDB.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.gson.Gson;

public class SearchDb {
	private ObjectMapper mapper = new ObjectMapper();
	ObjectNode DBData = mapper.createObjectNode();
	 public static void main(String[] args)
	    {
		 
		   
	        ConnectionDb connection = new ConnectionDb();
	        Connection con = null;
	        PreparedStatement p = null;
	        ResultSet rs = null;
	 
	    
	        con = connection.connectDB();
	 
	        
	        try {
	 
	        	@SuppressWarnings("resource")
			   Scanner scanner = new Scanner(System.in);
	           System.out.println("Enter a name to search: ");
	           String input=scanner.nextLine();
	           String sql
	                = "select * from myworkbook2 where name ='" +input+ "' " ;
	 
	            
	            p = con.prepareStatement(sql);
	            rs = p.executeQuery();
	 
	            while (rs.next()) {
	            	DataDetails stud = new DataDetails();
	            	
	               stud.getAdmission_no();
	               stud.getName();
	               stud.getPhysics();
	               stud.getChemistry();
	               stud.getMaths();

	                Gson gson = new Gson();
	                System.out.println(gson.toJson(stud));
	              
	                 double Admission_no = rs.getDouble("Admission_no");
	                 String name = rs.getString("Name");
	                 double physics = rs.getDouble("physics");
	                 double chemistry = rs.getDouble("chemistry");
	                 double maths = rs.getDouble("maths");
	                 
	                  
	               System.out.println(Admission_no+ "\t\t" + name
	                                    + "\t\t" + physics + "\t\t"
	                                    + chemistry + "\t\t"+ maths);
	                                    
	            }
	        }
	 
	     
	        catch (SQLException e) {
	 
	    
	            System.out.println(e);
	        }
	    }

}

package testDB.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchDb {
	 public static void main(String[] args)
	    {
	        // Step 2: Establishing a connection
	        ConnectionDb connection = new ConnectionDb();
	 
	        // Assigning NULL to object of Connection class
	        // as shown returned by above program
	        Connection con = null;
	        PreparedStatement p = null;
	        ResultSet rs = null;
	 
	        // Step 3: Loading and registereding drivers
	        // Loaded and registered in Connection class
	        // shown in above program
	        con = connection.connectDB();
	 
	        // Try block to check exceptions
	        try {
	 
	            // Step 4: Write a statement
	            String sql
	                = "select count(*) from myworkbook2 where Name =Anu";
	 
	            // Step 5: Execute the query
	            p = con.prepareStatement(sql);
	            rs = p.executeQuery();
	 
	            // Step 6: Process the results
	            System.out.println(
	                "Admission_no\t\tname\t\tphysics\t\tchemistry\t\tmaths");
	 
	            // Condition check using next() method
	            // Holds true till there is single element remaining
	          // in the object
	            while (rs.next()) {
	               
	                double Admission_no = rs.getDouble("Admission_no");
	                String name = rs.getString("name");
	                double physics = rs.getDouble("physics");
	                double chemistry = rs.getDouble("chemistry");
	                double maths = rs.getDouble("maths");
	                 
	              System.out.println(Admission_no+ "\t\t" + name
	                                   + "\t\t" + physics + "\t\t"
	                                   + chemistry + "\t\t"+ maths);
	            }
	        }
	 
	        // Catch block to handle exceptions
	        catch (SQLException e) {
	 
	            // Print the exception
	            System.out.println(e);
	        }
	    }

}

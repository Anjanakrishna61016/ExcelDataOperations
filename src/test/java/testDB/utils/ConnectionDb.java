package testDB.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDb {
	 final String DB_URL
     = "jdbc:mysql://localhost:3306/world";


  

 final String USER = "root";
  

 final String PASS = "abc123";


public Connection connectDB()
 {
   
     Connection con = null;

  
     try {

         Class.forName("com.mysql.cj.jdbc.Driver");

         con = DriverManager.getConnection(DB_URL, USER,
                                           PASS);
     }

     catch (SQLException e) {

         e.printStackTrace();
     }

     catch (ClassNotFoundException e) {
         // where exception occurs
         e.printStackTrace();
     }

     // Returning Connection class object to
     // be used in (App/Main) GFG class
     return con;
 }
}


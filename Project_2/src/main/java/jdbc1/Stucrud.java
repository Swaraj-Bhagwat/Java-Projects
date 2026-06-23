package jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Stucrud {

	public static void main(String[] args) {
		
		// Load/Register Driver Class
		// Load Driver class
	
		try {
			
			Class.forName("org.postgresql.Driver");
			System.out.println("Class Loaded!........");
			
			
			// create Connection
			String url = "jdbc:postgresql://localhost:5432/stucrud";
			String username = "postgres";
			String password = "root";
			
			Connection conn = DriverManager.getConnection(url, username, password);
			System.out.println(conn);
			
			
			// Create Statement
			String insertQuery1  = "INSERT INTO student VALUES(101,'Aarav',85)";
			String insertQuery2  = "INSERT INTO student VALUES(102,'Krishna',78)";
			String insertQuery3  = "INSERT INTO student VALUES(103,'Govind',92)";
			String insertQuery4  = "INSERT INTO student VALUES(104,'Rakesh',88)";
			String insertQuery5  = "INSERT INTO student VALUES(105,'Radha',95)";
			String insertQuery6  = "INSERT INTO student VALUES(106,'Priya',81)";
			String insertQuery7  = "INSERT INTO student VALUES(107,'Sneha',89)";
			String insertQuery8  = "INSERT INTO student VALUES(108,'Rohit',76)";
			String insertQuery9  = "INSERT INTO student VALUES(109,'Ananya',93)";
			String insertQuery10 = "INSERT INTO student VALUES(110,'Karan',84)";
			
			
			Statement st = conn.createStatement();
			
			
			//Update Query 
			
			  String updateQuery1 ="UPDATE student SET name = 'Shyam' WHERE id = 102";
			  String updateQuery2 ="UPDATE student SET marks = 95 WHERE id = 104";
			  
			  st.execute(updateQuery1); st.execute(updateQuery2);
			  
			  System.out.println("Records updated successfully");
			 
			
			//Delete Query
			String deleteQuery1 ="DELETE FROM student WHERE id = 109";
			String deleteQuery2 ="DELETE FROM student WHERE id = 110";
			
			
			st.execute(deleteQuery1);
			st.execute(deleteQuery2);
			
			System.out.println("Records Deleted Successfully");
			
			//Execute Query 
			
			  st.execute(insertQuery1); st.execute(insertQuery2); st.execute(insertQuery3);
			  st.execute(insertQuery4); st.execute(insertQuery5); st.execute(insertQuery6);
			  st.execute(insertQuery7); st.execute(insertQuery8); st.execute(insertQuery9);
			  st.execute(insertQuery10);
			 
			
			//System.out.println("Records inserted successfully........");
			
			
			//close connection
			conn.close();
			
			
		}catch(ClassNotFoundException e){
			System.out.println("Exception ocurred....");
		}catch(SQLException e) {
			System.out.println("Connection not created.......");
			e.printStackTrace();
		}

	}

}

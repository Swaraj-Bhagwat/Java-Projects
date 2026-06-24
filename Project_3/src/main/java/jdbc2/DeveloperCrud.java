package jdbc2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeveloperCrud {

	public static void main(String[] args) {

		// Load/Register Driver Class
		// Load Driver class

		try {

			Class.forName("org.postgresql.Driver");
			System.out.println("Class Loaded!........");

			// create Connection
			String url = "jdbc:postgresql://localhost:5432/developercrud";
			String username = "postgres";
			String password = "root";

			Connection conn = DriverManager.getConnection(url, username, password);
			System.out.println(conn);

			// Create Statement
			String insertQuery1 = "INSERT INTO developer VALUES(101,'Rahul','Java Developer',65000,'2 Years')";
			String insertQuery2 = "INSERT INTO developer VALUES(102,'Priya','HR',55000,'1 Year')";
			String insertQuery3 = "INSERT INTO developer VALUES(103,'Amit','Software Tester',60000,'3 Years')";
			String insertQuery4 = "INSERT INTO developer VALUES(104,'Sneha','Frontend Developer',75000,'4 Years')";
			String insertQuery5 = "INSERT INTO developer VALUES(105,'Rohit','Project Manager',90000,'6 Years')";
			String insertQuery6 = "INSERT INTO developer VALUES(106,'Ananya','Backend Developer',58000,'2 Years')";
			String insertQuery7 = "INSERT INTO developer VALUES(107,'Karan','Full Stack Developer',70000,'3 Years')";
			String insertQuery8 = "INSERT INTO developer VALUES(108,'Pooja','QA Engineer',62000,'2 Years')";
			String insertQuery9 = "INSERT INTO developer VALUES(109,'Vikram','Team Lead',95000,'7 Years')";
			String insertQuery10 = "INSERT INTO developer VALUES(110,'Neha','Senior Developer',82000,'5 Years')";

			Statement st = conn.createStatement();

			// Update Query

			String updateQuery1 = "UPDATE developer SET name = 'Shyam' WHERE id = 106";
			String updateQuery2 = "UPDATE developer SET experience ='5 Years' WHERE id = 107";

			st.execute(updateQuery1);
			st.execute(updateQuery2);

			System.out.println("Records updated successfully");

			
			  //Delete Query String deleteQuery1 ="DELETE FROM student WHERE id = 109";
			  String deleteQuery2 ="DELETE FROM student WHERE id = 110";
			  
			  
			  st.execute(deleteQuery1); st.execute(deleteQuery2);
			  
			  System.out.println("Records Deleted Successfully");
			 

			// Execute Query

			
			  st.execute(insertQuery1); st.execute(insertQuery2); st.execute(insertQuery3);
			  st.execute(insertQuery4); st.execute(insertQuery5); st.execute(insertQuery6);
			  st.execute(insertQuery7); st.execute(insertQuery8); st.execute(insertQuery9);
			  st.execute(insertQuery10);
			  
			  System.out.println("Developer records inserted successfully");
			  
			 

			// System.out.println("Records inserted successfully........");

			// close connection
			conn.close();

		} catch (ClassNotFoundException e) {
			System.out.println("Exception ocurred....");
		} catch (SQLException e) {
			System.out.println("Connection not created.......");
			e.printStackTrace();
		}

	}

}

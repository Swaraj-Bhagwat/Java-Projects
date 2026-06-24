package jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class EmpCrud {

	public static void main(String[] args) {
		
		// Load/Register Driver Class
		// Load Driver class
		
		try {
			
			Class.forName("org.postgresql.Driver");
			System.out.println("Class Loaded!........");
			
			
			// create Connection
			String url = "jdbc:postgresql://localhost:5432/jdbccrud";
			String username = "postgres";
			String password = "root";
			
			Connection conn = DriverManager.getConnection(url, username, password);
			System.out.println(conn);
			
			
			
			// Create Statement
			String insertQuery = "INSERT INTO employee VALUES(101,'Ram', 98000.0,'Developer')";
			String insertQuery1 = "INSERT INTO employee VALUES(102,'Krushna', 42000.0,'HR')";
			String insertQuery2 = "INSERT INTO employee VALUES(103,'Govind', 22000.0,'HR')";
			String insertQuery3 = "INSERT INTO employee VALUES(104,'Rakesh', 90000.0,'Developer')";
			String insertQuery4 = "INSERT INTO employee VALUES(105,'Radha', 74000.0,'Marketing')";

			Statement st = conn.createStatement();
			
			
			//Execute Query 
			
			/*
			 * st.execute(insertQuery); st.execute(insertQuery1); st.execute(insertQuery2);
			 * st.execute(insertQuery3); st.execute(insertQuery4);
			 */
			 
			
			// Read/Select data from database
			
			String sql = "SELECT * from employee";
			st.execute(sql);
			
			
			ResultSet re = st.getResultSet();
			
			while(re.next()) {
				
				int id = re.getInt(1);
				String name = re.getString(2);
				double salary = re.getDouble(3);
				String role = re.getString(4);
				
				System.out.println("ID: "+id);
				System.out.println("Nmae: "+name);
				System.out.println("Salary: "+salary);
				System.out.println("Role: "+role);
				
				System.out.println("--------------------------------");

			}
			
			//close connection
			conn.close();
			
			
		}catch(ClassNotFoundException e){
			System.out.println("Exception ocurred....");
			e.printStackTrace();
		}catch(SQLException e) {
			System.out.println("Connection not created.......");
			e.printStackTrace();
		}
			
	}

}

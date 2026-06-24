package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PrepareStatementDriver {
	public static void main(String[] args) {
		
		try {
			
			Class.forName("org.postgresql.Driver");
			
			String url="jdbc:postgresql://localhost:5432/jdbccrud";
			String username="postgres";
			String password="root";
			
			Connection conn = DriverManager.getConnection(url, username, password);
			System.out.println(conn);
			
			
			//String sql = "INSERT INTO employee VALUES(?,?,?,?)";
			
			String sql = "UPDATE employee SET salary=? WHERE id=?";

			PreparedStatement st = conn.prepareStatement(sql);
			
			Scanner sc = new Scanner(System.in);
			/*
			 * System.out.println("Enter ID: "); int id = sc.nextInt();
			 * System.out.println("Enter Name: "); String name = sc.next();
			 * System.out.println("Enter Salary: "); double salary = sc.nextDouble();
			 * System.out.println("Enter Role: "); String role = sc.next();
			 * 
			 * st.setInt(1, id); st.setString(2, name); st.setDouble(3, salary);
			 * st.setString(4, role);
			 */
			
			System.out.println("Enter Salary: ");
			double salary = sc.nextDouble();
			
			System.out.println("Enter ID: ");
			int id = sc.nextInt();
			
			st.setDouble(1, salary);
			st.setInt(2, id);
			
			st.execute();
			
			System.out.println("Records Updated Successfully..");
			
			conn.close();

			
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}

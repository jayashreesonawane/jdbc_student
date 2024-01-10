package jdbc_student;
//Prepared Statement 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

//learn file handling 

public class StudentInsert {

	public static void main(String[] args) throws SQLException {
		
		// Get the data from user dynamically 
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the id : ");
		
		int id = scanner.nextInt();
		
		System.out.println("Enter the name : ");
		
		String name = scanner.next();
		
		System.out.println("Enter the phone : ");
		
		long phone = scanner.nextLong();
		
		System.out.println("Enter the Address : ");
		
		String address = scanner.next();
		
		System.out.println("Enter the marks : ");
		
		int marks = scanner.nextInt();
		
		// 1. Load or Register the Driver
		
		Driver driver = new Driver();
		
		DriverManager.registerDriver(driver);
		
		// 2. Establish the Connection
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb?user=root&password=root");
		
		// 3. Create PreparedStatement
		
		PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO STUDENT VALUES(?,?,?,?,?)");
		
		preparedStatement.setInt(1, id);
		preparedStatement.setString(2, name);
		preparedStatement.setLong(3, phone);
		preparedStatement.setString(4, address);
		preparedStatement.setInt(5, marks);
		
		// 4. Execute the Statement or Process the result
		
		int count = preparedStatement.executeUpdate();
		
		if (count!=0) 
		{
			System.out.println("Data Inserted");
		} 
		else 
		{
			System.out.println("Data is not Inserted");
		}
		
		// 5. Close the Connection
		
		connection.close();
	}
}

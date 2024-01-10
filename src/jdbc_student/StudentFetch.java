package jdbc_student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class StudentFetch {
	
	public static void main(String[] args) throws SQLException {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the id : ");
		
		int id = scanner.nextInt();
		
		Driver driver = new Driver();
		
		DriverManager.registerDriver(driver);
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb?user=root&password=root");
		
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM STUDENT WHERE ID=?");
		
		preparedStatement.setInt(1, id);
		
		ResultSet resultSet = preparedStatement.executeQuery();
		
		while (resultSet.next()) 
		{
			System.out.println(resultSet.getInt("id"));
			
			System.out.println(resultSet.getString("name"));
			
			System.out.println(resultSet.getLong("phone"));
			
			System.out.println(resultSet.getString("address"));
			
			System.out.println(resultSet.getInt("marks"));
			
			System.out.println("---------------------");
		}
		
		resultSet.close();
		preparedStatement.close();
		connection.close();
	}
}


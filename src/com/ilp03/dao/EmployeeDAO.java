package com.ilp03.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ilp03.entity.Employee;
import com.ilp03.entity.Project;

public class EmployeeDAO {
	
	public static Connection getConnection() {
		String connectionString = "jdbc:mysql://localhost:3306/resourceforprojects?usesSSL=false";
		String userName = "root";
		String password = "jomi";

		Connection connection = null;

		try {
			connection = DriverManager.getConnection(connectionString, userName, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return connection;
	}
	
	public static String getEmployeeWithId(Connection connection,int id) {
		
		Statement statement;
		String empName="";
		
		try {
			statement = connection.createStatement();
			String query="SELECT emp_firstname FROM employee where emp_id="+id+";";
			
			ResultSet rs=statement.executeQuery(query);
			while(rs.next()) {
				empName=rs.getString("emp_firstname");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}
		
		return empName;
		
	}

}

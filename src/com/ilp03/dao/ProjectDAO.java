package com.ilp03.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ilp03.entity.Employee;
import com.ilp03.entity.Project;


public class ProjectDAO {
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

	public static ArrayList<Project> getProjectsWithId(Connection connection) {
		// TODO Auto-generated method stub
		Statement statement;
		ArrayList<Project> projectList=new ArrayList<>();
		try {
			statement = connection.createStatement();
			String query="SELECT project_id,project_name,project_description,start_date,end_date,budget,priority,created_by,updated_by FROM project";
			
			ResultSet rs=statement.executeQuery(query);
			while(rs.next()) {
				Project project=new Project(rs.getInt("project_id"),rs.getString("project_name"),rs.getString("project_description"),
						rs.getDate("start_date"),rs.getDate("end_date"),rs.getDouble("budget"),Project.Priority.valueOf(rs.getString("priority")),
						new Employee(rs.getInt("created_by"), null, null, null, null),
						new Employee(rs.getInt("updated_by"),null,null,null,null));
				
				projectList.add(project);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}
		
		return projectList;
	}
}

package com.ilp03.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import com.ilp03.entity.Employee;
import com.ilp03.entity.Project;
import com.ilp03.entity.Sprint;

public class SprintDAO {
	
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

	public void closeConnection(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static ArrayList<Sprint> getSprintWithId(Connection connection,int projectId) {
		// TODO Auto-generated method stub
		Statement statement;
		ArrayList<Sprint> sprintList=new ArrayList<>();
		try {
			statement = connection.createStatement();
			String query="SELECT sprint_id,sprint_name,sprint_goal,project_id,sprint_status,start_date,end_date,created_by,updated_by,created_at,updated_at FROM sprint where project_id="+projectId+";";
			
			ResultSet rs=statement.executeQuery(query);
			while(rs.next()) {
				Sprint sprint=new Sprint(rs.getInt("sprint_id"),rs.getString("sprint_name"),rs.getString("sprint_goal"),
						new Project(rs.getInt("project_id"),null,null,null,null,0, null,null, null),
						Sprint.Status.valueOf(rs.getString("sprint_status")),
						rs.getDate("start_date"),rs.getDate("end_date"),
						new Employee(rs.getInt("created_by"),null,null,null,null),
						new Employee(rs.getInt("updated_by"),null,null,null,null),
						rs.getDate("created_at"),
						rs.getDate("updated_at"));
				sprintList.add(sprint);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}
		
		return sprintList;
	}
	
	
    public static void insertSprint(Connection connection, String sprintName, String sprintGoal, int projectId, String sprintStatus,java.sql.Date startDate,java.sql.Date endDate,int createdBy,int updatedBy,java.sql.Date createdAt,java.sql.Date updatedAt) throws SQLException {
    	String query = "INSERT INTO sprint (sprint_name,sprint_goal,project_id,sprint_status,start_date,end_date,created_by,updated_by,created_at,updated_at) VALUES (?, ?, ?, ?, ?,?,?,?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, sprintName);
            preparedStatement.setString(2, sprintGoal);
            preparedStatement.setInt(3, projectId);
            preparedStatement.setString(4, sprintStatus);
            preparedStatement.setDate(5, startDate);
            preparedStatement.setDate(6, endDate);
            preparedStatement.setInt(7,createdBy );
            preparedStatement.setInt(8,updatedBy);
            preparedStatement.setDate(9, createdAt);
            preparedStatement.setDate(10, updatedAt);
            preparedStatement.executeUpdate();
        }catch (SQLException e) {
            System.err.println("Error inserting sprint: " + e.getMessage());
        }
    }
    
    public static void updateStatus(Connection connection, String sprintName,String status) throws SQLException {
    	String query = "UPDATE sprint SET sprint_status='" + status + "' WHERE sprint_name='" + sprintName + "'";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.executeUpdate();
        }catch (SQLException e) {
            System.err.println("Error Updating sprint: " + e.getMessage());
        }
    }

}

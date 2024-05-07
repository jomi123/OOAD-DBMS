package com.ilp03.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ilp03.entity.Employee;
import com.ilp03.entity.Project;
import com.ilp03.entity.Sprint;
import com.ilp03.entity.UserStory;

public class UserStoryDAO {
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

	public static ArrayList<UserStory> getUserStoryList(Connection connection,int projectId,int sprintId) {
		// TODO Auto-generated method stub
		Statement statement;
		ArrayList<UserStory> userStoryList=new ArrayList<>();
		try {
			statement = connection.createStatement();
			String query="SELECT * FROM userstory inner join sprint on userstory.sprint_id=sprint.sprint_id inner join project on sprint.project_id=project.project_id inner join employee on userstory.emp_assigned=employee.emp_id where project.project_id="+projectId+" and sprint.sprint_id="+sprintId+ "";
			
			ResultSet rs=statement.executeQuery(query);
			while(rs.next()) {
				UserStory userStory=new UserStory(rs.getInt("userstory_id"),
						new Sprint(rs.getInt("sprint_id"), rs.getString("sprint_name"), null, null, null, null, null, null, null,null,null),
						rs.getString("userstory_name"),
						rs.getString("userstory_description"),
						rs.getDouble("allocation_amount"),
						UserStory.Status.valueOf(rs.getString("completion_status")),
						new Employee(rs.getInt("emp_assigned"),rs.getString("emp_firstname"),null,rs.getString("skills"),null),
						rs.getDate("start_date"),
						rs.getDate("end_date"),
						new Employee(rs.getInt("created_by"),null,null,null,null),
						new Employee(rs.getInt("updated_by"),null,null,null,null));
				
				userStoryList.add(userStory);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}
		
		return userStoryList;
		
		
		
	}
	
	
	public static void insertUserStory(Connection connection, int sprintId,String name,String description,double allocationAmount,String completionStatus,int empAssigned,Date startDate,Date endDate,int createdBy,int updatedBy) throws SQLException {
        String query = "INSERT INTO userstory (sprint_id,userstory_name,userstory_description,allocation_amount,completion_status,emp_assigned,start_date,end_date,created_by,updated_by) VALUES (?, ?, ?, ?, ?,?,?,?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, sprintId);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, description);
            preparedStatement.setDouble(4, allocationAmount);
            preparedStatement.setString(5, completionStatus);
            preparedStatement.setInt(6,empAssigned );
            preparedStatement.setDate(7,startDate);
            preparedStatement.setDate(8, endDate);
            preparedStatement.setInt(9, createdBy);
            preparedStatement.setInt(10, updatedBy);
            preparedStatement.executeUpdate();
        }catch (SQLException e) {
            System.err.println("Error inserting User Story: " + e.getMessage());
        }
    }
	
	
    public static void updateStatus(Connection connection, String userName,String status) throws SQLException {
    	String query = "UPDATE userstory SET completion_status='" + status + "' WHERE userstory_name='" + userName + "'";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.executeUpdate();
        }catch (SQLException e) {
            System.err.println("Error Updating user story: " + e.getMessage());
        }
    }


}

package com.ilp03.service;

import java.sql.Connection;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

import com.ilp03.dao.EmployeeDAO;
import com.ilp03.dao.ProjectDAO;
import com.ilp03.dao.SprintDAO;
import com.ilp03.dao.UserStoryDAO;
import com.ilp03.entity.Project;
import com.ilp03.entity.Sprint;
import com.ilp03.entity.UserStory;

public class ProjectServiceImpl implements ProjectService {

	@Override
	public void getAllProjects() {
		// TODO Auto-generated method stub
		
		int projectId=0;
		int sprintId=0;
		
		Connection connection;
		Scanner scanner =new Scanner(System.in);
		int choice=0;
		
		do{
		try {
			System.out.println("1.List Project Details\n2.Insert Sprint\n3.Insert User Story\n4.Update Sprint Status\n5.Update User Story Status\n6.Exit");
	        choice = scanner.nextInt();
			connection = ProjectDAO.getConnection();
			switch(choice){
			
			case 1: ArrayList<Project> projectList=ProjectDAO.getProjectsWithId(connection);
					System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
					System.out.printf("%12s | %15s | %79s | %30s | %20s | %20s | %20s | %20s | %20s |\n", "Project ID", "Project Name","Project Description","Start Date","End Date","Budget","Priority",
										"Created By","Updated By");  
					System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
					for(Project project:projectList) {
						int created_by=project.getCreatedBy().getEmpId();
						String createdName=EmployeeDAO.getEmployeeWithId(connection,created_by);
						int updated_by=project.getUpdatedBy().getEmpId();
						String updatedName=EmployeeDAO.getEmployeeWithId(connection,updated_by);
						System.out.printf("%12s | %15s | %79s | %30s | %20s | %20s | %20s | %20s | %20s |\n",project.getProjectId(),project.getProjectName(),project.getProjectDescription(),
								project.getStartDate(),project.getEndDate(),project.getBudget(),project.getPriority(),createdName,updatedName);  
						}
					
					System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
					System.out.println("\n");
					
				
					
					
					System.out.println("Enter the project id: ");
					projectId=scanner.nextInt();
					
					
					
					
					
					
					ArrayList<Sprint> sprintList=SprintDAO.getSprintWithId(connection,projectId);
					for(Sprint sprint:sprintList) {
						int created_by=sprint.getCreatedBy().getEmpId();
						String createdName=EmployeeDAO.getEmployeeWithId(connection,created_by);
						int updated_by=sprint.getUpdatedBy().getEmpId();
						String updatedName=EmployeeDAO.getEmployeeWithId(connection,updated_by);
						System.out.println("**************************************************SPRINT***********************************************************************");
						
						System.out.println("\n");
						System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
						System.out.printf("%12s | %22s | %100s | %37s | %22s | %22s | %22s | %22s | %22s | %22s |\n", "ID", "Name","Goal","Created By","Updated By","Start Date","End Date","Status","Created At","Updated At");  
						System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
						System.out.printf("%12s | %22s | %100s | %37s | %22s | %22s | %22s | %22s | %22s | %22s \n",sprint.getSprintId(),sprint.getSprintName(),sprint.getSprintGoal(),createdName,updatedName,
								sprint.getStartDate(),sprint.getEndDate(),sprint.getSprintStatus(),sprint.getCreatedAt(),sprint.getUpdatedAt());
						
						System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
						System.out.println("\n");
						
						
						ArrayList<UserStory> userStoryList=UserStoryDAO.getUserStoryList(connection,projectId,sprint.getSprintId());
						if(userStoryList.size()==0)
						{
							continue;
						}
						
						System.out.println("******************************************************USER STORY*************************************************************\n\n");
						
						System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
						System.out.printf("%12s | %34s | %90s | %34s | %20s | %23s | %20s | %20s | %20s | %20s | %20s | %37s |\n", "ID", "Name","Description","Status","Created By","Updated By","Sprint Name","Employee Assigned",
								"Start Date","End Date","Allocation Amount","Skills");  
						System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
						
						for(UserStory userStory:userStoryList) {
							int createdByUser=userStory.getCreatedBy().getEmpId();
							String createdNameUser=EmployeeDAO.getEmployeeWithId(connection,createdByUser);
							int updatedByUser=userStory.getUpdatedBy().getEmpId();
							String updatedNameUser=EmployeeDAO.getEmployeeWithId(connection,updated_by);
							System.out.printf("%12s | %34s | %90s | %34s | %20s | %23s | %20s | %20s | %20s | %20s | %20s | %37s |\n",
									userStory.getUserStoryId(),
									userStory.getUserStoryName(),
									userStory.getUserStoryDescription(),
									userStory.getCompletionStatus(),
									createdNameUser,updatedByUser,
									userStory.getSprintId().getSprintName(),
									userStory.getEmpAssigned().getEmpFirstName()
									,userStory.getStartDate()
									,userStory.getEndDate(),
									userStory.getAllocationAmount(),
									userStory.getEmpAssigned().getSkills());
							
						}
						System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
						System.out.println("\n");
	
					}
					
					
					break;
					
			case 2: System.out.println("Enter the Sprint Name");
					String sprintName=scanner.next();
					scanner.nextLine();
					System.out.println("Enter the sprint goal");
					String sprintGoal=scanner.nextLine();
					System.out.println("Enter the project ID");
					int idProject=scanner.nextInt();
					System.out.println("Enter the sprint status(active/plan/completed)");
					String sprintStatus=scanner.next();
					scanner.nextLine();
					System.out.println("Enter the start date in format yyyy-MM-dd");
			        String inputDateStr = scanner.nextLine();

			        Date startDate = Date.valueOf(inputDateStr);
			        
			        System.out.println("Enter the end date in format yyyy-MM-dd");
			        String endDateStr = scanner.nextLine();

			        Date endDate = Date.valueOf(endDateStr);
			        
			        System.out.println("Enter the employee id created the sprint");
			        int createdEmpId=scanner.nextInt();
			        scanner.nextLine();
			        int updatedEmpId=createdEmpId;
			   
			        System.out.println("Enter the created date in format yyyy-MM-dd");
			        
			        String createdDateStr = scanner.nextLine();

			        Date createdDate = Date.valueOf(createdDateStr);
			        
			        System.out.println("Enter the updated date in format yyyy-MM-dd");
			        
			        String updatedDateStr = scanner.nextLine();

			        Date updatedDate = Date.valueOf(updatedDateStr);
			        SprintDAO.insertSprint(connection, sprintName, sprintGoal, idProject, sprintStatus, startDate, endDate, createdEmpId, updatedEmpId, createdDate, updatedDate);
			        System.out.println("You have successfully inserted");
			        break;
			        
			case 3: 
					System.out.println("Enter the Sprint ID");
					int userSprintId=scanner.nextInt();
					scanner.nextLine();
					System.out.println("Enter the User Story Name");
					String userName=scanner.nextLine();
					//scanner.nextLine();
					System.out.println("Enter the User Story Description");
					String userDescription=scanner.nextLine();
					System.out.println("Enter the Allocation Amount");
					Double userAmount=scanner.nextDouble();
					System.out.println("Enter the Completion Status(to_do/in_progress/done)");
					String userStatus=scanner.next();
					System.out.println("Enter the emplyee id of Employee Assigned");
					int userEmpAssigned=scanner.nextInt();
					
					scanner.nextLine();
					System.out.println("Enter the start date in format yyyy-MM-dd");
			        String userInputDateStr = scanner.nextLine();

			        Date userStartDate = Date.valueOf(userInputDateStr);
			        
			        System.out.println("Enter the end date in format yyyy-MM-dd");
			        String userEndDateStr = scanner.nextLine();

			        Date userEndDate = Date.valueOf(userEndDateStr);
			        
			        System.out.println("Enter the employee id created the sprint");
			        int userCreatedEmpId=scanner.nextInt();
			        
			        int userUpdatedEmpId=userCreatedEmpId;
					
			        UserStoryDAO.insertUserStory(connection, userSprintId, userName, userDescription, userAmount, userStatus, userEmpAssigned, userStartDate, userEndDate, userCreatedEmpId, userUpdatedEmpId);
			        System.out.println("You have successfully inserted");
			        break;
			        
			case 4:	scanner.nextLine();
					System.out.println("Enter the sprint name");
					String nameOfSprint=scanner.nextLine();
					System.out.println("Enter the Completion Status(plan/active/completed)");
					String status=scanner.next();
					
					
					SprintDAO.updateStatus(connection, nameOfSprint, status);
					break;
			case 5: 
				scanner.nextLine();
				System.out.println("Enter the user story name");
				String nameOfUserStory=scanner.nextLine();
				System.out.println("Enter the Completion Status(to_do/in_progress/done)");
				String statusOfUser=scanner.next();
				
				
				UserStoryDAO.updateStatus(connection, nameOfUserStory, statusOfUser);
				break;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}while(choice!=6);
		
		System.out.println("*****************You have Successfully Exitted******************");
		System.out.print("*******************Have a Nice Day********************************");

}
}

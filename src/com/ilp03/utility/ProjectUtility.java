package com.ilp03.utility;

import com.ilp03.service.ProjectService;
import com.ilp03.service.ProjectServiceImpl;

public class ProjectUtility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ProjectService projectService=new ProjectServiceImpl();
		projectService.getAllProjects();

	}

}

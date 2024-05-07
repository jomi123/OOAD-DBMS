package com.ilp03.entity;

import java.util.Date;

public class Project {

	private int projectId;
	private String projectName;
	private String projectDescription;
	private Date startDate;
	private Date endDate;
	private double budget;
	private Priority priority;
	private Employee createdBy;
	private Employee updatedBy;

	public enum Priority {
		high, medium, low
	}

	public Project(int projectId, String projectName, String projectDescription, Date startDate, Date endDate,
			double budget, Priority priority, Employee createdBy, Employee updatedBy) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.projectDescription = projectDescription;
		this.startDate = startDate;
		this.endDate = endDate;
		this.budget = budget;
		this.priority = priority;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public Employee getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Employee createdBy) {
		this.createdBy = createdBy;
	}

	public Employee getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Employee updatedBy) {
		this.updatedBy = updatedBy;
	}

}

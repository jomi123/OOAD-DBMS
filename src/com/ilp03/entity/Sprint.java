package com.ilp03.entity;

import java.util.Date;

public class Sprint {
	private int sprintId;
	private String sprintName;
	private String sprintGoal;
	private Project projectId;
	private Status sprintStatus;

	public enum Status {
		plan, active, completed
	}

	private Date startDate;
	private Date endDate;
	private Employee createdBy;
	private Employee updatedBy;
	private Date createdAt;
	private Date updatedAt;

	public Sprint(int sprintId, String sprintName, String sprintGoal, Project projectId, Status sprintStatus,
			Date startDate, Date endDate, Employee createdBy, Employee updatedBy, Date createdAt, Date updatedAt) {
		super();
		this.sprintId = sprintId;
		this.sprintName = sprintName;
		this.sprintGoal = sprintGoal;
		this.projectId = projectId;
		this.sprintStatus = sprintStatus;
		this.startDate = startDate;
		this.endDate = endDate;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public int getSprintId() {
		return sprintId;
	}

	public void setSprintId(int sprintId) {
		this.sprintId = sprintId;
	}

	public String getSprintName() {
		return sprintName;
	}

	public void setSprintName(String sprintName) {
		this.sprintName = sprintName;
	}

	public String getSprintGoal() {
		return sprintGoal;
	}

	public void setSprintGoal(String sprintGoal) {
		this.sprintGoal = sprintGoal;
	}

	public Project getProjectId() {
		return projectId;
	}

	public void setProjectId(Project projectId) {
		this.projectId = projectId;
	}

	public Status getSprintStatus() {
		return sprintStatus;
	}

	public void setSprintStatus(Status sprintStatus) {
		this.sprintStatus = sprintStatus;
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

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}

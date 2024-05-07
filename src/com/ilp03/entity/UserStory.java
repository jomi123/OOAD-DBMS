package com.ilp03.entity;

import java.util.Date;

public class UserStory {
	private int userStoryId;
	private Sprint sprintId;
	private String userStoryName;
	private String userStoryDescription;
	private double allocationAmount;
	private Status completionStatus;

	public enum Status {
		to_do, in_progress, done;
	}

	private Employee empAssigned;
	private Date startDate;
	private Date endDate;
	private Employee createdBy;
	private Employee updatedBy;

	public UserStory(int userStoryId, Sprint sprintId, String userStoryName, String userStoryDescription,
			double allocationAmount, Status completionStatus, Employee empAssigned, Date startDate, Date endDate,
			Employee createdBy, Employee updatedBy) {
		super();
		this.userStoryId = userStoryId;
		this.sprintId = sprintId;
		this.userStoryName = userStoryName;
		this.userStoryDescription = userStoryDescription;
		this.allocationAmount = allocationAmount;
		this.completionStatus = completionStatus;
		this.empAssigned = empAssigned;
		this.startDate = startDate;
		this.endDate = endDate;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
	}

	public int getUserStoryId() {
		return userStoryId;
	}

	public void setUserStoryId(int userStoryId) {
		this.userStoryId = userStoryId;
	}

	public Sprint getSprintId() {
		return sprintId;
	}

	public void setSprintId(Sprint sprintId) {
		this.sprintId = sprintId;
	}

	public String getUserStoryName() {
		return userStoryName;
	}

	public void setUserStoryName(String userStoryName) {
		this.userStoryName = userStoryName;
	}

	public String getUserStoryDescription() {
		return userStoryDescription;
	}

	public void setUserStoryDescription(String userStoryDescription) {
		this.userStoryDescription = userStoryDescription;
	}

	public double getAllocationAmount() {
		return allocationAmount;
	}

	public void setAllocationAmount(double allocationAmount) {
		this.allocationAmount = allocationAmount;
	}

	public Status getCompletionStatus() {
		return completionStatus;
	}

	public void setCompletionStatus(Status completionStatus) {
		this.completionStatus = completionStatus;
	}

	public Employee getEmpAssigned() {
		return empAssigned;
	}

	public void setEmpAssigned(Employee empAssigned) {
		this.empAssigned = empAssigned;
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

}

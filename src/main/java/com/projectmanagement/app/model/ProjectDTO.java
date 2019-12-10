/*
 * 
 */
package com.projectmanagement.app.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;

// TODO: Auto-generated Javadoc
/**
 * The Class ProjectDTO.
 */
public class ProjectDTO implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The project id. */
	public String projectId;

	/** The user id. */
	public String userId;

	/** The user name. */
	public String userName;

	/** The project name. */
	public String projectName;

	/** The start date. */
	public String startDate;

	/** The end date. */
	public String endDate;

	/** The priority. */
	public String priority;

	/** The message. */
	public String message;

	/** The message. */
	public String noOfTasks;


	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getNoOfTasks() {
		return noOfTasks;
	}

	public void setNoOfTasks(String noOfTasks) {
		this.noOfTasks = noOfTasks;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		ProjectDTO other = (ProjectDTO) obj;
		return true;
	}

	@Override
	public String toString() {
		return "ProjectDTO [projectId=" + projectId + ", userId=" + userId + ", userName=" + userName + ", projectName="
				+ projectName + ", startDate=" + startDate + ", endDate=" + endDate + ", priority=" + priority
				+ ", message=" + message + ", noOfTasks=" + noOfTasks + "]";
	}



}

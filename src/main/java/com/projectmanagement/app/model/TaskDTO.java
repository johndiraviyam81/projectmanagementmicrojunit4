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
 * The Class TaskDTO.
 */
public class TaskDTO implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The task id. */
	public String taskId;

	/** The parent task id. */
	public String parentTaskId;

	/** The project id. */
	public String projectId;

	/** The user id. */
	public String userId;

	/** The task name. */
	public String taskName;

	/** The start date. */
	public String startDate;

	/** The end date. */
	public String endDate;

	/** The priority. */
	public String priority;

	/** The status. */
	public String status;

	/** The message. */
	public String message;

	/** The parent task name. */
	public String parentTaskName;

	/** The project name. */
	public String projectName;

	/** The user name. */
	public String userName;
	
	 
	public String setParentTask;

	public String getSetParentTask() {
		return setParentTask;
	}

	public void setSetParentTask(String setParentTask) {
		this.setParentTask = setParentTask;
	}

	/**
	 * Gets the user id.
	 *
	 * @return the user id
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * Sets the user id.
	 *
	 * @param userId
	 *            the new user id
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * Gets the task id.
	 *
	 * @return the task id
	 */
	public String getTaskId() {
		return taskId;
	}

	/**
	 * Sets the task id.
	 *
	 * @param taskId
	 *            the new task id
	 */
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	/**
	 * Gets the parent task id.
	 *
	 * @return the parent task id
	 */
	public String getParentTaskId() {
		return parentTaskId;
	}

	/**
	 * Sets the parent task id.
	 *
	 * @param parentTaskId
	 *            the new parent task id
	 */
	public void setParentTaskId(String parentTaskId) {
		this.parentTaskId = parentTaskId;
	}

	/**
	 * Gets the project id.
	 *
	 * @return the project id
	 */
	public String getProjectId() {
		return projectId;
	}

	/**
	 * Sets the project id.
	 *
	 * @param projectId
	 *            the new project id
	 */
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	/**
	 * Gets the task name.
	 *
	 * @return the task name
	 */
	public String getTaskName() {
		return taskName;
	}

	/**
	 * Sets the task name.
	 *
	 * @param taskName
	 *            the new task name
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	/**
	 * Gets the start date.
	 *
	 * @return the start date
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * Sets the start date.
	 *
	 * @param startDate
	 *            the new start date
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * Gets the end date.
	 *
	 * @return the end date
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * Sets the end date.
	 *
	 * @param endDate
	 *            the new end date
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	/**
	 * Gets the priority.
	 *
	 * @return the priority
	 */
	public String getPriority() {
		return priority;
	}

	/**
	 * Sets the priority.
	 *
	 * @param priority
	 *            the new priority
	 */
	public void setPriority(String priority) {
		this.priority = priority;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status
	 *            the new status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Sets the message.
	 *
	 * @param message
	 *            the new message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Gets the parent task name.
	 *
	 * @return the parent task name
	 */
	public String getParentTaskName() {
		return parentTaskName;
	}

	/**
	 * Sets the parent task name.
	 *
	 * @param parentTaskName
	 *            the new parent task name
	 */
	public void setParentTaskName(String parentTaskName) {
		this.parentTaskName = parentTaskName;
	}

	/**
	 * Gets the project name.
	 *
	 * @return the project name
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * Sets the project name.
	 *
	 * @param projectName
	 *            the new project name
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	/**
	 * Gets the user name.
	 *
	 * @return the user name
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Sets the user name.
	 *
	 * @param userName
	 *            the new user name
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		TaskDTO other = (TaskDTO) obj;
		return true;
	}

	@Override
	public String toString() {
		return "TaskDTO [taskId=" + taskId + ", parentTaskId=" + parentTaskId + ", projectId=" + projectId + ", userId="
				+ userId + ", taskName=" + taskName + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", priority=" + priority + ", status=" + status + ", message=" + message + ", parentTaskName="
				+ parentTaskName + ", projectName=" + projectName + ", userName=" + userName + ", setParentTask="
				+ setParentTask + "]";
	}

 

 

}

/*
 * 
 */
package com.projectmanagement.app.entity;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;



// TODO: Auto-generated Javadoc
/**
 * The Class TaskVO.
 */
@Entity
@Table(name = "task")
public class TaskVO {
	
	/** The task id. */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="task_id")
	private	long taskId;
	
	/** The parent task VO. */
	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="parent_id")
	private ParentTaskVO parentTaskVO;

	/** The project VO. */
	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="project_id")
	private ProjectVO projectVO;
	
	
	/** The users VO. */
	@ManyToOne
	@JoinColumn(name="user_id")
	private UsersVO usersVO;

	/** The task. */
	@Column(name="task")
	protected String task;
	
	/** The start date. */
	@Column(name="start_date")
	protected LocalDate startDate;
	
	/** The end date. */
	@Column(name="end_date")
	protected LocalDate endDate;
	
	/** The priority. */
	@Column(name="priority")
	protected int priority;
	
	/** The status. */
	@Column(name="status")
	protected String status;

	/**
	 * Instantiates a new task VO.
	 */
	public TaskVO() {
		
	}
	
	

	
	/**
	 * Gets the task id.
	 *
	 * @return the task id
	 */
	public long getTaskId() {
		return taskId;
	}




	/**
	 * Sets the task id.
	 *
	 * @param taskId the new task id
	 */
	public void setTaskId(long taskId) {
		this.taskId = taskId;
	}




	/**
	 * Gets the parent task VO.
	 *
	 * @return the parent task VO
	 */
	public ParentTaskVO getParentTaskVO() {
		return parentTaskVO;
	}




	/**
	 * Sets the parent task VO.
	 *
	 * @param parentTaskVO the new parent task VO
	 */
	public void setParentTaskVO(ParentTaskVO parentTaskVO) {
		this.parentTaskVO = parentTaskVO;
	}




	/**
	 * Gets the project VO.
	 *
	 * @return the project VO
	 */
	public ProjectVO getProjectVO() {
		return projectVO;
	}




	/**
	 * Sets the project VO.
	 *
	 * @param projectVO the new project VO
	 */
	public void setProjectVO(ProjectVO projectVO) {
		this.projectVO = projectVO;
	}




	/**
	 * Gets the task.
	 *
	 * @return the task
	 */
	public String getTask() {
		return task;
	}




	/**
	 * Sets the task.
	 *
	 * @param task the new task
	 */
	public void setTask(String task) {
		this.task = task;
	}




	/**
	 * Gets the start date.
	 *
	 * @return the start date
	 */
	public LocalDate getStartDate() {
		return startDate;
	}




	/**
	 * Sets the start date.
	 *
	 * @param startDate the new start date
	 */
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}




	/**
	 * Gets the end date.
	 *
	 * @return the end date
	 */
	public LocalDate getEndDate() {
		return endDate;
	}




	/**
	 * Sets the end date.
	 *
	 * @param endDate the new end date
	 */
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}




	/**
	 * Gets the priority.
	 *
	 * @return the priority
	 */
	public int getPriority() {
		return priority;
	}




	/**
	 * Sets the priority.
	 *
	 * @param priority the new priority
	 */
	public void setPriority(int priority) {
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
	 * @param status the new status
	 */
	public void setStatus(String status) {
		this.status = status;
	}


	/**
	 * Gets the users VO.
	 *
	 * @return the users VO
	 */
	public UsersVO getUsersVO() {
		return usersVO;
	}




	/**
	 * Sets the users VO.
	 *
	 * @param usersVO the new users VO
	 */
	public void setUsersVO(UsersVO usersVO) {
		this.usersVO = usersVO;
	}


	 /* (non-Javadoc)
 	 * @see java.lang.Object#equals(java.lang.Object)
 	 */
 	@Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        TaskVO taskVO = (TaskVO) o;
	        return Objects.equals(task, taskVO.task);
	    }

	    /* (non-Javadoc)
    	 * @see java.lang.Object#hashCode()
    	 */
    	@Override
	    public int hashCode() {
	        return Objects.hash(task);
	    }


		@Override
		public String toString() {
			return "TaskVO [taskId=" + taskId + ", parentTaskVO=" + parentTaskVO + ", projectVO=" + projectVO
					+ ", usersVO=" + usersVO + ", task=" + task + ", startDate=" + startDate + ", endDate=" + endDate
					+ ", priority=" + priority + ", status=" + status + "]";
		}
	    







}

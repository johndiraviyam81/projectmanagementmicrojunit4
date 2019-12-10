/*
 * 
 */
package com.projectmanagement.app.entity;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class ProjectVO.
 */
@Entity
@Table(name = "project")
public class ProjectVO {

	/** The project id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "project_id")
	protected long projectId;

	/** The project. */
	@Column(name = "project")
	protected String project;

	/** The start date. */
	@Column(name = "start_date")
	protected LocalDate startDate;

	/** The end date. */
	@Column(name = "end_date")
	protected LocalDate endDate;
	
	@OneToMany(mappedBy = "projectVO")
    private List<TaskVO> taskList = new ArrayList<>();

	/** The priority. */
	@Column(name = "priority")
	protected int priority;

	
	
	public List<TaskVO> getTaskList() {
		return taskList;
	}

	public void setTaskList(List<TaskVO> taskList) {
		this.taskList = taskList;
	}

	/** The users VO. */
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UsersVO usersVO;

	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public UsersVO getUsersVO() {
		return usersVO;
	}

	public void setUsersVO(UsersVO usersVO) {
		this.usersVO = usersVO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		ProjectVO projectVO = (ProjectVO) o;
		return Objects.equals(project, projectVO.project);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return Objects.hash(project);
	}

	@Override
	public String toString() {
		return "ProjectVO [projectId=" + projectId + ", project=" + project + ", startDate=" + startDate + ", endDate="
				+ endDate + ", priority=" + priority + ", usersVO=" + usersVO + "]";
	}

}

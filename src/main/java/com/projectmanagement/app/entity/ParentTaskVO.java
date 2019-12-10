/*
 * 
 */
package com.projectmanagement.app.entity;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class ParentTaskVO.
 */
@Entity
@Table(name = "parent_task")
public class ParentTaskVO {
	
	/** The parent id. */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="parent_id")
	protected	long parentId;
	
	/** The parent task. */
	/** The task. */
	@Column(name="parent_task")
	protected String parentTask;
	
	/**
	 * Instantiates a new parent task VO.
	 */
	public ParentTaskVO()
	{
		
	}

	 
	
	 public long getParentId() {
		return parentId;
	}



	public void setParentId(long parentId) {
		this.parentId = parentId;
	}



	public String getParentTask() {
		return parentTask;
	}



	public void setParentTask(String parentTask) {
		this.parentTask = parentTask;
	}



	/* (non-Javadoc)
 	 * @see java.lang.Object#equals(java.lang.Object)
 	 */
 	@Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        ParentTaskVO parentTaskVO = (ParentTaskVO) o;
	        return Objects.equals(parentTask, parentTaskVO.parentTask);
	    }

	    /* (non-Javadoc)
    	 * @see java.lang.Object#hashCode()
    	 */
    	@Override
	    public int hashCode() {
	        return Objects.hash(parentTask);
	    }
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ParentTaskVO [parentId=" + parentId  + ", parentTask=" + parentTask.toString() + "]";
	}

}

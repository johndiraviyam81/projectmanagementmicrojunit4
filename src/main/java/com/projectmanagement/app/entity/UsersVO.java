/*
 * 
 */
package com.projectmanagement.app.entity;

import java.sql.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class UsersVO.
 */
@Entity
@Table(name = "users")
public class UsersVO {
	
	/** The user id. */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private long userId;	
	
	/** The first name. */
	@Column(name="first_name")
	private String firstName;
	
	/** The last name. */
	@Column(name="last_name")
	private String lastName;
	
	/** The employee id. */
	@Column(name="employee_id")
	private long employeeId;



	

	/**
	 * Instantiates a new users VO.
	 */
	public UsersVO() {
		
	}


	

	/**
	 * Gets the user id.
	 *
	 * @return the user id
	 */
	public long getUserId() {
		return userId;
	}




	/**
	 * Sets the user id.
	 *
	 * @param userId the new user id
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}




	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}




	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}




	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}




	/**
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}




	/**
	 * Gets the employee id.
	 *
	 * @return the employee id
	 */
	public long getEmployeeId() {
		return employeeId;
	}




	/**
	 * Sets the employee id.
	 *
	 * @param employeeId the new employee id
	 */
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	 /* (non-Javadoc)
 	 * @see java.lang.Object#equals(java.lang.Object)
 	 */
 	@Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        UsersVO usersVO = (UsersVO) o;
	        return Objects.equals(firstName, usersVO.firstName);
	    }

	    /* (non-Javadoc)
    	 * @see java.lang.Object#hashCode()
    	 */
    	@Override
	    public int hashCode() {
	        return Objects.hash(firstName);
	    }
	    


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UsersVO [userId=" + userId + ", firstName=" + firstName +", lastName=" + lastName +", employeeId=" + employeeId  + "]";
	}

}

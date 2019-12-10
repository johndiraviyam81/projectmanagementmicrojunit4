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
 * The Class DeleteRecordDTO.
 */
public class DeleteRecordDTO implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The delete id. */
	public String deleteId;

	/** The message. */
	public String message;

	/**
	 * Gets the delete id.
	 *
	 * @return the delete id
	 */
	public String getDeleteId() {
		return deleteId;
	}

	/**
	 * Sets the delete id.
	 *
	 * @param deleteId
	 *            the new delete id
	 */
	public void setDeleteId(String deleteId) {
		this.deleteId = deleteId;
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

 

	@Override
	public String toString() {
		return "DeleteRecordDTO [deleteId=" + deleteId + ", message=" + message + "]";
	}

}

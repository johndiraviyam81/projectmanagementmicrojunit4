/*
 * 
 */
package com.projectmanagement.app.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.projectmanagement.app.util.ProjectManagementConstants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projectmanagement.app.model.DeleteRecordDTO;
import com.projectmanagement.app.model.UserDTO;
import com.projectmanagement.app.service.UsersService;
import com.projectmanagement.app.entity.UsersVO;



/**
 * The Class UsersController.
 */
@RestController
@RequestMapping(value=ProjectManagementConstants.URL_USER_Service)
public class UsersController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	/** The users service. */
	@Autowired
	private	UsersService usersService;
	
	
	
	/**
	 * Gets the all users.
	 *
	 * @return the all users
	 */
	@CrossOrigin
	@GetMapping(value = ProjectManagementConstants.URL_USER_getAllUsers)
	public ResponseEntity<List<UserDTO>> getAllUsers()
	{
		List<UserDTO> userList=new ArrayList<>();
		try
		{		
			userList=usersService.getAllUsers();
			
			return ResponseEntity.ok().body(userList);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			log.error(e.getMessage());
			return ResponseEntity.badRequest().body(null);
		}
		
		
		
	}
	
	/**
	 * Search users.
	 *
	 * @param userNames the user names
	 * @return the response entity
	 */
	@CrossOrigin
	@PostMapping(value = ProjectManagementConstants.URL_USER_searchAllUsers)
	public ResponseEntity<List<UserDTO>> searchUsers(@RequestBody List<String> userNames)
	{
		List<UserDTO> userList=new ArrayList<>();
		try
		{		
			userList=usersService.searchUsers(userNames);
			
			return ResponseEntity.ok().body(userList);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			log.error(e.getMessage());
			return ResponseEntity.badRequest().body(null);
		}
		
		
		
	}
	
	/**
	 * Update user.
	 *
	 * @param userDTO the user DTO
	 * @return the response entity
	 */
	@CrossOrigin
	@PutMapping(value = ProjectManagementConstants.URL_USER_update)
	public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO)
	{
		try
		{	
			 usersService.save(userDTO);
			 userDTO.setMessage(ProjectManagementConstants.USER_Update_msgSuccess);			 
			 return ResponseEntity.ok().body(userDTO);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			log.error(e.getMessage());
			userDTO.setMessage(ProjectManagementConstants.USER_Update_msgFailure);
			return ResponseEntity.badRequest().body(userDTO);
		}
				
	}
	
	/**
	 * Adds the user.
	 *
	 * @param userDTO the user DTO
	 * @return the response entity
	 */
	@CrossOrigin
	@PostMapping(value = ProjectManagementConstants.URL_USER_addUser)
	public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO)
	{
		try
		{	
			usersService.save(userDTO);
			userDTO.setMessage(ProjectManagementConstants.USER_Add_msgSuccess);
			return ResponseEntity.ok().body(userDTO);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			log.error(e.getMessage());
			userDTO.setMessage(ProjectManagementConstants.USER_Add_msgFailure);
			return ResponseEntity.badRequest().body(userDTO);
		}
				
	}
	
	/**
	 * Gets the user.
	 *
	 * @param userId the user id
	 * @return the user
	 */
	@CrossOrigin
	@GetMapping(value = ProjectManagementConstants.URL_USER_deleteGetUser)
	public ResponseEntity<UserDTO> getUser(@PathVariable("userId")String userId)
	{
		UserDTO userDto=new UserDTO();	
		try
		{	
			userDto=usersService.getUser(userId);
			userDto.setMessage(ProjectManagementConstants.USER_Get_msgSuccess);
			return ResponseEntity.ok().body(userDto);
			 
		}
		catch(Exception e)
		{
			e.printStackTrace();
			log.error(e.getMessage());
			userDto.setMessage(ProjectManagementConstants.USER_Get_msgFailure);
			return ResponseEntity.badRequest().body(userDto);
		}
				
	}
	

	/**
	 * Delete user.
	 *
	 * @param userId the user id
	 * @return the response entity
	 */
	@CrossOrigin
	@DeleteMapping(value = ProjectManagementConstants.URL_USER_deleteGetUser)
	public ResponseEntity<DeleteRecordDTO> deleteUser(@PathVariable("userId")String userId)
	{
		DeleteRecordDTO deleteRecord=new DeleteRecordDTO();		
			
		try
		{	
			boolean deleteFlag=usersService.deleteUser(userId);	
			if(deleteFlag)
			{ deleteRecord.setMessage(ProjectManagementConstants.USER_Delete_msgSuccess); }
			else
				{ deleteRecord.setMessage(ProjectManagementConstants.USER_Delete_msgFailure); }	
			 return ResponseEntity.ok().body(deleteRecord);			 
		}
		 catch (Exception e) {
			
			e.printStackTrace();
			log.error(e.getMessage());
			deleteRecord.setMessage(ProjectManagementConstants.USER_Delete_msgFailure);
			return ResponseEntity.badRequest().body(deleteRecord);
		}
				
	}
	

}

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
import com.projectmanagement.app.model.ProjectDTO;
import com.projectmanagement.app.service.ProjectsService;
import com.projectmanagement.app.entity.ProjectVO;





/**
 * The Class ProjectsController.
 */
@RestController
@RequestMapping(value=ProjectManagementConstants.URL_PROJECT_Service)
public class ProjectsController {


	private final Logger log = LoggerFactory.getLogger(this.getClass());
	/** The projects service. */
	@Autowired
	private	ProjectsService projectsService;
	
	
	
	/**
	 * Gets the all projects.
	 *
	 * @return the all projects
	 */
	@CrossOrigin
	@GetMapping(value=ProjectManagementConstants.URL_PROJECT_getAllProjects)
	public ResponseEntity<List<ProjectDTO>> getAllProjects()
	{
		List<ProjectDTO> projectList=new ArrayList<>();
		try
		{		
			projectList=projectsService.getAllProjects();
			
			return ResponseEntity.ok().body(projectList);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			log.error(e.getMessage());
			return ResponseEntity.badRequest().body(null);
		}
		
		
		
	}
	
	/**
	 * Search all projects.
	 *
	 * @param projectName the project name
	 * @return the response entity
	 */
	@CrossOrigin
	@PostMapping(value=ProjectManagementConstants.URL_PROJECT_searchAllProjects)
	public ResponseEntity<List<ProjectDTO>> searchAllProjects(@RequestBody String projectName)
	{
		List<ProjectDTO> projectList=new ArrayList<>();
		try
		{		
			projectList=projectsService.searchProjects(projectName);
			
			return ResponseEntity.ok().body(projectList);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			log.error(e.getMessage());
			return ResponseEntity.badRequest().body(null);	
					
		}
		
		
		
	}
	
	
	
	/**
	 * Adds the project.
	 *
	 * @param projectDTO the project DTO
	 * @return the response entity
	 */
	@CrossOrigin
	@PostMapping(value=ProjectManagementConstants.URL_PROJECT_addProject)
	public ResponseEntity<ProjectDTO> addProject(@RequestBody ProjectDTO projectDTO)
	{
		try
		{	
			projectsService.save(projectDTO);
			 projectDTO.setMessage(ProjectManagementConstants.PROJECT_Add_msgSuccess); 
			 return ResponseEntity.ok().body(projectDTO);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			log.error(e.getMessage());
			projectDTO.setMessage(ProjectManagementConstants.PROJECT_Add_msgFailure);
			return ResponseEntity.badRequest().body(projectDTO);
		}
	}
	
	

	/**
	 * Delete project.
	 *
	 * @param projectId the project id
	 * @return the response entity
	 */
	@CrossOrigin
	@DeleteMapping(value=ProjectManagementConstants.URL_PROJECT_deleteGetProject)
	public ResponseEntity<DeleteRecordDTO> deleteProject(@PathVariable("projectId")String projectId)
	{
		DeleteRecordDTO deleteRecord=new DeleteRecordDTO();		
		deleteRecord.setDeleteId(projectId);
		boolean deleteFlag=false;
		try
		{	
			
			deleteFlag=projectsService.deleteProjectById(Long.parseLong(projectId));	
			if(deleteFlag)
			deleteRecord.setMessage(ProjectManagementConstants.PROJECT_Delete_msgSuccess);
			else
			deleteRecord.setMessage(ProjectManagementConstants.PROJECT_Delete_msgFailure);	
			
			 return ResponseEntity.ok().body(deleteRecord);
			 
		}
		catch (Exception e) {
				
			e.printStackTrace();
			log.error(e.getMessage());
			deleteRecord.setMessage(ProjectManagementConstants.PROJECT_Delete_msgFailure);
			return ResponseEntity.badRequest().body(deleteRecord);
		}
				
	}
		
	/**
	 * Gets the project.
	 *
	 * @param projectId the project id
	 * @return the project
	 */
	@CrossOrigin
	@GetMapping(value=ProjectManagementConstants.URL_PROJECT_deleteGetProject)
	public ResponseEntity<ProjectDTO> getProject(@PathVariable("projectId")String projectId)
	{
		ProjectDTO projectDTO=new ProjectDTO();		
		try
		{	
			projectDTO=projectsService.getProjectById(Long.parseLong(projectId));			
			 projectDTO.setMessage(ProjectManagementConstants.PROJECT_Get_msgSuccess);		
			 return ResponseEntity.ok().body(projectDTO);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			log.error(e.getMessage());
			projectDTO.setMessage(ProjectManagementConstants.PROJECT_Get_msgFailure);
			return ResponseEntity.badRequest().body(projectDTO);
		}
				
	}
	
	/**
	 * Update project.
	 *
	 * @param projectDTO the project DTO
	 * @return the response entity
	 */
	@CrossOrigin
	@PutMapping(value=ProjectManagementConstants.URL_PROJECT_update)
	public ResponseEntity<ProjectDTO> updateProject(@RequestBody ProjectDTO projectDTO)
	{
		try
		{	
			projectsService.save(projectDTO);
			projectDTO.setMessage(ProjectManagementConstants.PROJECT_Update_msgSuccess);			
			
			 return ResponseEntity.ok().body(projectDTO);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			log.error(e.getMessage());
			projectDTO.setMessage(ProjectManagementConstants.PROJECT_Update_msgFailure);
			return ResponseEntity.badRequest().body(projectDTO);
		}
				
	}


}

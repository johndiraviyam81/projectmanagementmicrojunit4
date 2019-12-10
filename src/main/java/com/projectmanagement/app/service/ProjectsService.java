package com.projectmanagement.app.service;

import java.sql.SQLException;
import java.util.List;

import com.projectmanagement.app.entity.ProjectVO;
import com.projectmanagement.app.model.ProjectDTO;





// TODO: Auto-generated Javadoc
/**
 * The Interface ProjectsService.
 */
public interface ProjectsService 
{
	
	/**
	 * Save.
	 *
	 * @param projectdto the projectdto
	 * @return the long
	 * @throws Exception the exception
	 */
	public long save(ProjectDTO projectdto) throws Exception;

	/**
	 * Gets the all projects.
	 *
	 * @return the all projects
	 */
	public List<ProjectDTO> getAllProjects() throws Exception;
	
	/**
	 * Search projects.
	 *
	 * @param projectContain the project contain
	 * @return the list
	 */
	public List<ProjectDTO> searchProjects(String projectContain) throws Exception;

	/**
	 * Gets the project by id.
	 *
	 * @param projectId the project id
	 * @return the project by id
	 */
	public ProjectDTO getProjectById(long projectId) throws Exception;
	
	/**
	 * Delete project by id.
	 *
	 * @param projectId the project id
	 * @return true, if successful
	 * @throws SQLException the SQL exception
	 */
	public boolean deleteProjectById(long projectId) throws Exception;

}

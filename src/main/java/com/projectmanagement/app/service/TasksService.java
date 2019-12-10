package com.projectmanagement.app.service;

import java.sql.SQLException;
import java.util.List;

import com.projectmanagement.app.entity.ProjectVO;
import com.projectmanagement.app.model.TaskDTO;





// TODO: Auto-generated Javadoc
/**
 * The Interface TasksService.
 */
public interface TasksService 
{
	
	/**
	 * Save.
	 *
	 * @param taskDTO the task DTO
	 * @return the long
	 * @throws Exception the exception
	 */
	public long save(TaskDTO taskDTO) throws Exception;

	/**
	 * Gets the all tasks.
	 *
	 * @return the all tasks
	 */
	public List<TaskDTO> getAllTasks() throws Exception; 
	
	public List<TaskDTO> getAllParentTasks() throws Exception;
	
	/**
	 * Gets the task by id.
	 *
	 * @param taskId the task id
	 * @return the task by id
	 */
	public TaskDTO getTaskById(long taskId) throws Exception;
	public long saveParentTask(TaskDTO taskDTO) throws Exception;
	/**
	 * Search tasks.
	 *
	 * @param taskName the task name
	 * @return the list
	 */
	public List<TaskDTO> searchTasks(String projectName) throws Exception;
	
	/**
	 * Delete by task by id.
	 *
	 * @param taskId the task id
	 * @return true, if successful
	 * @throws SQLException the SQL exception
	 */
	public boolean deleteByTaskById(long taskId) throws Exception;


}

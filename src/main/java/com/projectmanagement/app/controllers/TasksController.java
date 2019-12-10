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
import com.projectmanagement.app.model.TaskDTO;
import com.projectmanagement.app.service.TasksService;
import com.projectmanagement.app.entity.TaskVO;

/**
 * The Class TasksController.
 */
@RestController
@RequestMapping(value = ProjectManagementConstants.URL_TASK_Service)
public class TasksController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	/** The tasks service. */
	@Autowired
	private TasksService tasksService;

	/**
	 * Gets the all tasks.
	 *
	 * @return the all tasks
	 */
	@CrossOrigin
	@GetMapping(value = ProjectManagementConstants.URL_TASK_getAllTasks)
	public ResponseEntity<List<TaskDTO>> getAllTasks() {
		List<TaskDTO> taskList = new ArrayList<>();
		try {
			taskList = tasksService.getAllTasks();

			return ResponseEntity.ok().body(taskList);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
			return ResponseEntity.badRequest().body(null);
		}

	}
	
	@CrossOrigin
	@GetMapping(value = ProjectManagementConstants.URL_TASK_getAllParentTasks)
	public ResponseEntity<List<TaskDTO>> getAllParentTasks() {
		List<TaskDTO> taskList = new ArrayList<>();
		try {
			taskList = tasksService.getAllParentTasks();

			return ResponseEntity.ok().body(taskList);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
			return ResponseEntity.badRequest().body(null);
		}

	}

	/**
	 * Search tasks.
	 *
	 * @param projectName
	 *            the project name
	 * @return the response entity
	 */
	@CrossOrigin
	@PostMapping(value = ProjectManagementConstants.URL_TASK_searchAllTasks)
	public ResponseEntity<List<TaskDTO>> searchTasks(@RequestBody String projectName) {
		List<TaskDTO> taskList = new ArrayList<>();
		try {
			taskList = tasksService.searchTasks(projectName);

			return ResponseEntity.ok().body(taskList);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
			return ResponseEntity.badRequest().body(null);
		}

	}

	/**
	 * Adds the task.
	 *
	 * @param taskDTO
	 *            the task DTO
	 * @return the response entity
	 */
	@CrossOrigin
	@PostMapping(value = ProjectManagementConstants.URL_TASK_addTask)
	public ResponseEntity<TaskDTO> addTask(@RequestBody TaskDTO taskDTO) {
		try {
			if (taskDTO.getSetParentTask()!=null && taskDTO.getSetParentTask().equals("1")) {
				tasksService.saveParentTask(taskDTO);
			} else {
				tasksService.save(taskDTO);
			}
			taskDTO.setMessage(ProjectManagementConstants.TASK_Add_msgSuccess);
			return ResponseEntity.ok().body(taskDTO);

		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
			taskDTO.setMessage(ProjectManagementConstants.TASK_Add_msgFailure);
			return ResponseEntity.badRequest().body(taskDTO);
		}

	}

	/**
	 * Update task.
	 *
	 * @param taskDTO
	 *            the task DTO
	 * @return the response entity
	 */
	@CrossOrigin
	@PutMapping(value = ProjectManagementConstants.URL_TASK_update)
	public ResponseEntity<TaskDTO> updateTask(@RequestBody TaskDTO taskDTO) {
		try {
			tasksService.save(taskDTO);
			taskDTO.setMessage(ProjectManagementConstants.TASK_Update_msgSuccess);
			return ResponseEntity.ok().body(taskDTO);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
			taskDTO.setMessage(ProjectManagementConstants.TASK_Update_msgFailure);
			return ResponseEntity.badRequest().body(taskDTO);
		}

	}

	/**
	 * Gets the task.
	 *
	 * @param taskId
	 *            the task id
	 * @return the task
	 */
	@CrossOrigin
	@GetMapping(value = ProjectManagementConstants.URL_TASK_deleteGetTask)
	public ResponseEntity<TaskDTO> getTask(@PathVariable("taskId") String taskId) {
		TaskDTO taskDTO = new TaskDTO();
		try {
			taskDTO = tasksService.getTaskById(Long.parseLong(taskId));
			taskDTO.setMessage(ProjectManagementConstants.TASK_Get_msgSuccess);
			return ResponseEntity.ok().body(taskDTO);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
			taskDTO.setMessage(ProjectManagementConstants.TASK_Get_msgFailure);
			return ResponseEntity.badRequest().body(taskDTO);
		}

	}

	/**
	 * Delete task.
	 *
	 * @param taskId
	 *            the task id
	 * @return the response entity
	 */
	@CrossOrigin
	@DeleteMapping(value = ProjectManagementConstants.URL_TASK_deleteGetTask)
	public ResponseEntity<DeleteRecordDTO> deleteTask(@PathVariable("taskId") String taskId) {
		DeleteRecordDTO deleteRecord = new DeleteRecordDTO();
		deleteRecord.setDeleteId(taskId);

		try {
			tasksService.deleteByTaskById(Long.parseLong(taskId));
			deleteRecord.setMessage(ProjectManagementConstants.TASK_Delete_msgSuccess);
			return ResponseEntity.ok().body(deleteRecord);
		} catch (Exception e) {

			e.printStackTrace();
			log.error(e.getMessage());
			deleteRecord.setMessage(ProjectManagementConstants.TASK_Delete_msgFailure);
			return ResponseEntity.badRequest().body(deleteRecord);
		}

	}

}

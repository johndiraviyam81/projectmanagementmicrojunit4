package com.projectmanagement.app.util;

public final class ProjectManagementConstants {
	private ProjectManagementConstants(){}
	
	public static final String  URL_PROJECT_Service="/projects";
	public static final String  URL_PROJECT_getAllProjects="/allprojects";
	public static final String  URL_PROJECT_searchAllProjects="/search";
	public static final String  URL_PROJECT_addProject="/add";
	public static final String  URL_PROJECT_deleteGetProject="/project/{projectId}";
	public static final String  URL_PROJECT_update="/project";
	
	
	public static final String  URL_TASK_Service="/tasks";
	public static final String  URL_TASK_getAllTasks="/alltasks";
	public static final String  URL_TASK_getAllParentTasks="/allparenttasks";
	public static final String  URL_TASK_searchAllTasks="/search";
	public static final String  URL_TASK_addTask="/add";
	public static final String  URL_TASK_deleteGetTask="/task/{taskId}";
	public static final String  URL_TASK_update="/task";
	public static final String  URL_TASK_Parent_Task="/parent/{parentId}";
	public static final String  URL_TASK_Parent_Task_Test="/parent";
	

	public static final String  URL_USER_Service="/users";
	public static final String  URL_USER_getAllUsers="/allusers";
	public static final String  URL_USER_searchAllUsers="/searchusers";
	public static final String  URL_USER_addUser="/add";
	public static final String  URL_USER_deleteGetUser="/user/{userId}";
	public static final String  URL_USER_update="/user";
	
	
	
	public static final String  PROJECT_Update_msgSuccess="Project is updated successfully";
	public static final String  PROJECT_Update_msgFailure="Error has been occured while updating project";
	
	public static final String  PROJECT_Get_msgSuccess="Project is fetched successfully";
	public static final String  PROJECT_Get_msgFailure="Error has been occured while retrieving project";
	

	public static final String  PROJECT_Delete_msgSuccess="Project is deleted successfully along with related tasks";
	public static final String  PROJECT_Delete_msgFailure="Project is not deleted successfully as user is referenced in users or tasks";

	public static final String  PROJECT_Add_msgSuccess="Project is added successfully";
	public static final String  PROJECT_Add_msgFailure="Error has been occured while creating project";
	
	
	public static final String  TASK_Delete_msgSuccess="Task is deleted successfully";
	public static final String  TASK_Delete_msgFailure="Task is not deleted successfully";
	
	public static final String  TASK_Get_msgSuccess="Task is fetched successfully";
	public static final String  TASK_Get_msgFailure="Error has been occured while fetching task";
	
	public static final String  TASK_Update_msgSuccess="Task is updated successfully";
	public static final String  TASK_Update_msgFailure="Error has been occured while updating task";
	
	public static final String  TASK_Add_msgSuccess="Task is added successfully";
	public static final String  TASK_Add_msgFailure="Error has been occured while creating task";
	

	public static final String  USER_Delete_msgSuccess="User is deleted successfully";
	public static final String  USER_Delete_msgFailure="User is not deleted successfully as user is referenced in projects or tasks";
		
	public static final String  USER_Get_msgSuccess="User is received successfully";
	public static final String  USER_Get_msgFailure="Error has been occured while fetching user";
	

	public static final String  USER_Add_msgSuccess="User is added successfully";
	public static final String  USER_Add_msgFailure="Error has been occured while creating user";
	
	public static final String  USER_Update_msgSuccess="User is updated successfully";
	public static final String  USER_Update_msgFailure="Error has been occured while updating user";
	
	
		
	
			
	

}

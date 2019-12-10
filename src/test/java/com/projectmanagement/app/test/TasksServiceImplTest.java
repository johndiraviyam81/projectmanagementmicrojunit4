package com.projectmanagement.app.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.NestedServletException;

import com.projectmanagement.app.entity.ParentTaskVO;
import com.projectmanagement.app.entity.ProjectVO;
import com.projectmanagement.app.entity.TaskVO;
import com.projectmanagement.app.entity.UsersVO;
import com.projectmanagement.app.model.ProjectDTO;
import com.projectmanagement.app.model.TaskDTO;
import com.projectmanagement.app.repositories.ParentTaskVORepository;
import com.projectmanagement.app.repositories.ProjectVORepository;
import com.projectmanagement.app.repositories.TaskVORepository;
import com.projectmanagement.app.repositories.UsersVORepository;
import com.projectmanagement.app.service.TasksService;
import com.projectmanagement.app.service.TasksServiceImpl;



public class TasksServiceImplTest {
	
	@InjectMocks
	TasksServiceImpl tasksService;

	@Mock
	TaskVORepository taskVORepository;
	
	/** The parent task VO repository. */
	@Mock
	ParentTaskVORepository parentTaskVORepository;
	
	/** The project VO repository. */
	@Mock
	ProjectVORepository projectVORepository;
	
	/** The users VO repository. */
	@Mock
	UsersVORepository usersVORepository;
	
	/** The project DTO 4. */
	ProjectDTO projectDTO4=new ProjectDTO();
	
	/** The project VO 4. */
	ProjectVO projectVO4=new ProjectVO();
	
	/** The project DTO 4 error. */
	ProjectDTO projectDTO4Error=new ProjectDTO();
	
	/** The users VO2. */
	UsersVO usersVO1=new UsersVO();
	

	/** The users VO2. */
	UsersVO usersVO2=new UsersVO();
	
	/** The projectContain. */
	String projectContain="task";
	
	List<TaskDTO> parentTasksLists = new ArrayList<>();
	
	List<TaskDTO> taskList=new ArrayList<>();
	
	TaskDTO taskDto1=new TaskDTO();
	
	TaskDTO taskDto2=new TaskDTO();
	
	TaskDTO taskDto3=new TaskDTO();
	
	TaskDTO taskParentDto1 = new TaskDTO();
	
	TaskDTO taskParentDto2 = new TaskDTO();
	
	TaskDTO taskParentDtoError = new TaskDTO();
	TaskDTO taskDto4=new TaskDTO();
	
	/** The task vo 1. */
	TaskVO taskVo1=new TaskVO();
	
	/** The task vo 2. */
	TaskVO taskVo2=new TaskVO();
	
	/** The task vo 2. */
	TaskVO taskVo3=new TaskVO();
	
	
	/** The task vo 2. */
	TaskVO taskVo4=new TaskVO();
	
	/** The project VO 1. */
	ProjectVO projectVO1=new ProjectVO();
	
	/** The project VO 2. */
	ProjectVO projectVO2=new ProjectVO();
	
	/** The project VO 3. */
	ProjectVO projectVO3=new ProjectVO();
	
	/** The parent task VO. */
	ParentTaskVO parentTaskVO1=new ParentTaskVO();
	
	ParentTaskVO parentTaskVO2=new ParentTaskVO();
	
	ParentTaskVO parentTaskVOEmpty=new ParentTaskVO();
	
	/** The task VO list. */
	List<TaskVO> taskVOList=new ArrayList<>();
	
	List<TaskVO> newTaskVOList=new ArrayList<>();
	
	List<TaskVO> nextTaskVOList=new ArrayList<>();
	
	
	
	List<ParentTaskVO> parentTaskVOList=new ArrayList<>();
	
	List<ProjectVO> projectVOList=new ArrayList<>();
	
	/** The task VO list null. */
	List<TaskVO> taskVOListNull=null;
	
	List<TaskDTO> taskDTOListNull=new ArrayList<>();
	
 

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		this.usersVO1.setUserId(1);
		this.usersVO1.setFirstName("John");
		this.usersVO1.setLastName("Leslee");
		this.usersVO1.setEmployeeId(12412);
		
		this.usersVO2.setUserId(2);
		this.usersVO2.setFirstName("Ghomes");
		this.usersVO2.setLastName("Shelton");
		this.usersVO2.setEmployeeId(42412);
		
	
		this.projectVO1.setProjectId(1L);
		this.projectVO1.setProject("Termanite Project");
		this.projectVO1.setStartDate(LocalDate.parse("2019-12-01"));
		this.projectVO1.setEndDate(LocalDate.parse("2019-12-28"));
		this.projectVO1.setPriority(20);
		this.projectVO1.setUsersVO(this.usersVO1);
		this.projectVO1.setTaskList(this.newTaskVOList);
	
	
		this.projectVO2.setProjectId(2L);
		this.projectVO2.setProject("Solr Project");
		this.projectVO2.setStartDate(LocalDate.parse("2018-06-17"));
		this.projectVO2.setEndDate(LocalDate.parse("2018-11-28"));
		this.projectVO2.setPriority(30);
		this.projectVO2.setUsersVO(this.usersVO2);
		this.projectVO1.setTaskList(this.nextTaskVOList);
		
		this.projectVOList.add(projectVO1);
		this.projectVOList.add(projectVO2);


		this.taskParentDto1.setTaskId("1");
		this.taskParentDto1.setTaskName("Termanite Parent Task 1");
		this.taskParentDto1.setSetParentTask("1");
		
		this.parentTaskVO1.setParentId(1);
		this.parentTaskVO1.setParentTask("Termanite Parent Task 1");
		this.parentTaskVO1.toString();
		this.parentTaskVO1.equals(parentTaskVO1);
		
		this.parentTaskVO2.setParentId(2);
		this.parentTaskVO2.setParentTask("Solr Parent Task");
		this.parentTaskVO2.toString();
		this.parentTaskVO2.equals(parentTaskVO2);
		
		this.parentTaskVOList.add(this.parentTaskVO1);
		this.parentTaskVOList.add(this.parentTaskVO2);
		
		this.taskParentDto2.setTaskId("2");
		this.taskParentDto2.setTaskName("Solr Parent Task");
		this.taskParentDto2.setSetParentTask("1");
		
		this.parentTasksLists.add(this.taskParentDto1);
		this.parentTasksLists.add(this.taskParentDto2);

		this.taskParentDtoError.setSetParentTask("1");
	
		this.taskDto1.setTaskId("1");
		this.taskDto1.setEndDate("2019-12-28");
		this.taskDto1.setParentTaskId(null);
		this.taskDto1.setParentTaskName(null);
		this.taskDto1.setPriority("20");
		this.taskDto1.setProjectId("1");
		this.taskDto1.setProjectName("Termanite Project");
		this.taskDto1.setStartDate("2019-12-06");
		this.taskDto1.setTaskName("Termanite Task 1");
		this.taskDto1.setUserId("1");
		this.taskDto1.setUserName("John");
		this.taskDto1.setStatus("Pending");
		
		this.taskVo1.setTaskId(1);
		this.taskVo1.setTask("Termanite Task 1");
		this.taskVo1.setProjectVO(projectVO1);
		this.taskVo1.setUsersVO(usersVO1);
		this.taskVo1.setStartDate(LocalDate.parse("2019-12-06"));
		this.taskVo1.setEndDate(LocalDate.parse("2019-12-28"));
		this.taskVo1.setStatus("Pending");
		this.taskVo1.setPriority(20);
		this.taskVo1.setParentTaskVO(null);
		
		this.taskDto4.setTaskId("14");
		this.taskDto4.setTaskName("ParentTaskNmae");
		this.taskDto4.setSetParentTask("1");
		
		this.taskDto1.toString();
		this.taskDto1.equals(taskDto1);

					
		this.taskDto2.setTaskId("2");
		this.taskDto2.setEndDate("2019-12-20");
		this.taskDto2.setParentTaskId("1");
		this.taskDto2.setParentTaskName("Termanite Parent Task 1");
		this.taskDto2.setPriority("10");
		this.taskDto2.setProjectId("1");
		this.taskDto2.setProjectName("Termanite Project");
		this.taskDto2.setStartDate("2019-12-06");
		this.taskDto2.setTaskName("Termanite Task 2");
		this.taskDto2.setUserId("1");
		this.taskDto2.setUserName("John");
		this.taskDto2.setStatus("Pending");
		
		this.taskVo2.setTaskId(2);
		this.taskVo2.setTask("Termanite Task 2");
		this.taskVo2.setProjectVO(projectVO1);
		this.taskVo2.setUsersVO(usersVO1);
		this.taskVo2.setStartDate(LocalDate.parse("2019-12-06"));
		this.taskVo2.setEndDate(LocalDate.parse("2019-12-20"));
		this.taskVo2.setStatus("Pending");
		this.taskVo2.setPriority(10);
		this.taskVo2.setParentTaskVO(this.parentTaskVO1);
		this.taskVo2.toString();
		this.taskVo2.equals(taskVo2);
		
		this.taskDto2.toString();
		this.taskDto2.equals(taskDto2);
		
		
		this.taskDto3.setTaskId("3");
		this.taskDto3.setEndDate("2019-12-20");
		this.taskDto3.setParentTaskId(null);
		this.taskDto3.setParentTaskName(null);
		this.taskDto3.setPriority("15");
		this.taskDto3.setProjectId("2");
		this.taskDto3.setProjectName("Solr Project");
		this.taskDto3.setStartDate("2019-12-06");
		this.taskDto3.setTaskName("Solr Task 1");
		this.taskDto3.setUserId("2");
		this.taskDto3.setUserName("Ghomes");
		this.taskDto3.setStatus("Pending");
		
		this.taskVo3.setTaskId(3);
		this.taskVo3.setTask("Solr Task 1");
		this.taskVo3.setProjectVO(projectVO2);
		this.taskVo3.setUsersVO(usersVO2);
		this.taskVo3.setStartDate(LocalDate.parse("2019-12-06"));
		this.taskVo3.setEndDate(LocalDate.parse("2019-12-20"));
		this.taskVo3.setStatus("Pending");
		this.taskVo3.setPriority(15);
		this.taskVo3.setParentTaskVO(null);
		this.taskVo3.toString();
		this.taskVo3.equals(taskVo3);
		

		this.taskList.add(taskDto1);
		this.taskList.add(taskDto2);
		this.taskList.add(taskDto3);

		this.newTaskVOList.add(this.taskVo1);
		this.newTaskVOList.add(this.taskVo2);
		
		this.nextTaskVOList.add(this.taskVo3);
		
		this.taskVOList.add(this.taskVo1);
		this.taskVOList.add(this.taskVo2);
		this.taskVOList.add(this.taskVo3);

	}

	@Test
	public void testGetAllTasksPositiveFlow() throws Exception {
		when(taskVORepository.findAll()).thenReturn(taskVOList);
		List<TaskDTO> allTasks=new ArrayList<>();
		this.taskList.stream().forEach(taskVO->{allTasks.add(taskVO);});
		tasksService.getAllTasks();
		
		verify(taskVORepository, times(1)).findAll();
		assertEquals(3,allTasks.size());
	}
	
	@Test
	public void testGetAllTasksNegativeeFlow() throws Exception {
		when(taskVORepository.findAll()).thenReturn(null);
		List<TaskDTO> allTasks=new ArrayList<>();
		this.taskDTOListNull.stream().forEach(taskVO->{allTasks.add(taskVO);});
		tasksService.getAllTasks();
		
		verify(taskVORepository, times(1)).findAll();
		assertEquals(0,allTasks.size());
	}

	@Test
	public void testSearchTasksPositiveFlow() throws Exception {
		when(projectVORepository.findByProjectContainingOrProjectEndingWith(this.projectContain,this.projectContain)).thenReturn(projectVOList);
		
		List<TaskDTO> allTasks=new ArrayList<>();
		this.taskList.stream().forEach(taskVO->{allTasks.add(taskVO);});
		tasksService.searchTasks(projectContain);
		
		verify(projectVORepository, times(1)).findByProjectContainingOrProjectEndingWith(this.projectContain,this.projectContain);
		assertEquals(3,allTasks.size());
	}
	
	@Test
	public void testSearchTasksNegativeFlow() throws Exception {
		List<ProjectVO> emptyTaskNull=null;
		when(projectVORepository.findByProjectContainingOrProjectEndingWith(this.projectContain,this.projectContain)).thenReturn(emptyTaskNull);
		List<TaskDTO> allTasks=new ArrayList<>();
		this.taskDTOListNull.stream().forEach(taskVO->{allTasks.add(taskVO);});
		tasksService.searchTasks(projectContain);
		
		verify(projectVORepository, times(1)).findByProjectContainingOrProjectEndingWith(this.projectContain,this.projectContain);
		assertEquals(0,allTasks.size());
	}

	@Test
	public void testGetTaskByIdPositiveFlow() throws Exception {
	 
				when(taskVORepository.findByTaskId(1L)).thenReturn(this.taskVo1);
				TaskVO taskGetVO=this.taskVo1;				 
				tasksService.getTaskById(1L);				
				verify(taskVORepository, times(1)).findByTaskId(1L);
				assertEquals(1,taskGetVO.getTaskId());
				assertEquals("Termanite Task 1",taskGetVO.getTask());
				assertEquals(taskGetVO,taskVo1);
	}

	@Test
	public void testGetTaskByIdNegativeFlow() throws Exception {
	 
				when(taskVORepository.findByTaskId(10L)).thenReturn(null);
				TaskVO taskGetVO=null;				 
				tasksService.getTaskById(10L);				
				verify(taskVORepository, times(1)).findByTaskId(10L);
				assertEquals(null,taskGetVO);				
	}
	
	@Test
	public void testDeleteByTaskByIdPositiveFlow() throws Exception {
	TaskVO deleteTaskVO=new TaskVO();
		when(taskVORepository.findByTaskId(1L)).thenReturn(this.taskVo1);	
		parentTaskVORepository.deleteByParentTask(taskVo1);	
		taskVORepository.deleteByTaskId(1L);	
		tasksService.deleteByTaskById(11L);		 
		assertEquals(null,deleteTaskVO.getTask());
	}

	@Test
	public void testDeleteByTaskByIdNegativeFlow() throws Exception {
	TaskVO deleteTaskVO=this.taskVo1;
		when(taskVORepository.findByTaskId(1L)).thenReturn(null);	
		parentTaskVORepository.deleteByParentTask(null);	
		taskVORepository.deleteByTaskId(0);	
		tasksService.deleteByTaskById(1L);		 
		assertEquals("Termanite Task 1",deleteTaskVO.getTask());
	}
	




	
	@Test
	public void testSavePositiveFlow() throws Exception {
		 
	 	when(parentTaskVORepository.findByParentId(1)).thenReturn(this.parentTaskVO1);
		when(projectVORepository.findByProjectId(1)).thenReturn(this.projectVO1);
		when(usersVORepository.findByUserId(1L)).thenReturn(this.usersVO1);
		when(taskVORepository.save(this.taskVo2)).thenReturn(this.taskVo2);
		
		tasksService.save(this.taskDto2);				
		verify(taskVORepository, times(1)).save(this.taskVo2);
		assertEquals(taskVo2,this.taskVo2);	
		assertEquals("Pending",this.taskVo2.getStatus());
		assertEquals(this.taskVo2.getUsersVO(),this.usersVO1);	
		assertEquals(this.taskVo2.getParentTaskVO(),this.parentTaskVO1);	
		assertEquals(this.taskVo2.getProjectVO(),this.projectVO1);	
		
	}
		
		
	@Test
	public void testSaveAlternatePositiveFlow() throws Exception {
		long taskId=0L;
		TaskVO createTaskVO=this.taskVo1;
		createTaskVO.setStatus("Pending");
		when(taskVORepository.findByTaskId(0)).thenReturn(null);
		when(parentTaskVORepository.findByParentId(0)).thenReturn(null);
		when(projectVORepository.findByProjectId(1)).thenReturn(this.projectVO1);
		when(usersVORepository.findByUserId(1L)).thenReturn(this.usersVO1);
		when(taskVORepository.save(createTaskVO)).thenReturn(this.taskVo1);
		
		tasksService.save(this.taskDto1);				
		verify(taskVORepository, times(1)).save(createTaskVO);
		assertEquals(createTaskVO,this.taskVo1);	
		assertEquals(createTaskVO.getUsersVO(),this.usersVO1);	
		assertEquals(createTaskVO.getParentTaskVO(),null);	
		assertEquals(createTaskVO.getProjectVO(),this.projectVO1);	
		
	}

	
	@Test
	public void testSaveParentTaskPositiveFlow() throws Exception {
		ParentTaskVO createTaskVO=parentTaskVO2;
		when(parentTaskVORepository.save(parentTaskVO2)).thenReturn(parentTaskVO2);
		
		
		tasksService.saveParentTask(this.taskParentDto2);				
		verify(parentTaskVORepository, times(1)).save(createTaskVO);
		assertEquals(2,this.parentTaskVO2.getParentId());
		assertEquals("Solr Parent Task",this.parentTaskVO2.getParentTask());
		assertEquals(createTaskVO,this.parentTaskVO2);	
	}
	
	@Test
	public void testGetAllParentTasksPositiveFlow() throws Exception {
		when(parentTaskVORepository.findAll()).thenReturn(this.parentTaskVOList);
		List<TaskDTO> allTasks=new ArrayList<>();
		this.parentTasksLists.stream().forEach(parentTaskDto->{allTasks.add(parentTaskDto);});
		tasksService.getAllParentTasks();
		
		verify(parentTaskVORepository, times(1)).findAll();
		assertEquals(2,allTasks.size());
	}
	
	@Test
	public void testGetAllParentTasksNegativeeFlow() throws Exception {
		when(parentTaskVORepository.findAll()).thenReturn(null);
		List<TaskDTO> allTasks=new ArrayList<>();
		this.taskDTOListNull.stream().forEach(taskVO->{allTasks.add(taskVO);});
		tasksService.getAllParentTasks();
		
		verify(parentTaskVORepository, times(1)).findAll();
		assertEquals(0,allTasks.size());
	}
	

}

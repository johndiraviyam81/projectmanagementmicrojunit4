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
import com.projectmanagement.app.repositories.ParentTaskVORepository;
import com.projectmanagement.app.repositories.ProjectVORepository;
import com.projectmanagement.app.repositories.TaskVORepository;
import com.projectmanagement.app.repositories.UsersVORepository;
import com.projectmanagement.app.service.ProjectsService;
import com.projectmanagement.app.service.ProjectsServiceImpl;

// TODO: Auto-generated Javadoc
/**
 * The Class ProjectsServiceImplTest.
 */
public class ProjectsServiceImplTest {

	/** The projects service. */
	@InjectMocks
	private	ProjectsServiceImpl projectsService;
	
	/** The project VO repository. */
	@Mock
	private	ProjectVORepository projectVORepository;
	
	/** The User VO repository. */
	@Mock
	private UsersVORepository usersVORepository;
	
	/** The task VO repository. */
	@Mock
	private TaskVORepository taskVORepository;
	
	/** The parent task VO repository. */
	@Mock
	private ParentTaskVORepository parentTaskVORepository;
	
/** The project list. */
List<ProjectDTO> projectList=new ArrayList<>();

/** The project VO list. */
List<ProjectVO> projectVOList=new ArrayList<>();

/** The project VO null list. */
List<ProjectVO> projectVONullList=new ArrayList<>();
	
	/** The project null list. */
	List<ProjectDTO> projectNullList=new ArrayList<>();
	
	/** The project DTO 1. */
	ProjectDTO projectDTO1=new ProjectDTO();
	
	/** The project VO 1. */
	ProjectVO projectVO1=new ProjectVO();
	
	/** The project DTO 2. */
	ProjectDTO projectDTO2=new ProjectDTO();
	
	/** The project VO 2. */
	ProjectVO projectVO2=new ProjectVO();
	
	/** The project DTO 3. */
	ProjectDTO projectDTO3=new ProjectDTO();
	
	/** The project VO 3. */
	ProjectVO projectVO3=new ProjectVO();
	
	/** The project DTO 4. */
	ProjectDTO projectDTO4=new ProjectDTO();
	
	/** The project VO 4. */
	ProjectVO projectVO4=new ProjectVO();
	
	/** The project DTO 4 error. */
	ProjectDTO projectDTO4Error=new ProjectDTO();
	
	/** The users VO. */
	UsersVO usersVO=new UsersVO();
	
	/** The projectContain. */
	String projectContain="Solr";
	
	/** The task vo 1. */
	TaskVO taskVo1=new TaskVO();
	
	/** The task vo 2. */
	TaskVO taskVo2=new TaskVO();
	
	/** The parent task VO. */
	ParentTaskVO parentTaskVO=new ParentTaskVO();
	
	/** The task VO list. */
	List<TaskVO> taskVOList=new ArrayList<>();
	
	/** The task VO list null. */
	List<TaskVO> taskVOListNull=null;
	
	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	
		this.usersVO.setUserId(1);
		this.usersVO.setFirstName("John");
		this.usersVO.setLastName("Diraviyam");
		this.usersVO.setEmployeeId(12412);
		this.usersVO.toString();
		this.usersVO.hashCode();
		this.usersVO.equals(usersVO);
		
		this.taskVo1.setTaskId(1);
		this.taskVo1.setTask("Solr first Task");
		this.taskVo1.setProjectVO(projectVO1);
		this.taskVo1.setEndDate(LocalDate.parse("2019-12-01"));
		this.taskVo1.setStartDate(LocalDate.parse("2019-12-11"));
		this.taskVo1.setPriority(30);
		this.taskVo1.setUsersVO(usersVO);
		this.taskVo1.setStatus("Start");
		this.taskVo1.setParentTaskVO(null);
		
		this.taskVo1.toString();
		this.taskVo1.hashCode();
		this.taskVo1.equals(taskVo1);
		
		
		
		this.parentTaskVO.setParentId(1);
		this.parentTaskVO.setParentTask("Task Title");
		
		this.parentTaskVO.toString();
		this.parentTaskVO.hashCode();
		this.parentTaskVO.equals(parentTaskVO);
		
		this.taskVo2.setTaskId(2);
		this.taskVo2.setTask("Solr second Task");
		this.taskVo2.setProjectVO(projectVO1);
		this.taskVo2.setEndDate(LocalDate.parse("2018-12-01"));
		this.taskVo2.setStartDate(LocalDate.parse("2018-12-11"));
		this.taskVo2.setPriority(60);
		this.taskVo2.setUsersVO(usersVO);
		this.taskVo2.setStatus("Start");
		this.taskVo2.setParentTaskVO(parentTaskVO);
		
		this.taskVOList.add(this.taskVo1);
		this.taskVOList.add(this.taskVo2);
		
		this.projectVO1.setProjectId(1L);
		this.projectVO1.setProject("Solr elmer project");
		this.projectVO1.setStartDate(LocalDate.parse("2019-12-01"));
		this.projectVO1.setEndDate(LocalDate.parse("2019-12-28"));
		this.projectVO1.setPriority(60);
		this.projectVO1.setUsersVO(this.usersVO);
		
		this.projectVO1.toString();
		this.projectVO1.hashCode();
		this.projectVO1.equals(projectVO1);
		
		
		this.projectDTO1.setProjectId("1");
		this.projectDTO1.setProjectName("Solr elmer project");
		this.projectDTO1.setStartDate("2019-12-01");
		this.projectDTO1.setEndDate("2019-12-28");
		this.projectDTO1.setPriority("60");
		this.projectDTO1.setUserId("1");
		this.projectDTO1.setUserName("John");
		LocalDate today=LocalDate.of(19, 12, 03);
		this.projectDTO1.setNoOfTasks(String.valueOf(this.taskVOList.size()));
		
		
		
		this.projectVO2.setProjectId(2L);
		this.projectVO2.setProject("Perkin elmer project");
		this.projectVO2.setStartDate(LocalDate.parse("2018-06-17"));
		this.projectVO2.setEndDate(LocalDate.parse("2018-11-28"));
		this.projectVO2.setPriority(90);
		this.projectVO2.setUsersVO(this.usersVO);
		
		this.projectDTO2.setProjectId("2");
		this.projectDTO2.setProjectName("Perkin elmer project");
		this.projectDTO2.setStartDate("2018-06-17");
		this.projectDTO2.setEndDate("2018-11-28");
		this.projectDTO2.setPriority("90");
		this.projectDTO2.setUserId("1");
		this.projectDTO2.setUserName("John");
		 
		this.projectDTO2.setNoOfTasks("0");
		
		
	


		
		this.projectDTO3.setProjectId("3");
		this.projectDTO3.setProjectName("ILL elmer project");
		this.projectDTO3.setStartDate("2019-02-17");
		this.projectDTO3.setEndDate("2019-08-28");
		this.projectDTO3.setPriority("30");
		this.projectDTO3.setUserId("1");
		this.projectDTO3.setUserName("John");		
		this.projectDTO3.setNoOfTasks("0");
		
		this.projectVO3.setProject(this.projectDTO3.getProjectName());
		this.projectVO3.setProjectId(Long.parseLong(this.projectDTO3.getProjectId()));
		
		this.projectVO3.setStartDate(LocalDate.parse(this.projectDTO3.getStartDate()));
		this.projectVO3.setEndDate(LocalDate.parse(this.projectDTO3.getEndDate()));
		this.projectVO3.setPriority(Integer.parseInt(this.projectDTO3.getPriority()));
		this.projectVO3.setUsersVO(this.usersVO);
		 

		

		
	 
		/*this.projectVO4.setProjectId(0L);
		this.projectVO4.setProject("ILL elmer project");
		
		this.projectVO4.setPriority(30);*/
				
		 this.projectList.add(this.projectDTO1);
		  this.projectList.add(this.projectDTO2);
		  this.projectList.add(this.projectDTO3);
		  
		  this.projectVOList.add(this.projectVO1);
		  this.projectVOList.add(this.projectVO2);
		  this.projectVOList.add(this.projectVO3);
		  
		  
	}

	/**
	 * Test get all projects possitive flow.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testGetAllProjectsPositiveFlow()  throws Exception {
		when(projectVORepository.findAll()).thenReturn(projectVOList);
		when(taskVORepository.findByProjectVO(this.projectVO1)).thenReturn(this.taskVOList);
		List<ProjectDTO> allProjects=new ArrayList<>();
		this.projectList.stream().forEach(projectVO->{allProjects.add(projectVO);});
		projectsService.getAllProjects();
		
		verify(projectVORepository, times(1)).findAll();
		assertEquals(3,projectList.size());
	}
	
	
	/**
	 * Test search all projects possitive flow.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testSearchProjectsPositiveFlow()  throws Exception {
		when(projectVORepository.findByProjectContaining(this.projectContain)).thenReturn(projectVOList);
		when(taskVORepository.findByProjectVO(this.projectVO1)).thenReturn(this.taskVOList);
		List<ProjectDTO> allProjects=new ArrayList<>();
		projectList.stream().forEach(projectVO->{allProjects.add(projectVO);});
		
		projectsService.searchProjects(projectContain);
		 verify(projectVORepository, times(1)).findByProjectContaining(projectContain);		 
		assertEquals(3,allProjects.size());
		
	}
	 
	/**
	 * Test get all projects negative flow.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testGetAllProjectsNegativeFlow()  throws Exception {
		when(projectVORepository.findAll()).thenReturn(null);
		List<ProjectDTO> allProjects=new ArrayList<>();
		
		allProjects=projectsService.getAllProjects();
		
		 verify(projectVORepository, times(1)).findAll();	
		assertEquals(0,projectNullList.size());
		
	}
	
	/**
	 * Test search all projects negative flow.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testSearchProjectsNegativeFlow()  throws Exception {
		when(projectVORepository.findByProjectContaining(this.projectContain)).thenReturn(null);
		List<ProjectDTO> allProjects=new ArrayList<>();
		
		this.projectNullList.stream().forEach(projectVO->{allProjects.add(projectVO);});
		
		projectsService.searchProjects(projectContain);
		 verify(projectVORepository, times(1)).findByProjectContaining(projectContain);		 
		assertEquals(0,allProjects.size());
		
	}
	
	/**
	 * Test save postive flow.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testSavePostiveFlow() throws Exception {
		when(usersVORepository.findByUserId(1L)).thenReturn(this.usersVO);
		when(projectVORepository.save(this.projectVO3)).thenReturn(this.projectVO3);
		
		projectsService.save(this.projectDTO3);
		 verify(projectVORepository, times(1)).save(projectVO3);
		assertEquals(3L,projectVO3.getProjectId());
		
	}
	
	/**
	 * Test save negative flow.
	 *
	 * @throws Exception the exception
	 */

	@Test
	public void testSaveNegativeFlow() throws Exception{
		when(usersVORepository.findByUserId(1)).thenReturn(this.usersVO);
		when(projectVORepository.save(this.projectVO3)).thenReturn(null);		
		UsersVO negUser=null;
		projectsService.save(this.projectDTO3);
		verify(projectVORepository, times(1)).save(projectVO3);
		assertEquals(negUser,null);
	}


	/**
	 * Test get project by id possitive flow.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testGetProjectByIdPositiveFlow() throws Exception{
		
		when(projectVORepository.findByProjectId(1)).thenReturn(this.projectVO1);
		when(taskVORepository.findByProjectVO(this.projectVO1)).thenReturn(this.taskVOList);
		ProjectVO projectGetVo=this.projectVO1;
		projectsService.getProjectById(1);
		verify(projectVORepository, times(1)).findByProjectId(1);
		assertEquals(1,this.projectVO1.getProjectId());
		assertEquals(2,this.taskVOList.size());
		assertEquals("Solr elmer project",this.projectVO1.getProject());
		assertEquals(projectGetVo,this.projectVO1);
	}
	
	/**
	 * Test get project by id negative flow.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testGetProjectByIdNegativeFlow() throws Exception{
		
		when(projectVORepository.findByProjectId(5)).thenReturn(null);		
		ProjectVO projectGetVo=null;
		projectsService.getProjectById(5);
		verify(projectVORepository, times(1)).findByProjectId(5);
		assertEquals(null,projectGetVo);
		 
	}
	
	/**
	 * Test delete project by id possitive flow.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testDeleteProjectByIdPositiveFlow() throws Exception{
		ProjectVO deleteProject=new ProjectVO();
		when(projectVORepository.findByProjectId(1)).thenReturn(this.projectVO1);	
		when(taskVORepository.findByProjectVO(this.projectVO1)).thenReturn(this.taskVOList);
		
			parentTaskVORepository.deleteByParentTask(null);
			taskVORepository.deleteByTaskId(this.taskVOList.get(0).getTaskId()); 
			parentTaskVORepository.deleteByParentTask(this.taskVOList.get(0));
			taskVORepository.deleteByTaskId(this.taskVOList.get(1).getTaskId()); 
		
		projectVORepository.deleteByProjectId(1);
		 
		projectsService.deleteProjectById(1);
 
		assertEquals(null,deleteProject.getProject());
 
	}
	
	/**
	 * Test delete project by id negative flow.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testDeleteProjectByIdNegativeFlow() throws Exception{
		ProjectVO deleteProject=new ProjectVO();
		when(projectVORepository.findByProjectId(1)).thenReturn(null);	
		when(taskVORepository.findByProjectVO(this.projectVO1)).thenReturn(null);
		
			parentTaskVORepository.deleteByParentTask(null);
			taskVORepository.deleteByTaskId(0); 
		 
		
		projectVORepository.deleteByProjectId(1);
		 
		projectsService.deleteProjectById(1);
 
		assertEquals("Solr elmer project",this.projectVO1.getProject());
 
	}
		
}

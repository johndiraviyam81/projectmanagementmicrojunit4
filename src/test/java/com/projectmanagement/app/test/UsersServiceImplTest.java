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
import com.projectmanagement.app.model.TaskDTO;
import com.projectmanagement.app.model.UserDTO;
import com.projectmanagement.app.repositories.ParentTaskVORepository;
import com.projectmanagement.app.repositories.ProjectVORepository;
import com.projectmanagement.app.repositories.TaskVORepository;
import com.projectmanagement.app.repositories.UsersVORepository;
import com.projectmanagement.app.service.UsersServiceImpl;


public class UsersServiceImplTest {
	
	@InjectMocks
	UsersServiceImpl usersService;
	
	/** The users VO repository. */
	@Mock
	UsersVORepository usersVORepository;
	
	/** The project VO repository. */
	@Mock
	ProjectVORepository projectVORepository;
	
	/** The task VO repository. */
	@Mock
	TaskVORepository taskVORepository;
	
	/** The users VO2. */
	UsersVO usersVO1=new UsersVO();
	

	/** The users VO2. */
	UsersVO usersVO2=new UsersVO();
	
	/** The users VO3. */
	UsersVO usersVO3=new UsersVO();
	
	List<UserDTO> userList=new ArrayList<>();
	
	List<UserDTO> userListEmpty=new ArrayList<>();
	
	UserDTO userDto1=new UserDTO();
	
	UserDTO userDto2=new UserDTO();
	
	UserDTO userDto3=new UserDTO();
	
	List<UsersVO> usersVOList=new ArrayList<>();
	
	/** The task vo 1. */
	TaskVO taskVo1=new TaskVO();
	
	/** The task vo 2. */
	TaskVO taskVo2=new TaskVO();
	
	/** The project VO 1. */
	ProjectVO projectVO1=new ProjectVO();
	
	/** The project VO 2. */
	ProjectVO projectVO2=new ProjectVO();
	
	List<TaskVO> taskVOList=new ArrayList<>();
	
	List<ProjectVO> projectVOList=new ArrayList<>();
	
	List<String> userString=new ArrayList<>();

 	@Before
 	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		this.userDto1.setUserId("1");
		this.userDto1.setFirstName("John Diraviyam");
		this.userDto1.setLastName("Leslee");
		this.userDto1.setEmployeeId("13123");

		this.userDto2.setUserId("5");
		this.userDto2.setFirstName("Boogy man");
		this.userDto2.setLastName("Shelton");
		this.userDto2.setEmployeeId("234324");
		
		this.userDto3.setUserId("6");
		this.userDto3.setFirstName("Viceroi");
		this.userDto3.setLastName("Gomez");
		this.userDto3.setEmployeeId("454234");
		
		this.usersVO1.setUserId(1);
		this.usersVO1.setFirstName("John Diraviyam");
		this.usersVO1.setLastName("Leslee");
		this.usersVO1.setEmployeeId(13123);
		
		this.usersVO2.setUserId(5);
		this.usersVO2.setFirstName("Boogy Man");
		this.usersVO2.setLastName("Shelton");
		this.usersVO2.setEmployeeId(234324);
		
		this.usersVO3.setUserId(6);
		this.usersVO3.setFirstName("Viceroi");
		this.usersVO3.setLastName("Gomez");
		this.usersVO3.setEmployeeId(454234);
		
		this.usersVOList.add(this.usersVO1);
		this.usersVOList.add(this.usersVO2);
		this.usersVOList.add(this.usersVO2);
		
		this.userList.add(this.userDto1);
		this.userList.add(this.userDto2);
		this.userList.add(this.userDto3);
		
		this.projectVO1.setProjectId(1L);
		this.projectVO1.setProject("Solr elmer project");
		this.projectVO1.setStartDate(LocalDate.parse("2019-12-01"));
		this.projectVO1.setEndDate(LocalDate.parse("2019-12-28"));
		this.projectVO1.setPriority(60);
		this.projectVO1.setUsersVO(this.usersVO1);
		
	
	
		this.projectVO2.setProjectId(2L);
		this.projectVO2.setProject("Perkin elmer project");
		this.projectVO2.setStartDate(LocalDate.parse("2018-06-17"));
		this.projectVO2.setEndDate(LocalDate.parse("2018-11-28"));
		this.projectVO2.setPriority(90);
		this.projectVO2.setUsersVO(this.usersVO2);
		
		this.taskVo1.setTaskId(11);
		this.taskVo1.setTask("Task of this Project 1");
		this.taskVo1.setProjectVO(projectVO1);
		this.taskVo1.setEndDate(LocalDate.parse("2019-11-30"));
		this.taskVo1.setStartDate(LocalDate.parse("2019-11-29"));
		this.taskVo1.setPriority(30);
		this.taskVo1.setUsersVO(usersVO1);
		this.taskVo1.setStatus("Start");
		this.taskVo1.setParentTaskVO(null);
		
		this.taskVo2.setTaskId(12);
		this.taskVo2.setTask("Solr second Task");
		this.taskVo2.setProjectVO(projectVO2);
		this.taskVo2.setEndDate(LocalDate.parse("2019-11-30"));
		this.taskVo2.setStartDate(LocalDate.parse("2019-11-29"));
		this.taskVo2.setPriority(20);
		this.taskVo2.setUsersVO(usersVO2);
		this.taskVo2.setStatus("Start");
		this.taskVo2.setParentTaskVO(null);
		
		this.taskVOList.add(this.taskVo1);		
		this.projectVOList.add(this.projectVO1);
		
		this.userString.add("John Diraviyam");
		this.userString.add("Boogy man");
		this.userString.add("Viceroi");
	}

	@Test
	public void testGetAllUsersPositiveFlow() throws Exception {
		when(usersVORepository.findAll()).thenReturn(usersVOList);
		List<UserDTO> allUsers=new ArrayList<>();
		this.userList.stream().forEach(userVO->{allUsers.add(userVO);});
		usersService.getAllUsers();		
		verify(usersVORepository, times(1)).findAll();
		assertEquals(3,allUsers.size()); 
	}
	
	@Test
	public void testGetAllUsersNegativeFlow() throws Exception {
		when(usersVORepository.findAll()).thenReturn(null);
		List<UserDTO> allUsers=new ArrayList<>();
		this.userListEmpty.stream().forEach(userVO->{allUsers.add(userVO);});
		usersService.getAllUsers();		
		verify(usersVORepository, times(1)).findAll();
		assertEquals(0,allUsers.size()); 
	}

	@Test
	public void testSearchUsersPositiveFlow() throws Exception {
		when(usersVORepository.findByFirstNameIn(this.userString)).thenReturn(usersVOList);
		List<UserDTO> allUsers=new ArrayList<>();
		this.userList.stream().forEach(userVO->{allUsers.add(userVO);});
		usersService.searchUsers(userString);	
		verify(usersVORepository, times(1)).findByFirstNameIn(this.userString);
		assertEquals(3,allUsers.size());  
	}
	
	@Test
	public void testSearchUsersNegativeFlow() throws Exception {
		when(usersVORepository.findByFirstNameIn(this.userString)).thenReturn(null);
		List<UserDTO> allUsers=new ArrayList<>();
		this.userListEmpty.stream().forEach(userVO->{allUsers.add(userVO);});
		usersService.searchUsers(userString);
		verify(usersVORepository, times(1)).findByFirstNameIn(this.userString);
		assertEquals(0,allUsers.size());  
	}

	@Test
	public void testGetUserPositiveFlow() throws Exception {
		when(usersVORepository.findByUserId(1L)).thenReturn(this.usersVO1);
		UsersVO getUserVO=this.usersVO1;
		UserDTO getUserDto=this.userDto1;
		
		usersService.getUser("1");	
		verify(usersVORepository, times(1)).findByUserId(1L);
		assertEquals(1L,getUserVO.getUserId());
		assertEquals("John Diraviyam",getUserVO.getFirstName());
		assertEquals(getUserVO,usersVO1);
		assertEquals(getUserDto,this.userDto1);
	}
	
	@Test
	public void testGetUserNegativeFlow() throws Exception {
		when(usersVORepository.findByUserId(2L)).thenReturn(null);
		UsersVO getUserVO=new UsersVO();
		UserDTO getUserDto=null;
		
		usersService.getUser("2");	
		verify(usersVORepository, times(1)).findByUserId(2L);
		assertEquals(0L,getUserVO.getUserId());
		assertEquals(new UsersVO(),getUserVO);
		assertEquals(null,getUserDto);
	}

	@Test
	public void testDeleteUserPositiveFlow() throws Exception {
		when(usersVORepository.findByUserId(1L)).thenReturn(this.usersVO1);
		when(projectVORepository.findByUsersVO(usersVO1)).thenReturn(this.projectVOList);
		when(taskVORepository.findByUsersVO(usersVO1)).thenReturn(this.taskVOList);
		UsersVO deleteUserVO=this.usersVO1;
		usersService.deleteUser("1");	
		verify(projectVORepository, times(1)).findByUsersVO(usersVO1);	
		assertEquals(1L,deleteUserVO.getUserId());
		assertEquals("John Diraviyam",deleteUserVO.getFirstName());
		assertEquals(deleteUserVO,usersVO1);
		assertEquals(deleteUserVO,projectVOList.get(0).getUsersVO());
		assertEquals(deleteUserVO,taskVOList.get(0).getUsersVO());
		
	}
	
	@Test
	public void testDeleteUserAlternatePositiveFlow() throws Exception {
		when(usersVORepository.findByUserId(6L)).thenReturn(this.usersVO3);
		when(projectVORepository.findByUsersVO(usersVO3)).thenReturn(null);
		when(taskVORepository.findByUsersVO(usersVO3)).thenReturn(null);
		UsersVO deleteUserVO=new UsersVO();
		usersVORepository.deleteByUserId(Long.parseLong("6"));	
		usersService.deleteUser("6");	
		//verify(usersVORepository, times(1)).deleteByUserId(Long.parseLong("6"));	
		assertEquals(new UsersVO(),deleteUserVO);
		assertNotEquals("Viceroi",deleteUserVO.getFirstName());
		assertNotEquals(454234,deleteUserVO.getEmployeeId());
		
	}
	
	@Test
	public void testSavePositiveFlow() throws Exception {
		when(usersVORepository.save(usersVO1)).thenReturn(this.usersVO1);
		UsersVO createUserVO=this.usersVO1;
		usersService.save(this.userDto1);	
		verify(usersVORepository, times(1)).save(createUserVO);	
		assertEquals(1L,createUserVO.getUserId());
		assertEquals("John Diraviyam",createUserVO.getFirstName());
		assertEquals(createUserVO,this.usersVO1);		 
		
	}
	
	@Test
	public void testSaveNegativeFlow() throws Exception {
		when(usersVORepository.save(usersVO3)).thenReturn(null);
		UsersVO createUserVO=null ;
		usersService.save(this.userDto3);	
		verify(usersVORepository, times(1)).save(usersVO3);	
		assertEquals(null,createUserVO);
	 
		
	}

}

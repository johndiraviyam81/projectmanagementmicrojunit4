package com.projectmanagement.app.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.projectmanagement.app.util.ProjectManagementConstants;

import java.lang.reflect.Array;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.projectmanagement.app.controllers.TasksController;
import com.projectmanagement.app.controllers.UsersController;
import com.projectmanagement.app.model.DeleteRecordDTO;
import com.projectmanagement.app.model.UserDTO;
import com.projectmanagement.app.service.UsersService;


/**
 * The Class UsersControllerTest.
 */

public class UsersControllerTest {


	@InjectMocks
	UsersController usersController;
	
	@Mock
	private	UsersService usersService;
	
	
	private MockMvc mvc;
	
	List<UserDTO> userList=new ArrayList<>();
	
	List<UserDTO> userListEmpty=new ArrayList<>();
	
	UserDTO userDto1=new UserDTO();
	
	UserDTO userDto2=new UserDTO();
	
	UserDTO userDto3=new UserDTO();
	
	UserDTO userDtompty=new UserDTO();
	
	/** The delete record. */
	DeleteRecordDTO deleteRecord=new DeleteRecordDTO();	
	
	DeleteRecordDTO deleteNotRecord=new DeleteRecordDTO();	
	
	UserDTO userDto4Error=new UserDTO();
	
	UserDTO userDto5Error=new UserDTO();
	
	String userDto1Json="{\"userId\":\"1\",\"firstName\":\"John Diraviyam\",\"lastName\":\"Leslee\",\"employeeId\":\"13123\",\"message\":\"User is added successfully\"}";
	
	String userDto2Json="{\"userId\":\"5\",\"firstName\":\"Boogy man\",\"lastName\":\"Shelton\",\"employeeId\":\"234324\",\"message\":\"User is updated successfully\"}";
	
	String userDto3Json="{\"userId\":\"6\",\"firstName\":\"Viceroi\",\"lastName\":\"Gomez\",\"employeeId\":\"454234\",\"message\":\"User is received successfully\"}";
	
	String userDto4CreateErrorJson="{\"userId\":\"0\"}";
	
	
	String userDto4ErrorJson="{\"userId\":null,\"firstName\":null,\"lastName\":null,\"employeeId\":\"abcde1234\",\"message\":null}";
	
	String userDto4EmptyJson="{\"userId\":null,\"firstName\":null,\"lastName\":null,\"employeeId\":null,\"message\":null}";
	
	String userDto4EmptyAddJson="{\"userId\":null,\"firstName\":null,\"lastName\":null,\"employeeId\":null,\"message\":\"User is added successfully\"}";
	
	String userDto4EmptyUpdateJson="{\"userId\":null,\"firstName\":null,\"lastName\":null,\"employeeId\":null,\"message\":\"User is updated successfully\"}";
	
	String userDto4ReturnErrorJson="{\"userId\":null,\"firstName\":null,\"lastName\":null,\"employeeId\":\"abcde1234\",\"message\":\"Error has been occured while creating user\"}";
	
	String userDto5ErrorJson="{\"userId\":\"15\",\"firstName\":null,\"lastName\":null,\"employeeId\":\"abcde1234\",\"message\":null}";
	
	String userDto5ReturnErrorJson="{\"userId\":\"15\",\"firstName\":null,\"lastName\":null,\"employeeId\":\"abcde1234\",\"message\":\"Error has been occured while updating user\"}";
	
	String userDto6EmptyJson="{\"userId\":null,\"firstName\":null,\"lastName\":null,\"employeeId\":null,\"message\":\"User is received successfully\"}";
	
	
	String userDto6ErrorJson="{\"userId\":null,\"firstName\":null,\"lastName\":null,\"employeeId\":null,\"message\":\"Error has been occured while fetching user\"}";
	
	String userListJson="[{\"userId\":\"1\",\"firstName\":\"John Diraviyam\",\"lastName\":\"Leslee\",\"employeeId\":\"13123\",\"message\":null},{\"userId\":\"5\",\"firstName\":\"Boogy man\",\"lastName\":\"Shelton\",\"employeeId\":\"234324\",\"message\":null},{\"userId\":\"6\",\"firstName\":\"Viceroi\",\"lastName\":\"Gomez\",\"employeeId\":\"454234\",\"message\":null}]";
	
	/** The delete record json. */
	String deleteRecordJson="{\"deleteId\":null,\"message\":\"User is deleted successfully\"}";
	
	/** The delete not record json. */
	String deleteNotRecordJson="{\"deleteId\":null,\"message\":\"User is not deleted successfully as user is referenced in projects or tasks\"}";
	
	
	String userListJsonEmpty="";
	
	String userSearchStringsJson="[\"John Diraviyam\",\"Boogy man\",\"Viceroi\"]";
	
	List<String> userString=new ArrayList<>();
	

	@Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        this.mvc = MockMvcBuilders
                .standaloneSetup(this.usersController)
                .build();
	
	
	this.userDto1.setUserId("1");
	this.userDto1.setFirstName("John Diraviyam");
	this.userDto1.setLastName("Leslee");
	this.userDto1.setEmployeeId("13123");
	
	this.userDto1.toString();
	this.userDto1.equals(userDto1);

	this.userDto2.setUserId("5");
	this.userDto2.setFirstName("Boogy man");
	this.userDto2.setLastName("Shelton");
	this.userDto2.setEmployeeId("234324");
	
	this.userDto3.setUserId("6");
	this.userDto3.setFirstName("Viceroi");
	this.userDto3.setLastName("Gomez");
	this.userDto3.setEmployeeId("454234");
	
	this.userDto4Error.setUserId("0");
	this.userDto4Error.setEmployeeId("abcde1234");
	
	this.userDto5Error.setUserId("15");
	this.userDto5Error.setEmployeeId("abcde1234");
	
	System.out.println(this.userDto4Error.toString());
	
	this.deleteRecord.setDeleteId(null);
	this.deleteRecord.setMessage("User is deleted successfully");


	this.deleteNotRecord.setDeleteId(null);
	this.deleteNotRecord.setMessage("User is not deleted successfully as user is referenced in projects or tasks");
	 
	this.userList.add(this.userDto1);
	this.userList.add(this.userDto2);
	this.userList.add(this.userDto3);
	
	this.userString.add("John Diraviyam");
	this.userString.add("Boogy man");
	this.userString.add("Viceroi");

	}

	@Test
	public void testGetAllUsersPositiveFlow() throws Exception {
		Mockito.when(this.usersService.getAllUsers()).thenReturn(this.userList);		
		
		MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders.get(ProjectManagementConstants.URL_USER_Service+ProjectManagementConstants.URL_USER_getAllUsers).accept(MediaType.APPLICATION_JSON);
		MockHttpServletResponse response=this.mvc.perform(requestBuilder).andExpect(status().isOk()).andReturn().getResponse();
		verify(this.usersService, times(1)).getAllUsers();
		assertEquals(this.userListJson,response.getContentAsString());
	}
	
	@Test
	public void testGetAllUsersNegativeFlow() throws Exception {
		Mockito.when(this.usersService.getAllUsers()).thenReturn(this.userListEmpty);		
		
		MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders.get(ProjectManagementConstants.URL_USER_Service+ProjectManagementConstants.URL_USER_getAllUsers).accept(MediaType.APPLICATION_JSON);
		MockHttpServletResponse response=this.mvc.perform(requestBuilder).andExpect(status().isOk()).andReturn().getResponse();
		verify(this.usersService, times(1)).getAllUsers();
		assertEquals("[]",response.getContentAsString());
	}
	
	@Test(expected = NullPointerException.class)
	public void testGetAllUsersExceptionFlow() throws Exception {
		Mockito.when(this.usersService.getAllUsers()).thenThrow(NullPointerException.class);	
		
		MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders.get(ProjectManagementConstants.URL_USER_Service+ProjectManagementConstants.URL_USER_getAllUsers).accept(MediaType.APPLICATION_JSON);
		MockHttpServletResponse response=this.mvc.perform(requestBuilder).andExpect(status().isBadRequest()).andExpect(null).andReturn().getResponse();
		verify(this.usersService, times(1)).getAllUsers();
		assertEquals("[]",response.getContentAsString());
	}

	@Test
	public void testSearchUsersPositiveFlow() throws Exception {
	Mockito.when(this.usersService.searchUsers(this.userString)).thenReturn(this.userList);		
		
		MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders.post(ProjectManagementConstants.URL_USER_Service+ProjectManagementConstants.URL_USER_searchAllUsers).accept(MediaType.APPLICATION_JSON).content(this.userSearchStringsJson).contentType(MediaType.APPLICATION_JSON);
		MockHttpServletResponse response=this.mvc.perform(requestBuilder).andExpect(status().isOk()).andReturn().getResponse();
		verify(this.usersService, times(1)).searchUsers(this.userString);
		assertEquals(this.userListJson,response.getContentAsString());
		
	}
	
	@Test
	public void testSearchUsersNegativeFlow() throws Exception {
	Mockito.when(this.usersService.searchUsers(this.userString)).thenReturn(this.userListEmpty);		
		
		MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders.post(ProjectManagementConstants.URL_USER_Service+ProjectManagementConstants.URL_USER_searchAllUsers).accept(MediaType.APPLICATION_JSON).content(this.userSearchStringsJson).contentType(MediaType.APPLICATION_JSON);
		MockHttpServletResponse response=this.mvc.perform(requestBuilder).andExpect(status().isOk()).andReturn().getResponse();
		verify(this.usersService, times(1)).searchUsers(this.userString);
		assertEquals("[]",response.getContentAsString());
		
	}

	@Test(expected = NullPointerException.class)
	public void testSearchUsersExceptionFlow() throws Exception {
	Mockito.when(this.usersService.searchUsers(this.userString)).thenThrow(NullPointerException.class);	
		
		MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders.post(ProjectManagementConstants.URL_USER_Service+ProjectManagementConstants.URL_USER_searchAllUsers).accept(MediaType.APPLICATION_JSON).content(this.userSearchStringsJson).contentType(MediaType.APPLICATION_JSON);
		MockHttpServletResponse response=this.mvc.perform(requestBuilder).andExpect(status().isBadRequest()).andExpect(null).andReturn().getResponse();
		verify(this.usersService, times(1)).searchUsers(this.userString);
		assertEquals("[]",response.getContentAsString());
		
	}

	
	@Test
	public void testUpdateUserPositiveFlow() throws Exception {
	Mockito.when(this.usersService.save(this.userDto2)).thenReturn(5L);
		
		MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders.put(ProjectManagementConstants.URL_USER_Service+ProjectManagementConstants.URL_USER_update).accept(MediaType.APPLICATION_JSON).content(this.userDto2Json).contentType(MediaType.APPLICATION_JSON);
		MockHttpServletResponse response=this.mvc.perform(requestBuilder).andExpect(status().isOk()).andReturn().getResponse();
		verify(this.usersService, times(1)).save(this.userDto2);
		assertEquals(this.userDto2Json,response.getContentAsString());
	}
	
	@Test
	public void testUpdateUserNegativeFlow() throws Exception {
	Mockito.when(this.usersService.save(this.userDtompty)).thenReturn(0L);
		
		MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders.put(ProjectManagementConstants.URL_USER_Service+ProjectManagementConstants.URL_USER_update).accept(MediaType.APPLICATION_JSON).content(this.userDto4EmptyJson).contentType(MediaType.APPLICATION_JSON);
		MockHttpServletResponse response=this.mvc.perform(requestBuilder).andExpect(status().isOk()).andReturn().getResponse();
		verify(this.usersService, times(1)).save(this.userDtompty);
		assertEquals(this.userDto4EmptyUpdateJson,response.getContentAsString());
	}
	
	@Test(expected = NullPointerException.class)
	public void testUpdateUserExceptionFlow() throws Exception {
	Mockito.when(this.usersService.save(this.userDto5Error)).thenThrow(NullPointerException.class);
		
		MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders.put(ProjectManagementConstants.URL_USER_Service+ProjectManagementConstants.URL_USER_update).accept(MediaType.APPLICATION_JSON).content(this.userDto5ErrorJson).contentType(MediaType.APPLICATION_JSON);
		MockHttpServletResponse response=this.mvc.perform(requestBuilder).andExpect(status().isBadRequest()).andExpect(null).andReturn().getResponse();
		verify(this.usersService, times(1)).save(this.userDto5Error);
		assertEquals(this.userDto5ReturnErrorJson,response.getContentAsString());
	}

	@Test
	public void testAddUserPositiveFlow() throws Exception {
Mockito.when(this.usersService.save(this.userDto1)).thenReturn(1L);
		
		MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders.post(ProjectManagementConstants.URL_USER_Service+ProjectManagementConstants.URL_USER_addUser).accept(MediaType.APPLICATION_JSON).content(this.userDto1Json).contentType(MediaType.APPLICATION_JSON);
		MockHttpServletResponse response=this.mvc.perform(requestBuilder).andExpect(status().isOk()).andReturn().getResponse();
		verify(this.usersService, times(1)).save(this.userDto1);
		assertEquals(this.userDto1Json,response.getContentAsString());
	}
	
	@Test
	public void testAddUserNegativeFlow() throws Exception {
Mockito.when(this.usersService.save(this.userDtompty)).thenReturn(0L);
		
		MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders.post(ProjectManagementConstants.URL_USER_Service+ProjectManagementConstants.URL_USER_addUser).accept(MediaType.APPLICATION_JSON).content(this.userDto4EmptyJson).contentType(MediaType.APPLICATION_JSON);
		MockHttpServletResponse response=this.mvc.perform(requestBuilder).andExpect(status().isOk()).andReturn().getResponse();
		verify(this.usersService, times(1)).save(this.userDto4Error);
		assertEquals(this.userDto4EmptyAddJson,response.getContentAsString());
	}
	
	@Test(expected = NullPointerException.class)
	public void testAddUserExceptionFlow() throws Exception {
		Mockito.when(this.usersService.save(this.userDto4Error)).thenThrow(NullPointerException.class);
		
		MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders.post(ProjectManagementConstants.URL_USER_Service+ProjectManagementConstants.URL_USER_addUser).accept(MediaType.APPLICATION_JSON).content(this.userDto4ErrorJson).contentType(MediaType.APPLICATION_JSON);
		MockHttpServletResponse response=this.mvc.perform(requestBuilder).andExpect(status().isBadRequest()).andExpect(null).andReturn().getResponse();
		verify(this.usersService, times(1)).save(this.userDto4Error);
		assertEquals(this.userDto4ReturnErrorJson,response.getContentAsString());
	}

	@Test
	public void testGetUserPositiveFlow() throws Exception{
	Mockito.when(this.usersService.getUser("6")).thenReturn(this.userDto3);
		
		MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders.get(ProjectManagementConstants.URL_USER_Service+ProjectManagementConstants.URL_USER_update+"/6").accept(MediaType.APPLICATION_JSON).content("6").contentType(MediaType.APPLICATION_JSON);
		MockHttpServletResponse response=this.mvc.perform(requestBuilder).andExpect(status().isOk()).andReturn().getResponse();
		verify(this.usersService, times(1)).getUser("6");
		assertEquals(this.userDto3Json,response.getContentAsString());
	}
	
	@Test
	public void testGetUserNegativeFlow() throws Exception{
	Mockito.when(this.usersService.getUser("10")).thenReturn(new UserDTO());
		
		MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders.get(ProjectManagementConstants.URL_USER_Service+ProjectManagementConstants.URL_USER_update+"/10").accept(MediaType.APPLICATION_JSON).content("10").contentType(MediaType.APPLICATION_JSON);
		MockHttpServletResponse response=this.mvc.perform(requestBuilder).andExpect(status().isOk()).andReturn().getResponse();
		verify(this.usersService, times(1)).getUser("10");
		assertEquals(this.userDto6EmptyJson,response.getContentAsString());
	}
	
	@Test(expected = NullPointerException.class)
	public void testGetUserExceptionFlow() throws Exception{
	Mockito.when(this.usersService.getUser("0")).thenThrow(NullPointerException.class);
		
		MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders.get(ProjectManagementConstants.URL_USER_Service+ProjectManagementConstants.URL_USER_update+"/0").accept(MediaType.APPLICATION_JSON).content("0").contentType(MediaType.APPLICATION_JSON);
		MockHttpServletResponse response=this.mvc.perform(requestBuilder).andExpect(status().isBadRequest()).andExpect(null).andReturn().getResponse();
		verify(this.usersService, times(1)).getUser("0");
		assertEquals(this.userDto6ErrorJson,response.getContentAsString());
	}

	@Test
	public void testDeleteUserPositiveFlow()  throws Exception{
	Mockito.when(this.usersService.deleteUser("6")).thenReturn(true);
		
		MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders.delete(ProjectManagementConstants.URL_USER_Service+ProjectManagementConstants.URL_USER_update+"/6").accept(MediaType.APPLICATION_JSON).content("6").contentType(MediaType.APPLICATION_JSON);
		MockHttpServletResponse response=this.mvc.perform(requestBuilder).andExpect(status().isOk()).andReturn().getResponse();
		verify(this.usersService, times(1)).deleteUser("6");
		assertEquals(this.deleteRecordJson,response.getContentAsString());
	
	}
	
	@Test
	public void testDeleteUserNegativeFlow()  throws Exception{
	Mockito.when(this.usersService.deleteUser("10")).thenReturn(false);
		
		MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders.delete(ProjectManagementConstants.URL_USER_Service+ProjectManagementConstants.URL_USER_update+"/10").accept(MediaType.APPLICATION_JSON).content("10").contentType(MediaType.APPLICATION_JSON);
		MockHttpServletResponse response=this.mvc.perform(requestBuilder).andExpect(status().isOk()).andReturn().getResponse();
		verify(this.usersService, times(1)).deleteUser("10");
		assertEquals(this.deleteNotRecordJson,response.getContentAsString());
	}
	
	@Test(expected = NullPointerException.class)
	public void testDeleteUserExceptionFlow()  throws Exception{
	Mockito.when(this.usersService.deleteUser("0")).thenThrow(NullPointerException.class);
		
		MockHttpServletRequestBuilder requestBuilder=MockMvcRequestBuilders.delete(ProjectManagementConstants.URL_USER_Service+ProjectManagementConstants.URL_USER_update+"/0").accept(MediaType.APPLICATION_JSON).content("0").contentType(MediaType.APPLICATION_JSON);
		MockHttpServletResponse response=this.mvc.perform(requestBuilder).andExpect(status().isBadRequest()).andExpect(null).andReturn().getResponse();
		verify(this.usersService, times(1)).deleteUser("0");
		assertEquals(this.deleteNotRecordJson,response.getContentAsString());
	}

}

package com.projectmanagement.app.service;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import com.projectmanagement.app.entity.ParentTaskVO;
import com.projectmanagement.app.entity.ProjectVO;
import com.projectmanagement.app.entity.TaskVO;
import com.projectmanagement.app.entity.UsersVO;
import com.projectmanagement.app.repositories.ProjectVORepository;
import com.projectmanagement.app.repositories.TaskVORepository;
import com.projectmanagement.app.repositories.UsersVORepository;
import com.projectmanagement.app.model.TaskDTO;
import com.projectmanagement.app.model.UserDTO;







/**
 * The Class UsersServiceImpl.
 */
@Service
public class UsersServiceImpl implements UsersService {

	/** The users VO repository. */
	@Autowired
	UsersVORepository usersVORepository;
	
	/** The project VO repository. */
	@Autowired
	ProjectVORepository projectVORepository;
	
	/** The task VO repository. */
	@Autowired
	TaskVORepository taskVORepository;
	
	/* (non-Javadoc)
	 * @see com.projectmanagement.app.service.UsersService#getAllUsers()
	 */
	@Override
	@Transactional
	public List<UserDTO> getAllUsers() throws Exception
	{
		
		List<UserDTO> allUsers=new ArrayList<>();
		
		List<UsersVO> userList= usersVORepository.findAll();
		 if(userList!=null && !userList.isEmpty())
		 {
			 userList.stream().forEach(usersVO->allUsers.add(mapUserDto(usersVO)));			
		 }
								
			return allUsers;
	}
	
	
	/* (non-Javadoc)
	 * @see com.projectmanagement.app.service.UsersService#searchUsers(java.util.List)
	 */
	@Override
	@Transactional
	public List<UserDTO> searchUsers(List<String> userNames) throws Exception
	{
		
		List<UserDTO> allUsers=new ArrayList<>();
		
		List<UsersVO> userList=usersVORepository.findByFirstNameIn(userNames);
		 if(userList!=null && !userList.isEmpty())
		 {
			 userList.stream().forEach(usersVO->allUsers.add(mapUserDto(usersVO)));			
		 }
		 
					
					
			return allUsers;
	}
	
	/* (non-Javadoc)
	 * @see com.projectmanagement.app.service.UsersService#getUser(java.lang.String)
	 */
	@Override
	@Transactional
	public UserDTO getUser(String userId) throws Exception {
	
		UserDTO userDTO=new UserDTO();

	if(userId!=null && !userId.isEmpty())
	{
		UsersVO	createUserVO=usersVORepository.findByUserId(Long.parseLong(userId));
		userDTO=mapUserDto(createUserVO);
	}
	return userDTO;
	
	}

	/* (non-Javadoc)
	 * @see com.projectmanagement.app.service.UsersService#deleteUser(java.lang.String)
	 */
	@Override
	@Transactional
	public boolean deleteUser(String userId) throws Exception {	
		boolean deleteFlag=false;
	
	
			UsersVO userVO=usersVORepository.findByUserId(Long.parseLong(userId));
			List<ProjectVO> projectsVO=projectVORepository.findByUsersVO(userVO);
			List<TaskVO> tasksVO=taskVORepository.findByUsersVO(userVO);
			if(!((projectsVO!=null && !projectsVO.isEmpty()) || (tasksVO!=null && !tasksVO.isEmpty())))
			{
			usersVORepository.deleteByUserId(Long.parseLong(userId));	
			deleteFlag=true;
			}
		
	
		return deleteFlag;
}
	
	/* (non-Javadoc)
	 * @see com.projectmanagement.app.service.UsersService#save(com.projectmanagement.app.model.UserDTO)
	 */
	@Override
	@Transactional
	public long save(UserDTO userDTO) throws Exception {
	
	long userId=0L;
	
	UsersVO createUserVO=mapUserVo(userDTO);
	UsersVO usersVO=usersVORepository.save(createUserVO);
	
	if(usersVO!=null && usersVO.getUserId()>0L)
		userId=usersVO.getUserId();
	return userId;
	}

	/**
	 * Map user vo.
	 *
	 * @param userDTO the user DTO
	 * @return the users VO
	 */
	private UsersVO mapUserVo(UserDTO userDTO)
	{
		UsersVO usersVO=new UsersVO();
		
		usersVO.setFirstName(userDTO.getFirstName());
		usersVO.setLastName(userDTO.getLastName());
		usersVO.setEmployeeId(Integer.parseInt(userDTO.getEmployeeId()));
		if(userDTO.getUserId()!=null && !userDTO.getUserId().isEmpty())
			usersVO.setUserId(Long.parseLong(userDTO.getUserId()));
		
		
		return usersVO;
	}
	
	/**
	 * Map user dto.
	 *
	 * @param usersVO the users VO
	 * @return the user DTO
	 */
	private UserDTO mapUserDto(UsersVO usersVO)
	{
		UserDTO userDTO=new UserDTO();
		if(usersVO!=null && usersVO.getUserId()>0L)
		{
		userDTO.setUserId(String.valueOf(usersVO.getUserId()));
		userDTO.setFirstName(usersVO.getFirstName());
		userDTO.setLastName(usersVO.getLastName());
		userDTO.setEmployeeId(String.valueOf(usersVO.getEmployeeId()));
		}
	
		return userDTO;
	}
}

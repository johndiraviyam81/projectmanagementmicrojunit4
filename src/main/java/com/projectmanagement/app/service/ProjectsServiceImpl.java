package com.projectmanagement.app.service;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import com.projectmanagement.app.entity.ProjectVO;
import com.projectmanagement.app.entity.TaskVO;
import com.projectmanagement.app.entity.UsersVO;
import com.projectmanagement.app.repositories.ParentTaskVORepository;
import com.projectmanagement.app.repositories.ProjectVORepository;
import com.projectmanagement.app.repositories.TaskVORepository;
import com.projectmanagement.app.repositories.UsersVORepository;
import com.projectmanagement.app.model.ProjectDTO;







/**
 * The Class ProjectsServiceImpl.
 */
@Service
public class ProjectsServiceImpl implements ProjectsService {

	/** The project VO repository. */
	@Autowired
	ProjectVORepository projectVORepository;
	
	
	/** The parent task VO repository. */
	@Autowired
	ParentTaskVORepository parentTaskVORepository;
	
	/** The users VO repository. */
	@Autowired
	UsersVORepository usersVORepository;
	
	/** The task VO repository. */
	@Autowired
	TaskVORepository taskVORepository;
	
	/* (non-Javadoc)
	 * @see com.projectmanagement.app.service.ProjectsService#getProjectById(long)
	 */
	@Override
	@Transactional
	public ProjectDTO  getProjectById(long projectId)  throws Exception
	{
		
		ProjectDTO getProjectDTO=new ProjectDTO();
		
		ProjectVO projectVo1 =projectVORepository.findByProjectId(projectId);
		
		 if(projectVo1!=null && projectVo1.getProjectId()!=0L)
		 {
			 getProjectDTO=mapProjectDto(projectVo1);	
			
		 }
		 					
			return getProjectDTO;
	}

	/* (non-Javadoc)
	 * @see com.projectmanagement.app.service.ProjectsService#deleteProjectById(long)
	 */
	@Override
	@Transactional
	public boolean deleteProjectById(long projectId) throws Exception
	{
		boolean deleteFlag=false;
		ProjectVO deleteProjectVO=projectVORepository.findByProjectId(projectId);
		if(deleteProjectVO!=null && !deleteProjectVO.getProject().isEmpty())
		{
		List<TaskVO> deleteTaskList=taskVORepository.findByProjectVO(deleteProjectVO);	
			if(deleteTaskList!=null && !deleteTaskList.isEmpty()) {
			deleteTaskList.stream().forEach(taskvo->{
				parentTaskVORepository.deleteByParentTask(taskvo);
				taskVORepository.deleteByTaskId(taskvo.getTaskId()); 			
			});
		}
		
		projectVORepository.deleteByProjectId(projectId);
		deleteFlag=true;
		}
				
		return deleteFlag;
	}
	
	/* (non-Javadoc)
	 * @see com.projectmanagement.app.service.ProjectsService#getAllProjects()
	 */
	@Override
	@Transactional
	public List<ProjectDTO> getAllProjects()  throws Exception
	{
		
		List<ProjectDTO> allProjects=new ArrayList<>();
		
		List<ProjectVO> projectList=projectVORepository.findAll();
		
			 if(projectList!=null && !projectList.isEmpty())
			 {
				 projectList.stream().forEach(projectVO->allProjects.add(mapProjectDto(projectVO)));
			 }	
					
					
			return allProjects;
	}


	/* (non-Javadoc)
	 * @see com.projectmanagement.app.service.ProjectsService#searchProjects(java.lang.String)
	 */
	@Override
	@Transactional
	public List<ProjectDTO> searchProjects(String projectContain) throws Exception
	{
		
		List<ProjectDTO> allProjects=new ArrayList<>();
		
		
			String containsProjectName=projectContain;
			List<ProjectVO> projectList= projectVORepository.findByProjectContaining(containsProjectName);
			 if(projectList!=null && !projectList.isEmpty())
			 {
				 projectList.stream().forEach(projectVO->allProjects.add(mapProjectDto(projectVO)));
			 } 
								
			return allProjects;
	}
	

	/* (non-Javadoc)
	 * @see com.projectmanagement.app.service.ProjectsService#save(com.projectmanagement.app.model.ProjectDTO)
	 */
	@Override
	@Transactional
	public long save(ProjectDTO projectDTO) throws Exception {
	
	long projectId=0L;
	
	ProjectVO projectVO=projectVORepository.save(mapProjectVo(projectDTO));
	if(projectVO!=null && projectVO.getProjectId()>0L)
		projectId=projectVO.getProjectId();
	return projectId;
	}

	/**
	 * Map project vo.
	 *
	 * @param projectDTO the project DTO
	 * @return the project VO
	 */
	private ProjectVO mapProjectVo(ProjectDTO projectDTO)  throws Exception
	{
		ProjectVO projectVo=new ProjectVO();
		
		projectVo.setProject(projectDTO.getProjectName());
		if(projectDTO.getProjectId()!=null && !projectDTO.getProjectId().isEmpty())
		{ projectVo.setProjectId(Long.parseLong(projectDTO.getProjectId())); }
		
		if(projectDTO.getStartDate()!=null)
		{	projectVo.setStartDate(LocalDate.parse(projectDTO.getStartDate())); }
		if(projectDTO.getEndDate()!=null)
		{ projectVo.setEndDate(LocalDate.parse(projectDTO.getEndDate())); }
		projectVo.setPriority(Integer.parseInt(projectDTO.getPriority()));
		if(projectDTO.getUserId()!=null && !projectDTO.getUserId().isEmpty())
		{
		UsersVO userVoDt=usersVORepository.findByUserId(Long.parseLong(projectDTO.getUserId()));
		projectVo.setUsersVO(userVoDt);
		}
		return projectVo;
	}
	
	/**
	 * Map project dto.
	 *
	 * @param projectVO the project VO
	 * @return the project DTO
	 */
	private ProjectDTO mapProjectDto(ProjectVO projectVO)
	{
		ProjectDTO projectDTO=new ProjectDTO();
		LocalDate today=LocalDate.now();
		
		projectDTO.setProjectId(String.valueOf(projectVO.getProjectId()));
		projectDTO.setProjectName(projectVO.getProject());
		if(projectVO.getStartDate()!=null)
		{ projectDTO.setStartDate(String.valueOf(projectVO.getStartDate())); }
		
		if(projectVO.getEndDate()!=null)
		{
		projectDTO.setEndDate(String.valueOf(projectVO.getEndDate()));		
		}
		projectDTO.setPriority(String.valueOf(projectVO.getPriority()));
		if(projectVO.getUsersVO()!=null && projectVO.getUsersVO().getUserId()>0)
		{ 
		projectDTO.setUserId(String.valueOf(projectVO.getUsersVO().getUserId()));
		projectDTO.setUserName(projectVO.getUsersVO().getFirstName());
		}
		List<TaskVO> TaskList=taskVORepository.findByProjectVO(projectVO);
		if(!TaskList.isEmpty())
		{ projectDTO.setNoOfTasks(String.valueOf(TaskList.size())); }
		
		return projectDTO;
	}
}

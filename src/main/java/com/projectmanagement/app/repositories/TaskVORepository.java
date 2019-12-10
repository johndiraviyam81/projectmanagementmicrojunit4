/*
 * 
 */
package com.projectmanagement.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.annotation.QueryAnnotation;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.projectmanagement.app.entity.ProjectVO;
import com.projectmanagement.app.entity.TaskVO;
import com.projectmanagement.app.entity.UsersVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface TaskVORepository.
 */
@Transactional
@Repository("taskVOVORepository")
public interface TaskVORepository extends JpaRepository<TaskVO, Integer>{

	/**
	 * Find by task id.
	 *
	 * @param taskId the task id
	 * @return the task VO
	 */
	TaskVO findByTaskId(long taskId);
	
	/**
	 * Find by findByProjectVOContaining.
	 *
	 * @param projectName the prject name
	 * @return the list
	 */
	
	
	
	/**
	 * Find by project VO.
	 *
	 * @param projectVO the project VO
	 * @return the list
	 */
	List<TaskVO> findByProjectVO(ProjectVO projectVO);
	
	/**
	 * Find by users VO.
	 *
	 * @param usersVO the users VO
	 * @return the list
	 */
	List<TaskVO> findByUsersVO(UsersVO usersVO);
	
	/**
	 * Delete by task id.
	 *
	 * @param taskId the task id
	 */
	void deleteByTaskId(long taskId);
	
	
}

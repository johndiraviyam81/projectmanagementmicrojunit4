/*
 * 
 */
package com.projectmanagement.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.projectmanagement.app.entity.ParentTaskVO;
import com.projectmanagement.app.entity.TaskVO;


// TODO: Auto-generated Javadoc
/**
 * The Interface ParentTaskVORepository.
 */
@Transactional
@Repository("parentTaskVORepository")
public interface ParentTaskVORepository extends JpaRepository<ParentTaskVO, Integer>{

	/**
	 * Find by parent id.
	 *
	 * @param parentId the parent id
	 * @return the parent task VO
	 */
	ParentTaskVO findByParentId(long parentId);
	
	/**
	 * Find by parent task.
	 *
	 * @param parentTaskVO the parent task VO
	 * @return the parent task VO
	 */
	ParentTaskVO findByParentTask(TaskVO parentTaskVO);
	
	/**
	 * Delete by parent task.
	 *
	 * @param parentTaskVO the parent task VO
	 */
	void deleteByParentTask(TaskVO parentTaskVO);
	
	/**
	 * Delete in branch by parent task.
	 *
	 * @param taskList the task list
	 */
	void deleteInBranchByParentTask(List<TaskVO> taskList);
		
	
	
}

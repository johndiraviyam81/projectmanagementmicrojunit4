/*
 * 
 */
package com.projectmanagement.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.projectmanagement.app.entity.ProjectVO;
import com.projectmanagement.app.entity.TaskVO;
import com.projectmanagement.app.entity.UsersVO;

// TODO: Auto-generated Javadoc
/**
 * The Interface UsersVORepository.
 */
@Transactional
@Repository("usersVORepository")
public interface UsersVORepository extends JpaRepository<UsersVO, Integer>{

	/**
	 * Find by user id.
	 *
	 * @param userId the user id
	 * @return the users VO
	 */
	UsersVO findByUserId(long userId);

	/**
	 * Find by first name in.
	 *
	 * @param userNames the user names
	 * @return the list
	 */
	List<UsersVO> findByFirstNameIn(List<String> userNames);
	
	/**
	 * Delete by user id.
	 *
	 * @param userId the user id
	 */
	void deleteByUserId(long userId);
	
	
	

		
}

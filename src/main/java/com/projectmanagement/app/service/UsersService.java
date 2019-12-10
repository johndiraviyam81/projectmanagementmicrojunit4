package com.projectmanagement.app.service;

import java.sql.SQLException;
import java.util.List;

import com.projectmanagement.app.entity.UsersVO;
import com.projectmanagement.app.model.UserDTO;





// TODO: Auto-generated Javadoc
/**
 * The Interface UsersService.
 */
public interface UsersService 
{
	
	/**
	 * Save.
	 *
	 * @param userdto the userdto
	 * @return the long
	 * @throws Exception the exception
	 */
	public long save(UserDTO userdto) throws Exception;
	
	/**
	 * Gets the user.
	 *
	 * @param userId the user id
	 * @return the user
	 * @throws Exception the exception
	 */
	public UserDTO getUser(String userId) throws Exception;
	
	/**
	 * Delete user.
	 *
	 * @param userId the user id
	 * @return true, if successful
	 * @throws SQLException the SQL exception
	 */
	public boolean deleteUser(String userId) throws Exception;

	/**
	 * Gets the all users.
	 *
	 * @return the all users
	 */
	public List<UserDTO> getAllUsers() throws Exception;
	
	/**
	 * Search users.
	 *
	 * @param userNames the user names
	 * @return the list
	 * @throws Exception the exception
	 */
	public List<UserDTO> searchUsers(List<String> userNames) throws Exception;


}

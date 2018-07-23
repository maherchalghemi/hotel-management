package Service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import Model.Users;
import DAO.IUsersDAO;

/**
 * 
 * Users Service
 * 
 *
 */
@Transactional(readOnly = true)
public class UsersService implements IUsersService {

	// UsersDAO is injected...
	IUsersDAO usersDAO;
	
	/**
	 * Add Users
	 * 
	 * @param  Users Users
	 */
	@Transactional(readOnly = false)
	
	public void addUsers(Users users) {
		getUsersDAO().addUsers(users);
	}

	/**
	 * Delete Users
	 * 
	 * @param  Users Users
	 */
	@Transactional(readOnly = false)
	
	public void deleteUsers(Users users) {
		getUsersDAO().deleteUsers(users);
	}
	
	/**
	 * Update Users
	 * 
	 * @param  Users Users
	 */
	@Transactional(readOnly = false)

	public void updateUsers(Users users) {
		getUsersDAO().updateUsers(users);
	}
	
	/**
	 * Get Users
	 * 
	 * @param  int Users Id
	 */
	
	public Users getUsersById(int id) {
		return getUsersDAO().getUsersById(id);
	}
	/**
	 * Get Users
	 * @param login Strind
	 
	 */
	
	public Users getUsersByLogin(String login){
		return getUsersDAO().getUsersByLogin(login);
	}

	/**
	 * Get Users List
	 * 
	 */
	
	public List<Users> getUsers() {	
		return getUsersDAO().getUsers();
	}

	/**
	 * Get Users DAO
	 * 
	 * @return IUsersDAO - Users DAO
	 */
	public IUsersDAO getUsersDAO() {
		return usersDAO;
	}

	/**
	 * Set Users DAO
	 * 
	 * @param IUsersDAO - Users DAO
	 */
	public void setUsersDAO(IUsersDAO usersDAO) {
		this.usersDAO = usersDAO;
	}
        
        

}

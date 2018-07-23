package Service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import Model.RoleUsers;
import DAO.IRoleUsersDAO;

/**
 * 
 * RoleUsers Service
 * 
 *
 */
@Transactional(readOnly = true)
public class RoleUsersService implements IRoleUsersService {

	// RoleUsersDAO is injected...
	IRoleUsersDAO roleUsersDAO;
	
	/**
	 * Add RoleUsers
	 * 
	 * @param  RoleUsers RoleUsers
	 */
	@Transactional(readOnly = false)
	
	public void addRoleUsers(RoleUsers roleUsers) {
		getRoleUsersDAO().addRoleUsers(roleUsers);
	}

	/**
	 * Delete RoleUsers
	 * 
	 * @param  RoleUsers RoleUsers
	 */
	@Transactional(readOnly = false)
	
	public void deleteRoleUsers(RoleUsers roleUsers) {
		getRoleUsersDAO().deleteRoleUsers(roleUsers);
	}
	
	/**
	 * Update RoleUsers
	 * 
	 * @param  RoleUsers RoleUsers
	 */
	@Transactional(readOnly = false)

	public void updateRoleUsers(RoleUsers roleUsers) {
		getRoleUsersDAO().updateRoleUsers(roleUsers);
	}
	
	/**
	 * Get RoleUsers
	 * 
	 * @param  int RoleUsers Id
	 */
	
	public RoleUsers getRoleUsersById(int id) {
		return getRoleUsersDAO().getRoleUsersById(id);
	}

	/**
	 * Get RoleUsers List
	 * 
	 */
	
	public List<RoleUsers> getRoleUsers() {	
		return getRoleUsersDAO().getRoleUsers();
	}

	/**
	 * Get RoleUsers DAO
	 * 
	 * @return IRoleUsersDAO - RoleUsers DAO
	 */
	public IRoleUsersDAO getRoleUsersDAO() {
		return roleUsersDAO;
	}

	/**
	 * Set RoleUsers DAO
	 * 
	 * @param IRoleUsersDAO - RoleUsers DAO
	 */
	public void setRoleUsersDAO(IRoleUsersDAO roleUsersDAO) {
		this.roleUsersDAO = roleUsersDAO;
	}
        
        

}

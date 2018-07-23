package Service;

import java.util.List;
import Model.RoleUsers;


public interface IRoleUsersService {

	public void addRoleUsers(RoleUsers roleUsers);
	
	public void deleteRoleUsers(RoleUsers roleUsers);

	public void updateRoleUsers(RoleUsers roleUsers);

	
	public RoleUsers getRoleUsersById(int id);

	
	public List<RoleUsers> getRoleUsers();


}

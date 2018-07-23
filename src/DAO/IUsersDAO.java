package DAO;

import java.util.List;

import Model.Users;

public interface IUsersDAO {

	public void addUsers(Users users);
	public void deleteUsers(Users users);
	public void updateUsers(Users users);
	public Users getUsersById(int id);
	public Users getUsersByLogin(String login);
	public List<Users> getUsers();
}

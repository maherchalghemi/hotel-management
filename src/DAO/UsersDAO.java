package DAO;

import java.util.List;

import org.hibernate.SessionFactory;

import Model.Users;

public class UsersDAO implements IUsersDAO {

	private SessionFactory sessionFactory;

	/**
	 * Get Hibernate Session Factory
	 * 
	 * @return SessionFactory - Hibernate Session Factory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * Set Hibernate Session Factory
	 * 
	 * @param SessionFactory - Hibernate Session Factory
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

	/**
	 * Add Users
	 * 
	 * @param  Users Users
	 */
	public void addUsers(Users users) {
		getSessionFactory().getCurrentSession().save(users);
	}

	/**
	 * Delete Users
	 * 
	 * @param  Users Users
	 */
	public void deleteUsers(Users users) {
		getSessionFactory().getCurrentSession().delete(users);
	}

	/**
	 * Update Users
	 * 
	 * @param  Users Users
	 */
	
	public void updateUsers(Users users) {
		getSessionFactory().getCurrentSession().update(users);
	}

	/**
	 * Get Categorie
	 * 
	 * @param  int Users Id
	 * @return Users 
	 */
	
	public Users getUsersById(int id) {
		List list = getSessionFactory().getCurrentSession()
											.createQuery("from Users where idU=?")
									        .setParameter(0, id).list();
		return (Users)list.get(0);
	}
	
	
	/**
	 * Get Users
	 * 
	 * @param  String login
	 * @return Users 
	 */
	
	public Users getUsersByLogin(String login) {
		List list = getSessionFactory().getCurrentSession()
											.createQuery("from Users where login=?")
									        .setParameter(0, login).list();
		return (Users)list.get(0);
	}

	/**
	 * Get Users List
	 * 
	 * @return List - Users list
	 */
	
	public List<Users> getUsers() {
		List list = getSessionFactory().getCurrentSession().createQuery("from Users").list();
		return list;
	}
}

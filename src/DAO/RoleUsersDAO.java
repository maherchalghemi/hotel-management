package DAO;

import java.util.List;

import org.hibernate.SessionFactory;

import Model.RoleUsers;

public class RoleUsersDAO implements IRoleUsersDAO {

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
	 * Add RoleUsers
	 * 
	 * @param  RoleUsers RoleUsers
	 */
	public void addRoleUsers(RoleUsers roleUsers) {
		getSessionFactory().getCurrentSession().save(roleUsers);
	}

	/**
	 * Delete RoleUsers
	 * 
	 * @param  RoleUsers RoleUsers
	 */
	public void deleteRoleUsers(RoleUsers roleUsers) {
		getSessionFactory().getCurrentSession().delete(roleUsers);
	}

	/**
	 * Update RoleUsers
	 * 
	 * @param  RoleUsers RoleUsers
	 */
	
	public void updateRoleUsers(RoleUsers roleUsers) {
		getSessionFactory().getCurrentSession().update(roleUsers);
	}

	/**
	 * Get Categorie
	 * 
	 * @param  int RoleUsers Id
	 * @return RoleUsers 
	 */
	
	public RoleUsers getRoleUsersById(int id) {
		List list = getSessionFactory().getCurrentSession()
											.createQuery("from RoleUsers where idRoleUsers=?")
									        .setParameter(0, id).list();
		return (RoleUsers)list.get(0);
	}

	/**
	 * Get RoleUsers List
	 * 
	 * @return List - RoleUsers list
	 */
	
	public List<RoleUsers> getRoleUsers() {
		List list = getSessionFactory().getCurrentSession().createQuery("from RoleUsers").list();
		return list;
	}
}

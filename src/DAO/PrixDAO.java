package DAO;

import java.util.List;

import org.hibernate.SessionFactory;

import Model.Prix;

public class PrixDAO implements IPrixDAO {

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
	 * Add Prix
	 * 
	 * @param  Prix Prix
	 */
	public void addPrix(Prix prix) {
		getSessionFactory().getCurrentSession().save(prix);
	}

	/**
	 * Delete Prix
	 * 
	 * @param  Prix Prix
	 */
	public void deletePrix(Prix prix) {
		getSessionFactory().getCurrentSession().delete(prix);
	}

	/**
	 * Update Prix
	 * 
	 * @param  Prix Prix
	 */
	
	public void updatePrix(Prix prix) {
		getSessionFactory().getCurrentSession().update(prix);
	}

	/**
	 * Get Categorie
	 * 
	 * @param  int Prix Id
	 * @return Prix 
	 */
	
	public Prix getPrixById(int id) {
		List list = getSessionFactory().getCurrentSession()
											.createQuery("from Prix where idprix=?")
									        .setParameter(0, id).list();
		return (Prix)list.get(0);
	}
	
	

	
	
	
	

	
	
	public List<Prix> getPrix() {
		List list = getSessionFactory().getCurrentSession().createQuery("from Prix").list();
		return list;
	}
}

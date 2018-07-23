package DAO;

import java.util.List;

import org.hibernate.SessionFactory;

import Model.Saison;

public class SaisonDAO implements ISaisonDAO {

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
	 * Add Saison
	 * 
	 * @param  Saison Saison
	 */
	public void addSaison(Saison saison) {
		getSessionFactory().getCurrentSession().save(saison);
	}

	/**
	 * Delete Saison
	 * 
	 * @param  Saison Saison
	 */
	public void deleteSaison(Saison saison) {
		getSessionFactory().getCurrentSession().delete(saison);
	}

	/**
	 * Update Saison
	 * 
	 * @param  Saison Saison
	 */
	
	public void updateSaison(Saison saison) {
		getSessionFactory().getCurrentSession().update(saison);
	}

	/**
	 * Get Categorie
	 * 
	 * @param  int Saison Id
	 * @return Saison 
	 */
	
	public Saison getSaisonById(int id) {
		List list = getSessionFactory().getCurrentSession()
											.createQuery("from Saison where idsaison=?")
									        .setParameter(0, id).list();
		return (Saison)list.get(0);
	}
	
	

	
	
	
	

	
	
	public List<Saison> getSaison() {
		List list = getSessionFactory().getCurrentSession().createQuery("from Saison").list();
		return list;
	}
}

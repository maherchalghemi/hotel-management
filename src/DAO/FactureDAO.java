package DAO;

import java.util.List;

import org.hibernate.SessionFactory;

import Model.Facture;

public class FactureDAO implements IFactureDAO {

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
	 * Add Facture
	 * 
	 * @param  Facture Facture
	 */
	public void addFacture(Facture facture) {
		getSessionFactory().getCurrentSession().save(facture);
	}

	/**
	 * Delete Facture
	 * 
	 * @param  Facture Facture
	 */
	public void deleteFacture(Facture facture) {
		getSessionFactory().getCurrentSession().delete(facture);
	}

	/**
	 * Update Facture
	 * 
	 * @param  Facture facture
	 */
	
	public void updateFacture(Facture facture) {
		getSessionFactory().getCurrentSession().update(facture);
	}

	/**
	 * Get Categorie
	 * 
	 * @param  int Facture Id
	 * @return Facture 
	 */
	
	public Facture getFactureById(int id) {
		List list = getSessionFactory().getCurrentSession()
											.createQuery("from Facture where idfacture=?")
									        .setParameter(0, id).list();
		return (Facture)list.get(0);
	}

	/**
	 * Get Facture List
	 * 
	 * @return List - Facture list
	 */
	
	public List<Facture> getFacture() {
		List list = getSessionFactory().getCurrentSession().createQuery("from Facture").list();
		return list;
	}
}

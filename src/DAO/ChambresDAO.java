package DAO;

import java.util.List;

import org.hibernate.SessionFactory;

import Model.Chambres;;

public class ChambresDAO implements IChambresDAO{

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
	 * Add Chambres
	 * 
	 * @param  Chambres Chambres
	 */
	@Override
	public void addChambres(Chambres chambres) {
		getSessionFactory().getCurrentSession().save(chambres);
	}

	/**
	 * Delete Chambres
	 * 
	 * @param  Chambres Chambres
	 */
	@Override
	public void deleteChambres(Chambres chambres) {
		getSessionFactory().getCurrentSession().delete(chambres);
	}

	/**
	 * Update Chambres
	 * 
	 * @param  Chambres Chambres
	 */
	@Override
	public void updateChambres(Chambres chambres) {
		getSessionFactory().getCurrentSession().update(chambres);
	}

	/**
	 * Get Chambres
	 * 
	 * @param  int Chambres Id
	 * @return Chambres 
	 */
	@Override
	public Chambres getChambresById(int id) {
		List list = getSessionFactory().getCurrentSession()
											.createQuery("from Chambres where idchambres=?")
									        .setParameter(0, id).list();
		return (Chambres)list.get(0);
	}
	public List<Chambres> getChambresByIdHotel(int id) {
		List list = getSessionFactory().getCurrentSession()
											.createQuery("from Chambres where idhotel=?")
									        .setParameter(0, id).list();
		return list;
	}

	/**
	 * Get Chambres List
	 * 
	 * @return List - Chambres list
	 */
	@Override
	public List<Chambres> getChambres() {
		List list = getSessionFactory().getCurrentSession().createQuery("from Chambres").list();
		return list;
	}
	
        
        /**
	 * Get Chambres List
	 * 
	 * @return List - Chambres list dispo 1
	 */
	@Override
	public List<Chambres> getChambresDispo() {
           
		List list = getSessionFactory().getCurrentSession().createQuery("from Chambres where dispo = 1").list();
		return list;
	}
}

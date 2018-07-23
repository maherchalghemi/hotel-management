package DAO;

import java.util.List;

import org.hibernate.SessionFactory;

import Model.Reservation;

public class ReservationDAO implements IReservationDAO {

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
	 * Add Reservation
	 * 
	 * @param  Reservation Reservation
	 */
	public void addReservation(Reservation reservation) {
		getSessionFactory().getCurrentSession().save(reservation);
	}

	/**
	 * Delete Reservation
	 * 
	 * @param  Reservation Reservation
	 */
	public void deleteReservation(Reservation reservation) {
		getSessionFactory().getCurrentSession().delete(reservation);
	}

	/**
	 * Update Reservation
	 * 
	 * @param  Reservation Reservation
	 */
	
	public void updateReservation(Reservation reservation) {
		getSessionFactory().getCurrentSession().update(reservation);
	}

	/**
	 * Get Categorie
	 * 
	 * @param  int Reservation Id
	 * @return Reservation 
	 */
	
	public Reservation getReservationById(int id) {
		List list = getSessionFactory().getCurrentSession()
											.createQuery("from Reservation where idreserv=?")
									        .setParameter(0, id).list();
		return (Reservation)list.get(0);
	}

	/**
	 * Get Reservation List
	 * 
	 * @return List - Reservation list
	 */
	
	public List<Reservation> getReservation() {
		List list = getSessionFactory().getCurrentSession().createQuery("from Reservation").list();
		return list;
	}
}

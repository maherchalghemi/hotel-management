package DAO;

import java.util.List;

import org.hibernate.SessionFactory;

import Model.Hotel;

public class HotelDAO implements IHotelDAO{
	
	
	
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
	 * Add Hotel
	 * 
	 * @param  Hotel hotel
	 */
	public void addHotel(Hotel hotel) {
		getSessionFactory().getCurrentSession().save(hotel);
	}

	/**
	 * Delete Hotel
	 * 
	 * @param  Hotel hotel
	 */
	public void deleteHotel(Hotel hotel) {
		getSessionFactory().getCurrentSession().delete(hotel);
	}

	/**
	 * Update Hotel
	 * 
	 * @param  Hotel hotel
	 */
	
	public void updateHotel(Hotel hotel) {
		getSessionFactory().getCurrentSession().update(hotel);
	}

	/**
	 * Get Hotel
	 * 
	 * @param  int Hotel Id
	 * @return Hotel 
	 */
	
	public Hotel getHotelById(int id) {
		List list = getSessionFactory().getCurrentSession()
											.createQuery("from Hotel where idhotel=?")
									        .setParameter(0, id).list();
		return (Hotel)list.get(0);
	}

	/**
	 * Get Hotel List
	 * 
	 * @return List - Hotel list
	 */
	
	public List<Hotel> getHotel() {
		List list = getSessionFactory().getCurrentSession().createQuery("from Hotel").list();
		return list;
	}
        
        /**
	 * Get HotelOffre List
	 * 
	 * @return List - Hotel list
	 */
	
	public List<Hotel> getHotelOffre() {
           
		List list = getSessionFactory().getCurrentSession().createQuery("from Hotel where offre = 1").list();
		return list;
	}

}

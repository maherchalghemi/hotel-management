package Service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import Model.Reservation;
import DAO.IReservationDAO;

/**
 * 
 * Reservation Service
 * 
 *
 */
@Transactional(readOnly = true)
public class ReservationService implements IReservationService {

	// ReservationDAO is injected...
	IReservationDAO reservationDAO;
	
	/**
	 * Add Reservation
	 * 
	 * @param  Reservation Reservation
	 */
	@Transactional(readOnly = false)
	
	public void addReservation(Reservation reservation) {
		getReservationDAO().addReservation(reservation);
	}

	/**
	 * Delete Reservation
	 * 
	 * @param  Reservation Reservation
	 */
	@Transactional(readOnly = false)
	
	public void deleteReservation(Reservation reservation) {
		getReservationDAO().deleteReservation(reservation);
	}
	
	/**
	 * Update Reservation
	 * 
	 * @param  Reservation Reservation
	 */
	@Transactional(readOnly = false)

	public void updateReservation(Reservation reservation) {
		getReservationDAO().updateReservation(reservation);
	}
	
	/**
	 * Get Reservation
	 * 
	 * @param  int Reservation Id
	 */
	
	public Reservation getReservationById(int id) {
		return getReservationDAO().getReservationById(id);
	}

	/**
	 * Get Reservation List
	 * 
	 */
	
	public List<Reservation> getReservation() {	
		return getReservationDAO().getReservation();
	}

	/**
	 * Get Reservation DAO
	 * 
	 * @return IReservationDAO - Reservation DAO
	 */
	public IReservationDAO getReservationDAO() {
		return reservationDAO;
	}

	/**
	 * Set Reservation DAO
	 * 
	 * @param IReservationDAO - Reservation DAO
	 */
	public void setReservationDAO(IReservationDAO reservationDAO) {
		this.reservationDAO = reservationDAO;
	}
        
        

}

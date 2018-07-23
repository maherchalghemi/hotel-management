package Service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import Model.Hotel;
import DAO.IHotelDAO;

/**
 * 
 * Hotel Service
 * 
 *
 */
@Transactional(readOnly = true)
public class HotelService implements IHotelService {

	// HotelDAO is injected...
	IHotelDAO hotelDAO;
	
	/**
	 * Add Hotel
	 * 
	 * @param  Hotel Hotel
	 */
	@Transactional(readOnly = false)
	
	public void addHotel(Hotel hotel) {
		getHotelDAO().addHotel(hotel);
	}

	/**
	 * Delete Hotel
	 * 
	 * @param  Hotel Hotel
	 */
	@Transactional(readOnly = false)
	
	public void deleteHotel(Hotel hotel) {
		getHotelDAO().deleteHotel(hotel);
	}
	
	/**
	 * Update Hotel
	 * 
	 * @param  Hotel Hotel
	 */
	@Transactional(readOnly = false)

	public void updateHotel(Hotel hotel) {
		getHotelDAO().updateHotel(hotel);
	}
	
	/**
	 * Get Hotel
	 * 
	 * @param  int Hotel Id
	 */
	
	public Hotel getHotelById(int id) {
		return getHotelDAO().getHotelById(id);
	}

	/**
	 * Get Hotel List
	 * 
	 */
	
	public List<Hotel> getHotel() {	
		return getHotelDAO().getHotel();
	}

	/**
	 * Get Hotel DAO
	 * 
	 * @return IHotelDAO - Hotel DAO
	 */
	
	
	public List<Hotel> getHotelOffre() {
        
		return getHotelDAO().getHotelOffre();
		}
	
	
	public IHotelDAO getHotelDAO() {
		return hotelDAO;
	}

	/**
	 * Set Hotel DAO
	 * 
	 * @param IHotelDAO - Hotel DAO
	 */
	public void setHotelDAO(IHotelDAO hotelDAO) {
		this.hotelDAO = hotelDAO;
	}
        
        

}

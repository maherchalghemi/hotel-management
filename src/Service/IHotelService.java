package Service;

import java.util.List;
import Model.Hotel;


public interface IHotelService {

	public void addHotel(Hotel hotel);
	
	public void deleteHotel(Hotel hotel);

	public void updateHotel(Hotel hotel);

	
	public Hotel getHotelById(int id);

	
	public List<Hotel> getHotel();
	public List<Hotel> getHotelOffre();


}

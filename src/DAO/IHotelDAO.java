package DAO;


import java.util.List;

import Model.Hotel;




public interface IHotelDAO {
	
	public void addHotel(Hotel hotel);
	public void deleteHotel(Hotel hotel);
	public void updateHotel(Hotel hotel);
	public Hotel getHotelById(int id);
	public List<Hotel> getHotel();
	public List<Hotel> getHotelOffre();

}

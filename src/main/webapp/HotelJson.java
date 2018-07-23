package main.webapp;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedProperty;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;

import DAO.IHotelDAO;
import Model.Hotel;
import Service.HotelService;
import Service.IHotelService;




@Path("/hotel")
public class HotelJson {
	@Autowired 
	IHotelService hotelservice;
	
	ArrayList<Hotel> hotelList = new ArrayList<Hotel>();

	
	
	@GET
	@Path(value="/list")
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public List<Hotel> getHotelList() {
		
    	List<Hotel> list= new ArrayList<>();
    	list = new ArrayList<Hotel>();
       list.addAll(hotelservice.getHotel());
        //list.add("a");
        //list.add("ville");
        //list.add("c");
               return list;
    }
	
	
    
    
    
    
   
   

}
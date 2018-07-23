package Bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import org.springframework.dao.DataAccessException;
import Model.Hotel;
import Service.IHotelService;
import java.text.ParseException;


import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * Hotel Managed Bean
 *
 *
 */
@ManagedBean(name ="hotelMB")
@SessionScoped
public class HotelManagedBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final String SUCCESS = "success";
    private static final String ERROR = "error";

    //Spring Hotel Service is injected...
    @ManagedProperty(value = "#{HotelService}")
    IHotelService hotelService;

    List<Hotel> hotelList = new ArrayList<Hotel>();
    List<Hotel> hotelOffreList;

    private int id;
    
    private Hotel hotel;
    private Hotel selectedHotel;

    public HotelManagedBean() {
    	hotel=new Hotel();
    	selectedHotel=new Hotel();
    }

    /**
     * Add Hotel
     *
     * @return String - Response Message
     */
    public String addHotel() throws ParseException {
        try {
            
            hotel.setOffre(0);
            hotel.setNbreserv(0);
            hotel.setNbchambre(0);
           
            getHotelService().addHotel(hotel);
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Ajout hotel avec succes", ""));
            return SUCCESS;
        } catch (DataAccessException e) {
            e.printStackTrace();
        }

        return ERROR;
    }

    /**
     * Update Hotel
     *
     * @return String - Response Message
     */
    public String updHotel() {
        try {
            getHotelService().updateHotel(selectedHotel);
            return SUCCESS;
        } catch (DataAccessException e) {
            e.printStackTrace();
        }

        return ERROR;
    }

    /**
     * Delete Hotel
     *
     * @return String - Response Message
     */
    public String deleteHotel() {
        try {
            getHotelService().deleteHotel(selectedHotel);
            return SUCCESS;
        } catch (DataAccessException e) {
            e.printStackTrace();
        }

        return ERROR;
    }

    /**
     * Reset Fields
     *
     */
    public void reset() {
        this.setId(0);
    }

    /**
     * Get Hotel List
     *
     * @return List - Hotel List
     */
    public List<Hotel> getHotelList() {
    	hotelList = new ArrayList<Hotel>();
        hotelList.addAll(getHotelService().getHotel());
    	
        
        return hotelList;
    }
    
    
    
    
    /**
     * Set Hotel List
     *
     * @param List - Hotel List
     */
    public void setHotelList(List<Hotel> hotelList) {
        this.hotelList = hotelList;
    }

    /**
     * Get Hotel Service
     *
     * @return IHotelService - Hotel Service
     */
    public IHotelService getHotelService() {
        return hotelService;
    }

    /**
     * Set Hotel Service
     *
     * @param IHotelService - Hotel Service
     */
    public void setHotelService(IHotelService hotelService) {
        this.hotelService = hotelService;
    }

 

    /**
     * Get Hotel Id
     *
     * @return int - Hotel Id
     */
    public int getId() {
        return id;
    }

    /**
     * Set Hotel Id
     *
     * @param int - Hotel Id
     */
    public void setId(int id) {
        this.id = id;
    }

    public Hotel getSelectedHotel() {
        return selectedHotel;
    }

    public void setSelectedHotel(Hotel selectedHotel) {
        this.selectedHotel = selectedHotel;
    }

    public Hotel getHotel() {
    	
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }



    public List<Hotel> getHotelOffreList() {
        hotelOffreList = new ArrayList<Hotel>();
        hotelOffreList.addAll(getHotelService().getHotelOffre());
        return hotelOffreList;
    }

    public void setHotelOffreList(List<Hotel> hotelOffreList) {
        this.hotelOffreList = hotelOffreList;
    }

}
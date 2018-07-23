package Bean;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import org.springframework.dao.DataAccessException;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.ColumnText;
import com.lowagie.text.pdf.PdfWriter;
import com.sun.jersey.core.impl.provider.entity.XMLJAXBElementProvider.Text;

import Model.Reservation;
import Service.IReservationService;
import java.text.ParseException;

import javax.annotation.processing.Filer;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

/**
 *
 * Reservation Managed Bean
 *
 *
 */
@ManagedBean(name ="reservationMB")
@SessionScoped
public class ReservationManagedBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final String SUCCESS = "success";
    private static final String ERROR = "error";

    //Spring Reservation Service is injected...
    @ManagedProperty(value = "#{ReservationService}")
    IReservationService reservationService;
    List<Reservation> reservationList = new ArrayList<Reservation>();
    private Reservation reservation;
    

    public ReservationManagedBean() {
    	reservation=new Reservation();
    	
    }

    public void preProcessPDF(Object document) throws IOException, BadElementException, DocumentException {
        Document pdf = (Document) document;
        pdf.open();
        pdf.setPageSize(PageSize.A4);
 
        
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        Font georgia = FontFactory.getFont("georgia", 20f);
        georgia.setColor(Color.GREEN);
        Chunk c4 = new Chunk("HAPPY HOLYDAYS", georgia);
         Paragraph p
         = new Paragraph();
         p.add(c4);
        
     p.setAlignment(Element.ALIGN_CENTER);
     Paragraph p2
     = new Paragraph("");
 p2.setAlignment(Element.ALIGN_CENTER);
 Font georgia1 = FontFactory.getFont("georgia", 15f);
 georgia1.setColor(Color.CYAN);
 Chunk c = new Chunk("FACTURE", georgia1);
     Paragraph p1
     = new Paragraph();
     p1.add(c);
 p1.setAlignment(Element.ALIGN_CENTER);
 p1.setSpacingAfter(20);
 

 String logo = servletContext.getRealPath("") + File.separator + "images" + File.separator + "logo3.jpg";
 
 pdf.add(Image.getInstance(logo));
     pdf.add(p);
     pdf.add(p2);
     pdf.add(p1);
    
    }

    

    /**
     * Get Reservation List
     *
     * @return List - Reservation List
     */
    public List<Reservation> getReservationList() {
    	reservationList = new ArrayList<Reservation>();
        reservationList.addAll(getReservationService().getReservation());
    	
        
        return reservationList;
    }
    
    
    
    
    /**
     * Set Reservation List
     *
     * @param List - Reservation List
     */
    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }

    /**
     * Get Reservation Service
     *
     * @return IReservationService - Reservation Service
     */
    public IReservationService getReservationService() {
        return reservationService;
    }

    /**
     * Set Reservation Service
     *
     * @param IReservationService - Reservation Service
     */
    public void setReservationService(IReservationService reservationService) {
        this.reservationService = reservationService;
    }

 

    
    public Reservation getReservation() {
    	
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }



}
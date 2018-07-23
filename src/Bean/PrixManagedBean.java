package Bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import org.springframework.dao.DataAccessException;

import Model.Hotel;
import Model.Prix;
import Service.IPrixService;
import java.text.ParseException;


import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * Prix Managed Bean
 *
 *
 */
@ManagedBean(name ="prixMB")
@SessionScoped
public class PrixManagedBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final String SUCCESS = "success";
    private static final String ERROR = "error";

    //Spring Prix Service is injected...
    @ManagedProperty(value = "#{PrixService}")
    IPrixService prixService;
    List<Prix> prixList = new ArrayList<Prix>();
    private Prix prix;
    private Prix selectedPrix;
    

    public PrixManagedBean() {
    	prix=new Prix();
    	selectedPrix=new Prix();
    	
    }

    public String updPrix() {
        try {
            getPrixService().updatePrix(selectedPrix);
            return SUCCESS;
        } catch (DataAccessException e) {
            e.printStackTrace();
        }

        return ERROR;
    }

    

    /**
     * Get Prix List
     *
     * @return List - Prix List
     */
    public List<Prix> getPrixList() {
    	prixList = new ArrayList<Prix>();
        prixList.addAll(getPrixService().getPrix());
    	
        
        return prixList;
    }
    
    
    
    
    /**
     * Set Prix List
     *
     * @param List - Prix List
     */
    public void setPrixList(List<Prix> prixList) {
        this.prixList = prixList;
    }

    /**
     * Get Prix Service
     *
     * @return IPrixService - Prix Service
     */
    public IPrixService getPrixService() {
        return prixService;
    }

    /**
     * Set Prix Service
     *
     * @param IPrixService - Prix Service
     */
    public void setPrixService(IPrixService prixService) {
        this.prixService = prixService;
    }

 

    
    public Prix getPrix() {
    	
        return prix;
    }

    public void setPrix(Prix prix) {
        this.prix = prix;
    }

    public Prix getSelectedPrix() {
        return selectedPrix;
    }

    public void setSelectedPrix(Prix selectedPrix) {
        this.selectedPrix = selectedPrix;
    }

}
package Bean;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.springframework.dao.DataAccessException;

import Model.Categories;
import Model.Chambres;
import Model.Hotel;
import Model.Prix;
import Model.Saison;
import Service.ICategoriesService;
import Service.IChambresService;
import Service.IHotelService;
import Service.IPrixService;
import Service.ISaisonService;
import bsh.ParseException;

/**
 *
 * Chambres Managed Bean
 *
 *
 */
@ManagedBean(name ="chambresMB")
@SessionScoped
public class ChambresManagedBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final String SUCCESS = "success";
    private static final String ERROR = "error";

    //Spring Chambres Service is injected...
    @ManagedProperty(value = "#{ChambresService}")
    IChambresService chambresService;
    @ManagedProperty(value="#{CategoriesService}")
	ICategoriesService categoriesService;
    @ManagedProperty(value="#{SaisonService}")
	ISaisonService saisonService;
    @ManagedProperty(value="#{PrixService}")
	IPrixService prixService;
    @ManagedProperty(value="#{HotelService}")
   	IHotelService hotelService;
    List<Chambres> chambresList = new ArrayList<Chambres>();
    
    private Chambres chambres;
    private String idCSelected ;
    private String idhSelected ;
    private int size;
    
    private String chmp ;
    private String chmd ;
    private Date dph;
    private Date fph;
    private Date dpp;
    private Date fpp;
    private Date dpe;
    private Date fpe;
	private Date dpa;
    private Date fpa;
    private String px1;
    private String px2;
    private String px3;
    private String px4;
    

    public ChambresManagedBean() {
    	chambres=new Chambres();
    	
    }

    public String addChambres( int idhSelected) throws java.text.ParseException{
        try{ 
        	int id =Integer.parseInt(idCSelected);
         Categories categories = new Categories();
         categories =  getCategoriesService().getCategoriesById(id);
         Hotel hotel = new Hotel();
         hotel =  getHotelService().getHotelById(idhSelected);
         int f =Integer.parseInt(chmp);
 		int l =Integer.parseInt(chmd);
 		
 		
         for(int i=f; i<l+1; i++){
         chambres.setCategories(categories);
         chambres.setHotel(hotel);
         chambres.setNum(i);
         chambres.setDispo(1);
         getChambresService().addChambres(chambres);
         //
         
         
         
 		
		Saison saison1 =new Saison();
		
		saison1.setDebperiode(dph);
		saison1.setFinperiode(fph);
        saison1.setChambres(chambres);
        saison1.setCategories(categories);
        saison1.setPeriode("Hiver");

         getSaisonService().addSaison(saison1);
         Prix prix1 = new Prix();
         prix1.setSaison(saison1);
         int ps1 =Integer.parseInt(px1);
         prix1.setPrix(ps1);
         getPrixService().addPrix(prix1);
         //
         

         Saison saison2 =new Saison();
         saison2.setChambres(chambres);
         saison2.setCategories(categories);
         
         saison2.setDebperiode(dpp);
 		 saison2.setFinperiode(fpp);
         saison2.setPeriode("Printemps");
         getSaisonService().addSaison(saison2);
         Prix prix2 = new Prix();
         prix2.setSaison(saison2);
         int ps2 =Integer.parseInt(px2);
         prix2.setPrix(ps2);
         getPrixService().addPrix(prix2);
         //
         
     	
         Saison saison3 =new Saison();
         saison3.setChambres(chambres);
         saison3.setCategories(categories);
         saison3.setDebperiode(dpe);
         saison3.setFinperiode(fpe);
         saison3.setPeriode("Ete");
         getSaisonService().addSaison(saison3);
         Prix prix3 = new Prix();
         prix3.setSaison(saison3);
         int ps3 =Integer.parseInt(px3);
         prix3.setPrix(ps3);
         getPrixService().addPrix(prix3);
         //
         
     	
         Saison saison4 =new Saison();
         saison4.setChambres(chambres);
         saison4.setCategories(categories);
         saison4.setDebperiode(dpa);
         saison4.setFinperiode(fpa);
         saison4.setPeriode("Automne");
         getSaisonService().addSaison(saison4);
         Prix prix4 = new Prix();
         prix4.setSaison(saison4);
         int ps4 =Integer.parseInt(px4);
         prix4.setPrix(ps4);
         getPrixService().addPrix(prix4);
        
         }
         
         int nbc = hotel.getNbchambre();
  		int k = (l-f)+1;
  		int cp=nbc+k;
  		hotel.setNbchambre(cp);
  		getHotelService().updateHotel(hotel);
         
         
        return SUCCESS;
 	   } catch (DataAccessException e) {
              e.printStackTrace();
          }

          return ERROR;
          
         
     }

    

   
   
    
    

    /**
     * Get Chambres List
     *
     * @return List - Chambres List
     */
    public List<Chambres> getChambresList() {
    	chambresList = new ArrayList<Chambres>();
        chambresList.addAll(getChambresService().getChambres());
    	
        
        return chambresList;
    }
    
    
    
    
    /**
     * Set Chambres List
     *
     * @param List - Chambres List
     */
    public void setChambresList(List<Chambres> chambresList) {
        this.chambresList = chambresList;
    }

    /**
     * Get Chambres Service
     *
     * @return IChambresService - Chambres Service
     */
    public IChambresService getChambresService() {
        return chambresService;
    }

    /**
     * Set Chambres Service
     *
     * @param IChambresService - Chambres Service
     */
    public void setChambresService(IChambresService chambresService) {
        this.chambresService = chambresService;
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
     * Get Categories Service
     *
     * @return ICategoriesService - Categories Service
     */
    public ICategoriesService getCategoriesService() {
        return categoriesService;
    }

    /**
     * Set Categories Service
     *
     * @param ICategoriesService - Categories Service
     */
    public void setCategoriesService(ICategoriesService categoriesService) {
        this.categoriesService = categoriesService;
    }

    
    
    /**
     * Get Saison Service
     *
     * @return ISaisonService - Saison Service
     */
    public ISaisonService getSaisonService() {
        return saisonService;
    }

    /**
     * Set Saison Service
     *
     * @param ISaisonService - Saison Service
     */
    public void setSaisonService(ISaisonService saisonService) {
        this.saisonService = saisonService;
    }
    
    
    
    /**
     * Get Prix Service
     *
     * @return ISaisonService - Saison Service
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
 
    
    
    public Chambres getChambres() {
    	
        return chambres;
    }

    public void setChambres(Chambres chambres) {
        this.chambres = chambres;
    }
    
    public String getIdCSelected() {
        return idCSelected;
    }

    public void setIdhSelected(String idhSelected) {
        this.idhSelected = idhSelected;
    }
    public String getIdhSelected() {
        return idhSelected;
    }

    public void setIdCSelected(String idCSelected) {
        this.idCSelected = idCSelected;
    }
    
    public String getChmp() {
        return chmp;
    }

    public void setChmp(String chmp) {
        this.chmp = chmp;
    }

    public String getChmd() {
        return chmd;
    }

    public void setChmd(String chmd) {
        this.chmd = chmd;
    }
    
    
  
    
    public String getPx1() {
        return px1;
    }

    public void setPx1(String px1) {
        this.px1 = px1;
    }
    
    
    public String getPx2() {
        return px2;
    }

    public void setPx2(String px2) {
        this.px2 = px2;
    }
    
    public String getPx3() {
        return px3;
    }

    public void setPx3(String px3) {
        this.px3 = px3;
    }
    
    
    public String getPx4() {
        return px4;
    }

    public void setPx4(String px4) {
        this.px4 = px4;
    }

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	 public Date getDph() {
			return dph;
		}

		public void setDph(Date dph) {
			this.dph = dph;
		}

		public Date getFph() {
			return fph;
		}

		public void setFph(Date fph) {
			this.fph = fph;
		}

		public Date getDpp() {
			return dpp;
		}

		public void setDpp(Date dpp) {
			this.dpp = dpp;
		}

		public Date getFpp() {
			return fpp;
		}

		public void setFpp(Date fpp) {
			this.fpp = fpp;
		}

		public Date getDpe() {
			return dpe;
		}

		public void setDpe(Date dpe) {
			this.dpe = dpe;
		}

		public Date getFpe() {
			return fpe;
		}

		public void setFpe(Date fpe) {
			this.fpe = fpe;
		}

		public Date getDpa() {
			return dpa;
		}

		public void setDpa(Date dpa) {
			this.dpa = dpa;
		}

		public Date getFpa() {
			return fpa;
		}

		public void setFpa(Date fpa) {
			this.fpa = fpa;
		}


}
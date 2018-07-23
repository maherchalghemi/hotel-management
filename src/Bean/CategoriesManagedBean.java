package Bean;


import Model.Categories;
import Model.Hotel;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import Service.ICategoriesService;
import Service.IHotelService;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import static java.util.jar.Pack200.Packer.ERROR;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import org.springframework.dao.DataAccessException;


@ManagedBean(name="categoriesMB")
@SessionScoped
public class CategoriesManagedBean implements Serializable{
	
	 private static final long serialVersionUID = 1L;
	    private static final String SUCCESS = "success";
	    private static final String ERROR = "error";


	@ManagedProperty(value="#{CategoriesService}")
	ICategoriesService categoriesService;
	 List<Categories> categoriesList;
	 List<Categories> categoriesByIdHotelList;
	
	 private int idcSelected ;
     private Categories categories;
     
     private Categories categoriesSelected;
    
     
     
     public CategoriesManagedBean() {
    	 Categories categories; 
    	 categoriesSelected = new Categories();
    }
     
     
     
    
    	
     
   
     
     
     public ICategoriesService getCategoriesService() {
         return categoriesService;
     }

     public void setCategoriesService(ICategoriesService categoriesService) {
         this.categoriesService = categoriesService;
     }
     
    
     
     public Categories getCategories() {
        
    	 return categories;
         
     }



     public void setCategories(Categories categories) {
         this.categories = categories;
     }
     
     public Categories getCategoriesSelected() {
         return categoriesSelected;
     }


    

     public void setIdcSelected(int idcSelected) {
    	 
         this.idcSelected = idcSelected;
     }
     
     

     
     public List<Categories> getCategoriesList() {
    	 categoriesList = new ArrayList<Categories>();
    	 categoriesList.addAll(getCategoriesService().getCategories()); 
 return categoriesList;
}

public void setCategoriesList(List<Categories> categoriesList) {
 this.categoriesList = categoriesList;
}






}

package Service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import Model.Categories;
import DAO.ICategoriesDAO;

/**
 * 
 * Categories Service
 * 
 *
 */
@Transactional(readOnly = true)
public class CategoriesService implements ICategoriesService {

	// CategoriesDAO is injected...
	ICategoriesDAO categoriesDAO;
	
	/**
	 * Add Categories
	 * 
	 * @param  Categories categories
	 */
	@Transactional(readOnly = false)
	
	public void addCategories(Categories categories) {
		getCategoriesDAO().addCategories(categories);
	}

	/**
	 * Delete Categories
	 * 
	 * @param  Categories Categories
	 */
	@Transactional(readOnly = false)
	
	public void deleteCategories(Categories categories) {
		getCategoriesDAO().deleteCategories(categories);
	}
	
	/**
	 * Update Categories
	 * 
	 * @param  Categories Categories
	 */
	@Transactional(readOnly = false)

	public void updateCategories(Categories categories) {
		getCategoriesDAO().updateCategories(categories);
	}
	
	/**
	 * Get Categories
	 * 
	 * @param  int Categories Id
	 */
	
	public Categories getCategoriesById(int id) {
		return getCategoriesDAO().getCategoriesById(id);
	}
	
	

	/**
	 * Get Categories List
	 * 
	 */
	
	public List<Categories> getCategories() {	
		return getCategoriesDAO().getCategories();
	}
	


	/**
	 * Get Categories DAO
	 * 
	 * @return ICategoriesDAO - Categories DAO
	 */
	public ICategoriesDAO getCategoriesDAO() {
		return categoriesDAO;
	}

	/**
	 * Set Categories DAO
	 * 
	 * @param ICategoriesDAO - Categories DAO
	 */
	public void setCategoriesDAO(ICategoriesDAO categoriesDAO) {
		this.categoriesDAO = categoriesDAO;
	}
        
        

}

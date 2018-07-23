package Service;

import java.util.List;
import Model.Categories;


public interface ICategoriesService {

	public void addCategories(Categories categories);
	
	public void deleteCategories(Categories categories);

	public void updateCategories(Categories categories);

	
	public Categories getCategoriesById(int id);
	
	

	
	public List<Categories> getCategories();


}

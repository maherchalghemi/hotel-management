package Service;

import java.util.List;
import Model.Saison;


public interface ISaisonService {

	public void addSaison(Saison saison);
	
	public void deleteSaison(Saison saison);

	public void updateSaison(Saison saison);

	
	public Saison getSaisonById(int id);
	
	

	
	public List<Saison> getSaison();


}

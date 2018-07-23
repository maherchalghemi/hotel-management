package Service;

import java.util.List;
import Model.Prix;


public interface IPrixService {

	public void addPrix(Prix prix);
	
	public void deletePrix(Prix prix);

	public void updatePrix(Prix prix);

	
	public Prix getPrixById(int id);
	
	

	
	public List<Prix> getPrix();


}

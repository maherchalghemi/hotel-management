package Service;

import java.util.List;
import Model.Facture;


public interface IFactureService {

	public void addFacture(Facture facture);
	
	public void deleteFacture(Facture facture);

	public void updateFacture(Facture facture);

	
	public Facture getFactureById(int id);

	
	public List<Facture> getFacture();


}

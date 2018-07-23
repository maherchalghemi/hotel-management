package Service;

import java.util.List;
import Model.Chambres;


public interface IChambresService {

	public void addChambres(Chambres chambres);
	
	public void deleteChambres(Chambres chambres);

	public void updateChambres(Chambres chambres);

	
	public Chambres getChambresById(int id);
	public List<Chambres> getChambresByIdHotel(int id);

	
	public List<Chambres> getChambres();
	


}

package DAO;

import java.util.List;
import Model.Chambres;


public interface IChambresDAO {
	
public void addChambres(Chambres chambres);
	

	public void updateChambres(Chambres chambres);
	

	public void deleteChambres(Chambres chambres);
	
	
	public Chambres getChambresById(int id);
	public List<Chambres> getChambresByIdHotel(int id);
	
	
	public List<Chambres> getChambres();
        
        public List<Chambres> getChambresDispo();



}

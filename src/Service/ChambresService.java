package Service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import Model.Chambres;
import DAO.IChambresDAO;

/**
 * 
 * Chambres Service
 * 
 *
 */
@Transactional(readOnly = true)
public class ChambresService implements IChambresService {

	// ChambresDAO is injected...
	IChambresDAO chambresDAO;
	
	/**
	 * Add Chambres
	 * 
	 * @param  Chambres Chambres
	 */
	@Transactional(readOnly = false)
	
	public void addChambres(Chambres chambres) {
		getChambresDAO().addChambres(chambres);
	}

	/**
	 * Delete Chambres
	 * 
	 * @param  Chambres Chambres
	 */
	@Transactional(readOnly = false)
	
	public void deleteChambres(Chambres chambres) {
		getChambresDAO().deleteChambres(chambres);
	}
	
	/**
	 * Update Chambres
	 * 
	 * @param  Chambres Chambres
	 */
	@Transactional(readOnly = false)

	public void updateChambres(Chambres chambres) {
		getChambresDAO().updateChambres(chambres);
	}
	
	/**
	 * Get Chambres
	 * 
	 * @param  int Chambres Id
	 */
	
	public Chambres getChambresById(int id) {
		return getChambresDAO().getChambresById(id);
	}
	
	public List<Chambres> getChambresByIdHotel(int id) {
		return getChambresDAO().getChambresByIdHotel(id);
	}

	/**
	 * Get Chambres List
	 * 
	 */
	
	public List<Chambres> getChambres() {	
		return getChambresDAO().getChambres();
	}
	
	
	

	/**
	 * Get Chambres DAO
	 * 
	 * @return IChambresDAO - Chambres DAO
	 */
	public IChambresDAO getChambresDAO() {
		return chambresDAO;
	}

	/**
	 * Set Chambres DAO
	 * 
	 * @param IChambresDAO - Chambres DAO
	 */
	public void setChambresDAO(IChambresDAO chambresDAO) {
		this.chambresDAO = chambresDAO;
	}
        
        

}

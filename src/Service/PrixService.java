package Service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import Model.Prix;
import DAO.IPrixDAO;

/**
 * 
 * Prix Service
 * 
 *
 */
@Transactional(readOnly = true)
public class PrixService implements IPrixService {

	// PrixDAO is injected...
	IPrixDAO prixDAO;
	
	/**
	 * Add Prix
	 * 
	 * @param  Prix Prix
	 */
	@Transactional(readOnly = false)
	
	public void addPrix(Prix prix) {
		getPrixDAO().addPrix(prix);
	}

	/**
	 * Delete Prix
	 * 
	 * @param  Prix Prix
	 */
	@Transactional(readOnly = false)
	
	public void deletePrix(Prix prix) {
		getPrixDAO().deletePrix(prix);
	}
	
	/**
	 * Update Prix
	 * 
	 * @param  Prix Prix
	 */
	@Transactional(readOnly = false)

	public void updatePrix(Prix prix) {
		getPrixDAO().updatePrix(prix);
	}
	
	/**
	 * Get Prix
	 * 
	 * @param  int Prix Id
	 */
	
	public Prix getPrixById(int id) {
		return getPrixDAO().getPrixById(id);
	}
	
	

	/**
	 * Get Prix List
	 * 
	 */
	
	public List<Prix> getPrix() {	
		return getPrixDAO().getPrix();
	}
	
	

	/**
	 * Get Prix DAO
	 * 
	 * @return IPrixDAO - Prix DAO
	 */
	public IPrixDAO getPrixDAO() {
		return prixDAO;
	}

	/**
	 * Set Prix DAO
	 * 
	 * @param IPrixDAO - Prix DAO
	 */
	public void setPrixDAO(IPrixDAO prixDAO) {
		this.prixDAO = prixDAO;
	}
        
        

}

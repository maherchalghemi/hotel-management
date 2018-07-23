package Service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import Model.Saison;
import DAO.ISaisonDAO;

/**
 * 
 * Saison Service
 * 
 *
 */
@Transactional(readOnly = true)
public class SaisonService implements ISaisonService {

	// SaisonDAO is injected...
	ISaisonDAO saisonDAO;
	
	/**
	 * Add Saison
	 * 
	 * @param  Saison Saison
	 */
	@Transactional(readOnly = false)
	
	public void addSaison(Saison saison) {
		getSaisonDAO().addSaison(saison);
	}

	/**
	 * Delete Saison
	 * 
	 * @param  Saison Saison
	 */
	@Transactional(readOnly = false)
	
	public void deleteSaison(Saison saison) {
		getSaisonDAO().deleteSaison(saison);
	}
	
	/**
	 * Update Saison
	 * 
	 * @param  Saison Saison
	 */
	@Transactional(readOnly = false)

	public void updateSaison(Saison saison) {
		getSaisonDAO().updateSaison(saison);
	}
	
	/**
	 * Get Saison
	 * 
	 * @param  int Saison Id
	 */
	
	public Saison getSaisonById(int id) {
		return getSaisonDAO().getSaisonById(id);
	}
	
	

	/**
	 * Get Saison List
	 * 
	 */
	
	public List<Saison> getSaison() {	
		return getSaisonDAO().getSaison();
	}
	
	

	/**
	 * Get Saison DAO
	 * 
	 * @return ISaisonDAO - Saison DAO
	 */
	public ISaisonDAO getSaisonDAO() {
		return saisonDAO;
	}

	/**
	 * Set Saison DAO
	 * 
	 * @param ISaisonDAO - Saison DAO
	 */
	public void setSaisonDAO(ISaisonDAO saisonDAO) {
		this.saisonDAO = saisonDAO;
	}
        
        

}

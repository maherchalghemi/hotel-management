package Service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import Model.Facture;
import DAO.IFactureDAO;

/**
 * 
 * Facture Service
 * 
 *
 */
@Transactional(readOnly = true)
public class FactureService implements IFactureService {

	// FactureDAO is injected...
	IFactureDAO factureDAO;
	
	/**
	 * Add Facture
	 * 
	 * @param  Facture Facture
	 */
	@Transactional(readOnly = false)
	
	public void addFacture(Facture Facture) {
		getFactureDAO().addFacture(Facture);
	}

	/**
	 * Delete Facture
	 * 
	 * @param  Facture Facture
	 */
	@Transactional(readOnly = false)
	
	public void deleteFacture(Facture Facture) {
		getFactureDAO().deleteFacture(Facture);
	}
	
	/**
	 * Update Facture
	 * 
	 * @param  Facture Facture
	 */
	@Transactional(readOnly = false)

	public void updateFacture(Facture Facture) {
		getFactureDAO().updateFacture(Facture);
	}
	
	/**
	 * Get Facture
	 * 
	 * @param  int Facture Id
	 */
	
	public Facture getFactureById(int id) {
		return getFactureDAO().getFactureById(id);
	}

	/**
	 * Get Facture List
	 * 
	 */
	
	public List<Facture> getFacture() {	
		return getFactureDAO().getFacture();
	}

	/**
	 * Get Facture DAO
	 * 
	 * @return IFactureDAO - Facture DAO
	 */
	public IFactureDAO getFactureDAO() {
		return factureDAO;
	}

	/**
	 * Set Facture DAO
	 * 
	 * @param IFactureDAO - Facture DAO
	 */
	public void setFactureDAO(IFactureDAO factureDAO) {
		this.factureDAO = factureDAO;
	}
        
        

}

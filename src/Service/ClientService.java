package Service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import Model.Client;
import DAO.IClientDAO;

/**
 * 
 * Client Service
 * 
 *
 */
@Transactional(readOnly = true)
public class ClientService implements IClientService {

	// ClientDAO is injected...
	IClientDAO clientDAO;
	
	/**
	 * Add Client
	 * 
	 * @param  Client Client
	 */
	@Transactional(readOnly = false)
	
	public void addClient(Client client) {
		getClientDAO().addClient(client);
	}

	/**
	 * Delete Client
	 * 
	 * @param  Client Client
	 */
	@Transactional(readOnly = false)
	
	public void deleteClient(Client client) {
		getClientDAO().deleteClient(client);
	}
	
	/**
	 * Update Client
	 * 
	 * @param  Client Client
	 */
	@Transactional(readOnly = false)

	public void updateClient(Client client) {
		getClientDAO().updateClient(client);
	}
	
	/**
	 * Get Client
	 * 
	 * @param  int Client Id
	 */
	
	public Client getClientById(int id) {
		return getClientDAO().getClientById(id);
	}

	/**
	 * Get Client List
	 * 
	 */
	
	public List<Client> getClient() {	
		return getClientDAO().getClient();
	}

	/**
	 * Get Client DAO
	 * 
	 * @return IClientDAO - Client DAO
	 */
	public IClientDAO getClientDAO() {
		return clientDAO;
	}

	/**
	 * Set Client DAO
	 * 
	 * @param IClientDAO - Client DAO
	 */
	public void setClientDAO(IClientDAO clientDAO) {
		this.clientDAO = clientDAO;
	}
        
        

}

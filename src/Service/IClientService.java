package Service;

import java.util.List;
import Model.Client;


public interface IClientService {

	public void addClient(Client client);
	
	public void deleteClient(Client lient);

	public void updateClient(Client client);

	
	public Client getClientById(int id);

	
	public List<Client> getClient();


}

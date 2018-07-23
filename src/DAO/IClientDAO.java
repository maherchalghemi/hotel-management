package DAO;

import java.util.List;

import javax.servlet.ServletContext;

import Model.Client;

public interface IClientDAO {

	
	public void addClient(Client client);//winha implementation?
	public void deleteClient(Client client);
	public void updateClient(Client client);
	public Client getClientById(int id);
	public List<Client> getClient();
	
	
	
	
}

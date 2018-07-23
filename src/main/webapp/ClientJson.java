package main.webapp;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedProperty;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;

import DAO.ClientDAO;
import DAO.IClientDAO;
import Model.Client;
import Service.IClientService;


@Path(value="/client")
public class ClientJson{
	
	private ClientDAO clientService = new ClientDAO() ; 

	
	
	
	 
	@GET
	@Path(value="/enregistrer/{nom}/{prenom}/{tel}/{cin}/{login}/{mdp}")
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public String add(@PathParam (value="nom") String nom, @PathParam (value="prenom") String prenom,
			@PathParam (value="tel") String tel, @PathParam (value="cin") String cin,
			@PathParam (value="login") String login, @PathParam (value="mdp") String mdp){
	

		
		 Client client=new Client();
		 System.out.println(client.equals(null));
		client.setNom(nom);
		client.setPrenom(prenom);
		client.setTel(tel);
		client.setCin(cin);
		client.setLogin(login);
		client.setMdp(mdp);
		client.setNbreserv(0);
		System.out.println(client);
		if(!clientService.saveClient(client)){
		return "{\"statut\":\"ok\"}";
		}
		else{
			return "{\"statut\":\"not ok\"}";
		}
		
	}
}

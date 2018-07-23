package Bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import org.springframework.dao.DataAccessException;
import Model.Client;
import Service.IClientService;
import java.text.ParseException;


import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * Client Managed Bean
 *
 *
 */
@ManagedBean(name ="clientMB")
@SessionScoped
public class ClientManagedBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final String SUCCESS = "success";
    private static final String ERROR = "error";

    //Spring Client Service is injected...
    @ManagedProperty(value = "#{ClientService}")
    IClientService clientService;
    List<Client> clientList = new ArrayList<Client>();
    private Client client;
    

    public ClientManagedBean() {
    	client=new Client();
    	
    }

   

    

    /**
     * Get Client List
     *
     * @return List - Client List
     */
    public List<Client> getClientList() {
    	clientList = new ArrayList<Client>();
        clientList.addAll(getClientService().getClient());
    	
        
        return clientList;
    }
    
    
    
    
    /**
     * Set Client List
     *
     * @param List - Client List
     */
    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }

    /**
     * Get Client Service
     *
     * @return IClientService - Client Service
     */
    public IClientService getClientService() {
        return clientService;
    }

    /**
     * Set Client Service
     *
     * @param IClientService - Client Service
     */
    public void setClientService(IClientService clientService) {
        this.clientService = clientService;
    }

 

    
    public Client getClient() {
    	
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }



}
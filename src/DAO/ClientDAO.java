package DAO;

import java.util.List;

import javax.servlet.ServletContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import Model.Client;

public class ClientDAO implements IClientDAO{

	
	private SessionFactory sessionFactory;

	/**
	 * Get Hibernate Session Factory
	 * 
	 * @return SessionFactory - Hibernate Session Factory
	 */
	public SessionFactory getSessionFactory() {
		
		return sessionFactory;//ya m3ellem 3leh hekka :p betbi3a hetha new 
	}

	/**
	 * Set Hibernate Session Factory
	 * 
	 * @param SessionFactory - Hibernate Session Factory
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

	/**
	 * Add Client
	 * 
	 * @param  Client client
	 */
	public void addClient(Client client) {
		
		getSessionFactory().getCurrentSession().save(client);
	}

	/**
	 * Delete Client
	 * 
	 * @param  Client client
	 */
	public void deleteClient(Client client) {
		getSessionFactory().getCurrentSession().delete(client);
	}

	/**
	 * Update Client
	 * 
	 * @param  Client client
	 */
	
	public void updateClient(Client client) {
		getSessionFactory().getCurrentSession().update(client);
	}

	/**
	 * Get Ckient
	 * 
	 * @param  int Client Id
	 * @return Client 
	 */
	
	public Client getClientById(int id) {
		List list = getSessionFactory().getCurrentSession()
											.createQuery("from Client where idclient=?")
									        .setParameter(0, id).list();
		return (Client)list.get(0);
	}

	/**
	 * Get Client List
	 * 
	 * @return List - Client list
	 */
	
	public List<Client> getClient() {
		List list = getSessionFactory().getCurrentSession().createQuery("from Client").list();
		return list;
	}
        
	public boolean saveClient(Client client){
		Session session=null;
		boolean err = false;
		try{
			session =getSessionFactory().openSession();
			session.beginTransaction();
			session.saveOrUpdate(client);
			session.getTransaction().commit();
		}
		catch(Exception ex){
			if(session!=null){
				session.getTransaction().rollback();
			}
			err=true;
		}
		
		finally {
			if(session!=null){
				session.close();
			}
		}
		
		return err;
	}
	
	
	
}

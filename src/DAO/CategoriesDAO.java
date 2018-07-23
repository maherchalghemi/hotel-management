package DAO;

import java.util.List;

import org.hibernate.SessionFactory;

import Model.Categories;

public class CategoriesDAO implements ICategoriesDAO {

	private SessionFactory sessionFactory;

	/**
	 * Get Hibernate Session Factory
	 * 
	 * @return SessionFactory - Hibernate Session Factory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
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
	 * Add Categories
	 * 
	 * @param  Categories Categories
	 */
	public void addCategories(Categories Categories) {
		getSessionFactory().getCurrentSession().save(Categories);
	}

	/**
	 * Delete Categories
	 * 
	 * @param  Categories Categories
	 */
	public void deleteCategories(Categories Categories) {
		getSessionFactory().getCurrentSession().delete(Categories);
	}

	/**
	 * Update Categories
	 * 
	 * @param  Categories Categories
	 */
	
	public void updateCategories(Categories categories) {
		getSessionFactory().getCurrentSession().update(categories);
	}

	/**
	 * Get Categorie
	 * 
	 * @param  int Categories Id
	 * @return Categories 
	 */
	
	public Categories getCategoriesById(int id) {
		List list = getSessionFactory().getCurrentSession()
											.createQuery("from Categories where idcategories=?")
									        .setParameter(0, id).list();
		return (Categories)list.get(0);
	}
	

	
	public List<Categories> getCategories() {
		List list = getSessionFactory().getCurrentSession().createQuery("from Categories").list();
		return list;
	}
}

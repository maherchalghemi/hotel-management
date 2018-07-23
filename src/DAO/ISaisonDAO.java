package DAO;

import java.util.List;

import Model.Saison;

public interface ISaisonDAO {

	public void addSaison(Saison saison);
	public void deleteSaison(Saison saison);
	public void updateSaison(Saison saison);
	public Saison getSaisonById(int id);
	public List<Saison> getSaison();
}

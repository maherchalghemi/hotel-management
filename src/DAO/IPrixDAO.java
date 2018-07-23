package DAO;

import java.util.List;

import Model.Prix;

public interface IPrixDAO {

	public void addPrix(Prix prix);
	public void deletePrix(Prix prix);
	public void updatePrix(Prix prix);
	public Prix getPrixById(int id);
	public List<Prix> getPrix();
}

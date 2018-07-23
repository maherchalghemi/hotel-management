package DAO;

import java.util.List;

import Model.Reservation;

public interface IReservationDAO {

	public void addReservation(Reservation reservation);
	public void deleteReservation(Reservation reservation);
	public void updateReservation(Reservation reservation);
	public Reservation getReservationById(int id);
	public List<Reservation> getReservation();
}

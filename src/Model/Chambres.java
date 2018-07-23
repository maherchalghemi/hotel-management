package Model;
// Generated 25 juil. 2015 19:43:56 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator; 



/**
 * Chambres generated by hbm2java
 */
@Entity
@Table(name = "chambres", catalog = "ghl")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
public class Chambres implements java.io.Serializable {

	private Integer idchambres;
	private Integer num;
	private Integer dispo;
	private Categories categories;
	private Hotel hotel;
	private Set<Reservation> reservation = new HashSet<Reservation>(0);
	private Set<Saison> saison = new HashSet<Saison>(0);

	public Chambres() {
	}
	
	public Chambres(Integer idchambres, Integer num, Integer dispo, Categories categories ,Hotel hotel) {
		this.idchambres=idchambres;
		this.num = num;
		this.dispo = dispo;
		this.categories = categories;
		this.hotel = hotel;
	}

	public Chambres(Integer idchambres, Integer num, Integer dispo, Categories categories, Hotel hotel, Set<Reservation> reservation) {
		this.idchambres=idchambres;
		this.num = num;
		this.dispo = dispo;
		this.categories = categories;
		this.hotel= hotel;
		this.reservation=reservation;
	}
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "idchambres", unique = true, nullable = false)
	public Integer getIdchambres() {
		return this.idchambres;
	}

	public void setIdchambres(Integer idchambres) {
		this.idchambres = idchambres;
	}
	
	@Column(name = "num")
	public Integer getNum() {
		return this.num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	@Column(name = "dispo")
	public Integer getDispo() {
		return this.dispo;
	}

	public void setDispo(Integer dispo) {
		this.dispo = dispo;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idcategories", nullable = false)
	public Categories getCategories() {
		return this.categories;
	}

	public void setCategories(Categories categories) {
		this.categories = categories;
	}
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idhotel", nullable = false)
	public Hotel getHotel() {
		return this.hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "chambres")
	public Set<Reservation> getReservation() {
		return this.reservation;
	}

	public void setReservation(Set<Reservation> reservation) {
		this.reservation = reservation;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "chambres")
	public Set<Saison> getSaison() {
		return this.saison;
	}

	public void setSaison(Set<Saison> saison) {
		this.saison = saison;
	}

}
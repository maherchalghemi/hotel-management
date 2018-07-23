package Model;
// Generated 25 juil. 2015 19:43:56 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties; 


/**
 * Client generated by hbm2java
 */
@Entity
@Table(name = "client", catalog = "ghl")

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
public class Client implements java.io.Serializable {

	private Integer idclient;
	private String nom;
	private String prenom;
	private String tel;
	private String cin;
	private String login;
	private String mdp;
	private Integer nbreserv;
	private Set<Reservation> reservation = new HashSet<Reservation>(0);

	public Client() {
	}
	
	public Client(Integer idclient, String nom, String prenom, String tel, String cin, String login, String mdp, Integer nbreserv) {
		this.idclient=idclient;
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.cin = cin;
		this.login = login;
		this.mdp = mdp;
		this.nbreserv = nbreserv;
		
	}

	

	@Override
	public String toString() {
		return "Client [idclient=" + idclient + ", nom=" + nom + ", prenom=" + prenom + ", tel=" + tel + ", cin=" + cin
				+ ", login=" + login + ", mdp=" + mdp + ", nbreserv=" + nbreserv + ", reservation=" + reservation + "]";
	}

	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	

	@Column(name = "idclient", unique = true, nullable = false)
	public Integer getIdclient() {
		return this.idclient;
	}

	public void setIdclient(Integer idclient) {
		this.idclient = idclient;
	}

	@Column(name = "nom", length = 45)
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name = "prenom", length = 45)
	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Column(name = "tel", length = 45)
	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column(name = "cin", length = 8)
	public String getCin() {
		return this.cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	@Column(name = "login", length = 100)
	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Column(name = "mdp", length = 100)
	public String getMdp() {
		return this.mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	@Column(name = "nbreserv")
	public Integer getNbreserv() {
		return this.nbreserv;
	}

	public void setNbreserv(Integer nbreserv) {
		this.nbreserv = nbreserv;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "client")
	public Set<Reservation> getReservation() {
		return this.reservation;
	}

	public void setReservation(Set<Reservation> reservation) {
		this.reservation = reservation;
	}
}

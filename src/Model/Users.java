package Model;
// Generated 25 juil. 2015 19:43:56 by Hibernate Tools 4.3.1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import java.util.HashSet;
import java.util.Set;
/**
 * Users generated by hbm2java
 */
@Entity
@Table(name = "users", catalog = "ghl")
public class Users implements java.io.Serializable {

	private Integer idU;
	private String nom;
	private String prenom;
	private String login;
	private String pwd;
	private Date dateNaissance;
	private String cin;
	private Integer enable;
	private Set<RoleUsers> roleUsers = new HashSet<RoleUsers>(0);
	public Users() {
	}

	public Users(Integer idU, String nom, String prenom, String login, String pwd, Date dateNaissance, String cin, Integer enable) {
		this.idU=idU;
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.pwd = pwd;
		this.dateNaissance = dateNaissance;
		this.cin = cin;
		this.enable = enable;
	}
	
	public Users(Integer idU, String nom, String prenom, String login, String pwd, Date dateNaissance, String cin, Integer enable, Set<RoleUsers> roleUsers) {
		this.idU=idU;
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.pwd = pwd;
		this.dateNaissance = dateNaissance;
		this.cin = cin;
		this.enable = enable;
		this.roleUsers=roleUsers;
	}

	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")

	@Column(name = "id_u", unique = true, nullable = false)
	public Integer getIdU() {
		return this.idU;
	}

	public void setIdU(Integer idU) {
		this.idU = idU;
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

	@Column(name = "login", length = 45)
	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Column(name = "pwd", length = 100)
	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date_naissance", length = 10)
	public Date getDateNaissance() {
		return this.dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	@Column(name = "cin", length = 8)
	public String getCin() {
		return this.cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	@Column(name = "enable")
	public Integer getEnable() {
		return this.enable;
	}

	public void setEnable(Integer enable) {
		this.enable = enable;
	}
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "users")
	public Set<RoleUsers> getRoleUserses() {
		return this.roleUsers;
	}

	public void setRoleUserses(Set<RoleUsers> roleUsers) {
		this.roleUsers = roleUsers;
	}

}

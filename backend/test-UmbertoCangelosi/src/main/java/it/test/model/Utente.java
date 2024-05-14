package it.test.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "utente")
public class Utente {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_U")
	private int id;
	
	@Column(name = "Nome")
	private String nome;
	
	@Column(name = "Cognome")
	private String cognome;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "citta")
	private String citta;
	
	@OneToMany(mappedBy="user",cascade=CascadeType.REFRESH, orphanRemoval = true)
	private List<Weather_Forecast> meteo = new ArrayList<>();
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public List<Weather_Forecast> getMeteo() {
		return meteo;
	}

	public void setMeteo(List<Weather_Forecast> meteo) {
		this.meteo = meteo;
	}
	
	
	
	
}
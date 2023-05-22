package it.corso.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name="utenti")
public class Utente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nome")
	@Pattern(regexp = "[a-zA-Z\\s']{2,50}", message = "Caratteri non ammessi!")
	private String nome;
	
	
	@Column(name="cognome")
	@Pattern(regexp = "[a-zA-Z\\s']{2,50}", message = "Caratteri non ammessi!")
	private String cognome;
	
	
	@Column(name="via")
	@Pattern(regexp = "[a-zA-Z\\s']{2,50}", message = "Caratteri non ammessi!")
	private String via;
	
	
	@Column(name="civico")
	@Pattern(regexp = "[0-9a-zA-Z\\s/]{1,10}", message = "Caratteri non ammessi!")
	private String civico;
	
	
	@Column(name="cap")
	@Pattern(regexp = "[0-9]{5}", message = "Caratteri non ammessi!")
	private String cap;
	
	@Column(name="comune")
	@Pattern(regexp = "[A-Za-z\\s']{2,50}", message = "Caratteri non ammessi!")
	private String comune;
	
	@Column(name="provincia")
	@Pattern(regexp = "[A-Z]{2}", message = "Caratteri non ammessi!")
	private String provincia;
	
	@Pattern(regexp = "[0-9+]{8,15}", message = "Caratteri non ammessi!")
	@Column(name="telefono")
	private String telefono;
	
	@Column(name="mail")
	@Pattern(regexp = "[A-Za-z0-9.-_]+@+[a-z]+.+[a-z]")
	private String mail;
	
	@Column(name="username")
	@Pattern(regexp = "[a-zA-Z0-9.]{3,20}", message = "Username non valido, caratteri non ammessi!")
	private String username;
	
	@Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{8,20}", message = "Password troppo debole!")
	@Column(name="password")
	private String password;
	

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

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public String getCivico() {
		return civico;
	}

	public void setCivico(String civico) {
		this.civico = civico;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public String getComune() {
		return comune;
	}

	public void setComune(String comune) {
		this.comune = comune;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}

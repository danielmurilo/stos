package estagio.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "APP_USERS")
public class AppUser implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "APP_USER_ID")
	private long id;
	@Column(name = "USERNAME", nullable = false)
	private String username;
	@Column(name = "NAME", nullable = false)
	private String name;
	@Column(name = "PASSWORD", nullable = false)
	private String password;
	@Column(name = "ROLE", nullable = false)
	private String role;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLogin() {
		return username;
	}
	public void setLogin(String login) {
		this.username = login;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public AppUser(long id, String username, String name, String password, String role) {
		super();
		this.id = id;
		this.username = username;
		this.name = name;
		this.password = password;
		this.role = role;
	}

	
	

	
}

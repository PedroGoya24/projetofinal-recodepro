package squad25.comercioFacil.models;


import java.util.List;

import jakarta.persistence.*;
import squad25.comercioFacil.util.AccesLevel;

@Entity
@Table(name = "user")
public class User {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUser;

	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private AccesLevel accesLevel;
	private String userName;
	private String telephone;
	private String email;	
	
	@OneToMany(mappedBy = "user")
	private List<Enterprise> enterprise; 

	public User() {
		
	}
	public User(Long idUser, AccesLevel accesLevel, String userName, String telephone, String email) {
		this.idUser = idUser;

		this.accesLevel = accesLevel;
		this.userName = userName;
		this.telephone = telephone;
		this.email = email;
	}
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}	
	public AccesLevel getAccesLevel() {
		return accesLevel;
	}
	public void setAccesLevel(AccesLevel accesLevel) {
		this.accesLevel = accesLevel;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public List<Enterprise> getEnterprise() {
		return enterprise;
	}
	public void setEnterprise(List<Enterprise> enterprise) {
		this.enterprise = enterprise;
	}
	
	
	
	
}

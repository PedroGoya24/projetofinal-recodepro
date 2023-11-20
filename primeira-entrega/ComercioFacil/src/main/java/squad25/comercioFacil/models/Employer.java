package squad25.comercioFacil.models;



import jakarta.persistence.*;
import squad25.comercioFacil.util.AccesLevel;

@Entity
public class Employer extends User{
	
	private static final long serialVersionUID = 1L;
	
	@Column(columnDefinition = "TEXT")
	private String login;	
		
	@Column(columnDefinition = "TEXT")	
	private String password;
	
	
	
	public Employer(Long idUser,AccesLevel accesLevel, String userName, String telephone, String email, String login, String password) {
		super(idUser, accesLevel, userName, telephone, email);
		this.login = login;
		this.password = password;
		
	}
	public Employer() {
		
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}

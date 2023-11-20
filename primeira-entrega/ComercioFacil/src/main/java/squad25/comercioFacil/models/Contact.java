package squad25.comercioFacil.models;

import jakarta.persistence.*;

@Entity
@Table(name = "contact")
public class Contact {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idContact;
	
	@Column(columnDefinition = "TEXT")
	private String subject;
	private String message;
	
	private boolean acceptNotifications;
	
	@OneToOne
	@JoinColumn(name = "id_user")
	private User user;
	

	
	public Contact(Long idContact, String subject, String message, boolean acceptNotifications) {		
		this.idContact = idContact;
		this.subject = subject;
		this.message = message;
		this.acceptNotifications = acceptNotifications;
	}
	
	public Contact() {
		
	}

	public Long getIdContact() {
		return idContact;
	}

	public void setIdContact(Long idContact) {
		this.idContact = idContact;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isAcceptNotifications() {
		return acceptNotifications;
	}

	public void setAcceptNotifications(boolean acceptNotifications) {
		this.acceptNotifications = acceptNotifications;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}

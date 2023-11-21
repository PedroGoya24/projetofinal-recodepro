package squad25.comercioFacil.models;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "enterprise")
public class Enterprise {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEnterprise;
	
	@Column(columnDefinition = "TEXT")
	private String fantasyName;
	private String cnpj;
	private Long numStore;
	
	private String description;
	
	@OneToMany(mappedBy = "enterprise")
	private List<Product> product;
	
	
	//Employer idUser
	@ManyToOne
	@JoinColumn(name = "id_user", nullable = false)
	private User user;
	
	
	
	@OneToOne
	@JoinColumn( name = "id_market")
	private MarketPlace marketPlace;
	
	
	
	public Enterprise() {
		 
	}
	public Enterprise(Long idEnterprise, String fantasyName, String cnpj, Long numStore, String description, User user, MarketPlace marketPlace) {
		this.idEnterprise = idEnterprise;
		this.fantasyName = fantasyName;
		this.cnpj = cnpj;
		this.numStore = numStore;
		this.user = user;
		this.marketPlace = marketPlace;
		this.description = description;
		}
	public Long getIdEnterprise() {
		return idEnterprise;
	}
	public void setIdEnterprise(Long idEnterprise) {
		this.idEnterprise = idEnterprise;
	}
	public String getFantasyName() {
		return fantasyName;
	}
	public void setFantasyName(String fantasyName) {
		this.fantasyName = fantasyName;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public Long getNumStore() {
		return numStore;
	}
	public void setNumStore(Long numStore) {
		this.numStore = numStore;
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
	public MarketPlace getMarketPlace() {
		return marketPlace;
	}
	public void setMarketPlace(MarketPlace marketPlace) {
		this.marketPlace = marketPlace;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}	
	
	
	
}

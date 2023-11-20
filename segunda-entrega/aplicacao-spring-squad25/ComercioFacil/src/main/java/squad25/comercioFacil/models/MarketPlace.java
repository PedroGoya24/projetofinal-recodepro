package squad25.comercioFacil.models;


import jakarta.persistence.*;

@Entity
@Table(name = "marketPlace")
public class MarketPlace {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMarket;
	
	@Column(columnDefinition = "TEXT")
	private String nameMarket;
	private String state;
	private String city;
	private String neighborhood;
	private String street;
	
	public MarketPlace() {
		
	}
	
	public MarketPlace(Long idMarket, String nameMarket, String state, String city, String neighborhood,
			String street) {
		super();
		this.idMarket = idMarket;
		this.nameMarket = nameMarket;
		this.state = state;
		this.city = city;
		this.neighborhood = neighborhood;
		this.street = street;
	}

	public Long getIdMarket() {
		return idMarket;
	}

	public void setIdMarket(Long idMarket) {
		this.idMarket = idMarket;
	}

	public String getNameMarket() {
		return nameMarket;
	}

	public void setNameMarket(String nameMarket) {
		this.nameMarket = nameMarket;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}

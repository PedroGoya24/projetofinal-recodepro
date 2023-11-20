package squad25.comercioFacil.models;

import jakarta.persistence.*;
import java.util.Locale.Category;


@Entity
@Table(name = "product")
public class Product {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProduct;
	private String name;	
	private Double value;
	
	@Enumerated(EnumType.STRING)
	@Column 
	private Category category;
	
	@ManyToOne
	@JoinColumn(name = "id_enterprise")
	private Enterprise enterprise;
	
	
	//arrumar fk empreendimento
	

public Product(Long idProduct, Category category, String name, Double value) {
	
		this.idProduct = idProduct;
		this.category = category;
		this.name = name;
		this.value = value;
		
}

public Product() {
		
}

public Long getIdProduct() {
	return idProduct;
}
public void setIdProduct(Long idProduct) {
	this.idProduct = idProduct;
}
public Category getCategory() {
	return category;
}
public void setCategory(Category category) {
	this.category = category;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Double getValue() {
	return value;
}
public void setValue(Double value) {
	this.value = value;
}

public static long getSerialversionuid() {
	return serialVersionUID;
}

public Enterprise getEnterprise() {
	return enterprise;
}

public void setEnterprise(Enterprise enterprise) {
	this.enterprise = enterprise;
}
	


	
}

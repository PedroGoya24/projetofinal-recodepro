package squad25.comercioFacil.util;

public enum Category {
	
	CATEGORY_ONE("COMESTIVEIS"),
	CATEGORY_TWO("ROUPAS"),
	CATEGORY_TREE("ELETRÔNICOS"),
	CATEGORY_FOUR("COSMÉTICOS");
	
	private final String name;
	
	private Category(String name) {
		
		this.name = name;
	}
	

	public String getName() {
		return name;
	}
	
	
}

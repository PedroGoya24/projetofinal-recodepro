package squad25.comercioFacil.util;

public enum AccesLevel {
	
	CLIENT("CLIENT"),
    EMPLOYER("EMPLOYER");
    
    private final String name;

    private AccesLevel(String name) {
        
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    
}

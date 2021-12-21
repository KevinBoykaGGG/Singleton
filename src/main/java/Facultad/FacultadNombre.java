package Facultad;

public class FacultadNombre {
	
	private String NombreFacu;
	
	private static FacultadNombre instance;

	private FacultadNombre() {
    }
   
    public static FacultadNombre getInstance() {
        if (instance == null) {      
            instance = new FacultadNombre();
        }
        return instance;
    }


	public String getNombreFacu() {
		return NombreFacu;
	}


	public void setNombreFacu(String nombreFacu) {
		NombreFacu = nombreFacu;
	}
    
    

}

package Modelo;


	public class Categoria {
	
	
    private int id;
  
   
    private CategoriaNombre categoriaNombre;
	
    
    public Categoria() {
	}

	public Categoria(CategoriaNombre categoriaNombre) {
		this.categoriaNombre = categoriaNombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CategoriaNombre getCategoriaNombre() {
		return categoriaNombre;
	}

	public void setCategoriaNombre(CategoriaNombre categoriaNombre) {
		this.categoriaNombre = categoriaNombre;
	}
	


}

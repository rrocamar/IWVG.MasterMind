package masterMind.models;

public enum Color {

	AMARILLO("Amarillo"),
	ROJO("Rojo"),
	VERDE("Verde"),
	AZUL("Azul"),
	BLANCO("Blanco"),
	NEGRO("Negro");

	private String descripcion;

	Color(String descripcion){
		this.descripcion = descripcion;
	}

	public String getDescripcion(){
		return this.descripcion;
	}

}

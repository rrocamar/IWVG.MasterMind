package masterMind.models;

public enum Color {

    AMARILLO("A", "Amarillo"),
    ROJO("R", "Rojo"),
    VERDE("V", "Verde"),
    AZUL("Z", "Azul"),
    BLANCO("B", "Blanco"),
    NEGRO("N", "Negro");

	private String descripcion;

    private String codigo;

    Color(String codigo, String descripcion) {
        this.codigo = codigo;
		this.descripcion = descripcion;
	}

    public String getCodigo() {
        return codigo;
    }

	public String getDescripcion(){
		return this.descripcion;
	}

}

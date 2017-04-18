package enums;

public enum Estado {

	EN_PROCESO("En proceso",1),
	CONVERTIDA("Convertida",2),
	SIN_PENDIENTES("Sin pendientes",3);

	private String nomEstado;
	private Integer codEstado;

	private Estado(String nomEstado, Integer codEstado) {
		this.nomEstado = nomEstado;
		this.codEstado = codEstado;
	}

	public String getNomEstado() {
		return nomEstado;
	}

	public void setNomEstado(String nomEstado) {
		this.nomEstado = nomEstado;
	}

	public Integer getCodEstado() {
		return codEstado;
	}

	public void setCodEstado(Integer codEstado) {
		this.codEstado = codEstado;
	}
	
	

}

package SRC;

public class ReclameESolicite {
	private String tipo;
	private String texto;
	private String numeroApartamento;

	public ReclameESolicite(String tipo, String texto, String numeroApartamento) {
		super();
		this.tipo = tipo;
		this.texto = texto;
		this.numeroApartamento = numeroApartamento;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getNumeroApartamento() {
		return numeroApartamento;
	}

	public void setNumeroApartamento(String numeroApartamento) {
		this.numeroApartamento = numeroApartamento;
	}

}

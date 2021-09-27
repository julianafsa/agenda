package br.com.santander.agenda.model.dto;

public class FormTelefoneDto {
	
    private String ddd;
    private String numero;
    private Integer idContato;
    
	public FormTelefoneDto(String ddd, String numero, Integer idContato) {
		super();
		this.ddd = ddd;
		this.numero = numero;
		this.idContato = idContato;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Integer getIdContato() {
		return idContato;
	}

	public void setIdContato(Integer idContato) {
		this.idContato = idContato;
	}

}

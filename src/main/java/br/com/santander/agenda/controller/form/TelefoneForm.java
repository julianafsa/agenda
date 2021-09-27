package br.com.santander.agenda.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TelefoneForm {
	
	@NotNull @NotEmpty @Size(min = 2, max = 2)
    private String ddd;
	
	@NotNull @NotEmpty @Size(min = 8, max = 9)
    private String numero;
	
	@NotNull @NotEmpty
	private String idContato;
	
	public String getDdd() {
		return ddd;
	}

	public String getNumero() {
		return numero;
	}

	public String getIdContato() {
		return idContato;
	}

}

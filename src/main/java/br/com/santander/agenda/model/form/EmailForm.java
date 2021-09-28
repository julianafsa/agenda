package br.com.santander.agenda.model.form;

import java.util.Optional;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import br.com.santander.agenda.model.Contato;
import br.com.santander.agenda.service.ContatoService;

public class EmailForm {
	
	@Email
	@NotBlank(message = "Field must not be missing or null")
    private String email;

	@Min(value = 1)
	@NotBlank(message = "Field must not be missing or null")	
	private String idContato;
	
	public String getEmail() {
		return email;
	}

	public String getIdContato() {
		return idContato;
	}

	public br.com.santander.agenda.model.Email converter(ContatoService contatoService) {
		Optional<Contato> contato = contatoService.getContact(Integer.parseInt(this.idContato));
		if (!contato.isPresent())
			return null;
		return new br.com.santander.agenda.model.Email(this.email, contato.get());
	}

}

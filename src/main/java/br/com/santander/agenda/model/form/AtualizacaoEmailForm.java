package br.com.santander.agenda.model.form;

import java.util.Optional;

import javax.validation.constraints.Email;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.santander.agenda.service.EmailService;

public class AtualizacaoEmailForm {
	
	@JsonProperty("E-mail")
	@Email(message = "Field is not valid")
    private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public br.com.santander.agenda.model.Email atualizar(Integer id, EmailService service) {
		Optional<br.com.santander.agenda.model.Email> optional = service.getEmail(id);
		if (optional.isPresent()) {
			br.com.santander.agenda.model.Email email = optional.get();
			email.setEmail(this.email);
			return email;
		}
		return null;
	}
	
}

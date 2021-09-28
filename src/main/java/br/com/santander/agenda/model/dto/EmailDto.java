package br.com.santander.agenda.model.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.santander.agenda.model.Email;

public class EmailDto {
	
	@JsonProperty("E-mail")
	private String email;
    
	@JsonProperty("Contato")
    private String contactFullName;
	
	public EmailDto() {}

	public EmailDto(String email, String contactFullName) {
		this.email = email;
		this.contactFullName = contactFullName;
	}
	
	public EmailDto(Email email) {
		this.email = email.getEmail();
		this.contactFullName = email.getContato().getNome() + " " + email.getContato().getSobrenome();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactFullName() {
		return contactFullName;
	}

	public void setContactFullName(String contactFullName) {
		this.contactFullName = contactFullName;
	}

	public static List<EmailDto> converter(List<Email> emails) {
		return emails.stream().map(EmailDto::new).collect(Collectors.toList());
	}

}

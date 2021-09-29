package br.com.santander.agenda.model.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.santander.agenda.model.Email;

public class EmailDto {
	
	private String email;
	
	public EmailDto() {}

	public EmailDto(String email) {
		this.email = email;
	}
	
	public EmailDto(Email email) {
		this.email = email.getEmail();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static List<EmailDto> converter(List<Email> emails) {
		return emails.stream().map(EmailDto::new).collect(Collectors.toList());
	}

}

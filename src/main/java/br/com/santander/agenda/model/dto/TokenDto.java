package br.com.santander.agenda.model.dto;

public class TokenDto {

	private String token;
	private String type;
	
	public TokenDto(final String token, final String type) {
		this.token = token;
		this.type = type;
	}

	public String getToken() {
		return token;
	}
	
	public String getType() {
		return type;
	}
	
}
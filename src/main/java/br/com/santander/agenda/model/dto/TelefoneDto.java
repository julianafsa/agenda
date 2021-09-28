package br.com.santander.agenda.model.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.santander.agenda.enumerations.TipoTelefone;
import br.com.santander.agenda.model.Telefone;

public class TelefoneDto {
	
	@JsonProperty("Contato")
    private String contactFullName;

	@JsonProperty("Número")
	private String phoneNumber;
	
	@JsonProperty("Tipo")
	private String phoneType;
    
    protected TelefoneDto() {}
    
	public TelefoneDto(String ddd, String numero, String nome, String sobrenome, TipoTelefone tipo) {
		this.phoneNumber = "(" + ddd + ") " + numero;
		this.phoneType = tipo.getDescricao();
		this.contactFullName = nome + " " + sobrenome;
	}
	
	public TelefoneDto(Telefone telefone) {
		this.phoneNumber = "(" + telefone.getDdd() + ") " + telefone.getNumero(); 
		this.phoneType = telefone.getTipo().getDescricao();
		this.contactFullName = telefone.getContato().getNome() + " " + telefone.getContato().getSobrenome();
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(TipoTelefone phoneType) {
		this.phoneType = phoneType.getDescricao();
	}

	public String getContactFullName() {
		return contactFullName;
	}

	public void setFullName(String fullName) {
		this.contactFullName = fullName;
	}

	public static List<TelefoneDto> converter(List<Telefone> telefones) {
		return telefones.stream().map(TelefoneDto::new).collect(Collectors.toList());
	}
	
	public static Page<TelefoneDto> converter(Page<Telefone> telefones) {
		return telefones.map(TelefoneDto::new);
	}
	
}

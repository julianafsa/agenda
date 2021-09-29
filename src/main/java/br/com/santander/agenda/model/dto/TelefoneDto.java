package br.com.santander.agenda.model.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

import br.com.santander.agenda.enumerations.TipoTelefone;
import br.com.santander.agenda.model.Telefone;

public class TelefoneDto {
	
    private String ddd;
    private String numero;
    private TipoTelefone tipo;
    
	public TelefoneDto(String ddd, String numero, TipoTelefone tipo) {
		this.ddd = ddd;
		this.numero = numero;
		this.tipo = tipo;
	}
	
	public TelefoneDto(Telefone telefone) {
		this.ddd = telefone.getDdd();
		this.numero = telefone.getNumero();
		this.tipo = telefone.getTipo();
	}	

	public String getDdd() {
		return ddd;
	}

	public String getNumero() {
		return numero;
	}

	public TipoTelefone getTipo() {
		return tipo;
	}

	public static List<TelefoneDto> converter(List<Telefone> telefones) {
		return telefones.stream().map(TelefoneDto::new).collect(Collectors.toList());
	}
	
	public static Page<TelefoneDto> converter(Page<Telefone> telefones) {
		return telefones.map(TelefoneDto::new);
	}
	
}

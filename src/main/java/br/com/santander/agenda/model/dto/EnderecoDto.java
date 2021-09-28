package br.com.santander.agenda.model.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.santander.agenda.model.Endereco;

public class EnderecoDto {
	
	@JsonProperty("Endereço")
    private String address;
	
	@JsonProperty("Contato")
    private String contactFullName;
	
	public EnderecoDto(String address, String contactFullName) {
		this.address = address;
		this.contactFullName = contactFullName;
	}

	public EnderecoDto(Endereco endereco) {
		this.address = 
			endereco.getRua() + ", " +
			endereco.getNumero() + ", " +
			endereco.getComplemento() + ", " +
			endereco.getBairro() + ". " +
			endereco.getCidade() + "/ " +
			endereco.getEstado() + "/ " +
			endereco.getCep() + ". Tipo: " +
			endereco.getTipo().getDescricao();
		this.contactFullName = endereco.getContato().getNome() + " " + endereco.getContato().getSobrenome();
	}

	public static List<EnderecoDto> converter(List<Endereco> enderecos) {
		return enderecos.stream().map(EnderecoDto::new).collect(Collectors.toList());
	}

}

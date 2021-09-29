package br.com.santander.agenda.model.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.santander.agenda.enumerations.TipoEndereco;
import br.com.santander.agenda.model.Endereco;

public class EnderecoDto {
	
	private String numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String estado;
	private String cep;
	private TipoEndereco tipo;
	
	public EnderecoDto(Endereco endereco) {
		this.numero = endereco.getNumero();
		this.complemento = endereco.getComplemento();
		this.bairro = endereco.getBairro();
		this.cidade = endereco.getCidade();
		this.estado = endereco.getEstado();
		this.cep = endereco.getCep();
		this.tipo = endereco.getTipo();		
	}
	
	public EnderecoDto(String numero, String complemento, String bairro, String cidade, String estado, String cep,
			TipoEndereco tipo) {
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
		this.tipo = tipo;
	}
	
	public String getNumero() {
		return numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEstado() {
		return estado;
	}

	public String getCep() {
		return cep;
	}

	public TipoEndereco getTipo() {
		return tipo;
	}

	public static List<EnderecoDto> converter(List<Endereco> enderecos) {
		return enderecos.stream().map(EnderecoDto::new).collect(Collectors.toList());
	}

}

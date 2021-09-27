package br.com.santander.agenda.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

import br.com.santander.agenda.model.Telefone;

public class TelefoneDto {
	
    private String ddd;
    private String numero;
    private String nome;
    private String sobrenome;
    
    protected TelefoneDto() {}
    
	public TelefoneDto(String ddd, String numero, String nome, String sobrenome) {
		super();
		this.ddd = ddd;
		this.numero = numero;
		this.nome = nome;
		this.sobrenome = sobrenome;
	}
	
	public TelefoneDto(Telefone telefone) {
		super();
		this.ddd = telefone.getDdd();
		this.numero = telefone.getNumero();
		this.nome = telefone.getContato().getNome();
		this.sobrenome = telefone.getContato().getSobrenome();
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	public static List<TelefoneDto> converter(List<Telefone> telefones) {
		return telefones.stream().map(TelefoneDto::new).collect(Collectors.toList());
//		List<TelefoneDto> novosTelefones = new ArrayList<>();
//		for (Telefone telefone : telefones) {
//			novosTelefones.add(new TelefoneDto(
//				telefone.getDdd(), 
//				telefone.getNumero(), 
//				telefone.getContato().getNome(), 
//				telefone.getContato().getSobrenome()));
//		}
//		return novosTelefones;
	}
	
	public static Page<TelefoneDto> converter(Page<Telefone> telefones) {
		return telefones.map(TelefoneDto::new);
	}
	
}

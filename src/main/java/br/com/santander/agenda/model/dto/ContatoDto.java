package br.com.santander.agenda.model.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.santander.agenda.model.Contato;

public class ContatoDto {

	private String nome;
	private String sobrenome;
	private LocalDate dataNascimento;
	private String apelido;

	public ContatoDto(String nome, String sobrenome, LocalDate dataNascimento, String apelido) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.dataNascimento = dataNascimento;
		this.apelido = apelido;
	}
	
	public ContatoDto(Contato contato) {
		this.nome = contato.getNome();
		this.sobrenome = contato.getSobrenome();
		this.dataNascimento = contato.getDataNascimento();
		this.apelido = contato.getApelido();
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public String getApelido() {
		return apelido;
	}

	public Contato converte() {
		return new Contato(nome, sobrenome, dataNascimento, apelido);
	}
	
	public static List<ContatoDto> converter(List<Contato> contatos) {
		return contatos.stream().map(ContatoDto::new).collect(Collectors.toList());
	}

}

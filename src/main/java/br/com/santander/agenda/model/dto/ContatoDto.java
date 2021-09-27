package br.com.santander.agenda.model.dto;

import br.com.santander.agenda.model.Contato;

import java.time.LocalDate;

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

}

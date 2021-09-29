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
	private List<EnderecoDto> enderecos;
	private List<TelefoneDto> telefones;
	private List<EmailDto> emails;

	public ContatoDto(String nome, String sobrenome, LocalDate dataNascimento, String apelido,
		List<EnderecoDto> enderecos, List<TelefoneDto> telefones, List<EmailDto> emails) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.dataNascimento = dataNascimento;
		this.apelido = apelido;
		this.enderecos = enderecos;
		this.telefones = telefones;
		this.emails = emails;
	}
	
	public ContatoDto(Contato contato) {
		this.nome = contato.getNome();
		this.sobrenome = contato.getSobrenome();
		this.dataNascimento = contato.getDataNascimento();
		this.apelido = contato.getApelido();
		this.enderecos = contato.getEnderecos().stream().map(EnderecoDto::new).collect(Collectors.toList());
		this.telefones = contato.getTelefones().stream().map(TelefoneDto::new).collect(Collectors.toList());
		this.emails = contato.getEmails().stream().map(EmailDto::new).collect(Collectors.toList());
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
	
	public List<EnderecoDto> getEnderecos() {
		return enderecos;
	}

	public List<TelefoneDto> getTelefones() {
		return telefones;
	}
	
	public List<EmailDto> getEmails() {
		return emails;
	}

	public static List<ContatoDto> converter(List<Contato> contatos) {
		return contatos.stream().map(ContatoDto::new).collect(Collectors.toList());
	}

}

package br.com.santander.agenda.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Contato implements Serializable {

	private static final long serialVersionUID = 1136960142029299111L;

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull @NotEmpty
	private String nome;
	
	private String sobrenome;
	private LocalDate dataNascimento;
	private String apelido;

	@OneToMany (mappedBy = "contato", cascade = CascadeType.ALL)
	private List<Telefone> telefones = new ArrayList<>();
	
	@OneToMany(mappedBy = "contato",cascade = CascadeType.ALL)
	private List<Endereco> enderecos = new ArrayList<>();
	
	@OneToMany(mappedBy = "contato",cascade = CascadeType.ALL)
	private List<Email> emails = new ArrayList<>();

	protected Contato() {}
	
	public Contato(String nome, String sobrenome, LocalDate dataNascimento, String apelido) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.dataNascimento = dataNascimento;
		this.apelido = apelido;
	}

	public Integer getId() {
		return id;
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

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public List<Email> getEmails() {
		return emails;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		enderecos.forEach(endereco -> adicionaEndereco(endereco));
	}

	public void adicionaEndereco(Endereco endereco) {
		endereco.setContato(this);
		this.enderecos.add(endereco);
	}

	public void setTelefones(List<Telefone> telefones) {
		telefones.forEach(telefone -> adicionaTelefone(telefone));
	}

	public void adicionaTelefone(Telefone telefone) {
		telefone.setContato(this);
		this.telefones.add(telefone);
	}

	public void setEmails(List<Email> emails) {
		emails.forEach(email -> adicionaEmail(email));
	}

	public void adicionaEmail(Email emails) {
		emails.setContato(this);
		this.emails.add(emails);
	}
	
}

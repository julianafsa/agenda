package br.com.santander.agenda.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "endereco")
public class Endereco {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String rua;
	private String numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String estado;
	private String tipo;
	
	@ManyToOne
	private Contato contato;

	public Endereco(String rua, String numero, String complemento, String cidade, String estado, String tipo) {
		this.rua = rua;
		this.complemento = complemento;
		this.numero = numero;
		this.cidade = cidade;
		this.estado = estado;
		this.tipo = tipo;
	}
	
	protected Endereco() {}

	public Integer getId() {
		return id;
	}

	public String getRua() {
		return rua;
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
	
	public String getTipo() {
		return tipo;
	}
	
	public void setContato(Contato contato) {
		this.contato = contato;
	}

}

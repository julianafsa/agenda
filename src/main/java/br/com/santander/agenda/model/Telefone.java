package br.com.santander.agenda.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.santander.agenda.enumerations.TipoTelefone;

@Entity
@Table(name = "telefone")
public class Telefone {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String ddd;
    private String numero;
    private TipoTelefone tipo;
    
    @ManyToOne
    private Contato contato;
    
    protected Telefone() {}

    public Telefone(String ddd, String numero, TipoTelefone tipo, Contato contato) {
        this.ddd = ddd;
    	this.numero = numero;
    	this.tipo = tipo;
    	this.contato = contato;
    }
    
    public Integer getId() {
    	return this.id;
    }    
    
    public String getDdd() {
    	return this.ddd;
    }
    
	public void setDDD(String ddd) {
		this.ddd = ddd;
	}

    public String getNumero() {
    	return this.numero;
    }
    
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
    public TipoTelefone getTipo() {
		return tipo;
	}

	public void setTipo(TipoTelefone tipo) {
		this.tipo = tipo;
	}

	public Contato getContato() {
    	return this.contato;
    }
    
	public void setContato(Contato contato) {
		this.contato = contato;
	}
    
}

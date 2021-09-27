package br.com.santander.agenda.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "telefone")
public class Telefone {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String ddd;
    private String numero;
    
    @ManyToOne
    private Contato contato;
    
    protected Telefone() {}

    public Telefone(String ddd, String numero) {
        this.ddd = ddd;
    	this.numero = numero;
    }
    
    public Integer getId() {
    	return this.id;
    }    
    
    public String getDdd() {
    	return this.ddd;
    }

    public String getNumero() {
    	return this.numero;
    }
    
    public Contato getContato() {
    	return this.contato;
    }
    
	public void setContato(Contato contato) {
		this.contato = contato;
	}
    
}

package br.com.santander.agenda.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "email")
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    @ManyToOne
    private Contato contato;

    protected Email() {}

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

	public void setContato(Contato contato) {
		this.contato = contato;
	}
    
}



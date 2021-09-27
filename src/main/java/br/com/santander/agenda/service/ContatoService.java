package br.com.santander.agenda.service;

import br.com.santander.agenda.model.Contato;

import java.util.List;

public interface ContatoService {

    Contato getContact(Integer id);
    //List<Contato> getByName(String name);
    List<Contato> getAll();
    Contato saveContact(Contato contato);
}

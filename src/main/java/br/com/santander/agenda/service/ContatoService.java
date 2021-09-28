package br.com.santander.agenda.service;

import java.util.List;
import java.util.Optional;

import br.com.santander.agenda.model.Contato;

public interface ContatoService {

    Optional<Contato> getContact(Integer id);
    //List<Contato> getByName(String name);
    List<Contato> getAll();
    Contato saveContact(Contato contato);
}

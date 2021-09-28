package br.com.santander.agenda.service;

import java.util.List;
import java.util.Optional;

import br.com.santander.agenda.model.Telefone;

public interface TelefoneService {

    Optional<Telefone> findById(Integer id);
    List<Telefone> getAll();
    Telefone saveTelefone(Telefone telefone);
    void deleteById(Integer id);
}

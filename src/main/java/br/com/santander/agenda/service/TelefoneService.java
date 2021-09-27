package br.com.santander.agenda.service;

import java.util.List;

import br.com.santander.agenda.model.Telefone;

public interface TelefoneService {

    Telefone getTelefone(Integer id);
    List<Telefone> getAll();
    Telefone saveTelefone(Telefone telefone);
}

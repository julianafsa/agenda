package br.com.santander.agenda.service;

import java.util.List;
import java.util.Optional;

import br.com.santander.agenda.model.Endereco;

public interface EnderecoService {

    Optional<Endereco> findById(Integer id);
    List<Endereco> getAll();
    Endereco saveEndereco(Endereco telefone);
    void deleteById(Integer id);
}

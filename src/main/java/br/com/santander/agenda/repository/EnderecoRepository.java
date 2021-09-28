package br.com.santander.agenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.santander.agenda.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
}

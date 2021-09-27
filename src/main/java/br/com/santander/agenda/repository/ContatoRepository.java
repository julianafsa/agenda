package br.com.santander.agenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.santander.agenda.model.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Integer> {
	
}

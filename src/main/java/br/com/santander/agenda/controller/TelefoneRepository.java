package br.com.santander.agenda.controller;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.santander.agenda.model.Telefone;

public interface TelefoneRepository extends JpaRepository<Telefone, Integer> {
}

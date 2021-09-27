package br.com.santander.agenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.santander.agenda.model.Email;

public interface EmailRepository extends JpaRepository<Email, Integer> {
}

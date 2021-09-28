package br.com.santander.agenda.service;

import java.util.List;
import java.util.Optional;

import br.com.santander.agenda.model.Email;

public interface EmailService {

    Optional<Email> getEmail(Integer id);
    List<Email> getAll();
    Email saveEmail(Email contato);
    void deleteById(Integer id);
}

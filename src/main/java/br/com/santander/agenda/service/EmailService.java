package br.com.santander.agenda.service;

import java.util.List;

import br.com.santander.agenda.model.Email;

public interface EmailService {

    Email getEmail(Integer id);
    List<Email> getAll();
    Email saveEmail(Email contato);
}

package br.com.santander.agenda.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import br.com.santander.agenda.model.Contato;

public interface ContatoService {

    Optional<Contato> getContact(Integer id);
    List<Contato> getAll();
    Contato saveContact(Contato contato);
    void deleteById(Integer id);
    List<Contato> searchByContato(String nome, String sobrenome, LocalDate dataNascimento, String apelido);
	String updatePhoto(MultipartFile file);
}

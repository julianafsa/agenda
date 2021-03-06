package br.com.santander.agenda.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.santander.agenda.model.Contato;
import br.com.santander.agenda.repository.ContatoRepository;
import br.com.santander.agenda.service.ContatoService;

@Service
public class ContatoServiceImpl implements ContatoService {

    ContatoRepository repository;
    
    public ContatoServiceImpl(ContatoRepository contatoRepository) {
        this.repository = contatoRepository;
    }

    @Override
    public Optional<Contato> getContact(Integer id){
        return repository.findById(id);
    }
    
    @Override
    public List<Contato> getAll(){
        return repository.findAll();
    }

    @Override
    public Contato saveContact(Contato contato) {
        return repository.save(contato);
    }

	@Override
	public List<Contato> searchByContato(String nome, String sobrenome, LocalDate dataNascimento, String apelido) {
		return repository.searchByContato(nome, sobrenome, dataNascimento, apelido);
	}

	@Override
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}

}

package br.com.santander.agenda.service.impl;

import java.util.List;

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
    public Contato getContact(Integer id){
        return repository.getById(id);
    }
    
    @Override
    public List<Contato> getAll(){
        return repository.findAll();
    }

    @Override
    public Contato saveContact(Contato contato) {
        return repository.save(contato);
    }

}
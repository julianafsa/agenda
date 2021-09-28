package br.com.santander.agenda.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.santander.agenda.model.Email;
import br.com.santander.agenda.repository.EmailRepository;
import br.com.santander.agenda.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService {

    EmailRepository repository;
    
    public EmailServiceImpl(EmailRepository contatoRepository) {
        this.repository = contatoRepository;
    }

    @Override
    public Optional<Email> getEmail(Integer id){
        return repository.findById(id);
    }
    
    @Override
    public List<Email> getAll(){
        return repository.findAll();
    }

    @Override
    public Email saveEmail(Email email) {
        return repository.save(email);
    }

	@Override
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public List<Email> searchByEmail(String email) {
		return repository.searchByEmail(email);
	}

}

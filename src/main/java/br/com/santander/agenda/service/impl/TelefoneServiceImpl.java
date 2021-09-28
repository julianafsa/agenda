package br.com.santander.agenda.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.santander.agenda.model.Telefone;
import br.com.santander.agenda.repository.TelefoneRepository;
import br.com.santander.agenda.service.TelefoneService;

@Service
public class TelefoneServiceImpl implements TelefoneService {

    TelefoneRepository repository;
    
    public TelefoneServiceImpl(TelefoneRepository repository) {
        this.repository = repository;
    }

	@Override
	public Optional<Telefone> findById(Integer id) {
		return repository.findById(id);
	}

	@Override
	public List<Telefone> getAll() {
		return repository.findAll();
	}

	@Override
	public Telefone saveTelefone(Telefone telefone) {
		return repository.save(telefone);
	}

	@Override
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}

}

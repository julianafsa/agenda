package br.com.santander.agenda.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.santander.agenda.controller.TelefoneRepository;
import br.com.santander.agenda.model.Telefone;
import br.com.santander.agenda.service.TelefoneService;

@Service
public class TelefoneServiceImpl implements TelefoneService {

    TelefoneRepository repository;

    public TelefoneServiceImpl(TelefoneRepository telefoneRepository) {
        this.repository = telefoneRepository;
    }

	@Override
	public Telefone getTelefone(Integer id) {
        return repository.getById(id);
	}

	@Override
	public List<Telefone> getAll() {
        return repository.findAll();
	}

	@Override
	public Telefone saveTelefone(Telefone telefone) {
        return repository.save(telefone);
	}



}

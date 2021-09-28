package br.com.santander.agenda.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.santander.agenda.model.Endereco;
import br.com.santander.agenda.repository.EnderecoRepository;
import br.com.santander.agenda.service.EnderecoService;

@Service
public class EnderecoServiceImpl implements EnderecoService {

    EnderecoRepository repository;
    
    public EnderecoServiceImpl(EnderecoRepository repository) {
        this.repository = repository;
    }

	@Override
	public Optional<Endereco> findById(Integer id) {
		return repository.findById(id);
	}

	@Override
	public List<Endereco> getAll() {
		return repository.findAll();
	}

	@Override
	public Endereco saveEndereco(Endereco endereco) {
		return repository.save(endereco);
	}

	@Override
	public void deleteById(Integer id) {
		repository.deleteById(id);
	}

}

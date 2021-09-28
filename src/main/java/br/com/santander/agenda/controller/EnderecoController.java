package br.com.santander.agenda.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.santander.agenda.model.Endereco;
import br.com.santander.agenda.model.dto.EnderecoDto;
import br.com.santander.agenda.model.form.AtualizacaoEnderecoForm;
import br.com.santander.agenda.model.form.EnderecoForm;
import br.com.santander.agenda.service.ContatoService;
import br.com.santander.agenda.service.EnderecoService;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    private EnderecoService service;
    
    private ContatoService contatoService;

    public EnderecoController(EnderecoService service, ContatoService contatoService) {
        this.service = service;
        this.contatoService = contatoService;
    }

	@GetMapping
	public List<EnderecoDto> listar() {
		List<Endereco> enderecos = service.getAll();
		return EnderecoDto.converter(enderecos);
	}
    
    @GetMapping("/{id}")
    public ResponseEntity<EnderecoDto> getEnderecoById(@PathVariable Integer id){
    	Optional<Endereco> endereco = service.findById(id);
		if (endereco.isPresent()) {
			return ResponseEntity.ok(new EnderecoDto(endereco.get()));
		}
		return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<EnderecoDto> salvar(@RequestBody @Valid EnderecoForm form, UriComponentsBuilder uriBuilder)  {
		Endereco endereco = form.converter(contatoService);
		if (endereco != null) {
			service.saveEndereco(endereco);
	        URI uri = UriComponentsBuilder.fromPath("telefone").buildAndExpand(endereco.getId()).toUri();
	        return ResponseEntity.created(uri).body(new EnderecoDto(endereco));
		}
		return ResponseEntity.badRequest().build();
    }
    
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<EnderecoDto> atualizar(@PathVariable Integer id, @RequestBody @Valid AtualizacaoEnderecoForm form) {
		Optional<Endereco> optional = service.findById(id);
		if (optional.isPresent()) {
			Endereco endereco = form.atualizar(id, service);
			return ResponseEntity.ok(new EnderecoDto(endereco));
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Integer id) {
		Optional<Endereco> optional = service.findById(id);
		if (optional.isPresent()) {
			service.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
    
    
}

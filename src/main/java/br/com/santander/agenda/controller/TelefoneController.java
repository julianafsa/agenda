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

import br.com.santander.agenda.model.Telefone;
import br.com.santander.agenda.model.dto.TelefoneDto;
import br.com.santander.agenda.model.form.AtualizacaoTelefoneForm;
import br.com.santander.agenda.model.form.TelefoneForm;
import br.com.santander.agenda.service.ContatoService;
import br.com.santander.agenda.service.TelefoneService;

@RestController
@RequestMapping("/telefones")
public class TelefoneController {

    private TelefoneService service;
    
    private ContatoService contatoService;

    public TelefoneController(TelefoneService service, ContatoService contatoService) {
        this.service = service;
        this.contatoService = contatoService;
    }

	@GetMapping
	public List<TelefoneDto> listar() {
		List<Telefone> telefones = service.getAll();
		return TelefoneDto.converter(telefones);
	}
    
    @GetMapping("/{id}")
    public ResponseEntity<TelefoneDto> getTelefoneById(@PathVariable Integer id){
    	Optional<Telefone> telefone = service.findById(id);
		if (telefone.isPresent()) {
			return ResponseEntity.ok(new TelefoneDto(telefone.get()));
		}
		return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<TelefoneDto> salvar(@RequestBody @Valid TelefoneForm form, UriComponentsBuilder uriBuilder)  {
		Telefone telefone = form.converter(contatoService);
		if (telefone != null) {
			service.saveTelefone(telefone);
	        URI uri = UriComponentsBuilder.fromPath("telefone").buildAndExpand(telefone.getId()).toUri();
	        return ResponseEntity.created(uri).body(new TelefoneDto(telefone));
		}
		return ResponseEntity.badRequest().build();
    }
    
//    @PostMapping
//    public ResponseEntity<Telefone> salvar(@RequestBody @Valid TelefoneForm form, UriComponentsBuilder uriBuilder)  {
//		Telefone telefone = form.converter(contatoService);
//		if (telefone != null) {
//			service.saveTelefone(telefone);
//	        URI uri = UriComponentsBuilder.fromPath("telefone").buildAndExpand(telefone.getId()).toUri();
//	        return ResponseEntity.created(uri).body(telefone);
//		}
//		return ResponseEntity.badRequest().build();
//    }
    
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<TelefoneDto> atualizar(@PathVariable Integer id, @RequestBody @Valid AtualizacaoTelefoneForm form) {
		Optional<Telefone> optional = service.findById(id);
		if (optional.isPresent()) {
			Telefone telefone = form.atualizar(id, service);
			return ResponseEntity.ok(new TelefoneDto(telefone));
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Integer id) {
		Optional<Telefone> optional = service.findById(id);
		if (optional.isPresent()) {
			service.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
    
    
}

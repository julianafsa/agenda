package br.com.santander.agenda.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.santander.agenda.model.Contato;
import br.com.santander.agenda.model.dto.ContatoDto;
import br.com.santander.agenda.service.ContatoService;
import io.swagger.annotations.Api;

@Api(tags = "Contatos")
@RestController
@RequestMapping("/contatos")
public class ContatoController {

    private ContatoService service;
    
    @Value("${file.upload.dir}")
    private String dir;

    public ContatoController(ContatoService contatoService) {
        this.service = contatoService;
    }

    @GetMapping
    public ResponseEntity<List<ContatoDto>> listar() {
    	List<Contato> contatos = service.getAll();
        return ResponseEntity.ok(ContatoDto.converter(contatos));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Contato>> getContactById(@PathVariable Integer id){
        return ResponseEntity.ok(service.getContact(id));
    }

    @PostMapping
    public ResponseEntity<Contato> saveContact(@RequestBody @Valid Contato contato)  {
		List<Contato> contatos = service.searchByContato(contato.getNome(), contato.getSobrenome(), 
			contato.getDataNascimento(), contato.getApelido());
		if (!contatos.isEmpty()) {
			System.out.println("Cannot save duplicate contact.");
			return ResponseEntity.badRequest().build();
		}
    	
        Contato retorno = service.saveContact(contato);
        URI uri = UriComponentsBuilder.fromPath("contato/{id}").buildAndExpand(contato.getId()).toUri();
        return ResponseEntity.created(uri).body(retorno);
    }
    
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Integer id) {
		Optional<Contato> optional = service.getContact(id);
		if (optional.isPresent()) {
			service.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/photo/{id}")
	@Transactional
	public ResponseEntity<?> uploadPhoto(@PathVariable Integer id, @RequestBody MultipartFile file) {
		Optional<Contato> optional = service.getContact(id);
		if (optional.isPresent()) {
			if (file != null ) {
				return ResponseEntity.ok().body(service.updatePhoto(file));				
			} else {
				return ResponseEntity.badRequest().body("Foto não anexada");	
			}
		}
		return ResponseEntity.notFound().build();

	}
}

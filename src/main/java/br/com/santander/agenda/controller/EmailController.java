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

import br.com.santander.agenda.model.Email;
import br.com.santander.agenda.model.dto.EmailDto;
import br.com.santander.agenda.model.form.AtualizacaoEmailForm;
import br.com.santander.agenda.model.form.EmailForm;
import br.com.santander.agenda.service.ContatoService;
import br.com.santander.agenda.service.EmailService;

@RestController
@RequestMapping("/emails")
public class EmailController {

    private EmailService service;
    
    private ContatoService contatoService;

    public EmailController(EmailService service, ContatoService contatoService) {
        this.service = service;
        this.contatoService = contatoService;
    }

    @GetMapping
    public ResponseEntity<List<EmailDto>> listar() {
		List<Email> emails = service.getAll();
		return ResponseEntity.ok(EmailDto.converter(emails));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<EmailDto> getEmailById(@PathVariable Integer id){
    	Optional<Email> email = service.getEmail(id);
		if (email.isPresent()) {
			return ResponseEntity.ok(new EmailDto(email.get()));
		}
		return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<EmailDto> saveTelefone(@RequestBody @Valid EmailForm form, UriComponentsBuilder uriBuilder)  {
		Email email = form.converter(contatoService);
		if (email != null) {
			service.saveEmail(email);
	        URI uri = UriComponentsBuilder.fromPath("email").buildAndExpand(email.getId()).toUri();
	        return ResponseEntity.created(uri).body(new EmailDto(email));
		}
		return ResponseEntity.badRequest().build();        
    }
    
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<EmailDto> atualizar(@PathVariable Integer id, @RequestBody @Valid AtualizacaoEmailForm form) {
		Optional<Email> optional = service.getEmail(id);
		if (optional.isPresent()) {
			Email email = form.atualizar(id, service);
			return ResponseEntity.ok(new EmailDto(email));
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Integer id) {
		Optional<Email> optional = service.getEmail(id);
		if (optional.isPresent()) {
			service.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}    
    
    
}

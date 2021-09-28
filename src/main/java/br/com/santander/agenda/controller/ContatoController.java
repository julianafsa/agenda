package br.com.santander.agenda.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.santander.agenda.model.Contato;
import br.com.santander.agenda.service.ContatoService;

@RestController
@RequestMapping("/contatos")
public class ContatoController {

    private ContatoService contactService;

    public ContatoController(ContatoService contatoService) {
        this.contactService = contatoService;
    }

    @GetMapping
    public ResponseEntity<List<Contato>> listar() {
    	List<Contato> contatos = contactService.getAll();
        return ResponseEntity.ok(contatos);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Contato>> getContactById(@PathVariable Integer id){
        return ResponseEntity.ok(contactService.getContact(id));
    }

    @PostMapping
    public ResponseEntity<Contato> saveContact(@RequestBody @Valid Contato contato)  {
        Contato retorno = contactService.saveContact(contato);
        URI uri = UriComponentsBuilder.fromPath("contato/{id}").buildAndExpand(contato.getId()).toUri();
        return ResponseEntity.created(uri).body(retorno);
    }
}

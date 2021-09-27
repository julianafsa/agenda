package br.com.santander.agenda.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.santander.agenda.model.Email;
import br.com.santander.agenda.service.EmailService;

@RestController
@RequestMapping("/email")
public class EmailController {

    private EmailService service;

    public EmailController(EmailService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Email>> listTelefones(){
        return ResponseEntity.ok(service.getAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Email> getEmailById(@PathVariable Integer id){
        return ResponseEntity.ok(service.getEmail(id));
    }

    @PostMapping
    public ResponseEntity<Email> saveTelefone(@RequestBody Email email)  {
        Email retorno = service.saveEmail(email);
        URI uri = UriComponentsBuilder.fromPath("telefone/{id}").buildAndExpand(email.getId()).toUri();
        return ResponseEntity.created(uri).body(retorno);
    }
}

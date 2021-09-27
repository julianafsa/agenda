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

import br.com.santander.agenda.controller.dto.TelefoneDto;
import br.com.santander.agenda.model.Telefone;
import br.com.santander.agenda.service.TelefoneService;

@RestController
@RequestMapping("/telefones")
public class TelefoneController {

    private TelefoneService service;

    public TelefoneController(TelefoneService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Telefone>> listTelefones(){
        return ResponseEntity.ok(service.getAll());
    }
    
	@GetMapping
	public List<TelefoneDto> listar() {
		List<Telefone> telefones = service.getAll();
		return TelefoneDto.converter(telefones);
	}
    
    @GetMapping("/{id}")
    public ResponseEntity<Telefone> getTelefoneById(@PathVariable Integer id){
        return ResponseEntity.ok(service.getTelefone(id));
    }

    @PostMapping
    public ResponseEntity<Telefone> saveTelefone(@RequestBody Telefone telefone)  {
        Telefone retorno = service.saveTelefone(telefone);
        URI uri = UriComponentsBuilder.fromPath("telefone/{id}").buildAndExpand(telefone.getId()).toUri();
        return ResponseEntity.created(uri).body(retorno);
    }
}

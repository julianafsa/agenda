package br.com.santander.agenda.model.form;

import java.util.Optional;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import br.com.santander.agenda.enumerations.TipoTelefone;
import br.com.santander.agenda.model.Contato;
import br.com.santander.agenda.model.Telefone;
import br.com.santander.agenda.service.ContatoService;

public class TelefoneForm {
	
	@Length(min = 2, max = 2)
	@NotBlank(message = "Field must not be missing or null")
    private String ddd;
	
	@Size(min = 8, max = 9)
	@NotBlank(message = "Field must not be missing or null")
    private String numero;
	
//	@Size(min = 0, max = 3)
//	@NotBlank(message = "Field must not be missing or null")
    private TipoTelefone tipo;
	
	@Min(value = 1)
	@NotBlank(message = "Field must not be missing or null")
	private String idContato;
	
	public String getDdd() {
		return ddd;
	}

	public String getNumero() {
		return numero;
	}

	public TipoTelefone getTipo() {
		return tipo;
	}

	public String getIdContato() {
		return idContato;
	}

	public Telefone converter(ContatoService contatoService) {
		Optional<Contato> contato = contatoService.getContact(Integer.parseInt(this.idContato));
		if (!contato.isPresent())
			return null;
		return new Telefone(this.ddd, this.numero, this.tipo, contato.get());
	}

}

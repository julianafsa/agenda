package br.com.santander.agenda.model.form;

import java.util.Optional;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.santander.agenda.enumerations.TipoTelefone;
import br.com.santander.agenda.model.Telefone;
import br.com.santander.agenda.service.TelefoneService;

public class AtualizacaoTelefoneForm {
	
	@NotNull @NotEmpty @Size(min = 2, max = 2)
    private String ddd;
	
	@NotNull @NotEmpty @Size(min = 8, max = 9)
    private String numero;
	
//	@Size(min = 0, max = 3)
	@NotBlank(message = "Field must not be missing or null")
    private TipoTelefone tipo;
    
	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public TipoTelefone getTipo() {
		return tipo;
	}

	public void setTipo(TipoTelefone tipo) {
		this.tipo = tipo;
	}

	public Telefone atualizar(Integer id, TelefoneService service) {
		Optional<Telefone> optional = service.findById(id);
		if (optional.isPresent()) {
			Telefone telefone = optional.get();
			telefone.setDDD(this.ddd);
			telefone.setNumero(this.numero);
			telefone.setTipo(this.tipo);
			return telefone;			
		}
		return null;
	}

}

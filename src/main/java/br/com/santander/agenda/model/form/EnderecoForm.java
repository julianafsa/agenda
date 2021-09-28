package br.com.santander.agenda.model.form;

import java.util.Optional;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import br.com.santander.agenda.enumerations.TipoEndereco;
import br.com.santander.agenda.model.Contato;
import br.com.santander.agenda.model.Endereco;
import br.com.santander.agenda.service.ContatoService;

public class EnderecoForm {
	
	@NotBlank(message = "Field must not be missing or null")
	private String rua;
	
	@NotBlank(message = "Field must not be missing or null")
	private String numero;
	
	private String complemento;
	
	@NotBlank(message = "Field must not be missing or null")
	private String bairro;
	
	@NotBlank(message = "Field must not be missing or null")
	private String cidade;
	
	@Length(min = 2, max = 2)
	@NotBlank(message = "Field must not be missing or null")
	private String estado;
	
	@NotBlank(message = "Field must not be missing or null")
	private String cep;
	
	private TipoEndereco tipo;
	
	@Min(value = 1)
	@NotBlank(message = "Field must not be missing or null")
	private String idContato;
	
	public String getRua() {
		return rua;
	}

	public String getNumero() {
		return numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEstado() {
		return estado;
	}
	
	public String getCep() {
		return cep;
	}

	public TipoEndereco getTipo() {
		return tipo;
	}

	public String getIdContato() {
		return idContato;
	}

	public Endereco converter(ContatoService contatoService) {
		Optional<Contato> contato = contatoService.getContact(Integer.parseInt(this.idContato));
		if (!contato.isPresent())
			return null;
		return new Endereco(
			this.rua, 
			this.numero, 
			this.complemento, 
			this.bairro,
			this.cidade, 
			this.estado,
			this.cep,
			this.tipo,
			contato.get());
	}

}

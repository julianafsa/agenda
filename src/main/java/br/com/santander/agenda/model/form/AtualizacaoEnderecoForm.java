package br.com.santander.agenda.model.form;

import java.util.Optional;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import br.com.santander.agenda.enumerations.TipoEndereco;
import br.com.santander.agenda.model.Endereco;
import br.com.santander.agenda.service.EnderecoService;

public class AtualizacaoEnderecoForm {
	
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

	public Endereco atualizar(Integer id, EnderecoService service) {
		Optional<Endereco> optional = service.findById(id);
		if (optional.isPresent()) {
			Endereco endereco = optional.get();
			endereco.setRua(this.rua); 
			endereco.setNumero(numero); 
			endereco.setComplemento(complemento);
			endereco.setBairro(bairro);
			endereco.setCidade(cidade);
			endereco.setEstado(estado);
			endereco.setCep(cep);
			endereco.setTipo(tipo);
			return endereco;			
		}
		return null;
	}

}

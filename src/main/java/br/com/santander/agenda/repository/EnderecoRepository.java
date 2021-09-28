package br.com.santander.agenda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.santander.agenda.enumerations.TipoEndereco;
import br.com.santander.agenda.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
	
	String query = "SELECT e FROM Endereco e "
			+ "WHERE e.rua = ?1 "
			+ "AND e.numero = ?2 "
			+ "AND e.complemento = ?3 "
			+ "AND e.bairro = ?4 "
			+ "AND e.cidade = ?5 "
			+ "AND e.estado = ?6 "
			+ "AND e.cep = ?7 "
			+ "AND e.tipo = ?8 "
			+ "AND e.contato.id IN (SELECT c FROM Contato c WHERE c.id = ?9)";
	@Query(value = query, nativeQuery = false)
	List<Endereco> searchByEndereco(
		String rua, 
		String numero,
		String complemento, 
		String bairro, 
		String cidade,
		String estado, 
		String cep, 
		TipoEndereco tipo, 
		Integer idContato);
	
}

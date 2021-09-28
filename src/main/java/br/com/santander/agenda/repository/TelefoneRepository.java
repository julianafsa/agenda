package br.com.santander.agenda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.santander.agenda.model.Telefone;

public interface TelefoneRepository extends JpaRepository<Telefone, Integer> {
	
	String query = "SELECT t FROM Telefone t WHERE "
			+ "t.ddd = ?1 "
			+ "AND t.numero = ?2 "
			+ "AND t.contato.id IN (SELECT c FROM Contato c WHERE c.id = ?3)";
	@Query(value = query, nativeQuery = false)
	List<Telefone> searchByTelefone(String ddd, String numero, Integer idContato);

}
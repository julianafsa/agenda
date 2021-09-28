package br.com.santander.agenda.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.santander.agenda.model.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Integer> {
	
	String query = "SELECT c FROM Contato c WHERE "
			+ "c.nome = ?1 "
			+ "AND c.sobrenome = ?2 "
			+ "AND c.dataNascimento = ?3 "
			+ "AND c.apelido = ?4";
	@Query(value = query, nativeQuery = false)
	List<Contato> searchByContato(String nome, String sobrenome, LocalDate dataNascimento, String apelido);
	
}

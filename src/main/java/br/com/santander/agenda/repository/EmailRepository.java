package br.com.santander.agenda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.santander.agenda.model.Email;

public interface EmailRepository extends JpaRepository<Email, Integer> {
	
	String query = "SELECT e FROM Email e WHERE e.email = ?1";
	@Query(value = query, nativeQuery = false)
	List<Email> searchByEmail(String email);
	
}

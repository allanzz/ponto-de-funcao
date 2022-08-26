package br.com.allan.pontodefuncao.util.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.allan.pontodefuncao.classes.Recurso;

public interface RecursoRepository extends JpaRepository<Recurso,Integer> {
	public Recurso findByUsername(String username);

}

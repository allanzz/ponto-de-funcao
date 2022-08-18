package br.com.allan.pontodefuncao.util.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.allan.pontodefuncao.classes.Projeto;

public interface ProjetoRepository extends JpaRepository<Projeto, Integer> {

}

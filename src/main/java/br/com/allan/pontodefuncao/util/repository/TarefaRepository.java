package br.com.allan.pontodefuncao.util.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.allan.pontodefuncao.classes.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Integer> {

}

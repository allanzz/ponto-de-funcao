package br.com.allan.pontodefuncao.util.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.allan.pontodefuncao.classes.TiposFuncoes.Funcao;

public interface FuncaoRepository extends JpaRepository<Funcao, Integer> {

}

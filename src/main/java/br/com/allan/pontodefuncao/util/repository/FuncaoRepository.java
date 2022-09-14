package br.com.allan.pontodefuncao.util.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.allan.pontodefuncao.classes.TiposFuncoes.Funcao;

public interface FuncaoRepository extends JpaRepository<Funcao, Integer> {
	public List<Funcao> findByDataConclusaoBetween(Date start,Date end);

	public List<Funcao> findByStatus(String string);
}

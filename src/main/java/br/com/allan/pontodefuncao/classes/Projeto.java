package br.com.allan.pontodefuncao.classes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Projeto {
	private int id;
	private String descricao;
	private String responsavel;
	private Date dataInicio;
	private List<Tarefa> tarefas;
	public Projeto() {
		tarefas=new ArrayList<>();
	}

}

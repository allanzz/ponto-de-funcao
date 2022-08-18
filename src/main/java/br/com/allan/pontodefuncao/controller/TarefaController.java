package br.com.allan.pontodefuncao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.allan.pontodefuncao.classes.Projeto;
import br.com.allan.pontodefuncao.classes.Tarefa;
import br.com.allan.pontodefuncao.util.repository.TarefaRepository;

@Controller
public class TarefaController {
	@Autowired
	TarefaRepository tarefaRep;
	@GetMapping("/cadastra-tarefa")
	public String exibeCadastroRecurso() {		
		return "/projetos/cadastrar-projeto";		
	}
	@PostMapping("/adiciona-tarefa")
	public ModelAndView salvar(Tarefa tarefa) {
		System.out.println("Tarefa:"+tarefa);
		Tarefa tarefaSalva = tarefaRep.save(tarefa);
		ModelAndView mv = new ModelAndView("redirect:/cadastrar-projeto");
		mv.addObject("nome-da-tarefa", tarefaSalva.getDescricao());
		return mv;
		
		
	}

}

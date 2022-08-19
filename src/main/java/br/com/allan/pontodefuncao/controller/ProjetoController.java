package br.com.allan.pontodefuncao.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.allan.pontodefuncao.classes.CategoriaTarefa;
import br.com.allan.pontodefuncao.classes.Projeto;
import br.com.allan.pontodefuncao.classes.Tarefa;
import br.com.allan.pontodefuncao.util.repository.CategoriaTarefaRepository;
import br.com.allan.pontodefuncao.util.repository.ProjetoRepository;
import br.com.allan.pontodefuncao.util.repository.TarefaRepository;

@Controller
public class ProjetoController {
	@Autowired
	ProjetoRepository projetoRep;
	@Autowired
	CategoriaTarefaRepository categoriaRepository;
	@Autowired
	TarefaRepository tarefaRepository;
	@GetMapping("/cadastra-projeto")
	public String exibeCadastroProjeto() {		
		return "/projetos/cadastrar-projeto";		
	}
	@PostMapping("/adiciona-projeto")
	public ModelAndView salvarProjeto(Projeto projeto) {
		System.out.println("Projeto:"+projeto);
		Projeto projetoSalvo = projetoRep.save(projeto);
		ModelAndView mv = new ModelAndView("redirect:/cadastra-projeto");
		mv.addObject("descricao", projetoSalvo.getDescricao());
		return mv;		
	}
	@GetMapping("/detalhe-projeto/{id}")
	public ModelAndView exibeDetalhesProjeto(@PathVariable int id) {
		Optional<Projeto> projeto = projetoRep.findById(id);
		List<CategoriaTarefa> categorias = categoriaRepository.findAll();		
		if(projeto.isPresent()) {
		ModelAndView mv = new ModelAndView("/projetos/detalhe-projeto");
		mv.addObject("projeto",projeto.get());
		mv.addObject("categorias", categorias);	
		System.out.println(projeto.get().getTarefas().toString());
		return mv;
		}else {
			return new ModelAndView("/listar-projeto");
		}
	}
	@GetMapping("/listar-projetos")
	public ModelAndView listarRecursos() {
		List<Projeto> projetos = projetoRep.findAll();
		ModelAndView mv = new ModelAndView("/projetos/listarProjeto");
		mv.addObject("projetos", projetos);
		return mv;
	}
	@PostMapping("/adiciona-tarefa/{id}")
	public ModelAndView adicionaTarefa(@PathVariable int id,Tarefa tarefa) {
		System.out.println("Tarefa: "+tarefa);
		Optional<Projeto> projeto = projetoRep.findById(id);
		if(projeto.isPresent()) {
			tarefa.setProjeto(projeto.get());
			projeto.get().adicionarTarefa(tarefa);
			projetoRep.save(projeto.get());
			String url = "/detalhe-projeto/"+projeto.get().getId();
			ModelAndView mv = new ModelAndView("redirect:"+url);
			System.out.println(projeto.get().toString());
			mv.addObject("descricao", projeto.get().getDescricao());
			return mv;		
		}else {
			return null;
		}
	}

}

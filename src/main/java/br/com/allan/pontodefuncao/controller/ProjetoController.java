package br.com.allan.pontodefuncao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.allan.pontodefuncao.classes.Projeto;
import br.com.allan.pontodefuncao.util.repository.ProjetoRepository;

@Controller
public class ProjetoController {
	@Autowired
	ProjetoRepository projetoRep;
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
	public String exibeDetalhesProjeto() {		
		return "/projetos/cadastrar-projeto";		
	}

}

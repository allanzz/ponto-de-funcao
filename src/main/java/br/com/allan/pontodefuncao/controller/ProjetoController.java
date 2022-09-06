package br.com.allan.pontodefuncao.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.allan.pontodefuncao.classes.Deflator;
import br.com.allan.pontodefuncao.classes.Projeto;
import br.com.allan.pontodefuncao.util.repository.DeflatorRepository;
import br.com.allan.pontodefuncao.util.repository.FuncaoRepository;
import br.com.allan.pontodefuncao.util.repository.ProjetoRepository;


@Controller
public class ProjetoController {
	@Autowired
	ProjetoRepository projetoRep;
	@Autowired
	DeflatorRepository deflatorRep;
	
	@Autowired
	FuncaoRepository funcaoRepository;
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
		 List<Deflator> deflatores = new ArrayList<>();
		 deflatores = deflatorRep.findAll();
		 System.out.println(deflatores.get(0).getDescricao());
		Optional<Projeto> projeto = projetoRep.findById(id);
		if(projeto.isPresent()) {
		ModelAndView mv = new ModelAndView("/projetos/detalhe-projeto");
		mv.addObject("projeto",projeto.get());
		mv.addObject("deflatores",deflatores);
		return mv;
		}else {
			return new ModelAndView("/listar-projeto");
		}
	}
	
	@GetMapping("/listar-projetos")
	public ModelAndView listarProjetos() {
		List<Projeto> projetos = projetoRep.findAll();
		ModelAndView mv = new ModelAndView("/projetos/listarProjeto");
		mv.addObject("projetos", projetos);
		return mv;
	}
	@GetMapping("/excluir-projeto/{id}")
	public ModelAndView excluirProjeto(@PathVariable int id) {
		projetoRep.deleteById(id);
		ModelAndView mv = new ModelAndView("redirect:/listar-projetos");
		return mv;
	}
	

}

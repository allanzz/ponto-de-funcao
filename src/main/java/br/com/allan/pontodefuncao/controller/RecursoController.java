package br.com.allan.pontodefuncao.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.allan.pontodefuncao.classes.Recurso;
import br.com.allan.pontodefuncao.util.repository.RecursoRepository;

@Controller
public class RecursoController {
	@Autowired
	RecursoRepository recursoRepository;
	
	//Salva Recurso no banco
	@PostMapping("/adiciona-recurso")
	public ModelAndView salvar(Recurso recurso) {
		System.out.println("Recurso:"+recurso);
		Recurso recursoSalvo = recursoRepository.save(recurso);
		ModelAndView mv = new ModelAndView("redirect:/cadastra-recurso");
		mv.addObject("username", recursoSalvo.getNome());
		return mv;		
	}
	
	//Exibe tela de cadastro de recurso
	@GetMapping("/cadastra-recurso")
	public String exibeCadastroRecurso() {		
		return "/recursos/cadastrar-recurso";		
	}
	
	//Exibe tela de listagem de produtos
	@GetMapping("/listar-recursos")
	public ModelAndView listarRecursos() {
		List<Recurso> recursos = recursoRepository.findAll();
		ModelAndView mv = new ModelAndView("/recursos/listarRecursos");
		mv.addObject("recursos", recursos);
		return mv;
	}
	
	//Remove recursos
	@GetMapping("/remove-recurso/{id}")
	public String removeRecurso(@PathVariable int id) {
		recursoRepository.deleteById(id);
		return "redirect:/listar-recursos";
		
	}
	//retorna tela com detalhes do recursos
		@GetMapping("/detalhe-recurso/{id}")
		public ModelAndView detalheRecurso(@PathVariable int id) {
			Optional<Recurso> recurso = recursoRepository.findById(id);
			ModelAndView mv = new ModelAndView("/recursos/detalhe-recurso");
			mv.addObject("recurso", recurso);
			return mv;
			
			
		}

}

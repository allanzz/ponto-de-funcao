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
import br.com.allan.pontodefuncao.classes.Recurso;
import br.com.allan.pontodefuncao.util.repository.CategoriaTarefaRepository;

@Controller
public class CategoriaTarefaController {
		@Autowired
		CategoriaTarefaRepository categoriaRepository;
	//Salva Recurso no banco
		@PostMapping("/adiciona-categoria")
		public ModelAndView salvar(CategoriaTarefa categoria) {
			CategoriaTarefa categoriaSalva= categoriaRepository.save(categoria);
			ModelAndView mv = new ModelAndView("redirect:/cadastra-categoria");
			mv.addObject("nome", categoriaSalva.getDescricao());
			return mv;		
		}
		
		//Exibe tela de cadastro de recurso
		@GetMapping("/cadastra-categoria")
		public String exibeCadastroRecurso() {		
			return "/categorias/cadastrar-categoria";		
		}
		
		//Exibe tela de listagem de produtos
		@GetMapping("/listar-categorias")
		public ModelAndView listarRecursos() {
			List<CategoriaTarefa> categorias = categoriaRepository.findAll();
			System.out.println(categorias.toString());
			ModelAndView mv = new ModelAndView("/categorias/listarCategorias");
			mv.addObject("categorias", categorias);
			return mv;
		}
		
		//Remove recursos
		@GetMapping("/remove-categoria/{id}")
		public String removeRecurso(@PathVariable int id) {
			categoriaRepository.deleteById(id);
			return "redirect:/listar-categorias";
			
		}		


}

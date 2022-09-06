package br.com.allan.pontodefuncao.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.allan.pontodefuncao.classes.Usuario;
import br.com.allan.pontodefuncao.util.repository.UsuarioRepository;

@Controller
public class UsuarioController {
	@Autowired
	UsuarioRepository usuarioRepository;

	// Salva Recurso no banco

	@PostMapping("/novo-usuario")
	public ModelAndView salvar(Usuario usuario) {
		System.out.println("Recurso:" + usuario);
		Usuario usuarioSalvo = usuarioRepository.save(usuario);
		ModelAndView mv = new ModelAndView("redirect:/cadastra-usuario");
		mv.addObject("username", usuarioSalvo.getNome());
		return mv;
	}

	// Exibe tela de cadastro de usuario
	@GetMapping("/cadastra-usuario")
	public String exibeCadastroUsuario() {
		return "/recursos/cadastrar-usuario";
	}

	// Exibe tela de listagem de produtos
	@GetMapping("/listar-usuarios")
	public ModelAndView listarUsuarios() {
		List<Usuario> usuarios = usuarioRepository.findAll();
		ModelAndView mv = new ModelAndView("/recursos/listarUsuarios");
		mv.addObject("usuarios", usuarios);
		return mv;
	}

	// Remove recursos
	@GetMapping("/remove-usuario/{id}")
	public String removeUsuario(@PathVariable int id) {
		usuarioRepository.deleteById(id);
		return "redirect:/listar-usuario";

	}

	// retorna tela com detalhes do recursos
	@GetMapping("/detalhe-usuario/{id}")
	public ModelAndView detalheUsuario(@PathVariable int id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		ModelAndView mv = new ModelAndView("/recursos/detalhe-usuarios");
		mv.addObject("usuario", usuario);
		return mv;

	}

}

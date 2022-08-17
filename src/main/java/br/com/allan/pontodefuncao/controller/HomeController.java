package br.com.allan.pontodefuncao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	@GetMapping("/teste")
	public ModelAndView hello() {
		String nome = "Allan";
		ModelAndView mv = new ModelAndView("ola");
		mv.addObject("nome",nome);
		return mv;
	}

}

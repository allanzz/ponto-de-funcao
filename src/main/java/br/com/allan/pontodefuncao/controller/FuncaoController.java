package br.com.allan.pontodefuncao.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.allan.pontodefuncao.classes.Projeto;
import br.com.allan.pontodefuncao.classes.TiposFuncoes.Funcao;
import br.com.allan.pontodefuncao.util.repository.FuncaoRepository;
import br.com.allan.pontodefuncao.util.repository.ProjetoRepository;

@Controller
public class FuncaoController {
	@Autowired
	FuncaoRepository funcaoRep;
	@Autowired
	ProjetoRepository projetoRep;
	@PostMapping("/nova-funcao/{id}")
	public ModelAndView adicionaFuncao(@PathVariable int id,Funcao funcao) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		System.out.println("Entrou nessa função");
		Class<?> classeFuncao = getClass().forName("br.com.allan.pontodefuncao.classes.TiposFuncoes."+funcao.getTipoDeFuncao());		
		Optional<Projeto> projeto = projetoRep.findById(id);
		
		if(projeto.isPresent()) {	
			Funcao novaFuncao = (Funcao) classeFuncao.getDeclaredConstructor().newInstance();	
			novaFuncao.setDer(funcao.getDer());
			novaFuncao.setDescricao(funcao.getDescricao());
			novaFuncao.setId(funcao.getId());
			novaFuncao.setResponsavel(funcao.getResponsavel());
			novaFuncao.setRlr_alr(funcao.getRlr_alr());
			novaFuncao.CalcularComplexidade();
			novaFuncao.calcularPontosDeFuncao();
			projeto.get().adicionarFuncao(novaFuncao);
			novaFuncao.setProjeto(projeto.get());
			System.out.println(novaFuncao.CalcularComplexidade());
			System.out.println(novaFuncao.calcularPontosDeFuncao());
			projetoRep.save(projeto.get());
			String url = "/detalhe-projeto/"+projeto.get().getId();
			ModelAndView mv = new ModelAndView("redirect:"+url);
			mv.addObject("descricao", projeto.get().getDescricao());
			return mv;		
		}else {
			return null;
		}
	}

}

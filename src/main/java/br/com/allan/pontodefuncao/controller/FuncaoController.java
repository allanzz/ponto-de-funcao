package br.com.allan.pontodefuncao.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.allan.pontodefuncao.classes.Deflator;
import br.com.allan.pontodefuncao.classes.Projeto;
import br.com.allan.pontodefuncao.classes.TiposFuncoes.Funcao;
import br.com.allan.pontodefuncao.util.repository.DeflatorRepository;
import br.com.allan.pontodefuncao.util.repository.FuncaoRepository;
import br.com.allan.pontodefuncao.util.repository.ProjetoRepository;

@Controller
public class FuncaoController {
	@Autowired
	FuncaoRepository funcaoRep;
	@Autowired
	ProjetoRepository projetoRep;
	@Autowired
	DeflatorRepository deflatorRep;

	@PostMapping("/nova-funcao/{id}")
	public ModelAndView adicionaFuncao(@PathVariable int id, Funcao funcao)
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException, ClassNotFoundException {
		System.out.println("Entrou na função de nova-função");
		Class<?> classeFuncao = Class.forName("br.com.allan.pontodefuncao.classes.TiposFuncoes." + funcao.getTipoDeFuncao());
		Optional<Projeto> projeto = projetoRep.findById(id);
		Optional<Deflator> deflatorOpt = deflatorRep.findById(funcao.getIdDeflator());
		Deflator deflator = deflatorOpt.isPresent()?deflatorOpt.get():null;
		System.out.println(funcao.getDeflator());

		if (projeto.isPresent()) {
			criaNovaFuncao(funcao,deflator,classeFuncao, projeto);
			projetoRep.save(projeto.get());
			String url = "/detalhe-projeto/" + projeto.get().getId();
			ModelAndView mv = new ModelAndView("redirect:" + url);
			mv.addObject("descricao", projeto.get().getDescricao());
			return mv;
		} else {
			return null;
		}
	}

	//Funçao que passa os parametros de uma função recebida da tela de inclusão para um objeto Ponto de funcção específico
	public Funcao criaNovaFuncao(Funcao funcao,Deflator deflator, Class<?> classeFuncao, Optional<Projeto> projeto)
			throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		Funcao novaFuncao = (Funcao) classeFuncao.getDeclaredConstructor().newInstance();
		novaFuncao.setDer(funcao.getDer());
		novaFuncao.setDescricao(funcao.getDescricao());
		novaFuncao.setId(funcao.getId());
		novaFuncao.setResponsavel(funcao.getResponsavel());
		novaFuncao.setRlr_alr(funcao.getRlr_alr());
		novaFuncao.setTipoDeContagem(projeto.get().getTipoContagem());
		novaFuncao.setDeflator(deflator);
		novaFuncao.calcularComplexidade();
		novaFuncao.calcularPontosDeFuncao();
		projeto.get().adicionarFuncao(novaFuncao);
		novaFuncao.setProjeto(projeto.get());
		return novaFuncao;
	}

}

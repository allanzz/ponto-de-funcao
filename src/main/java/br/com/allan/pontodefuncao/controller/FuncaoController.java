package br.com.allan.pontodefuncao.controller;

import java.lang.reflect.InvocationTargetException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
		Class<?> classeFuncao = Class
				.forName("br.com.allan.pontodefuncao.classes.TiposFuncoes." + funcao.getTipoDeFuncao());
		Optional<Projeto> projeto = projetoRep.findById(id);
		Optional<Deflator> deflatorOpt = deflatorRep.findById(funcao.getIdDeflator());
		Deflator deflator = deflatorOpt.isPresent() ? deflatorOpt.get() : null;
		System.out.println(funcao.getDeflator());

		if (projeto.isPresent()) {
			criaNovaFuncao(funcao, deflator, classeFuncao, projeto);
			projetoRep.save(projeto.get());
			String url = "/detalhe-projeto/" + projeto.get().getId();
			ModelAndView mv = new ModelAndView("redirect:" + url);
			mv.addObject("descricao", projeto.get().getDescricao());
			return mv;
		} else {
			return null;
		}
	}

	@GetMapping("/alterar-funcao/{projeto_id}/{funcao_id}")
	public ModelAndView alteraFuncao(@PathVariable int funcao_id) {
		Optional<Funcao> funcaoOpt = funcaoRep.findById(funcao_id);
		List<Deflator> deflatores = deflatorRep.findAll();
		if (funcaoOpt.isPresent()) {
			ModelAndView mv = new ModelAndView("funcao/detalhe-funcao");
			mv.addObject("funcao", funcaoOpt.get());
			mv.addObject("deflatores", deflatores);
			return mv;
		}
		return null;
	}
	
	@PostMapping("/alterar-funcao/{id}")
	public ModelAndView alterarFuncao(@PathVariable int id, Funcao funcao)
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException, ClassNotFoundException {
		System.out.println("Entrou na função de alterar-função"+funcao.getDataConclusao());
		Optional<Projeto> projetoOpt = projetoRep.findById(id);
		Optional<Deflator> deflatorOpt = deflatorRep.findById(funcao.getIdDeflator());
		Deflator deflator = deflatorOpt.isPresent() ? deflatorOpt.get() : null;	
		

		if (projetoOpt.isPresent()) {
			Projeto projeto = projetoOpt.get();
			int indice = projeto.getFuncoes().indexOf(funcao);
			System.out.println(projeto.getFuncoes().get(0).equals(funcao));
			if(indice>=0) {				
			projeto.getFuncoes().get(indice).setDescricao(funcao.getDescricao());
			projeto.getFuncoes().get(indice).setResponsavel(funcao.getResponsavel());
			projeto.getFuncoes().get(indice).setRlr_alr(funcao.getRlr_alr());
			projeto.getFuncoes().get(indice).setDer(funcao.getDer());
			projeto.getFuncoes().get(indice).setDeflator(deflator);
			boolean ehAlteracao = !projeto.getFuncoes().get(indice).getStatus().equals(funcao.getStatus());
			boolean ehConcluido = funcao.getStatus().equals("Concluido");						
			projeto.getFuncoes().get(indice).setStatus(funcao.getStatus());
			
			System.out.println(ehAlteracao+" "+ehConcluido);
			if(ehAlteracao&&ehConcluido) {
			try {
				Date agora = new SimpleDateFormat("yyyy-MM-dd").parse(LocalDate.now().toString());
				projeto.getFuncoes().get(indice).setDataConclusao(agora);
				System.out.println("Data alterada"+projeto.getFuncoes().get(indice).getDataConclusaoFormatada());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//fim do try...catch				
			}//fim do IF da data
			if(funcao.getStatus().equals("Pendente")) {
				projeto.getFuncoes().get(indice).setDataConclusao(null);
			}
			}//fim do IF fo INDICE
			projetoRep.save(projetoOpt.get());
			String url = "/detalhe-projeto/" + projetoOpt.get().getId();
			ModelAndView mv = new ModelAndView("redirect:" + url);
			mv.addObject("descricao", projetoOpt.get().getDescricao());
			return mv;
		} else {
			return null;
		}
	}
	
	@GetMapping("excluir-funcao/{idProjeto}/{idFuncao}")
	public ModelAndView removerFuncao(@PathVariable int idProjeto,@PathVariable int idFuncao) {
		funcaoRep.deleteById(idFuncao);
		String url = "/detalhe-projeto/" +idProjeto;
		ModelAndView mv = new ModelAndView("redirect:" + url);
		return mv;
	}

	// Funçao que passa os parametros de uma função recebida da tela de inclusão
	// para um objeto Ponto de funcção específico
	public Funcao criaNovaFuncao(Funcao funcao, Deflator deflator, Class<?> classeFuncao, Optional<Projeto> projeto)
			throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		Funcao novaFuncao = (Funcao) classeFuncao.getDeclaredConstructor().newInstance();
		novaFuncao.setDer(funcao.getDer());
		novaFuncao.setDescricao(funcao.getDescricao());
		novaFuncao.setId(funcao.getId());
		novaFuncao.setResponsavel(funcao.getResponsavel());
		novaFuncao.setRlr_alr(funcao.getRlr_alr());
		novaFuncao.setTipoDeContagem(projeto.get().getTipoContagem());
		novaFuncao.setDeflator(deflator);
		novaFuncao.setStatus(funcao.getStatus());
		novaFuncao.calcularComplexidade();
		novaFuncao.calcularPontosDeFuncao();
		projeto.get().adicionarFuncao(novaFuncao);
		novaFuncao.setProjeto(projeto.get());
		novaFuncao.setDataConclusao(funcao.getDataConclusao());
		return novaFuncao;
	}
	@GetMapping("/listagemFuncoes")
	public ModelAndView listarFuncoesConcluidas(){
		List<Funcao> funcoes = new ArrayList<>();
		funcoes = funcaoRep.findByStatus("Concluido");
		for (Funcao funcao : funcoes) {
			System.out.println(funcao.getDataConclusao().toString());
		}
		
		ModelAndView mv = new ModelAndView("/funcao/listarFuncoes");
		mv.addObject("funcoes", funcoes);
		return mv;
	}
	@PostMapping("/listagemFuncoes")
	public ModelAndView listarFuncoesConcluidas(@PathParam(value = "dataIncial") String dataInicial,@PathParam(value = "dataFinal") String dataFinal){
		System.out.println("Entrou aqui na listagem de funcoes"+dataInicial+" "+dataFinal);
		DateFormat df = new SimpleDateFormat("yyyy-MM-d");
		Date inicial=new Date();
		Date fim=new Date();
		try {
			  inicial = df.parse(dataInicial); 
			  fim = df.parse(dataFinal);
			  }catch(Exception
			  e){
				  e.getMessage(); 
				  }
		System.out.println(inicial);
		
		List<Funcao> funcoes = new ArrayList<>();
		if(dataInicial==null&&dataFinal==null) {
		funcoes = funcaoRep.findByDataConclusaoBetween(inicial,fim);
		}else {
		funcoes = funcaoRep.findByStatus("Concluido");
		}
		ModelAndView mv = new ModelAndView("/funcao/listarFuncoes");
		mv.addObject("funcoes", funcoes);
		return mv;
	}

}

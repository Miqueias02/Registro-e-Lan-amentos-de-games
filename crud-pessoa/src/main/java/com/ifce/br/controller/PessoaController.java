package com.ifce.br.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ifce.br.model.Pessoa;
import com.ifce.br.service.PessoaService;

@Controller
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService;
	
	@GetMapping("/olaMundo")
     public String olaMundo() {
    	 return "ola-mundo";
     }

	@GetMapping("/pessoa/formulario")
	public String formulario() { 
		return "formulario";
	}
	
	@GetMapping("/pessoa/salvar")
	public String salvar(Pessoa pessoa) {	
		pessoaService.cadastrarPessoa(pessoa);
		return "sucesso";
		
	}
	
	@GetMapping("/pessoa/listar")
	public ModelAndView listarPessoas() {
		List<Pessoa> pessoas = pessoaService.listarPessoas();
		ModelAndView mv = new ModelAndView("listagem-pessoa");
		
		mv.addObject("listaPessoas", pessoas);
		
		return mv;
		
		
		
	}
}
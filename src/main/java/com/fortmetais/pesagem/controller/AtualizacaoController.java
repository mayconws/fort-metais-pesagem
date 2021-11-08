package com.fortmetais.pesagem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.fortmetais.pesagem.service.AtualizacaoService;

@Controller
@RequestMapping("/atualizacao")
public class AtualizacaoController {
	@Autowired
	private AtualizacaoService atualizacaoService;
	
	@RequestMapping("/clientes")
	public ModelAndView atualizarClientes() {
		return atualizacaoService.atualizarClientes();
	}
	
	@RequestMapping("/produtos")
	public ModelAndView atualizarProdutos() {
		return atualizacaoService.atualizarProdutos();
	}

}

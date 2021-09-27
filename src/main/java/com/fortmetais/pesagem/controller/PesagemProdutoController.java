package com.fortmetais.pesagem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/pesagens/produtos")
public class PesagemProdutoController {
	
	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("pesagem/PesagemProduto");
		return mv;

	}	

}

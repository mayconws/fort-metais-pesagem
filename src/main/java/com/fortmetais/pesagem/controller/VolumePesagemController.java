package com.fortmetais.pesagem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fortmetais.pesagem.model.Pesagem;
import com.fortmetais.pesagem.repository.Produtos;

@Controller
@RequestMapping("/pesagens/produtos")
public class VolumePesagemController {

	private Produtos produtos;
	
	@RequestMapping("/novo")
	public ModelAndView novo(Pesagem pesagem) {
		ModelAndView mv = new ModelAndView("pesagem/VolumePesagem");
		return mv;

	}	

}

package com.fortmetais.pesagem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/pesagens")
public class PesagemController {
	
	@RequestMapping("/nova")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("pesagem/CadastroPesagem");
		return mv;

	}	

}

package com.fortmetais.pesagem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fortmetais.pesagem.model.Pesagem;
import com.fortmetais.pesagem.model.TipoPesagem;
import com.fortmetais.pesagem.repository.Clientes;
import com.fortmetais.pesagem.repository.Produtos;
import com.fortmetais.pesagem.service.PesagemService;

@Controller
@RequestMapping("/pesagens")
public class PesagemController {
	
	@Autowired
	private Clientes clientes;
	
	@Autowired
	private Produtos produtos;
	
	@Autowired
	PesagemService pesagemService;	
	
	@RequestMapping("/nova")
	public ModelAndView novo(Pesagem pesagem) {
		ModelAndView mv = new ModelAndView("pesagem/CadastroPesagem");
		mv.addObject("clientes", clientes.findAll());
		mv.addObject("produtos", produtos.findAll());
		mv.addObject("tipos", TipoPesagem.values());
		return mv;

	}
	
	@PostMapping("/novo")
	public ModelAndView salvar(@Validated Pesagem pesagem, BindingResult result, RedirectAttributes attributes) {
		
		pesagemService.salvar(pesagem);
		
		attributes.addFlashAttribute("mensagem", "Pesagem salva com Sucesso!");
		return new ModelAndView("redirect:/pesagens");
	}

}

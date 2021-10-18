package com.fortmetais.pesagem.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fortmetais.pesagem.model.ItemPesagem;
import com.fortmetais.pesagem.model.Pesagem;
import com.fortmetais.pesagem.repository.ItemPesagens;
import com.fortmetais.pesagem.repository.Pesagens;
import com.fortmetais.pesagem.repository.Produtos;
import com.fortmetais.pesagem.service.ItensPesagemService;
import com.fortmetais.pesagem.service.PesagemService;

@Controller
@RequestMapping("/pesagens/produtos")
public class ItensPesagemController {

	@Autowired
	private Pesagens pesagens;
	
	@Autowired
	private Produtos produtos;

	@Autowired
	private ItemPesagens itemPesagens;

	@Autowired
	private ItensPesagemService itensPesagemService;
	
	@Autowired
	private PesagemService pesagemService;
	
	private List<ItemPesagem> listaDeItensPesagens = new ArrayList<ItemPesagem>();

	@RequestMapping("/novo")
	public ModelAndView novo(Pesagem pesagem, ItemPesagem itemPesagem) {
		ModelAndView mv = new ModelAndView("pesagem/itensPesagem");
		mv.addObject("pesagem", pesagem);
		mv.addObject("produtos", produtos.findAll());
		mv.addObject("itemPesagem", itemPesagem);
		mv.addObject("listaItensPesagens", listaDeItensPesagens);
		return mv;

	}

	@PostMapping("/novo")
	public ModelAndView salvar(@Validated String acao, Pesagem pesagem, ItemPesagem itemPesagem,
			BindingResult result, RedirectAttributes attributes) {
		
		if(acao.equals("itens")) {
			
			listaDeItensPesagens.add(itemPesagem);
			
		} else if(acao.equals("salvar")) {
			
			pesagemService.salvar(pesagem);
						
			for(ItemPesagem itens : listaDeItensPesagens) {
				
				itens.setPesagem(pesagem);
				itens.setPesoLiquido(itens.getPesoLiquidoTotal());	
				itensPesagemService.salvar(itens);			
				listaDeItensPesagens = new ArrayList<>();
				return novo(new Pesagem(), new ItemPesagem());
			}
		}
		
		System.err.println("Quantidade de Itens Adicionados > " + listaDeItensPesagens.size());

		return novo(pesagem, new ItemPesagem());
	}

}

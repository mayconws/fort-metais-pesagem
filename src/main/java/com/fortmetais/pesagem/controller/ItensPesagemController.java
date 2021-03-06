package com.fortmetais.pesagem.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
import com.fortmetais.pesagem.model.Produto;
import com.fortmetais.pesagem.model.VolumePesagem;
import com.fortmetais.pesagem.repository.Produtos;
import com.fortmetais.pesagem.service.PesagemService;

@Controller
@RequestMapping("/pesagens/produtos")
public class ItensPesagemController {

	@Autowired
	private Produtos produtos;

	@Autowired
	private PesagemService pesagemService;

	private List<VolumePesagem> listaDeVolumes = new ArrayList<VolumePesagem>();

	@RequestMapping("/novo")
	public ModelAndView novo(Pesagem pesagem, VolumePesagem volumePesagem) {
		ModelAndView mv = new ModelAndView("pesagem/itensPesagem");
		mv.addObject("pesagem", pesagem);
		mv.addObject("conteudo", volumePesagem);
		mv.addObject("produtos", produtos.findAll());
		mv.addObject("listaVolumes", listaDeVolumes);
		
		return mv;
	}

	@PostMapping("/novo")
	public ModelAndView salvar(@Validated String acao, Pesagem pesagem, VolumePesagem volumePesagem,
			BindingResult result, RedirectAttributes attributes) {	

		if (acao.equals("itens")) {

			listaDeVolumes.add(volumePesagem);

		} else if (acao.equals("salvar")) {			

			ItemPesagem itens = new ItemPesagem();
			Produto produto = new Produto();
					
			itens.setPesoBruto(BigDecimal.ZERO);
			itens.setPesoTara(BigDecimal.ZERO);
			itens.setPesoLiquido(BigDecimal.ZERO);			
			
			Optional<Produto> prod = produtos.findByNome(listaDeVolumes.get(0).getProdutoTemporario());
			produto = prod.get();			
			
			itens.setProduto(produto);

			for (VolumePesagem volumes : listaDeVolumes) {
				
				volumes.setItemPesagem(itens);			
				volumes.setPesoLiquido(volumes.getPesoLiquidoTotal());		
				itens.getVolumesPesagem().add(volumes);				
				
				itens.setPesoBruto(itens.getPesoBruto().add(volumes.getPesoBruto()));
				itens.setPesoTara(itens.getPesoTara().add(volumes.getPesoTara()));
				itens.setPesoLiquido(itens.getPesoLiquido().add(volumes.getPesoLiquido()));			
			}	
			
			System.out.println("Total Liquido: ");
			pesagem.getItensPesagem().add(itens);
			pesagemService.salvar(pesagem);				
			listaDeVolumes = new ArrayList<>();
			return novo(new Pesagem(), new VolumePesagem());
		}

		System.err.println("Quantidade de Itens Adicionados > " + listaDeVolumes.size());		

		return novo(new Pesagem(), new VolumePesagem());
	}

}
package com.fortmetais.pesagem.controller;

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
import com.fortmetais.pesagem.model.VolumePesagem;
import com.fortmetais.pesagem.repository.ItemPesagens;
import com.fortmetais.pesagem.repository.Pesagens;
import com.fortmetais.pesagem.repository.Produtos;
import com.fortmetais.pesagem.repository.VolumePesagens;
import com.fortmetais.pesagem.service.ItensPesagemService;
import com.fortmetais.pesagem.service.PesagemService;
import com.fortmetais.pesagem.service.VolumePegemService;

@Controller
@RequestMapping("/pesagens/produtos")
public class ItensPesagemController {

	@Autowired
	private Produtos produtos;

	@Autowired
	private PesagemService pesagemService;

	@Autowired
	private VolumePegemService volumePegemService;

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

			pesagemService.salvar(pesagem);

			ItemPesagem itens = new ItemPesagem();

			for (VolumePesagem volumes : listaDeVolumes) {

				itens.setPesagem(pesagem);
				volumes.setPesoLiquido(volumes.getPesoLiquidoTotal());
				volumePegemService.salvar(volumes);
				listaDeVolumes = new ArrayList<>();
			}
			return novo(new Pesagem(), new VolumePesagem());
		}

		System.err.println("Quantidade de Itens Adicionados > " + listaDeVolumes.size());

		return novo(new Pesagem(), new VolumePesagem());
	}

}
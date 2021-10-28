package com.fortmetais.pesagem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InicioController {

	@RequestMapping("/")
	public String inicio() {
		return "index";
	}
	
}

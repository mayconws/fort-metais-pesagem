package com.fortmetais.pesagem.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.fortmetais.pesagem.model.Produto;

@Component
public class ProdutoConverterObjectToString implements Converter<Produto, String> {
	
	@Override
	public String convert(Produto produto) {
		return produto.getNome();
	}
}

package com.fortmetais.pesagem.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.fortmetais.pesagem.model.Cliente;

@Component
public class ClienteConverterObjectToString implements Converter<Cliente, String> {
	
	@Override
	public String convert(Cliente cliente) {
		return cliente.getNome();
	}
}

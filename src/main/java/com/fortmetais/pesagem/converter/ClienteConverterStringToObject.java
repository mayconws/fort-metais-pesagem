package com.fortmetais.pesagem.converter;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.fortmetais.pesagem.model.Cliente;
import com.fortmetais.pesagem.repository.Clientes;

@Component
public class ClienteConverterStringToObject implements Converter<String, Cliente> {
	
	@Autowired
	private Clientes clientes;
	
	@Override
	public Cliente convert(String text) {
		if (text.isEmpty()) {
			return null;
		}		
		
		Optional<Cliente> clienteOptional = clientes.findByNome(text);
		return clienteOptional.get();
	}
}

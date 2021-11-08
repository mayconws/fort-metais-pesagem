package com.fortmetais.pesagem.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.fortmetais.pesagem.model.Cliente;
import com.fortmetais.pesagem.model.Produto;
import com.fortmetais.pesagem.repository.Clientes;
import com.fortmetais.pesagem.repository.Produtos;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

@Service
public class AtualizacaoService {
	@Autowired
	private Clientes clientes;
	
	@Autowired
	private Produtos produtos;
	
	public ModelAndView atualizarClientes() {
		try {
			List<Cliente> listaClientes = clientes.findLastId();
		    Long codUltimoCliente = 0L;
			
			if (!listaClientes.isEmpty()) {
				codUltimoCliente = listaClientes.get(0).getId();
			}
			
	        System.out.println("http://infomaniasistemas.ddns.net:8080/fortmetais/ws/clientes/list/" + codUltimoCliente);
			
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("http://infomaniasistemas.ddns.net:8080/fortmetais/ws/clientes/list/" + codUltimoCliente)
                    .method("GET", null)
                    .build();

            Response response = client.newCall(request).execute();
            String json = response.body().string();
            
            if (!json.equals("[]")) {
            	salvarCliente(json);
            }

        } catch (IOException e) {
            System.out.println(e);
        }
		
		return new ModelAndView("redirect:/");
	}
	
	private void salvarCliente(String json) {      
        json = json.replace("[", "").replace("]", "");
        String[] jsonSplit = json.split("},");
        
        int contador = 1;
        
        for (String s : jsonSplit) {
            if (contador != jsonSplit.length) {
                s += "}";
            }
            
            Gson g = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
            Cliente cliente = g.fromJson(s, Cliente.class);
            clientes.save(cliente);
            contador++;
        }
    }
	
	public ModelAndView atualizarProdutos() {
		try {
			List<Produto> listaProdutos = produtos.findLastId();
		    Long codUltimoProduto = 0L;
			
			if (!listaProdutos.isEmpty()) {
				codUltimoProduto = listaProdutos.get(0).getId();
			}
			
	        System.out.println("http://infomaniasistemas.ddns.net:8080/fortmetais/ws/produtos/list/" + codUltimoProduto);
			
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("http://infomaniasistemas.ddns.net:8080/fortmetais/ws/produtos/list/" + codUltimoProduto)
                    .method("GET", null)
                    .build();

            Response response = client.newCall(request).execute();
            String json = response.body().string();
            
            if (!json.equals("[]")) {
            	salvarProduto(json);
            }

        } catch (IOException e) {
            System.out.println(e);
        }
		
		return new ModelAndView("redirect:/");
	}
	
	private void salvarProduto(String json) {      
        json = json.replace("[", "").replace("]", "");
        String[] jsonSplit = json.split("},");
        
        int contador = 1;
        
        for (String s : jsonSplit) {
            if (contador != jsonSplit.length) {
                s += "}";
            }
            
            Gson g = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
            Produto produto = g.fromJson(s, Produto.class);
            produtos.save(produto);
            contador++;
        }
    }
}

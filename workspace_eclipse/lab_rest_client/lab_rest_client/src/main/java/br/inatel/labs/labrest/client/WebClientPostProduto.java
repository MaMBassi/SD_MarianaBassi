package br.inatel.labs.labrest.client;

import java.math.BigDecimal;

import org.springframework.web.reactive.function.client.WebClient;

import br.inatel.labs.labrest.client.model.dto.ProdutoDTO;

public class WebClientPostProduto {

	public static void main(String[] args) {
		ProdutoDTO novoProduto = new ProdutoDTO();
		novoProduto.setDescricao("Martelo");
		novoProduto.setPreco(new BigDecimal(25.00));
		
		ProdutoDTO produtoCriado = WebClient.create("http://localhost:8080")
				.post()
				.uri("/produto")
				.bodyValue(novoProduto)
				.retrieve()
				.bodyToMono(ProdutoDTO.class)
				.block();
		
		System.out.println("Produto criado");
		System.out.println(produtoCriado);
	}
		
	
}

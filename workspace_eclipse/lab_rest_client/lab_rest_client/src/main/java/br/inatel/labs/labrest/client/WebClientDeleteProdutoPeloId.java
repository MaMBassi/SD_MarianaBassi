package br.inatel.labs.labrest.client;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;

public class WebClientDeleteProdutoPeloId {

	public static void main(String[] args) {
		ResponseEntity<Void> responseEntity = WebClient.create("http://localhost:8080")
				.put()
				.uri("/produto/3")
				.retrieve()
				.toBodilessEntity()
				.block();
		
		HttpStatusCode statusCode = responseEntity.getStatusCode();		
		System.out.println("Produto removido");
		System.out.println("Status da resposta: " + statusCode);

	}

}

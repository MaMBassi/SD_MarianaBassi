package br.inatel.labs.labrest.server.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.inatel.labs.labrest.server.model.Produto;
import br.inatel.labs.labrest.server.service.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoService service;
	
	@GetMapping
	public List<Produto> getProdutos(){
		return service.findAll();
	}

	@GetMapping("/{id}")
	public Produto getProdutosById(@PathVariable("id") Long produtoId){
		Optional<Produto> opProduto = service.findById(produtoId);
		
		if(opProduto.isEmpty()) {
			String msg = String.format("Nenhum produto encontrado com id [%s]", produtoId);
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,msg);
			
		}
		
		//if(opProduto.isPresent()) {
			//return opProduto.get();			
		//}		
		
			return opProduto.get();
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Produto postProduto(@RequestBody Produto p) {
		Produto produtoCriado = service.create(p);
		return produtoCriado;
	}
	
	@PutMapping
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void putProduto(@RequestBody Produto p) {
		service.update(p);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteProduto(@PathVariable("id") Long produtoId) {
		Produto produtoEncontrado = this.getProdutosById(produtoId);
		service.remove(produtoEncontrado);
	}
	
	
}

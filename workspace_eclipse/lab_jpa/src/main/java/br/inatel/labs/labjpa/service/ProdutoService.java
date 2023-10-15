package br.inatel.labs.labjpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.Transactional;

import br.inatel.labs.labjpa.entity.Produto;
import br.inatel.labs.labjpa.repository.ProdutoRepository;

@Service
@Transactional
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;
  
  public Produto salvar(Produto p) {
    return repository.save( p );
  }

  public Optional<Produto> buscarPeloId(Long id) {
    return repository.findById(id);
  }

  public List<Produto> listar() {
    return repository.findAll();
  }

  public void remover(Produto p) {
    repository.delete(p);
  }

}

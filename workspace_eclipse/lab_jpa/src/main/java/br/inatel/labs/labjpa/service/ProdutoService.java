package br.inatel.labs.labjpa.service;

import java.util.List;

import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.Transactional;

import br.inatel.labs.labjpa.entity.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


@Service
@Transactional
public class ProdutoService {

  @PersistenceContext
  private EntityManager em;

  public Produto salvar(Produto p) {
    p = em.merge( p );
    return p;
  }

  public Produto buscarPeloId(Long id) {
    Produto produto = em.find(Produto.class, id);
    return produto;
  }

  public List<Produto> listar() {
    List<Produto> listaProduto = em.createQuery("select p from Produto p", Produto.class)
      .getResultList();
    return listaProduto;
  }

  public void remover(Produto p) {
    p = em.merge( p );
    em.remove( p );
  }

}

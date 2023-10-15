package br.inatel.labs.labjpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.inatel.labs.labjpa.dto.TotalCompradoPorFornecedorDTO;
import br.inatel.labs.labjpa.repository.RelatorioRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class RelatorioService {
	@Autowired
	private RelatorioRepository relatorioRepository;
	
	public List<TotalCompradoPorFornecedorDTO> pesquisarTotalCompradoPorFornecedor(){

		return relatorioRepository.pesquisarTotalCompradoPorFornecedor();
	}
}

package br.inatel.labs.labjpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.inatel.labs.labjpa.entity.Endereco;
import br.inatel.labs.labjpa.service.EnderecoService;

@SpringBootTest
public class EnderecoTest {
	
	@Autowired
	private EnderecoService service;
	
	@Test
	public void testarUIIDGeradoJPAListener(){
		Endereco endereco = new Endereco();
		endereco.setRua("Moreira");
		endereco.setNumero("100");
		endereco.setCidade("Sao Joao da Boa Vista");
		endereco.setUf("SP");
		
		endereco = service.salvar(endereco);
		System.out.println(endereco);
	}

}

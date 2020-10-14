package br.com.transacao.repository;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;

import br.com.transacao.model.Ordem;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class OrdemRepositoryTest {

	@InjectMocks
	OrdemRepository ordemRepository;

	/**
	 * Metodo responsável por testar a lista de ordens
	 */
	@Test
	public void testarListarOrdem() {

		Ordem primeiraOrdem = new Ordem();
		Ordem segundaOrdem = new Ordem();

		List<Ordem> ordens = new ArrayList<Ordem>();

		ordens.add(primeiraOrdem);
		ordens.add(segundaOrdem);

		Mockito.when(ordemRepository.listAll()).thenReturn(ordens);

		Assertions.assertSame(segundaOrdem, ordemRepository.listAll().get(1));
	}

}

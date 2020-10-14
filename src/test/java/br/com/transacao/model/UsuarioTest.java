package br.com.transacao.model;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.panache.mock.PanacheMock;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class UsuarioTest {

	/**
	 * Metodo responsável por testar uma pesquisa de usuario por ID.
	 */
	@Test
	public void testarFindByIdOptionalUsuario() {

		PanacheMock.mock(Usuario.class);

		Usuario u = new Usuario();
		Optional<PanacheEntityBase> usuario = Optional.of(u);

		Mockito.when(Usuario.findByIdOptional(40)).thenReturn(usuario);

		Assertions.assertSame(u, Usuario.findByIdOptional(40).get());

	}
}

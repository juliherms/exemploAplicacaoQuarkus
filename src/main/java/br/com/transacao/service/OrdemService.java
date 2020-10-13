package br.com.transacao.service;

import java.time.LocalDate;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.SecurityContext;

import br.com.transacao.model.Ordem;
import br.com.transacao.model.Usuario;
import br.com.transacao.repository.OrdemRepository;

@ApplicationScoped
public class OrdemService {

	@Inject
	OrdemRepository ordemRepository;

	public void inserir(SecurityContext context, Ordem ordem) {

		Optional<Usuario> optionalUsuario = Usuario.findByIdOptional(ordem.getUserId());
		Usuario usuario = optionalUsuario.orElseThrow();
		
		if(!usuario.getUsername().equals(context.getUserPrincipal().getName())) {
			throw new RuntimeException("O usuário logado é diferente do userId");
		}

		ordem.setData(LocalDate.now());
		ordem.setStatus("ENVIADA");

		ordemRepository.persist(ordem);
	}
}

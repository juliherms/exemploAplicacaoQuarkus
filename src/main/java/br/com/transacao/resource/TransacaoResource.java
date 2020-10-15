package br.com.transacao.resource;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.transacao.model.Ordem;
import br.com.transacao.model.Transacao;
import br.com.transacao.service.TransacaoService;

/**
 * Classe responsável por representar um endpoint de Transacoes
 * 
 * @author jlv
 *
 */
@Path("/transacoes")
public class TransacaoResource {

	@Inject
	TransacaoService transacaoService;

	/**
	 * Metodo responsável por inserir uma ordem
	 * 
	 * @param ordem
	 */
	@POST
	@Transactional
	@Consumes(MediaType.APPLICATION_JSON)
	public void inserir(Transacao transacao) {

		transacaoService.save(transacao);

	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Ordem> listar() {
		
		return transacaoService.listar();
	}

}

package br.com.transacao.resource;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

import br.com.transacao.model.Ordem;
import br.com.transacao.service.OrdemService;

/**
 * Classe responsável por representar um endpoint de Ordens
 * 
 * @author jlv
 *
 */
@Path("/ordens")
public class OrdemResource {

	@Inject
	OrdemService ordemService;

	/**
	 * Metodo responsável por inserir uma ordem
	 * 
	 * @param ordem
	 */
	@POST
	@Transactional
	@RolesAllowed("user")
	@Consumes(MediaType.APPLICATION_JSON)
	public void inserir(@Context SecurityContext securityContext, Ordem ordem) {

		ordemService.inserir(securityContext, ordem);

	}
}

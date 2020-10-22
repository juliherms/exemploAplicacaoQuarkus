package br.com.transacao.resource;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.SimplyTimed;
import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import br.com.transacao.model.Categoria;
import br.com.transacao.model.Transacao;
import br.com.transacao.service.CategoriaService;
import br.com.transacao.service.TransacaoService;

/**
 * Classe responsável por representar um endpoint de Transacoes
 * 
 * @author jlv
 *
 */
@Path("/transacoes")
@Tag(name = "transacoes")
public class TransacaoResource {

	@Inject
	TransacaoService transacaoService;

	@Inject
	@RestClient
	CategoriaService categoriaService;

	/**
	 * Metodo responsavel por listar todos as categorias
	 * 
	 * @return
	 */
	@GET
	@Path("categorias")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Categoria> listarTodos() {
		return categoriaService.listar();
	}

	/**
	 * Metodo responsável por inserir uma transacao
	 * 
	 * @param ordem
	 */
	@POST
	@Transactional
	@Consumes(MediaType.APPLICATION_JSON)
	@APIResponse(responseCode = "201", description = "Caso a transacao seja processada com sucesso")
	public Response inserir(Transacao transacao) {

		transacaoService.save(transacao);
		return Response.status(Status.CREATED).build();

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Counted(name = "Quantidade de listagem de transacoes")
	@SimplyTimed(name = "Tempo simples da busca de listagem de transacaoes")
	@Timed(name = "Tempo completo de listagem de transacoes")
	public List<Transacao> listar() {

		return transacaoService.listar();
	}

}
